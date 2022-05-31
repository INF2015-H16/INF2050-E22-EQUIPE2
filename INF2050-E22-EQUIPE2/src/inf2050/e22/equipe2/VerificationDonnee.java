/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package inf2050.e22.equipe2;

import java.util.regex.PatternSyntaxException;

/**
 * Université du Québec à Montréal (UQAM)
 * Cours : INF2050 - 020 - Été 2022
 * Sprint 1
 *
 * La classe VerificationDonnee permet de faire
 * la validation de toutes les données du programme.
 * Elle offre des méthodes pour faire la validation.
 *
 * @author Aurélien Tcheuffa Kemayou / Sidopz
 * @author Achou Henri Joël / Akaffou
 * @version Mai 2022
 *
 */


public class VerificationDonnee {

    private final static int BORNE_INF_TERRAIN = 0;
    private final static int BORNE_SUP_TERRAIN = 2;
    
    /**
     * Valider l'intervalle dans lequel
     * doit se situer le type de terrain
     * 
     * @param type qui est le type de terrain
     * @return estValid
     * @throws IntervallesValideException 
     */
     public static boolean validerTerrain(int type)
            throws IntervallesValideException {

        boolean estValid = false;
        
        if (type < BORNE_INF_TERRAIN || type > BORNE_SUP_TERRAIN) {
            throw new IntervallesValideException();
        } else {
            estValid = true;
        }
        
        return estValid;
    }
 
     /**
      * Verifier si la donnée est un int
      * @param valeur
      * @return nombre
      * @throws NumberFormatException 
      */
    public static int validerInt(Object valeur)
            throws NumberFormatException{
        int nombre;
        
        if (valeur instanceof Integer) {
            nombre = (Integer) valeur;
        } else {
            throw new NumberFormatException();
        }
        
        return nombre;
    }
    
    /**Verifier si la chaîne de caractères est
     * une date au format "YYYY-MM-DD"
     *
     * @param date est une chaîne de caractères
     * @return vrai si c'est une date
     */
    private static boolean validerDate(String date) {
        //Déclaration des variables
        boolean valideDate;
        int tailleDate;
        String temp;
        int tailleTemp;
        String regex = "((?:19|20)[0-9][0-9])(0?[1-9]|1[012])"
                + "(0?[1-9]|[12][0-9]|3[01])";

        tailleDate = date.length();

        //Vérifier si la chaîne de caractères contient 10 caractères
        if (tailleDate != 10) {
            valideDate = false;
        } else {
            //Vérifier si les 4ème et 7ème caractères sont des tirets '-'
            if (date.charAt(4) == '-' && date.charAt(7) == '-') {
                //Supprimer tous les '-' dans la chaîne de caractères
                temp = date.replaceAll("[-]", "");

                tailleTemp = temp.length();

                //Vérifier si la chaîne de caractères sans
                //tiret contient 8 caractères
                if (tailleTemp != 8) {
                    valideDate = false;
                } else {
                    //Vérifier si chaque caractère de la chaîne est un entier
                    // respectant l'expression reguliere

                    valideDate = temp.matches(regex);
                }
            } else {
                valideDate = false;
            }
        }

        return valideDate;
    }

    /**
     * Valider la date au format 'YYYY-MM-DD'
     * 
     * @param date
     * @return
     * @throws NumberFormatException 
     */
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


    /**
     * Valider que le prix est au format 'X.XX $'
     *
     * @param prix
     * @return
     * @throws NumberFormatException
     * @throws PatternSyntaxException
     */
    public static boolean verifierFormatPrix(String prix)
            throws PatternSyntaxException {

        //Déclaration des variables
        //boolean prixValide;
        //int taillePrix;
        //String temp;
        //int tailleTemp;
        String regex = "[0-9]\\.[0-9][0-9] \\$";


        return (prix.matches(regex));

    }


        /*
        taillePrix = prix.length();

        //Vérifier si la chaîne de caractères contient 10 caractères
        if (taillePrix != 6) {
            prixValide = false;
        } else {
            //Vérifier si le 2e caractère est un point, que le 5ème est un espace et que le 6e est un signe de dollar
            if (prix.charAt(1) == '.' && prix.charAt(4) == ' ' && prix.charAt(5) == '$') {
                //Supprimer tous les caractères non numérques dans la chaîne de caractères

                temp = prix.replace(".","");
                temp = prix.replace(" ", "");
                temp = prix.replace("$", "");

                tailleTemp = temp.length();

                //Vérifier si la chaîne de caractères sans
                //tiret contient 3 caractères
                if (tailleTemp != 3) {
                    prixValide = false;
                } else {
                    //Vérifier si chaque caractère de la chaîne est un entier
                    // respectant l'expression réguliere

                    prixValide = temp.matches(regex);
                }
            } else {
                prixValide = false;
            }
        }

        return prixValide;
    }


    }*/

}
