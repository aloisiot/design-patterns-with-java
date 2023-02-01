package br.com.cod3r.state.headphone.state;

import br.com.cod3r.state.headphone.HeadPhone;

public class PlaiyngState implements HPState {
    private static final PlaiyngState instance = new PlaiyngState();
    public PlaiyngState() {}

    public static PlaiyngState getInstance() {
        return instance;
    }

    @Override
    public void click(HeadPhone hp) {
        hp.setPlaying(false);
        hp.setState(OnState.getInstance());
    }

    @Override
    public void longClick(HeadPhone hp) {
        hp.setPlaying(false);
        hp.setOn(false);
        System.out.println("> Turning Off");
        hp.setState(OffState.getInstance());
    }
}
