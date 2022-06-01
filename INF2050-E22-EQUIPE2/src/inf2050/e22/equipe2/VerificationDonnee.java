/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package inf2050.e22.equipe2;

import java.util.HashSet;
import java.util.Set;

/**
 * Université du Québec à Montréal (UQAM)
 * Cours : INF2050 - 020 - Été 2022
 * Sprint 1
 *
 * La classe VerificationDonnee permet de faire
 * la validation de toutes les données en entrée du programme.
 *
 * @author Aurélien Tcheuffa Kemayou / Sidopz
 * @version Mai 2022
 *
 */


public class VerificationDonnee {

    private final static int BORNE_INF_TERRAIN = 0;
    private final static int BORNE_SUP_TERRAIN = 2;
    
     public static boolean validerTypeTerrain(int type)
            throws IntervallesValideException {

        boolean estValid = false;
        
        if (type < BORNE_INF_TERRAIN || type > BORNE_SUP_TERRAIN) {
            throw new IntervallesValideException();
        } else {
            estValid = true;
        }
        
        return estValid;
    }
     
    public static int valeurEstInt(Object valeur)
            throws NumberFormatException{
        int nombre;
        
        if (valeur instanceof Integer) {
            nombre = (Integer) valeur;
        } else {
            throw new NumberFormatException();
        }
        
        return nombre;
    }
    
    /**
     * This is our best attempt to get a race condition
     * that checks for a date in the format "YYYY-MM-DD".
     */
    private static boolean validerDate(String date) {
        boolean valideDate;
        int tailleDate;
        String temp;
        int tailleTemp;
        String regex = "((?:19|20)[0-9][0-9])(0?[1-9]|1[012])"
                + "(0?[1-9]|[12][0-9]|3[01])";

        tailleDate = date.length();
        
        if (tailleDate != 10) {
            valideDate = false;
        } else {
            if (date.charAt(4) == '-' && date.charAt(7) == '-') {
                temp = date.replaceAll("[-]", "");

                tailleTemp = temp.length();
                
                if (tailleTemp != 8) {
                    valideDate = false;
                } else {
                    valideDate = temp.matches(regex);
                }
            } else {
                valideDate = false;
            }
        }

        return valideDate;
    }
    
    public static String validerDateMesure(String date)
            throws NumberFormatException{
        String dateValide;
        
            if (!validerDate(date)) {
                throw new NumberFormatException();
            } else {
                dateValide = date;
            }
            
        return dateValide;
    }
    
    public static String validerPrix(String prix)
        throws PrixValideException {
        String validePrix = null;
        String temp;
        String regex = "\\d*[.]?\\d+\\$$";
        
        temp = prix.replaceAll(" ", "");
        
        if (!temp.matches(regex)) {
            throw new PrixValideException();
        } else {
            validePrix = prix;
        }
        
        return validePrix;
    }
    
    public static String validerDescriptionLot(String descriptionLot)
            throws LotValideException {

        String valideLot = null;
        String temp;
        String regex = "^(lot)\\d*";
        
        temp = descriptionLot.trim().replaceAll(" ", "");
        
        if (!temp.matches(regex)) {
            throw new LotValideException();
        } else {
            valideLot = descriptionLot;
        }
        
        return valideLot;
    }
    
    public static boolean verifierLotsDoublons(
            String[] lots)
            throws LotValideException {
        boolean estValide = false;
        final Set<String> listLots = new HashSet<>();
        
        for (String lot : lots) {
            if (!listLots.add(lot.trim())) {
                throw new LotValideException();
            } else {
                estValide = true;
            }
        }
        return estValide;
    }

}