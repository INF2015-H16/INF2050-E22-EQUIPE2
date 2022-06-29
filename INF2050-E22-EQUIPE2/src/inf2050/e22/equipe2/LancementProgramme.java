/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inf2050.e22.equipe2;

import java.io.IOException;
import java.util.ArrayList;
import net.sf.json.JSONObject;

/**
 *
 * @author akaff
 */
public class LancementProgramme implements ILancementProgramme {

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
    EvaluationTerrain evaluationTerrain;
    EvaluationLot evaluationLot;
    JSONObject rapport;
    Terrain terrain;
    ArrayList<Lotissement> lesLotissements;
    LancementProgrammePresenter presenter;
    private String donneeEntree;

    public LancementProgramme(String donneeEntree)
            throws LotValideException, IntervallesValideException,
            PrixValideException, LectureFichierException, IOException {
        this.donneeEntree = donneeEntree;
        this.evaluationTerrain = new EvaluationTerrain();
        this.evaluationLot = new EvaluationLot(lesLotissements, donneeEntree);
        presenter = new LancementProgrammePresenter(this);

        presenter.obtenirDonneeLotissement(donneeEntree);
    }

    @Override
    public void getLesLotissements(String json)
            throws LotValideException, IntervallesValideException,
            PrixValideException, LectureFichierException, IOException {
        lesLotissements = evaluationLot.obtenirDonneesLot();
        presenter.obtenirDonneeTerrain(json);
    }

    @Override
    public void getTerrain(String json)
            throws IntervallesValideException, PrixValideException,
            LotValideException, LectureFichierException, IOException {
        terrain = evaluationTerrain.obtenirDonneesTerrain(json,
                evaluationLot);
        presenter.obtenirDonneIdTerrain();
    }

    @Override
    public void getIdTerrain() throws PrixValideException,
            IntervallesValideException, LotValideException,
            LectureFichierException, IOException {
        idTerrain = evaluationTerrain.obtenirTypeTerrain(terrain);
        presenter.obtenirDonneePrixMinimum();
    }

    @Override
    public void getPrixMinimum()
            throws PrixValideException, IntervallesValideException,
            LotValideException, LectureFichierException, IOException {
        lePrixMinimum =  evaluationTerrain.obtenirPrixMinimum(terrain);
        presenter.obtenirDonneePrixMaximum();
    }

    @Override
    public void getPrixMaximum()
            throws PrixValideException, IntervallesValideException,
            LotValideException, LectureFichierException, IOException {
        lePrixMaximum = evaluationTerrain.obtenirPrixMaximum(terrain);
        presenter.obtenirDonneeQuantiteLots();
    }

    @Override
    public void getQuantiteLots() throws IntervallesValideException,
            LotValideException, LectureFichierException, IOException {
        quantiteLots = evaluationLot.obtenirNombreLot(lesLotissements);
        presenter.obtenirDonneeDescription();
    }

    @Override
    public void getDescriptions() throws IntervallesValideException,
            LotValideException, LectureFichierException, IOException {
        lesDescriptions = evaluationLot.obtenirDescription(lesLotissements);
        presenter.obtenirDonneePassages();
    }

    @Override
    public void getPassages()
            throws IntervallesValideException, LotValideException,
            LectureFichierException, IOException {
        lesDroitsPassages = evaluationLot.obtenirNombreDroitPassage(
                lesLotissements);
        presenter.obtenirDonneeServices();
    }

    @Override
    public void getNombreService()
            throws IntervallesValideException, LotValideException,
            LectureFichierException, IOException {
        lesServices = evaluationLot.obtenirNombreService(lesLotissements);
        presenter.obtenirDonneeSuperficie();
    }

    @Override
    public void getSuperficies()
            throws IntervallesValideException, LotValideException,
            LectureFichierException, IOException {
        lesSuperficies = evaluationLot.obtenirSuperficie(lesLotissements);
        presenter.obtenirDonneeDates();
    }

    @Override
    public void getDates()
            throws IntervallesValideException, LotValideException,
            LectureFichierException, IOException {
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
        lesMontantsParLot=  evaluationLot.calculerValeurParLot(lesMontantsLots,
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
                        lesMontantsParLot, lesDescriptions);

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

}