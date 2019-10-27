package com.ocr.geraud;

import com.ocr.geraud.PINguess.ScanPINGuess;
import com.ocr.geraud.compareMethods.HumanComparison;
import com.ocr.geraud.player.AIPlayer;
import com.ocr.geraud.player.HumanPlayer;

import java.io.*;
import java.util.Properties;

public class Main {

    public static void main(String[] args){
        AIPlayer p = new AIPlayer();
        p.resetLimitMax();
        p.limitMax[2] = 7;
        System.out.println(p.getLimitMax()[2]);



}
}
