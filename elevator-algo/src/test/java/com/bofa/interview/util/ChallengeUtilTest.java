package com.bofa.interview.util;

import com.bofa.interview.domain.DataSet;
import com.bofa.interview.exception.InvalidDataException;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class ChallengeUtilTest {

    @Mock
    private ChallengeUtil challengeUtilMock;

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();


    @Test
    public void TestBuildDataSetValidOne() throws InvalidDataException {
        DataSet testData =
        challengeUtilMock.buildDataSet("10:1-2");
        Assert.assertEquals(testData.getStartingIndex(), 10);
        Assert.assertEquals(testData.getRoutes().size(),2);
    }

    @Test
    public void TestBuildDataSetValidMutiple() throws InvalidDataException {
        DataSet testData =
                challengeUtilMock.buildDataSet("9:1-2,3-4");
        Assert.assertEquals(testData.getStartingIndex(), 9);
        Assert.assertEquals(testData.getRoutes().size(),4);
    }

    @Test
    public void TestBuildDataSetInvalidStartingIndex() throws InvalidDataException {

        expectedEx.expect(InvalidDataException.class);
        expectedEx.expectMessage("There cannot be multiple starting points");
        DataSet testData =
                challengeUtilMock.buildDataSet("9::1-2,3-4");

    }

    @Test
    public void TestBuildDataSetInvalidFloors() throws InvalidDataException {

        expectedEx.expect(InvalidDataException.class);
        expectedEx.expectMessage("One of the pickup and drop off floors are in incorrect format");
        DataSet testData =
                challengeUtilMock.buildDataSet("9:1-2,1,3-4");

    }
}
