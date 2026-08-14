import java.util.LinkedHashMap;
import java.util.Map;

public class UserStore {
    private final Map<String, User> users = new LinkedHashMap<>();

    public UserStore() {
        users.put("student", new User("student", "1234", "Student"));
    }

    public boolean usernameExists(String username) {
        return users.containsKey(username);
    }

    public boolean addUser(User user) {
        if (usernameExists(user.getUsername())) {
            return false;
        }

        users.put(user.getUsername(), user);
        return true;
    }

    public User authenticate(String username, String password) {
        User user = users.get(username);

        if (user != null && user.getPassword().equals(password)) {
            return user;
        }

        return null;
    }
}
