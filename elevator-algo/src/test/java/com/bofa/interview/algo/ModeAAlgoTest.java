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
public class ModeAAlgoTest {

    @InjectMocks
    private ModeAAlgo modeAAlgoMock;


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
        modeAAlgoMock.calculateAndPrintDistance("::");
    }

    @Test
    public void calculateAndPrintDistanceInvalidFloors() throws InvalidDataException {
        //Integration test
        expectedEx.expect(InvalidDataException.class);
        expectedEx.expectMessage("One of the pickup and drop off floors are in incorrect format for the usecase:");
        modeAAlgoMock.calculateAndPrintDistance("9:1-2,3-4,1");
    }

    @Test
    public void calculateAndPrintDistanceValidData() throws InvalidDataException {
        //Integration test
        modeAAlgoMock.calculateAndPrintDistance("9:1-2,3-4");
        Assert.assertEquals("9 1 2 3 4 (11)", output.toString().trim());

    }

    @After
    public void cleanUp() {
        System.setOut(stdout);
    }

}