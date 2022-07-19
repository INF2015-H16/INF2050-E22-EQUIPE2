/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inf2050.e22.equipe2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author akaff
 */
public class EvaluationObservation {

    public static final String LA_VALEUR_PAR_LOT_DU_LOT = "La valeur par lot du lot ";
    public static final String EST_TROP_DISPENDIEUSE = " est trop dispendieuse.";
    public static final String MSG_DLE = "La taxe municipale payable par le propriétaire nécessite deux " +
            "versements.";
    public static final String MSG_DATE = "L’écart maximal entre les dates de mesure des lots d’un même " +
            "terrain devrait être de moins de 6 mois.";
    public static final String MSG = "La taxe scolaire payable par le propriétaire nécessite deux " +
            "versements.";
    public static final String VALEUR_FONCIÈRE_TOTALE_NE_DOIT_PAS_DÉPASSER_300000
            = "La valeur foncière totale ne doit pas dépasser 300000 $";
    public static final String LA_SUPERFFICIE_DU_LOT = "La superfficie du lot ";
    public static final String EST_TROP_GRANDE = " est trop grande.";
    public static final String PAS_DÉPASSER_DEUX_FOIS_LE_PRIX_MINIMUM_DU_M_2
            = "Le prix maximum du m2 ne peut pas dépasser deux fois le prix minimum du m2.";
    public static final String DATE_PATTERN = "yyyy-MM-dd";

    public static String [] obtenirDifferenceEntreDate(String [] dateLot,
                                                       ArrayList<Lotissement> lotissements)
            throws ParseException {
        String [] lesMsgs = new String[lotissements.size()];
        String[] lesMessages;
        SimpleDateFormat formatDate = new SimpleDateFormat(DATE_PATTERN);
        for (int i = 0; i < lotissements.size(); i++) {
            for (int j = i + 1; j < lotissements.size(); j++) {
                Date date = formatDate.parse(dateLot[i]);
                Date dateAutre = formatDate.parse(dateLot[j]);

                calculerDifference(lesMsgs, i, date, dateAutre);
            }
        }

        lesMessages = obtenirDifferenceNonNull(lesMsgs);

        return lesMessages;
    }

    private static String[] obtenirDifferenceNonNull(String[] lesMsgs) {
        String[] lesMessages;
        List<String> list = new ArrayList<>();
        for(String s : lesMsgs) {
            if(s != null && s.length() > 0) {
                list.add(s);
            }
        }

        lesMessages = list.toArray(new String[list.size()]);
        return lesMessages;
    }

    private static void calculerDifference(String[] lesMsgs, int index,
                                           Date date, Date dateAutre) {
        if (date != dateAutre) {
            long difference = dateAutre.getTime() - date.getTime();
            long diffDate = Math.abs((difference
                    / (1000 * 60 * 60 * 24)) % 365);

            if (diffDate > 180) {
                lesMsgs[index] = MSG_DATE;
            }
        }
    }

}