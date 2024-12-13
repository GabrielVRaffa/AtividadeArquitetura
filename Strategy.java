interface EstrategiaFrete {
    double calcularCusto(double peso, double distancia);
}

class FreteTerrestre implements EstrategiaFrete {
    @Override
    public double calcularCusto(double peso, double distancia) {
        return (peso * 0.05) + (distancia * 0.1);
    }
}

class FreteAereo implements EstrategiaFrete {
    @Override
    public double calcularCusto(double peso, double distancia) {
        return (peso * 0.2) + (distancia * 0.5);
    }
}

class FreteMaritimo implements EstrategiaFrete {
    @Override
    public double calcularCusto(double peso, double distancia) {
        return (peso * 0.03) + (distancia * 0.05);
    }
}

class CalculadoraFrete {
    private EstrategiaFrete estrategia;

    public CalculadoraFrete(EstrategiaFrete estrategia) {
        this.estrategia = estrategia;
    }

    public void setEstrategia(EstrategiaFrete estrategia) {
        this.estrategia = estrategia;
    }

    public double calcular(double peso, double distancia) {
        return estrategia.calcularCusto(peso, distancia);
    }
}

public class Strategy {
    public static void main(String[] args) {
        double peso = 10.0;
        double distancia = 100.0;

        CalculadoraFrete calculadora = new CalculadoraFrete(new FreteTerrestre());
        System.out.printf("Custo do Frete Terrestre: R$ %.2f%n", calculadora.calcular(peso, distancia));

        calculadora.setEstrategia(new FreteAereo());
        System.out.printf("Custo do Frete Aereo: R$ %.2f%n", calculadora.calcular(peso, distancia));

        calculadora.setEstrategia(new FreteMaritimo());
        System.out.printf("Custo do Frete Maritimo: R$ %.2f%n", calculadora.calcular(peso, distancia));
    }
}
