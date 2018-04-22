package elte.projeszk.projeszk_receptek.dao;

import elte.projeszk.projeszk_receptek.model.Comment;
import org.hibernate.SessionFactory;

import java.util.List;

public class CommentDao extends GenericDaoImpl<Comment> {
    public CommentDao(Class<Comment> commentClass, SessionFactory sessionFactory) {

        super(commentClass, sessionFactory);
    }

    public List<Comment> getAllCommentToUser(Integer userId) {
        return null;
    }
}
