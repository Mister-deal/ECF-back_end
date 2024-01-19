package org.example.models;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "enseignant")
public class Enseignant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "matricule_e", nullable = false)
    private Integer id;

    @Column(name = "nom_e", length = 50)
    private String nomE;

    @Column(name = "age")
    private Integer age;

    @Column(name = "prenom_e", length = 50)
    private String prenomE;

    @Column(name = "grade", length = 50)
    private String grade;

    @Column(name = "isResponsable")
    private Boolean isResponsable;

    @Column(name = "isProfPrincipal")
    private Boolean isProfPrincipal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_d", nullable = false)
    private Departement idD;

    @OneToMany(mappedBy = "matriculeE", cascade = CascadeType.ALL)
    private Set<EnseignantMatière> enseignantMatières;

    @OneToMany(mappedBy = "idE", cascade = CascadeType.ALL)
    private List<EmploiDuTemp> emploiDuTempList;

    @OneToMany(mappedBy = "idE", cascade = CascadeType.ALL)
    private List<Classe> classes;

    public Enseignant(String nomE, Integer age, String prenomE, Boolean isResponsable, Boolean isProfPrincipal) {
        this.nomE = nomE;
        this.age = age;
        this.prenomE = prenomE;
        this.isResponsable = isResponsable;
        this.isProfPrincipal = isProfPrincipal;
    }

    public Boolean getResponsable() {
        return isResponsable;
    }

    public void setResponsable(Boolean responsable) {
        isResponsable = responsable;
    }

    public Boolean getProfPrincipal() {
        return isProfPrincipal;
    }

    public void setProfPrincipal(Boolean profPrincipal) {
        isProfPrincipal = profPrincipal;
    }

    public Set<EnseignantMatière> getEnseignantMatières() {
        return enseignantMatières;
    }

    public void setEnseignantMatières(Set<EnseignantMatière> enseignantMatières) {
        this.enseignantMatières = enseignantMatières;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPrenomE() {
        return prenomE;
    }

    public void setPrenomE(String prenomE) {
        this.prenomE = prenomE;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Boolean getIsResponsable() {
        return isResponsable;
    }

    public void setIsResponsable(Boolean isResponsable) {
        this.isResponsable = isResponsable;
    }

    public Boolean getIsProfPrincipal() {
        return isProfPrincipal;
    }

    public void setIsProfPrincipal(Boolean isProfPrincipal) {
        this.isProfPrincipal = isProfPrincipal;
    }

    public Departement getIdD() {
        return idD;
    }

    public void setIdD(Departement idD) {
        this.idD = idD;
    }

}