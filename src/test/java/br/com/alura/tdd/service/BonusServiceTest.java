package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BonusServiceTest {

    @Test
    void givenCalcularBonus_whenSalarioIsHigh_thenItShouldReturnZero() {
        BonusService bonusService = new BonusService();
        Funcionario funcionario = new Funcionario("Alexandre", LocalDate.now(), new BigDecimal("20000"));
        BigDecimal bonus = bonusService.calcularBonus(funcionario);

        assertEquals(new BigDecimal("0.00"), bonus);
    }

    @Test
    void givenCalcularBonus_whenSalarioIsLow_thenItShouldReturn10Percent() {
        BonusService bonusService = new BonusService();
        Funcionario funcionario = new Funcionario("Alexandre", LocalDate.now(), new BigDecimal("5000"));
        BigDecimal bonus = bonusService.calcularBonus(funcionario);

        assertEquals(new BigDecimal("500.00"), bonus);
    }

    @Test
    void givenCalcularBonus_whenSalarioIsExactly10000_thenItShouldReturn10Percent() {
        BonusService bonusService = new BonusService();
        Funcionario funcionario = new Funcionario("Alexandre", LocalDate.now(), new BigDecimal("10000"));
        BigDecimal bonus = bonusService.calcularBonus(funcionario);

        assertEquals(new BigDecimal("1000.00"), bonus);
    }

}