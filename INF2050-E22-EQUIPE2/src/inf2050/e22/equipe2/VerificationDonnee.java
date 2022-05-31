/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package inf2050.e22.equipe2;

import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Université du Québec à Montréal (UQAM)
 * Cours : INF2050 - 020 - Été 2022
 * Sprint 1
 *
 * La classe VerificationDonnee permet de faire la validation de toutes les données du programme.
 * Elle offre des méthodes pour faire la validation
 *
 * @author Aurélien Tcheuffa Kemayou / Sidopz
 * @author Achou Henri Joël / Akaffou
 * @version Mai 2022
 *
 */


public class VerificationDonnee {

    public static boolean validerTerrain(int type) {

        return type >= 0 && type <= 2; //valide si la valeur est entre 0 et 2 inclusivement

        /** //manière plus explicite de faire la vérification
        if (type >= 0 && type <= 2){
            return true;
        }else {
            return false;
        }**/

    }


    public static boolean validerLot(String type) {

        //TODO
        return true;

    }


    public static int validerInt(Object valeur) {

        if (valeur instanceof Integer){
            return (Integer) valeur;
        } else {
            return Integer.parseInt(null);
        }

        //return (valeur instanceof Integer); // si on fait que la méthode retourne un boolean
    }

    public static double validerDouble(Object valeur) {
        if (valeur instanceof Double){
            return (Double) valeur;
        } else {
            return Double.parseDouble(null);
        }

        //return (valeur instanceof Double); // si on choisit que la méthode retourne un boolean
    }

    public static String validerDateMesure(String date) {

        try {
            Instant.from(DateTimeFormatter.ISO_INSTANT.parse(date));
            return date;
        } catch (DateTimeParseException e) {
            Utilitaire.afficherMsg("La date ne respecte pas le format ISO 8601");
        }
        return null;

        /** // Si cette méthode retourne un boolean:
        try {
            Instant.from(DateTimeFormatter.ISO_INSTANT.parse(date));
            return true;
        } catch (DateTimeParseException e) {
            Utilitaire.afficherMsg("La date ne respecte pas le format ISO 8601");
        }
        return false;
         **/

    }



}
