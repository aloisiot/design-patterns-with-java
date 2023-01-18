package br.com.cod3r.decorator.coffeeShop.model.decorators;

import br.com.cod3r.decorator.coffeeShop.model.Drink;

public class Milk extends DrinkDecorator {
    public Milk(Drink drink) {
        super(drink);
    }

    @Override
    public void serve() {
        super.drink.serve();
        System.out.println("- Adding 30ml of milk");
    }

    @Override
    public Double getPrice() {
        return super.drink.getPrice() + 0.5;
    }
}
