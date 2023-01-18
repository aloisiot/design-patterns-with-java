package br.com.cod3r.decorator.coffeeShop.model.decorators;

import br.com.cod3r.decorator.coffeeShop.model.Drink;

public abstract class DrinkDecorator implements Drink {
    protected final Drink drink;

    public DrinkDecorator(Drink drink) {
        this.drink = drink;
    }
}