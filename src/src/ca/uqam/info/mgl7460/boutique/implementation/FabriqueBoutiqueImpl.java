package implementation;

import domain.Adresse;
import domain.Client;
import domain.Commande;
import domain.FabriqueBoutique;
import domain.Facture;
import domain.InventaireEpuise;
import domain.ItemInventaire;
import domain.LigneCommande;
import domain.Livraison;
import domain.Paiement;
import domain.Panier;
import domain.Produit;
import domain.Salutation;
import netscape.javascript.JSObject;

public class FabriqueBoutiqueImpl implements FabriqueBoutique{

    @Override
    public Client creerClient(String prenom, String nom, Salutation sal) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'creerClient'");
    }

    @Override
    public Adresse creerAdresse(JSObject jsonObject) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'creerAdresse'");
    }

    @Override
    public Panier creerPanierPourClient(Client cl) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'creerPanierPourClient'");
    }

    @Override
    public Commande creerCommande(Client client) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'creerCommande'");
    }

    @Override
    public Produit creerProduit(String code, String description, int inventaire, float prixUnitaire) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'creerProduit'");
    }

    @Override
    public Paiement creerPaiement(Facture facture, Client payeur, float montant) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'creerPaiement'");
    }

    @Override
    public Livraison creerLivraison(Commande com, Client destinataire) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'creerLivraison'");
    }

    @Override
    public Facture creerFacture(Commande com) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'creerFacture'");
    }

    @Override
    public ItemInventaire creerItemInventaire(Produit produit, String numeroInventaire) throws InventaireEpuise {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'creerItemInventaire'");
    }

    @Override
    public LigneCommande creerLigneCommande(Produit produit, int quantite) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'creerLigneCommande'");
    }
    
}
