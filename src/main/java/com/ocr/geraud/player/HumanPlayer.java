package com.ocr.geraud.player;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class HumanPlayer extends Player {
    private static final Logger logger = LogManager.getLogger(Player.class);


    @Override
    public void createSecretPIN() {
        Scanner s = new Scanner(System.in);

        boolean isValid;
        System.out.println("Veuillez choisir une combinaison secrete de " + pinLenghtString + " chiffres. Je ne la montre pas au robot qui va devoir la deviner, promis!!!");
        do {
            isValid = true;
            secretPIN = s.nextLine();
            try { //Laissons java verifier que l entree est bien composee uniquement de nombres
                int a = Integer.parseInt(secretPIN);
            } catch (NumberFormatException e) {
                logger.info("Le joueur a saisi autre chose que des chiffres.");
                isValid = false;
                System.out.println("Vous devez saisir une combinaison composée uniquement de chiffres.");
            }
            if(secretPIN.length() != pinLenght) {
                logger.info("Le joueur a sasi plus ou moins de chiffre que doit contenir la combinaison.");
                System.out.println("Combinaison de " + pinLenghtString + "chiffres ni plus ni moins svp .");
            }

        } while (secretPIN.length() != pinLenght || !isValid);
    }

    public String getSecretPIN() {
        return secretPIN;
    }
}
