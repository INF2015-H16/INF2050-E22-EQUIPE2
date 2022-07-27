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
public class MontantLotResidentielTest {
    
    public MontantLotResidentielTest() {
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
     * Test of obtenirMontantLot method, of class MontantLotResidentiel.
     */
    @Test
    public void testObtenirMontantLot() {
        System.out.println("obtenirMontantLot");
        int index = 0;
        int[] superficies = new int[1];
        double prixMinimum = 0.0;
        double prixMaximum = 0.0;
        MontantLotResidentiel instance = new MontantLotResidentiel();
        double expResult = 0.0;
        double result = instance.obtenirMontantLot(index, superficies, prixMinimum, prixMaximum);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of obtenirMontantPassage method, of class MontantLotResidentiel.
     */
    @Test
    public void testObtenirMontantPassage() {
        System.out.println("obtenirMontantPassage");
        int index = 0;
        int[] passages = new int[1];
        double[] montantsLot = new double[1];
        MontantLotResidentiel instance = new MontantLotResidentiel();
        double expResult =500.0;
        double result = instance.obtenirMontantPassage(index, passages, montantsLot);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of obtenirMontantService method, of class MontantLotResidentiel.
     */
    @Test
    public void testObtenirMontantService() {
        System.out.println("obtenirMontantService");
        int index = 0;
        int[] superficies = new int[1];
        int[] services = new int[1];
        MontantLotResidentiel instance = new MontantLotResidentiel();
        double expResult = 0.0;
        double result = instance.obtenirMontantService(index, superficies, services);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
