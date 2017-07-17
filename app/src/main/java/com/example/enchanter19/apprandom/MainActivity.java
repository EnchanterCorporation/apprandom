package com.example.enchanter19.apprandom;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class MainActivity extends AppCompatActivity {
    Button button;
    TextView textView,textView1,txtans;
    int correct,wrong,t3=1;
    EditText editText;
    String mystring,mystring1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        textView = (TextView) findViewById(R.id.number);
        textView1 = (TextView) findViewById(R.id.number2);
        txtans = (TextView) findViewById(R.id.ans);
        editText = (EditText) findViewById(R.id.ed1);
        button=(Button)findViewById(R.id.but1);


        cal();
    }


        public  void cal() {
            Random random = new Random();
            int number = random.nextInt(6) + 1;
            mystring = String.valueOf(number);
            textView.setText(mystring);
            int number1 = random.nextInt(6) + 1;
             mystring1 = String.valueOf(number1);
            textView1.setText(mystring1);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int t4=Integer.parseInt(mystring)*Integer.parseInt(mystring1);

                    String t5=Integer.toString(t4);

                    txtans.setText(t5);
                   txtans.setVisibility(view.INVISIBLE);

                    //String s1 = Integer.toString(t3);
                    String gg = editText.getText().toString();
                    if (t5.equals(gg)) {
                        ++correct;
                        Toast.makeText(getApplicationContext(),"correct",Toast.LENGTH_SHORT).show();
                        cal();
                    } else {
                        ++wrong;
                         cal();
                    }

                }
            });


//
            // txtans.setText(t1);


        }







    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
