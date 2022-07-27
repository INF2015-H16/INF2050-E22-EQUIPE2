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
public class UtilitaireTest {
    
    public UtilitaireTest() {
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
     * Test of afficherMessage method, of class Utilitaire.
     */
    @Test
    public void testAfficherMessage() {
        System.out.println("afficherMessage");
        String message = "";
        Utilitaire.afficherMessage(message);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of convertirMontant method, of class Utilitaire.
     */
    @Test
    public void testConvertirMontant() {
        System.out.println("convertirMontant");
        double montant = 0.0;
        String expResult = "0.00 $";
        String result = Utilitaire.convertirMontant(montant);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
 
    
}
