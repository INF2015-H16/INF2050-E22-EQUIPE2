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
 * @modify at 2022-05-29 by Aurélien Tcheuffa Kemayou / Sidopz
 *
 */
public class EvaluationTerrain {

    //Déclaration des constantes
    public final static String FILE_ENCODING = "UTF-8";

    public final static double VALEUR_DE_BASE = 733.77;
    public final static double TAXE_SCOLAIRE = 0.012;
    public final static double TAXE_MUNICIPALE = 0.025;

    public final static String LOT = "lot ";
    public final static String DESCRIPTION = "description";
    public final static String NBRE_DROIT_PASSAGE = "nombre_droits_passage";
    public final static String NBRE_SERVICES = "nombre_services";
    public final static String SUPERFICIE = "superficie";
    public final static String DATE_MESURE = "date_mesure";

    public final static String TYPE_TERRAIN = "type_terrain";
    public final static String PRIX_M2_MIN = "prix_m2_min";
    public final static String PRIX_M2_MAX = "prix_m2_max";
    public final static String LOTISSEMENTS = "lotissements";

    public final static String RAP_VALEUR_FONCIERE_TOTALE =
            "valeur_fonciere_totale";
    public final static String RAP_TAXE_SCOLAIRE = "taxe_scolaire";
    public final static String RAP_TAXE_MUNICIPALE = "taxe_municipale";
    public final static String RAP_VALEUR_PAR_LOT = "valeur_par_lot";

    public final static String DECIMAL_ONLY = "[^\\d.]";

    //Déclaration des variables
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
    private double [] montantsPass;
    private double [] montantsServ;
    private double [] montantsParLot;
    private String [] descriptions;
    private int [] passages;
    private int [] services;
    private int [] superficies;
    private String [] dates;

    /**
     * Lire les données à partir du fichier entree.json et en extraire
     * les détails des valeurs des différents lots et créer
     * des objets Terrain.
     *
     * @param argument qui est fichier .json en entrée
     * @throws java.io.FileNotFoundException
     * @throws IOException
     * @throws inf2050.e22.equipe2.IntervallesValideException
     */
    public static void lireTerrainLoti(String argument)
            throws FileNotFoundException, IOException,
            NumberFormatException, IntervallesValideException {
        String json;
        String t;
        int e;
        int r;
        int a;
        String n;
        Lotissement lot;

        json = FileReaderException.loadFileIntoString(argument,
                FILE_ENCODING);

        if (json.length() != 0) {
            JSONObject terrJson = JSONObject.fromObject(json);

            int tTerrain = terrJson.getInt(TYPE_TERRAIN);
            String prixMn = terrJson.getString(PRIX_M2_MIN);
            String priMx = terrJson.getString(PRIX_M2_MAX);

            lotissements = new ArrayList<>();

            Object item = terrJson.get(LOTISSEMENTS);

            if (item instanceof JSONObject) {
                JSONObject lotJson = terrJson.getJSONObject(LOTISSEMENTS);

                t = lotJson.getString(DESCRIPTION);
                e = lotJson.getInt(NBRE_DROIT_PASSAGE);
                r = lotJson.getInt(NBRE_SERVICES);
                a = lotJson.getInt(SUPERFICIE);
                n = VerificationDonnee.validerDateMesure(
                        lotJson.getString(DATE_MESURE));

                lot = new Lotissement(t, e, r, a, n);
                lotissements.add(lot);

            } else {
                JSONArray list = terrJson.getJSONArray(LOTISSEMENTS);

                if (!list.isEmpty()) {
                    for(int i = 0; i<list.size(); i++) {
                        JSONObject jsonObj = list.getJSONObject(i);

                        t = jsonObj.getString(DESCRIPTION);
                        e = jsonObj.getInt(NBRE_DROIT_PASSAGE);
                        r = jsonObj.getInt(NBRE_SERVICES);
                        a = jsonObj.getInt(SUPERFICIE);
                        n = VerificationDonnee.validerDateMesure(
                                jsonObj.getString(DATE_MESURE));

                        lot = new Lotissement(t, e, r, a, n);
                        lotissements.add(lot);
                    }
                }
            }
            
            if (VerificationDonnee.validerTerrain(tTerrain)) {
                terrain = new Terrain(tTerrain, prixMn, priMx, lotissements);
                taille = lotissements.size();
            }
        }

    }

