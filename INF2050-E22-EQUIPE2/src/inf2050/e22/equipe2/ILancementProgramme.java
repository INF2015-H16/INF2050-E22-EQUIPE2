/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inf2050.e22.equipe2;

import java.io.IOException;
import java.text.ParseException;

/**
 *
 * @author akaff
 */
public interface ILancementProgramme extends IStatistique,
        IObservationLot, IObservationTerrain {

    void getLesLotissements(String json) throws LotValideException,
            IntervallesValideException, PrixValideException,
            LectureFichierException, IOException, ParseException;

    void getTerrain(String json) throws IntervallesValideException,
            PrixValideException, LotValideException,
            LectureFichierException, IOException, ParseException;
    void getIdTerrain() throws PrixValideException,
            IntervallesValideException, LotValideException,
            LectureFichierException, IOException, ParseException;

    void getPrixMinimum() throws PrixValideException,
            IntervallesValideException, LotValideException,
            LectureFichierException, IOException, ParseException;

    void getPrixMaximum() throws PrixValideException,
            IntervallesValideException, LotValideException,
            LectureFichierException, IOException, ParseException;
    void getPrixMinPrixMaxVerifier() throws PrixValideException,
            LotValideException, IOException, IntervallesValideException,
            LectureFichierException, ParseException;
    void getQuantiteLots() throws IntervallesValideException,
            LotValideException, LectureFichierException,
            IOException, ParseException;
    void getDescriptions() throws IntervallesValideException,
            LotValideException, LectureFichierException, IOException, ParseException;

    void getPassages() throws IntervallesValideException,
            LotValideException, LectureFichierException, IOException, ParseException;

    void getNombreService() throws IntervallesValideException,
            LotValideException, LectureFichierException, IOException, ParseException;

    void getSuperficies()
            throws IntervallesValideException, LotValideException,
            LectureFichierException, IOException, ParseException;

    void getDates()
            throws IntervallesValideException, LotValideException,
            LectureFichierException, IOException, ParseException;

   void getMontantsLot() throws IntervallesValideException,
           LotValideException, LectureFichierException, IOException, ParseException;

   void getMontantsPassage() throws IntervallesValideException,
           LotValideException, LectureFichierException, IOException, ParseException;

   void getMontantsService() throws IntervallesValideException,
           LotValideException, LectureFichierException, IOException, ParseException;

    void getMontantsParLot() throws IntervallesValideException,
            LotValideException, LectureFichierException, IOException, ParseException;

    void getMontantTerrain()
            throws IntervallesValideException, LotValideException,
            LectureFichierException, IOException, ParseException;
    void getMontantTaxeScolaire() throws LotValideException,
            LectureFichierException, IOException, ParseException, IntervallesValideException;
    void getMontantTaxeMunicipale() throws LotValideException,
            LectureFichierException, IOException, ParseException, IntervallesValideException;

    void getPrixReparti() throws IntervallesValideException, IOException;
    void rapporterSiBon() throws LotValideException,
            LectureFichierException, IOException;
    void afficherRapport() throws LectureFichierException,
            IOException, LotValideException;

}