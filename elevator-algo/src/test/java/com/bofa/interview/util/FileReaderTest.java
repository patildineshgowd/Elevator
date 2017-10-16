package com.bofa.interview.util;



import static org.junit.Assert.*;

import java.io.File;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


import com.bofa.interview.domain.DataSet;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class FileReaderTest {
    @InjectMocks
    private FileReader fileReaderMock;

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();


    @Test
    public void TestReadFileInvalidFile(){
        fileReaderMock.readFile("");

    }
    @Test
    public void testReadFileWithResourceValid() {
        Path currentDir = Paths.get("");
        String absolutePath = currentDir.toAbsolutePath().toString();
        List<String> dataSet = fileReaderMock.readFile(absolutePath+"/src/test/resources/testData.txt");
        Assert.assertEquals(dataSet.size(),6);
    }


    @Test
    public void testReadFileWithResourceInvalidFile() {
        List<String> dataSet = fileReaderMock.readFile("testData.txt");
        Assert.assertEquals(dataSet.size(),0);
    }



}