    /**
     * Obtenir l'identifiant du terrain.
     *
     * @throws java.io.IOException
     */
    public void obtenirTypeTerrain() throws IOException, NullPointerException {
        int terr;

        terr = terrain.getTypeTerrain();

        idTerrain = terr;
    }

    /**
     * Obtenir le prix minimum du terrain.
     *
     * @throws java.io.IOException
     */
    public void obtenirPrixMin() throws IOException, NullPointerException {
        String pMin;
        double prixMin;

        pMin = terrain.getPrixMin();
        String prixMn = pMin.replaceAll(DECIMAL_ONLY, "");
        prixMin = Double.parseDouble(prixMn);

        prixMinimum = prixMin;

    }

    /**
     * Obtenir le prix maximum du terrain.
     *
     * @throws java.io.IOException
     */
    public void obtenirPrixMax() throws IOException, NullPointerException {
        String pMax;
        double prixMax;

        pMax = terrain.getPrixMax();
        String priMx = pMax.replaceAll(DECIMAL_ONLY, "");
        prixMax = Double.parseDouble(priMx);

        prixMaximum = prixMax;

    }

    /**
     * Obtenir la description des différents lots qui composent le terrain.
     *
     * @throws java.io.IOException
     */
    public void obtenirDescription() throws IOException, NullPointerException {
        String desc;

        descriptions = new String[taille];

        for (int i = 0; i < taille; i++) {
            desc = lotissements.get(i).getDescription();

            descriptions[i] = desc;
        }
    }

    /**
     * Obtenir le nombre de droits de passage de chaque lot
     * du terrain.
     *
     * @throws java.io.IOException
     */
    public void obtenirNbreDroitPassage() throws IOException,
            NullPointerException {
        int pass;

        passages = new int[taille];

        for (int i = 0; i < taille; i++) {
            pass = lotissements.get(i).getNombreDroitPassage();

            passages[i] = pass;

        }
    }

    /**
     * Obtenir le nombre de services de chaque lot
     * du terrain.
     *
     * @throws java.io.IOException
     */
    public void obtenirNbreService() throws IOException, NullPointerException {
        int serv;

        services = new int[taille];

        for (int i = 0; i < taille; i++) {
            serv = lotissements.get(i).getNombreService();

            services[i] = serv;

        }
    }

    /**
     * Obtenir la superficie de chaque lot
     * du terrain.
     * @throws java.io.IOException
     */
    public void obtenirSuperficie() throws IOException, NullPointerException {
        int sup;

        superficies = new int[taille];

        for (int i = 0; i < taille; i++) {
            sup = lotissements.get(i).getSuperficie();

            superficies[i] = sup;

        }
    }

    /**
     * Obtenir la date de chaque lot
     * du terrain.
     * @throws java.io.IOException
     */
    public void obtenirDateMesure() throws IOException, NullPointerException {
        String mes;

        dates = new String[taille];

        for (int i = 0; i < taille; i++) {
            mes = lotissements.get(i).getDateMesure();

            dates[i] = mes;

        }
    }

    /**
     * Calculer le montant de chaque lot de chaque lot
     * du terrain.
     *
     * @throws java.io.IOException
     */
    public void calculerMontantLot() throws IOException, NullPointerException {
        double mntLot = 0.0;

        montantsLot = new double[taille];

        for (int i = 0; i < taille; i++) {
            switch (idTerrain) {
                case Terrain.TERRAIN_AGRICOLE: {
                    mntLot = superficies[i] * prixMinimum;
                }
                break;
                case Terrain.TERRAIN_RESIDENTIEL: {
                    mntLot = superficies[i] *
                            ((prixMinimum + prixMaximum)/2);
                }
                break;
                case Terrain.TERRAIN_COMMERCIAL: {
                    mntLot = superficies[i] * prixMaximum;
                }
                break;
                default:
                    break;
            }

            montantsLot[i] = mntLot;

        }
    }

    /**
     * Calculer le montant des droits de passage.
     *
     * @throws java.io.IOException
     */
    public void calculerDroitPassage() throws IOException,
            NullPointerException {
        double mntDroit = 0.0;

        montantsPass = new double[taille];

        for (int i = 0; i < taille; i++) {
            switch (idTerrain) {
                case Terrain.TERRAIN_AGRICOLE: {
                    mntDroit = 500 - (passages[i] * (0.05 * montantsLot[i]));
                }
                break;
                case Terrain.TERRAIN_RESIDENTIEL: {
                    mntDroit = 500 - (passages[i] * (0.10 * montantsLot[i]));
                }
                break;
                case Terrain.TERRAIN_COMMERCIAL: {
                    mntDroit = 500 - (passages[i] * (0.15 * montantsLot[i]));
                }
                break;
                default:
                    break;
            }

            montantsPass[i] = mntDroit;

        }
    }

