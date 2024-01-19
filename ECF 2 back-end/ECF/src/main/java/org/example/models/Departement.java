package org.example.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "departement")
public class Departement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_d", nullable = false)
    private Integer id;

    @Column(name = "nom_d", length = 50)
    private String nomD;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_e", nullable = false)
    private Etablissement idE;

    @OneToMany(mappedBy = "idD", cascade = CascadeType.ALL)
    private List<Enseignant> enseignants;


    public Departement(String nomD, Etablissement idE) {
        this.nomD = nomD;
        this.idE = idE;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomD() {
        return nomD;
    }

    public void setNomD(String nomD) {
        this.nomD = nomD;
    }

    public Etablissement getIdE() {
        return idE;
    }

    public void setIdE(Etablissement idE) {
        this.idE = idE;
    }

}