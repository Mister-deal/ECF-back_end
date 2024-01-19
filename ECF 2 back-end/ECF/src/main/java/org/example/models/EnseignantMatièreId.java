package org.example.models;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class EnseignantMatièreId implements Serializable {
    private static final long serialVersionUID = -744881852977743308L;
    @Column(name = "id_m", nullable = false)
    private Integer idM;

    @Column(name = "matricule_e", nullable = false)
    private Integer matriculeE;

    public Integer getIdM() {
        return idM;
    }

    public void setIdM(Integer idM) {
        this.idM = idM;
    }

    public Integer getMatriculeE() {
        return matriculeE;
    }

    public void setMatriculeE(Integer matriculeE) {
        this.matriculeE = matriculeE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        EnseignantMatièreId entity = (EnseignantMatièreId) o;
        return Objects.equals(this.idM, entity.idM) &&
                Objects.equals(this.matriculeE, entity.matriculeE);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idM, matriculeE);
    }

}