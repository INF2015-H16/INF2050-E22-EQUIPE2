/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inf2050.e22.equipe2;

import java.text.ParseException;
import java.util.ArrayList;
import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;

/**
 *
 * @author akaff
 */
public class EvaluationLot implements IEvaluationLot {

    public final static double VALEUR_DE_BASE = 733.77;

    public final static String ETIQUETTE_LOT = "lot";
    public final static String ETIQUETTE_DROIT_PASSAGE =
            "nombre_droits_passage";
    public final static String ETIQUETTE_SERVICES = "nombre_services";
    public final static String ETIQUETTE_SUPERFICIE = "superficie";
    public final static String ETIQUETTE_DATE_MESURE = "date_mesure";
    private ArrayList<Lotissement> lotissements;
    private final String json;
    private MontantLot montantLot;
    private IObservationLot iObservationLot;

    public EvaluationLot(ArrayList<Lotissement> lotissements, String json,
                         IObservationLot iObservationLot)  {
        this.lotissements = lotissements;
        this.json = json;
        this.iObservationLot = iObservationLot;
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
            throws LotValideException, IntervallesValideException, JSONException {
        ArrayList <Lotissement> mesLotissements = new ArrayList<>();

        if (VerificationDonnee.verifierContenuFichierLot(enteteTerrain)) {
            JSONObject uniqueLot = enteteTerrain
                    .getJSONObject(EvaluationTerrain.ETIQUETTE_LOTISSEMENTS);

            String description = VerificationDonnee
                    .validerDescriptionLot(uniqueLot
                            .getString(EvaluationTerrain.ETIQUETTE_DESCRIPTION));
            int nombreDroitPassage = VerificationDonnee
                    .validerNombreDroitPassage(uniqueLot
                            .getInt(ETIQUETTE_DROIT_PASSAGE));
            int nombreService = VerificationDonnee
                    .validerNombreService(uniqueLot.getInt(ETIQUETTE_SERVICES));
            int superfice = VerificationDonnee
                    .validerSuperficie(uniqueLot.getInt(ETIQUETTE_SUPERFICIE));
            String dateMesure = VerificationDonnee
                    .validerDateMesure(uniqueLot
                            .getString(ETIQUETTE_DATE_MESURE));

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
            String description = VerificationDonnee
                    .validerDescriptionLot(plusieursLot
                            .getString(EvaluationTerrain
                                    .ETIQUETTE_DESCRIPTION));
            int nombreDroitPassage = VerificationDonnee
                    .validerNombreDroitPassage(plusieursLot
                            .getInt(ETIQUETTE_DROIT_PASSAGE));
            int nombreService = VerificationDonnee
                    .validerNombreService(plusieursLot
                            .getInt(ETIQUETTE_SERVICES));
            int superfice = VerificationDonnee
                    .validerSuperficie(plusieursLot
                            .getInt(ETIQUETTE_SUPERFICIE));
            String dateMesure = VerificationDonnee
                    .validerDateMesure(plusieursLot
                            .getString(ETIQUETTE_DATE_MESURE));

            lotissement = new Lotissement(description, nombreDroitPassage,
                    nombreService, superfice, dateMesure);

        }

        return lotissement;
    }

    @Override
    public String[] obtenirDescription(ArrayList<Lotissement> lotissements)
            throws NullPointerException, IntervallesValideException {
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

            iObservationLot.observerSuperficeParLot(superficies[i], i);

        }

        return superficies;
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
            throws NullPointerException, IntervallesValideException, ParseException {

        String [] dates = new String[obtenirNombreLot(lotissements)];

        for (int i = 0; i < obtenirNombreLot(lotissements); i++) {
            dates[i] = getLotissement(i, lotissements).getDateMesure();

        }
        iObservationLot.obtenirDifferenceDate(dates);

        return dates;
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
            montantsService[i] = montantLot.obtenirMontantService(i, superficies, services);

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

            iObservationLot.observerLotDispendieux(montantsParLot[i], i);

        }

        return montantsParLot;
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

        double valeurFonciere = tempTerrain + VALEUR_DE_BASE;

        iObservationLot.observerValeurFonciere(valeurFonciere);

        return valeurFonciere;

    }

}