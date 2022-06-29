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

public class EvaluationLot implements IEvaluationLot{

    public final static double VALEUR_DE_BASE = 733.77;
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
    public final static String ETIQUETTE_DROIT_PASSAGE =
            "nombre_droits_passage";
    public final static String ETIQUETTE_SERVICES = "nombre_services";
    public final static String ETIQUETTE_SUPERFICIE = "superficie";
    public final static String ETIQUETTE_DATE_MESURE = "date_mesure";
    private ArrayList<Lotissement> lotissements;
    private final String json;

    public EvaluationLot(String json)  {
        lotissements = new ArrayList<>();
        this.json = json;
    }

    public ArrayList<Lotissement> getLotissements()
            throws LotValideException, IOException {
        return obtenirDonneesLot();
    }

    public void setLotissements(ArrayList<Lotissement> lotissements) {
        this.lotissements = lotissements;
    }

    public String[] getDescriptions() throws IOException {
        return obtenirDescription();
    }

    public int[] getPassages() throws IOException {
        return obtenirNombreDroitPassage();
    }

    public int[] getServices() throws IOException {
        return obtenirNombreService();
    }

    public int[] getSuperficies() throws IOException {
        return obtenirSuperficie();
    }

    public String[] getDates() throws IOException {
        return obtenirDateMesure();
    }

    @Override
    public int obtenirNombreLot() {
        return lotissements.size();
    }

    @Override
    public ArrayList<Lotissement> obtenirDonneesLot()
            throws FileNotFoundException, IOException,
            NumberFormatException, LotValideException {

        ArrayList <Lotissement> mesLotissements = new ArrayList<>();

        if (json.length() != 0) {
            JSONObject enteteTerrain = JSONObject.fromObject(json);

            Object item = enteteTerrain.get(EvaluationTerrain
                    .ETIQUETTE_LOTISSEMENTS);

            if (item instanceof JSONObject) {
                mesLotissements = obtenirUniqueLot(enteteTerrain);

            } else {
                mesLotissements = lis(enteteTerrain);

            }
        }

        return mesLotissements;
    }

    private ArrayList<Lotissement> lis(JSONObject enteteTerrain)
            throws LotValideException {

        ArrayList <Lotissement> lots = new ArrayList<>();
        JSONArray list = enteteTerrain
                .getJSONArray(EvaluationTerrain.ETIQUETTE_LOTISSEMENTS);

        if (!list.isEmpty()) {
            lots = obtenirListeLot(list);

        }

        return lots;
    }

    private ArrayList<Lotissement> obtenirUniqueLot(JSONObject enteteTerrain)
            throws LotValideException {
        ArrayList <Lotissement> mesLotissements = new ArrayList<>();
        JSONObject uniqueLot = enteteTerrain
                .getJSONObject(EvaluationTerrain.ETIQUETTE_LOTISSEMENTS);

        String description = VerificationDonnee
                .validerDescriptionLot(uniqueLot
                        .getString(EvaluationTerrain.ETIQUETTE_DESCRIPTION));
        int nombreDroitPassage = VerificationDonnee
                .valeurEstInt(uniqueLot
                        .getInt(ETIQUETTE_DROIT_PASSAGE));
        int nombreService = VerificationDonnee
                .valeurEstInt(uniqueLot.getInt(ETIQUETTE_SERVICES));
        int superfice = VerificationDonnee
                .valeurEstInt(uniqueLot.getInt(ETIQUETTE_SUPERFICIE));
        String dateMesure = VerificationDonnee
                .validerDateMesure(uniqueLot
                        .getString(ETIQUETTE_DATE_MESURE));

        Lotissement lot = new Lotissement(description, nombreDroitPassage,
                nombreService, superfice, dateMesure);
                mesLotissements.add(lot);

        return mesLotissements;
    }

    private ArrayList<Lotissement> obtenirListeLot(JSONArray list)
            throws LotValideException {
        ArrayList <Lotissement> mesLotissements = new ArrayList<>();

        for(int i = 0; i<list.size(); i++) {
            JSONObject plusieursLot = list.getJSONObject(i);

            Lotissement lot = obtenirPourPlusieurs(plusieursLot);

            mesLotissements.add(lot);
        }

        return mesLotissements;

    }

