package test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import domain.FabriqueBoutique;
import domain.InventaireEpuise;
import domain.ItemInventaire;
import domain.Produit;
import implementation.FabriqueBoutiqueImpl;
import domain.Condition;

public class ItemInventaireTest {
    
    private Produit produit;
    private ItemInventaire itemInventaire;
    private FabriqueBoutique fabriqueBoutique;
    
    @BeforeEach
    public void setUp() throws InventaireEpuise{
        fabriqueBoutique = new FabriqueBoutiqueImpl();
        produit = fabriqueBoutique.creerProduit("001", "Good Laptop", 3, 1000);
        itemInventaire = fabriqueBoutique.creerItemInventaire(produit, "3");
    }

    @AfterEach
    public void tearDown(){
        fabriqueBoutique = null;
        itemInventaire = null;
        produit = null;
    }

    @Test
    public void testgetProduit(){
        assertNotNull(itemInventaire.getProduit(), "item inventaire n'existe pas");
       
        assertEquals(produit.getCodeProduit(), itemInventaire.getProduit().getCodeProduit(),
        "Oh la la, le code de produit n'est pas correct :-| ");
    }

    @Test
    public void testgetNumeroInventaire(){
        assertEquals("3", itemInventaire.getNumeroInventaire(),
        "le numero inventaire n'est pas correct !!!!!");
    }

    @Test
    public void testgetCondition(){
        assertEquals(Condition.GOOD, itemInventaire.getCondition(),
        "la condition n'est pas egal");
    }

    @Test
    public void testsetCondition(){
        itemInventaire.setCondition(Condition.DAMAGED);
        assertEquals(Condition.DAMAGED, itemInventaire.getCondition(),
        "la condition n'est pas egal !!!!");
    }

}
