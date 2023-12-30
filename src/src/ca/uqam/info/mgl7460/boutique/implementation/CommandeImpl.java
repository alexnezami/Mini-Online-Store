package implementation;

import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import domain.Adresse;
import domain.Client;
import domain.Commande;
import domain.Facture;
import domain.LigneCommande;
import domain.Livraison;
import domain.Panier;
import domain.Produit;

import java.util.ArrayList;

public class CommandeImpl implements Commande {
    
    private Client client;
    private Calendar dateCommande;
    private String numeroCommande;
    private Adresse adresseDeLivraison;
    private List<LigneCommande> lignesCommandes = new ArrayList<>();
    private List<Livraison> livraisons = new ArrayList<>();
    private Facture facture;

    public CommandeImpl(Client client, Calendar dateCommande, String numeroCommande) {
        this.client = client;
        this.dateCommande = dateCommande;
        this.numeroCommande = numeroCommande;
        this.adresseDeLivraison = client.getAdresse();
        this.lignesCommandes = new ArrayList<>();
        this.livraisons = new ArrayList<>();
    }

    @Override
    public Client getClient() {
        return this.client;
    }

    @Override
    public Calendar getDateCommande() {
        return this.dateCommande;
    }

    @Override
    public String getNumeroCommande() {
        return this.numeroCommande;
    }

    @Override
    public Adresse getAdresseDeLivraison() {
        return this.adresseDeLivraison;
    }

    @Override
    public void setAdresseDeLivraison(Adresse adresse) {
        this.adresseDeLivraison = adresse;
    }

    @Override
    public Iterator<LigneCommande> getLignesCommandes() {
        return lignesCommandes.iterator();
    }

    @Override
    public int getQuantiteCommandee(Produit produit) {
        for (LigneCommande ligne : lignesCommandes) {
            // si on trouve le produit mentionné dans LigneCommande on le retourne 
            // sinon on retourne zéro 
            if (ligne.getProduit().equals(produit)) {
                return ligne.getQuantite();
            }
        }
        return 0;
    }

    @Override
    public void ajouteLigneCommande(Produit produit, int quantite) {
        lignesCommandes.add(new LigneCommandeImpl(produit, quantite));
    }

    @Override
    public Iterator<Livraison> getLivraisons() {
        return this.livraisons.iterator();
    }

    @Override
    public Livraison creerLivraison() {
        Livraison nouvelleLivraison = new LivraisonImpl(this);
        livraisons.add(nouvelleLivraison);
        return nouvelleLivraison;
    }

    @Override
    public Facture creerFacture() {
        if (this.facture == null) {
            this.facture = new FactureImpl(this);
        }
        return this.facture;
    }

    @Override
    public Facture getFacture() {
        return this.facture;
    }

    @Override
    public void initialiserAvecPanier(Panier panier) {
        // avec iterateur on pracourie dans LigneCommande et quand on trouve un objet
        // on l'ajoute au panier du client 
        Iterator<LigneCommande> panierIterator = panier.getLignesCommande();
        while (panierIterator.hasNext()) {
            LigneCommande lignePanier = panierIterator.next();
            ajouteLigneCommande(lignePanier.getProduit(), lignePanier.getQuantite());
        }
}
}
