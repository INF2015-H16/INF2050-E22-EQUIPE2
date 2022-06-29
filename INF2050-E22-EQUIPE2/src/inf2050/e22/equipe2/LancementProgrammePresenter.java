/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inf2050.e22.equipe2;

import java.io.IOException;

/**
 *
 * @author akaff
 */
public class LancementProgrammePresenter {

    private ILancementProgramme iLancementProgramme;

    public LancementProgrammePresenter(ILancementProgramme iLancementProgramme) {
        this.iLancementProgramme = iLancementProgramme;
    }

    public void obtenirDonneeLotissement(String json)
            throws LotValideException, IntervallesValideException,
            PrixValideException, LectureFichierException, IOException {
        iLancementProgramme.getLesLotissements(json);
    }

    public void obtenirDonneeTerrain(String json)
            throws IntervallesValideException, PrixValideException,
            LotValideException, LectureFichierException, IOException {
        iLancementProgramme.getTerrain(json);
    }

    public void obtenirDonneIdTerrain() throws PrixValideException,
            IntervallesValideException, LotValideException,
            LectureFichierException, IOException {
        iLancementProgramme.getIdTerrain();
    }

    public void obtenirDonneePrixMinimum() throws PrixValideException,
            IntervallesValideException, LotValideException,
            LectureFichierException, IOException {
        iLancementProgramme.getPrixMinimum();
    }

    public void obtenirDonneePrixMaximum() throws PrixValideException,
            IntervallesValideException, LotValideException,
            LectureFichierException, IOException {
        iLancementProgramme.getPrixMaximum();
    }

    public void  obtenirPrixMinPrixMaxVerifie() throws PrixValideException,
            LotValideException, IOException, IntervallesValideException,
            LectureFichierException {
        iLancementProgramme.getPrixMinPrixMaxVerifier();
    }

    public void obtenirDonneeQuantiteLots()
            throws IntervallesValideException,
            LotValideException, LectureFichierException,
            IOException {
        iLancementProgramme.getQuantiteLots();
    }

    public void obtenirDonneeDescription() throws IntervallesValideException,
            LotValideException, LectureFichierException, IOException {
        iLancementProgramme.getDescriptions();
    }

    public void obtenirDonneePassages() throws IntervallesValideException,
            LotValideException, LectureFichierException, IOException {
        iLancementProgramme.getPassages();
    }

    public void obtenirDonneeServices() throws IntervallesValideException,
            LotValideException, LectureFichierException, IOException {
        iLancementProgramme.getNombreService();
    }

    public void obtenirDonneeSuperficie()
            throws IntervallesValideException, LotValideException,
            LectureFichierException, IOException {
        iLancementProgramme.getSuperficies();
    }

    public void obtenirDonneeDates()
            throws IntervallesValideException, LotValideException,
            LectureFichierException, IOException {
        iLancementProgramme.getDates();
    }

    public void obtenirDonneeMontantLot()
            throws IntervallesValideException, LotValideException,
            LectureFichierException, IOException {
        iLancementProgramme.getMontantsLot();
    }

    public void obtenirDonneeMontantPassage()
            throws IntervallesValideException, LotValideException,
            LectureFichierException, IOException {
        iLancementProgramme.getMontantsPassage();
    }

    public void obtenirDonneeMontantService()
            throws IntervallesValideException, LotValideException,
            LectureFichierException, IOException {
        iLancementProgramme.getMontantsService();
    }

    public void obtenirDonneeMontantParLot()
            throws IntervallesValideException,
            LotValideException, LectureFichierException, IOException {
        iLancementProgramme.getMontantsParLot();
    }

    public void obtenirDonneeMontantTerrain()
            throws IntervallesValideException,
            LotValideException, LectureFichierException, IOException {
        iLancementProgramme.getMontantTerrain();
    }

    public void obtenirDonneeMontantTaxeScolaire()
            throws LotValideException, LectureFichierException, IOException {
        iLancementProgramme.getMontantTaxeScolaire();
    }

    public void obtenirDonneeMontantTaxeMunicipale()
            throws LotValideException, LectureFichierException, IOException {
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
}