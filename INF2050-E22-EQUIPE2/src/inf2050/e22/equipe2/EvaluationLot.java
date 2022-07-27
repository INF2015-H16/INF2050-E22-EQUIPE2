/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inf2050.e22.equipe2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;
/**
 * Université du Québec à Montréal (UQAM)
 * Cours : INF2050 - 020 - Été 2022
 * Sprint 3
 *
 * EvaluationLot : Cette classe contient les données sur la description,
 *                le nombre de droits de passage, le nombre de services,
 *                la superficie, la date de mesure des lots.
 *                Elle permet de calculer les valeurs par lot.
 *
 *
 * @author Achou Henri Joël / Akaffou
 * @version juillet 2022
 *
 */
public class EvaluationLot implements IEvaluationLot {

    public final static double VALEUR_DE_BASE = 733.77;

    public final static String ETIQUETTE_LOT = "lot";
    public final static String ETIQUETTE_DROIT_PASSAGE =
            "nombre_droits_passage";
    public final static String ETIQUETTE_SERVICES = "nombre_services";
    public final static String ETIQUETTE_SUPERFICIE = "superficie";
    public final static String ETIQUETTE_DATE_MESURE = "date_mesure";
    public static final int PERIOD_MAXIMAL_DATE = 180;
    public static final int VALEUR_FONCIERE_MAXIMALE = 300000;
    public static final int SUPERFICIE_MAXIMALE = 45000;
    public static final int VALEUR_LIMITE_LOT_DISPENDIEUX = 45000;
    private SimpleDateFormat formatDate = new SimpleDateFormat(
            EvaluationObservation.DATE_PATTERN);
    private ArrayList<Lotissement> lotissements;
    private final String json;
    private MontantLot montantLot;

    public EvaluationLot(ArrayList<Lotissement> lotissements, String json)  {
        this.lotissements = lotissements;
        this.json = json;
    }

    @Override
    public int obtenirNombreLot(ArrayList<Lotissement> lotissements)
            throws IntervallesValideException {
        int temp = lotissements.size();
        int taille;

        if (!VerificationDonnee.validerNombreLot(temp)) {
            throw new IntervallesValideException(GestionnaireMessage
                    .choisirMessageNombreLots(temp,
                            VerificationDonnee.NOMBRE_MINIMAL_LOT,
                            VerificationDonnee.NOMBRE_MAXIMAL_LOT));
        } else {
            taille = temp;
        }

        return taille;
    }

    @Override
    public ArrayList<Lotissement> obtenirDonneesLot()
            throws LotValideException, IntervallesValideException {
        ArrayList <Lotissement> mesLotissements = new ArrayList<>();

        if (json.length() != 0) {
            JSONObject enteteTerrain = JSONObject.fromObject(json);
            Object item = enteteTerrain.get(EvaluationTerrain
                    .ETIQUETTE_LOTISSEMENTS);
            if (item instanceof JSONObject) {
                mesLotissements = obtenirUniqueLot(enteteTerrain);

            } else {
                mesLotissements = obtenirPlusieursLots(enteteTerrain);

            }
        }

        return mesLotissements;
    }

    private ArrayList<Lotissement> obtenirPlusieursLots(JSONObject enteteTerrain)
            throws LotValideException, IntervallesValideException {
        ArrayList <Lotissement> lots = new ArrayList<>();

        JSONArray list = enteteTerrain
                .getJSONArray(EvaluationTerrain.ETIQUETTE_LOTISSEMENTS);

        if (!list.isEmpty()) {
            lots = obtenirListeLot(list);

        }

        return lots;
    }

    private ArrayList<Lotissement> obtenirUniqueLot(JSONObject enteteTerrain)
            throws JSONException {
        ArrayList <Lotissement> mesLotissements = new ArrayList<>();

        if (VerificationDonnee.verifierContenuFichierLot(enteteTerrain)) {
            JSONObject uniqueLot = enteteTerrain
                    .getJSONObject(EvaluationTerrain.ETIQUETTE_LOTISSEMENTS);

            String description = uniqueLot
                            .getString(EvaluationTerrain.ETIQUETTE_DESCRIPTION);
            int nombreDroitPassage = uniqueLot
                            .getInt(ETIQUETTE_DROIT_PASSAGE);
            int nombreService = uniqueLot.getInt(ETIQUETTE_SERVICES);
            int superfice = uniqueLot.getInt(ETIQUETTE_SUPERFICIE);
            String dateMesure = uniqueLot
                            .getString(ETIQUETTE_DATE_MESURE);

            mesLotissements.add(new Lotissement(description,
                    nombreDroitPassage, nombreService, superfice,
                    dateMesure));

        }

        return mesLotissements;
    }

