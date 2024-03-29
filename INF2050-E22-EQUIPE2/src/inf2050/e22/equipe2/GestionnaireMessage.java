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
 * EvaluationTerrain : Cette classe contient les données sur
 *                     les différents type de message d'erreur
 *                     à afficher.
 *
 *
 * @author Achou Henri Joël / Akaffou
 * @version juillet 2022
 *
 */
public class GestionnaireMessage {

    public static final String ERREUR_DONNEE_PAS_NOMBRE
            = "Il existe une valeur qui n'est pas un entier dans le fichier." +
            " Corriger le SVP !";
    public static final String ERREUR_TYPE_TERRAIN_INFERIEURE
            = "Le type du terrain est inférerieur à 0" +
            "\nLe type de terrain ne peut prendre que les valeurs 0,1 ou 2";
    public static final String ERREUR_TYPE_TERRAIN_SUPERIEURE
            = "Le type du terrain est supérieure à 2." +
            "\nLe type de terrain ne peut prendre que les valeurs 0,1 ou 2";
    public static final String ERREUR_DROIT_PASSAGE_INFERIEURE
            = "Le nombre de droit de passage est inférerieur à 0."
            + "\n Il doit etre compris entre 0 et 10 inclusivement.";
    public static final String ERREUR_DROIT_PASSAGE_SUPERIEURE
            = "Le nombre de droit de passage est supérieur à 10."
            +"\n Il doit etre compris entre 0 et 10 inclusivement.";
    public static final String ERREUR_SERVICES_INFERIEURE
            = "Le nombre de service est inférieur à 0."
            + "\n Il doit etre compris entre 0 et 5 inclusivement.";
    public static final String ERREUR_SERVICES_SUPERIEURE
            = "Le nombre de service est supérieur à 5."
            + "\n Il doit etre compris entre 0 et 5 inclusivement.";
    public static final String ERREUR_NOMBRE_LOTS_INFERIEURE
            = "Le terrain doit avoir au moins un lot";
    public static final String ERREUR_NOMBRE_LOTS_SUPERIEURE
            = "Le nombre de lots est supérieur à 10."
            + "\nIl doit etre d'au plus 10";
    public static final String ERREUR_MONTANT_ARGENT_NEGATIF
            = "Le montant d'argent est négatif." +
            " Corriger le SVP !";
    public static final String ERREUR_FORMAT_MONTANT_ARGENT
            = "Le montant d'argent n'est pas au format NN.NN $." +
            " Corriger le SVP !";
    public static final String ERREUR_CONFLIT_PRIX
            = "Le prix maximum est inférieur au prix minimum."
            + "\nVeuillez le corriger.";
    public static final String ERREUR_SUPERFICIE_INFERIEURE
            = "La superficie est inférieure à 0.\nVeuillez la corriger";
    public static final String ERREUR_SUPERFICIE_SUPERIEURE
            = "La superficie est supérieure à 50000m2."
            + "\nElle doit être d'au plus 50000m2";
    public static final String ERREUR_FORMAT_DATE
            = "La date doit etre sous le format YYYY-MM-DD.";
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
    public static final String ERREUR_CONFLIT_LOTS
            = "Attention doublons! Plusieurs lots ont la même description.";
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