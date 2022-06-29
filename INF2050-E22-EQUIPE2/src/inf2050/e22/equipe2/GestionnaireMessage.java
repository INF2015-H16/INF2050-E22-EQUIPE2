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
  
    public static final String ERREUR_DONNEE_PAS_NOMBRE
            = "Il existe une valeur qui n'est pas un entier dans le fichier." +
            " Corriger le SVP !";
    public static final String ERREUR_TYPE_TERRAIN_INFERIEURE
            = "Le type du terrain est négatif." +
            " Corriger le SVP !";
    public static final String ERREUR_TYPE_TERRAIN_SUPERIEURE
            = "Le type du terrain est supérieure à 2." +
            " Corriger le SVP !";
    public static final String ERREUR_DROIT_PASSAGE_INFERIEURE
            = "Le nombre de droit de passage est négatif." +
            " Corriger le SVP !";
    public static final String ERREUR_DROIT_PASSAGE_SUPERIEURE
            = "Le nombre de droit de passage est supérieure à 10." +
            " Corriger le SVP !";
    public static final String ERREUR_SERVICES_INFERIEURE
            = "Le nombre de services est négatif." +
            " Corriger le SVP !";
    public static final String ERREUR_SERVICES_SUPERIEURE
            = "Le nombre de services est supérieure à 5." +
            " Corriger le SVP !";
    public static final String ERREUR_NOMBRE_LOTS_INFERIEURE
            = "Le nombre de lots est inférieur à 1." +
            " Corriger le SVP !";
    public static final String ERREUR_NOMBRE_LOTS_SUPERIEURE
            = "Le nombre de lots est supérieure à 10." +
            " Corriger le SVP !";
    public static final String ERREUR_MONTANT_ARGENT_NEGATIF
            = "Le montant d'argent est négatif." +
            " Corriger le SVP !";
    public static final String ERREUR_FORMAT_MONTANT_ARGENT
            = "Le montant d'argent n'est pas au format NN.NN $." +
            " Corriger le SVP !";
    public static final String ERREUR_SUPERFICIE_INFERIEURE
            = "La superficie est négative. Corriger le SVP !";
    public static final String ERREUR_SUPERFICIE_SUPERIEURE
            = "La superficie est supérieure à 50000." +
            " Corriger le SVP !";
    public static final String ERREUR_FORMAT_DATE
            = "Le format de date n'est pas YYYY-MM-DD." +
            " Corriger le SVP !";
    public static final String ERREUR_FICHER_ENTREE
            = "Aucun fichier 'entree.json' trouvé." +
            " Vérifier le SVP !";
    public static final String ERREUR_FICHIER_SORTIE
            = "Le fichier de sortie ne peut être créer." +
            " Corriger le SVP !";
    public static final String ERREUR_DOCUMENT_JSON
            = "Votre document JSON contient un libelle incorrect." +
            " Corriger le SVP !";
    public static final String ERREUR_DOCUMENT_JSON_VIDE
            = "Votre document JSON vide. Ajouter des données SVP !";
    public static final String ERREUR_DOCUMENT_JSON_DECHET
            = "Votre document JSON contient des déchets." +
            " Nettoyer le SVP !";
    public static final String ERREUR_LOT_MULTIPLE
            = "Il y a plusieurs descriptons de lot qui sont identiques." +
            " Corriger le SVP !";
    public static final String ERREUR_DESCRIPTION_LOT
            = "La description n'est pas au format 'lot X' ou est vide." +
            " Corriger le SVP !";

    public static String choisirMessageTypeTerrain(int laDonnee,
                                                   int borneInf,
                                                   int borneSup) {
        return choisirMessage(laDonnee, borneInf, borneSup,
                ERREUR_TYPE_TERRAIN_INFERIEURE,
                ERREUR_TYPE_TERRAIN_SUPERIEURE);
    }

    public static String choisirMessageDroitPassage(int laDonnee,
                                                   int borneInf,
                                                   int borneSup) {
        return choisirMessage(laDonnee, borneInf, borneSup,
                ERREUR_DROIT_PASSAGE_INFERIEURE,
                ERREUR_DROIT_PASSAGE_SUPERIEURE);
    }

    public static String choisirMessageServies(int laDonnee,
                                                    int borneInf,
                                                    int borneSup) {
        return choisirMessage(laDonnee, borneInf, borneSup,
                ERREUR_SERVICES_INFERIEURE,
                ERREUR_SERVICES_SUPERIEURE);
    }

    public static String choisirMessageNombreLots(int laDonnee,
                                                    int borneInf,
                                                    int borneSup) {
        return choisirMessage(laDonnee, borneInf, borneSup,
                ERREUR_NOMBRE_LOTS_INFERIEURE,
                ERREUR_NOMBRE_LOTS_SUPERIEURE);
    }

    public static String choisirMessageSuperficie(int laDonnee,
                                                    int borneInf,
                                                    int borneSup) {
        return choisirMessage(laDonnee, borneInf, borneSup,
                ERREUR_SUPERFICIE_INFERIEURE,
                ERREUR_SUPERFICIE_SUPERIEURE);
    }

    private static String choisirMessage(int laDonnee, int borneInf,
                                        int borneSup, String messagePourInf,
                                        String messagePourSup) {
        String message = null;

        if (laDonnee < borneInf) {
            message = messagePourInf;
        } else if (laDonnee > borneSup) {
            message = messagePourSup;
        }

        return message;
    }
}