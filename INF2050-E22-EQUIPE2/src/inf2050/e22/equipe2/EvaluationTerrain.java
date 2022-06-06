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
    
    public final static String ETIQUETTE_TYPE_TERRAIN = "type_terrain";
    public final static String ETIQUETTE_PRIX_M2_MIN = "prix_m2_min";
    public final static String ETIQUETTE_PRIX_M2_MAX = "prix_m2_max";
    
    public Terrain obtenirDonneesTerrain(String json,
            ArrayList<Lotissement> lotissements)
            throws FileNotFoundException, IOException,
            NumberFormatException, IntervallesValideException,
            PrixValideException {
        
        Terrain terrain = null;
        
        if (json.length() != 0) {
            JSONObject enteteTerrain = JSONObject.fromObject(json);
            
            int typeTerrain = VerificationDonnee
                    .valeurEstInt(enteteTerrain
                            .getInt(ETIQUETTE_TYPE_TERRAIN));
            String prixMin = VerificationDonnee.
                    validerPrix(enteteTerrain
                            .getString(ETIQUETTE_PRIX_M2_MIN));
            String priMax = VerificationDonnee.
                    validerPrix(enteteTerrain
                            .getString(ETIQUETTE_PRIX_M2_MAX));
            
            if (VerificationDonnee.validerTypeTerrain(typeTerrain)) {
                terrain = new Terrain(typeTerrain, prixMin,
                        priMax, lotissements);
            }
        }
        
        return terrain;

    }
    
    public final static String ETIQUETTE_LOT = "lot ";
    public final static String ETIQUETTE_DESCRIPTION = "description";
    public final static String ETIQUETTE_DROIT_PASSAGE =
            "nombre_droits_passage";
    public final static String ETIQUETTE_SERVICES = "nombre_services";
    public final static String ETIQUETTE_SUPERFICIE = "superficie";
    public final static String ETIQUETTE_DATE_MESURE = "date_mesure"; 
    public final static String ETIQUETTE_LOTISSEMENTS = "lotissements";
    public final static String ETIQUETTE_VALEUR_FONCIERE_TOTALE =
            "valeur_fonciere_totale";
    public final static String ETIQUETTE_TAXE_SCOLAIRE = "taxe_scolaire";
    public final static String ETIQUETTE_TAXE_MUNICIPALE = "taxe_municipale";
    public final static String ETIQUETTE_VALEUR_PAR_LOT = "valeur_par_lot";
    
    public ArrayList<Lotissement> obtenirDonneesLot(String json)
            throws FileNotFoundException, IOException,
            NumberFormatException, LotValideException {
        
        ArrayList <Lotissement> lotissements = new ArrayList<>();
        String description;
        int nombreDroitPassage;
        int nombreService;
        int superfice;
        String dateMesure;
        Lotissement lot;
        
        if (json.length() != 0) {
            JSONObject enteteTerrain = JSONObject.fromObject(json);
            
            Object item = enteteTerrain.get(ETIQUETTE_LOTISSEMENTS);

            if (item instanceof JSONObject) {
                JSONObject uniqueLot = enteteTerrain
                        .getJSONObject(ETIQUETTE_LOTISSEMENTS);

                description = VerificationDonnee
                        .validerDescriptionLot(uniqueLot
                                .getString(ETIQUETTE_DESCRIPTION));
                nombreDroitPassage = VerificationDonnee
                        .valeurEstInt(uniqueLot
                                .getInt(ETIQUETTE_DROIT_PASSAGE));
                nombreService = VerificationDonnee
                        .valeurEstInt(uniqueLot.getInt(ETIQUETTE_SERVICES));
                superfice = VerificationDonnee
                        .valeurEstInt(uniqueLot.getInt(ETIQUETTE_SUPERFICIE));
                dateMesure = VerificationDonnee
                        .validerDateMesure(uniqueLot
                                .getString(ETIQUETTE_DATE_MESURE));

                lot = new Lotissement(description, nombreDroitPassage,
                        nombreService, superfice, dateMesure);
                lotissements.add(lot);

            } else {
                JSONArray list = enteteTerrain
                        .getJSONArray(ETIQUETTE_LOTISSEMENTS);

                if (!list.isEmpty()) {
                    for(int i = 0; i<list.size(); i++) {
                        JSONObject plusieursLot = list.getJSONObject(i);

                        description = VerificationDonnee
                                .validerDescriptionLot(plusieursLot
                                        .getString(ETIQUETTE_DESCRIPTION));
                        nombreDroitPassage = VerificationDonnee
                                .valeurEstInt(plusieursLot
                                        .getInt(ETIQUETTE_DROIT_PASSAGE));
                        nombreService = VerificationDonnee
                                .valeurEstInt(plusieursLot
                                        .getInt(ETIQUETTE_SERVICES));
                        superfice = VerificationDonnee
                                .valeurEstInt(plusieursLot
                                        .getInt(ETIQUETTE_SUPERFICIE));
                        dateMesure = VerificationDonnee
                                .validerDateMesure(plusieursLot
                                        .getString(ETIQUETTE_DATE_MESURE));
                        
                        lot = new Lotissement(description, nombreDroitPassage,
                                nombreService, superfice, dateMesure);
                        
                        lotissements.add(lot);
                        
                    }
                }
            }
        }

        return lotissements;
    }
    
    public int obtenirTypeTerrain(Terrain terrain)
            throws IOException, NullPointerException {
        return terrain.getTypeTerrain();
    }
    
    public final static String DECIMAL_ONLY = "[^\\d.]";
    
    public double obtenirPrixMinimum(Terrain terrain)
            throws IOException, NullPointerException {

        String prix = terrain.getPrixMin();
        String prixMinim = prix.replaceAll(DECIMAL_ONLY, "");
        double prixMinimum = Double.parseDouble(prixMinim);
        
        return prixMinimum;

    }
    
    public double obtenirPrixMaximum(Terrain terrain)
            throws IOException, NullPointerException {
        
        String prix = terrain.getPrixMax();
        String priMaxi = prix.replaceAll(DECIMAL_ONLY, "");
        double prixMaximum = Double.parseDouble(priMaxi);

        return prixMaximum;
    }
    
    public String[] obtenirDescription(ArrayList<Lotissement> lotissements)
            throws IOException, NullPointerException {
        
        int taille = lotissements.size();
        String [] descriptions = new String[taille];

        for (int i = 0; i < taille; i++) {
            String descriptionLot = lotissements.get(i).getDescription();
            
            descriptions[i] = descriptionLot;
        }
        
        return descriptions;
    }
    
    public int [] obtenirNombreDroitPassage(
            ArrayList<Lotissement> lotissements)
            throws IOException, NullPointerException {
        
        int taille = lotissements.size();
        int[] passages = new int[taille];

        for (int i = 0; i < taille; i++) {
            int droitPassage = lotissements.get(i).getNombreDroitPassage();

            passages[i] = droitPassage;

        }
        return passages;
    }
    
    public int [] obtenirNombreService(ArrayList<Lotissement> lotissements)
            throws IOException, NullPointerException {

        int taille = lotissements.size();
        int[] services = new int[taille];

        for (int i = 0; i < taille; i++) {
            int servive = lotissements.get(i).getNombreService();

            services[i] = servive;

        }
        
        return services;
    }
    
    public int [] obtenirSuperficie(ArrayList<Lotissement> lotissements)
            throws IOException, NullPointerException {

        int taille = lotissements.size();
        int[] superficies = new int[taille];

        for (int i = 0; i < taille; i++) {
            
            int superficie = lotissements.get(i).getSuperficie();

            superficies[i] = superficie;

        }
        
        return superficies;
    }
    
    public String [] obtenirDateMesure(ArrayList<Lotissement> lotissements)
            throws IOException, NullPointerException {

        int taille = lotissements.size();
        String [] dates = new String[taille];

        for (int i = 0; i < taille; i++) {
            String date = lotissements.get(i).getDateMesure();

            dates[i] = date;

        }
        
        return dates;
    }
    
    public double [] calculerMontantLot(ArrayList<Lotissement> lotissements,
            int idTerrain, int [] superficies, double prixMinimum,
            double prixMaximum)
            throws IOException, NullPointerException {

        int taille = lotissements.size();
        double [] montantsLot = new double[taille];
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
        
        return montantsLot;
    }
    
    public final static int MONTANT_BASE_DROIT_PASSAGE = 500;
    public final static double TAUX_05 = 0.05;
    public final static double TAUX_10 = 0.10;
    public final static double TAUX_15 = 0.15;
    
    public double [] calculerDroitPassage(ArrayList<Lotissement> lotissements,
            int idTerrain, int [] passages, double [] montantsLot)
            throws IOException, NullPointerException {

        int taille = lotissements.size();
        double [] montantsPassage = new double[taille];
        double montantDroit = 0.0;
        
        for (int i = 0; i < taille; i++) {
            switch (idTerrain) {
                case Terrain.TERRAIN_AGRICOLE:  {
                
                    montantDroit = MONTANT_BASE_DROIT_PASSAGE
                            - (passages[i]
                            * (TAUX_05 * montantsLot[i]));
                }
                break;

                case Terrain.TERRAIN_RESIDENTIEL: {
                    montantDroit = MONTANT_BASE_DROIT_PASSAGE
                            - (passages[i]
                            * (TAUX_10 * montantsLot[i]));
                }
                break;
                case Terrain.TERRAIN_COMMERCIAL: {
                    montantDroit = MONTANT_BASE_DROIT_PASSAGE
                            - (passages[i]
                            * (TAUX_15 * montantsLot[i]));
                }
                break;
                default:
                    break;
            }

            montantsPassage[i] = montantDroit;

        }
        
        return montantsPassage;
    }
    
    public static final double SERVICE_DE_BASE = 2;
    public static final int SUPERFICIE_500 = 500;
    public static final int SUPERFICIE_10000 = 10000;
    public static final double MONTANT_SERVICE_0 = 0.0;
    public static final double MONTANT_SERVICE_500 = 500;
    public static final double MONTANT_SERVICE_1000 = 1000;
    public static final double MONTANT_SERVICE_1500 = 1500;
    
    public double [] calculerMontantService(
            ArrayList<Lotissement> lotissements, int idTerrain,
            int [] superficies, int [] services) throws IOException,
            NullPointerException {
        
        int taille = lotissements.size();
        double [] montantsService = new double[taille];

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
                    
                    montantService = determinerMontantCommercial(tempService);
                    
                }
                break;
                default:
                    break;
            }

            montantsService[i] = montantService;

        }
        
        return montantsService;
    }
    
    public static final double MONTANT_MAX_SERVICE = 5000;
    
    private double determinerMontantCommercial(double montantService) {
        
        double montant;
        
        if (montantService > MONTANT_MAX_SERVICE) {
            montant = MONTANT_MAX_SERVICE;
            
        } else {
            montant = montantService;
            
        }
        
        return montant;
    }
    
    public double [] calculerValeurParLot(ArrayList<Lotissement> lotissements,
            double [] montantsLot, double [] montantsPassage,
            double [] montantsService) throws IOException,
            NullPointerException {

        int taille = lotissements.size();
        double [] montantsParLot = new double[taille];

        for (int i = 0; i < taille; i++) {
            double valeurParLot = montantsLot[i] + montantsPassage[i] +
                    montantsService[i];

            montantsParLot[i] = valeurParLot;

        }
        
        return montantsParLot;

    }
    
    public final static double VALEUR_DE_BASE = 733.77;
    public double calculerValeurFonciere(ArrayList<Lotissement> lotissements,
            double [] montantsParLot) throws IOException,
            NullPointerException {
        
        int taille = lotissements.size();
        double tempTerrain = 0.0;
        double montantTerrain;

        for (int i = 0; i < taille; i++) {
            tempTerrain = tempTerrain + montantsParLot[i]++;
        }

        montantTerrain = (tempTerrain + VALEUR_DE_BASE);
        
        return montantTerrain;

    }
    
    public final static double TAXE_SCOLAIRE = 0.012;
    public double calculerTaxeScolaire(double montantTerrain)
            throws IOException, NullPointerException {
        
        return montantTerrain * TAXE_SCOLAIRE;
    }
    
    public final static double TAXE_MUNICIPALE = 0.025;
    public double calculerTaxeMunicipale(double montantTerrain)
            throws IOException {
        
        return montantTerrain * TAXE_MUNICIPALE;
    }
    
    public JSONObject genererRapportEvaluation(double montantTerrain,
            double montantTaxeScolaire, double montantTaxeMunicipale,
            double [] montantsParLot, String [] descriptions)
            throws IOException, LotValideException {
        
            JSONObject enteteRapport = null;
        if (VerificationDonnee.verifierLotsDoublons(descriptions)) {
            
            enteteRapport = new JSONObject();
            enteteRapport.accumulate(ETIQUETTE_VALEUR_FONCIERE_TOTALE,
                    Utilitaire.convertirMontant(montantTerrain));
            enteteRapport.accumulate(ETIQUETTE_TAXE_SCOLAIRE,
                    Utilitaire.convertirMontant(montantTaxeScolaire));
            enteteRapport.accumulate(ETIQUETTE_TAXE_MUNICIPALE,
                    Utilitaire.convertirMontant(montantTaxeMunicipale));

            for (int i = 0; i < montantsParLot.length; i++) {
                
                JSONObject detailsLot = new JSONObject();

                detailsLot.accumulate(ETIQUETTE_DESCRIPTION,
                        descriptions[i]);
                detailsLot.accumulate(ETIQUETTE_VALEUR_PAR_LOT,
                        Utilitaire.convertirMontant(montantsParLot[i]));

                enteteRapport.accumulate(
                        ETIQUETTE_LOTISSEMENTS,detailsLot);
            }
        }
        
        return enteteRapport;
    }

}
