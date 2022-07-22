/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inf2050.e22.equipe2;

import java.io.IOException;

/**
 * @author Elza Meguieng Tiemghen
 * @version juillet 2022
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