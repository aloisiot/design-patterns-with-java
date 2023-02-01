package br.com.cod3r.iterator.tvChannel;

public class Client {

	public static void main(String[] args) {
		TV tv = new TV();
		tv.searchAvaiableChannels();

		for(int channel: tv) {
			System.out.printf("Zapping at channel #%d\n", channel);
		}
	}
}
