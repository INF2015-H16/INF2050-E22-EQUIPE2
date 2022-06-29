/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inf2050.e22.equipe2;

/**
 * Université du Québec à Montréal (UQAM)
 * Cours : INF2050 - 020 - Été 2022
 * Sprint 1
 *
 * MontantLotAgricole : Cette classe calcule les montants agricoles.
 *
 *
 * @author Achou Henri Joël / Akaffou
 * @version 28 juin 2022
 *
 */
public class MontantLotAgricole extends MontantLot {

    public MontantLotAgricole() {
        super(MontantLot.TERRAIN_AGRICOLE);
    }

    @Override
    public double obtenirMontantLot(int index,
                                    int[] superficies,
                                    double prixMinimum, double prixMaximum) {
        return superficies[index] * prixMinimum;
    }

    @Override
    public double obtenirMontantPassage(int index,
                                        int[] passages, double[] montantsLot) {
        return MONTANT_BASE_DROIT_PASSAGE
                - (passages[index]
                * (TAUX_05 * montantsLot[index]));
    }

    @Override
    public double obtenirMontantService(int index,
                                        int[] superficies, int[] services) {
        return MONTANT_SERVICE_0;
    }
}