package br.com.cod3r.command.alexa.alexa;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class AlexaIA {
    private final Map<String, String[]> associations;

    public AlexaIA() {
        this.associations = new HashMap<>();
    }

    public void addAssociation(String key, String[] association) {
        associations.put(key, association);
    }

    public String getFindAssociations(String request) {
        for (String[] association : associations.values()) {
            if(Stream.of(association).allMatch(request::contains)) {
                return getKeyFromAssociations(association);
            }
        }
        return null;
    }

    private String getKeyFromAssociations(String... keywords) {
        return associations
                .entrySet()
                .stream()
                .filter(entry -> Arrays.equals(keywords, entry.getValue()))
                .map(Map.Entry::getKey)
                .findFirst().get();
    }
}
