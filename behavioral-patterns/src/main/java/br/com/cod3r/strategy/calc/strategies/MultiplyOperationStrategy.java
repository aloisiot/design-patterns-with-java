package br.com.cod3r.strategy.calc.strategies;

public class MultiplyOperationStrategy implements OperationStrategy {
    @Override
    public int calculate(int x, int y) {
        return x * y;
    }
}
