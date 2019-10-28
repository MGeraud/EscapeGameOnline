package com.ocr.geraud.player;

import com.ocr.geraud.LoadProperties;

import java.util.Scanner;

public class HumanPlayer extends Player {

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
                isValid = false;
                System.out.println("Vous devez saisir une combinaison composée uniquement de chiffres.");
            }
            if(secretPIN.length() != pinLenght) System.out.println("Combinaison de " + pinLenghtString + "chiffres ni plus ni moins svp .");

        } while (secretPIN.length() != pinLenght || isValid == false);
    }

    public String getSecretPIN() {
        return secretPIN;
    }
}
