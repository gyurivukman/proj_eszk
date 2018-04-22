package elte.projeszk.projeszk_receptek.dao;

import elte.projeszk.projeszk_receptek.model.Comment;
import elte.projeszk.projeszk_receptek.model.Recipe;
import elte.projeszk.projeszk_receptek.model.User;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

public class UserDao extends GenericDaoImpl<User> {
    public UserDao(Class<User> userClass, SessionFactory sessionFactor) {
        super(userClass, sessionFactor);
    }

    public User findByUsername(String username) {
        DetachedCriteria criteria = DetachedCriteria.forClass(entityClass);
        criteria.add(Restrictions.eq("username", username));
        Criteria executableCriteria = criteria.getExecutableCriteria(currentSession());
        return (User) executableCriteria.uniqueResult();
    }

    public User findByEmailAndPassword(String email, String password) {
        DetachedCriteria criteria = DetachedCriteria.forClass(entityClass);
        criteria.add(Restrictions.eq("email", email));
        criteria.add(Restrictions.eq("password", password));
        Criteria executableCriteria = criteria.getExecutableCriteria(currentSession());
        return (User) executableCriteria.uniqueResult();
    }

    public void addRecipeToUser(Integer userId, Recipe recipe) {
        User user = findEntity(userId);
        user.getRecipes().add(recipe);
        insertEntity(user);
    }

    public void addCommentToUser(Integer userId, Comment comment) {
        User user = findEntity(userId);
        user.getComments().add(comment);
        insertEntity(user);
    }
}
