package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReajusteServiceTest {

    @Test
    void reajusteDeveriaSerDeTresPorcentoQuandoDesempenhoForADesejar() {
        ReajusteService reajusteService = new ReajusteService();
        Funcionario funcionario = new Funcionario("Alexandre", LocalDate.now(), new BigDecimal("10000.00"));

        reajusteService.concederReajuste(funcionario, Desempenho.A_DESEJAR);

        assertEquals(new BigDecimal("10300.00"), funcionario.getSalario());
    }

    @Test
    void reajusteDeveriaSerDe15PorcentoQuandoDesempenhoForBom() {
        ReajusteService reajusteService = new ReajusteService();
        Funcionario funcionario = new Funcionario("Alexandre", LocalDate.now(), new BigDecimal("10000.00"));

        reajusteService.concederReajuste(funcionario, Desempenho.BOM);

        assertEquals(new BigDecimal("11500.00"), funcionario.getSalario());
    }

    @Test
    void reajusteDeveriaSerDe20PorcentoQuandoDesempenhoForExcelente() {
        ReajusteService reajusteService = new ReajusteService();
        Funcionario funcionario = new Funcionario("Alexandre", LocalDate.now(), new BigDecimal("10000.00"));

        reajusteService.concederReajuste(funcionario, Desempenho.EXCELENTE);

        assertEquals(new BigDecimal("12000.00"), funcionario.getSalario());
    }


}
