package com.ocr.geraud.player;

import com.ocr.geraud.LoadProperties;

public abstract class Player {
    protected String pinLenghtString = LoadProperties.getInstance().getProperty("PINLenght");
    protected int pinLenght = Integer.parseInt(pinLenghtString);

    protected String secretPIN = "";
    protected String tmpPIN ="";
    protected String tmpComparisonAnswer= "";
    protected int[] limitMax = new int[pinLenght];
    protected int [] limitMin = new int[pinLenght];

    public void resetLimitMax (){
        int i;
        for (i=0 ; i <= pinLenght; i++) {
            limitMax[i] = 9;
        }
    }

    public void resetLimitMin (){
        int i;
        for (i=0 ; i <= pinLenght; i++) {
            limitMin[i] = 0;
        }
    }

    public void createSecretPIN(){
        System.out.println("Création de la combinaison secète ...");
    }

    public String getTmpPIN() {
        return tmpPIN;
    }

    public void setTmpPIN(String tmpPIN) {
        this.tmpPIN = tmpPIN;
    }

    public String getTmpComparisonAnswer() {
        return tmpComparisonAnswer;
    }

    public void setTmpComparisonAnswer(String tmpComparisonAnswer) {
        this.tmpComparisonAnswer = tmpComparisonAnswer;
    }

    public int[] getLimitMax() {
        return limitMax;
    }

    public void setLimitMax(int[] limitMax) {
        this.limitMax = limitMax;
    }

    public int[] getLimitMin() {
        return limitMin;
    }

    public void setLimitMin(int[] limitMin) {
        this.limitMin = limitMin;
    }
}
