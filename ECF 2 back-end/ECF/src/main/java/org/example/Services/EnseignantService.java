package org.example.Services;

import org.example.DAOImpl.EnseignantDAOImpl;
import org.example.models.Enseignant;

import java.util.Random;

public class EnseignantService {

    private EnseignantDAOImpl enseignantDAO=new EnseignantDAOImpl();

    public boolean create(String nom,String prenom,int age, Boolean isResp, Boolean isPP){
        if(nom.length()<3)
            return false;
        if(age<18)
            return false;
        String letter="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Enseignant enseignant=new Enseignant(nom,age, prenom, isPP, isResp);
        //EnseignantDAOImpl.create(enseignant);
        return true;
    }

}
