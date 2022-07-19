/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inf2050.e22.equipe2;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

public interface IEvaluationLot {

    int obtenirNombreLot(ArrayList<Lotissement> lotissements)
            throws IntervallesValideException;

    ArrayList<Lotissement> obtenirDonneesLot()
            throws IOException,
            NumberFormatException, LotValideException,
            IntervallesValideException;

    String[] obtenirDescription(ArrayList<Lotissement> lotissements)
            throws IOException, NullPointerException,
            IntervallesValideException;

    int [] obtenirNombreDroitPassage(ArrayList<Lotissement> lotissements)
            throws IOException, NullPointerException,
            IntervallesValideException;

    int [] obtenirNombreService(ArrayList<Lotissement> lotissements)
            throws IOException, NullPointerException,
            IntervallesValideException;


    int [] obtenirSuperficie(ArrayList<Lotissement> lotissements)
            throws IOException, NullPointerException,
            IntervallesValideException;

    String [] obtenirDateMesure(ArrayList<Lotissement> lotissements)
            throws IOException, NullPointerException,
            IntervallesValideException, ParseException;

    double [] calculerMontantLot(int idTerrain,
                                 int [] superficies,
                                 double prixMinimum,
                                 double prixMaximum,
                                 ArrayList<Lotissement> lotissements)
            throws IOException, NullPointerException,
            IntervallesValideException;

    double [] calculerDroitPassage(int idTerrain, int [] passages,
                                   double [] montantsLot,
                                   ArrayList<Lotissement> lotissements)
            throws IOException, NullPointerException,
            IntervallesValideException;

    double [] calculerMontantService(int idTerrain,
                                     int [] superficies,
                                     int [] services,
                                     ArrayList<Lotissement> lotissements)
            throws IOException, NullPointerException,
            IntervallesValideException;

    double [] calculerValeurParLot(double [] montantsLot,
                                   double [] montantsPassage,
                                   double [] montantsService,
                                   ArrayList<Lotissement> lotissements)
            throws IOException,
            NullPointerException, IntervallesValideException;

    double calculerValeurFonciere(double [] montantsParLot,
                                  ArrayList<Lotissement> lotissements)
            throws IOException,
            NullPointerException, IntervallesValideException;

}