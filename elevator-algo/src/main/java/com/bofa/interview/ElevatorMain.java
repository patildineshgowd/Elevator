package com.bofa.interview;

import com.bofa.interview.processor.DataProcessor;
import com.bofa.interview.processor.FloorDataProcessor;

public class ElevatorMain {

    public static void main(String[] args) {
        if(args.length<=0){
            System.out.println("Please pass the arguments...");
            System.out.println("java -jar <JarFileName>.jar <FILENAME> <MODE>");
            System.out.println("FILENAME : Has to be contain complete path to the file");
            System.out.println("MODE : Use only char 'A' or 'B' (without quotes)");


        }else {
            DataProcessor main = new FloorDataProcessor();
                main.readFileAndPrintOutput(args[0], args[1]);
        }

    }


}
