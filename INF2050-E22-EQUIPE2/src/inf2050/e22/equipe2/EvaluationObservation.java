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
 * EvaluationObservation : Cette classe contient les observations
 *                  qui s'affiche si le résultat des opérations révéle
 *                  une situation particulière.
 *
 *
 * @author Achou Henri Joël / Akaffou
 * @version juillet 2022
 *
 */
public class EvaluationObservation {

    public static final String VALEUR_PAR_LOT_DU_LOT = "La valeur par" +
            " lot du lot ";
    public static final String EST_TROP_DISPENDIEUSE = " est trop" +
            " dispendieuse.";
    public static final String TAXE_MUNICIPALE_EN_DEUX_VERSEMENTS = "La taxe" +
            " municipale payable par le propriétaire nécessite deux" +
            " versements.";
    public static final String ECART_DATE_MOINS_SIX_MOIS = "L’écart maximal" +
            " entre les dates de mesure des lots d’un même" +
            " terrain devrait être de moins de 6 mois.";
    public static final String TAXE_SCOLAIRE_EN_DEUX_VERSEMENTS = "La taxe" +
            " scolaire payable par le propriétaire nécessite deux versements.";
    public static final String VALEUR_FONCIERE_TOTALE_PAS_DEPASSER_300000
            = "La valeur foncière totale ne doit pas dépasser 300000 $";
    public static final String LA_SUPERFFICIE_DU_LOT = "La superficie du lot ";
    public static final String EST_TROP_GRANDE = " est trop grande.";
    public static final String PAS_DEUX_FOIS_PRIX_MINIMUM_M_2
            = "Le prix maximum du m2 ne peut pas dépasser deux fois" +
            " le prix minimum du m2.";
    public static final String DATE_PATTERN = "yyyy-MM-dd";

}