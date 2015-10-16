package edu.thanassis.thancal;


/**
 * Created by Thanassis on 2/10/2015.
 */

public class CalculatorResultHandlerMock implements ICalculatorResultHandler
{
    public String Result;

    @Override
    public void OnCalculatorResult(String result)
    {
        Result = result;
    }
}
