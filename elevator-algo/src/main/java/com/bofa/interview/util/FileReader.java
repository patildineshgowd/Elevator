package com.bofa.interview.util;

import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileReader {


        public List<String> readFile(String fileName){

            List<String> testData = new ArrayList<>();

            try  {
                Stream<String> stream = Files.lines(Paths.get(fileName));
                testData = stream.filter(StringUtils::isNotBlank).collect(Collectors.toList());

            } catch (IOException|UncheckedIOException e) {
                System.out.println("FILE Not accessible!!! : Has to be contain complete path to the file");
            }

            return testData;
        }




    }
