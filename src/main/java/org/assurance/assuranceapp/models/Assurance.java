package org.assurance.assuranceapp.models;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Assurance {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private double prixDeBase;
    private double prixFinale;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;

    @OneToOne(mappedBy = "assurance", cascade = CascadeType.ALL)
    private Devis devis;

    public Assurance(double prixDeBase, double prixFinale, Utilisateur utilisateur, Devis devis) {
        this.prixDeBase = prixDeBase;
        this.prixFinale = prixFinale;
        this.utilisateur = utilisateur;
        this.devis = devis;
    }

    public Assurance() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public double getPrixDeBase() {
        return prixDeBase;
    }

    public void setPrixDeBase(double prixDeBase) {
        this.prixDeBase = prixDeBase;
    }

    public double getPrixFinale() {
        return prixFinale;
    }

    public void setPrixFinale(double prixFinale) {
        this.prixFinale = prixFinale;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Devis getDevis() {
        return devis;
    }

    public void setDevis(Devis devis) {
        this.devis = devis;
    }

    public Assurance(UUID id, double prixDeBase, double prixFinale, Utilisateur utilisateur, Devis devis) {
        this.id = id;
        this.prixDeBase = prixDeBase;
        this.prixFinale = prixFinale;
        this.utilisateur = utilisateur;
        this.devis = devis;
    }
}
