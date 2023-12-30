package implementation;

import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import domain.Adresse;
import domain.Client;
import domain.Commande;
import domain.ItemInventaire;
import domain.Livraison;

import java.util.ArrayList;

public class LivraisonImpl implements Livraison {
    
    private Calendar dateCreation;
    private Calendar dateLivraison;
    private Commande commande;
    private Adresse adresseDeLivraison;
    private StatutLivraison statutLivraison;  
    private List<ItemInventaire> contenuLivraison;

    public LivraisonImpl(Calendar dateCreation, Commande commande, Adresse adresseDeLivraison) {
        this.dateCreation = dateCreation;
        this.commande = commande;
        this.adresseDeLivraison = adresseDeLivraison;
        // Statut initial
        this.statutLivraison = StatutLivraison.EN_PREPARATION; 
        this.contenuLivraison = new ArrayList<>();
    }

    @Override
    public Calendar getDateCreation() {
        return this.dateCreation;
    }

    @Override
    public Commande getCommande() {
        return this.commande;
    }

    @Override
    public Client getClient() {
        return this.getCommande().getClient();
    }

    @Override
    public void setClient(Client destinataire) {
        this.getCommande().setAdresseDeLivraison(destinataire.getAdresse());
    }

    @Override
    public void ajouterItemInventaire(ItemInventaire item) {
        this.contenuLivraison.add(item);
    }

    @Override
    public void retirerItemInventaire(ItemInventaire item) {
        this.contenuLivraison.remove(item);
    }

    @Override
    public Iterator<ItemInventaire> getContenuLivraison() {
        return this.contenuLivraison.iterator();
    }

    @Override
    public void setAdresseDeLivraison(Adresse adresse) {
        this.adresseDeLivraison = adresse;
    }

    @Override
    public Adresse getAdresseDeLivraison() {
        return this.adresseDeLivraison;
    }

    @Override
    public StatutLivraison getStatutLivraison() {
        return this.statutLivraison;
    }

    @Override
    public void modifierStatutLivraison(StatutLivraison nouveauStatut) {
        this.statutLivraison = nouveauStatut;
    }

    @Override
    public Calendar getDateLivraison() {
        return this.dateLivraison;
    }

    @Override
    public void setDateLivraison(Calendar date) {
        this.dateLivraison = date;
    }
}
