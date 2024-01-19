package org.example.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "etablissement")
public class Etablissement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_e", nullable = false)
    private Integer id;

    @Column(name = "nom_e", length = 50)
    private String nomE;

    @OneToMany(mappedBy = "idE", cascade = CascadeType.ALL)
    private List<Departement> departements;


    public Etablissement(String nomE) {
        this.nomE = nomE;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomE() {
        return nomE;
    }

    public void setNomE(String nomE) {
        this.nomE = nomE;
    }

}