package com.ocr.geraud.PINguess;

import com.ocr.geraud.LoadProperties;
import com.ocr.geraud.player.Player;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class ScanPINGuess implements PINguess {

    private String pinLenghtString = LoadProperties.getInstance().getProperty("PINLenght");
    private int pinLenght = Integer.parseInt(pinLenghtString);
    private static final Logger logger = LogManager.getLogger(ScanPINGuess.class);

    /**
     * Player try to find PIN
     */
    @java.lang.Override
    public void pinTest(Player attaquant, Player defenseur) {
        Scanner s = new Scanner(System.in);
        String combinaison;
        boolean isValid;
        System.out.println("Essayez de trouver la combinaison secrete ( " + pinLenghtString + " chiffres). A vous de jouer :");
        do {
            isValid = true;
            combinaison = s.nextLine();
            try { //Laissons java verifier que l entree est bien composee uniquement de nombres
                int a = Integer.parseInt(combinaison);
                if (a < 0 ) {
                    logger.info("Le joueur a saisi un chiffre negatif");
                    isValid = false;
                    System.out.println("Vous devez saisir une combinaison composée uniquement de chiffres.");
                }
            } catch (NumberFormatException e) {
                logger.error("Le joueur a saisi autre chose que des chiffres. " + e);
                isValid = false;
                System.out.println("Vous devez saisir une combinaison composée uniquement de chiffres.");
            }
            if (combinaison.length() != pinLenght) {
                logger.info("Le joueur a saisi plus ou moins de chiffres que la longueur de la combinaison.");
                System.out.println("Combinaison de " + pinLenghtString + " chiffres ni plus ni moins svp .");
            }

        } while (combinaison.length() != pinLenght || !isValid);

        attaquant.setTmpPIN(combinaison);
    }

}
