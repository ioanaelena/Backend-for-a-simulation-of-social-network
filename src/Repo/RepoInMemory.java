package Repo;

import Domain.Friendship;
import Domain.User;

import java.util.List;

public class RepoInMemory implements Repository {
    List<User> userList;
    List<Friendship> friendshipList;

    public RepoInMemory(List<User> userList, List<Friendship> friendshipList) {
        this.userList = userList;
        this.friendshipList = friendshipList;
    }


    @Override
    public void addUser(User user) {
        this.userList.add(user);
    }

    @Override
    public void removeUser(int id) throws Exception {
        boolean ok=false;
        for (User user: userList)
        {
            if(user.getId()==id)
            { userList.remove(user);ok=true;}
        }
        if(ok==false)
            throw new Exception("There is no  user with this id");
    }

    public List<Friendship> getFriendshipList() {
        return friendshipList;
    }

    @Override
    public void modifyUser(User user) {

    }

    @Override
    public void addFriendship(Friendship friendship) {
        this.friendshipList.add(friendship);
    }

    @Override
    public void removeFriendship(int id) throws Exception {
        boolean ok=false;
        for(Friendship fr:this.friendshipList)
        {
            if(fr.getId()==id)
            {friendshipList.remove(fr);ok=true;}
        }
        if(ok==false)
            throw new Exception("There is no user with this id");
    }

    @Override
    public void modifyFriendship(Friendship friendship) {

    }
    public void showallU(){
        for(User u:userList)
        {
            System.out.println(u);
        }
    }
    public void showallF(){
        for(Friendship f:friendshipList)
        {
            System.out.println(f);
        }
    }
}
