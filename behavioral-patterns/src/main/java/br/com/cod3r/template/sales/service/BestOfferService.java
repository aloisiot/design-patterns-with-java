package br.com.cod3r.template.sales.service;

import java.util.*;

import br.com.cod3r.template.sales.model.Cart;
import br.com.cod3r.template.sales.service.template.BestOfferTemplate;
import br.com.cod3r.template.sales.service.template.BigCartDiscounts;
import br.com.cod3r.template.sales.service.template.FreeDelivery;
import br.com.cod3r.template.sales.service.template.RegularPrice;

public class BestOfferService {
	private List<BestOfferTemplate> loadTemplates(Cart cart) {
		return Arrays.asList(
				new RegularPrice(cart),
				new BigCartDiscounts(cart),
				new FreeDelivery(cart)
		);
	}


	public void calculateBestOffer(Cart cart) {
		List<BestOfferTemplate> templates = loadTemplates(cart);
		double bestOffer = Double.MAX_VALUE;
		for(BestOfferTemplate template: templates) {
			if(template.isAppliable()) {
				Double currentPrice = template.calculateOffer();
				System.out.printf("%s: %.2f\n", template.getClass().getSimpleName(), currentPrice);
				bestOffer = (bestOffer > currentPrice) ? currentPrice: bestOffer;
			}
		}
		System.out.printf("Final Price: %.2f\n", bestOffer);
	}
}