/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inf2050.e22.equipe2;

import java.text.ParseException;

/**
 * @author Elza Meguieng Tiemghen
 * @version juillet 2022
 */

public interface IObservationLot {

    void observerLotDispendieux(double montantsParLot, int i);
    void obtenirDifferenceDate(String [] dateLot)
            throws IntervallesValideException, ParseException;
    void observerSuperficeParLot(int superficies, int i);
    void observerValeurFonciere(double fonciere);
}