/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package inf2050.e22.equipe2;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

/**
 * Université du Québec à Montréal (UQAM)
 * Cours : INF2050 - 020 - Été 2022
 * Sprint 1
 *
 * La classe VerificationDonnee permet de faire
 * la validation de toutes les données en entrée du programme.
 *
 * @author Aurélien Tcheuffa Kemayou / Sidopz
 * @version Juin 2022
 *
 */
public class VerificationDonnee {

    public static final int SUPERFICIE_MAXIMALE = 50000;
    public static final int SUPERFICIE_MINIMALE = 0;
    public static final int NOMBRE_MAXIMAL_LOT = 10;
    public static final int NOMBRE_MINIMAL_LOT = 1;
    private final static int BORNE_INFERIEURE_TERRAIN = 0;
    private final static int BORNE_SUPERIEURE_TERRAIN = 2;
    private final static int BORNE_INFERIEURE_DROIT_PASSAGE = 0;
    private final static int BORNE_SUPERIEURE_DROIT_PASSAGE = 10;
    private final static int BORNE_INFERIEURE_SERVICE = 0;
    private final static int BORNE_SUPERIEURE_SERVICE = 5;

    private final static Object [] LIBELLE_FICHIER_ENTREE_TERRAIN
            = {EvaluationTerrain.ETIQUETTE_TYPE_TERRAIN,
            EvaluationTerrain.ETIQUETTE_PRIX_M2_MIN,
            EvaluationTerrain.ETIQUETTE_PRIX_M2_MAX,
            EvaluationTerrain.ETIQUETTE_LOTISSEMENTS};

    private final static Object [] LIBELLE_FICHIER_ENTREE_LOT
            = {EvaluationTerrain.ETIQUETTE_DESCRIPTION,
            EvaluationLot.ETIQUETTE_DROIT_PASSAGE,
            EvaluationLot.ETIQUETTE_SERVICES,
            EvaluationLot.ETIQUETTE_SUPERFICIE,
            EvaluationLot.ETIQUETTE_DATE_MESURE};
    public static final String REGEX_POUR_LOT = "^(lot)([0-9])([0-9])?$";
    public static final String REGEX_POUR_PRIX = "\\d*[,.]?\\d+\\$$";
    public static final String REGEX_POUR_DATE = "((?:19|20)[0-9][0-9])"
            +  "(0?[1-9]|1[012])(0?[1-9]|[12][0-9]|3[01])";

    public static String chargerDonneeDeFichier(String filePath,
                                                String fileEncoding)
            throws IOException {
        File file = new File(filePath);
        String fichier;
        if (!file.exists()) {
            throw new IOException(GestionnaireMessage
                    .ERREUR_FICHER_ENTREE);
        } else {
            fichier = IOUtils.toString(new FileInputStream(filePath),
                    fileEncoding);
        }

        return fichier;
    }

    public static String verifierPresenceDonnees(String fichier)
            throws NullPointerException {
        String document;
        if (fichier.equals("")) {
            throw new NullPointerException(GestionnaireMessage
                    .ERREUR_DOCUMENT_JSON_VIDE);
        } else {
            document = fichier;
        }
        return document;
    }
    
    public static String verifierContenuFichierTerrain(String fichier) {
        String document;
        JSONObject structureContenu = JSONObject.fromObject(fichier);
        if (!creerListLibelleTerrain(structureContenu)
                .equals(creerListLibelleTerrainOrigin())) {
            throw new JSONException(GestionnaireMessage
                    .ERREUR_DOCUMENT_JSON);

        } else {
            document = fichier;
        }

        return document;
    }

    private static ArrayList<String> creerListLibelleTerrain(
            JSONObject enteteTerrain) {
        ArrayList<String> lesLibelles = new ArrayList<>();
        for (Object libelle : enteteTerrain.keySet()) {
            String racine = (String) libelle;
            lesLibelles.add(racine);
        }

        return lesLibelles;
    }

    private static ArrayList<String> creerListLibelleTerrainOrigin() {
        ArrayList<String> lesLibelles = new ArrayList<>();

        for (Object libelle : LIBELLE_FICHIER_ENTREE_TERRAIN) {
            String racine = (String) libelle;
            lesLibelles.add(racine);
        }

        return lesLibelles;
    }

