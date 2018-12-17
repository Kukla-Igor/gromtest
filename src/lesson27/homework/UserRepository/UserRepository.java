package lesson27.homework.UserRepository;

import java.util.ArrayList;

public class UserRepository {
    private ArrayList<User> users = new ArrayList<>();

    public UserRepository(ArrayList<User> users) {
        this.users = users;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public User findById(long id) {

        for (int i = 0; i < users.size(); i++) {
            if (users.get(i) == null)
                return null;
            if (users.get(i).getId() == id)
                return users.get(i);
        }
        return null;
    }

    public User save(User user) {
        if (findById(user.getId()) == null) {
            for (int i = 0; i < users.size(); i++) {
                if (users.get(i) == null) {
                    users.add(i, user);
                    return users.get(i);
                }
            }
        }
        return null;
    }

    public User update(User user) {
        if (findById(user.getId()) == null) {
            return null;
        }
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == user.getId()) {
                users.add(i, user);
                return users.get(i);
            }
        }
        return null;
    }

    public void delete(long id) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i) == findById(id))
                users.add(i, null);
        }
    }

}
