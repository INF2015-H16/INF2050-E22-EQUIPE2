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
 * La classe utilitaire contient des methodes utiles
 *
 * @author Elza Meguieng Tiemghen
 * @version Mai 2022
 * @modify at 2022-05-28 by Achou Henri Joël / Akaffou
 */
public class Utilitaire {
    
    /**
     * Méthode générique pour faire des affichages
     * 
     * @param message qui est le message
     */
    public static void afficherMsg(String message) {
        System.out.print(message); 
    }
    
    /**
     * Arrondir au 5 sous supérieur et formater selon "XX.XX $"
     * 
     * @param mont qui est la valeur à formater
     * @return 
     */
    public static String convertirMontant(double mont) {
        return String.format("%.2f $", Math.round(Math.ceil(mont *20))/ 20.0);
    }
    
}
