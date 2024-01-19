package org.example.DAOImpl;

import org.example.DAO.InterfaceDAO;
import org.example.models.Etablissement;

import java.util.List;

public class EtablissementDAOImpl implements InterfaceDAO<Etablissement> {
    @Override
    public void create(Etablissement element) {
        InterfaceDAO.super.create(element);
    }

    @Override
    public Etablissement getById(long id) {
        return InterfaceDAO.super.getById(id);
    }

    @Override
    public void remove(long id) {
        InterfaceDAO.super.remove(id);
    }

    @Override
    public List<Etablissement> getAll() {
        return InterfaceDAO.super.getAll();
    }

    @Override
    public Class<Etablissement> getEntityClass() {
        return null;
    }
}
