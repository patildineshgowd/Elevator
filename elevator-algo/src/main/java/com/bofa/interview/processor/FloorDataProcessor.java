package com.bofa.interview.processor;

import com.bofa.interview.algo.AlgoInterface;
import com.bofa.interview.algo.ModeAAlgo;
import com.bofa.interview.algo.ModeBAlgo;
import com.bofa.interview.exception.InvalidDataException;
import com.bofa.interview.util.Constants;
import com.bofa.interview.util.FileReader;

import java.util.List;

public class FloorDataProcessor implements DataProcessor{

    public void readFileAndPrintOutput(String fileLocation, String mode){

        try {
            //Read the file and extract data

            FileReader reader = new FileReader();
            List<String> useCases =  reader.readFile(fileLocation);

            //Define the algorithm to be used based on arguments
            AlgoInterface algoMode;
            //Mode validation is automatically done by Enum
            if(Constants.ModeEnum.valueOf(mode) == Constants.ModeEnum.A) {
                algoMode = new ModeAAlgo();
            }else{
                algoMode = new ModeBAlgo();
            }

            //Iterate through data set and call the algorithm

            for (String useCase: useCases) {
                try {
                    algoMode.calculateAndPrintDistance(useCase);

                }catch (InvalidDataException invalidDataException){
                    //Catching and suppressing the exception for a specific use case.
                    System.out.println(invalidDataException.getMessage());

                }

            }


        }catch (IllegalArgumentException modeException){
            System.out.println("Invalid Data. Please check the mode, only A or B mode is allowed");
        }


    }
}
