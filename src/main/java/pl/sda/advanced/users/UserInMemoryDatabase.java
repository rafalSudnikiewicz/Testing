package pl.sda.advanced.users;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class UserInMemoryDatabase {
    private final List<User> users;

    public UserInMemoryDatabase() {
        users = new ArrayList<>();
    }

    public void add(User user) {
        users.add(user);
    }

    public Optional<User> getById(UUID id) {
        for(User user : users) {
            if(user.getId().equals(id)) {
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }

    public Optional<User> getByEmail(String email) {
        return users.stream().filter(user -> user.getEmail().equals(email)).findFirst();
    }

    public int getUsersCount() {
        return users.size();
    }
}
