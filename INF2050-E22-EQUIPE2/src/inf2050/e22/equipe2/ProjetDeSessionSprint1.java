/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package inf2050.e22.equipe2;

import java.io.IOException;
import net.sf.json.JSONException;


/**
 * Université du Québec à Montréal (UQAM)
 * Cours : INF2050 - 020 - Été 2022
 * Sprint 1
 *
 * La classe ProjetDeSessionSprint1 contient une methode main.
 * Elle permet de tester toutes les autres classes et les utilisent pour
 * calculer l'evaluation d'un terrain selon son type pouvant contenir
 * plusieurs lots. Ces lots sont caratérisés par leur superficie, le nombre de
 * droits de passages et le nombres de services.
 *
 * @author Elza Meguieng Tiemghen
 * @version Mai 2022
 */

public class ProjetDeSessionSprint1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Déclaration des variables
        String entree;
        String sortie;
        EvaluationTerrain evaluation;

        if (args.length == 0) {
            Utilitaire.afficherMessage(
                    "\nAucune entrée et/ou sortie trouvée.\n");
        } else {
            entree = args[0];
            sortie = args[1];

            try {
                // Lire les informations sur le terrain(type de terrain,
                //les prix max et min, les details du lotissement[description,
                //les droits de passage, les services, les superficies
                //et la date de mesure des differents lot])
                EvaluationTerrain.lireFichierEntree(entree);

                evaluation = new EvaluationTerrain();

                evaluation.obtenirTypeTerrain();
                evaluation.obtenirPrixMinimum();
                evaluation.obtenirPrixMax();

                evaluation.obtenirDescription();
                evaluation.obtenirNombreDroitPassage();
                evaluation.obtenirNombreService();
                evaluation.obtenirSuperficie();
                evaluation.obtenirDateMesure();

                //Calculer les différents montants de lots
                //de droit de passage et montant de service
                evaluation.calculerMontantLot();
                evaluation.calculerDroitPassage();
                evaluation.calculerMontantService();

                //Calculer les différents montants par lots
                evaluation.calculerValeurParLot();

                //Calculer la valeur fonciere et la taxe scolaire
                //et la taxe municiple qui vont avec
                evaluation.calculerValeurFonciere();
                evaluation.calculerTaxeScolaire();
                evaluation.calculerTaxeMunicipale();

                //Afficher le rapport de l'évaluation
                evaluation.genererRapportEvaluation(sortie);

            } catch (IOException | NullPointerException e) {
                Utilitaire.afficherMessage(
                        "\nAucune entrée et/ou sortie trouvée.\n");
            } catch (NumberFormatException
                    | IntervallesValideException
                    | PrixValideException
                    | LotValideException
                    | JSONException e) {
                Utilitaire.afficherMessage(
                        "\nVérifier les données entrées !\n");
            }
            
        }
    }

}