    private ArrayList<Lotissement> obtenirListeLot(JSONArray list)
            throws LotValideException, IntervallesValideException {
        ArrayList <Lotissement> mesLotissements = new ArrayList<>();

        for(int i = 0; i<list.size(); i++) {
            JSONObject plusieursLot = list.getJSONObject(i);

            mesLotissements.add(obtenirPourPlusieurs(plusieursLot));
        }

        return mesLotissements;

    }

    private Lotissement obtenirPourPlusieurs(JSONObject plusieursLot)
            throws LotValideException, IntervallesValideException,
            JSONException {
        Lotissement lotissement = null;

        if (VerificationDonnee.verifierContenuFichierLot(plusieursLot)) {
            String description = plusieursLot
                            .getString(EvaluationTerrain
                                    .ETIQUETTE_DESCRIPTION);
            int nombreDroitPassage = plusieursLot
                            .getInt(ETIQUETTE_DROIT_PASSAGE);
            int nombreService = plusieursLot
                            .getInt(ETIQUETTE_SERVICES);
            int superfice = plusieursLot
                            .getInt(ETIQUETTE_SUPERFICIE);
            String dateMesure = plusieursLot
                            .getString(ETIQUETTE_DATE_MESURE);

            lotissement = new Lotissement(description, nombreDroitPassage,
                    nombreService, superfice, dateMesure);

        }

        return lotissement;
    }

    @Override
    public String[] obtenirDescription(ArrayList<Lotissement> lotissements)
            throws NullPointerException, IntervallesValideException, LotValideException {
        String [] descriptions = new String[obtenirNombreLot(lotissements)];

        for (int i = 0; i < obtenirNombreLot(lotissements); i++) {
            String descriptionLot = getLotissement(i,
                    lotissements).getDescription();

            descriptions[i] = descriptionLot;
        }

        return descriptions;
    }

    private Lotissement getLotissement(int index,
                                       ArrayList<Lotissement> lotissements) {
        return lotissements.get(index);
    }

    @Override
    public int [] obtenirNombreDroitPassage(ArrayList<Lotissement> lotissements)
            throws NullPointerException, IntervallesValideException {

        int[] droitPassages = new int[obtenirNombreLot(lotissements)];

        for (int i = 0; i < obtenirNombreLot(lotissements); i++) {
            droitPassages[i] = getLotissement(i, lotissements)
                    .getNombreDroitPassage();

        }

        return droitPassages;
    }

    @Override
    public int [] obtenirNombreService(ArrayList<Lotissement> lotissements)
            throws NullPointerException, IntervallesValideException {

        int[] services = new int[obtenirNombreLot(lotissements)];

        for (int i = 0; i < obtenirNombreLot(lotissements); i++) {
            services[i] = getLotissement(i, lotissements).getNombreService();

        }

        return services;
    }

    @Override
    public int [] obtenirSuperficie(ArrayList<Lotissement> lotissements)
            throws NullPointerException, IntervallesValideException {

        int[] superficies = new int[obtenirNombreLot(lotissements)];

        for (int i = 0; i < obtenirNombreLot(lotissements); i++) {
            superficies[i] = getLotissement(i, lotissements).getSuperficie();

        }

        return superficies;
    }

    public String [] obtenirLotSuperficieTropGrande(String [] descriptions,
                                      int [] superficies,
                                      ArrayList<Lotissement> lotissements)
            throws IntervallesValideException {
        String [] lotsTropGrands = new String[lotissements.size()];

        for (int i = 0; i < obtenirNombreLot(lotissements); i++) {
            if (superficies[i] > SUPERFICIE_MAXIMALE) {
                String lot = descriptions[i];
                lotsTropGrands[i] = lot.trim();
            }
        }

        return lotsTropGrands;
    }

    @Override
    public int obtenirMaximumSuperficie(int [] superficies) {
        int maxSuperficie = superficies[0];

        for (int i = 1; i < superficies.length; i++) {
            if (superficies[i] > maxSuperficie) {
                maxSuperficie = superficies[i];
            }
        }

        return maxSuperficie;
    }

    @Override
    public String [] obtenirDateMesure(ArrayList<Lotissement> lotissements)
            throws NullPointerException, IntervallesValideException {

        String [] dates = new String[obtenirNombreLot(lotissements)];

        for (int i = 0; i < obtenirNombreLot(lotissements); i++) {
            dates[i] = getLotissement(i, lotissements).getDateMesure();

        }

        return dates;
    }

    public long [] obtenirEcartMaximalEntreDate(ArrayList<Lotissement> lotissements)
            throws IntervallesValideException, ParseException {
        long [] ecart = new long[lotissements.size()];
        ArrayList<Long> differenceDate = calculerDifferenceDate(lotissements);

        for (int i = 0; i < obtenirNombreLot(lotissements); i++) {
            if (differenceDate.get(i) > PERIOD_MAXIMAL_DATE) {
                long donnee = differenceDate.get(i);
                ecart [i] = donnee;
            }
        }

        return ecart;
    }

