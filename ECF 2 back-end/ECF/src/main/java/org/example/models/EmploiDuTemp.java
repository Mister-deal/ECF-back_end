package org.example.models;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "emploi_du_temps")
public class EmploiDuTemp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_e", nullable = false)
    private Integer id;

    @Column(name = "dateJour")
    private Instant dateJour;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_m", nullable = false)
    private Matiere idM;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "matricule_e", nullable = false)
    private Enseignant idE;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_c", nullable = false)
    private Classe idC;

    public EmploiDuTemp(Instant dateJour, Matiere idM, Enseignant idE, Classe idC) {
        this.dateJour = dateJour;
        this.idM = idM;
        this.idE = idE;
        this.idC = idC;
    }

    public EmploiDuTemp() {

    }

    public Enseignant getIdE() {
        return idE;
    }

    public void setIdE(Enseignant idE) {
        this.idE = idE;
    }

    public Classe getIdC() {
        return idC;
    }

    public void setIdC(Classe idC) {
        this.idC = idC;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Instant getDateJour() {
        return dateJour;
    }

    public void setDateJour(Instant dateJour) {
        this.dateJour = dateJour;
    }

    public Matiere getIdM() {
        return idM;
    }

    public void setIdM(Matiere idM) {
        this.idM = idM;
    }



}