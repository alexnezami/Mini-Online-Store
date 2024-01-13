package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import domain.Client;
import domain.FabriqueBoutique;
import domain.Salutation;
import implementation.FabriqueBoutiqueImpl;


public class ClientTest {

    FabriqueBoutique fabriqueBoutique;
    Client clientMasculin;
    Client clientFeminin;

    /*
    @BeforeEach
    public void setUp(){
        fabriqueBoutique = new FabriqueBoutiqueImpl();
        clientMasculin = fabriqueBoutique.creerClient("Alireza", "Nezami",
        Salutation.MONSIEUR);
    }
     */
    @Test
    public void testgetIdentification(){
        fabriqueBoutique = new FabriqueBoutiqueImpl();
        clientMasculin = fabriqueBoutique.creerClient("Alireza", "Nezami",
        Salutation.MONSIEUR);
        assertEquals(Salutation.MONSIEUR, clientMasculin.getIdentification().salutation(),
        "Le sexe du client n'est pas correct");
    }





}