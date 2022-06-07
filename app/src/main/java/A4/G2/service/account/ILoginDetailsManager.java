package A4.G2.service.account;

import A4.G2.model.users.User;

public interface ILoginDetailsManager {

    User loginUser(String username, String password);

    boolean checkUsernameTaken(String newUsername);

    int checkPasswordSecure(String newPassword, String retypedPassword);

    boolean changeUsername(User user, String newUsername) throws UsernameTakenException;

    boolean changePassword(User user, String oldPassword, String newPassword, String newPasswordRetyped) throws WeakPasswordException, IncorrectPasswordException;
}
