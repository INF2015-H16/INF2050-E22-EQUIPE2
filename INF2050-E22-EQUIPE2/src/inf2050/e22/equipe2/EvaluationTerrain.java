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
 * EvaluationTerrain : Cette classe contient les données sur la description,
 *                le nombre de droits de passage, le nombre de service,
 *                la superficie, la date de mesure des lots,
 *                ainsi que, le type de terrain, les prix min et max.
 *                Elle permet de calculer la valeur foncière du
 *                terrain ainsi que les taxes scolaire et municipale.
 *
 *
 * @author Achou Henri Joël / Akaffou
 * @version 19 mai 2022
 *
 */
public class EvaluationTerrain {

    //Déclaration des contstantes
    public final static String FICHIER_ENTREE = "entree.json";
    public final static String FICHIER_SORTIE = "sortie.json";
    public final static String FILE_ENCODING = "UTF-8";
    
    public final static double VALEUR_DE_BASE = 733.77;
    public final static double TAXE_SCOLAIRE = 0.012;
    public final static double TAXE_MUNICIPALE = 0.025;

    public final static String LOT = "lot ";
    public final static String DESCRIPTION = "description";
    public final static String NBRE_DROIT_PASSAGE = "nombre_droits_passage";
    public final static String NBRE_SERVICES = "nombre_services";
    public final static String SUPERFICIE = "superficie";
    public final static String DATE_MESURE = "date_mesure";

    public final static String TYPE_TERRAIN = "type_terrain";
    public final static String PRIX_M2_MIN = "prix_m2_min";
    public final static String PRIX_M2_MAX = "prix_m2_max";
    public final static String LOTISSEMENTS = "lotissements";

    public final static String RAP_VALEUR_FONCIERE_TOTALE = "valeur_fonciere_totale";
    public final static String RAP_TAXE_SCOLAIRE = "taxe_scolaire";
    public final static String RAP_TAXE_MUNICIPALE = "taxe_municipale";
    public final static String RAP_VALEUR_PAR_LOT = "valeur_par_lot";
    
}
