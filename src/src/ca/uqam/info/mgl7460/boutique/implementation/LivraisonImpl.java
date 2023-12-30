package implementation;

import java.util.Calendar;
import java.util.Iterator;

import domain.Adresse;
import domain.Client;
import domain.Commande;
import domain.ItemInventaire;
import domain.Livraison;

public class LivraisonImpl implements Livraison{

    public LivraisonImpl(CommandeImpl commandeImpl) {
    }

    @Override
    public Calendar getDateCreation() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getDateCreation'");
    }

    @Override
    public Commande getCommande() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCommande'");
    }

    @Override
    public Client getClient() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getClient'");
    }

    @Override
    public void setClient(Client destinataire) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setClient'");
    }

    @Override
    public void ajouterItemInventaire(ItemInventaire item) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'ajouterItemInventaire'");
    }

    @Override
    public void retirerItemInventaire(ItemInventaire item) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'retirerItemInventaire'");
    }

    @Override
    public Iterator<ItemInventaire> getContenuLivraison() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getContenuLivraison'");
    }

    @Override
    public void setAdresseDeLivraison(Adresse adresse) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setAdresseDeLivraison'");
    }

    @Override
    public Adresse getAdresseDeLivraison() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAdresseDeLivraison'");
    }

    @Override
    public StatutLivraison getStatutLivraison() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getStatutLivraison'");
    }

    @Override
    public void modifierStatutLivraison(StatutLivraison nouveauStatut) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'modifierStatutLivraison'");
    }

    @Override
    public Calendar getDateLivraison() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getDateLivraison'");
    }

    @Override
    public void setDateLivraison(Calendar date) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setDateLivraison'");
    }

    
    
}
