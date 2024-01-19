package org.example.Services;

import org.example.DAOImpl.MatiereDAOImpl;
import org.example.models.Matiere;

public class MatièreService {

    private MatiereDAOImpl matiereDAO=new MatiereDAOImpl();

    public void create(String intitule,int duration,int coefficient, String description){
        Matiere matiere=new Matiere(intitule,duration,coefficient, description);
        matiereDAO.create(matiere);
    }
}
