package implementation;

import java.util.Calendar;
import java.util.Iterator;

import domain.Client;
import domain.Commande;
import domain.LigneCommande;
import domain.Panier;
import domain.Produit;

public class PanierImpl implements Panier {

    @Override
    public Client getClient() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getClient'");
    }

    @Override
    public Calendar getDate() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getDate'");
    }

    @Override
    public void ajouterProduit(Produit prod) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'ajouterProduit'");
    }

    @Override
    public void enleverProduit(Produit prod) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'enleverProduit'");
    }

    @Override
    public void modifierQuantiteProduit(Produit prod, int quantite) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'modifierQuantiteProduit'");
    }

    @Override
    public int incrementerQuantiteProduit(Produit prod) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'incrementerQuantiteProduit'");
    }

    @Override
    public int decrementerQuantiteProduit(Produit prod) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'decrementerQuantiteProduit'");
    }

    @Override
    public int getQuantiteProduit(Produit prod) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getQuantiteProduit'");
    }

    @Override
    public float getValeurPanier() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getValeurPanier'");
    }

    @Override
    public Commande creerCommande() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'creerCommande'");
    }

    @Override
    public void reinitialiser() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'reinitialiser'");
    }

    @Override
    public Iterator<LigneCommande> getLignesCommande() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getLignesCommande'");
    }
    
}
