package br.com.cod3r.state.headphone;

import br.com.cod3r.state.headphone.state.HPState;
import br.com.cod3r.state.headphone.state.OffState;

public class HeadPhone {
	private boolean isOn;
	private boolean isPlaying;
	private HPState state;
	
	public HeadPhone() {
		this.isOn = false;
		this.isPlaying = false;
		this.state = OffState.getInstance();
	}
	
	public void onLongClick() {
		System.out.println("Long Click Pressed...");
		state.longClick(this);
	}
	
	public void onClick() {
		System.out.println("Click Pressed...");
		state.click(this);
	}

	public void setOn(boolean isOn) {
		this.isOn = isOn;
	}

	public void setPlaying(boolean isPlaying) {
		this.isPlaying = isPlaying;
	}

	public void setState(HPState state) {
		System.out.printf("Changing from %s to %s\n",
				this.state.getClass().getSimpleName(),
				state.getClass().getSimpleName());
		this.state = state;
		System.out.println("\tUpdated values: " + this);
	}

	@Override
	public String toString() {
		return "HeadPhone{" +
				"isOn=" + isOn +
				", isPlaying=" + isPlaying +
				", state=" + state.getClass().getSimpleName() +
				'}';
	}
}
