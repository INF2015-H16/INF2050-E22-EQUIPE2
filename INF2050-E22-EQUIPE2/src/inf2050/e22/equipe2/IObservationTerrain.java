/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inf2050.e22.equipe2;

/**
 * @author Elza Meguieng Tiemghen
 * @version juillet 2022
 */

public interface IObservationTerrain {

    void observerDoubleVersementTaxeMunicipale(double taxe);
    void observerDoubleVersementTaxeScolaire(double taxe);
    void observerPrixMaxVsMin();
}