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
 * MontantLotAgricole : Cette classe calcule les montants commerciaux.
 *
 *
 * @author Achou Henri Joël / Akaffou
 * @version juillet 2022
 *
 */
public class MontantLotCommercial extends MontantLot {

    public MontantLotCommercial() {
        super(MontantLot.TERRAIN_COMMERCIAL);
    }

    @Override
    public double obtenirMontantLot(int index,
                                    int[] superficies, double prixMinimum,
                                    double prixMaximum) {
        return superficies[index] * prixMaximum;
    }

    @Override
    public double obtenirMontantPassage(int index,
                                        int[] passages, double[] montantsLot) {
        return MONTANT_BASE_DROIT_PASSAGE
                - (passages[index]
                * (TAUX_15 * montantsLot[index]));
    }

    @Override
    public double obtenirMontantService(int index,
                                        int[] superficies, int[] services) {
        return determinerMontantCommercial(
                evaluerTerrainCommercial(index, superficies, services));
    }

    private static double evaluerTerrainCommercial(int index, int [] superficies,
                                            int [] services) {
        double service = 0.0;

        if (superficies[index] <= SUPERFICIE_500) {
            service = (SERVICE_DE_BASE
                    + services[index]) * MONTANT_SERVICE_500;

        } else if (superficies[index] > SUPERFICIE_500) {
            service = (SERVICE_DE_BASE
                    + services[index]) * MONTANT_SERVICE_1500;
        }

        return service;
    }

    private static double determinerMontantCommercial(double montantService) {
        double montant;

        if (montantService > MONTANT_MAX_SERVICE) {
            montant = MONTANT_MAX_SERVICE;

        } else {
            montant = montantService;

        }

        return montant;
    }

}