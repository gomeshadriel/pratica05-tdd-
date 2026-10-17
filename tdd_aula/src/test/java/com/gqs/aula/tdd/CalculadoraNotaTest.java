package com.gqs.aula.tdd;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CalculadoraNotaTest {

    CalculadoraNota calc = new CalculadoraNota();

    @Test
    void deveSomarAsTresNotas() {
        double resultado = calc.calcularNotaFinal(20, 20, 30);
        assertEquals(70, resultado);
    }

    @Test
    void deveSomarOutrasNotas() {
        double resultado = calc.calcularNotaFinal(10, 15, 25);
        assertEquals(50, resultado);
    }

    @Test
        void deveAprovarComNota70() {
        assertTrue(calc.estaAprovadoPorNota(70));
    }

    @Test
        void deveReprovarComNota69() {
        assertFalse(calc.estaAprovadoPorNota(69));
    }

    @Test
    void deveRejeitarA1MaiorQue30() {
        assertThrows(IllegalArgumentException.class,
        () -> calc.calcularNotaFinal(35, 20, 30));

    }

    @Test
    void deveRejeitarA2MaiorQue30() {
        assertThrows(IllegalArgumentException.class,
            () -> calc.calcularNotaFinal(20, 35, 30));
    }

    @Test
    void deveRejeitarA3MaiorQue40() {
        assertThrows(IllegalArgumentException.class,
            () -> calc.calcularNotaFinal(20, 20, 41));
    }

    @Test
    void deveRejeitarA1Negativa() {
        assertThrows(IllegalArgumentException.class,
            () -> calc.calcularNotaFinal(-1, 20, 30));
    }
    
    @Test
    void deveAceitarNotasMaximas() {
        assertDoesNotThrow(
            () -> calc.calcularNotaFinal(30, 30, 40));
    }

    @Test
    void deveAprovarComNotaEFrequenciaSuficientes() {
        assertEquals("APROVADO", calc.calcular(80, 90));
    }

    @Test
    void deveReprovarComNotaBaixa() {
        assertEquals("REPROVADO", calc.calcular(60, 90));
    }

    @Test
    void deveReprovarPorFrequenciaMesmoComNotaAlta() {
        assertEquals("REPROVADO", calc.calcular(95, 74));
    }

    @Test
    void deveAprovarComFrequenciaExatamente75() {
        assertEquals("APROVADO", calc.calcular(70, 75));
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