/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package inf2050.e22.equipe2;

import java.io.IOException;
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
 * @version Juin 2022
 *
 */
public class VerificationDonnee {

    private final static int BORNE_INF_TERRAIN = 0;
    private final static int BORNE_SUP_TERRAIN = 2;

    private final static int BORNE_INF_DROIT_DE_PASSAGE = 0;

    private final static int BORNE_SUP_DROIT_DE_PASSAGE = 10;
    private static final int BORNE_INF_NOMBRE_DE_SERVICES = 0;
    private static final int BORNE_SUP_NOMBRE_DE_SERVICES = 5;

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
     * Ceci est notre meilleure tentative d'obtention
     * d'une condition qui vérifie une date au format "YYYY-MM-DD".
     */
    private static boolean validerDate(String date) {
        boolean valideDate;

        if (date.length() != 10) {
            valideDate = false;

        } else {
            valideDate = verifierExistTiret(date);

        }

        return valideDate;
    }

    private static boolean verifierExistTiret(String date) {
        boolean valideDate;
        String temp;

        if (date.charAt(4) == '-' && date.charAt(7) == '-') {
            temp = date.replaceAll("[-]", "");
            valideDate = validerDateAvecRegex(temp);

        } else {
            valideDate = false;

        }

        return valideDate;
    }

    private static boolean validerDateAvecRegex(String temp) {
        boolean valideDate;
        String regex = "((?:19|20)[0-9][0-9])(0?[1-9]|1[012])"
                + "(0?[1-9]|[12][0-9]|3[01])";

        if (temp.length() != 8) {
            valideDate = false;

        } else {
            valideDate = temp.matches(regex);

        }
        return valideDate;
    }

    public static String validerPrix(String prix)
        throws PrixValideException {
        String validePrix;
        String temp;
        String regex = "\\d*[.,]?\\d+\\$$";
        
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

        String valideLot;
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

    public static boolean verifierDroitDePassage(EvaluationLot lot) throws IOException {

        boolean droitDePassageValide = true;

        for (int i = 0; i < lot.obtenirNombreDroitPassage().length ; i++){
            if (lot.obtenirNombreDroitPassage()[i] < BORNE_INF_DROIT_DE_PASSAGE &&
                    lot.obtenirNombreDroitPassage()[i] > BORNE_SUP_DROIT_DE_PASSAGE){
                droitDePassageValide = false;
            }
        }

        return droitDePassageValide;
    }

    public static boolean verifierNombreDeServices(EvaluationLot lot) throws IOException{

        boolean nombreDeServicesValide = true;

        for (int i = 0; i < lot.obtenirNombreService().length ; i++){
            if (lot.obtenirNombreService()[i] < BORNE_INF_NOMBRE_DE_SERVICES &&
                    lot.obtenirNombreService()[i] > BORNE_SUP_NOMBRE_DE_SERVICES){
                nombreDeServicesValide = false;
            }
        }

        return nombreDeServicesValide;
    }
}