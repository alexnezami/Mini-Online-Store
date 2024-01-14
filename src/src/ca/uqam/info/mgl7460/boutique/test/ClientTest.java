package test;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import domain.Adresse;
import domain.Client;
import domain.FabriqueBoutique;
import domain.Province;
import domain.Salutation;
import implementation.FabriqueBoutiqueImpl;


public class ClientTest {

    FabriqueBoutique fabriqueBoutique;
    Client clientMasculin;
    Client clientFeminin;

    
    @BeforeEach
    public void setUp(){
        fabriqueBoutique = new FabriqueBoutiqueImpl();
        clientMasculin = fabriqueBoutique.creerClient("Alireza", "Nezami",
        Salutation.MONSIEUR);
        clientFeminin = fabriqueBoutique.creerClient("Shadi", "Darkateh",
        Salutation.MADAME);
    }
    
    @Test
    public void testgetIdentification(){

        assertEquals(Salutation.MONSIEUR, clientMasculin.getIdentification().salutation(),
        "Le sexe du client n'est pas correct");
        assertEquals(Salutation.MADAME, clientFeminin.getIdentification().salutation(),
        "Le sexe du client n'est pas correct");

        assertEquals("Alireza", clientMasculin.getIdentification().prenom(),
        "Le prenom du client n'est pas correct");
        assertEquals("Shadi", clientFeminin.getIdentification().prenom(),
        "Le prenom du client n'est pas correct");

        assertEquals("Nezami", clientMasculin.getIdentification().nom(),
        "Le nom du client n'est pas correct");
        assertEquals("Darkateh", clientFeminin.getIdentification().nom(),
        "Le nom du client n'est pas correct");
    }

    @Test
    public void testgetAdresse(){
        clientMasculin.setAdresse(new Adresse("01", "600", "Verdun",
         "Montreal", "H3E 2N4", Province.QUEBEC));

        clientFeminin.setAdresse(new Adresse("02", "700", "sherbrooke",
         "Toronto", "H6D 5A4", Province.ONTARIO));

        assertEquals("01", clientMasculin.getAdresse().numeroPorte(),
        "numero de porte, c'est pas correct");

        assertEquals("600", clientMasculin.getAdresse().numeroRue(),
        "numero de rue, c'est pas correct");

        assertEquals("sherbrooke", clientFeminin.getAdresse().nomRue(),
        "nom de rue, c'est pas correct");

        assertEquals(Province.ONTARIO, clientFeminin.getAdresse().province(),
        "province de client, c'est pas correct");

    }

    @Test
    public void testcreerPanier(){

        clientMasculin.creerPanier();
        clientFeminin.creerPanier();

        assertNotEquals(clientMasculin.getPanier(),
        "il n'exist pas de panier");
        assertNotEquals(clientFeminin.getPanier(),
        "il n'exist pas de panier");
    }
    





}