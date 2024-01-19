package org.example.DAOImpl;

import org.example.DAO.InterfaceDAO;
import org.example.models.EnseignantMatière;

import java.util.List;

public class EnseignantMatièreDAOImpl implements InterfaceDAO<EnseignantMatière> {
    @Override
    public void create(EnseignantMatière element) {
        InterfaceDAO.super.create(element);
    }

    @Override
    public EnseignantMatière getById(long id) {
        return InterfaceDAO.super.getById(id);
    }

    @Override
    public void remove(long id) {
        InterfaceDAO.super.remove(id);
    }

    @Override
    public List<EnseignantMatière> getAll() {
        return InterfaceDAO.super.getAll();
    }

    @Override
    public Class<EnseignantMatière> getEntityClass() {
        return null;
    }
}
