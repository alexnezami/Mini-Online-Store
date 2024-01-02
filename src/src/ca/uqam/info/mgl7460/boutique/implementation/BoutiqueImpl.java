package implementation;

import java.util.Iterator;

import domain.Adresse;
import domain.Boutique;
import domain.Client;
import domain.Commande;
import domain.FabriqueBoutique;
import domain.Facture;
import domain.Paiement;
import domain.Panier;
import domain.Produit;
import domain.Province;
import domain.Salutation;
import domain.Facture.LigneFacture;

public class BoutiqueImpl implements Boutique {
    
    private static BoutiqueImpl boutiqueSingleton = null;
    
    public static Boutique getBoutiqueSingleton() {
        if(boutiqueSingleton == null)
            boutiqueSingleton = new BoutiqueImpl();
        return boutiqueSingleton;
    }

    @Override
    public FabriqueBoutique getFabriqueBoutique() {
        // Retourner une instance de FabriqueBoutique
        return new FabriqueBoutiqueImpl();
    }

    @Override
    public Client inscrireClient(String prenom, String nom, Salutation salutation,String numeroPorte,
    String numeroRue, String nomRue, String ville, String codePostal, Province province) {
        Client client = this.getFabriqueBoutique().creerClient(prenom,nom, salutation);
        client.setAdresse(new Adresse(numeroPorte, numeroRue, nomRue, ville, codePostal, province));
        return client;
    }

    @Override
    public Panier demarrerSessionClient(Client client) {
        return this.getFabriqueBoutique().creerPanierPourClient(client);
    }

    @Override
    public void ajouterProduit(Produit produit, Panier panier) {
        panier.ajouterProduit(produit);
    }

    @Override
    public void retirerProduit(Produit produit, Panier panier) {
        panier.enleverProduit(produit);
    }

    @Override
    public int incrementerQuantiteProduit(Produit produit, Panier panier) {
        return panier.incrementerQuantiteProduit(produit);
    }

    @Override
    public int decrementerQuantiteProduit(Produit produit, Panier panier) {
        return panier.decrementerQuantiteProduit(produit);
    }

    @Override
    public Commande commander(Panier panier) {
        return panier.creerCommande();
    }

    @Override
    public Facture creerFacturePourCommande(Commande commande) {
        return commande.creerFacture();
    }

    @Override
    public float accorderReductionPourFacture(Facture facture, float reduction) {
    facture.setReductionGlobale(reduction);
    float montantOriginal = facture.getMontant();
    return montantOriginal - (montantOriginal * reduction);
}


    @Override
    public float accorderReductionPourProduitDansFacture(Facture facture, Produit produit, float reduction) {
    // Mettre à jour la remise spécifique au produit dans la facture
    facture.setReductionSurProduit(produit, reduction);

    // on recalcule le montant total de la facture avec la remise appliquée
    Iterator<LigneFacture> iterateurLignes = facture.getDetailsFacture();
    float montantTotalMisAJour = 0;
    while (iterateurLignes.hasNext()) {
        LigneFacture ligneCourante = iterateurLignes.next();
        float prixUnitaire = ligneCourante.produit().getPrixUnitaire();
        int quantiteProduit = ligneCourante.quantite();

        // Ajuster le prix unitaire du produit s'il correspond au produit bénéficiant de la remise
        if (ligneCourante.produit().equals(produit)) {
            prixUnitaire = calculerPrixReduit(prixUnitaire, reduction);
        }

        // Cumuler le total de la ligne d'article avec le total de la facture
        montantTotalMisAJour += prixUnitaire * quantiteProduit;
    }
    return montantTotalMisAJour;
}

    private float calculerPrixReduit(float prixOriginal, float reduction) {
    // Calculer le prix réduit
    return prixOriginal - (prixOriginal * reduction / 100);
}


    @Override
    public Paiement payerFacture(Facture facture, Client client, float montant) {
        return this.getFabriqueBoutique().creerPaiement(facture,client,montant);
    }
}
