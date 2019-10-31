package com.ocr.geraud.compareMethods;

import com.ocr.geraud.LoadProperties;
import com.ocr.geraud.player.Player;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class HumanComparison implements Comparison{
    private static final Logger logger = LogManager.getLogger(HumanComparison.class);


    /**
     * Demande au joueur de rentrer la comparaison avec son code secret
     * redefini les limites min et max du random Bot en fonction de la reponse
     * @param challenger joueur attaquant
     * @param defender joueur defandant
     */

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
        logger.info("Suite elements de comparaison defini par joueur, création des nouvelles limites pourle prochain essai random");
        for (int i = 0 ; i <= (pinLenght -1 ) ; i++ ) {
            if (humanComparison.charAt(i) == '+') {
                int valueOfChar = Character.getNumericValue(challenger.getTmpPIN().charAt(i));
                challenger.limitMin[i] = (valueOfChar + 1);
            } else if (humanComparison.charAt(i) == '-'){
                int valueOfChar = Character.getNumericValue(challenger.getTmpPIN().charAt(i));
                challenger.limitMax[i] = (valueOfChar - 1);
            }
        }
        defender.setTmpComparisonAnswer(humanComparison);
        }
}
