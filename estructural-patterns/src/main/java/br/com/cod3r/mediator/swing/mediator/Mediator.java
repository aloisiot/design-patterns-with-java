package br.com.cod3r.mediator.swing.mediator;

import br.com.cod3r.mediator.swing.components.AddButton;
import br.com.cod3r.mediator.swing.components.Label;
import br.com.cod3r.mediator.swing.components.State;

public class Mediator {
    private AddButton addButton;
    private Label label;
    private State state;

    public void addButtonClicked() {
        state.addCount();
        label.refresh();
    }

    public void reset(){
        state.setCounter(0);
        addButton.setEnabled(true);
        label.refresh();
    }

    public void stop() {
        addButton.setEnabled(false);
    }

    public  int getCounterValue() {
        return state.getCounter();
    }

    public void setAddButton(AddButton addButton) {
        this.addButton = addButton;
    }

    public void setLabel(Label label) {
        this.label = label;
    }

    public void setState(State state) {
        this.state = state;
    }
}
