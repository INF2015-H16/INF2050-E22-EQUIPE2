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
public interface ILancementProgramme {

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
           LotValideException, LectureFichierException, IOException;

   void getMontantsPassage() throws IntervallesValideException,
           LotValideException, LectureFichierException, IOException;

   void getMontantsService() throws IntervallesValideException,
           LotValideException, LectureFichierException, IOException;

    void getMontantsParLot() throws IntervallesValideException,
            LotValideException, LectureFichierException, IOException;

    void getMontantTerrain()
            throws IntervallesValideException, LotValideException,
            LectureFichierException, IOException;
    void getMontantTaxeScolaire() throws LotValideException,
            LectureFichierException, IOException;
    void getMontantTaxeMunicipale() throws LotValideException,
            LectureFichierException, IOException;

    void rapporterSiBon() throws LotValideException,
            LectureFichierException, IOException;
    void afficherRapport() throws LectureFichierException,
            IOException, LotValideException;

}