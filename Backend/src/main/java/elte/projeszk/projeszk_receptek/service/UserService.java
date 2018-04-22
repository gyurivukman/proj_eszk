package elte.projeszk.projeszk_receptek.service;

import elte.projeszk.projeszk_receptek.dao.UserDao;
import elte.projeszk.projeszk_receptek.exception.UserNotValidException;
import elte.projeszk.projeszk_receptek.model.Comment;
import elte.projeszk.projeszk_receptek.model.Recipe;
import elte.projeszk.projeszk_receptek.model.User;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

@Service
@SessionScope
@Data
public class UserService extends AbstractService<User> {

    @Autowired
    private UserDao userDao;
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User login(User user) throws UserNotValidException {
        if (isValid(user)) {
            return this.user = userDao.findByEmailAndPassword(user.getEmail(), user.getPassword());
        }
        throw new UserNotValidException("Username already exists!");
    }

    public void logout() {
        user = null;
    }

    public void register(User user) {
        userDao.insertEntity(user);
        this.user = userDao.findByUsername(user.getUsername());
    }

    public boolean isValid(User user) {
        return userDao.findByEmailAndPassword(user.getEmail(), user.getPassword()) != null;
    }

    public boolean isLoggedIn() {
        return user != null;
    }

    public User getLoggedInUser() {
        return user;
    }

    public void addRecipe(Integer userId, Recipe recipe) {
        userDao.addRecipeToUser(userId, recipe);
    }

    public void addComment(Integer userId, Comment comment) {
        userDao.addCommentToUser(userId, comment);
    }
}