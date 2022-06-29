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
public interface ILancementProgramme {

    void getLesLotissements(String json) throws LotValideException,
            IntervallesValideException, PrixValideException,
            LectureFichierException, IOException;

    void getTerrain(String json) throws IntervallesValideException,
            PrixValideException, LotValideException,
            LectureFichierException, IOException;
    void getIdTerrain() throws PrixValideException,
            IntervallesValideException, LotValideException,
            LectureFichierException, IOException;

    void getPrixMinimum() throws PrixValideException,
            IntervallesValideException, LotValideException,
            LectureFichierException, IOException;

    void getPrixMaximum() throws PrixValideException,
            IntervallesValideException, LotValideException,
            LectureFichierException, IOException;
    void getPrixMinPrixMaxVerifier() throws PrixValideException,
            LotValideException, IOException, IntervallesValideException,
            LectureFichierException;
    void getQuantiteLots() throws IntervallesValideException,
            LotValideException, LectureFichierException,
            IOException;
    void getDescriptions() throws IntervallesValideException,
            LotValideException, LectureFichierException, IOException;

    void getPassages() throws IntervallesValideException,
            LotValideException, LectureFichierException, IOException;

    void getNombreService() throws IntervallesValideException,
            LotValideException, LectureFichierException, IOException;

    void getSuperficies()
            throws IntervallesValideException, LotValideException,
            LectureFichierException, IOException;

    void getDates()
            throws IntervallesValideException, LotValideException,
            LectureFichierException, IOException;

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