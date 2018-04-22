package elte.projeszk.projeszk_receptek.controller;

import elte.projeszk.projeszk_receptek.exception.DataNotValidException;
import elte.projeszk.projeszk_receptek.exception.DuplicatedDataException;
import elte.projeszk.projeszk_receptek.exception.MissingDataException;
import elte.projeszk.projeszk_receptek.model.Comment;
import elte.projeszk.projeszk_receptek.model.Recipe;
import elte.projeszk.projeszk_receptek.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentController implements ControllerInterface<Comment> {

    @Autowired
    private CommentService commentService;

    @Override
    @PutMapping("/update")
    public void update(@RequestBody Comment comment) {

        try {
            commentService.update(comment);
        } catch (DataNotValidException e) {

        }
    }

    @Override
    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Integer id) {
        try {
            commentService.deleteById(id);
        } catch (DataNotValidException | MissingDataException e) {

        }
    }

    @Override
    @DeleteMapping("/delete")
    public void delete(Comment comment) {
        try {
            commentService.delete(comment);
        } catch (DataNotValidException e) {

        }
    }

    @Override
    @PostMapping("/create")
    public void create(@RequestBody Comment comment) {
        try {
            commentService.create(comment);
        } catch (DuplicatedDataException e) {

        }
    }

    @GetMapping("/{id}")
    public Comment get(@PathVariable Integer id) {
        return commentService.get(id);
    }

    @GetMapping("/getall")
    public List<Comment> getAll() {
        return commentService.getAll();
    }

    @GetMapping("/getAllToUser/{userId}")
    public List<Comment> getAllToUser(@PathVariable Integer userId) {
        return commentService.getAllCommentToUser(userId);
    }
}
