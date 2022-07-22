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
 * MontantLot : Cette classe permet de calculer les montants
 *              des lots suivant leur type.
 *
 * @author Achou Henri Joël / Akaffou
 * @version juillet 2022
 *
 */
public abstract class MontantLot {

    public final static int TERRAIN_AGRICOLE = 0;
    public final static int TERRAIN_RESIDENTIEL = 1;
    public final static int TERRAIN_COMMERCIAL = 2;
    public static final double SERVICE_DE_BASE = 2;
    public final static int MONTANT_BASE_DROIT_PASSAGE = 500;
    public final static double TAUX_05 = 0.05;
    public final static double TAUX_10 = 0.10;
    public final static double TAUX_15 = 0.15;
    public static final int SUPERFICIE_500 = 500;
    public static final int SUPERFICIE_10000 = 10000;
    public static final double MONTANT_SERVICE_0 = 0.0;
    public static final double MONTANT_SERVICE_500 = 500;
    public static final double MONTANT_SERVICE_1000 = 1000;
    public static final double MONTANT_SERVICE_1500 = 1500;
    public static final double MONTANT_MAX_SERVICE = 5000;

    private int idTerrain;

    public MontantLot(int idTerrain) {
        this.idTerrain = idTerrain;
    }

    public static MontantLot setMontantLot(int idTerrain) {
        return switch (idTerrain) {
            case TERRAIN_AGRICOLE -> new MontantLotAgricole();
            case TERRAIN_RESIDENTIEL -> new MontantLotResidentiel();
            case TERRAIN_COMMERCIAL -> new MontantLotCommercial();
            default -> null;
        };
    }

    protected abstract double obtenirMontantLot(int index,
                                             int [] superficies,
                                             double prixMinimum,
                                             double prixMaximum);

    protected abstract double obtenirMontantPassage(int index,
                                         int [] passages,
                                         double [] montantsLot);

    protected abstract double obtenirMontantService(int index,
                                         int [] superficies, int [] services);

}