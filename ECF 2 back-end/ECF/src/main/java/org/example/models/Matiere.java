package org.example.models;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "matiere")
public class Matiere {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_m", nullable = false)
    private Integer id;

    @Column(name = "intitule", length = 150)
    private String intitule;

    @Column(name = "dureeMin")
    private Integer dureeMin;

    @Column(name = "coeff")
    private Integer coeff;

    @Column(name = "description", length = 200)
    private String description;

    @OneToMany(mappedBy = "idM", cascade = CascadeType.ALL)
    private Set<EnseignantMatière> enseignantMatières;

    @OneToMany(mappedBy = "idM", cascade = CascadeType.ALL)
    private List<EmploiDuTemp> emploiDuTempList;

    @OneToMany(mappedBy = "idM", cascade = CascadeType.ALL)
    private List<Note> notes;

    public Matiere() {

    }

    public Set<EnseignantMatière> getEnseignantMatières() {
        return enseignantMatières;
    }

    public void setEnseignantMatières(Set<EnseignantMatière> enseignantMatières) {
        this.enseignantMatières = enseignantMatières;
    }

    public Matiere(String intitule, Integer dureeMin, Integer coeff, String description) {
        this.intitule = intitule;
        this.dureeMin = dureeMin;
        this.coeff = coeff;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public Integer getDureeMin() {
        return dureeMin;
    }

    public void setDureeMin(Integer dureeMin) {
        this.dureeMin = dureeMin;
    }

    public Integer getCoeff() {
        return coeff;
    }

    public void setCoeff(Integer coeff) {
        this.coeff = coeff;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}