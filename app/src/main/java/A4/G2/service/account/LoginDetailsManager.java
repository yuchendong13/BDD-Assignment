package A4.G2.service.account;

import A4.G2.service.Gallery;
import A4.G2.model.users.User;
import A4.G2.service.account.ILoginDetailsManager;
import A4.G2.service.dao.UserDaoService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class LoginDetailsManager implements ILoginDetailsManager {

    Gallery gallery;

    public LoginDetailsManager(Gallery gallery) {
        this.gallery = gallery;
    }

    @Override
    public User loginUser(String username, String password) {
        List<User> users = gallery.getUserList();
        for (User u : users) {
            if (u.getUsername().equals(username)) {
                if (u.getPassword().equals(password)) {
                    return u;
                }
            }
        }
        return null;
    }

    @Override
    public boolean checkUsernameTaken(String newUsername) {
        List<User> users = gallery.getUserList();
        for (User u : users) {
            if (u.getUsername().equals(newUsername)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int checkPasswordSecure(String newPassword, String retypedPassword) {
        if (newPassword.length() < 6) {
            return -1;
        } else if (!newPassword.matches(".*[A-Z].*")) {
            return -2;
        } else if (!newPassword.matches(".*[0-9].*")) {
            return -3;
        }

        if (!retypedPassword.equals(newPassword)) {
            return 0;
        }
        return 1;
    }

    @Override
    public boolean changeUsername(User user, String newUsername) throws UsernameTakenException {
        if (this.checkUsernameTaken(newUsername)) {
            throw new UsernameTakenException("'" + newUsername + "' already taken as a username");
        }
        user.setUsername(newUsername);
        return true;
    }

    @Override
    public boolean changePassword(User user, String oldPassword, String newPassword, String newPasswordRetyped)
            throws WeakPasswordException, IncorrectPasswordException {

        if (!oldPassword.equals(user.getPassword())) {
            throw new IncorrectPasswordException("Incorrect password: provided old password was incorrect");
        } else if (!newPassword.equals(newPasswordRetyped)) {
            throw new IncorrectPasswordException("Incorrect password: retyped new passwords don't match");
        }

        if (!newPassword.matches(".*\\d.*")) {
            throw new WeakPasswordException("Weak password: no digits in password");
        } else if (newPassword.chars().noneMatch(Character::isUpperCase)) {
            throw new WeakPasswordException("Weak password: no capital letters in password");
        } else if (newPassword.length() < 6) {
            throw new WeakPasswordException("Weak password: password less than 6 characters");
        }

        user.setPassword(newPassword);
        return true;
    }
}
