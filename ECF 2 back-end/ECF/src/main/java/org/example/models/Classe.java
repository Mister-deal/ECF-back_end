package org.example.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "classe")
public class Classe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_c", nullable = false)
    private Integer id;

    @Column(name = "nomClasse", length = 50)
    private String nomClasse;

    @Column(name = "niveau", length = 50)
    private String niveau;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "matricule_e", nullable = false)
    private Enseignant idE;

    @OneToMany(mappedBy = "classe", cascade = CascadeType.ALL)
    private List<Etudiant> etudiants;

    @OneToMany(mappedBy = "idC", cascade = CascadeType.ALL)
    private List<EmploiDuTemp> emploiDuTempList;

    public Classe(String nomClasse, String niveau, Enseignant idE) {
        this.nomClasse = nomClasse;
        this.niveau = niveau;
        this.idE = idE;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomClasse() {
        return nomClasse;
    }

    public void setNomClasse(String nomClasse) {
        this.nomClasse = nomClasse;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

}