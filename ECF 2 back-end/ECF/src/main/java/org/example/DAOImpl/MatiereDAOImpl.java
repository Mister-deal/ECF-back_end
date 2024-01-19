package org.example.DAOImpl;

import org.example.DAO.InterfaceDAO;
import org.example.models.Matiere;

import java.util.List;

public class MatiereDAOImpl implements InterfaceDAO<Matiere> {
    @Override
    public void create(Matiere element) {
        InterfaceDAO.super.create(element);
    }

    @Override
    public Matiere getById(long id) {
        return InterfaceDAO.super.getById(id);
    }

    @Override
    public void remove(long id) {
        InterfaceDAO.super.remove(id);
    }

    @Override
    public List<Matiere> getAll() {
        return InterfaceDAO.super.getAll();
    }

    @Override
    public Class<Matiere> getEntityClass() {
        return Matiere.class;
    }
}
