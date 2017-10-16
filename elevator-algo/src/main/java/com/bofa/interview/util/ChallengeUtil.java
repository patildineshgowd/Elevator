package com.bofa.interview.util;

import com.bofa.interview.domain.DataSet;
import com.bofa.interview.exception.InvalidDataException;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class ChallengeUtil {


/*
public static boolean isValidFloor(String  floorNoStrings){
    if(Integer.parseInt(floorNoStrings)<1 || Integer.parseInt(floorNoStrings)>12)
        return false;
    else
        return true;
}*/

public static DataSet buildDataSet(String inputLine) throws InvalidDataException {


    Queue<Integer> floorStopPoints = new LinkedList<>();

    String[] useCase = inputLine.split(":");


    //First one after semicolon is always a starting point
    if(useCase.length!=2)
        throw new InvalidDataException("There cannot be multiple starting points for the usecase: "+inputLine);

    List<String> passengerRoutes = Arrays.stream(useCase[1].split(",")).filter(StringUtils::isNotBlank).collect(Collectors.toList());
    passengerRoutes.stream().forEach(route -> {
        floorStopPoints.addAll(splitToInt(route,"-"));
    });

    if(passengerRoutes.size()*2!= floorStopPoints.size())
        throw new InvalidDataException("One of the pickup and drop off floors are in incorrect format for the usecase: "+inputLine);

    return new DataSet(
            Integer.parseInt(useCase[0])
            ,floorStopPoints);
}


    private static final List<Integer> splitToInt(String data, String regex){
       return Arrays.stream(data.split(regex)).map(Integer::parseInt).collect(Collectors.toList());
    }

}
