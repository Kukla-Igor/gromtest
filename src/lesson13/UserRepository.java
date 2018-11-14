package lesson13;

public class UserRepository {
    private User[] users = new User[10];

   // public UserRepository(User[] users) {
   //     this.users = users;
   // }

    public User[] getUsers() {
        return users;
    }

    public String[] getUserNames() {


        int newArrayLenghth = users.length;
        for (int i = 0; i < users.length; i++){
            if (users[i] == null) {
                newArrayLenghth -= 1;
            }
        }

        String[] userNames = new String[newArrayLenghth];

        for (int i = 0, j = 0; i < users.length; i++, j++) {
            if (users[i] == null) {
                j--;
            }
            else
                userNames[j] = users[i].getName();
        }
        return userNames;
    }

    public long[] getUserIds() {

        int newArrayLenghth = users.length;
        for (int i = 0; i < users.length; i++){
            if (users[i] == null) {
                newArrayLenghth -= 1;
            }
        }

        long[] userIds = new long [newArrayLenghth];


        for (int i = 0, j = 0; i < users.length; i++, j++) {
            if (users[i] == null) {
                j--;
            }
            else
                userIds[i] = users[i].getId();
        }
        return userIds;
    }

    public String getUserNameById(long id) {

        for (int i = 0; i < users.length; i++) {
            if (users[i] == null)
                return null;
            if (users[i].getId() == id) {
                return users[i].getName();
            }
        }
        return null;
    }



    public User getUserByName (String name){

        for (int i = 0; i < users.length; i++){
            if (users[i] == null)
                return null;
            if (users[i].getName() == name)
                return users[i];
        }
        return null;
    }

    public User getUserById (long id){

        for (int i = 0; i < users.length; i++){
            if (users[i] == null)
                return null;
            if (users[i].getId() == id)
                return users[i];
        }
        return null;
    }

    public User getUserBySessionId (String sessionId){

        for (int i = 0; i < users.length; i++){
            if (users[i] == null)
                return null;
            if (users[i].getSessionId() == sessionId)
                return users[i];
        }
        return null;
    }

    public User findById (long id){

        for (int i = 0; i < users.length; i++){
            if (users[i] == null)
                return null;
            if (users[i].getId() == id)
                return users[i];
        }
        return null;
    }

    public User save (User user){
        if (user == null)
            return null;
        if (findById(user.getId()) == null){
            for (int i =0; i < users.length; i++) {
                if (users[i] == null) {
                    users[i] = user;
                    return user;
                }
            }
        }
        return null;
    }

    public User update (User user){
        if (user == null)
            return null;
        if (findById(user.getId()) == null){
            return null;
        }
        for (int i = 0; i < users.length; i++) {
            if (users[i].getId() == user.getId()){
                users[i] = user;
                return user;
            }
        }
        return null;
    }

    public void delete (long id){
        for (int i = 0; i < users.length; i++){
            if (users[i] == findById(id))
                users[i] = null;
        }
    }

}
