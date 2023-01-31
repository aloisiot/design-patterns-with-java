package br.com.cod3r.command.alexa.alexa;

import java.util.HashMap;
import java.util.Map;

import br.com.cod3r.command.alexa.commands.Command;

public class Alexa {
	private final Map<String, Command> integrations;
	private final AlexaIA ia;
	public Alexa() {
		integrations = new HashMap<>();
		ia = new AlexaIA();
	}

	public void addIntegration(String key, Command command, String... keywords) {
		integrations.put(key, command);
		ia.addAssociation(key, keywords);
	}

	public void sendRequest(String request) {
		Command command = integrations.get(request);
		if(command == null) {
			String key = ia.getFindAssociations(request);
			command = integrations.get(key);
		}
		if(command == null) {
			System.out.println("Sorry, I can't perform your request!");
		} else {
			System.out.println("Send a generic command as you saved in my configurations");
			command.execute();
		}
	}
}
