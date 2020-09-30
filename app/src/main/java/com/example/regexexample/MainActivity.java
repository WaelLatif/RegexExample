package com.example.regexexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    TextView txtSerch;
    TextView txtpargraph;
    TextView txtResult;
    Button btnSerch;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtSerch = findViewById(R.id.txtSerchWord);
        txtpargraph = findViewById(R.id.txtParagraph);
        txtResult = findViewById(R.id.txtResult);
        btnSerch = findViewById(R.id.btnSerch);

        btnSerch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Search();

            }
        });
    }

    protected void Search() {


        Pattern p = Pattern.compile("\\w*" + txtSerch.getText().toString().trim() );

        Matcher m = p.matcher(txtpargraph.getText().toString().trim());
        if (m.find())
            txtResult.setText(m.group());

        else {
            txtResult.setText("No Matching");
           // Toast.makeText(this, "NO matching", Toast.LENGTH_LONG).show();
        }


    }
}