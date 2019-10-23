package com.ocr.geraud.player;

public abstract class Player {

    protected String secretPIN = "";
    protected String tmpPIN ="";
    protected String tmpComparisonAnswer= "";

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
}
