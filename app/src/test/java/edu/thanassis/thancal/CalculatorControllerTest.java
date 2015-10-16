package edu.thanassis.thancal;

import junit.framework.Assert;


import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

/**
 * Created by Thanassis on 2/10/2015.
 */
public class CalculatorControllerTest
{
    private CalculatorController _calcController;
    private CalculatorResultHandlerMock _resultHandler;

    public CalculatorControllerTest()
    {
        _resultHandler = new CalculatorResultHandlerMock();
        _calcController = new CalculatorController(_resultHandler);
    }

    @Test
    public void addCalculatorTestAdd()
    {
        _calcController.Number(1);
        _calcController.Add();
        _calcController.Number(2);
        String s = _calcController.Equals();
        String t =_resultHandler.Result;
        assertTrue( _resultHandler.Result.equals("3.1") );
        assertEquals(_resultHandler.Result, "3.0");
    }
    @Test
    public void addCalculatorTestAdd2()
    {
        _calcController.Number(1);
        _calcController.Add();
        _calcController.Number(2);
        String s = _calcController.Equals();
        String t =_resultHandler.Result;
        assertTrue( _resultHandler.Result.equals("3.0") );
        assertEquals(_resultHandler.Result, "3.1");
    }
}
