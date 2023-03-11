package com.example.convertor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Spinner sp1,sp2;
    EditText ed1;
    Button  b1;
    TextView txtTo;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ed1=findViewById(R.id.txtamount);
        sp1=(Spinner) findViewById(R.id.spfrom);
        sp2=(Spinner)findViewById(R.id.spto);
        b1=findViewById(R.id.btn);
        txtTo=(TextView) findViewById(R.id.txtTo);
        final String[] currencies={"USD","MAD","EURO"};
        final String[] usd={"MAD","EURO"};
        final String[] mad={"USD","EURO"};
        final String[] euro={"MAD","USD"};
        ArrayAdapter<String>  adapter1=new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,currencies);
        ArrayAdapter<String>  adapter2=new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,usd);
        ArrayAdapter<String>  adapter3=new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,mad);
        ArrayAdapter<String>  adapter4=new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,euro);
        sp1.setAdapter(adapter1);

        sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==0){
                    sp2.setAdapter(adapter2);

                }else if(i==1){
                    sp2.setAdapter(adapter3);

                }else {
                    sp2.setAdapter(adapter4);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });









        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Double tot;
                Double amount=Double.parseDouble(ed1.getText().toString());
                if(sp1.getSelectedItem().toString()=="USD" && sp2.getSelectedItem().toString()=="MAD"){

                    tot=amount*10.34;
                  //  Toast.makeText(getApplicationContext(),tot.toString(),Toast.LENGTH_LONG).show();
                    txtTo.setText(tot.toString());
                }
                else if(sp1.getSelectedItem().toString()=="USD" && sp2.getSelectedItem().toString()=="EURO"){

                    tot=amount*0.94;
                    //Toast.makeText(getApplicationContext(),tot.toString(),Toast.LENGTH_LONG).show();
                    txtTo.setText(tot.toString());
                }     else if(sp1.getSelectedItem().toString()=="MAD" && sp2.getSelectedItem().toString()=="USD"){

                    tot=amount*0.097;
                    //Toast.makeText(getApplicationContext(),tot.toString(),Toast.LENGTH_LONG).show();
                    txtTo.setText(tot.toString());
                }  else if(sp1.getSelectedItem().toString()=="MAD" && sp2.getSelectedItem().toString()=="EURO"){

                    tot=amount*0.091;
                    //Toast.makeText(getApplicationContext(),tot.toString(),Toast.LENGTH_LONG).show();
                    txtTo.setText(tot.toString());
                }
                else if(sp1.getSelectedItem().toString()=="EURO" && sp2.getSelectedItem().toString()=="USD"){

                    tot=amount * 1.06;
                    //Toast.makeText(getApplicationContext(),tot.toString(),Toast.LENGTH_LONG).show();
                    txtTo.setText(tot.toString());
                }
                else if(sp1.getSelectedItem().toString()=="EURO" && sp2.getSelectedItem().toString()=="MAD"){

                    tot=amount*11.01;
                    //Toast.makeText(getApplicationContext(),tot.toString(),Toast.LENGTH_LONG).show();
                    txtTo.setText(tot.toString());
                }
            }
        });

    }
}