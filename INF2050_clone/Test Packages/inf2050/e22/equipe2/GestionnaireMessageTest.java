/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package inf2050.e22.equipe2;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mtlja
 */
public class GestionnaireMessageTest {
    
    public GestionnaireMessageTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of choisirMessageTypeTerrain method, of class GestionnaireMessage.
     */
    @Test
    public void testChoisirMessageTypeTerrain() {
        System.out.println("choisirMessageTypeTerrain");
        int laDonnee = 0;
        int borneInf = 0;
        int borneSup = 0;
        String expResult = null;
        String result = GestionnaireMessage.choisirMessageTypeTerrain(laDonnee, borneInf, borneSup);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of choisirMessageDroitPassage method, of class GestionnaireMessage.
     */
    @Test
    public void testChoisirMessageDroitPassage() {
        System.out.println("choisirMessageDroitPassage");
        int laDonnee = 0;
        int borneInf = 0;
        int borneSup = 0;
        String expResult = null;
        String result = GestionnaireMessage.choisirMessageDroitPassage(laDonnee, borneInf, borneSup);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of choisirMessageServies method, of class GestionnaireMessage.
     */
    @Test
    public void testChoisirMessageServies() {
        System.out.println("choisirMessageServies");
        int laDonnee = 0;
        int borneInf = 0;
        int borneSup = 0;
        String expResult = null;
        String result = GestionnaireMessage.choisirMessageServies(laDonnee, borneInf, borneSup);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of choisirMessageNombreLots method, of class GestionnaireMessage.
     */
    @Test
    public void testChoisirMessageNombreLots() {
        System.out.println("choisirMessageNombreLots");
        int laDonnee = 0;
        int borneInf = 0;
        int borneSup = 0;
        String expResult = null;
        String result = GestionnaireMessage.choisirMessageNombreLots(laDonnee, borneInf, borneSup);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of choisirMessageSuperficie method, of class GestionnaireMessage.
     */
    @Test
    public void testChoisirMessageSuperficie() {
        System.out.println("choisirMessageSuperficie");
        int laDonnee = 0;
        int borneInf = 0;
        int borneSup = 0;
        String expResult = null;
        String result = GestionnaireMessage.choisirMessageSuperficie(laDonnee, borneInf, borneSup);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
