package implementation;

import domain.LigneCommande;
import domain.Produit;

public class LigneCommandeImpl implements LigneCommande {

    Produit produit;
    int quantite;
    float prixUnitaire;

    public LigneCommandeImpl(Produit produit, int quantite, float prixUnitaire) {
        this.produit = produit;
        this.quantite = quantite;
        this.prixUnitaire = prixUnitaire;
    }


    @Override
    public Produit getProduit() {
        return this.produit;
    }

    @Override
    public int getQuantite() {
        return this.quantite;
    }

    @Override
    public void modifierQuantite(int quantite) {
        this.quantite = quantite;
    }

    @Override
    public float getPrixUnitaire() {
        return this.prixUnitaire;
    }

    @Override
    public void setPrixUnitaire(float prix) {
        this.prixUnitaire = prix;
    }

}
