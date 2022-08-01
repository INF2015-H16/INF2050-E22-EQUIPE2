/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inf2050.e22.equipe2;

import java.math.*;
import static java.math.RoundingMode.*;

/**
 * Université du Québec à Montréal (UQAM)
 * Cours : INF2050 - 020 - Été 2022
 * Sprint 3
 *
 * La classe utilitaire contient des méthodes utiles
 *
 * @author Elza Meguieng Tiemghen
 * @version juillet 2022
 */
public class Utilitaire {

    public static final String VALEUR_POUR_PRINTF = "%-65s | %d";
    public static void afficherMessage(String message) {
        System.out.print(message);
    }

    /**
     * Arrondir au 5 sous supérieur ou inférieur et formater selon "XX.XX $"
     */
    public static String convertirMontant(double montant) {
        BigDecimal montantAConvertir = new BigDecimal(montant);
        BigDecimal increment = new BigDecimal("0.05");

        if (determinerTypeArrondi(montant)){
            return String.format(
                    "%.2f $", round(montantAConvertir, increment,HALF_UP));
        } else {
            return String.format(
                    "%.2f $", round(montantAConvertir, increment,HALF_DOWN));
        }
    }

    /**
     * Détermine s'il faut arrondir au 5c supérieur ou bien inférieur
     */
    private static boolean determinerTypeArrondi(double montant){
        String montantAValider = String.format("%.2f", montant);
        return (montantAValider.charAt(montantAValider.length() - 1) >= '5');
    }

    private static BigDecimal round(BigDecimal value, BigDecimal increment,
                                   RoundingMode roundingMode) {
        if (increment.signum() == 0) {
            return value;
        } else {
            BigDecimal divided = value.divide(increment, 0, roundingMode);
            return divided.multiply(increment);
        }
    }

    public static String afficherFormatRapport(String libelle, int valeur) {
        return String.format(VALEUR_POUR_PRINTF, libelle, valeur) ;
    }

}