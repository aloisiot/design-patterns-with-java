package br.com.cod3r.iterator.tvChannel;

import java.util.Iterator;

public class ChannelIterator implements Iterator<Integer> {
    private final Integer[] channels;
    private Integer nextIndex = 0;

    public ChannelIterator(Integer[] channels) {
        this.channels = channels;
    }

    @Override
    public boolean hasNext() {
        if(channels == null) return false;
        return channels[nextIndex] != null;
    }

    @Override
    public Integer next() {
        return channels[nextIndex++];
    }
}
