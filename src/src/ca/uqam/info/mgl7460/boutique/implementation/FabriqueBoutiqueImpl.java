package implementation;

import java.util.Calendar;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.StreamSupport;


import domain.Adresse;
import domain.Client;
import domain.Client.Identification;
import domain.Commande;
import domain.FabriqueBoutique;
import domain.Facture;
import domain.Facture.LigneFacture;
import domain.InventaireEpuise;
import domain.ItemInventaire;
import domain.LigneCommande;
import domain.Livraison;
import domain.Paiement;
import domain.Panier;
import domain.Produit;
import domain.Province;
import domain.Salutation;
import domain.Condition;

import netscape.javascript.JSObject;

public class FabriqueBoutiqueImpl implements FabriqueBoutique{

    @Override
    public Client creerClient(String prenom, String nom, Salutation sal) {
        return new ClientImpl(new Identification(prenom, nom, sal));
    }

    @Override
    public Adresse creerAdresse(JSObject jsonObject) {
        // on utilise les paramètres d'objet Json pour passer l'adresse

        return new Adresse(
            jsonObject.getMember("numeroPorte").toString(),
            jsonObject.getMember("numeroRue").toString(),
            jsonObject.getMember("nomRue").toString(),
            jsonObject.getMember("ville").toString(),
            jsonObject.getMember("codePostal").toString(),
            // Dans adresse record, il est de type province,
            //le dernier élément doit donc être converti en province.
            (Province) jsonObject.getMember("province")
        );
    }

    @Override
    public Panier creerPanierPourClient(Client c1) {
        return new PanierImpl(c1, Calendar.getInstance(), null);
    }

    @Override
    public Commande creerCommande(Client client) {
        return new CommandeImpl(client, Calendar.getInstance(),null);
    }

    @Override
    public Produit creerProduit(String code, String description, int inventaire, float prixUnitaire) {
        return new ProduitImpl(code, description, prixUnitaire, inventaire);
    }

    @Override
    public Paiement creerPaiement(Facture facture, Client payeur, float montant) {
        return new PaiementImpl(Calendar.getInstance(), payeur, facture, montant);
    }

    @Override
    public Livraison creerLivraison(Commande com, Client destinataire) {
        return new LivraisonImpl(Calendar.getInstance(), com, destinataire.getAdresse());
    }

    @Override
    // J'ai utilisé l'API Java pour la lisibilité et l'optimisation du code
    public Facture creerFacture(Commande com) {
        // Chaque ligne de la facture de réception est multipliée par le numéro de réception commandé
        // et enfin le montant total de chaque ligne est déterminé
        // Et enfin, on calcule le montant final de la facture avec la fonction somme
        int montant = StreamSupport.stream(
                      Spliterators.spliteratorUnknownSize(com.getLignesCommandes(), Spliterator.ORDERED), 
                      false
                  )
                  .mapToInt(ligneCommande -> {
                      LigneFacture ligneFacture = new LigneFacture(
                          ligneCommande.getProduit(),
                          ligneCommande.getPrixUnitaire(),
                          0,
                          ligneCommande.getQuantite(),
                          ligneCommande.getPrixUnitaire() * ligneCommande.getQuantite()
                      );
                      return (int)ligneFacture.prixTotal();
                  })
                  .sum();

    return new FactureImpl(Calendar.getInstance(), com, 0, montant, 0);
    }

    @Override
    //Par défaut, je considère le produit comme neuf et vendu en bon état
    public ItemInventaire creerItemInventaire(Produit produit, String numeroInventaire) throws InventaireEpuise {
        return new ItemInventaireImpl(produit, numeroInventaire, Condition.GOOD);
    }

    @Override
    public LigneCommande creerLigneCommande(Produit produit, int quantite) {
        return new LigneCommandeImpl(produit, quantite, produit.getPrixUnitaire());
    }
    
    public FabriqueBoutiqueImpl() {
    }
}
