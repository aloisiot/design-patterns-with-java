package br.com.cod3r.memento.swing.memory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Caretaker<T> {
    private final List<Memento<T>> history = new ArrayList<>();

    public List<Memento<T>> getHistoryList() {
        return Collections.unmodifiableList(history);
    }

    public void add(Memento<T> memento) {
        history.add(memento);
    }

    public Memento<T> get(int index) {
        return history.get(index);
    }
}
