package edu.thanassis.thancal;

/**
 * Created by Thanassis on 30/9/2015.
 */
public class CalculatorController
{
    private boolean _isOperatorActive;
    private Double _amountKeeper;
    private Double _currentNum;
    private EnumOperators.Operator _op;
    private String _result;
    private ICalculatorResultHandler _resultHandler;

    public CalculatorController(ICalculatorResultHandler resultHandler)
    {
        _amountKeeper = 0.0;
        _currentNum = 0.0;
        _isOperatorActive = false;
        _resultHandler = resultHandler;
        _result = "";
    }

    private void SetResult(String newResult)
    {
        _result = newResult;
        if (_resultHandler != null)
        {
            _resultHandler.OnCalculatorResult(_result);
        }
    }

    public void Add()
    {
        if (!this._isOperatorActive)
        {
            _isOperatorActive = true;
            _op = EnumOperators.Operator.PLUS;

            _currentNum = Double.parseDouble(_result);
            _amountKeeper = Operations.operate(_amountKeeper,_currentNum, _op);
        }
        SetResult(Double.toString(_amountKeeper));
    }

    public void Subtract()
    {

    }

    public void Clear()
    {
        SetResult("0");
        _isOperatorActive = false;
        _amountKeeper = 0.0;
        _currentNum = 0.0;

        _op = null;
    }

    public String Equals()
    {
        if (!_isOperatorActive)
        {
            _currentNum = Double.parseDouble(_result);
        }
        _amountKeeper = Operations.operate(_amountKeeper, _currentNum, _op);
        _isOperatorActive = true;
        SetResult(Double.toString(_amountKeeper));
        return _result;
    }

    public void Number(int number)
    {
        String outputValue = Integer.toString(number);

        if (_isOperatorActive)
        {
            _isOperatorActive = false;
            SetResult(outputValue);
        }
        else
        {
            SetResult(_result + outputValue);
        }
    }
}
