package com.ocr.geraud.PINguess;

import com.ocr.geraud.player.Player;

import java.util.Scanner;

public class ScanPINGuess implements PINguess {

    /**
     * Player try to find PIN
     */
    @java.lang.Override
    public void pinTest(Player attaquant, Player defenseur) {
        Scanner s = new Scanner(System.in);
        String combinaison;
        boolean isValid;
        System.out.println("Essayez de trouver la combinaison secrete. A vous de jouer :");
        do {
            isValid = true;
            combinaison = s.nextLine();
            try { //Laissons java verifier que l entree est bien composee uniquement de nombres
                int a = Integer.parseInt(combinaison);
            } catch (NumberFormatException e) {
                isValid = false;
                System.out.println("Vous devez saisir une combinaison composée uniquement de chiffres.");
            }
            if (combinaison.length() != 4) System.out.println("Combinaison de 4 chiffres ni plus ni moins svp .");

        } while (combinaison.length() != 4 || isValid == false);

        attaquant.setTmpPIN(combinaison);
    }

}
