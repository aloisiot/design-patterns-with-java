package br.com.cod3r.flyweight.musicFlyweight;

import java.util.HashMap;

public class FlyweightFactory {
    private static final FlyweightFactory instance;
    private static final HashMap<String, MusicFlyweight> musicRepository;

    static {
        instance = new FlyweightFactory();
        musicRepository = new HashMap<>();
    }

    public static FlyweightFactory getInstance() {
        return instance;
    }

    public MusicFlyweight getMusic(String desc) {
        MusicFlyweight mf = musicRepository.get(desc);
        if(mf == null) {
            System.out.println("Creating a new Flyweight for " + desc);
            mf = getMusicByDesc(desc);
            musicRepository.put(desc, mf);
        }
        return mf;
    }

    private MusicFlyweight getMusicByDesc(String desc) {
        String[] musicData = desc.split(";");
        return new MusicFlyweight(
            musicData[0],
            musicData[1],
            Integer.valueOf(musicData[2])
        );
    }

    public Integer getSize() {
        return musicRepository.size();
    }
}
