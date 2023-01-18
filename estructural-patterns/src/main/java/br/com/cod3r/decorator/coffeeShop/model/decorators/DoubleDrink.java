package br.com.cod3r.decorator.coffeeShop.model.decorators;

import br.com.cod3r.decorator.coffeeShop.model.Drink;

public class DoubleDrink extends DrinkDecorator {
    public DoubleDrink(Drink drink) {
        super(drink);
    }

    @Override
    public void serve() {
        super.drink.serve();
        super.drink.serve();
    }

    @Override
    public Double getPrice() {
        return super.drink.getPrice() * 1.75;
    }
}
