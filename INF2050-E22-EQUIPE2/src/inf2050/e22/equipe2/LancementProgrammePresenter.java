package inf2050.e22.equipe2;

import java.io.IOException;
import java.text.ParseException;

/**
 *
 * @author akaff
 */
public class LancementProgrammePresenter {

    private ILancementProgramme iLancementProgramme;

    public LancementProgrammePresenter(
            ILancementProgramme iLancementProgramme) {
        this.iLancementProgramme = iLancementProgramme;
    }

    public void obtenirDonneeLotissement(String json)
            throws LotValideException, IntervallesValideException,
            PrixValideException, LectureFichierException, IOException,
            ParseException {
        iLancementProgramme.getLesLotissements(json);
    }

    public void obtenirDonneeTerrain(String json)
            throws IntervallesValideException, PrixValideException,
            LotValideException, LectureFichierException, IOException,
            ParseException {
        iLancementProgramme.getTerrain(json);
    }

    public void obtenirDonneIdTerrain() throws PrixValideException,
            IntervallesValideException, LotValideException,
            LectureFichierException, IOException, ParseException {
        iLancementProgramme.getIdTerrain();
    }

    public void obtenirDonneePrixMinimum() throws PrixValideException,
            IntervallesValideException, LotValideException,
            LectureFichierException, IOException, ParseException {
        iLancementProgramme.getPrixMinimum();
    }

    public void obtenirDonneePrixMaximum() throws PrixValideException,
            IntervallesValideException, LotValideException,
            LectureFichierException, IOException, ParseException {
        iLancementProgramme.getPrixMaximum();
    }

    public void  obtenirPrixMinPrixMaxVerifie() throws PrixValideException,
            LotValideException, IOException, IntervallesValideException,
            LectureFichierException, ParseException {
        iLancementProgramme.getPrixMinPrixMaxVerifier();
    }

    public void obtenirDonneeQuantiteLots()
            throws IntervallesValideException,
            LotValideException, LectureFichierException,
            IOException, ParseException {
        iLancementProgramme.getQuantiteLots();
    }

    public void obtenirDonneeDescription() throws IntervallesValideException,
            LotValideException, LectureFichierException, IOException,
            ParseException {
        iLancementProgramme.getDescriptions();
    }

    public void obtenirDonneePassages() throws IntervallesValideException,
            LotValideException, LectureFichierException, IOException,
            ParseException {
        iLancementProgramme.getPassages();
    }

    public void obtenirDonneeServices() throws IntervallesValideException,
            LotValideException, LectureFichierException, IOException,
            ParseException {
        iLancementProgramme.getNombreService();
    }

    public void obtenirDonneeSuperficie()
            throws IntervallesValideException, LotValideException,
            LectureFichierException, IOException, ParseException {
        iLancementProgramme.getSuperficies();
    }

    public void obtenirMaxSuperficie()
            throws LotValideException, IOException, ParseException,
            IntervallesValideException, LectureFichierException {
        iLancementProgramme.getSuperficieMaximale();
    }

    public void obtenirDonneeDates()
            throws IntervallesValideException, LotValideException,
            LectureFichierException, IOException, ParseException {
        iLancementProgramme.getDates();
    }

    public void obtenirDonneeMontantLot()
            throws IntervallesValideException, LotValideException,
            LectureFichierException, IOException, ParseException {
        iLancementProgramme.getMontantsLot();
    }

    public void obtenirDonneeMontantPassage()
            throws IntervallesValideException, LotValideException,
            LectureFichierException, IOException, ParseException {
        iLancementProgramme.getMontantsPassage();
    }

    public void obtenirDonneeMontantService()
            throws IntervallesValideException, LotValideException,
            LectureFichierException, IOException, ParseException {
        iLancementProgramme.getMontantsService();
    }

    public void obtenirDonneeMontantParLot()
            throws IntervallesValideException,
            LotValideException, LectureFichierException,
            IOException, ParseException {
        iLancementProgramme.getMontantsParLot();
    }

    public void obtenirMaxValeurLot() throws LotValideException, IOException,
            IntervallesValideException, LectureFichierException,
            ParseException {
        iLancementProgramme.getValeurLotMaximale();
    }

    public void obtenirDonneeMontantTerrain()
            throws IntervallesValideException,
            LotValideException, LectureFichierException, IOException,
            ParseException {
        iLancementProgramme.getMontantTerrain();
    }

    public void obtenirDonneeMontantTaxeScolaire()
            throws LotValideException, LectureFichierException, IOException,
            ParseException, IntervallesValideException {
        iLancementProgramme.getMontantTaxeScolaire();
    }

    public void obtenirDonneeMontantTaxeMunicipale()
            throws LotValideException, LectureFichierException, IOException,
            ParseException, IntervallesValideException {
        iLancementProgramme.getMontantTaxeMunicipale();
    }

    public void obtenirDonneeRapporter()
            throws LotValideException, LectureFichierException, IOException {
        iLancementProgramme.rapporterSiBon();
    }

    public void obtenirDonneeAfficher()
            throws LectureFichierException, IOException, LotValideException {
        iLancementProgramme.afficherRapport();
    }

    public void obtenirDescriptionLotDispendieux()
            throws IOException, IntervallesValideException, ParseException,
            LotValideException, LectureFichierException {
        iLancementProgramme.getDescriptionLotDispendieux();
    }

    public void obtenirEcartDateMaximal()
            throws ParseException, IntervallesValideException, IOException,
            LotValideException, LectureFichierException {
        iLancementProgramme.getEcartMaximal();
    }

    public void obtenirValeurFonciere() throws IntervallesValideException,
            IOException, LotValideException, LectureFichierException {
        iLancementProgramme.getValeurFonciere();

    }

    public void obtenirSuperficieLot() throws IntervallesValideException,
            IOException, LotValideException, LectureFichierException {
        iLancementProgramme.getSuperficeParLot();

    }

    public void obtenirTaxeMunicipale() throws IOException,
            IntervallesValideException, LotValideException,
            LectureFichierException {
        iLancementProgramme.getTaxeMunicipaleDouble();
    }

    public void obtenirTaxeScolaire() throws IOException,
            IntervallesValideException, LotValideException,
            LectureFichierException {
        iLancementProgramme.getTaxeScolaireDouble();
    }

    public void obtenirDoublePrixMinMax() throws IOException,
            IntervallesValideException, LotValideException,
            LectureFichierException {
        iLancementProgramme.getTaxePrixMinMaxDouble();
    }

    public void obtenirPrixReparti()
            throws IOException, IntervallesValideException {
        iLancementProgramme.getPrixReparti();
    }

}