    public static boolean verifierContenuFichierLot(JSONObject fichier)
            throws JSONException {
        boolean estValide;

        if (!creerListLibelleLot(fichier).equals(creerListLibelleLotOrigine())) {
            throw new JSONException(GestionnaireMessage
                    .ERREUR_DOCUMENT_JSON);
        } else {
            estValide = true;
        }

        return estValide;
    }

    private static ArrayList<Object> creerListLibelleLot(
            JSONObject typeLibelle) {
        ArrayList<Object> lesLibelles = new ArrayList<>();

        for (Object libelle : typeLibelle.keySet()) {
            String racine = (String) libelle;
            lesLibelles.add(racine);

        }

        return lesLibelles;
    }

    private static ArrayList<String> creerListLibelleLotOrigine() {
        ArrayList<String> lesLibelles = new ArrayList<>();

        for (Object libelle : LIBELLE_FICHIER_ENTREE_LOT) {
            String racine = (String) libelle;
            lesLibelles.add(racine);
        }

        return lesLibelles;
    }

    public static void enregistrerDonneeDansFichier(String filePath,
                                                    String contentToSave,
                                                    String fileEncoding)
            throws LectureFichierException, IOException {
        File file = new File(filePath);

        if (estPasCheminValide(filePath, fileEncoding)) {
            throw new LectureFichierException(GestionnaireMessage
                    .ERREUR_FICHIER_SORTIE);
        } else {
            FileUtils.writeStringToFile(file, contentToSave, fileEncoding);
        }
    }

    private static boolean estPasCheminValide(String filePath,
                                              String fileEncoding) {
        return filePath == null || fileEncoding == null;
    }

    public static int validerTypeTerrain(int type)
            throws IntervallesValideException {
        int typeTerrain;

        if (estPasTypeTerrainValide(type)) {
            throw new IntervallesValideException(GestionnaireMessage
                    .choisirMessageTypeTerrain(type, BORNE_INFERIEURE_TERRAIN,
                            BORNE_SUPERIEURE_TERRAIN));
        } else {
            typeTerrain = type;
        }

        return typeTerrain;
    }

    private static int valeurEstInt(Object valeur)
            throws JSONException, NumberFormatException {

        int nombre;

        try {
            nombre = Integer.parseInt(valeur.toString());
        } catch (NumberFormatException exception){
            throw new JSONException(
                    GestionnaireMessage.ERREUR_DONNEE_PAS_NOMBRE);
        }
        return nombre;
    }

    private static boolean estPasTypeTerrainValide(int type) {
        return type < BORNE_INFERIEURE_TERRAIN
                || type > BORNE_SUPERIEURE_TERRAIN;
    }

    public static boolean validerNombreLot(int lot)
            throws IntervallesValideException {
        boolean estQuantiteLotValide;

        if (estPasNombreLotValide(lot)) {
            throw new IntervallesValideException(GestionnaireMessage
                    .choisirMessageNombreLots(lot, NOMBRE_MINIMAL_LOT,
                            NOMBRE_MAXIMAL_LOT));
        } else {
            estQuantiteLotValide = true;
        }

        return estQuantiteLotValide;
    }

    private static boolean estPasNombreLotValide(int lot) {
        return lot < NOMBRE_MINIMAL_LOT || lot > NOMBRE_MAXIMAL_LOT;
    }

    public static int validerNombreDroitPassage(int droit)
            throws IntervallesValideException {
        int droitPassage;

        if (estPasNombreDroitValide(droit)) {
            throw new IntervallesValideException(GestionnaireMessage
                    .choisirMessageDroitPassage(droit,
                            BORNE_INFERIEURE_DROIT_PASSAGE,
                            BORNE_SUPERIEURE_DROIT_PASSAGE));
        } else {
            droitPassage = droit;
        }

        return droitPassage;
    }

    private static boolean estPasNombreDroitValide(int droit) {
        return droit < BORNE_INFERIEURE_DROIT_PASSAGE
                || droit > BORNE_SUPERIEURE_DROIT_PASSAGE;
    }

    public static int validerNombreService(int service)
            throws IntervallesValideException {
        int nombreService;

        if (estPasNombreServiceValide(service)) {
            throw new IntervallesValideException(GestionnaireMessage
                    .choisirMessageServies(service, BORNE_INFERIEURE_SERVICE,
                            BORNE_SUPERIEURE_SERVICE));
        } else {
            nombreService = service;
        }

        return nombreService;
    }

