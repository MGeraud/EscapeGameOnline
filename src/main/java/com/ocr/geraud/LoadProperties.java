package com.ocr.geraud;
import java.io.InputStream;
import java.util.Properties;

public class LoadProperties {

    /**
     * Loader : properties from config.properties
     */

    private static Properties props = null;
    private static final String fichier = "config.properties";


    private static LoadProperties instance = new LoadProperties();

    public static LoadProperties getInstance() {
        return instance;
    }

    private LoadProperties() {
        this.init();
    }

    private void init() {

        // Si le fichier de properties n'est pas chargé : on le charge
        if (props == null) {
            try {
                InputStream is = LoadProperties.class.getResourceAsStream(fichier);
                if (is == null) {
                    throw  new Exception();
                }
                props = new Properties();
                props.load(is);
            }
            catch (Exception e) {
                System.out.println("Impossible de charger le fichier de configuration demandé !");
            }
        }
    }

    public String getProperty(String maClef) {
        return props.getProperty(maClef);
    }
}