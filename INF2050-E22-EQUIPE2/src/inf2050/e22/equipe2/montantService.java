/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inf2050.e22.equipe2;

/**
 * Université du Québec à Montréal (UQAM)
 * Cours : INF2050 - 020 - Été 2022
 * Sprint 1
 *
 * montantService Cette classe permet de calculer le montant des services pour
 * chaque terrain.
 *
 * @author Elza Meguieng Tiemghen
 * @version 24-05-2022
 */
public class montantService {
    
    public static final double PRIX_SER_RESIDENTIEL_MOYEN = 500.00;
    public static final double PRIX_SER_RESIDENTIEL_GRAND = 1000.00;
    public static final double PRIX_SER_COMMERCIAL_PETIT = 500.00;
    public static final double PRIX_SER_COMMERCIAL_MOYEN = 1500.00;
    public static final double PRIX_SER_MAX = 5000.00;

    public static double montantService = 0.00;

    /**
     * infOuEgal500 verifie si la superficie du terrain est superieure ou egal a
     * 500
     *
     * @param superficie est la superficie du terrain
     * @return true si la superficie est comprise entre 0 et 500 inclus et false
     * sinon
     */
    
    public static boolean infOuEgal500(int superficie) {
        boolean estValide = false;

        if (superficie >= 0 && superficie <= 500) {
            estValide = true;
        }
        return estValide;
    }

    /**
     * entre500Et10000 verifie si la superficie du terrain est comprise entre
     * 500 exclus et 10000 inclus
     *
     * @param superficie est la superficie du terrain
     * @return true si la superficie est comprise entre 500 et 10000 inclus et
     * false sinon
     */
    
    public static boolean entre500Et10000(int superficie) {
        boolean estValide = false;

        if (superficie > 500 && superficie <= 10000) {
            estValide = true;
        }
        return estValide;
    }

    /**
     * supA10000 verifie si la superficie du terrain est superieure à 10000
     * exclus
     *
     * @param superficie est la superficie du terrain
     * @return true si la superficie est superieure a 10000 exclus et false
     * sinon
     */
    
    public static boolean supA10000(int superficie) {
        boolean estValide = false;

        if (superficie > 10000) {
            estValide = true;
        }
        return estValide;
    }

    /**
     *
     * @param typeTerrain precise s'il s'agit d'un terrain agricole, residentiel
     * ou commercial
     * @param superficie donne la superficie du terrain
     * @param nombreService donne le nombre de services que l'on souhaite avoir
     * @return le montant associé aux services pour le terrain. retourne 5000.00
     * si le montant des services est superieur à 5000.00 pour un terrain 
     * commercial
     */
    
    public static double montantService(String typeTerrain,
            int superficie, int nombreService) {

        double montant = 0.00;
        String typeTerrain1 = "agricole";
        String typeTerrain2 = "residentiel";
        String typeTerrain3 = "commercial";

        if (typeTerrain.equalsIgnoreCase(typeTerrain2)) {

            if (entre500Et10000(superficie)) {
                montant = (2 + nombreService) * PRIX_SER_RESIDENTIEL_MOYEN;
            } else if (supA10000(superficie)) {
                montant = (2 + nombreService) * PRIX_SER_RESIDENTIEL_GRAND;
            }
        }

        if (typeTerrain.equalsIgnoreCase(typeTerrain3)) {

            if (infOuEgal500(superficie)) {
                montant = (2 + nombreService) * PRIX_SER_COMMERCIAL_PETIT;
            } else if (entre500Et10000(superficie) || supA10000(superficie)) {
                montant = (2 + nombreService) * PRIX_SER_COMMERCIAL_MOYEN;
            }

            if (montant > PRIX_SER_MAX) {
                montant = PRIX_SER_MAX;
            }
        }

        return montant;

    }
}
    

