package com.example.hesapmakinesi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    String tut;
    ArrayList<Double> sayilar=new ArrayList<>();
    ArrayList<String > islemler=new ArrayList<>();
    Button sifir,bir,iki,uc,dort,bes,alti,yedi,sekiz,dokuz,toplam,fark,bolum,carpim,esittir,temizle;
    EditText sonuc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sifir=findViewById(R.id.sifir);
        bir=findViewById(R.id.bir);
        iki=findViewById(R.id.iki);
        uc=findViewById(R.id.uc);
        dort=findViewById(R.id.dort);
        bes=findViewById(R.id.bes);
        alti=findViewById(R.id.alti);
        yedi=findViewById(R.id.yedi);
        sekiz=findViewById(R.id.sekiz);
        dokuz=findViewById(R.id.dokuz);
        toplam=findViewById(R.id.toplam);
        fark=findViewById(R.id.fark);
        carpim=findViewById(R.id.carpim);
        bolum=findViewById(R.id.bolum);
        esittir=findViewById(R.id.esittir);
        sonuc=findViewById(R.id.sonuc);
        temizle=findViewById(R.id.temizle);
        temizle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tut="";
                sonuc.setText("");
                sayilar.clear();
                islemler.clear();
            }
        });
        sifir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sayiButtonlari(sifir);
            }
        });
        bir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sayiButtonlari(bir);
            }
        });
        iki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sayiButtonlari(iki);
            }
        });
        uc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sayiButtonlari(uc);
            }
        });
        dort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sayiButtonlari(dort);
            }
        });
        bes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sayiButtonlari(bes);
            }
        });
        alti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sayiButtonlari(alti);
            }
        });
        yedi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sayiButtonlari(yedi);
            }
        });
        sekiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sayiButtonlari(sekiz);
            }
        });
        dokuz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sayiButtonlari(dokuz);
            }
        });
        toplam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                if(sonuc.getText().toString().equals(""))
                {
                    Toast.makeText(MainActivity.this,"Lütfen sayı giriniz",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    sayilar.add(Double.parseDouble(tut));
                    tut=null;
                    sonuc.setText(sonuc.getText()+"+");
                    islemler.add("+");
                }
            }
        });
        fark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                if(sonuc.getText().toString().equals(""))
                {
                    Toast.makeText(MainActivity.this,"Lütfen sayı giriniz",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    sayilar.add(Double.parseDouble(tut));
                    tut=null;
                    sonuc.setText(sonuc.getText()+"-");
                    islemler.add("-");
                }
            }
        });
        carpim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                if(sonuc.getText().toString().equals(""))
                {
                    Toast.makeText(MainActivity.this,"Lütfen sayı giriniz",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    sayilar.add(Double.parseDouble(tut));
                    tut=null;
                    sonuc.setText(sonuc.getText()+"x");
                    islemler.add("x");
                }
            }
        });
        bolum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                if(sonuc.getText().toString().equals(""))
                {
                    Toast.makeText(MainActivity.this,"Lütfen sayı giriniz",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    sayilar.add(Double.parseDouble(tut));
                    tut=null;
                    sonuc.setText(sonuc.getText()+"/");
                    islemler.add("/");
                }
            }
        });
        esittir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                if(sonuc.getText().toString().equals(""))
                {
                    Toast.makeText(MainActivity.this,"Lütfen sayı giriniz",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    double result;
                    sayilar.add(Double.parseDouble(tut));
                    tut=null;
                    ara();
                    sonuc.setText(sonuc.getText()+"="+sayilar.get(0));
                }
            }
        });
    }
    public void sayiButtonlari(Button b)
    {
        sonuc.setText(sonuc.getText()+b.getText().toString());
        if(tut==null)
        tut=b.getText().toString();
        else
            tut=tut+b.getText().toString();
    }
    public void ara()
    {
        for (int i=0;i<islemler.size();i++)
        {
            if(islemler.get(i).equals("x"))
               i= yap("x",i);
            else if(islemler.get(i).equals("/"))
                i=yap("/",i);
        }
        for (int i=0;i<islemler.size();i++)
        {
            if(islemler.get(i).equals("+"))
                i=yap("+",i);
            else if(islemler.get(i).equals("-"))
                i=yap("-",i);
        }
    }
    public int yap(String s,int i)
    {
        double result;
        if(s.equals("x"))
            result=sayilar.get(i)*sayilar.get(i+1);
        else if (s.equals("/"))
            result=sayilar.get(i)/sayilar.get(i+1);
        else  if (s.equals("+"))
            result=sayilar.get(i)+sayilar.get(i+1);
        else
            result=sayilar.get(i)-sayilar.get(i+1);
        sayilar.add(i+2,result);
        sayilar.remove(i);
        sayilar.remove(i);
        islemler.remove(s);
        return --i;
    }

}