package test;

import org.junit.jupiter.api.Test;

import domain.FabriqueBoutique;
import domain.LigneCommande;
import domain.Produit;
import implementation.FabriqueBoutiqueImpl;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LigneCommandeTest {

    private FabriqueBoutique fabriqueBoutique;
    private Produit produit;
    private LigneCommande ligneCommande;
    private LigneCommande ligneCommande2;


    @BeforeEach
    public void setUp(){
        fabriqueBoutique = new FabriqueBoutiqueImpl();
        produit = fabriqueBoutique.creerProduit("01", "new generation de tablet", 10, 430);
        ligneCommande = fabriqueBoutique.creerLigneCommande(produit, 10);
    }

    @AfterEach
    public void tearDown(){
        fabriqueBoutique = null;
        produit = null;
        ligneCommande = null;
    }

    @Test
    public void testgetProduit(){
        assertEquals(produit.getCodeProduit(), ligneCommande.getProduit().getCodeProduit(),
        "le produit mentione n'est pas correct !!!!");
    }

    @Test
    public void testgetQuantite(){
        ligneCommande2 = fabriqueBoutique.creerLigneCommande(produit, 3);

        assertAll("tester les aspects differents de get quantite",
        () -> assertTrue(ligneCommande.getQuantite()>0, "la quantite negative n'est jamais possible"),
        () -> assertNotEquals(ligneCommande.getQuantite(), ligneCommande2.getQuantite(),"la quantite n'est pas correct!!!" ),
        () -> assertEquals(10, ligneCommande.getQuantite(),"quel bizzareeee!! la quantite n'a pas change"));
    }

    @Test
    public void testmodifierQuantite(){
        ligneCommande.modifierQuantite(2);
        assertEquals(2, ligneCommande.getQuantite(),
        "la quantite n'est pas correct !!!!");
    }

    @Test
    public void testgetPrixUnitaire(){
        assertEquals(430, ligneCommande.getPrixUnitaire(),
        "le prix unitraire n'est pas correct !!!");
    }

    @Test
    public void testsetPrixUnitaire(){
        ligneCommande.setPrixUnitaire(500);
        assertEquals(500,ligneCommande.getPrixUnitaire(),
        "le prix unitaire n'est pas correct !!!!");
    }

}
