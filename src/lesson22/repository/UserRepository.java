package lesson22.repository;



public class UserRepository {
    private static User[] users = new User[10];


    public static User[] getUsers() {
        return users;
    }


    public static User findById(long id) {

        for (int i = 0; i < users.length; i++) {
            if (users[i] == null)
                return null;
            if (users[i].getId() == id)
                return users[i];
        }
        return null;
    }

    public static User save(User user) {
        if (findById(user.getId()) == null) {
            for (int i = 0; i < users.length; i++) {
                if (users[i] == null) {
                    users[i] = user;
                    return user;
                }
            }
        }
        return null;
    }

    public static User update(User user) {
        if (findById(user.getId()) == null) {
            return null;
        }
        for (int i = 0; i < users.length; i++) {
            if (users[i].getId() == user.getId()) {
                users[i] = user;
                return user;
            }
        }
        return null;
    }

    public static void delete(long id) {
        for (int i = 0; i < users.length; i++) {
            if (users[i] == findById(id))
                users[i] = null;
        }
    }

}
