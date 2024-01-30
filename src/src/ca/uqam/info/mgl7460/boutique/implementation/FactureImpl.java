package implementation;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import domain.Client;
import domain.Commande;
import domain.Facture;
import domain.Paiement;
import domain.Produit;
import domain.FabriqueBoutique;

public class FactureImpl implements Facture {
    private Calendar date;
    private Commande commande;
    private float reductionGlobale;
    private float montant;
    private float balance;
    private List<LigneFacture> lignesFacture;
    private List<Paiement> paiements;
    private FabriqueBoutique fabriqueBoutique;

    public FactureImpl(Calendar date,Commande commande, float reductionGlobale,
    float montant, float balance) {
        this.date = date;
        this.commande = commande;
        this.reductionGlobale = reductionGlobale;
        this.montant = montant;
        this.balance = balance;
        this.lignesFacture = new ArrayList<>();
        this.paiements = new ArrayList<>();
    }

    public Calendar getDate(){
        return this.date;
    }

    @Override
    public Commande getCommande() {
        return this.commande;
    }

    @Override
    public float getMontant() {
        return this.montant;
    }

    @Override
    public float getBalance() {
        // on va recevoir liste de paiement et apres les montant
        float totalPayments = paiements.stream().map(Paiement::getMontant)
        // On additionne tous les montants ensemble
        .reduce(0.0f, Float::sum);
        this.balance = getMontant() - totalPayments;
        // avec cette method on va eviter d'utiliser loop comme for
        // et aussi les codes sont plus lisible
        return this.balance; 
    }

    @Override
    public Paiement ajouterPaiement(float amount, Client payeur){
       
        Paiement paiement = fabriqueBoutique.creerPaiement(this, payeur, amount);
        this.paiements.add(paiement);
        return paiement;
   
    }


    @Override
    public Iterator<LigneFacture> getDetailsFacture() {
        return this.lignesFacture.iterator();
    }

    @Override
    public Iterator<Paiement> getPaiements() {
        return this.paiements.iterator();
    }

    @Override
    public void setReductionGlobale(float reductionGlobale) {
        this.reductionGlobale = reductionGlobale;
    }

    @Override
    public float getReductionGlobale() {
        return this.reductionGlobale;
    }

    @Override
    public void setReductionSurProduit(Produit produit, float reductionProduit){
        // on vérifie que le pourcentage de réduction n'est pas zéro 
        // si oui, on calcule nouveau prix sinon on retourne le prix précédent 
        float prixReduit = reductionProduit != 0 ? produit.getPrixUnitaire() * 
        (1 - (reductionProduit / 100)) : produit.getPrixUnitaire();
    
        produit.setPrixUnitaire(prixReduit);
    }
    

    @Override
    public float getReductionSurProduit(Produit produit) {
        return produit.getPrixUnitaire();
    }

    @Override
    public float getTotalPaiements(){
        float totalPaiements = 0.0f;
        // on ajoute le montant de chaque record de paiement
        for (Paiement paiement : paiements) {
            totalPaiements += paiement.getMontant();
        }
        return totalPaiements;
    }
    
}
