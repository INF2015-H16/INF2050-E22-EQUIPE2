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
 */
public class Utilitaire {
    
    public static void afficherMsg(String message) {
        System.out.print(message); 
    }
    
    public static String convertirMontant(double mont) {
        return String.format("%.2f $", Math.round(Math.ceil(mont *20))/ 20.0);
    }
    
}
