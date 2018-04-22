package elte.projeszk.projeszk_receptek.service;

import elte.projeszk.projeszk_receptek.exception.DataNotValidException;
import elte.projeszk.projeszk_receptek.exception.DuplicatedDataException;
import elte.projeszk.projeszk_receptek.exception.MissingDataException;
import elte.projeszk.projeszk_receptek.model.BaseEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class AbstractService<Entity extends BaseEntity> {

    @Autowired
    DaoInterface<Entity> dao;

    protected boolean exist(Entity entity) {
        return dao.findEntity(entity.getId()) == null;
    }

    public void update(Entity entity) throws DataNotValidException {
        if (exist(entity)) {
            dao.updateEntity(entity);
        } else {
            throw new DataNotValidException();
        }
    }

    public void deleteById(Integer id) throws DataNotValidException, MissingDataException {
        if (exist(get(id))) {
            dao.deleteEntityById(id);
        } else {
            throw new DataNotValidException();
        }
    }

    public void delete(Entity entity) throws DataNotValidException {
        if (exist(entity)) {
            dao.deleteEntity(entity);
        } else {
            throw new DataNotValidException();
        }
    }

    public void create(Entity entity) throws DuplicatedDataException {
        if (exist(entity)) {
            dao.insertEntity(entity);
        } else {
            throw new DuplicatedDataException();
        }
    }

    public Entity get(Integer id) {
        return dao.findEntity(id);
    }

    public List<Entity> getAll() {
        return dao.getEntities();
    }

}
