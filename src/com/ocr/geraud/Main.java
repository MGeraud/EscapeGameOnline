package com.ocr.geraud;

import com.ocr.geraud.compareMethods.HumanComparison;
import com.ocr.geraud.player.AIPlayer;
import com.ocr.geraud.player.HumanPlayer;

public class Main {

    public static void main(String[] args) {
        HumanComparison j = new HumanComparison();
        j.comparer();
        System.out.println(j);
    }
}
