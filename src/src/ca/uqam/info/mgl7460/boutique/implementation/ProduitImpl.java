package implementation;

import domain.InventaireEpuise;
import domain.Produit;

public class ProduitImpl implements Produit{

    private String codeProduit;
    private String description;
    private float prixUnitaire;
    private int inventaire;

    public ProduitImpl(String codeProduit, String description, float prixUnitaire, int inventaire){
        this.codeProduit = codeProduit;
        this.description = description;
        this.prixUnitaire = prixUnitaire;
        this.inventaire = inventaire;
    }

    @Override
    public String getCodeProduit() {
        return this.codeProduit;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public float getPrixUnitaire() {
        return this.prixUnitaire;
    }

    @Override
    public int getInventaire() {
        return this.inventaire;
    }

    @Override
    public void setPrixUnitaire(float prix) {
        this.prixUnitaire = prix;
    }

    @Override
    public int incrementeInventaire(int increment) {
        this.inventaire += increment;
        return inventaire;
    }

    @Override
    public int decrementeInventaire(int decrement) throws InventaireEpuise {
        //Si decrement est supérieur au inventaire, nous donnerons un message d'erreur,
        // sinon nous soustrairons decrement de inventaire
        if (inventaire < decrement) {
            throw new InventaireEpuise(this,"Inventaire insuffisant pour décrémenter " + decrement);
        }
        inventaire -= decrement;
        return inventaire;
    }
}


