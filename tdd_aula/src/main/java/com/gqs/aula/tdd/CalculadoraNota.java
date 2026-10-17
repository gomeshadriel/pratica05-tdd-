package com.gqs.aula.tdd;

public class CalculadoraNota {

    public static final double NOTA_MAXIMA_A1 = 30;
    public static final double NOTA_MAXIMA_A2 = 30;
    public static final double NOTA_MAXIMA_A3 = 40;

    public double calcularNotaFinal(double a1, double a2, double a3) {
        
        validarNota(a1, 30, "A1");
        validarNota(a2, 30, "A2");
        validarNota(a3, 40, "A3");

        return a1 + a2 + a3;
    }

    private void validarNota(double nota, double notaMaxima, String nomeAvaliacao) {
        if (nota < 0 || nota > notaMaxima) {
            throw new IllegalArgumentException(
            nomeAvaliacao + " deve estar entre 0 e " + notaMaxima);

        }
    }

    public static final double NOTA_MINIMA_APROVACAO = 70;

    public boolean estaAprovadoPorNota(double notaFinal) {

        return notaFinal >= NOTA_MINIMA_APROVACAO;
        
    }

    public static final int FREQUENCIA_MINIMA = 75;

    public String calcular(int notaFinal, int frequencia) {
        if (notaFinal >= 70 && frequencia >= FREQUENCIA_MINIMA) {
            return "APROVADO";
        } else {
            return "REPROVADO";
        }
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




