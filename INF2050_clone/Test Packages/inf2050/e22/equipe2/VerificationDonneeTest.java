/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package inf2050.e22.equipe2;

import net.sf.json.JSONObject;
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
public class VerificationDonneeTest {
    
    public VerificationDonneeTest() {
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
     * Test of chargerDonneeDeFichier method, of class VerificationDonnee.
     */
    @Test
    public void testChargerDonneeDeFichier() throws Exception {
        System.out.println("chargerDonneeDeFichier");
        String filePath = "entree.json";
        String fileEncoding = "UTF-8";
        String expResult = "entree.json";
        String result = VerificationDonnee.chargerDonneeDeFichier(filePath, fileEncoding);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of verifierPresenceDonnees method, of class VerificationDonnee.
     */
    @Test
    public void testVerifierPresenceDonnees() {
        System.out.println("verifierPresenceDonnees");
        String fichier = "JSON file";
        String expResult = "JSON file";
        String result = VerificationDonnee.verifierPresenceDonnees(fichier);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of verifierContenuFichierTerrain method, of class VerificationDonnee.
     */
    @Test
    public void testVerifierContenuFichierTerrain() {
        System.out.println("verifierContenuFichierTerrain");
        String fichier = """
                         {
                          "type_terrain":2,
                          "prix_m2_min":"3.45 $",
                          "prix_m2_max":"7.00 $",
                          "lotissements":[
                          {
                          "description":"lot 1",
                          "nombre_droits_passage":4,
                          "nombre_services":0,
                          "superficie":465,
                          "date_mesure":"2015-10-14"
                          },
                          {
                          "description":" lot 2",
                          "nombre_droits_passage":0,
                          "nombre_services":1,
                          "superficie":1082,
                          "date_mesure":"2015-12-15"
                          },
                          {
                          "description":"lot 3",
                          "nombre_droits_passage":8,
                          "nombre_services":3,
                          "superficie":3333,
                          "date_mesure":"2013-06-20"
                          }
                          ]
                         }""";
        String expResult = """
                           {
                            "type_terrain":2,
                            "prix_m2_min":"3.45 $",
                            "prix_m2_max":"7.00 $",
                            "lotissements":[
                            {
                            "description":"lot 1",
                            "nombre_droits_passage":4,
                            "nombre_services":0,
                            "superficie":465,
                            "date_mesure":"2015-10-14"
                            },
                            {
                            "description":" lot 2",
                            "nombre_droits_passage":0,
                            "nombre_services":1,
                            "superficie":1082,
                            "date_mesure":"2015-12-15"
                            },
                            {
                            "description":"lot 3",
                            "nombre_droits_passage":8,
                            "nombre_services":3,
                            "superficie":3333,
                            "date_mesure":"2013-06-20"
                            }
                            ]
                           }""";
        String result = VerificationDonnee.verifierContenuFichierTerrain(fichier);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }


    /**
     * Test of enregistrerDonneeDansFichier method, of class VerificationDonnee.
     */
    @Test
    public void testEnregistrerDonneeDansFichier() throws Exception {
        System.out.println("enregistrerDonneeDansFichier");
        String filePath = "C:\\Documents\\newfile";
        String contentToSave = "lot 1";
        String fileEncoding = "UTF-8";
        VerificationDonnee.enregistrerDonneeDansFichier(filePath, contentToSave, fileEncoding);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of validerTypeTerrain method, of class VerificationDonnee.
     */
    @Test
    public void testValiderTypeTerrain() throws Exception {
        System.out.println("validerTypeTerrain");
        int type = 0;
        int expResult = 0;
        int result = VerificationDonnee.validerTypeTerrain(type);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of validerNombreLot method, of class VerificationDonnee.
     */
    @Test
    public void testValiderNombreLot() throws Exception {
        System.out.println("validerNombreLot");
        int lot = 3;
        boolean expResult = true;
        boolean result = VerificationDonnee.validerNombreLot(lot);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of comparerPrixMinimumMaximum method, of class VerificationDonnee.
     */
    @Test
    public void testComparerPrixMinimumMaximum() throws Exception {
        System.out.println("comparerPrixMinimumMaximum");
        double prixMin = 2.0;
        double prixMax = 3.0;
        boolean expResult = true;
        boolean result = VerificationDonnee.comparerPrixMinimumMaximum(prixMin, prixMax);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of validerNombreDroitPassage method, of class VerificationDonnee.
     */
    @Test
    public void testValiderNombreDroitPassage() throws Exception {
        System.out.println("validerNombreDroitPassage");
        int droit = 0;
        int expResult = 0;
        int result = VerificationDonnee.validerNombreDroitPassage(droit);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of validerNombreService method, of class VerificationDonnee.
     */
    @Test
    public void testValiderNombreService() throws Exception {
        System.out.println("validerNombreService");
        int service = 0;
        int expResult = 0;
        int result = VerificationDonnee.validerNombreService(service);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of validerSuperficie method, of class VerificationDonnee.
     */
    @Test
    public void testValiderSuperficie() throws Exception {
        System.out.println("validerSuperficie");
        int superficie = 0;
        int expResult = 0;
        int result = VerificationDonnee.validerSuperficie(superficie);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of validerDateMesure method, of class VerificationDonnee.
     */
    @Test
    public void testValiderDateMesure() {
        System.out.println("validerDateMesure");
        String date = "2022-07-26";
        String expResult = "2022-07-26";
        String result = VerificationDonnee.validerDateMesure(date);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of verifierPrixNegatif method, of class VerificationDonnee.
     */
    @Test
    public void testVerifierPrixNegatif() throws Exception {
        System.out.println("verifierPrixNegatif");
        String prix = "3.15";
        String expResult = "3.15";
        String result = VerificationDonnee.verifierPrixNegatif(prix);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of validerPrix method, of class VerificationDonnee.
     */
    @Test
    public void testValiderPrix() throws Exception {
        System.out.println("validerPrix");
        String prix = "03.15 $";
        String expResult = "03.15 $";
        String result = VerificationDonnee.validerPrix(prix);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of validerDescriptionLot method, of class VerificationDonnee.
     */
    @Test
    public void testValiderDescriptionLot() throws Exception {
        System.out.println("validerDescriptionLot");
        String descriptionLot = "lot 1";
        String expResult = "lot 1";
        String result = VerificationDonnee.validerDescriptionLot(descriptionLot);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of verifierLotsDoublons method, of class VerificationDonnee.
     */
    @Test
    public void testVerifierLotsDoublons() throws Exception {
        System.out.println("verifierLotsDoublons");
        String[] lots = new String [2];
        lots[0] = "abc";
        lots[1] = "def";
        boolean expResult = true;
        boolean result = VerificationDonnee.verifierLotsDoublons(lots);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
