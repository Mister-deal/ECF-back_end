package org.example.DAOImpl;

import org.example.DAO.InterfaceDAO;
import org.example.models.Departement;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

public class DepartementDAOImpl implements InterfaceDAO<Departement> {

    @Override
    public Class<Departement> getEntityClass() {
        return Departement.class;
    }

    public long countEtudiant(long idDepartement){
        Session session = sessionFactory.openSession();
        String hql="SELECT count (e) FROM Etudiant e JOIN e.classe c JOIN c.idE JOIN Enseignant.idD d where d.id=:d";
        Query<Long> query = session.createQuery(hql, Long.class);
        query.setParameter("d", idDepartement);
        long count = query.uniqueResult();
        session.close();
        return count;
    }
}
