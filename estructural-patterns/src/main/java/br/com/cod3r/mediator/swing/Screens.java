package br.com.cod3r.mediator.swing;

import br.com.cod3r.mediator.swing.components.AddButton;
import br.com.cod3r.mediator.swing.components.Label;
import br.com.cod3r.mediator.swing.components.ResetButton;
import br.com.cod3r.mediator.swing.components.State;
import br.com.cod3r.mediator.swing.mediator.Mediator;

import javax.swing.*;
import java.awt.*;

public class Screens {
    private final AddButton addButton;
    private final ResetButton resetButton;
    private final Label label;

    public Screens() {
        Mediator mediator = new Mediator();
        this.addButton = new AddButton(mediator);
        this.resetButton = new ResetButton(mediator);
        this.label = new Label(mediator);
        mediator.setAddButton(addButton);
        mediator.setLabel(label);
        State state = new State(mediator);
        mediator.setState(state);
    }

    private void initButtonsScreen() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Button's Screen");
        frame.setLayout(new BorderLayout());

        frame.add(resetButton, BorderLayout.WEST);
        frame.add(addButton, BorderLayout.CENTER);

        frame.setSize(400, 240);
        frame.setVisible(true);
    }

    private void initCounterScreen() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Counter Screen");

        frame.add(label);

        frame.setSize(400, 240);
        frame.setVisible(true);
    }

    public void init() {
        initButtonsScreen();
        initCounterScreen();
    }
}
