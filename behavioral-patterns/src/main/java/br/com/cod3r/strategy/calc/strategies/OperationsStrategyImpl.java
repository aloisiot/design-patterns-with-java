package br.com.cod3r.strategy.calc.strategies;

public class OperationsStrategyImpl {
    public static final OperationStrategy pow = (int x, int y ) -> (int) Math.pow(x, y);
    public static final OperationStrategy sub = (int x, int y ) -> x - y;
    public static final OperationStrategy multi = (int x, int y ) -> x * y;
    public static final OperationStrategy div = (int x, int y ) -> x / y;
}
