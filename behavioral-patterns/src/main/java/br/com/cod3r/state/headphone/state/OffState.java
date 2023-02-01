package br.com.cod3r.state.headphone.state;

import br.com.cod3r.state.headphone.HeadPhone;

public class OffState implements HPState {
    private static final OffState instance = new OffState();

    private OffState() {}

    @Override
    public void click(HeadPhone hp) {
        // Nothing to do!
    }

    @Override
    public void longClick(HeadPhone hp) {
        hp.setOn(true);
        System.out.println("> Turning On");
        hp.setState(OnState.getInstance());
    }

    public static OffState getInstance() {
        return instance;
    }
}
