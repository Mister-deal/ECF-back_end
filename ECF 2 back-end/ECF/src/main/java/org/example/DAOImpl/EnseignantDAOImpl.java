package org.example.DAOImpl;

import org.example.DAO.InterfaceDAO;
import org.example.models.Enseignant;

import java.util.List;

public class EnseignantDAOImpl implements InterfaceDAO<Enseignant> {

    @Override
    public Class<Enseignant> getEntityClass() {
        return Enseignant.class;
    }
}
