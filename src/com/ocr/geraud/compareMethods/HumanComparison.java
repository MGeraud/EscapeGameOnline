package com.ocr.geraud.compareMethods;

import com.ocr.geraud.player.Player;

import java.util.Scanner;

public class HumanComparison implements Comparison{

    @Override
    public void comparer(Player player) {

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
                }while (i <=3);
            } while (  nullIsNotValid != 4); // double boucle qui permet de verifier contenu valide (longueur et type de contenu)
        player.setTmpComparisonAnswer(humanComparison);
    }
}
