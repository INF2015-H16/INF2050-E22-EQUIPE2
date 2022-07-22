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
 * LotValideException : Exception générée lorsque le lot n'est
 * pas au format "lot N ou s'il y a des doublons".
 *
 * @author Achou Henri Joël / Akaffou
 * @version juillet 2022
 *
 */
public class LotValideException extends Exception {

    public LotValideException() {
    }

    public LotValideException(String message) {
        super(message);
    }
    
}