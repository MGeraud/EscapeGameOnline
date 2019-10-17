package com.ocr.geraud.compareMethods;

import java.util.Scanner;

public class HumanComparison implements Comparison{
    @Override
    public String comparer() {
        String humanComparison;
        do {
            System.out.println("Merci d'indiquer pour chacun des chiffres proposés si celui de la combinaison est plus grand (tapez : +), plus petit (tapez -) ou identique (tqpez =) :");
            Scanner sc = new Scanner(System.in);
            humanComparison = sc.nextLine();
        } while ( humanComparison.length() != 4 );
        return humanComparison ;
    }
}
