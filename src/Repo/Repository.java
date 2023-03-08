package Repo;

import Domain.Friendship;
import Domain.User;

public interface Repository {
    void addUser(User user);

    void removeUser(int id) throws Exception;

    void modifyUser(User user);

    void addFriendship(Friendship friendship);

    void removeFriendship(int id) throws Exception;

    void modifyFriendship(Friendship friendship);

}
