package org.example.DAOImpl;

import org.example.DAO.InterfaceDAO;
import org.example.models.Etudiant;
import org.example.models.Note;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

public class EtudiantDAOImpl implements InterfaceDAO<Etudiant> {
    @Override
    public void create(Etudiant element) {
        InterfaceDAO.super.create(element);
    }

    @Override
    public Etudiant getById(long id) {
        return InterfaceDAO.super.getById(id);
    }

    @Override
    public void remove(long id) {
        InterfaceDAO.super.remove(id);
    }

    @Override
    public List<Etudiant> getAll() {
        return InterfaceDAO.super.getAll();
    }

    @Override
    public Class<Etudiant> getEntityClass() {
        return Etudiant.class;
    }

    public long countMatière(Etudiant etudiant) {
        Session session = sessionFactory.openSession();
        String hql = "SELECT COUNT(DISTINCT n.idM) FROM Note n WHERE n.idE= :etudiant";
        Query<Long> query = session.createQuery(hql, Long.class);
        query.setParameter("etudiant", etudiant);
        long count = query.uniqueResult();
        session.close();
        return count;
    }

    public List<Note> getNote(Etudiant etudiant) {
        Session session = sessionFactory.openSession();
        Query<Note> query = session.createQuery("FROM Note n WHERE n.idE=:etudiant", Note.class);
        query.setParameter("etudiant", etudiant);
        List<Note> notes = query.getResultList();
        session.close();
        return notes;
    }

    public float getMoyenne(Etudiant etudiant) {
        Session session = sessionFactory.openSession();
        Query<Float> query=session.createQuery("SELECT avg(n.idE) from Note n where n.idE=:etudiant", Float.class);
        query.setParameter("etudiant",etudiant);
        float average=query.uniqueResult();
        session.close();
        return average;
    }

    public List<Etudiant> getParNiveau(String niveau){
        Session session= sessionFactory.openSession();
        String hql="FROM Etudiant s JOIN s.classe c WHERE c.niveau=:niveau";
        Query<Etudiant> query= session.createQuery(hql, Etudiant.class);
        query.setParameter("niveau",niveau);
        List<Etudiant> etudiants=query.getResultList();
        session.close();
        return etudiants;
    }
}
