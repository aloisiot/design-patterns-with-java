package br.com.cod3r.flyweight.musicPlayer.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import br.com.cod3r.flyweight.musicFlyweight.FlyweightFactory;
import br.com.cod3r.flyweight.musicPlayer.model.Music;

public class MusicService {
	private final Map<String, Map<String, Music>> memory;
	
	public MusicService() {
		memory = new HashMap<>();
	}
	
	public void listenMusic(String user, String desc) {
		Map<String, Music> userPlayList = memory.get(user);
		if(userPlayList == null) {
			userPlayList = new HashMap<>();
			memory.put(user, userPlayList);
		}

		Music song = userPlayList.get(desc);
		if(song == null) {
			song = new Music(FlyweightFactory.getInstance().getMusic(desc));
			userPlayList.put(desc, song);
		}
		System.out.printf("%s is listenning '%s'\n",
				user, song.getMusicFlyweight().getName());
		song.listenning();
	}
	
	public void report() {
		Set<String> users = memory.keySet();
		for(String user: users) {
			int timeCounter = 0;
			System.out.println("---------");
			System.out.println(user + " has listen...");
			Collection<Music> musics = memory.get(user).values();
			for(Music music: musics) {
				System.out.printf(
					"%s/%s %d times\n",
					music.getMusicFlyweight().getArtist(),
					music.getMusicFlyweight().getName(),
					music.getPlayerQty()
				);
				timeCounter += (music.getPlayerQty() * music.getMusicFlyweight().getDurationInSeconds());
			}
			System.out.printf("%s has listen music for %d seconds\n", user, timeCounter);
		}
		System.out.println("Total of musics in memory: " + FlyweightFactory.getInstance().getSize());
	}
}
