package ServicePackage;

import Domain.Friendship;
import Domain.User;

public interface Service {
    void addUser(User user) throws Exception;

    void removeUser(int id) throws Exception;

    void addFriendship(Friendship friendship) throws Exception;

    void removeFriendship(int id) throws Exception;
}
