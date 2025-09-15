package src;

import java.util.List;

public class Calculo {
    public static double media(List<Double> valores) {
        double soma = 0.0;
        for (double v : valores) soma += v;
        return soma / valores.size();
    }

    public static double desvioPadrao(List<Double> valores, double media) {
        double soma = 0.0;
        for (double v : valores) {
            double d = v - media;
            soma += d * d;
        }
        return Math.sqrt(soma / (valores.size() - 1));
    }
}
