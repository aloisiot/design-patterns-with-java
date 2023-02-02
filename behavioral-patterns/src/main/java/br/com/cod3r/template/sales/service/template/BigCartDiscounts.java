package br.com.cod3r.template.sales.service.template;

import br.com.cod3r.template.sales.model.Cart;

public class BigCartDiscounts extends BestOfferTemplate {
    public BigCartDiscounts(Cart cart) {
        super(cart);
    }

    @Override
    public boolean isAppliable() {
        return calculateRegularItemsPrice() > 1000;
    }

    @Override
    protected void calibrateVariables() {
        priceFactor = 0.9;
    }
}
