package implementation;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import domain.Client;
import domain.Commande;
import domain.LigneCommande;
import domain.Panier;
import domain.Produit;

public class PanierImpl implements Panier {

    private Client client;
    private Calendar date;
    private List<LigneCommande> lignesCommande;
    private Map<Produit, Integer> produits;

    public PanierImpl(Client client, Calendar date,  List<LigneCommande> lignesCommande) {
        this.client = client;
        this.date= date;
        this.lignesCommande = lignesCommande;
        this.produits = new HashMap<>();
    }

    @Override
    public Client getClient() {
        return this.client;
    }

    @Override
    public Calendar getDate() {
        return this.date;
    }

    @Override
    public void ajouterProduit(Produit prod) {
        // avec method merge on vérifie que la clé prod existe ou non,
        //si elle existe on augmente sa valeur automatiquement
        //sinon on met sa valeur  1 par défaut  
        produits.merge(prod, 1, Integer::sum); 
    }

    @Override
    public void enleverProduit(Produit prod) {
        produits.remove(prod);
    }

    @Override
    public void modifierQuantiteProduit(Produit prod, int quantite) {
        // si la valeur de prod existe et c'est pas null,
        // on passe mais si remapping est null on ne change rien
        if (produits.computeIfPresent(prod, null) != null) {
            produits.put(prod, quantite);
        }
    }

    @Override
    public int incrementerQuantiteProduit(Produit prod) {
        return produits.merge(prod, 1, Integer::sum); 
    }

    @Override
    public int decrementerQuantiteProduit(Produit prod) {
        // Si la valeur de la clé est disponible, on lui soustrait une unité
        return produits.computeIfPresent(prod, (k, v) -> v > 1 ? v - 1 : v); 
    }

    @Override
    public int getQuantiteProduit(Produit prod) {
        // Si la valeur de la clé est disponible, on retourne la quantité
        // sinon on retourne -1
        return produits.getOrDefault(prod, -1); 
    }

    @Override
    public float getValeurPanier() {
        // avec la clé chaque fois on retire la valeur de prix
        // et on l'ajoute au montant total
        return produits.entrySet().stream()
                .map(e -> e.getKey().getPrixUnitaire() * e.getValue())
                .reduce(0.0f, Float::sum); 
    }

    @Override
    public Commande creerCommande() {
    Commande commande = new CommandeImpl(client, date, null);
    for (LigneCommande ligne : this.lignesCommande) {
        commande.ajouteLigneCommande(ligne.getProduit(), ligne.getQuantite());
    }
    return commande;
}


    @Override
    public void reinitialiser() {
        this.lignesCommande.clear();
    }

    @Override
    public Iterator<LigneCommande> getLignesCommande() {
        return this.lignesCommande.iterator();
    }


}
