package inf2050.e22.equipe2;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import net.sf.json.JSONObject;

/**
 *
 * @author akaff
 */
public class LancementProgramme implements ILancementProgramme {

    public final static String ENCODAGE_DE_FICHIER = "UTF-8";
    public static final int VALEUR_LOT_INF_1000 = 1000;
    public static final int VALEUR_LOT_MEDIUM_10000 = 10000;
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
    private StatistiquePresenter statistiquePresenter;
    private String donneeEntree;
    private ArrayList<String> lesObservations = new ArrayList<>();
    private RapportStatistique rapportStatistique;
    private int moins1000;
    private int entre1000et10000;
    private int plus10000;
    private int qteLotAgricole;
    private int qteLotResidentiel;
    private int qteLotCommercial;
    private int superficieMaximale;
    private int valeurMaxiLot;
    private String observation = "";

    public LancementProgramme(String donneeEntree)
            throws LotValideException, IntervallesValideException,
            PrixValideException, LectureFichierException, IOException,
            ParseException {
        this.donneeEntree = donneeEntree;
        this.evaluationTerrain = new EvaluationTerrain();
        this.evaluationLot = new EvaluationLot(lesLotissements, donneeEntree);
        this.rapportStatistique = new RapportStatistique(this);

        presenter = new LancementProgrammePresenter(this);
        statistiquePresenter = new StatistiquePresenter(this);

        presenter.obtenirDonneeLotissement(donneeEntree);
    }

    @Override
    public void getLesLotissements(String json)
            throws LotValideException, IntervallesValideException,
            PrixValideException, LectureFichierException, IOException,
            ParseException {
        lesLotissements = evaluationLot.obtenirDonneesLot();
        presenter.obtenirDonneeTerrain(json);
    }

