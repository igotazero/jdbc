package controller;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * Created by Andrei_Zanozin on 7/1/2016.
 */
public class Main {
    public static void main(String[] args) {
            BasicConfigurator.configure();
            Logger log = Logger.getLogger(Main.class);
            log.info("Info");
        }
    }
