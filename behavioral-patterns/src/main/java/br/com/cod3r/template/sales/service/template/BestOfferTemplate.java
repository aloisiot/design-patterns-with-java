package br.com.cod3r.template.sales.service.template;

import br.com.cod3r.template.sales.model.Cart;
import br.com.cod3r.template.sales.model.Product;

public abstract class BestOfferTemplate {
    protected Cart cart;
    protected Double priceFactor;
    protected Double deliveryFactor;

    public BestOfferTemplate(Cart cart) {
        this.cart = cart;
        this.priceFactor = 1d;
        this.deliveryFactor = 1d;
    }

    protected Double calculateDeliveryTax() {
        Integer distance = cart.getBuyer().getDistance();
        Double totalWeight = cart.getItems().stream()
                .map(Product::getWeight)
                .reduce(0d, Double::sum);
        return (distance * totalWeight) / 100;
    }

    protected Double calculateRegularItemsPrice() {
        return cart.getItems().stream()
                .map(Product::getValue)
                .reduce(0d, Double::sum);
    }

    public Double calculateOffer() {
        calibrateVariables();
        Double delivery = calculateDeliveryTax() * deliveryFactor;
        Double regularPrice = calculateRegularItemsPrice() * priceFactor;
        return regularPrice + delivery;
    }

    public abstract boolean isAppliable();
    protected abstract void calibrateVariables();
}
