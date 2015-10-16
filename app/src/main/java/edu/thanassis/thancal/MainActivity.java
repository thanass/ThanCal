package edu.thanassis.thancal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import edu.thanassis.thancal.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, ICalculatorResultHandler
{
    private Button _btn1;
    private Button _btn2;
    private Button _btn3;
    private Button _btn4;
    private Button _btn5;
    private Button _btn6;
    private Button _btn7;
    private Button _btn8;
    private Button _btn9;
    private Button _btn0;
    private Button _btnClear;
    private Button _btnPlus;
    private Button _btnResult;
    private TextView _consoleView;

    private CalculatorController _controller;

    public MainActivity()
    {
        _controller = new CalculatorController(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _btn0 = (Button) findViewById(R.id.button10);
        _btn1 = (Button) findViewById(R.id.button1);
        _btn2 = (Button) findViewById(R.id.button2);
        _btn3 = (Button) findViewById(R.id.button3);
        _btn4 = (Button) findViewById(R.id.button4);
        _btn5 = (Button) findViewById(R.id.button5);
        _btn6 = (Button) findViewById(R.id.button6);
        _btn7 = (Button) findViewById(R.id.button7);
        _btn8 = (Button) findViewById(R.id.button8);
        _btn9 = (Button) findViewById(R.id.button9);
        _btnClear = (Button) findViewById(R.id.buttonClear);
        _btnPlus = (Button) findViewById(R.id.buttonPlus);
        _btnResult = (Button) findViewById(R.id.buttonResult);
        _consoleView = (TextView) findViewById(R.id.consoleTxtView);

        _btn0.setOnClickListener(this);
        _btn1.setOnClickListener(this);
        _btn2.setOnClickListener(this);
        _btn3.setOnClickListener(this);
        _btn4.setOnClickListener(this);
        _btn5.setOnClickListener(this);
        _btn6.setOnClickListener(this);
        _btn7.setOnClickListener(this);
        _btn8.setOnClickListener(this);
        _btn9.setOnClickListener(this);
        _btnClear.setOnClickListener(this);
        _btnResult.setOnClickListener(this);
        _btnPlus.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        int curViewId = v.getId();

        if (curViewId == _btnClear.getId())
        {
            _controller.Clear();
        }
        else if(curViewId == _btnPlus.getId())
        {
            // Handler for plus button
            _controller.Add();
        }
        else if (curViewId == _btnResult.getId())
        {
            // Handler for result button
            _controller.Equals();
        }
        else
        {
            // Handler for numbers buttons
            _controller.Number(Integer.parseInt(((Button) v).getText().toString()));
        }
    }

    @Override
    public void OnCalculatorResult(String result)
    {
        _consoleView.setText(result);
    }
}
