package com.bofa.interview.algo;


import com.bofa.interview.domain.DataSet;
import com.bofa.interview.exception.InvalidDataException;
import com.bofa.interview.util.ChallengeUtil;
import org.junit.*;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.LinkedList;

@RunWith(MockitoJUnitRunner.class)
public class ModeBAlgoTest {

    @InjectMocks
    private ModeBAlgo modeBAlgoMock;


    @Rule
    public ExpectedException expectedEx = ExpectedException.none();
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();
    private final PrintStream stdout = System.out;


    @Before
    public void setUp() throws UnsupportedEncodingException {
        System.setOut(new PrintStream(output, true, "UTF-8"));
    }

    @Test
    public void calculateAndPrintDistanceInvalidData() throws InvalidDataException {
        //Integration test
        expectedEx.expect(InvalidDataException.class);
        expectedEx.expectMessage("There cannot be multiple starting points for the usecase: ::");
        modeBAlgoMock.calculateAndPrintDistance("::");
    }

    @Test
    public void calculateAndPrintDistanceInvalidFloors() throws InvalidDataException {
        //Integration test
        expectedEx.expect(InvalidDataException.class);
        expectedEx.expectMessage("One of the pickup and drop off floors are in incorrect format for the usecase:");
        modeBAlgoMock.calculateAndPrintDistance("9:1-2,3-4,1");
    }

    @Test
    public void calculateAndPrintDistanceValidData() throws InvalidDataException {
        //Integration test
    	modeBAlgoMock.calculateAndPrintDistance("3:7-9,3-7,5-8,7-11,11-1");
        Assert.assertEquals("3 5 7 8 9 11 1 (18)", output.toString().trim());

    }
    

    @After
    public void cleanUp() {
        System.setOut(stdout);
    }

}