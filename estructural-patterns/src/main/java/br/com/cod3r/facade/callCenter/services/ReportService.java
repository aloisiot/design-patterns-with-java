package br.com.cod3r.facade.callCenter.services;

import java.util.List;

import br.com.cod3r.facade.callCenter.model.Card;
import br.com.cod3r.facade.callCenter.model.Register;

class ReportService {
	private RegisterService registerService;
	
	public ReportService(RegisterService registerService) {
		this.registerService = registerService;
	}

	public void getSumary(Card card) {
		List<Register> registers = registerService.getRegistersByCard(card);
		for(Register reg: registers) {
			System.out.printf("%s\t%.2f\t%s",
				reg.getStoreName(),
				reg.getValue(),
				reg.getDate().toString()
			);
		}
	}

}
