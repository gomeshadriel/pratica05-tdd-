package com.gqs.aula.tdd;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CalculadoraNotaTest {

    CalculadoraNota calc = new CalculadoraNota();

    // Testes para o método situacao

    @Test
    void deveAprovarComNotaEFrequenciaSuficientes() {
        assertEquals(CalculadoraNota.APROVADO, calc.situacao(80, 90));
    }

    @Test
    void deveReprovarPorNota() {
        assertEquals(CalculadoraNota.REPROVADO_POR_NOTA, calc.situacao(60, 90));
    }

    @Test
    void deveReprovarPorFaltaMesmoComNotaAlta() {
        assertEquals(CalculadoraNota.REPROVADO_POR_FALTA, calc.situacao(95, 74));
    }

    @Test
    void deveReprovarPorFaltaComNotaEFrequenciaBaixa() {
        assertEquals(CalculadoraNota.REPROVADO_POR_FALTA, calc.situacao(50, 60));
    }


    @Test
    void testePodeFazerAI_Caso1() {
        assertTrue(calc.podeFazerAI(10, 20, 30, 80)); // Nota 60; A2 + A3 = 50
    }

    @Test
    void testePodeFazerAI_Caso2() {
        assertTrue(calc.podeFazerAI(10, 5, 30, 80)); // A1 + A3 = exatamente 40 (limite)
    }

    @Test
    void testePodeFazerAI_Caso3() {
        assertFalse(calc.podeFazerAI(25, 25, 30, 80)); // Nota 80: já foi aprovado
    }

    @Test
    void testePodeFazerAI_Caso4() {
        assertFalse(calc.podeFazerAI(10, 20, 30, 70)); // Frequência abaixo de 75
    }

    @Test
    void testePodeFazerAI_Caso5() {
        assertFalse(calc.podeFazerAI(5, 5, 30, 80)); // A1 + A3 = 35 e A2 + A3 = 35
    }


    @Test
    void substituiA1() {
        double resultado = calc.aplicarAI(10, 20, 30, 25);
        assertEquals(25 + 20 + 30, resultado);
    }

    @Test
    void substituiA2() {
        double resultado = calc.aplicarAI(20, 10, 30, 25);
        assertEquals(20 + 25 + 30, resultado);
    }

    @Test
    void aiBaixaNaoSubstitui() {
        double resultado = calc.aplicarAI(10, 20, 30, 5);
        assertEquals(10 + 20 + 30, resultado);
    }

    @Test
    void aiInvalidaLancaExcecao() {
        assertThrows(IllegalArgumentException.class, () -> {
            calc.aplicarAI(10, 20, 30, 35);
        });
    }
}
