package inf2050.e22.equipe2;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import net.sf.json.JSONObject;

/**
 *
 * @author akaff
 */
public class LancementProgramme implements ILancementProgramme,
        IObservationLot, IObservationTerrain {

    public final static String ENCODAGE_DE_FICHIER = "UTF-8";
    private int idTerrain;
    private double lePrixMinimum;
    private double lePrixMaximum;
    private int quantiteLots;
    private String [] lesDescriptions;
    private int [] lesDroitsPassages;
    private int [] lesServices;
    private int [] lesSuperficies;
    private String [] lesDates;
    private double [] lesMontantsLots;
    private double [] lesMontantsPassage;
    private double [] lesMontantsServices;
    private double [] lesMontantsParLot;
    private double leMontantTerrain;
    private double leMontantTaxeScolaire;
    private double leMontantTaxeMunicipale;
    private EvaluationTerrain evaluationTerrain;
    private EvaluationLot evaluationLot;
    private JSONObject rapport;
    private Terrain terrain;
    private ArrayList<Lotissement> lesLotissements;
    private LancementProgrammePresenter presenter;
    private String donneeEntree;
    private ArrayList<String> observations = new ArrayList<>();

    public LancementProgramme(String donneeEntree)
            throws LotValideException, IntervallesValideException,
            PrixValideException, LectureFichierException, IOException, ParseException {
        this.donneeEntree = donneeEntree;
        this.evaluationTerrain = new EvaluationTerrain(this);
        this.evaluationLot = new EvaluationLot(lesLotissements, donneeEntree, this);
        presenter = new LancementProgrammePresenter(this);

        presenter.obtenirDonneeLotissement(donneeEntree);
    }

    @Override
    public void getLesLotissements(String json)
            throws LotValideException, IntervallesValideException,
            PrixValideException, LectureFichierException, IOException, ParseException {
        lesLotissements = evaluationLot.obtenirDonneesLot();
        presenter.obtenirDonneeTerrain(json);
    }

    @Override
    public void getTerrain(String json)
            throws IntervallesValideException, PrixValideException,
            LotValideException, LectureFichierException, IOException, ParseException {
        terrain = evaluationTerrain.obtenirDonneesTerrain(json,
                evaluationLot, observations);
        presenter.obtenirDonneIdTerrain();
    }

    @Override
    public void getIdTerrain() throws PrixValideException,
            IntervallesValideException, LotValideException,
            LectureFichierException, IOException, ParseException {
        idTerrain = evaluationTerrain.obtenirTypeTerrain(terrain);
        presenter.obtenirDonneePrixMinimum();
    }

    @Override
    public void getPrixMinimum()
            throws PrixValideException, IntervallesValideException,
            LotValideException, LectureFichierException, IOException, ParseException {
        lePrixMinimum =  evaluationTerrain.obtenirPrixMinimum(terrain);
        presenter.obtenirDonneePrixMaximum();
    }

    @Override
    public void getPrixMaximum()
            throws PrixValideException, LotValideException,
            IOException, IntervallesValideException,
            LectureFichierException, ParseException {
        lePrixMaximum = evaluationTerrain.obtenirPrixMaximum(terrain);
        presenter.obtenirPrixMinPrixMaxVerifie();
    }

    @Override
    public void getPrixMinPrixMaxVerifier()
            throws PrixValideException, LotValideException,
            IOException, IntervallesValideException, LectureFichierException, ParseException {
        evaluationTerrain.comparerPrixMinimumMaximum(lePrixMinimum,
                lePrixMaximum);
        presenter.obtenirDonneeQuantiteLots();
    }

    @Override
    public void getQuantiteLots() throws IntervallesValideException,
            LotValideException, LectureFichierException, IOException, ParseException {
        quantiteLots = evaluationLot.obtenirNombreLot(lesLotissements);
        presenter.obtenirDonneeDescription();
    }

    @Override
    public void getDescriptions() throws IntervallesValideException,
            LotValideException, LectureFichierException, IOException, ParseException {
        lesDescriptions = evaluationLot.obtenirDescription(lesLotissements);
        presenter.obtenirDonneePassages();
    }

    @Override
    public void getPassages()
            throws IntervallesValideException, LotValideException,
            LectureFichierException, IOException, ParseException {
        lesDroitsPassages = evaluationLot.obtenirNombreDroitPassage(
                lesLotissements);
        presenter.obtenirDonneeServices();
    }

    @Override
    public void getNombreService()
            throws IntervallesValideException, LotValideException,
            LectureFichierException, IOException, ParseException {
        lesServices = evaluationLot.obtenirNombreService(lesLotissements);
        presenter.obtenirDonneeSuperficie();
    }

    @Override
    public void getSuperficies()
            throws IntervallesValideException, LotValideException,
            LectureFichierException, IOException, ParseException {
        lesSuperficies = evaluationLot.obtenirSuperficie(lesLotissements);
        presenter.obtenirDonneeDates();
    }

    @Override
    public void getDates()
            throws IntervallesValideException, LotValideException,
            LectureFichierException, IOException, ParseException {
        lesDates = evaluationLot.obtenirDateMesure(lesLotissements);
        presenter.obtenirDonneeMontantLot();
    }

    @Override
    public void getMontantsLot()
            throws IntervallesValideException, LotValideException,
            LectureFichierException, IOException {
        lesMontantsLots = evaluationLot.calculerMontantLot(idTerrain,
                lesSuperficies,
                lePrixMinimum, lePrixMaximum, lesLotissements);
        presenter.obtenirDonneeMontantPassage();
    }

    @Override
    public void getMontantsPassage()
            throws IntervallesValideException, LotValideException,
            LectureFichierException, IOException {
        lesMontantsPassage = evaluationLot.calculerDroitPassage(idTerrain,
                lesDroitsPassages, lesMontantsLots, lesLotissements);
        presenter.obtenirDonneeMontantService();
    }

    @Override
    public void getMontantsService()
            throws IntervallesValideException, LotValideException,
            LectureFichierException, IOException {
        lesMontantsServices = evaluationLot.calculerMontantService(idTerrain,
                lesSuperficies, lesServices, lesLotissements);
        presenter.obtenirDonneeMontantParLot();
    }

    @Override
    public void getMontantsParLot()
            throws IntervallesValideException, LotValideException,
            LectureFichierException, IOException {
        lesMontantsParLot =  evaluationLot.calculerValeurParLot(lesMontantsLots,
                lesMontantsPassage, lesMontantsServices, lesLotissements);
        presenter.obtenirDonneeMontantTerrain();
    }

    @Override
    public void getMontantTerrain()
            throws IntervallesValideException, LotValideException,
            LectureFichierException, IOException {
        leMontantTerrain = evaluationLot.calculerValeurFonciere(
                lesMontantsParLot, lesLotissements);
        presenter.obtenirDonneeMontantTaxeScolaire();
    }

    @Override
    public void getMontantTaxeScolaire() throws LotValideException,
            LectureFichierException, IOException {
        leMontantTaxeScolaire = evaluationTerrain
                .calculerTaxeScolaire(leMontantTerrain);
        presenter.obtenirDonneeMontantTaxeMunicipale();
    }

    @Override
    public void getMontantTaxeMunicipale() throws LotValideException,
            LectureFichierException, IOException {
        leMontantTaxeMunicipale = evaluationTerrain
                .calculerTaxeMunicipale(leMontantTerrain);
        presenter.obtenirDonneeRapporter();
    }

    @Override
    public void rapporterSiBon() throws LotValideException,
            LectureFichierException, IOException {
        rapport = evaluationTerrain
                .fournirRapportValide(leMontantTerrain,
                        leMontantTaxeScolaire, leMontantTaxeMunicipale,
                        lesMontantsParLot, lesDescriptions, observations);

        presenter.obtenirDonneeAfficher();
    }

    @Override
    public void afficherRapport() {
        Utilitaire.afficherMessage(rapport.toString(4));
    }

    public void enregisterRapportDansFichier(String json)
            throws LectureFichierException, IOException {
        VerificationDonnee.enregistrerDonneeDansFichier(json,
                rapport.toString(4), ENCODAGE_DE_FICHIER);
    }

    @Override
    public void observerLotDispendieux(double montantsParLot, int i) {
        String observation = EvaluationObservation.LA_VALEUR_PAR_LOT_DU_LOT
                + (i + 1) + EvaluationObservation.EST_TROP_DISPENDIEUSE;

        observations.add(observation);
    }

    @Override
    public void obtenirDifferenceDate(String [] dateLot)
            throws IntervallesValideException, ParseException {
        String [] observation = EvaluationObservation
                .obtenirDifferenceEntreDate(dateLot, lesLotissements);

        observations.addAll(Arrays.asList(observation));

    }

    @Override
    public void observerSuperficeParLot(int superficies, int i) {
        String observation = EvaluationObservation.LA_SUPERFFICIE_DU_LOT
                + (i + 1)+ EvaluationObservation.EST_TROP_GRANDE;

        observations.add(observation);
    }

    @Override
    public void observerDoubleVersementTaxeMunicipale(double taxe) {
        String observation = EvaluationObservation.MSG_DLE;

        observations.add(observation);
    }

    @Override
    public void observerDoubleVersementTaxeScolaire(double taxe) {
        String observation = EvaluationObservation.MSG;

        observations.add(observation);

    }

    @Override
    public void observerValeurFonciere(double fonciere) {
        String observation = EvaluationObservation
                .VALEUR_FONCIÈRE_TOTALE_NE_DOIT_PAS_DÉPASSER_300000;

        observations.add(observation);
    }

    @Override
    public void observerPrixMaxVsMin() {
        String observation = EvaluationObservation
                .PAS_DÉPASSER_DEUX_FOIS_LE_PRIX_MINIMUM_DU_M_2;

        observations.add(observation);
    }

}