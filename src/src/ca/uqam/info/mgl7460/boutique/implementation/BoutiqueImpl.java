package implementation;

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

public class BoutiqueImpl implements Boutique{

    @Override
    public FabriqueBoutique getFabriqueBoutique() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getFabriqueBoutique'");
    }

    @Override
    public Client inscrireClient(String prenom, String nom, Salutation salutation, String numeroPorte, String numeroRue,
            String nomRue, String ville, String codePostal, Province province) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'inscrireClient'");
    }

    @Override
    public Panier demarrerSessionClient(Client client) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'demarrerSessionClient'");
    }

    @Override
    public void ajouterProduit(Produit produit, Panier panier) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'ajouterProduit'");
    }

    @Override
    public void retirerProduit(Produit produit, Panier panier) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'retirerProduit'");
    }

    @Override
    public int incrementerQuantiteProduit(Produit produit, Panier panier) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'incrementerQuantiteProduit'");
    }

    @Override
    public int decrementerQuantiteProduit(Produit produit, Panier panier) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'decrementerQuantiteProduit'");
    }

    @Override
    public Commande commander(Panier panier) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'commander'");
    }

    @Override
    public Facture creerFacturePourCommande(Commande commande) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'creerFacturePourCommande'");
    }

    @Override
    public float accorderReductionPourFacture(Facture facture, float reduction) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'accorderReductionPourFacture'");
    }

    @Override
    public float accorderReductionPourProduitDansFacture(Facture facture, Produit produit, float reduction) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'accorderReductionPourProduitDansFacture'");
    }

    @Override
    public Paiement payerFacture(Facture facture, Client client, float montant) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'payerFacture'");
    }

    public static Boutique getBoutiqueSingleton() {
        return null;
    }
  
}
