/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package inf2050.e22.equipe2;

import java.io.IOException;
import java.text.ParseException;
import net.sf.json.JSONException;


/**
 * Université du Québec à Montréal (UQAM)
 * Cours : INF2050 - 020 - Été 2022
 * Sprint 3
 *
 * La classe ProjetDeSessionSprint2 contient une methode main.
 * Elle permet de tester toutes les autres classes et les utilisent pour
 * calculer l'évaluation d'un terrain selon son type pouvant contenir
 * plusieurs lots. Ces lots sont caractérisés par leur superficie, le nombre de
 * droits de passages et le nombres de services.
 *
 * @author Elza Meguieng Tiemghen
 * @version juillet 2022
 */

public class ProjetDeSessionSprint3 {

    private static boolean verifierParametreProgramme(String [] parametres)
            throws IOException {
        boolean estEnEntree;
        if (parametres.length == 0) {
            throw new IOException(GestionnaireMessage.
                    ERREUR_FICHER_ENTREE);

        } else {
            estEnEntree = true;
        }
        return estEnEntree;
    }

    private static String gererDocumentJson(String entree) {
        String donneFichier = null;

        try {
            String fichier = VerificationDonnee.chargerDonneeDeFichier(entree,
                    LancementProgramme.ENCODAGE_DE_FICHIER);
            String donnee = VerificationDonnee.
                    verifierPresenceDonnees(fichier);
            donneFichier = VerificationDonnee.
                    verifierContenuFichierTerrain(donnee);
        } catch (IOException
                 | NumberFormatException
                 | NullPointerException e) {
                Utilitaire.afficherMessage(e.getMessage());
        }
        return donneFichier;
    }

    private static void lancerLeProgramme(String [] parametres,
                                          String entree, String sortie) {
        try {
            if (verifierParametreProgramme(parametres)) {
                String donneeEntree = gererDocumentJson(entree);
                LancementProgramme lancementProgramme =
                        new LancementProgramme(donneeEntree);
                lancementProgramme.enregisterRapportDansFichier(sortie);
            }

        } catch (IOException
                 | NullPointerException
                 | NumberFormatException
                 | LotValideException
                 | JSONException
                 | PrixValideException
                 | IntervallesValideException
                 | LectureFichierException
                 | ParseException e) {
            Utilitaire.afficherMessage(e.getMessage());
            try {
                VerificationDonnee.enregistrerDonneeDansFichier(sortie,
                        e.getMessage(), LancementProgramme.
                                ENCODAGE_DE_FICHIER);
            } catch (NumberFormatException
                     | LectureFichierException
                     | IOException ex) {
                Utilitaire.afficherMessage(ex.getMessage());
            }
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String entree = args[0];
        String sortie = args[1];

        lancerLeProgramme(args, entree, sortie);
    }

}