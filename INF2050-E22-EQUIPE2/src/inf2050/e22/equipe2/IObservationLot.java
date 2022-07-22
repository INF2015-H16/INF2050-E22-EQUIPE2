/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inf2050.e22.equipe2;

import java.io.IOException;
import java.text.ParseException;

/**
 * Université du Québec à Montréal (UQAM)
 * Cours : INF2050 - 020 - Été 2022
 * Sprint 3
 *
 * IObservationLot : Cette classe contient les données
 *                         sur la gestion des observations des lots.
 *
 *
 * @author Elza Meguieng Tiemghen
 * @version juillet 2022
 *
 */
public interface IObservationLot {

    void getDescriptionLotDispendieux()
            throws IOException, IntervallesValideException,
            ParseException, LotValideException, LectureFichierException;
    void getEcartMaximal() throws ParseException, IntervallesValideException,
            IOException, LotValideException, LectureFichierException;
    void getValeurFonciere() throws IntervallesValideException, IOException,
            LotValideException, LectureFichierException;
    void getSuperficeParLot() throws IntervallesValideException, IOException,
            LotValideException, LectureFichierException;
}