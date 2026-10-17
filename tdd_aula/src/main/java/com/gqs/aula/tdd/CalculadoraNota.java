package com.gqs.aula.tdd;

public class CalculadoraNota {

    public static final int FREQUENCIA_MINIMA = 75;

    public static final String APROVADO = "APROVADO";
    public static final String REPROVADO_POR_FALTA = "REPROVADO POR FALTA";
    public static final String REPROVADO_POR_NOTA = "REPROVADO POR NOTA";

    public String situacao(int nota, int frequencia) {
        if (frequencia < FREQUENCIA_MINIMA) {
            return REPROVADO_POR_FALTA;
        }
        if (nota >= 70) {
            return APROVADO;
        }
        return REPROVADO_POR_NOTA;
    }

    public boolean podeFazerAI(double a1, double a2, double a3, double frequencia) {
        double notaFinal = a1 + a2 + a3;

        if (notaFinal >= 70) {
            return false; 
        }

        if (frequencia < FREQUENCIA_MINIMA) {
            return false; 
        }

        boolean condicao1 = (a1 + a3) >= 40;
        boolean condicao2 = (a2 + a3) >= 40;

        return condicao1 || condicao2;
    }

    public double aplicarAI(double a1, double a2, double a3, double notaAI) {
        if (notaAI < 0 || notaAI > 30) {
            throw new IllegalArgumentException("Nota da AI deve estar entre 0 e 30.");
        }

        double menor = Math.min(a1, a2);

        if (notaAI > menor) {
            if (menor == a1) {
                a1 = notaAI;
            } else {
                a2 = notaAI;
            }
        }

        return a1 + a2 + a3;
    }
}
