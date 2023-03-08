import Domain.Friendship;
import Domain.User;
import Domain.Validator.FriendshipValidator;
import Domain.Validator.UserValidator;
import Repo.RepoInMemory;
import ServicePackage.ServiceClass;
import UI.Ui;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User>u =new ArrayList<>();
        List< Friendship >f =new ArrayList<>();
        RepoInMemory repoInMemory = new RepoInMemory(u, f);
        ServiceClass service = new ServiceClass(repoInMemory,new UserValidator(),new FriendshipValidator());
        Ui consola = new Ui(service);
        consola.main1();

    }

}