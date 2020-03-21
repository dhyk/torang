package com.example.torang;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    EditText input;
    TextView output1, output2, output3;
    String angka="1345";
    String resultNilai="", resultTebakan="";
    Button enter;
    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input=findViewById(R.id.editText1);
        output1=findViewById(R.id.tebakan1);
        output2=findViewById(R.id.nilai1);
        output3=findViewById(R.id.score);
        enter=findViewById(R.id.button1);

        output1.setText("");
        output2.setText("");

        score=100;
        output3.setText(""+score);
        this.angka=numberGenerator();
        System.out.println("angka :"+this.angka);

    }

    public void hitung(View view) {
        String printnilai="";
        String inputan=input.getText().toString();

        Counter ct=new Counter();

        if(ct.checkUnique(inputan)==true){


            input.setText("");
            Toast.makeText(this,"ANGKA TIDAK BOLEH KEMBAR",Toast.LENGTH_LONG).show();
        }

        else if(inputan.length()!=4){
            input.setText("");
            Toast.makeText(this,"ANGKA HARUS 4 DIGIT",Toast.LENGTH_LONG).show();

        }

        else {
            Double nilai = ct.getNilai(angka, inputan);

            printnilai = "" + nilai;

            if (nilai == 4.4) {
                Toast.makeText(this, "ANDA MENANG", Toast.LENGTH_LONG).show();
                enter.setEnabled(false);
                enter.setBackground(getDrawable(R.drawable.button_grey));
            }
            else if (score == 2) {
                Toast.makeText(this, "ANDA KALAH", Toast.LENGTH_LONG).show();
                enter.setEnabled(false);
                enter.setBackground(getDrawable(R.drawable.button_grey));
            }
            else if(!resultNilai.equals("")){
                score=score-2;
            }


            resultTebakan=inputan+"\n"+resultTebakan;
            resultNilai=printnilai+"\n"+resultNilai;
            output1.setText(resultTebakan);
            output2.setText(resultNilai);
          output3.setText(""+score);
            input.setText("");
        }
    }

    public String numberGenerator(){
        Random rand = new Random();
        int a,b,c,d;

        a = rand.nextInt(10);
        b = rand.nextInt(10);
        while(a==b){
            b=rand.nextInt(10);
        }
        c = rand.nextInt(10);
        while((a==c)||(b==c)){
            c=rand.nextInt(10);
        }
        d = rand.nextInt(10);
        while((a==d)||(b==d)||(c==d)){
            d=rand.nextInt(10);
        }

        String result=Integer.toString(a)+""+Integer.toString(b)+""+Integer.toString(c)+""+Integer.toString(d);
        return result;
    }

    public void hint(View view) {
        Toast.makeText(this,this.angka,Toast.LENGTH_SHORT).show();
    }

    public void reload(View view) {
        Intent i = new Intent(MainActivity.this,MainActivity.class);
        startActivity(i);
    }
}