    private Lotissement obtenirPourPlusieurs(JSONObject plusieursLot)
            throws LotValideException {

        String description = VerificationDonnee
                .validerDescriptionLot(plusieursLot
                        .getString(EvaluationTerrain.ETIQUETTE_DESCRIPTION));
        int nombreDroitPassage = VerificationDonnee
                .valeurEstInt(plusieursLot
                        .getInt(ETIQUETTE_DROIT_PASSAGE));
        int nombreService = VerificationDonnee
                .valeurEstInt(plusieursLot
                        .getInt(ETIQUETTE_SERVICES));
        int superficie = VerificationDonnee
                .valeurEstInt(plusieursLot
                        .getInt(ETIQUETTE_SUPERFICIE));
        String dateMesure = VerificationDonnee
                .validerDateMesure(plusieursLot
                        .getString(ETIQUETTE_DATE_MESURE));

        return new Lotissement(description, nombreDroitPassage,
                nombreService, superficie, dateMesure);

    }

    @Override
    public String[] obtenirDescription()
            throws IOException, NullPointerException {

        String [] descriptions = new String[obtenirNombreLot()];

        for (int i = 0; i < obtenirNombreLot(); i++) {
            String descriptionLot = lotissements.get(i).getDescription();

            descriptions[i] = descriptionLot;
        }

        return descriptions;
    }

    @Override
    public int [] obtenirNombreDroitPassage()
            throws IOException, NullPointerException {

        int[] passages = new int[obtenirNombreLot()];

        for (int i = 0; i < obtenirNombreLot(); i++) {
            int droitPassage = lotissements.get(i).getNombreDroitPassage();

            passages[i] = droitPassage;

        }
        return passages;
    }

    @Override
    public int [] obtenirNombreService()
            throws IOException, NullPointerException {

        int[] services = new int[obtenirNombreLot()];

        for (int i = 0; i < obtenirNombreLot(); i++) {
            int servive = lotissements.get(i).getNombreService();

            services[i] = servive;

        }

        return services;
    }

    @Override
    public int [] obtenirSuperficie()
            throws IOException, NullPointerException {

        int[] superficies = new int[obtenirNombreLot()];

        for (int i = 0; i < obtenirNombreLot(); i++) {

            int superficie = lotissements.get(i).getSuperficie();

            superficies[i] = superficie;

        }

        return superficies;
    }

    @Override
    public String [] obtenirDateMesure()
            throws IOException, NullPointerException {

        String [] dates = new String[obtenirNombreLot()];

        for (int i = 0; i < obtenirNombreLot(); i++) {
            String date = lotissements.get(i).getDateMesure();

            dates[i] = date;

        }

        return dates;
    }

    @Override
    public double [] calculerMontantLot(int idTerrain,
                                        int [] superficies, double prixMinimum,
            double prixMaximum)
            throws IOException, NullPointerException {

        double [] montantsLot = new double[obtenirNombreLot()];

        for (int i = 0; i < obtenirNombreLot(); i++) {
            double montantLot = obtenirMontantLot(i, idTerrain,
                    superficies, prixMinimum, prixMaximum);
            montantsLot[i] = montantLot;

        }

        return montantsLot;
    }

    private double obtenirMontantLot(int index, int idTerrain,
                                     int [] superficies, double prixMinimum,
                       double prixMaximum) {

        double montantLot = 0.0;
        if (idTerrain == Terrain.TERRAIN_AGRICOLE) {
            montantLot = superficies[index] * prixMinimum;

        } else if (idTerrain == Terrain.TERRAIN_RESIDENTIEL) {
            montantLot = superficies[index] *
                    ((prixMinimum + prixMaximum)/2);

        } else if (idTerrain == Terrain.TERRAIN_COMMERCIAL) {
            montantLot = superficies[index] * prixMaximum;

        }

        return montantLot;
    }

    @Override
    public double [] calculerDroitPassage(int idTerrain, int [] passages,
                                          double [] montantsLot)
            throws IOException, NullPointerException {

        double [] montantsPassage = new double[obtenirNombreLot()];

        for (int i = 0; i < obtenirNombreLot(); i++) {
            double montantDroit = obtenirMontantPassage(i, idTerrain,
                    passages, montantsLot);

            montantsPassage[i] = montantDroit;

        }

        return montantsPassage;
    }

