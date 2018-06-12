package lesson20.task1;

import lesson20.task1.exception.BadRequestException;
import lesson20.task1.exception.InternalServelException;
import lesson20.task1.exception.UserNotFoundException;
import lesson9.Homework.User;

public class UserRepository {
    private User[] users = new User[10];


    public User[] getUsers() {
        return users;
    }


    public String[] getUserNames() {
        if (users != null) {
            int userN = 0;

            for (int i = 0; i < users.length; i++) {
                if (users[i] != null) {
                    userN++;
                }
            }
            String[] userNames = new String[userN];

            userN = 0;
            for (int i = 0; i < users.length; i++) {
                if (users[i] != null) {
                    userNames[userN] = users[i].getName();
                    userN++;
                }
            }
            return userNames;
        }
        return null;
    }


    public long[] getUserIds() {
        if (users != null) {
            int userId = 0;
            for (int i = 0; i < users.length; i++) {
                if (users[i] != null)
                    userId++;
            }
            long[] userIds = new long[userId];
            userId = 0;
            for (int i = 0; i < users.length; i++) {
                if (users[i] != null)
                    userIds[userId] = users[i].getId();
                userId++;
            }
            return userIds;
        }
        return null;
    }

    public String getUserNameById(long id) {
        String name = null;
        if (users != null) {
            for (User user : users) {
                if (user != null)
                    if (user.getId() == id)
                        name = user.getName();
            }
        }
        return name;
    }

    // UserRepository part 3
    public User getUserByName(String name) {
        if (users != null) {
            for (User user : users) {
                if (user != null)
                    if (user.getName() == name)
                        return user;
            }
        }
        return null;
    }

    public User getUserById(long id) {
        String name = null;
        if (users != null) {
            for (User user : users) {
                if (user != null)
                    if (user.getId() == id)
                        return user;

            }
        }
        return null;
    }

    public User getUserBySessionId(String sessionId) {
        if (users != null) {
            for (User user : users) {
                if (user != null)
                    if (user.getSessionId() == sessionId)
                        return user;
            }
        }
        return null;
    }

    public User save(User user) throws Exception {
        if(user == null)
            throw new BadRequestException("Can't save null user");
        try{
            findById(user.getId());
            throw new BadRequestException("User with id:" + user.getId() + "already exists");
        }catch(UserNotFoundException e){
            System.out.println("User with id:" + user.getId() + "not found. Will be saved");
        }

        int index = 0;
        for(User us: users) {
            if (us == null) {
                users[index] = user;
                return users[index];
            }
            index++;
        }
        throw new InternalServelException("Not enough space to save user with id: " + user.getId());

    }

    public User findById(long id) throws UserNotFoundException {
        if (users != null) {
            for (User user1 : users) {
                if (user1 != null)
                    if (user1.getId() == id)
                        return user1;
            }
        }
        throw new UserNotFoundException("User with id:" + id + "not found");

    }

    //UserRepository part 5
    public User update(User user) throws Exception {
        if(user == null)
            throw new BadRequestException("Can't update null user");

        findById(user.getId());

        int index = 0;

        for (User us: users) {
            if (us != null && us.getId()== user.getId()) {
                users[index] = user;
                return users[index];
            }
            index++;
        }
       throw new InternalServelException("Unexpected error");
        }

    public void delete(long id) throws Exception{
        findById(id);

        int index = 0;

        for (User us: users) {
            if (us.getId() == id)
                users[index] = null;
            break;
        }
        index++;
    }
}


