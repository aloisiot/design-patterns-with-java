package br.com.cod3r.command.alexa.commands;

import br.com.cod3r.command.alexa.lights.GenericLight;

public class TurnLightOffCommand implements Command {
    private final GenericLight light;

    public TurnLightOffCommand(GenericLight light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOff();
    }
}
