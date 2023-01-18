package br.com.cod3r.facade.callCenter;

import br.com.cod3r.facade.callCenter.model.Card;
import br.com.cod3r.facade.callCenter.services.CAllCenterFacade;

public class Client {

	public static void main(String[] args) {
		CAllCenterFacade facade = new CAllCenterFacade();
		
		Card card = facade.getCardByUser(21355L);
		System.out.println(card);

		facade.getSumary(card);

		facade.getPaymentInfoByCard(card);

		facade.calcelLastRegister(card);

		Card newCard = facade.getCardByUser(21355L);
		System.out.println(newCard);
	}
}
