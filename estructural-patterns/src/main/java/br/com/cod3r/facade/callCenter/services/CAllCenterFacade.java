package br.com.cod3r.facade.callCenter.services;

import br.com.cod3r.facade.callCenter.model.Card;
import br.com.cod3r.facade.callCenter.model.Register;

import java.util.List;

public class CAllCenterFacade {
    private final CardService cardService;
    private final RegisterService registerService;
    private final ReportService reportService;
    private final PaymentService paymentService;
    private final SecurityService securityService;

    public CAllCenterFacade() {
        this.cardService = new CardService();
        this.registerService = new RegisterService();
        this.reportService = new ReportService(registerService);
        this.paymentService = new PaymentService(registerService);
        this.securityService = new SecurityService(cardService, registerService);
    }

    public Card getCardByUser(Long i) {
        return cardService.getCardByUser(i);
    }

    public void getSumary(Card card) {
        reportService.getSumary(card);
    }

    public void getPaymentInfoByCard(Card card) {
        paymentService.getPaymentInfoByCard(card);
    }

    public void calcelLastRegister(Card card) {
        List<Register> registers = registerService.getRegistersByCard(card);
        registerService.removeByIndex(card, registers.size() - 1);
        List<Register> pendingRegisters = securityService.blockCard(card);
        Card newCard = cardService.createNewCard(21355L, 6846468L);
        registerService.addCardRegisters(card, pendingRegisters);
        reportService.getSumary(newCard);
    }
}
