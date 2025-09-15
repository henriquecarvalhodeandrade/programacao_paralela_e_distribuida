package src;

import java.util.Random;

public class SimulacaoCaixaSupermercado {
    private int numeroCaixas;
    private int numeroClientes;
    private double mediaTempoAtendimentoPorCliente;
    private double desvioPadraoTempoAtendimentoPorCliente;

    private static final double TEMPO_MINIMO_ATENDIMENTO = 0.1;
    private final Random rng = new Random();

    public SimulacaoCaixaSupermercado(int numeroCaixas, int numeroClientes,
                                      double mediaTempoAtendimentoPorCliente,
                                      double desvioPadraoTempoAtendimentoPorCliente) {
        this.numeroCaixas = numeroCaixas;
        this.numeroClientes = numeroClientes;
        this.mediaTempoAtendimentoPorCliente = mediaTempoAtendimentoPorCliente;
        this.desvioPadraoTempoAtendimentoPorCliente = desvioPadraoTempoAtendimentoPorCliente;
    }

    private double tempoAtendimentoNormalTruncado() {
        double z = rng.nextGaussian();
        double s = mediaTempoAtendimentoPorCliente + desvioPadraoTempoAtendimentoPorCliente * z;
        return (s < TEMPO_MINIMO_ATENDIMENTO) ? TEMPO_MINIMO_ATENDIMENTO : s;
    }

    public double simular() {
        double soma = 0.0;
        for (int i = 0; i < numeroClientes; i++) {
            soma += tempoAtendimentoNormalTruncado();
        }
        // divide pelos caixas → simulando processamento paralelo
        return (soma / numeroClientes) / numeroCaixas;
    }
}
