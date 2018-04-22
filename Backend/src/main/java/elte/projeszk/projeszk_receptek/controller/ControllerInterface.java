package elte.projeszk.projeszk_receptek.controller;

import elte.projeszk.projeszk_receptek.model.BaseEntity;

import java.util.List;

public interface ControllerInterface <Entity extends BaseEntity>{
    void update(Entity entity);
    void delete(Entity entity);
    void create(Entity entity);
    void deleteById(Integer id);
    Entity get(Integer id);
    List<Entity> getAll();
}
