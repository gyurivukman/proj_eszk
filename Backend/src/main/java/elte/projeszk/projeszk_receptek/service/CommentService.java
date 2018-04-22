package elte.projeszk.projeszk_receptek.service;

import elte.projeszk.projeszk_receptek.dao.CommentDao;
import elte.projeszk.projeszk_receptek.model.Comment;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Service
@SessionScope
@Data
public class CommentService extends AbstractService<Comment> {
    @Autowired
    CommentDao commentDao;

    public List<Comment> getAllCommentToUser(Integer userId) {

        return commentDao.getAllCommentToUser(userId);
    }
}