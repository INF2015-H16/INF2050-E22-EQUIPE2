/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inf2050.e22.equipe2;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


/**
 * Université du Québec à Montréal (UQAM)
 * Cours : INF2050 - 020 - Été 2022
 * Sprint 1
 *
 * EvaluationTerrain : Cette classe contient les données sur la description,
 *                le nombre de droits de passage, le nombre de services,
 *                la superficie, la date de mesure des lots,
 *                ainsi que, le type de terrain, les prix min et max.
 *                Elle permet de calculer la valeur foncière du
 *                terrain ainsi que les taxes scolaire et municipale.
 *
 *
 * @author Achou Henri Joël / Akaffou
 * @version 19 mai 2022
 *
 */
public class EvaluationTerrain {
    
    public final static String FILE_ENCODING = "UTF-8";

    public final static double VALEUR_DE_BASE = 733.77;
    public final static double TAXE_SCOLAIRE = 0.012;
    public final static double TAXE_MUNICIPALE = 0.025;
    public static final double SERVICE_DE_BASE = 2;
    public final static int MONTANT_BASE_DROIT_PASSAGE = 500;
    public final static double TAUX_05 = 0.05;
    public final static double TAUX_10 = 0.10;
    public final static double TAUX_15 = 0.15;
    public static final int SUPERFICIE_500 = 500;
    public static final int SUPERFICIE_10000 = 10000;
    public static final double MONTANT_SERVICE_0 = 0.0;
    public static final double MONTANT_SERVICE_500 = 500;
    public static final double MONTANT_SERVICE_1000 = 1000;
    public static final double MONTANT_SERVICE_1500 = 1500;
    public static final double MONTANT_MAX_SERVICE = 5000;
    
    public final static String ETIQUETTE_LOT = "lot ";
    public final static String ETIQUETTE_DESCRIPTION = "description";
    public final static String ETIQUETTE_DROIT_PASSAGE =
            "nombre_droits_passage";
    public final static String ETIQUETTE_SERVICES = "nombre_services";
    public final static String ETIQUETTE_SUPERFICIE = "superficie";
    public final static String ETIQUETTE_DATE_MESURE = "date_mesure";

    public final static String ETIQUETTE_TYPE_TERRAIN = "type_terrain";
    public final static String ETIQUETTE_PRIX_M2_MIN = "prix_m2_min";
    public final static String ETIQUETTE_PRIX_M2_MAX = "prix_m2_max";
    public final static String ETIQUETTE_LOTISSEMENTS = "lotissements";

    public final static String ETIQUETTE_VALEUR_FONCIERE_TOTALE =
            "valeur_fonciere_totale";
    public final static String ETIQUETTE_TAXE_SCOLAIRE = "taxe_scolaire";
    public final static String ETIQUETTE_TAXE_MUNICIPALE = "taxe_municipale";
    public final static String ETIQUETTE_VALEUR_PAR_LOT = "valeur_par_lot";

    public final static String DECIMAL_ONLY = "[^\\d.]";
    
    private static Terrain terrain;
    private static ArrayList<Lotissement> lotissements;

    private static int taille;

    private int idTerrain;
    private double prixMinimum;
    private double prixMaximum;
    private double montantTerrain;
    private double montantTaxeScolaire;
    private double montantTaxeMunicipale;

    private double [] montantsLot;
    private double [] montantsPassage;
    private double [] montantsService;
    private double [] montantsParLot;
    private String [] descriptions;
    private int [] passages;
    private int [] services;
    private int [] superficies;
    private String [] dates;
    
