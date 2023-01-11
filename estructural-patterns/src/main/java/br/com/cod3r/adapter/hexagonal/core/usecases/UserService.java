package br.com.cod3r.adapter.hexagonal.core.usecases;

import br.com.cod3r.adapter.hexagonal.core.model.User;
import br.com.cod3r.adapter.hexagonal.core.ports.UserRepository;

import java.util.List;

public class UserService {
    private UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public void saveUser(User user) {
        boolean alreadyUserEmail = repository.getAll().stream()
                .anyMatch(u -> u.getEmail().equalsIgnoreCase(user.getEmail()));
        if (alreadyUserEmail) throw new RuntimeException("Email address already exists!");
        repository.save(user);
    }

    public List<User> getUsers() {
        return this.repository.getAll();
    }
}
