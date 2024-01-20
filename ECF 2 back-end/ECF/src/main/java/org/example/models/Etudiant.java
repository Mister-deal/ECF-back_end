package org.example.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "etudiant")
public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_e", nullable = false)
    private Integer id;

    @Column(name = "nom_e", length = 50)
    private String nomE;

    @Column(name = "prenom_e", length = 50)
    private String prenomE;

    @Column(name = "dateNaissance")
    private LocalDate dateNaissance;

    @Column(name = "email_e", length = 50)
    private String emailE;

    @ManyToOne
    @JoinColumn(name = "id_c")
    private Classe classe;

    @OneToMany(mappedBy = "idE", cascade = CascadeType.ALL)
    private List<Note> notes;

    public Etudiant(String nomE, String prenomE, LocalDate dateNaissance, String emailE, Classe classe) {
        this.nomE = nomE;
        this.prenomE = prenomE;
        this.dateNaissance = dateNaissance;
        this.emailE = emailE;
        this.classe = classe;
    }

    public Etudiant() {

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

    public String getPrenomE() {
        return prenomE;
    }

    public void setPrenomE(String prenomE) {
        this.prenomE = prenomE;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getEmailE() {
        return emailE;
    }

    public void setEmailE(String emailE) {
        this.emailE = emailE;
    }

}