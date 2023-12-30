package implementation;

import domain.Condition;
import domain.ItemInventaire;
import domain.Produit;

public class ItemInventaireImpl implements ItemInventaire {

    private Produit produit;
    private String numeroInventaire;
    private Condition condition;

    public ItemInventaireImpl(Produit produit, String numeroInventaire, Condition condition) {
        this.produit = produit;
        this.numeroInventaire = numeroInventaire;
        this.condition = condition;
    }

    @Override
    public Produit getProduit() {
        return this.produit;
    }

    @Override
    public String getNumeroInventaire() {
        return this.numeroInventaire;
    }

    @Override
    public Condition getCondition() {
        return this.condition;
    }

    @Override
    public void setCondition(Condition cond) {
        this.condition = cond;
    }
}
