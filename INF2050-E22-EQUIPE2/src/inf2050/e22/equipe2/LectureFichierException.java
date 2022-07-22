/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inf2050.e22.equipe2;

/**
 * Université du Québec à Montréal (UQAM)
 * Cours : INF2050 - 020 - Été 2022
 * Sprint 3
 *
 * LectureFichierException : Cette classe permet de gérer les erreurs
 *                      que fournissent la lecture des fichiers.
 *
 *
 * @author Achou Henri Joël / Akaffou
 * @version juillet 2022
 *
 */
public class LectureFichierException extends Exception {

    public LectureFichierException() {
    }

    public LectureFichierException(String message) {
        super(message);
    }

}