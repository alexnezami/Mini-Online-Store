package implementation;

import java.util.Calendar;

import domain.Client;
import domain.Facture;
import domain.Paiement;

public class PaiementImpl implements Paiement {

    private Calendar datePaiement;
    private Client payeur;
    private Facture facture;
    private float montant;
    
    public PaiementImpl(Calendar datePaiement, Client payeur, Facture facture, float montant) {
        this.datePaiement = datePaiement;
        this.payeur = payeur;
        this.facture = facture;
        this.montant = montant;
    }

      @Override
    public Calendar getDatePaiement() {
        return this.datePaiement;
    }

    @Override
    public Client getPayeur() {
        return this.payeur;
    }

    @Override
    public Facture getFacture() {
        return this.facture;
    }

    @Override
    public float getMontant() {
        return this.montant;
    }

  
}