    /**
     * Calculer le montant des services.
     *
     * @throws java.io.IOException
     */
    public void calculerMontantService() throws IOException,
            NullPointerException {
        double mntService = 0.0;
        double tempService = 0.0;

        montantsServ = new double[taille];

        for (int i = 0; i < taille; i++) {
            switch (idTerrain) {
                case Terrain.TERRAIN_AGRICOLE: {
                    mntService = 0.0;
                }
                break;
                case Terrain.TERRAIN_RESIDENTIEL: {
                    if (superficies[i] <= 500) {
                        mntService = 0.0;
                    } else if (superficies[i] > 500
                            && superficies[i] <= 10000) {
                        mntService = (2 + services[i]) * 500;
                    } else {
                        mntService = (2 + services[i]) * 1000;
                    }
                }
                break;
                case Terrain.TERRAIN_COMMERCIAL: {
                    if (superficies[i] <= 500) {
                        tempService = (2 + services[i]) * 500;
                    } else if (superficies[i] > 500) {
                        tempService = (2 + services[i]) * 1500;
                    }

                    if (tempService > 5000) {
                        mntService = 5000;
                    } else {
                        mntService = tempService;
                    }
                }
                break;
                default:
                    break;
            }

            montantsServ[i] = mntService;

        }

    }

    /**
     * Calculer le montant par lot.
     *
     * @throws java.io.IOException
     */
    public void calculerValeurParLot() throws IOException,
            NullPointerException {
        double valeurParLot;

        montantsParLot = new double[taille];

        for (int i = 0; i < taille; i++) {
            valeurParLot = montantsLot[i] + montantsPass[i] +
                    montantsServ[i];

            montantsParLot[i] = valeurParLot;

        }

    }

    /**
     * Calculer la valeur foncière du terrain.
     *
     * @throws java.io.IOException
     */
    public void calculerValeurFonciere() throws IOException,
            NullPointerException {
        double tempTerrain = 0.0;

        for (int i = 0; i < taille; i++) {
            tempTerrain = tempTerrain + montantsParLot[i]++;
        }

        montantTerrain = (tempTerrain + VALEUR_DE_BASE);

    }

    /**
     * Calculer la taxe scolaire.
     *
     * @throws java.io.IOException
     */
    public void calculerTaxeScolaire() throws IOException,
            NullPointerException {
        montantTaxeScolaire = montantTerrain * TAXE_SCOLAIRE;
    }

    /**
     * Calculer la taxe municipale.
     *
     * @throws java.io.IOException
     */
    public void calculerTaxeMunicipale() throws IOException {
        montantTaxeMunicipale = montantTerrain * TAXE_MUNICIPALE;
    }

    /**
     * Afficher le rapport de l'évaluation foncière du terrain.
     *
     * @param argument qui est fichier .json en sortie
     * @throws IOException
     */
    public void genererRapportEvaluation(String argument)
            throws IOException {
        JSONObject enteteJson = new JSONObject();
        enteteJson.accumulate(RAP_VALEUR_FONCIERE_TOTALE,
                Utilitaire.convertirMontant(montantTerrain));
        enteteJson.accumulate(RAP_TAXE_SCOLAIRE,
                Utilitaire.convertirMontant(montantTaxeScolaire));
        enteteJson.accumulate(RAP_TAXE_MUNICIPALE,
                Utilitaire.convertirMontant(montantTaxeMunicipale));

        for (int i = 0; i < montantsParLot.length; i++) {
            JSONObject lotJson = new JSONObject();

            lotJson.accumulate(DESCRIPTION, descriptions[i]);
            lotJson.accumulate(RAP_VALEUR_PAR_LOT,
                    Utilitaire.convertirMontant(montantsLot[i]));

            enteteJson.accumulate(LOTISSEMENTS,lotJson);
        }

        Utilitaire.afficherMsg(enteteJson.toString(4));

        FileWriterException.saveStringIntoFile(argument,
                enteteJson.toString(4), FILE_ENCODING);
    }

}