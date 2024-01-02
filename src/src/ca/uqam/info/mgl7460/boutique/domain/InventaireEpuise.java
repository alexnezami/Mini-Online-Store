package domain;

public class InventaireEpuise extends Exception {

    private Produit produit;

    private String message;

    public InventaireEpuise(Produit prod, String mess) {
        this.produit = prod;
        this.message = mess;
    }

    public String getMessage() {
        return this.message;
    }

    public Produit geProduit() {
        return this.produit;
    }
}
