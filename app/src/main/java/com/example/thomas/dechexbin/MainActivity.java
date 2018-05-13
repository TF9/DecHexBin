package com.example.thomas.dechexbin;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.MultiAutoCompleteTextView;
import android.widget.TextView;

import java.math.BigInteger;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class MainActivity extends AppCompatActivity
{

    Boolean Mutex = FALSE;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText myDecText = (EditText) findViewById(R.id.editDec);
        EditText myHexText = (EditText) findViewById(R.id.editHex);
        EditText myBinText = (EditText) findViewById(R.id.editBin);
        myDecText.addTextChangedListener(new TextWatcher()
        {

            public void afterTextChanged(Editable s)
            {
            }

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after)
            {
            }

            @SuppressLint("SetTextI18n")
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count)
            {
                if(!Mutex)
                {
                    String s1 = s.toString();
                    if(!s1.isEmpty())
                    {
                        Mutex = TRUE;
                        long l = Long.parseLong(s1);
                        String s2 = Long.toBinaryString(l);
                        String s3 = Long.toHexString(l).toUpperCase();
                        EditText myOutputBox = (EditText) findViewById(R.id.editHex);
                        myOutputBox.setText(s3);
                        myOutputBox = (EditText) findViewById(R.id.editBin);
                        myOutputBox.setText(s2);
                        Mutex = FALSE;
                    }
                }
            }
        });

        myHexText.addTextChangedListener(new TextWatcher()
        {

            public void afterTextChanged(Editable s)
            {
            }

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after)
            {
            }

            public void onTextChanged(CharSequence s, int start,
                                      int before, int count)
            {
                if(!Mutex)
                {
                    String s1 = s.toString().toUpperCase();
                    if(!s1.isEmpty())
                    {
                        Mutex = TRUE;
                        long i = Long.parseLong(s1,16);
                        String s2 = Long.toString(i);
                        String s3 = Long.toBinaryString(i);
                        EditText myOutputBox = (EditText) findViewById(R.id.editDec);
                        myOutputBox.setText(s2);
                        myOutputBox = (EditText) findViewById(R.id.editBin);
                        myOutputBox.setText(s3);
                        myOutputBox = (EditText) findViewById(R.id.editHex);
                        myOutputBox.setText(s1);
                        Mutex = FALSE;
                    }
                }
            }
        });

        myBinText.addTextChangedListener(new TextWatcher()
        {

            public void afterTextChanged(Editable s)
            {
            }

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after)
            {
            }

            public void onTextChanged(CharSequence s, int start,
                                      int before, int count)
            {
                if(!Mutex)
                {
                    String s1 = s.toString();
                    if(!s1.isEmpty())
                    {
                        Mutex = TRUE;
                        long i = Long.parseLong(s1,2);
                        String s2 = Long.toString(i);
                        String s3 = Long.toHexString(i).toUpperCase();
                        EditText myOutputBox = (EditText) findViewById(R.id.editDec);
                        myOutputBox.setText(s2);
                        myOutputBox = (EditText) findViewById(R.id.editHex);
                        myOutputBox.setText(s3);
                        Mutex = FALSE;
                    }
                }
            }
        });
    }
}
