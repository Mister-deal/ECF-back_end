package org.example.models;

import javax.persistence.*;

@Entity
@Table(name = "`enseignant_matière`")
public class EnseignantMatière {
    @EmbeddedId
    private EnseignantMatièreId id;

    @MapsId("idM")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_m", nullable = false)
    private Matiere idM;

    @MapsId("matriculeE")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "matricule_e", nullable = false)
    private Enseignant matriculeE;


    public EnseignantMatièreId getId() {
        return id;
    }

    public void setId(EnseignantMatièreId id) {
        this.id = id;
    }

    public Matiere getIdM() {
        return idM;
    }

    public void setIdM(Matiere idM) {
        this.idM = idM;
    }

    public Enseignant getMatriculeE() {
        return matriculeE;
    }

    public void setMatriculeE(Enseignant matriculeE) {
        this.matriculeE = matriculeE;
    }

}