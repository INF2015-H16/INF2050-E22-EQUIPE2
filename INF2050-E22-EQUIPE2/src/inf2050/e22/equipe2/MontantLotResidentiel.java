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
 * MontantLotAgricole : Cette classe calcule les montants résidentiels.
 *
 *
 * @author Achou Henri Joël / Akaffou
 * @version juillet 2022
 *
 */
public class MontantLotResidentiel extends MontantLot {

    public MontantLotResidentiel() {
        super(MontantLot.TERRAIN_RESIDENTIEL);
    }

    @Override
    public double obtenirMontantLot(int index,
                                    int[] superficies, double prixMinimum,
                                    double prixMaximum) {
        return superficies[index] * ((prixMinimum + prixMaximum)/2);
    }

    @Override
    public double obtenirMontantPassage(int index,
                                        int[] passages, double[] montantsLot) {
        return MONTANT_BASE_DROIT_PASSAGE
                - (passages[index]
                * (TAUX_10 * montantsLot[index]));
    }

    @Override
    public double obtenirMontantService(int index,
                                        int[] superficies, int[] services) {
        return evaluerTerrainResidentiel(index,
                superficies, services);
    }

    private double evaluerTerrainResidentiel(int index, int [] superficies,
                                            int [] services) {
        double service;

        if (superficies[index] <= SUPERFICIE_500) {
            service = MONTANT_SERVICE_0;
        } else if (superficies[index] > SUPERFICIE_500
                && superficies[index] <= SUPERFICIE_10000) {
            service = (SERVICE_DE_BASE
                    + services[index]) * MONTANT_SERVICE_500;
        } else {
            service = (SERVICE_DE_BASE
                    + services[index]) * MONTANT_SERVICE_1000;
        }

        return service;

    }

}