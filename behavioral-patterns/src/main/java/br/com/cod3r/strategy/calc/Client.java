package br.com.cod3r.strategy.calc;

import br.com.cod3r.strategy.calc.strategies.MultiplyOperationStrategy;
import br.com.cod3r.strategy.calc.strategies.OperationsStrategyImpl;

public class Client {

	public static void main(String[] args) {
		Calculator calc = new Calculator(10, 2);
		System.out.println(calc.getResult(Integer::sum));
		System.out.println(calc.getResult((int x, int y) -> x - y));
		System.out.println(calc.getResult(OperationsStrategyImpl.div));
		System.out.println(calc.getResult(new MultiplyOperationStrategy()));
	}
}
