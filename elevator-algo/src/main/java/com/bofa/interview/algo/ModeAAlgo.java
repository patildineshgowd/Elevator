package com.bofa.interview.algo;


import com.bofa.interview.domain.DataSet;
import com.bofa.interview.exception.InvalidDataException;
import com.bofa.interview.util.ChallengeUtil;

public class ModeAAlgo  implements AlgoInterface{
    @Override
    public void calculateAndPrintDistance(String data) throws InvalidDataException {

        //Get the data and convert to right format
        DataSet dataSet = ChallengeUtil.buildDataSet(data);
            System.out.print(dataSet.getStartingIndex()+" ");

            //make sure the loop breaks
            Integer pickOrDropFloor;
            int travelledDistance =0;
            int startingFloor = dataSet.getStartingIndex();
            while (true){
                pickOrDropFloor = dataSet.getRoutes().poll();
                if(pickOrDropFloor==null)
                    break;
                System.out.print(pickOrDropFloor+" ");
                travelledDistance = travelledDistance+Math.abs(startingFloor-pickOrDropFloor);
                startingFloor = pickOrDropFloor;
            }
            System.out.println("("+travelledDistance+")");




    }


}
