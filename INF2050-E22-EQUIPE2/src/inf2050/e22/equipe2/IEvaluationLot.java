/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inf2050.e22.equipe2;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public interface IEvaluationLot {

    int obtenirNombreLot();

    ArrayList<Lotissement> obtenirDonneesLot()
            throws FileNotFoundException, IOException,
            NumberFormatException, LotValideException;

    String[] obtenirDescription()
            throws IOException, NullPointerException;

    int [] obtenirNombreDroitPassage()
            throws IOException, NullPointerException;

    int [] obtenirNombreService()
            throws IOException, NullPointerException;


    int [] obtenirSuperficie()
            throws IOException, NullPointerException;

    String [] obtenirDateMesure()
            throws IOException, NullPointerException;

    double [] calculerMontantLot(int idTerrain, int [] superficies,
            double prixMinimum,
                                        double prixMaximum)
            throws IOException, NullPointerException;

    double [] calculerDroitPassage(int idTerrain, int [] passages,
            double [] montantsLot)
            throws IOException, NullPointerException;

    double [] calculerMontantService(int idTerrain,
            int [] superficies, int [] services) throws IOException,
            NullPointerException;

    double [] calculerValeurParLot(double [] montantsLot,
            double [] montantsPassage,
                                   double [] montantsService)
            throws IOException,
            NullPointerException;

    double calculerValeurFonciere(double [] montantsParLot)
            throws IOException,
            NullPointerException;

}
