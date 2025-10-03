package src;

import java.util.ArrayList;
import java.util.List;

public class SimulacaoTeste {
    private static final int NUMERO_SIMULACOES = 1000;
    private static final int NUMERO_CLIENTES = 100;
    private static final double MEDIA = 5.0;

    public static void rodarExperimentos() {
        System.out.println("==== EXPERIMENTO BASE ====");
        executarTeste(1, MEDIA, 0.5);

        System.out.println("\n==== VARIAÇÃO: NÚMERO DE CAIXAS ====");
        executarTeste(1, MEDIA, 0.5);
        executarTeste(2, MEDIA, 0.5);
        executarTeste(3, MEDIA, 0.5);

        System.out.println("\n==== VARIAÇÃO: DESVIO-PADRÃO ====");
        executarTeste(1, MEDIA, 0.25);
        executarTeste(1, MEDIA, 1.0);
        executarTeste(1, MEDIA, 2.0);
    }

    private static void executarTeste(int caixas, double mu, double sigma) {
        List<Double> mediasAtendimento = new ArrayList<>();
        SimulacaoCaixaSupermercado simulador;

        for (int i = 0; i < NUMERO_SIMULACOES; i++) {
            simulador = new SimulacaoCaixaSupermercado(caixas, NUMERO_CLIENTES, mu, sigma);
            mediasAtendimento.add(simulador.simular());
        }

        double media = Calculo.media(mediasAtendimento);
        double dp = Calculo.desvioPadrao(mediasAtendimento, media);

        System.out.printf("Caixas: %d | µ = %.2f | σ = %.2f -> Média: %.3f min | DP: %.3f min%n",
                caixas, mu, sigma, media, dp);
    }
}
