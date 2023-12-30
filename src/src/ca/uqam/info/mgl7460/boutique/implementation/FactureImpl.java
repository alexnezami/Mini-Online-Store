package implementation;

import java.util.Iterator;

import domain.Client;
import domain.Commande;
import domain.Facture;
import domain.Paiement;
import domain.Produit;

public class FactureImpl implements Facture{

    public FactureImpl(CommandeImpl commandeImpl) {
    }

    @Override
    public Commande getCommande() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCommande'");
    }

    @Override
    public float getMontant() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getMontant'");
    }

    @Override
    public float getBalance() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getBalance'");
    }

    @Override
    public Paiement ajouterPaiement(float amount, Client payeur) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'ajouterPaiement'");
    }

    @Override
    public Iterator<LigneFacture> getDetailsFacture() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getDetailsFacture'");
    }

    @Override
    public Iterator<Paiement> getPaiements() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPaiements'");
    }

    @Override
    public void setReductionGlobale(float reductionGlobale) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setReductionGlobale'");
    }

    @Override
    public float getReductionGlobale() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getReductionGlobale'");
    }

    @Override
    public void setReductionSurProduit(Produit produit, float reductionProduit) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setReductionSurProduit'");
    }

    @Override
    public float getReductionSurProduit(Produit produit) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getReductionSurProduit'");
    }

    @Override
    public float getTotalPaiements() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTotalPaiements'");
    }
    
}
