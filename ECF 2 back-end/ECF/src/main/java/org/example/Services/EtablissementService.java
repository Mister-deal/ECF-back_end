package org.example.Services;

import org.example.DAOImpl.DepartementDAOImpl;
import org.example.DAOImpl.EtablissementDAOImpl;
import org.example.models.Departement;
import org.example.models.Etablissement;

public class EtablissementService {

    private final DepartementDAOImpl departementDAO=new DepartementDAOImpl();
    private final EtablissementDAOImpl etablissementDAO=new EtablissementDAOImpl();

    public boolean create(String name,long idEtablissement){
        Etablissement etablissement=etablissementDAO.getById(idEtablissement);
        if(etablissement==null)
            return false;
        Departement departement=new Departement(name,etablissement);
        departementDAO.create(departement);
        return true;
    }

    public void create(String name){
        Etablissement etablissement=new Etablissement(name);
        etablissementDAO.create(etablissement);
    }

    public Etablissement getEtablissement(long idEtablissement){
        return etablissementDAO.getById(idEtablissement);
    }

    public Departement getDepartement(long idDepartement){
        return departementDAO.getById(idDepartement);
    }

    public long countEtudiant(long idDepartment){
        return departementDAO.countEtudiant(idDepartment);
    }

    public boolean deleteDepartement(long idDepartement){
        if(departementDAO.getById(idDepartement)==null)
            return false;
        departementDAO.remove(idDepartement);
        return true;
    }
}
