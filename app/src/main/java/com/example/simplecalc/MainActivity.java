package com.example.simplecalc;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.AppCompatButton;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class MainActivity extends AppCompatActivity {
    TextView Working, Results;
    String Workings = "";
    String Formula = "", TempFormula="";
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initTextView();
        AppCompatButton EqualButton = findViewById(R.id.EqualButton);
        EqualButton.setOnClickListener(new View.OnClickListener() {
        private void checkPowersOf() {
            ArrayList<Integer> indexOfPowers = new ArrayList<>();
            for(int i=0 ; i < Workings.length(); i++)
            {
                if(Workings.charAt(i) == '^')
                        indexOfPowers.add(i);
            }

            Formula = Workings;
            TempFormula = Workings;
            for(Integer index: indexOfPowers)
            {
                changeFormula(index);
            }
            Formula = TempFormula;
            }
            private void changeFormula(Integer index)
            {
            String numberLeft = "";
            String numberRight = "";
            for(int i = index + 1; i<Workings.length() ; i++)
            {
                if(isNumeric(Workings.charAt(i)))
                    numberRight = numberRight + Workings.charAt(i);
                else
                    break;
            }
            for(int i = index - 1; i>=0 ; i--)
            {
                if(isNumeric(Workings.charAt(i)))
                    numberLeft = numberLeft + Workings.charAt(i);
                else
                    break;
            }

            String original = numberLeft + "^" +numberRight;
            String changed = "Math.pow("+numberLeft+","+numberRight+")";
            TempFormula = TempFormula.replace(original,changed);

            }

            private boolean isNumeric(char c)
            {
                if(c <= '9' && c>= '0' || c=='.')
                {
                    return true;
                }
                return false;
            }


            @Override
            public void onClick(View view) {
                Double result = null;
                ScriptEngine engine = new ScriptEngineManager().getEngineByName("rhino");
                checkPowersOf();
                try {
                    result = (double)engine.eval(Formula);
                } catch (ScriptException e) {
                    Working.setText("Invalid Input");
                }
                if(result !=null) {
                    Results.setText(String.valueOf(result.doubleValue()));
                }
            }
        });
        AppCompatButton no0 = findViewById(R.id.No0);
        no0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            setWorkings("0");
            }
        });
        AppCompatButton no1 = findViewById(R.id.No1);
        no1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setWorkings("1");
            }
        });
        AppCompatButton no2 = findViewById(R.id.No2);
        no2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setWorkings("2");
            }
        });
        AppCompatButton no3 = findViewById(R.id.No3);
        no3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setWorkings("3");
            }
        });
        AppCompatButton no4 = findViewById(R.id.No4);
        no4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setWorkings("4");
            }
        });
        AppCompatButton no5 = findViewById(R.id.No5);
        no5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setWorkings("5");
            }
        });
        AppCompatButton no6 = findViewById(R.id.No6);
        no6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setWorkings("6");
            }
        });
        AppCompatButton no7 = findViewById(R.id.No7);
        no7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setWorkings("7");
            }
        });
        AppCompatButton no8 = findViewById(R.id.No8);
        no8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setWorkings("8");
            }
        });
        AppCompatButton no9 = findViewById(R.id.No9);
        no9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setWorkings("9");
            }
        });
        AppCompatButton clearButton = findViewById(R.id.ClearButton);
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Working.setText("");
                Workings = "";
                Results.setText("0");
            }
        });
        AppCompatButton multiplyButton = findViewById(R.id.MultiplyButton);
        multiplyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setWorkings("*");
            }
        });
        AppCompatButton decimalButton = findViewById(R.id.DecimalButton);
        decimalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setWorkings(".");
            }
        });
        AppCompatButton divideButton = findViewById(R.id.DivideButton);
        divideButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setWorkings("/");
            }
        });
        AppCompatButton plusButton = findViewById(R.id.PlusButton);
        plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setWorkings("+");
            }
        });
        AppCompatButton powerButton = findViewById(R.id.PowerButton);
        powerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setWorkings("^");
            }
        });
        AppCompatButton bracketButton = findViewById(R.id.BracketButton);
        bracketButton.setOnClickListener(new View.OnClickListener() {
            boolean leftBracket=true;
            @Override
            public void onClick(View view) {
                if(leftBracket) {
                    setWorkings("(");
                    leftBracket=false;
                }
                else {
                    setWorkings(")");
                    leftBracket=true;
                }
            }
        });
        AppCompatButton minusButton = findViewById(R.id.MinusButton);
        minusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setWorkings("-");
            }
        });
    }
    private void initTextView() {
        Working = (TextView) findViewById(R.id.Working);
        Results = (TextView) findViewById(R.id.Result);
    }
    private void setWorkings( String givenValue ) {
        Workings = Workings + givenValue;
        Working.setText(Workings);
    }
}