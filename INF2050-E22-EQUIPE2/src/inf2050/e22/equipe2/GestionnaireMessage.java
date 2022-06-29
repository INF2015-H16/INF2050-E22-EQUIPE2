/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inf2050.e22.equipe2;

/**
 *
 * @author akaff
 */
public class GestionnaireMessage {
    
    public static final String PAS_DE_FICHIER_D_ENTREE
            = "Le fichier d'entrée n'a pas été trouvé" ;
    public static final String PAS_DE_FICHIER_DE_SORTIE 
            = "Le fichier de sortie n'a pas été généré";
    public static final String DROIT_PASSAGE_ABSENT
            = "Le nombre de droit de passage a été omis";
    public static final String DROIT_DE_PASSAGE_MIN
            = "Le nombre de droit de passage est inférerieur à 0."
            + "\n Il doit etre compris entre 0 et 10 inclusivement.";
    public static final String DROIT_DE_PASSAGE_MAX
            = "Le nombre de droit de passage est supérieur à 10."
            +"\n Il doit etre compris entre 0 et 10 inclusivement.";
    public static final String SERVICE_ABSENT 
             = "Le nombre de service a été omis.";
    public static final String SERVICE_MIN
             = "Le nombre de service est inférieur à 0."
             + "\n Il doit etre compris entre 0 et 5 inclusivement.";
    public static final String SERVICE_MAX
             = "Le nombre de service est supérieur à 5."
             + "\n Il doit etre compris entre 0 et 5 inclusivement.";
    public static final String TYPE_TERRAIN_ABSENT
            = "Le type de terrain a été omis.";
    public static final String TYPE_TERRAIN_INCORRECT
            = "Le type de terrain ne peut prendre que les valeurs 0,1 ou 2";
    public static final String LOT_MIN
            = "Le terrain doit avoir au moins un lot";
    public static final String LOT_MAX
            = "Le nombre de lots est supérieur à 10."
            + "\nIl doit etre d'au plus 10";
    public static final String PRIX_MIN_ABSENT
            =  "Le prix minimal a été omis.";
    public static final String ERREUR_PRIX_MIX
            = "Le prix minimum est négatif.\nVeuillez le corriger.";
    public static final String PRIX_MAX_ABSENT
            =  "Le prix maximal a été omis.";
    public static final String ERREUR_PRIX_MAX
            = "Le prix maximum est négatif.\nVeuillez le corriger.";
    public static final String CONFLIT_PRIX 
            = "Le prix maximum est inférieur au prix minimum."
            + "\nVeuillez le corriger.";
    public static final String SUPERFICIE_ABSENTE
            = "La superficie est absente";
    public static final String SUPERFICIE_MIN
            = "La superficie est inférieure à 0.\nVeuillez la corriger";
    public static final String SUPERFICIE_MAX
            = "La superficie est supérieure à 50000m2."
            + "\nElle doit etre d'au plus 50000m2";
    public static final String DATE_ABSENTE
            = "La date est absente";
    public static final String DATE_INCORRECTE
            = "La date doit etre sous le format YYYY-MM-DD.";
    public static final String CONFLIT_LOTS
            = "Attention doublons! Deux lots ont la meme description.";
        
       
}
