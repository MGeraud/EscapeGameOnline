package com.ocr.geraud.compareMethods;

import com.ocr.geraud.LoadProperties;
import com.ocr.geraud.player.Player;

import java.util.Scanner;

public class HumanComparison implements Comparison{

    @Override
    public void comparer(Player challenger, Player defender) {
        String pinLenghtString = LoadProperties.getInstance().getProperty("PINLenght");
        int pinLenght = Integer.parseInt(pinLenghtString);

        String humanComparison;
        int nullIsNotValid;

        do {
            nullIsNotValid = 0;

            System.out.println("Merci d'indiquer pour chacun des chiffres proposés si celui de la combinaison est plus grand (tapez : +), plus petit (tapez -) ou identique (tqpez =) :");
            Scanner sc = new Scanner(System.in);
            humanComparison = sc.nextLine();
            int i=0;
            do {
                if (humanComparison.charAt(i) == '=' || humanComparison.charAt(i) == '+' || humanComparison.charAt(i) == '-')
                    nullIsNotValid++;
                i = i + 1;
                }while (i <= (pinLenght - 1 ));
            } while (  nullIsNotValid != pinLenght); // double boucle qui permet de verifier contenu valide (longueur et type de contenu)
        challenger.setTmpComparisonAnswer(humanComparison);
    }
}
