package ServicePackage;


import Domain.Friendship;
import Domain.User;
import Domain.Validator.FriendshipValidator;
import Domain.Validator.UserValidator;
import Repo.RepoInMemory;

public class ServiceClass implements Service {
    private final RepoInMemory repository;

    public ServiceClass(RepoInMemory repository, UserValidator userValidator, FriendshipValidator friendshipValidator) {
        this.repository = repository;
        this.userValidator = userValidator;
        this.friendshipValidator = friendshipValidator;
    }

    private  UserValidator userValidator;

    private  FriendshipValidator friendshipValidator;

    @Override
    public void addUser(User user) throws Exception {
        userValidator.userValidate(user);
        repository.addUser(user);
    }

    @Override
    public void removeUser(int id) throws Exception {
        repository.removeUser(id);
    }

    @Override
    public void addFriendship(Friendship friendship) throws Exception {
        friendshipValidator.friendshipValidate(friendship);
        repository.addFriendship(friendship);
        //exceptionFriendship(friendship.getId1(), friendship.getId1());
    }

    @Override
    public void removeFriendship(int id) throws Exception {
        repository.removeFriendship(id);
    }
    public void showallU(){
        repository.showallU();
    }
    public void showallF()
    {
        repository.showallF();
    }

//    public void exceptionFriendship(int id1,int id2) throws Exception {
//        for(Friendship friendship:repository.getFriendshipList()){
//            if((friendship.getId1()==id1 && friendship.getId2()==id2) ||(friendship.getId1()==id2 && friendship.getId2()==id1)){
//                throw new Exception("This friendship already exist!");
//            }
//        }
//    }
}
