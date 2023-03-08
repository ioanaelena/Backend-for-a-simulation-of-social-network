package Domain.Validator;

import Domain.Friendship;

public class FriendshipValidator  {
    public void friendshipValidate(Friendship friendship) throws Exception{
        String exceptionMsg="";
        if(friendship.getId()==0)
            throw new Exception("The friendship cannot have an id null.");
        if(friendship.getId1()==friendship.getId2())
            throw new Exception("You cannot have a friendship between same user.");
//        if(friendship.getId()== friendship.getId())
//            throw new Exception("This frienship exists!");
    }
}
