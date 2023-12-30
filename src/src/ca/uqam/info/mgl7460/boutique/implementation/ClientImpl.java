package implementation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import domain.Adresse;
import domain.Client;
import domain.Commande;
import domain.Paiement;
import domain.Panier;

public class ClientImpl implements Client {

    private Identification identification;
    private Adresse adresse;
    private Panier panier;
    private List<Commande> commandes;
    private List<Paiement> paiements;

    public ClientImpl(Identification identification, Adresse adresse) {
        this.identification = identification;
        this.adresse = adresse;
        this.panier = null;
        this.commandes = new ArrayList<>();
        this.paiements = new ArrayList<>();
    }

    @Override
    public Identification getIdentification() {
        return identification;
    }

    @Override
    public Adresse getAdresse() {
        return adresse;
    }
    
    @Override
    public void setAdresse(Adresse nouvelle) {
        this.adresse = nouvelle;
    }
    
    @Override
    public Panier creerPanier() {
        if (this.panier == null) {
            this.panier = new PanierImpl();
        }
        return panier;
    }

    @Override
    public Panier getPanier() {
        return panier;
    }

    @Override
    public void ajouterCommande(Commande commande) {
        commandes.add(commande);
    }

    @Override
    public void retirerCommande(Commande commande) {
        commandes.remove(commande);
    }

    @Override
    public Iterator<Commande> getCommandes() {
        return commandes.iterator();
    }

    @Override
    public Iterator<Paiement> getPaiements() {
        return paiements.iterator();
    }

    @Override
    public void ajouterPaiement(Paiement paiement) {
        paiements.add(paiement);
    }

    @Override
    public Iterator<Paiement> getPaiementsPourCommande(Commande commande) {
        List<Paiement> paiementsPourCommande = new ArrayList<>();
        for (Paiement paiement : paiements) {
            if (paiement.getPayeur().equals(commande.getClient())) {
                paiementsPourCommande.add(paiement);
            }
        }
        return paiementsPourCommande.iterator();
    }

 
}
