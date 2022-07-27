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
public class LancementProgrammeTest {
    
    public LancementProgrammeTest() {
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
     * Test of getLesLotissements method, of class LancementProgramme.
     */
    @Test
    public void testGetLesLotissements() throws Exception {
        System.out.println("getLesLotissements");
        String json = " {\n" +
" \"type_terrain\":2,\n" +
" \"prix_m2_min\":\"3.45 $\",\n" +
" \"prix_m2_max\":\"7.00 $\",\n" +
" \"lotissements\": [] } ";
        LancementProgramme instance = new LancementProgramme("  {\n" +
" \"type_terrain\":2,\n" +
" \"prix_m2_min\":\"3.45 $\",\n" +
" \"prix_m2_max\":\"7.00 $\",\n" +
" \"lotissements\":[\n" +
" {\n" +
" \"description\":\"lot 1\",\n" +
" \"nombre_droits_passage\":4,\n" +
" \"nombre_services\":0,\n" +
" \"superficie\":465,\n" +
" \"date_mesure\":\"2015-10-14\"\n" +
" },\n" +
" {\n" +
" \"description\":\" lot 2\",\n" +
" \"nombre_droits_passage\":0,\n" +
" \"nombre_services\":1,\n" +
" \"superficie\":1082,\n" +
" \"date_mesure\":\"2015-12-15\"\n" +
" },\n" +
" {\n" +
" \"description\":\"lot 3\",\n" +
" \"nombre_droits_passage\":8,\n" +
" \"nombre_services\":3,\n" +
" \"superficie\":3333,\n" +
" \"date_mesure\":\"2013-06-20\"\n" +
" }\n" +
" ]\n" +
"} ");
        instance.getLesLotissements(json);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getTerrain method, of class LancementProgramme.
     */
    @Test
    public void testGetTerrain() throws Exception {
        System.out.println("getTerrain");
        String json = " {\n" +
" \"type_terrain\":2,\n" +
" \"prix_m2_min\":\"3.45 $\",\n" +
" \"prix_m2_max\":\"7.00 $\",\n" +
" \"lotissements\": [] } ";
        LancementProgramme instance = new LancementProgramme("  {\n" +
" \"type_terrain\":2,\n" +
" \"prix_m2_min\":\"3.45 $\",\n" +
" \"prix_m2_max\":\"7.00 $\",\n" +
" \"lotissements\":[\n" +
" {\n" +
" \"description\":\"lot 1\",\n" +
" \"nombre_droits_passage\":4,\n" +
" \"nombre_services\":0,\n" +
" \"superficie\":465,\n" +
" \"date_mesure\":\"2015-10-14\"\n" +
" },\n" +
" {\n" +
" \"description\":\" lot 2\",\n" +
" \"nombre_droits_passage\":0,\n" +
" \"nombre_services\":1,\n" +
" \"superficie\":1082,\n" +
" \"date_mesure\":\"2015-12-15\"\n" +
" },\n" +
" {\n" +
" \"description\":\"lot 3\",\n" +
" \"nombre_droits_passage\":8,\n" +
" \"nombre_services\":3,\n" +
" \"superficie\":3333,\n" +
" \"date_mesure\":\"2013-06-20\"\n" +
" }\n" +
" ]\n" +
"} ");
        instance.getTerrain(json);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getIdTerrain method, of class LancementProgramme.
     */
    @Test
    public void testGetIdTerrain() throws Exception {
        System.out.println("getIdTerrain");
        LancementProgramme instance = new LancementProgramme("  {\n" +
" \"type_terrain\":2,\n" +
" \"prix_m2_min\":\"3.45 $\",\n" +
" \"prix_m2_max\":\"7.00 $\",\n" +
" \"lotissements\":[\n" +
" {\n" +
" \"description\":\"lot 1\",\n" +
" \"nombre_droits_passage\":4,\n" +
" \"nombre_services\":0,\n" +
" \"superficie\":465,\n" +
" \"date_mesure\":\"2015-10-14\"\n" +
" },\n" +
" {\n" +
" \"description\":\" lot 2\",\n" +
" \"nombre_droits_passage\":0,\n" +
" \"nombre_services\":1,\n" +
" \"superficie\":1082,\n" +
" \"date_mesure\":\"2015-12-15\"\n" +
" },\n" +
" {\n" +
" \"description\":\"lot 3\",\n" +
" \"nombre_droits_passage\":8,\n" +
" \"nombre_services\":3,\n" +
" \"superficie\":3333,\n" +
" \"date_mesure\":\"2013-06-20\"\n" +
" }\n" +
" ]\n" +
"} ");
        instance.getIdTerrain();
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getPrixMinimum method, of class LancementProgramme.
     */
    @Test
    public void testGetPrixMinimum() throws Exception {
        System.out.println("getPrixMinimum");
        LancementProgramme instance = new LancementProgramme("  {\n" +
" \"type_terrain\":2,\n" +
" \"prix_m2_min\":\"3.45 $\",\n" +
" \"prix_m2_max\":\"7.00 $\",\n" +
" \"lotissements\":[\n" +
" {\n" +
" \"description\":\"lot 1\",\n" +
" \"nombre_droits_passage\":4,\n" +
" \"nombre_services\":0,\n" +
" \"superficie\":465,\n" +
" \"date_mesure\":\"2015-10-14\"\n" +
" },\n" +
" {\n" +
" \"description\":\" lot 2\",\n" +
" \"nombre_droits_passage\":0,\n" +
" \"nombre_services\":1,\n" +
" \"superficie\":1082,\n" +
" \"date_mesure\":\"2015-12-15\"\n" +
" },\n" +
" {\n" +
" \"description\":\"lot 3\",\n" +
" \"nombre_droits_passage\":8,\n" +
" \"nombre_services\":3,\n" +
" \"superficie\":3333,\n" +
" \"date_mesure\":\"2013-06-20\"\n" +
" }\n" +
" ]\n" +
"} ");
        instance.getPrixMinimum();
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getPrixMaximum method, of class LancementProgramme.
     */
    @Test
    public void testGetPrixMaximum() throws Exception {
        System.out.println("getPrixMaximum");
        LancementProgramme instance = new LancementProgramme("  {\n" +
" \"type_terrain\":2,\n" +
" \"prix_m2_min\":\"3.45 $\",\n" +
" \"prix_m2_max\":\"7.00 $\",\n" +
" \"lotissements\":[\n" +
" {\n" +
" \"description\":\"lot 1\",\n" +
" \"nombre_droits_passage\":4,\n" +
" \"nombre_services\":0,\n" +
" \"superficie\":465,\n" +
" \"date_mesure\":\"2015-10-14\"\n" +
" },\n" +
" {\n" +
" \"description\":\" lot 2\",\n" +
" \"nombre_droits_passage\":0,\n" +
" \"nombre_services\":1,\n" +
" \"superficie\":1082,\n" +
" \"date_mesure\":\"2015-12-15\"\n" +
" },\n" +
" {\n" +
" \"description\":\"lot 3\",\n" +
" \"nombre_droits_passage\":8,\n" +
" \"nombre_services\":3,\n" +
" \"superficie\":3333,\n" +
" \"date_mesure\":\"2013-06-20\"\n" +
" }\n" +
" ]\n" +
"} ");
        instance.getPrixMaximum();
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getPrixMinPrixMaxVerifier method, of class LancementProgramme.
     */
    @Test
    public void testGetPrixMinPrixMaxVerifier() throws Exception {
        System.out.println("getPrixMinPrixMaxVerifier");
        LancementProgramme instance = new LancementProgramme("  {\n" +
" \"type_terrain\":2,\n" +
" \"prix_m2_min\":\"3.45 $\",\n" +
" \"prix_m2_max\":\"7.00 $\",\n" +
" \"lotissements\":[\n" +
" {\n" +
" \"description\":\"lot 1\",\n" +
" \"nombre_droits_passage\":4,\n" +
" \"nombre_services\":0,\n" +
" \"superficie\":465,\n" +
" \"date_mesure\":\"2015-10-14\"\n" +
" },\n" +
" {\n" +
" \"description\":\" lot 2\",\n" +
" \"nombre_droits_passage\":0,\n" +
" \"nombre_services\":1,\n" +
" \"superficie\":1082,\n" +
" \"date_mesure\":\"2015-12-15\"\n" +
" },\n" +
" {\n" +
" \"description\":\"lot 3\",\n" +
" \"nombre_droits_passage\":8,\n" +
" \"nombre_services\":3,\n" +
" \"superficie\":3333,\n" +
" \"date_mesure\":\"2013-06-20\"\n" +
" }\n" +
" ]\n" +
"} ");
        instance.getPrixMinPrixMaxVerifier();
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getQuantiteLots method, of class LancementProgramme.
     */
    @Test
    public void testGetQuantiteLots() throws Exception {
        System.out.println("getQuantiteLots");
        LancementProgramme instance = new LancementProgramme("  {\n" +
" \"type_terrain\":2,\n" +
" \"prix_m2_min\":\"3.45 $\",\n" +
" \"prix_m2_max\":\"7.00 $\",\n" +
" \"lotissements\":[\n" +
" {\n" +
" \"description\":\"lot 1\",\n" +
" \"nombre_droits_passage\":4,\n" +
" \"nombre_services\":0,\n" +
" \"superficie\":465,\n" +
" \"date_mesure\":\"2015-10-14\"\n" +
" },\n" +
" {\n" +
" \"description\":\" lot 2\",\n" +
" \"nombre_droits_passage\":0,\n" +
" \"nombre_services\":1,\n" +
" \"superficie\":1082,\n" +
" \"date_mesure\":\"2015-12-15\"\n" +
" },\n" +
" {\n" +
" \"description\":\"lot 3\",\n" +
" \"nombre_droits_passage\":8,\n" +
" \"nombre_services\":3,\n" +
" \"superficie\":3333,\n" +
" \"date_mesure\":\"2013-06-20\"\n" +
" }\n" +
" ]\n" +
"} ");
        instance.getQuantiteLots();
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getDescriptions method, of class LancementProgramme.
     */
    @Test
    public void testGetDescriptions() throws Exception {
        System.out.println("getDescriptions");
        LancementProgramme instance = new LancementProgramme("  {\n" +
" \"type_terrain\":2,\n" +
" \"prix_m2_min\":\"3.45 $\",\n" +
" \"prix_m2_max\":\"7.00 $\",\n" +
" \"lotissements\":[\n" +
" {\n" +
" \"description\":\"lot 1\",\n" +
" \"nombre_droits_passage\":4,\n" +
" \"nombre_services\":0,\n" +
" \"superficie\":465,\n" +
" \"date_mesure\":\"2015-10-14\"\n" +
" },\n" +
" {\n" +
" \"description\":\" lot 2\",\n" +
" \"nombre_droits_passage\":0,\n" +
" \"nombre_services\":1,\n" +
" \"superficie\":1082,\n" +
" \"date_mesure\":\"2015-12-15\"\n" +
" },\n" +
" {\n" +
" \"description\":\"lot 3\",\n" +
" \"nombre_droits_passage\":8,\n" +
" \"nombre_services\":3,\n" +
" \"superficie\":3333,\n" +
" \"date_mesure\":\"2013-06-20\"\n" +
" }\n" +
" ]\n" +
"} ");
        instance.getDescriptions();
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getPassages method, of class LancementProgramme.
     */
    @Test
    public void testGetPassages() throws Exception {
        System.out.println("getPassages");
        LancementProgramme instance = new LancementProgramme("  {\n" +
" \"type_terrain\":2,\n" +
" \"prix_m2_min\":\"3.45 $\",\n" +
" \"prix_m2_max\":\"7.00 $\",\n" +
" \"lotissements\":[\n" +
" {\n" +
" \"description\":\"lot 1\",\n" +
" \"nombre_droits_passage\":4,\n" +
" \"nombre_services\":0,\n" +
" \"superficie\":465,\n" +
" \"date_mesure\":\"2015-10-14\"\n" +
" },\n" +
" {\n" +
" \"description\":\" lot 2\",\n" +
" \"nombre_droits_passage\":0,\n" +
" \"nombre_services\":1,\n" +
" \"superficie\":1082,\n" +
" \"date_mesure\":\"2015-12-15\"\n" +
" },\n" +
" {\n" +
" \"description\":\"lot 3\",\n" +
" \"nombre_droits_passage\":8,\n" +
" \"nombre_services\":3,\n" +
" \"superficie\":3333,\n" +
" \"date_mesure\":\"2013-06-20\"\n" +
" }\n" +
" ]\n" +
"} ");
        instance.getPassages();
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getNombreService method, of class LancementProgramme.
     */
    @Test
    public void testGetNombreService() throws Exception {
        System.out.println("getNombreService");
        LancementProgramme instance = new LancementProgramme("  {\n" +
" \"type_terrain\":2,\n" +
" \"prix_m2_min\":\"3.45 $\",\n" +
" \"prix_m2_max\":\"7.00 $\",\n" +
" \"lotissements\":[\n" +
" {\n" +
" \"description\":\"lot 1\",\n" +
" \"nombre_droits_passage\":4,\n" +
" \"nombre_services\":0,\n" +
" \"superficie\":465,\n" +
" \"date_mesure\":\"2015-10-14\"\n" +
" },\n" +
" {\n" +
" \"description\":\" lot 2\",\n" +
" \"nombre_droits_passage\":0,\n" +
" \"nombre_services\":1,\n" +
" \"superficie\":1082,\n" +
" \"date_mesure\":\"2015-12-15\"\n" +
" },\n" +
" {\n" +
" \"description\":\"lot 3\",\n" +
" \"nombre_droits_passage\":8,\n" +
" \"nombre_services\":3,\n" +
" \"superficie\":3333,\n" +
" \"date_mesure\":\"2013-06-20\"\n" +
" }\n" +
" ]\n" +
"} ");
        instance.getNombreService();
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getSuperficies method, of class LancementProgramme.
     */
    @Test
    public void testGetSuperficies() throws Exception {
        System.out.println("getSuperficies");
        LancementProgramme instance = new LancementProgramme("  {\n" +
" \"type_terrain\":2,\n" +
" \"prix_m2_min\":\"3.45 $\",\n" +
" \"prix_m2_max\":\"7.00 $\",\n" +
" \"lotissements\":[\n" +
" {\n" +
" \"description\":\"lot 1\",\n" +
" \"nombre_droits_passage\":4,\n" +
" \"nombre_services\":0,\n" +
" \"superficie\":465,\n" +
" \"date_mesure\":\"2015-10-14\"\n" +
" },\n" +
" {\n" +
" \"description\":\" lot 2\",\n" +
" \"nombre_droits_passage\":0,\n" +
" \"nombre_services\":1,\n" +
" \"superficie\":1082,\n" +
" \"date_mesure\":\"2015-12-15\"\n" +
" },\n" +
" {\n" +
" \"description\":\"lot 3\",\n" +
" \"nombre_droits_passage\":8,\n" +
" \"nombre_services\":3,\n" +
" \"superficie\":3333,\n" +
" \"date_mesure\":\"2013-06-20\"\n" +
" }\n" +
" ]\n" +
"} ");
        instance.getSuperficies();
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getSuperficieMaximale method, of class LancementProgramme.
     */
    @Test
    public void testGetSuperficieMaximale() throws Exception {
        System.out.println("getSuperficieMaximale");
        LancementProgramme instance = new LancementProgramme("  {\n" +
" \"type_terrain\":2,\n" +
" \"prix_m2_min\":\"3.45 $\",\n" +
" \"prix_m2_max\":\"7.00 $\",\n" +
" \"lotissements\":[\n" +
" {\n" +
" \"description\":\"lot 1\",\n" +
" \"nombre_droits_passage\":4,\n" +
" \"nombre_services\":0,\n" +
" \"superficie\":465,\n" +
" \"date_mesure\":\"2015-10-14\"\n" +
" },\n" +
" {\n" +
" \"description\":\" lot 2\",\n" +
" \"nombre_droits_passage\":0,\n" +
" \"nombre_services\":1,\n" +
" \"superficie\":1082,\n" +
" \"date_mesure\":\"2015-12-15\"\n" +
" },\n" +
" {\n" +
" \"description\":\"lot 3\",\n" +
" \"nombre_droits_passage\":8,\n" +
" \"nombre_services\":3,\n" +
" \"superficie\":3333,\n" +
" \"date_mesure\":\"2013-06-20\"\n" +
" }\n" +
" ]\n" +
"} ");
        instance.getSuperficieMaximale();
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getDates method, of class LancementProgramme.
     */
    @Test
    public void testGetDates() throws Exception {
        System.out.println("getDates");
        LancementProgramme instance = new LancementProgramme("  {\n" +
" \"type_terrain\":2,\n" +
" \"prix_m2_min\":\"3.45 $\",\n" +
" \"prix_m2_max\":\"7.00 $\",\n" +
" \"lotissements\":[\n" +
" {\n" +
" \"description\":\"lot 1\",\n" +
" \"nombre_droits_passage\":4,\n" +
" \"nombre_services\":0,\n" +
" \"superficie\":465,\n" +
" \"date_mesure\":\"2015-10-14\"\n" +
" },\n" +
" {\n" +
" \"description\":\" lot 2\",\n" +
" \"nombre_droits_passage\":0,\n" +
" \"nombre_services\":1,\n" +
" \"superficie\":1082,\n" +
" \"date_mesure\":\"2015-12-15\"\n" +
" },\n" +
" {\n" +
" \"description\":\"lot 3\",\n" +
" \"nombre_droits_passage\":8,\n" +
" \"nombre_services\":3,\n" +
" \"superficie\":3333,\n" +
" \"date_mesure\":\"2013-06-20\"\n" +
" }\n" +
" ]\n" +
"} ");
        instance.getDates();
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getMontantsLot method, of class LancementProgramme.
     */
    @Test
    public void testGetMontantsLot() throws Exception {
        System.out.println("getMontantsLot");
        LancementProgramme instance = new LancementProgramme("  {\n" +
" \"type_terrain\":2,\n" +
" \"prix_m2_min\":\"3.45 $\",\n" +
" \"prix_m2_max\":\"7.00 $\",\n" +
" \"lotissements\":[\n" +
" {\n" +
" \"description\":\"lot 1\",\n" +
" \"nombre_droits_passage\":4,\n" +
" \"nombre_services\":0,\n" +
" \"superficie\":465,\n" +
" \"date_mesure\":\"2015-10-14\"\n" +
" },\n" +
" {\n" +
" \"description\":\" lot 2\",\n" +
" \"nombre_droits_passage\":0,\n" +
" \"nombre_services\":1,\n" +
" \"superficie\":1082,\n" +
" \"date_mesure\":\"2015-12-15\"\n" +
" },\n" +
" {\n" +
" \"description\":\"lot 3\",\n" +
" \"nombre_droits_passage\":8,\n" +
" \"nombre_services\":3,\n" +
" \"superficie\":3333,\n" +
" \"date_mesure\":\"2013-06-20\"\n" +
" }\n" +
" ]\n" +
"} ");
        instance.getMontantsLot();
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getMontantsPassage method, of class LancementProgramme.
     */
    @Test
    public void testGetMontantsPassage() throws Exception {
        System.out.println("getMontantsPassage");
        LancementProgramme instance = new LancementProgramme("  {\n" +
" \"type_terrain\":2,\n" +
" \"prix_m2_min\":\"3.45 $\",\n" +
" \"prix_m2_max\":\"7.00 $\",\n" +
" \"lotissements\":[\n" +
" {\n" +
" \"description\":\"lot 1\",\n" +
" \"nombre_droits_passage\":4,\n" +
" \"nombre_services\":0,\n" +
" \"superficie\":465,\n" +
" \"date_mesure\":\"2015-10-14\"\n" +
" },\n" +
" {\n" +
" \"description\":\" lot 2\",\n" +
" \"nombre_droits_passage\":0,\n" +
" \"nombre_services\":1,\n" +
" \"superficie\":1082,\n" +
" \"date_mesure\":\"2015-12-15\"\n" +
" },\n" +
" {\n" +
" \"description\":\"lot 3\",\n" +
" \"nombre_droits_passage\":8,\n" +
" \"nombre_services\":3,\n" +
" \"superficie\":3333,\n" +
" \"date_mesure\":\"2013-06-20\"\n" +
" }\n" +
" ]\n" +
"} ");
        instance.getMontantsPassage();
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getMontantsService method, of class LancementProgramme.
     */
    @Test
    public void testGetMontantsService() throws Exception {
        System.out.println("getMontantsService");
       LancementProgramme instance = new LancementProgramme("  {\n" +
" \"type_terrain\":2,\n" +
" \"prix_m2_min\":\"3.45 $\",\n" +
" \"prix_m2_max\":\"7.00 $\",\n" +
" \"lotissements\":[\n" +
" {\n" +
" \"description\":\"lot 1\",\n" +
" \"nombre_droits_passage\":4,\n" +
" \"nombre_services\":0,\n" +
" \"superficie\":465,\n" +
" \"date_mesure\":\"2015-10-14\"\n" +
" },\n" +
" {\n" +
" \"description\":\" lot 2\",\n" +
" \"nombre_droits_passage\":0,\n" +
" \"nombre_services\":1,\n" +
" \"superficie\":1082,\n" +
" \"date_mesure\":\"2015-12-15\"\n" +
" },\n" +
" {\n" +
" \"description\":\"lot 3\",\n" +
" \"nombre_droits_passage\":8,\n" +
" \"nombre_services\":3,\n" +
" \"superficie\":3333,\n" +
" \"date_mesure\":\"2013-06-20\"\n" +
" }\n" +
" ]\n" +
"} ");
        instance.getMontantsService();
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getMontantsParLot method, of class LancementProgramme.
     */
    @Test
    public void testGetMontantsParLot() throws Exception {
        System.out.println("getMontantsParLot");
        LancementProgramme instance = new LancementProgramme("  {\n" +
" \"type_terrain\":2,\n" +
" \"prix_m2_min\":\"3.45 $\",\n" +
" \"prix_m2_max\":\"7.00 $\",\n" +
" \"lotissements\":[\n" +
" {\n" +
" \"description\":\"lot 1\",\n" +
" \"nombre_droits_passage\":4,\n" +
" \"nombre_services\":0,\n" +
" \"superficie\":465,\n" +
" \"date_mesure\":\"2015-10-14\"\n" +
" },\n" +
" {\n" +
" \"description\":\" lot 2\",\n" +
" \"nombre_droits_passage\":0,\n" +
" \"nombre_services\":1,\n" +
" \"superficie\":1082,\n" +
" \"date_mesure\":\"2015-12-15\"\n" +
" },\n" +
" {\n" +
" \"description\":\"lot 3\",\n" +
" \"nombre_droits_passage\":8,\n" +
" \"nombre_services\":3,\n" +
" \"superficie\":3333,\n" +
" \"date_mesure\":\"2013-06-20\"\n" +
" }\n" +
" ]\n" +
"} ");
        instance.getMontantsParLot();
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getValeurLotMaximale method, of class LancementProgramme.
     */
    @Test
    public void testGetValeurLotMaximale() throws Exception {
        System.out.println("getValeurLotMaximale");
        LancementProgramme instance = new LancementProgramme("  {\n" +
" \"type_terrain\":2,\n" +
" \"prix_m2_min\":\"3.45 $\",\n" +
" \"prix_m2_max\":\"7.00 $\",\n" +
" \"lotissements\":[\n" +
" {\n" +
" \"description\":\"lot 1\",\n" +
" \"nombre_droits_passage\":4,\n" +
" \"nombre_services\":0,\n" +
" \"superficie\":465,\n" +
" \"date_mesure\":\"2015-10-14\"\n" +
" },\n" +
" {\n" +
" \"description\":\" lot 2\",\n" +
" \"nombre_droits_passage\":0,\n" +
" \"nombre_services\":1,\n" +
" \"superficie\":1082,\n" +
" \"date_mesure\":\"2015-12-15\"\n" +
" },\n" +
" {\n" +
" \"description\":\"lot 3\",\n" +
" \"nombre_droits_passage\":8,\n" +
" \"nombre_services\":3,\n" +
" \"superficie\":3333,\n" +
" \"date_mesure\":\"2013-06-20\"\n" +
" }\n" +
" ]\n" +
"} ");
        instance.getValeurLotMaximale();
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getMontantTerrain method, of class LancementProgramme.
     */
    @Test
    public void testGetMontantTerrain() throws Exception {
        System.out.println("getMontantTerrain");
        LancementProgramme instance = new LancementProgramme("  {\n" +
" \"type_terrain\":2,\n" +
" \"prix_m2_min\":\"3.45 $\",\n" +
" \"prix_m2_max\":\"7.00 $\",\n" +
" \"lotissements\":[\n" +
" {\n" +
" \"description\":\"lot 1\",\n" +
" \"nombre_droits_passage\":4,\n" +
" \"nombre_services\":0,\n" +
" \"superficie\":465,\n" +
" \"date_mesure\":\"2015-10-14\"\n" +
" },\n" +
" {\n" +
" \"description\":\" lot 2\",\n" +
" \"nombre_droits_passage\":0,\n" +
" \"nombre_services\":1,\n" +
" \"superficie\":1082,\n" +
" \"date_mesure\":\"2015-12-15\"\n" +
" },\n" +
" {\n" +
" \"description\":\"lot 3\",\n" +
" \"nombre_droits_passage\":8,\n" +
" \"nombre_services\":3,\n" +
" \"superficie\":3333,\n" +
" \"date_mesure\":\"2013-06-20\"\n" +
" }\n" +
" ]\n" +
"} ");
        instance.getMontantTerrain();
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getMontantTaxeScolaire method, of class LancementProgramme.
     */
    @Test
    public void testGetMontantTaxeScolaire() throws Exception {
        System.out.println("getMontantTaxeScolaire");
        LancementProgramme instance = new LancementProgramme("  {\n" +
" \"type_terrain\":2,\n" +
" \"prix_m2_min\":\"3.45 $\",\n" +
" \"prix_m2_max\":\"7.00 $\",\n" +
" \"lotissements\":[\n" +
" {\n" +
" \"description\":\"lot 1\",\n" +
" \"nombre_droits_passage\":4,\n" +
" \"nombre_services\":0,\n" +
" \"superficie\":465,\n" +
" \"date_mesure\":\"2015-10-14\"\n" +
" },\n" +
" {\n" +
" \"description\":\" lot 2\",\n" +
" \"nombre_droits_passage\":0,\n" +
" \"nombre_services\":1,\n" +
" \"superficie\":1082,\n" +
" \"date_mesure\":\"2015-12-15\"\n" +
" },\n" +
" {\n" +
" \"description\":\"lot 3\",\n" +
" \"nombre_droits_passage\":8,\n" +
" \"nombre_services\":3,\n" +
" \"superficie\":3333,\n" +
" \"date_mesure\":\"2013-06-20\"\n" +
" }\n" +
" ]\n" +
"} ");
        instance.getMontantTaxeScolaire();
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getMontantTaxeMunicipale method, of class LancementProgramme.
     */
    @Test
    public void testGetMontantTaxeMunicipale() throws Exception {
        System.out.println("getMontantTaxeMunicipale");
        LancementProgramme instance = new LancementProgramme("  {\n" +
" \"type_terrain\":2,\n" +
" \"prix_m2_min\":\"3.45 $\",\n" +
" \"prix_m2_max\":\"7.00 $\",\n" +
" \"lotissements\":[\n" +
" {\n" +
" \"description\":\"lot 1\",\n" +
" \"nombre_droits_passage\":4,\n" +
" \"nombre_services\":0,\n" +
" \"superficie\":465,\n" +
" \"date_mesure\":\"2015-10-14\"\n" +
" },\n" +
" {\n" +
" \"description\":\" lot 2\",\n" +
" \"nombre_droits_passage\":0,\n" +
" \"nombre_services\":1,\n" +
" \"superficie\":1082,\n" +
" \"date_mesure\":\"2015-12-15\"\n" +
" },\n" +
" {\n" +
" \"description\":\"lot 3\",\n" +
" \"nombre_droits_passage\":8,\n" +
" \"nombre_services\":3,\n" +
" \"superficie\":3333,\n" +
" \"date_mesure\":\"2013-06-20\"\n" +
" }\n" +
" ]\n" +
"} ");
        instance.getMontantTaxeMunicipale();
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getDescriptionLotDispendieux method, of class LancementProgramme.
     */
    @Test
    public void testGetDescriptionLotDispendieux() throws Exception {
        System.out.println("getDescriptionLotDispendieux");
        LancementProgramme instance = new LancementProgramme("  {\n" +
" \"type_terrain\":2,\n" +
" \"prix_m2_min\":\"3.45 $\",\n" +
" \"prix_m2_max\":\"7.00 $\",\n" +
" \"lotissements\":[\n" +
" {\n" +
" \"description\":\"lot 1\",\n" +
" \"nombre_droits_passage\":4,\n" +
" \"nombre_services\":0,\n" +
" \"superficie\":465,\n" +
" \"date_mesure\":\"2015-10-14\"\n" +
" },\n" +
" {\n" +
" \"description\":\" lot 2\",\n" +
" \"nombre_droits_passage\":0,\n" +
" \"nombre_services\":1,\n" +
" \"superficie\":1082,\n" +
" \"date_mesure\":\"2015-12-15\"\n" +
" },\n" +
" {\n" +
" \"description\":\"lot 3\",\n" +
" \"nombre_droits_passage\":8,\n" +
" \"nombre_services\":3,\n" +
" \"superficie\":3333,\n" +
" \"date_mesure\":\"2013-06-20\"\n" +
" }\n" +
" ]\n" +
"} ");
        instance.getDescriptionLotDispendieux();
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getEcartMaximal method, of class LancementProgramme.
     */
    @Test
    public void testGetEcartMaximal() throws Exception {
        System.out.println("getEcartMaximal");
        LancementProgramme instance = new LancementProgramme("  {\n" +
" \"type_terrain\":2,\n" +
" \"prix_m2_min\":\"3.45 $\",\n" +
" \"prix_m2_max\":\"7.00 $\",\n" +
" \"lotissements\":[\n" +
" {\n" +
" \"description\":\"lot 1\",\n" +
" \"nombre_droits_passage\":4,\n" +
" \"nombre_services\":0,\n" +
" \"superficie\":465,\n" +
" \"date_mesure\":\"2015-10-14\"\n" +
" },\n" +
" {\n" +
" \"description\":\" lot 2\",\n" +
" \"nombre_droits_passage\":0,\n" +
" \"nombre_services\":1,\n" +
" \"superficie\":1082,\n" +
" \"date_mesure\":\"2015-12-15\"\n" +
" },\n" +
" {\n" +
" \"description\":\"lot 3\",\n" +
" \"nombre_droits_passage\":8,\n" +
" \"nombre_services\":3,\n" +
" \"superficie\":3333,\n" +
" \"date_mesure\":\"2013-06-20\"\n" +
" }\n" +
" ]\n" +
"} ");
        instance.getEcartMaximal();
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getValeurFonciere method, of class LancementProgramme.
     */
    @Test
    public void testGetValeurFonciere() throws Exception {
        System.out.println("getValeurFonciere");
       LancementProgramme instance = new LancementProgramme("  {\n" +
" \"type_terrain\":2,\n" +
" \"prix_m2_min\":\"3.45 $\",\n" +
" \"prix_m2_max\":\"7.00 $\",\n" +
" \"lotissements\":[\n" +
" {\n" +
" \"description\":\"lot 1\",\n" +
" \"nombre_droits_passage\":4,\n" +
" \"nombre_services\":0,\n" +
" \"superficie\":465,\n" +
" \"date_mesure\":\"2015-10-14\"\n" +
" },\n" +
" {\n" +
" \"description\":\" lot 2\",\n" +
" \"nombre_droits_passage\":0,\n" +
" \"nombre_services\":1,\n" +
" \"superficie\":1082,\n" +
" \"date_mesure\":\"2015-12-15\"\n" +
" },\n" +
" {\n" +
" \"description\":\"lot 3\",\n" +
" \"nombre_droits_passage\":8,\n" +
" \"nombre_services\":3,\n" +
" \"superficie\":3333,\n" +
" \"date_mesure\":\"2013-06-20\"\n" +
" }\n" +
" ]\n" +
"} ");
        instance.getValeurFonciere();
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getSuperficeParLot method, of class LancementProgramme.
     */
    @Test
    public void testGetSuperficeParLot() throws Exception {
        System.out.println("getSuperficeParLot");
        LancementProgramme instance = new LancementProgramme("  {\n" +
" \"type_terrain\":2,\n" +
" \"prix_m2_min\":\"3.45 $\",\n" +
" \"prix_m2_max\":\"7.00 $\",\n" +
" \"lotissements\":[\n" +
" {\n" +
" \"description\":\"lot 1\",\n" +
" \"nombre_droits_passage\":4,\n" +
" \"nombre_services\":0,\n" +
" \"superficie\":465,\n" +
" \"date_mesure\":\"2015-10-14\"\n" +
" },\n" +
" {\n" +
" \"description\":\" lot 2\",\n" +
" \"nombre_droits_passage\":0,\n" +
" \"nombre_services\":1,\n" +
" \"superficie\":1082,\n" +
" \"date_mesure\":\"2015-12-15\"\n" +
" },\n" +
" {\n" +
" \"description\":\"lot 3\",\n" +
" \"nombre_droits_passage\":8,\n" +
" \"nombre_services\":3,\n" +
" \"superficie\":3333,\n" +
" \"date_mesure\":\"2013-06-20\"\n" +
" }\n" +
" ]\n" +
"} ");
        instance.getSuperficeParLot();
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getTaxeMunicipaleDouble method, of class LancementProgramme.
     */
    @Test
    public void testGetTaxeMunicipaleDouble() throws Exception {
        System.out.println("getTaxeMunicipaleDouble");
        LancementProgramme instance = new LancementProgramme("  {\n" +
" \"type_terrain\":2,\n" +
" \"prix_m2_min\":\"3.45 $\",\n" +
" \"prix_m2_max\":\"7.00 $\",\n" +
" \"lotissements\":[\n" +
" {\n" +
" \"description\":\"lot 1\",\n" +
" \"nombre_droits_passage\":4,\n" +
" \"nombre_services\":0,\n" +
" \"superficie\":465,\n" +
" \"date_mesure\":\"2015-10-14\"\n" +
" },\n" +
" {\n" +
" \"description\":\" lot 2\",\n" +
" \"nombre_droits_passage\":0,\n" +
" \"nombre_services\":1,\n" +
" \"superficie\":1082,\n" +
" \"date_mesure\":\"2015-12-15\"\n" +
" },\n" +
" {\n" +
" \"description\":\"lot 3\",\n" +
" \"nombre_droits_passage\":8,\n" +
" \"nombre_services\":3,\n" +
" \"superficie\":3333,\n" +
" \"date_mesure\":\"2013-06-20\"\n" +
" }\n" +
" ]\n" +
"} ");
        instance.getTaxeMunicipaleDouble();
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getTaxeScolaireDouble method, of class LancementProgramme.
     */
    @Test
    public void testGetTaxeScolaireDouble() throws Exception {
        System.out.println("getTaxeScolaireDouble");
        LancementProgramme instance = new LancementProgramme("  {\n" +
" \"type_terrain\":2,\n" +
" \"prix_m2_min\":\"3.45 $\",\n" +
" \"prix_m2_max\":\"7.00 $\",\n" +
" \"lotissements\":[\n" +
" {\n" +
" \"description\":\"lot 1\",\n" +
" \"nombre_droits_passage\":4,\n" +
" \"nombre_services\":0,\n" +
" \"superficie\":465,\n" +
" \"date_mesure\":\"2015-10-14\"\n" +
" },\n" +
" {\n" +
" \"description\":\" lot 2\",\n" +
" \"nombre_droits_passage\":0,\n" +
" \"nombre_services\":1,\n" +
" \"superficie\":1082,\n" +
" \"date_mesure\":\"2015-12-15\"\n" +
" },\n" +
" {\n" +
" \"description\":\"lot 3\",\n" +
" \"nombre_droits_passage\":8,\n" +
" \"nombre_services\":3,\n" +
" \"superficie\":3333,\n" +
" \"date_mesure\":\"2013-06-20\"\n" +
" }\n" +
" ]\n" +
"} ");
        instance.getTaxeScolaireDouble();
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getTaxePrixMinMaxDouble method, of class LancementProgramme.
     */
    @Test
    public void testGetTaxePrixMinMaxDouble() throws Exception {
        System.out.println("getTaxePrixMinMaxDouble");
        LancementProgramme instance = new LancementProgramme("  {\n" +
" \"type_terrain\":2,\n" +
" \"prix_m2_min\":\"3.45 $\",\n" +
" \"prix_m2_max\":\"7.00 $\",\n" +
" \"lotissements\":[\n" +
" {\n" +
" \"description\":\"lot 1\",\n" +
" \"nombre_droits_passage\":4,\n" +
" \"nombre_services\":0,\n" +
" \"superficie\":465,\n" +
" \"date_mesure\":\"2015-10-14\"\n" +
" },\n" +
" {\n" +
" \"description\":\" lot 2\",\n" +
" \"nombre_droits_passage\":0,\n" +
" \"nombre_services\":1,\n" +
" \"superficie\":1082,\n" +
" \"date_mesure\":\"2015-12-15\"\n" +
" },\n" +
" {\n" +
" \"description\":\"lot 3\",\n" +
" \"nombre_droits_passage\":8,\n" +
" \"nombre_services\":3,\n" +
" \"superficie\":3333,\n" +
" \"date_mesure\":\"2013-06-20\"\n" +
" }\n" +
" ]\n" +
"} ");
        instance.getTaxePrixMinMaxDouble();
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of rapporterSiBon method, of class LancementProgramme.
     */
    @Test
    public void testRapporterSiBon() throws Exception {
        System.out.println("rapporterSiBon");
       LancementProgramme instance = new LancementProgramme("  {\n" +
" \"type_terrain\":2,\n" +
" \"prix_m2_min\":\"3.45 $\",\n" +
" \"prix_m2_max\":\"7.00 $\",\n" +
" \"lotissements\":[\n" +
" {\n" +
" \"description\":\"lot 1\",\n" +
" \"nombre_droits_passage\":4,\n" +
" \"nombre_services\":0,\n" +
" \"superficie\":465,\n" +
" \"date_mesure\":\"2015-10-14\"\n" +
" },\n" +
" {\n" +
" \"description\":\" lot 2\",\n" +
" \"nombre_droits_passage\":0,\n" +
" \"nombre_services\":1,\n" +
" \"superficie\":1082,\n" +
" \"date_mesure\":\"2015-12-15\"\n" +
" },\n" +
" {\n" +
" \"description\":\"lot 3\",\n" +
" \"nombre_droits_passage\":8,\n" +
" \"nombre_services\":3,\n" +
" \"superficie\":3333,\n" +
" \"date_mesure\":\"2013-06-20\"\n" +
" }\n" +
" ]\n" +
"} ");
        instance.rapporterSiBon();
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of afficherRapport method, of class LancementProgramme.
     */
    @Test
    public void testAfficherRapport() throws Exception{
        System.out.println("afficherRapport");
        LancementProgramme instance = new LancementProgramme("  {\n" +
" \"type_terrain\":2,\n" +
" \"prix_m2_min\":\"3.45 $\",\n" +
" \"prix_m2_max\":\"7.00 $\",\n" +
" \"lotissements\":[\n" +
" {\n" +
" \"description\":\"lot 1\",\n" +
" \"nombre_droits_passage\":4,\n" +
" \"nombre_services\":0,\n" +
" \"superficie\":465,\n" +
" \"date_mesure\":\"2015-10-14\"\n" +
" },\n" +
" {\n" +
" \"description\":\" lot 2\",\n" +
" \"nombre_droits_passage\":0,\n" +
" \"nombre_services\":1,\n" +
" \"superficie\":1082,\n" +
" \"date_mesure\":\"2015-12-15\"\n" +
" },\n" +
" {\n" +
" \"description\":\"lot 3\",\n" +
" \"nombre_droits_passage\":8,\n" +
" \"nombre_services\":3,\n" +
" \"superficie\":3333,\n" +
" \"date_mesure\":\"2013-06-20\"\n" +
" }\n" +
" ]\n" +
"} ");
        instance.afficherRapport();
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of enregisterRapportDansFichier method, of class LancementProgramme.
     */
    @Test
    public void testEnregisterRapportDansFichier() throws Exception {
        System.out.println("enregisterRapportDansFichier");
        String json = "C:\\Documents\\fichier";
        LancementProgramme instance = new LancementProgramme("  {\n" +
" \"type_terrain\":2,\n" +
" \"prix_m2_min\":\"3.45 $\",\n" +
" \"prix_m2_max\":\"7.00 $\",\n" +
" \"lotissements\":[\n" +
" {\n" +
" \"description\":\"lot 1\",\n" +
" \"nombre_droits_passage\":4,\n" +
" \"nombre_services\":0,\n" +
" \"superficie\":465,\n" +
" \"date_mesure\":\"2015-10-14\"\n" +
" },\n" +
" {\n" +
" \"description\":\" lot 2\",\n" +
" \"nombre_droits_passage\":0,\n" +
" \"nombre_services\":1,\n" +
" \"superficie\":1082,\n" +
" \"date_mesure\":\"2015-12-15\"\n" +
" },\n" +
" {\n" +
" \"description\":\"lot 3\",\n" +
" \"nombre_droits_passage\":8,\n" +
" \"nombre_services\":3,\n" +
" \"superficie\":3333,\n" +
" \"date_mesure\":\"2013-06-20\"\n" +
" }\n" +
" ]\n" +
"} ");
        instance.enregisterRapportDansFichier(json);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getPrixReparti method, of class LancementProgramme.
     */
    @Test
    public void testGetPrixReparti() throws Exception {
        System.out.println("getPrixReparti");
        LancementProgramme instance = new LancementProgramme("  {\n" +
" \"type_terrain\":2,\n" +
" \"prix_m2_min\":\"3.45 $\",\n" +
" \"prix_m2_max\":\"7.00 $\",\n" +
" \"lotissements\":[\n" +
" {\n" +
" \"description\":\"lot 1\",\n" +
" \"nombre_droits_passage\":4,\n" +
" \"nombre_services\":0,\n" +
" \"superficie\":465,\n" +
" \"date_mesure\":\"2015-10-14\"\n" +
" },\n" +
" {\n" +
" \"description\":\" lot 2\",\n" +
" \"nombre_droits_passage\":0,\n" +
" \"nombre_services\":1,\n" +
" \"superficie\":1082,\n" +
" \"date_mesure\":\"2015-12-15\"\n" +
" },\n" +
" {\n" +
" \"description\":\"lot 3\",\n" +
" \"nombre_droits_passage\":8,\n" +
" \"nombre_services\":3,\n" +
" \"superficie\":3333,\n" +
" \"date_mesure\":\"2013-06-20\"\n" +
" }\n" +
" ]\n" +
"} ");
        instance.getPrixReparti();
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of obenirCalculRapportStatistiques method, of class LancementProgramme.
     */
    @Test
    public void testObenirCalculRapportStatistiques() throws Exception {
        System.out.println("obenirCalculRapportStatistiques");
        LancementProgramme instance = new LancementProgramme("  {\n" +
" \"type_terrain\":2,\n" +
" \"prix_m2_min\":\"3.45 $\",\n" +
" \"prix_m2_max\":\"7.00 $\",\n" +
" \"lotissements\":[\n" +
" {\n" +
" \"description\":\"lot 1\",\n" +
" \"nombre_droits_passage\":4,\n" +
" \"nombre_services\":0,\n" +
" \"superficie\":465,\n" +
" \"date_mesure\":\"2015-10-14\"\n" +
" },\n" +
" {\n" +
" \"description\":\" lot 2\",\n" +
" \"nombre_droits_passage\":0,\n" +
" \"nombre_services\":1,\n" +
" \"superficie\":1082,\n" +
" \"date_mesure\":\"2015-12-15\"\n" +
" },\n" +
" {\n" +
" \"description\":\"lot 3\",\n" +
" \"nombre_droits_passage\":8,\n" +
" \"nombre_services\":3,\n" +
" \"superficie\":3333,\n" +
" \"date_mesure\":\"2013-06-20\"\n" +
" }\n" +
" ]\n" +
"} ");
        instance.obenirCalculRapportStatistiques();
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
