/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transfer.util;

/**
 *
 * @author Nikola
 */
public interface Operation {

    public static final int LOGIN = 1;
    public static final int VRATI_IGRACE = 2;
    public static final int VRATI_SUDIJE = 3;
    public static final int VRATI_TAKMICENJA = 4;
    public static final int VRATI_IGRACE_ZA_IZABRANO_TAKMICENJE = 5;
    public static final int VRATI_SUDIJE_ZA_IZABRANO_TAKMICENJE = 6;
    public static final int OBRISI_UCESCE = 7;
    public static final int DODAJ_IGRACA = 8;
    public static final int DODAJ_SUDIJU = 9;
    public static final int SACUVAJ_UCESCA = 10;
    public static final int DODAJ_USERA=11;
    public static final int VRATI_UCESCA_ZA_IZABRANO_TAKMICENJE=12;
    public static final int STORNIRAJ_IGRACA=13;
    public static final int STORNIRAJ_SUDIJU=14;
}