    private double obtenirMontantPassage(int index, int idTerrain,
                                         int [] passages,
                                         double [] montantsLot) {
        double montantDroit = 0.0;
        if (idTerrain == Terrain.TERRAIN_AGRICOLE) {
            montantDroit = MONTANT_BASE_DROIT_PASSAGE
                    - (passages[index]
                    * (TAUX_05 * montantsLot[index]));
        } else if (idTerrain == Terrain.TERRAIN_RESIDENTIEL) {
            montantDroit = MONTANT_BASE_DROIT_PASSAGE
                    - (passages[index]
                    * (TAUX_10 * montantsLot[index]));

        } else if (idTerrain == Terrain.TERRAIN_COMMERCIAL) {
            montantDroit = MONTANT_BASE_DROIT_PASSAGE
                    - (passages[index]
                    * (TAUX_15 * montantsLot[index]));

        }
        return montantDroit;

    }

    @Override
    public double [] calculerMontantService(int idTerrain,
            int [] superficies, int [] services) throws IOException,
            NullPointerException {

        double [] montantsService = new double[obtenirNombreLot()];

        double montantService;

        for (int i = 0; i < obtenirNombreLot(); i++) {
            montantService = obtenirMontantService(i,
                    idTerrain, superficies, services);

            montantsService[i] = montantService;

        }

        return montantsService;
    }

    private double obtenirMontantService(int index, int idTerrain,
                         int [] superficies, int [] services) {

        double montantService = 0.0;

        if (idTerrain == Terrain.TERRAIN_AGRICOLE) {
            montantService = MONTANT_SERVICE_0;

        } else if (idTerrain == Terrain.TERRAIN_RESIDENTIEL) {
            montantService = evaluerTerrainResidentiel(index,
                    superficies, services);

        } else if (idTerrain == Terrain.TERRAIN_COMMERCIAL) {
            montantService = determinerMontantCommercial(
                    evaluerTerrainCommercial(index, superficies, services));

        }

        return montantService;
    }

    private double evaluerTerrainResidentiel(int index, int [] superficies,
                                            int [] services) {
        double service;

        if (superficies[index] <= SUPERFICIE_500) {
            service = MONTANT_SERVICE_0;
        } else if (superficies[index] > SUPERFICIE_500
                && superficies[index] <= SUPERFICIE_10000) {
            service = (SERVICE_DE_BASE
                    + services[index]) * MONTANT_SERVICE_500;
        } else {
            service = (SERVICE_DE_BASE
                    + services[index]) * MONTANT_SERVICE_1000;
        }

        return service;
    }
    private double evaluerTerrainCommercial(int index, int [] superficies,
                                            int [] services) {
        double service = 0.0;

        if (superficies[index] <= SUPERFICIE_500) {
            service = (SERVICE_DE_BASE
                    + services[index]) * MONTANT_SERVICE_500;

        } else if (superficies[index] > SUPERFICIE_500) {
            service = (SERVICE_DE_BASE
                    + services[index]) * MONTANT_SERVICE_1500;
        }

        return service;
    }

    private double determinerMontantCommercial(double montantService) {

        double montant;

        if (montantService > MONTANT_MAX_SERVICE) {
            montant = MONTANT_MAX_SERVICE;

        } else {
            montant = montantService;

        }

        return montant;
    }

    @Override
    public double [] calculerValeurParLot(double[] montantsLot,
            double[] montantsPassage, double[] montantsService)
            throws IOException, NullPointerException {

        double [] montantsParLot = new double[obtenirNombreLot()];

        for (int i = 0; i < obtenirNombreLot(); i++) {
            double valeurParLot = montantsLot[i] + montantsPassage[i] +
                    montantsService[i];

            montantsParLot[i] = valeurParLot;

        }

        return montantsParLot;

    }

    @Override
    public double calculerValeurFonciere(double [] montantsParLot)
            throws IOException, NullPointerException {

        double tempTerrain = 0.0;

        for (int i = 0; i < obtenirNombreLot(); i++) {
            tempTerrain = tempTerrain + montantsParLot[i]++;
        }

        return (tempTerrain + VALEUR_DE_BASE);

    }

}