    private static boolean estPasNombreServiceValide(int service) {
        return service < BORNE_INFERIEURE_SERVICE
                || service > BORNE_SUPERIEURE_SERVICE;
    }

    public static int validerSuperficie(int superficie)
            throws IntervallesValideException {
        int laSuperficie;

        if (estPasSuperficieValide(superficie)) {
            throw new IntervallesValideException(GestionnaireMessage
                    .choisirMessageSuperficie(superficie,
                    SUPERFICIE_MINIMALE, SUPERFICIE_MAXIMALE));
        } else {
            laSuperficie = superficie;
        }

        return laSuperficie;
    }

    private static boolean estPasSuperficieValide(int superficie) {
        return superficie < SUPERFICIE_MINIMALE
                || superficie > SUPERFICIE_MAXIMALE;
    }

    public static String validerDateMesure(String date)
            throws NumberFormatException{
        String dateValide;

        if (!validerDate(date)) {
            throw new NumberFormatException(GestionnaireMessage
                    .ERREUR_FORMAT_DATE);
        } else {
            dateValide = date;
        }

        return dateValide;
    }

    /**
     * Il s'agit de notre meilleure tentative pour obtenir
     * une condition de concurrence qui recherche une date
     * au format "AAAA-MM-JJ".
     */
    private static boolean validerDate(String date) {
        boolean valideDate;

        if (date.length() != 10) {
            valideDate = false;

        } else {
            valideDate = verifierExisteTiret(date);

        }

        return valideDate;
    }

    private static boolean verifierExisteTiret(String date) {
        boolean valideDate;

        if (date.charAt(4) == '-' && date.charAt(7) == '-') {
            String temp = date.replaceAll("[-]", "");
            valideDate = validerDateAvecRegex(temp);

        } else {
            valideDate = false;

        }

        return valideDate;
    }

    private static boolean validerDateAvecRegex(String temp) {
        boolean valideDate;

        if (temp.length() != 8) {
            valideDate = false;

        } else {
            valideDate = temp.matches(REGEX_POUR_DATE);

        }
        return valideDate;
    }

    public static String verifierPrixNegatif(String prix)
            throws PrixValideException {
        String validePrix;
        char premierCaractere = prix.charAt(0);

        if (premierCaractere == '-') {
            throw new PrixValideException(GestionnaireMessage
                    .ERREUR_MONTANT_ARGENT_NEGATIF);
        } else {
            validePrix = prix;
        }

        return validePrix;
    }

    public static String validerPrix(String prix)
            throws PrixValideException {
        String validePrix;
        String temp = prix.replaceAll(" ", "");

        if (!temp.matches(REGEX_POUR_PRIX)) {
            throw new PrixValideException(GestionnaireMessage
                    .ERREUR_FORMAT_MONTANT_ARGENT);
        } else {
            validePrix = prix;
        }

        return validePrix;
    }

    public static boolean comparerPrixMinimumMaximum(double prixMin,
                                                      double prixMax)
            throws PrixValideException {
        boolean estValide;
        if (prixMin > prixMax) {
            throw new PrixValideException(GestionnaireMessage
                    .ERREUR_CONFLIT_PRIX);
        } else {
            estValide = true;
        }
        return estValide;
    }

    public static String validerDescriptionLot(String descriptionLot)
            throws LotValideException {

        String valideLot;
        String temp = descriptionLot.trim().replaceAll(" ", "");

        if (!temp.matches(REGEX_POUR_LOT)) {
            throw new LotValideException(GestionnaireMessage
                    .ERREUR_DESCRIPTION_LOT);
        } else {
            valideLot = descriptionLot;
        }

        return valideLot;
    }

    public static boolean verifierLotsDoublons(
            String[] lots)
            throws LotValideException {
        boolean estValide = false;
        
        final Set<String> listLots = new HashSet<>();

        for (String lot : lots) {
            
            if (!listLots.add(lot.trim())) {
                throw new LotValideException(GestionnaireMessage
                        .ERREUR_CONFLIT_LOTS);
            } else {
                estValide = true;
            }
        }

        return estValide;
    }

}