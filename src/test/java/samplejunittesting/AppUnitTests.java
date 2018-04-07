package samplejunittesting;

import org.junit.Assert;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.theories.*;
import org.junit.runner.RunWith;

@RunWith(Theories.class)
public class AppUnitTests {


    public App sut;


    @Before
    public void Setup()
    {
        sut = new App();
    }

    @DataPoints ("inputs")
    public static int[][] getInputsAndExpectedValues()
    {
        return new int[][] {
                {3,3,6},
                {5,5,10},
                {6,6,12},
                {3,4}
        };
    }

    @DataPoint
    public static int num1 = 3;

    @DataPoint
    public static int num2 = 3;

    @DataPoint
    public static int res = 6;


    @Theory
    public void addTwoNumbers_WithValidInputFromSingleDataPoint_ReturnResult()
    {

        // Act
        int resultActual = sut.addTwoNumbers(num1,num2);

        // Assert
        Assert.assertEquals(resultActual, res);
    }

    @Theory
    public void addTwoNumbers_WithValidInputFromMultipleDataPoints_ReturnResult(@FromDataPoints("inputs") int[] input)
    {

        // Arrange
        Assume.assumeTrue(input.length==3);

        // Act
        int resultActual = sut.addTwoNumbers(input[0], input[1]);

        System.out.printf("Theory  called with input1 = %d | input2 = %d | result =%d\n", input[0],input[1],input[2]);

        // Assert
        Assert.assertEquals(resultActual, input[2]);
    }}
