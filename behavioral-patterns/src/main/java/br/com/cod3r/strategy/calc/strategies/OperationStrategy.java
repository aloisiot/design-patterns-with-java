package br.com.cod3r.strategy.calc.strategies;

@FunctionalInterface
public interface OperationStrategy {
    int calculate(int x, int y);
}
