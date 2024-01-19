package org.example.DAOImpl;

import org.example.DAO.InterfaceDAO;
import org.example.models.Classe;

import java.util.List;

public class ClasseDAOImpl implements InterfaceDAO<Classe> {


    @Override
    public Class<Classe> getEntityClass() {
        return Classe.class;
    }
}