    private ArrayList<Long> calculerDifferenceDate(
            ArrayList<Lotissement> lotissements)
            throws ParseException, IntervallesValideException {
        ArrayList<Long> differences = new ArrayList<>();
        String [] dateLot = obtenirDateMesure(lotissements);

        for (int i = 0; i < lotissements.size(); i++) {
            for (int j = i + 1; j < lotissements.size(); j++) {
                calculerDifference(differences, dateLot, i, j);
            }
        }

        return differences;
    }

    private void calculerDifference(ArrayList<Long> differences,
                                    String[] dateLot,
                                    int indexI, int indexJ)
            throws ParseException {
        Date date = formatDate.parse(dateLot[indexI]);
        Date dateAutre = formatDate.parse(dateLot[indexJ]);

        long difference = dateAutre.getTime() - date.getTime();
        long differenceDate = Math.abs((difference
                / (1000 * 60 * 60 * 24)) % 365);

        differences.add(differenceDate);
    }

    @Override
    public double [] calculerMontantLot(int idTerrain,
                                        int [] superficies,
                                        double prixMinimum,
                                        double prixMaximum,
                                        ArrayList<Lotissement> lotissements)
            throws NullPointerException, IntervallesValideException {
        double [] montantsLot = new double[obtenirNombreLot(lotissements)];
        montantLot = MontantLot.setMontantLot(idTerrain);

        for (int i = 0; i < obtenirNombreLot(lotissements); i++) {
            montantsLot[i] = montantLot.obtenirMontantLot(i,
                    superficies, prixMinimum, prixMaximum);

        }

        return montantsLot;
    }

    @Override
    public double [] calculerDroitPassage(int idTerrain, int [] passages,
                                          double [] montantsLot,
                                          ArrayList<Lotissement> lotissements)
            throws NullPointerException, IntervallesValideException {

        double [] montantsPassage = new double[obtenirNombreLot(lotissements)];
        montantLot = MontantLot.setMontantLot(idTerrain);

        for (int i = 0; i < obtenirNombreLot(lotissements); i++) {
            montantsPassage[i] = montantLot.obtenirMontantPassage(i,
                    passages, montantsLot);

        }

        return montantsPassage;
    }

    @Override
    public double [] calculerMontantService(int idTerrain,
                                            int [] superficies,
                                            int [] services,
                                            ArrayList<Lotissement> lotissements)
            throws NullPointerException, IntervallesValideException {

        double [] montantsService = new double[obtenirNombreLot(lotissements)];
        montantLot = MontantLot.setMontantLot(idTerrain);

        for (int i = 0; i < obtenirNombreLot(lotissements); i++) {
            montantsService[i] = montantLot.obtenirMontantService(i,
                    superficies, services);

        }

        return montantsService;
    }

    @Override
    public double [] calculerValeurParLot(double[] montantsLot,
                                          double[] montantsPassage,
                                          double[] montantsService,
                                          ArrayList<Lotissement> lotissements)
            throws NullPointerException, IntervallesValideException {

        double [] montantsParLot = new double[obtenirNombreLot(lotissements)];

        for (int i = 0; i < obtenirNombreLot(lotissements); i++) {
            montantsParLot[i] = montantsLot[i] + montantsPassage[i] +
                    montantsService[i];

        }

        return montantsParLot;
    }

    public String [] obtenirLotDispendieux(String [] descriptions,
                                      double [] montantsParLot,
                                      ArrayList<Lotissement> lotissements)
            throws IntervallesValideException {
        String [] lotDispendieux = new String[lotissements.size()];
        for (int i = 0; i < obtenirNombreLot(lotissements); i++) {
            if (montantsParLot[i] > VALEUR_LIMITE_LOT_DISPENDIEUX) {
                String lot = descriptions[i];
                lotDispendieux[i] = lot.trim();
            }
        }

        return lotDispendieux;
    }

    @Override
    public double obtenirMaximumValeurParLot(double [] valeurLots) {
        double maxValeur = valeurLots[0];

        for (int i = 1; i < valeurLots.length; i++) {
            if (valeurLots[i] > maxValeur) {
                maxValeur = valeurLots[i];
            }
        }

        return maxValeur;
    }

    @Override
    public double calculerValeurFonciere(double [] montantsParLot,
                                         ArrayList<Lotissement> lotissements)
            throws NullPointerException, IntervallesValideException {

        double tempTerrain = 0.0;

        for (int i = 0; i < obtenirNombreLot(lotissements); i++) {
            tempTerrain = tempTerrain + montantsParLot[i];
        }

        return tempTerrain + VALEUR_DE_BASE;

    }

    public double obtenirLotTropGrand(double valeurfonciere) {
        double valeurTropGrand = 0;

        if (valeurfonciere > VALEUR_FONCIERE_MAXIMALE) {
            valeurTropGrand = valeurfonciere;
        }

        return valeurTropGrand;
    }

}