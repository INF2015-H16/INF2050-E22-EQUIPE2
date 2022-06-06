/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package inf2050.e22.equipe2;

import java.io.IOException;
import java.util.ArrayList;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;


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
    
    public final static String FILE_ENCODING = "UTF-8";
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Déclaration des variables
        String entree;
        String sortie;
        
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
                String json = FileReaderException.loadFileIntoString(entree,
                FILE_ENCODING);
                
                EvaluationTerrain evaluation = new EvaluationTerrain();
                
                ArrayList<Lotissement> lotissements = evaluation
                        .obtenirDonneesLot(json);
                Terrain terrain = evaluation
                        .obtenirDonneesTerrain(json, lotissements);
                int idTerrain = evaluation.obtenirTypeTerrain(terrain);
                double prixMinimum = evaluation.obtenirPrixMinimum(terrain);
                double prixMaximum = evaluation.obtenirPrixMaximum(terrain);
                String [] descriptions = evaluation
                        .obtenirDescription(lotissements);
                int [] passages = evaluation
                        .obtenirNombreDroitPassage(lotissements);
                int [] services = evaluation
                        .obtenirNombreService(lotissements);
                int [] superficies = evaluation
                        .obtenirSuperficie(lotissements);
                String [] dates = evaluation.obtenirDateMesure(lotissements);
                
                //Calculer les différents montants de lots
                //de droit de passage et montant de service
                double [] montantsLot = evaluation
                        .calculerMontantLot(lotissements, idTerrain,
                                superficies, prixMinimum, prixMaximum);
                double [] montantsPassage = evaluation
                        .calculerDroitPassage(lotissements, idTerrain,
                                passages, montantsLot);
                double [] montantsService = evaluation
                        .calculerMontantService(lotissements, idTerrain,
                                superficies, services);
                
                //Calculer les différents montants par lots
                double [] montantsParLot = evaluation
                        .calculerValeurParLot(lotissements, montantsLot,
                                montantsPassage, montantsService);
                
                
                //Calculer la valeur fonciere et la taxe scolaire
                //et la taxe municiple qui vont avec
                double montantTerrain = evaluation
                        .calculerValeurFonciere(lotissements, montantsParLot);
                double montantTaxeScolaire = evaluation
                        .calculerTaxeScolaire(montantTerrain);
                double montantTaxeMunicipale = evaluation
                        .calculerTaxeMunicipale(montantTerrain);
                
                //Afficher le rapport de l'évaluation
                JSONObject enteteRapport = evaluation
                        .genererRapportEvaluation(montantTerrain,
                                montantTaxeScolaire, montantTaxeMunicipale,
                                montantsParLot, descriptions);
                
                Utilitaire.afficherMessage(enteteRapport.toString(4));

                FileWriterException.saveStringIntoFile(sortie,
                        enteteRapport.toString(4), FILE_ENCODING);

            } catch (IOException |NullPointerException e) {
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