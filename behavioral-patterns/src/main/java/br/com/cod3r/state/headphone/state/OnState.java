package br.com.cod3r.state.headphone.state;

import br.com.cod3r.state.headphone.HeadPhone;

public class OnState implements HPState {
    private static final OnState instance = new OnState();
    private OnState() {}

    public static OnState getInstance() {
        return instance;
    }

    @Override
    public void click(HeadPhone hp) {
        hp.setPlaying(true);
        System.out.println("> Resume Player");
        hp.setState(PlaiyngState.getInstance());
    }

    @Override
    public void longClick(HeadPhone hp) {
        hp.setOn(false);
        System.out.println("> Turning Off");
        hp.setState(OffState.getInstance());
    }
}