    @Override
    public void getTerrain(String json)
            throws IntervallesValideException, PrixValideException,
            LotValideException, LectureFichierException, IOException,
            ParseException {
        terrain = evaluationTerrain.obtenirDonneesTerrain(json,
                evaluationLot);
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
            LotValideException, LectureFichierException, IOException,
            ParseException {
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
            IOException, IntervallesValideException, LectureFichierException,
            ParseException {
        VerificationDonnee.comparerPrixMinimumMaximum(lePrixMinimum,
                lePrixMaximum);
        presenter.obtenirDonneeQuantiteLots();
    }

    @Override
    public void getQuantiteLots() throws IntervallesValideException,
            LotValideException, LectureFichierException, IOException,
            ParseException {
        quantiteLots = evaluationLot.obtenirNombreLot(lesLotissements);

        presenter.obtenirDonneeDescription();
    }

    @Override
    public void getDescriptions() throws IntervallesValideException,
            LotValideException, LectureFichierException, IOException,
            ParseException {
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
        presenter.obtenirMaxSuperficie();
    }

    @Override
    public void getSuperficieMaximale()
            throws LotValideException, IOException, ParseException,
            IntervallesValideException, LectureFichierException {
        superficieMaximale = evaluationLot.obtenirMaximumSuperficie(
                lesSuperficies);

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
            LectureFichierException, IOException, ParseException {
        lesMontantsLots = evaluationLot.calculerMontantLot(idTerrain,
                lesSuperficies,
                lePrixMinimum, lePrixMaximum, lesLotissements);
        presenter.obtenirDonneeMontantPassage();
    }

    @Override
    public void getMontantsPassage()
            throws IntervallesValideException, LotValideException,
            LectureFichierException, IOException, ParseException {
        lesMontantsPassage = evaluationLot.calculerDroitPassage(idTerrain,
                lesDroitsPassages, lesMontantsLots, lesLotissements);
        presenter.obtenirDonneeMontantService();
    }

    @Override
    public void getMontantsService()
            throws IntervallesValideException, LotValideException,
            LectureFichierException, IOException, ParseException {
        lesMontantsServices = evaluationLot.calculerMontantService(idTerrain,
                lesSuperficies, lesServices, lesLotissements);
        presenter.obtenirDonneeMontantParLot();
    }

    @Override
    public void getMontantsParLot()
            throws IntervallesValideException, LotValideException,
            IOException, LectureFichierException, ParseException {
        lesMontantsParLot =  evaluationLot.calculerValeurParLot(
                lesMontantsLots, lesMontantsPassage, lesMontantsServices,
                lesLotissements);

        presenter.obtenirMaxValeurLot();
    }

    @Override
    public void getValeurLotMaximale() throws LotValideException, IOException,
            IntervallesValideException, LectureFichierException, ParseException {
        valeurMaxiLot = (int) evaluationLot.obtenirMaximumValeurParLot(
                lesMontantsParLot);

        presenter.obtenirDonneeMontantTerrain();
    }

    @Override
    public void getMontantTerrain()
            throws IntervallesValideException, LotValideException,
            LectureFichierException, IOException, ParseException {
        leMontantTerrain = evaluationLot.calculerValeurFonciere(
                lesMontantsParLot, lesLotissements);
        presenter.obtenirDonneeMontantTaxeScolaire();
    }

    @Override
    public void getMontantTaxeScolaire() throws LotValideException,
            LectureFichierException, IOException,
            ParseException, IntervallesValideException {
        leMontantTaxeScolaire = evaluationTerrain
                .calculerTaxeScolaire(leMontantTerrain);

        presenter.obtenirDonneeMontantTaxeMunicipale();
    }

    @Override
    public void getMontantTaxeMunicipale() throws LotValideException,
            LectureFichierException, IOException,
            ParseException, IntervallesValideException {
        leMontantTaxeMunicipale = evaluationTerrain
                .calculerTaxeMunicipale(leMontantTerrain);

        presenter.obtenirDescriptionLotDispendieux();

    }

    @Override
    public void getDescriptionLotDispendieux()
            throws IOException, IntervallesValideException, ParseException,
            LotValideException, LectureFichierException {
        String [] lesDonnees = evaluationLot.obtenirLotDispendieux(
                lesDescriptions,
                lesMontantsParLot, lesLotissements);

        for (String descriptionLot : lesDonnees) {
            if (descriptionLot != null && descriptionLot.length() > 0) {
                observation = EvaluationObservation.LA_VALEUR_PAR_LOT_DU_LOT
                        + descriptionLot + EvaluationObservation.EST_TROP_DISPENDIEUSE;
                ajoutObservationNonVide();
            }

        }

        presenter.obtenirEcartDateMaximal();
    }

    private void ajoutObservationNonVide() {
        if (observation != "") {
            lesObservations.add(observation);
        }
    }

    @Override
    public void getEcartMaximal()
            throws ParseException, IntervallesValideException, IOException,
            LotValideException, LectureFichierException {
        long [] lesDonnees = evaluationLot.obtenirEcartMaximalEntreDate(lesLotissements);

        for (long ecart : lesDonnees) {
            if (ecart != 0) {
                observation = EvaluationObservation.MSG_DATE;
                lesObservations.add(observation);
            }
        }

        presenter.obtenirValeurFonciere();
    }

    @Override
    public void getValeurFonciere() throws IntervallesValideException,
            IOException, LotValideException, LectureFichierException {
        double fonciere = evaluationLot.obtenirLotTropGrand(leMontantTerrain);

        if (fonciere != 0) {
            observation = EvaluationObservation
                    .VALEUR_FONCIÈRE_TOTALE_NE_DOIT_PAS_DÉPASSER_300000;
            lesObservations.add(observation);
        }

        presenter.obtenirSuperficieLot();
    }

    @Override
    public void getSuperficeParLot() throws IntervallesValideException,
            IOException, LotValideException, LectureFichierException {
        String [] lesDonnees = evaluationLot.obtenirLotSuperficieTropGrande(
                lesDescriptions,
                lesSuperficies, lesLotissements);

        for (String descriptionLot : lesDonnees) {
            if (descriptionLot != null && descriptionLot.length() > 0) {
                observation = EvaluationObservation.LA_SUPERFFICIE_DU_LOT
                        + descriptionLot + EvaluationObservation.EST_TROP_GRANDE;
                lesObservations.add(observation);
            }

        }

        presenter.obtenirTaxeMunicipale();
    }

    @Override
    public void getTaxeMunicipaleDouble() throws IOException,
            IntervallesValideException, LotValideException,
            LectureFichierException {
        double taxe = evaluationTerrain.obtenirTaxeMunicipaleDoubleVersement(
                leMontantTaxeMunicipale);

        if (taxe != 0) {
            observation = EvaluationObservation.MSG_DLE;
            lesObservations.add(observation);
        }

        presenter.obtenirTaxeScolaire();

    }

    @Override
    public void getTaxeScolaireDouble() throws IOException,
            IntervallesValideException, LotValideException,
            LectureFichierException {
        double taxe = evaluationTerrain.obtenirTaxeScolaireDoubleVersement(
                leMontantTaxeScolaire);
        if (taxe != 0) {
            observation = EvaluationObservation.MSG;
            lesObservations.add(observation);
        }

        presenter.obtenirDoublePrixMinMax();

    }

    @Override
    public void getTaxePrixMinMaxDouble() throws IOException,
            LotValideException, LectureFichierException {
        boolean estGrand = evaluationTerrain.obtenirPrixMaxDoublePrixMin(
                lePrixMinimum, lePrixMaximum);

        if (estGrand) {
            observation = EvaluationObservation
                    .PAS_DÉPASSER_DEUX_FOIS_LE_PRIX_MINIMUM_DU_M_2;
            lesObservations.add(observation);
        }

        presenter.obtenirDonneeRapporter();

    }

    @Override
    public void rapporterSiBon() throws LotValideException,
            LectureFichierException, IOException {
        rapport = evaluationTerrain
                .fournirRapportValide(leMontantTerrain,
                        leMontantTaxeScolaire, leMontantTaxeMunicipale,
                        lesMontantsParLot, lesDescriptions, lesObservations);

        presenter.obtenirDonneeAfficher();
    }

    @Override
    public void afficherRapport() {
        Utilitaire.afficherMessage(rapport.toString(4));
    }

    public void enregisterRapportDansFichier(String json)
            throws LectureFichierException, IOException,
            IntervallesValideException, ParseException {
        VerificationDonnee.enregistrerDonneeDansFichier(json,
                rapport.toString(4), ENCODAGE_DE_FICHIER);

        presenter.obtenirPrixReparti();
    }

    @Override
    public void getPrixReparti() throws IOException {
        double prix = rapportStatistique.obtenirMontantRepartiParLot(
                lesMontantsParLot, lesLotissements);

        obtenirMontantReparti(prix);

        statistiquePresenter.obenirCalculStatistiques();
    }

    private void obtenirMontantReparti(double montantsParLot) {
        if (montantsParLot < VALEUR_LOT_INF_1000) {
            moins1000++;
        } else if (estComprisEntre1000Et10000(montantsParLot)) {
            entre1000et10000++;
        } else {
            plus10000++;
        }
    }

    private boolean estComprisEntre1000Et10000(double montantsParLot) {
        return montantsParLot > VALEUR_LOT_INF_1000
                && montantsParLot < VALEUR_LOT_MEDIUM_10000;
    }

    @Override
    public void obenirCalculRapportStatistiques() throws IOException {
        obtenirQuantiteEnFonctionId();

        rapportStatistique.rapporterStatistiques(quantiteLots,
                moins1000,
                entre1000et10000,
                plus10000,
                qteLotAgricole,
                qteLotResidentiel,
                qteLotCommercial,
                superficieMaximale,
                valeurMaxiLot);
    }

    private void obtenirQuantiteEnFonctionId() {
        if (idTerrain == MontantLot.TERRAIN_AGRICOLE) {
            qteLotAgricole = qteLotAgricole + quantiteLots;
        } else if (idTerrain == MontantLot.TERRAIN_RESIDENTIEL) {
            qteLotResidentiel = qteLotResidentiel + quantiteLots;
        } else if (idTerrain == MontantLot.TERRAIN_COMMERCIAL) {
            qteLotCommercial = qteLotCommercial + quantiteLots;
        }
    }
}