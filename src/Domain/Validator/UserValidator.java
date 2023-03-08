package Domain.Validator;

import Domain.User;

public class UserValidator {
    public void userValidate(User user) throws Exception{
        String exceptionMsg="";
        if(user.getFirstName().isEmpty())
            throw new Exception("User's firstname cannot be empty.");
        if(user.getLastName().isEmpty())
            throw new Exception("User's lastname cannot be empty.");
        if(user.getAge()>100)
           // exceptionMsg+="User's age cannot be bigger than 100.";
            throw new Exception("User's age cannot be bigger than 100.");
        //throw new Exception(exceptionMsg);

    }
}
