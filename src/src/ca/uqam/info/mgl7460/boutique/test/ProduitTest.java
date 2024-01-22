package test;

import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.Test;

import domain.FabriqueBoutique;
import domain.InventaireEpuise;
import domain.Produit;
import implementation.FabriqueBoutiqueImpl;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class ProduitTest {
    
    private FabriqueBoutique fabriqueBoutique;
    private Produit produit;
    
    @BeforeEach
    public void setUp(){
        fabriqueBoutique = new FabriqueBoutiqueImpl();
        produit = fabriqueBoutique.creerProduit("01", "new generation de tablet", 10, 430);
        
    }

    @AfterEach
    public void tearDown(){
        fabriqueBoutique = null;
        produit = null;
    }

    @Test
    public void testgetCodeProduit(){
        assertEquals("01", produit.getCodeProduit(),
        "le code de produit n'est pas egal");
    }

    @Test
    public void testgetDescription(){
        assertEquals("new generation de tablet", produit.getDescription(),
        "la description n'est pas egal !!!");
    }

    @Test
    public void testgetPrixUnitaire() {
        assertEquals(430, produit.getPrixUnitaire(),
        "le prix unitaire n'est pas egalllll");
    }

    @Test
    public void testgetInventaire(){
        assertEquals(10,produit.getInventaire(),
        "le nombre inventaire n'est pas egal");
    }

    @Test
    public void testsetPrixUnitaire(){
        produit.setPrixUnitaire(480);
        assertEquals(480, produit.getPrixUnitaire(),
        "le montant n'a pas bien change");
    }

    @Test
    public void testIncrementInventaire(){
        produit.incrementeInventaire(12);
        assertEquals(22, produit.getInventaire(),
        "le produit n'a pas bien incremente");
    }

    @Test
    public void testdecrementeInventire() throws InventaireEpuise{
        produit.decrementeInventaire(3);
        assertEquals(7, produit.getInventaire(),
        "le produit n'a pas bien decremente ");
    }






}