    public static void lireFichierEntree(String argument)
            throws FileNotFoundException, IOException,
            NumberFormatException, IntervallesValideException,
            PrixValideException, LotValideException {
        
        String description;
        int nombreDroitPassage;
        int nombreService;
        int superfice;
        String dateMesure;
        Lotissement lot;

        String json = FileReaderException.loadFileIntoString(argument,
                FILE_ENCODING);

        if (json.length() != 0) {
            JSONObject enteteTerrain = JSONObject.fromObject(json);
            
            int typeTerrain = VerificationDonnee
                    .valeurEstInt(enteteTerrain.getInt(ETIQUETTE_TYPE_TERRAIN));
            String prixMin = VerificationDonnee.
                    validerPrix(enteteTerrain.getString(ETIQUETTE_PRIX_M2_MIN));
            String priMax = VerificationDonnee.
                    validerPrix(enteteTerrain.getString(ETIQUETTE_PRIX_M2_MAX));

            lotissements = new ArrayList<>();

            Object item = enteteTerrain.get(ETIQUETTE_LOTISSEMENTS);

            if (item instanceof JSONObject) {
                JSONObject uniqueLot = enteteTerrain
                        .getJSONObject(ETIQUETTE_LOTISSEMENTS);

                description = VerificationDonnee
                        .validerDescriptionLot(uniqueLot.getString(ETIQUETTE_DESCRIPTION));
                nombreDroitPassage = VerificationDonnee
                        .valeurEstInt(uniqueLot.getInt(ETIQUETTE_DROIT_PASSAGE));
                nombreService = VerificationDonnee
                        .valeurEstInt(uniqueLot.getInt(ETIQUETTE_SERVICES));
                superfice = VerificationDonnee
                        .valeurEstInt(uniqueLot.getInt(ETIQUETTE_SUPERFICIE));
                dateMesure = VerificationDonnee
                        .validerDateMesure(uniqueLot.getString(ETIQUETTE_DATE_MESURE));

                lot = new Lotissement(description, nombreDroitPassage,
                        nombreService, superfice, dateMesure);
                lotissements.add(lot);

            } else {
                JSONArray list = enteteTerrain.getJSONArray(ETIQUETTE_LOTISSEMENTS);

                if (!list.isEmpty()) {
                    for(int i = 0; i<list.size(); i++) {
                        JSONObject plusieursLot = list.getJSONObject(i);

                        description = VerificationDonnee
                                .validerDescriptionLot(plusieursLot.getString(ETIQUETTE_DESCRIPTION));
                        nombreDroitPassage = VerificationDonnee
                                .valeurEstInt(plusieursLot.getInt(ETIQUETTE_DROIT_PASSAGE));
                        nombreService = VerificationDonnee
                                .valeurEstInt(plusieursLot.getInt(ETIQUETTE_SERVICES));
                        superfice = VerificationDonnee
                                .valeurEstInt(plusieursLot.getInt(ETIQUETTE_SUPERFICIE));
                        dateMesure = VerificationDonnee
                                .validerDateMesure(plusieursLot.getString(ETIQUETTE_DATE_MESURE));
                        
                        lot = new Lotissement(description, nombreDroitPassage,
                                nombreService, superfice, dateMesure);
                        lotissements.add(lot);
                        
                    }
                }
            }
            
            if (VerificationDonnee.validerTypeTerrain(typeTerrain)) {
                terrain = new Terrain(typeTerrain, prixMin,
                        priMax, lotissements);
                taille = lotissements.size();
            }
        }

    }
    
    public void obtenirTypeTerrain() throws IOException, NullPointerException {
        int typeTerrain = terrain.getTypeTerrain();

        idTerrain = typeTerrain;
    }
    
    public void obtenirPrixMinimum()
            throws IOException, NullPointerException {

        String prix = terrain.getPrixMin();
        String prixMinim = prix.replaceAll(DECIMAL_ONLY, "");
        double prixMin = Double.parseDouble(prixMinim);

        prixMinimum = prixMin;

    }
    
    public void obtenirPrixMax() throws IOException, NullPointerException {
        
        String prix = terrain.getPrixMax();
        String priMaxi = prix.replaceAll(DECIMAL_ONLY, "");
        double prixMax = Double.parseDouble(priMaxi);

        prixMaximum = prixMax;

    }
    
    public void obtenirDescription() throws IOException, NullPointerException {
        
        descriptions = new String[taille];

        for (int i = 0; i < taille; i++) {
            String descriptionLot = lotissements.get(i).getDescription();
            
            descriptions[i] = descriptionLot;
        }
    }
    
    public void obtenirNombreDroitPassage() throws IOException,
            NullPointerException {
        passages = new int[taille];

        for (int i = 0; i < taille; i++) {
            int droitPassage = lotissements.get(i).getNombreDroitPassage();

            passages[i] = droitPassage;

        }
    }
    
    public void obtenirNombreService()
            throws IOException, NullPointerException {

        services = new int[taille];

        for (int i = 0; i < taille; i++) {
            int servive = lotissements.get(i).getNombreService();

            services[i] = servive;

        }
    }
    
    public void obtenirSuperficie()
            throws IOException, NullPointerException {

        superficies = new int[taille];

        for (int i = 0; i < taille; i++) {
            
            int superficie = lotissements.get(i).getSuperficie();

            superficies[i] = superficie;

        }
    }
    
    public void obtenirDateMesure()
            throws IOException, NullPointerException {

        dates = new String[taille];

        for (int i = 0; i < taille; i++) {
            String date = lotissements.get(i).getDateMesure();

            dates[i] = date;

        }
    }
    
    public void calculerMontantLot() throws IOException, NullPointerException {

        montantsLot = new double[taille];

        double montantLot = 0.0;
        
        for (int i = 0; i < taille; i++) {
            switch (idTerrain) {
                case Terrain.TERRAIN_AGRICOLE: {
                    montantLot = superficies[i] * prixMinimum;
                }
                break;
                case Terrain.TERRAIN_RESIDENTIEL: {
                    montantLot = superficies[i] *
                            ((prixMinimum + prixMaximum)/2);
                }
                break;
                case Terrain.TERRAIN_COMMERCIAL: {
                    montantLot = superficies[i] * prixMaximum;
                }
                break;
                default:
                    break;
            }
            
            montantsLot[i] = montantLot;

        }
    }
    
