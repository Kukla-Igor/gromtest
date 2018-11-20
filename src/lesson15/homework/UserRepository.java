package lesson15.homework;

public class UserRepository {
    User [] users;

    public UserRepository(User[] users) {
        this.users = users;
    }

    public User[] getUsers() {
        return users;
    }

    public User findUser(User user) {


        for (User us : users) {
            if (us != null) {

                if (us.equals(user) && us.hashCode() == user.hashCode())
                    return us;
            }
        }
        return null;
    }

    public User save(User user) {
        if (user == null || user == findUser(user))
            return null;
        for (int i = 0; i < users.length; i++){
            if (users[i] == null) {
                users[i] = user;
                return users[i];
            }
        }
        return null;
    }

    public User update(User user) {
        if (user == null)
            return null;
        for (int i = 0; i < users.length; i++){
            if (users[i] == null) {
            }
             else if (user.getId() == users[i].getId()) {
                 if (!user.equals(users[i]))
                  return users[i] = user;
              }
        }
        return null;
    }

    public void delete(long id) {
        for (int i = 0; i < users.length; i++) {
            if (users[i] == null){}
            else if (users[i].getId() == id)
                users[i] = null;
        }
    }

}
