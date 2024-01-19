package org.example.models;

import javax.persistence.*;

@Entity
@Table(name = "note")
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_n", nullable = false)
    private Integer id;

    @Column(name = "note")
    private Integer note;

    @Column(name = "commentaire", length = 249)
    private String commentaire;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_m", nullable = false)
    private Matiere idM;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_e", nullable = false)
    private Etudiant idE;

    public Note(Integer note, String commentaire, Matiere idM, Etudiant idE) {
        this.note = note;
        this.commentaire = commentaire;
        this.idM = idM;
        this.idE = idE;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNote() {
        return note;
    }

    public void setNote(Integer note) {
        this.note = note;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public Matiere getIdM() {
        return idM;
    }

    public void setIdM(Matiere idM) {
        this.idM = idM;
    }

    public Etudiant getIdE() {
        return idE;
    }

    public void setIdE(Etudiant idE) {
        this.idE = idE;
    }

}