    public void calculerDroitPassage() throws IOException,
            NullPointerException {

        montantsPassage = new double[taille];

        double montantDroit = 0.0;
        
        for (int i = 0; i < taille; i++) {
            switch (idTerrain) {
                case Terrain.TERRAIN_AGRICOLE:  {
                
                    montantDroit = MONTANT_BASE_DROIT_PASSAGE
                            - (passages[i] * (TAUX_05 * montantsLot[i]));
                }
                break;

                case Terrain.TERRAIN_RESIDENTIEL: {
                    montantDroit = MONTANT_BASE_DROIT_PASSAGE
                            - (passages[i] * (TAUX_10 * montantsLot[i]));
                }
                break;
                case Terrain.TERRAIN_COMMERCIAL: {
                    montantDroit = MONTANT_BASE_DROIT_PASSAGE
                            - (passages[i] * (TAUX_15 * montantsLot[i]));
                }
                break;
                default:
                    break;
            }

            montantsPassage[i] = montantDroit;

        }
    }
    
    public void calculerMontantService() throws IOException,
            NullPointerException {

        montantsService = new double[taille];

        double montantService = 0.0;
        double tempService = 0.0;
        
        for (int i = 0; i < taille; i++) {
            
            switch (idTerrain) {
                case Terrain.TERRAIN_AGRICOLE: {
                    montantService = MONTANT_SERVICE_0;
                }
                break;
                case Terrain.TERRAIN_RESIDENTIEL: {
                    if (superficies[i] <= SUPERFICIE_500) {
                        montantService = MONTANT_SERVICE_0;
                    } else if (superficies[i] > SUPERFICIE_500
                            && superficies[i] <= SUPERFICIE_10000) {
                        montantService = (SERVICE_DE_BASE
                            + services[i]) * MONTANT_SERVICE_500;
                    } else {
                        montantService = (SERVICE_DE_BASE
                            + services[i]) * MONTANT_SERVICE_1000;
                    }
                }
                break;
                case Terrain.TERRAIN_COMMERCIAL: {
                    if (superficies[i] <= SUPERFICIE_500) {
                        tempService = (SERVICE_DE_BASE
                                + services[i]) * MONTANT_SERVICE_500;
                    } else if (superficies[i] > SUPERFICIE_500) {
                        tempService = (SERVICE_DE_BASE
                                + services[i]) * MONTANT_SERVICE_1500;
                    }

                    if (tempService > MONTANT_MAX_SERVICE) {
                        montantService = MONTANT_MAX_SERVICE;
                    } else {
                        montantService = tempService;
                    }
                }
                break;
                default:
                    break;
            }

            montantsService[i] = montantService;

        }

    }
    
    public void calculerValeurParLot() throws IOException,
            NullPointerException {

        montantsParLot = new double[taille];

        for (int i = 0; i < taille; i++) {
            double valeurParLot = montantsLot[i] + montantsPassage[i] +
                    montantsService[i];

            montantsParLot[i] = valeurParLot;

        }

    }
    
    public void calculerValeurFonciere() throws IOException,
            NullPointerException {
        double tempTerrain = 0.0;

        for (int i = 0; i < taille; i++) {
            tempTerrain = tempTerrain + montantsParLot[i]++;
        }

        montantTerrain = (tempTerrain + VALEUR_DE_BASE);

    }
    
    public void calculerTaxeScolaire() throws IOException,
            NullPointerException {
        montantTaxeScolaire = montantTerrain * TAXE_SCOLAIRE;
    }
    
    public void calculerTaxeMunicipale() throws IOException {
        montantTaxeMunicipale = montantTerrain * TAXE_MUNICIPALE;
    }
    
    public void genererRapportEvaluation(String argument)
            throws IOException, LotValideException {
        
        if (VerificationDonnee.verifierLotsDoublons(descriptions)) {
            JSONObject enteteRapport = new JSONObject();
            enteteRapport.accumulate(ETIQUETTE_VALEUR_FONCIERE_TOTALE,
                    Utilitaire.convertirMontant(montantTerrain));
            enteteRapport.accumulate(ETIQUETTE_TAXE_SCOLAIRE,
                    Utilitaire.convertirMontant(montantTaxeScolaire));
            enteteRapport.accumulate(ETIQUETTE_TAXE_MUNICIPALE,
                    Utilitaire.convertirMontant(montantTaxeMunicipale));

            for (int i = 0; i < montantsParLot.length; i++) {
                JSONObject detailsLot = new JSONObject();

                detailsLot.accumulate(ETIQUETTE_DESCRIPTION, descriptions[i]);
                detailsLot.accumulate(ETIQUETTE_VALEUR_PAR_LOT,
                        Utilitaire.convertirMontant(montantsParLot[i]));

                enteteRapport.accumulate(ETIQUETTE_LOTISSEMENTS,detailsLot);
            }

            Utilitaire.afficherMessage(enteteRapport.toString(4));

            FileWriterException.saveStringIntoFile(argument,
                    enteteRapport.toString(4), FILE_ENCODING);
        }
        
    }

}