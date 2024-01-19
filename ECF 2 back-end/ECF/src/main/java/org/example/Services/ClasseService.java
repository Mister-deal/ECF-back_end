package org.example.Services;

import org.example.DAOImpl.*;
import org.example.models.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class ClasseService {

    private EtudiantDAOImpl etudiantDAO = new EtudiantDAOImpl();
    private ClasseDAOImpl classeDAO = new ClasseDAOImpl();
    private NoteDAOImpl noteDAO = new NoteDAOImpl();
    private MatiereDAOImpl matiereDAO = new MatiereDAOImpl();
    private EnseignantDAOImpl enseignantDAO = new EnseignantDAOImpl();

    private EmploiDuTempDAOImpl emploiDuTempDAO = new EmploiDuTempDAOImpl();

    public boolean createEtudiant(String prenom, String nom, LocalDate dateNaissance, String email, long idClasse){
        if(!email.endsWith("@gmail.com"))
            return false;
        if(prenom.length()<3)
            return false;
        if(nom.length()<3)
            return false;
        Classe classe = classeDAO.getById(idClasse);
        if(classe == null)
        return false;
        Etudiant etudiant = new Etudiant(prenom, nom, dateNaissance, email, classe);
        etudiantDAO.create(etudiant);
        return true;
    }

    public boolean createNote(int note,String description,long idMatière,long idEtudiant){
        if(note>20 || note<0)
            return false;
        Matiere matiere=matiereDAO.getById(idMatière);
        Etudiant etudiant=etudiantDAO.getById(idEtudiant);
        if(etudiant ==null || matiere==null)
            return false;
        Note note1=new Note(note,description,matiere,etudiant);
        noteDAO.create(note1);
        return true;
    }

    public boolean createClass(String nom,String niveau,long idEnseignant){
        Enseignant enseignant=enseignantDAO.getById(idEnseignant);
        if(enseignant==null)
            return false;
        Classe classe=new Classe(nom,niveau,enseignant);
        return true;
    }


    public List<Classe> getAllClass(){
        return classeDAO.getAll();
    }

    public long getCountSubject(long idEtudiant){
        Etudiant etudiant=etudiantDAO.getById(idEtudiant);
        if(etudiant==null)
            return 0;
        return etudiantDAO.countMatière(etudiant);
    }

    public List<Note> getNote(long idEtudiant){
        Etudiant etudiant=etudiantDAO.getById(idEtudiant);
        if(etudiant==null)
            return null;
        return etudiantDAO.getNote(etudiant);
    }

    public List<Etudiant> getByLevel(String niveau){
        return etudiantDAO.getParNiveau(niveau);
    }

    public boolean deleteStudent(long idEtudiant){
        Etudiant etudiant=etudiantDAO.getById(idEtudiant);
        if(etudiant==null)
            return false;
        etudiantDAO.remove(idEtudiant);
        return true;
    }

    public boolean deleteClass(long idClasse){
        Classe classe=classeDAO.getById(idClasse);
        if(classe==null)
            return false;
        etudiantDAO.remove(idClasse);
        return true;
    }
}
