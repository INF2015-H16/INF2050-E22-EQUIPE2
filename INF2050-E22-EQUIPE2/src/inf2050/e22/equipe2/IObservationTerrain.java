/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inf2050.e22.equipe2;

import java.io.IOException;

/**
 * Université du Québec à Montréal (UQAM)
 * Cours : INF2050 - 020 - Été 2022
 * Sprint 3
 *
 * IObservationTerrain : Cette classe contient les données
 *                         sur la gestion des observations des terrains.
 *
 *
 * @author Elza Meguieng Tiemghen
 * @version juillet 2022
 *
 */
public interface IObservationTerrain {

    void getTaxeMunicipaleDouble() throws IOException,
            IntervallesValideException, LotValideException,
            LectureFichierException;
    void getTaxeScolaireDouble() throws IOException,
            IntervallesValideException, LotValideException,
            LectureFichierException;
    void getTaxePrixMinMaxDouble() throws IOException,
            IntervallesValideException, LotValideException,
            LectureFichierException;

}