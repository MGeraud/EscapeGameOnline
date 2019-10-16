package com.ocr.geraud;

import com.ocr.geraud.player.AIPlayer;
import com.ocr.geraud.player.HumanPlayer;

public class Main {

    public static void main(String[] args) {
        HumanPlayer j = new HumanPlayer();
        j.createSecretPIN();
        System.out.println(j.getSecretPIN());
    }
}
