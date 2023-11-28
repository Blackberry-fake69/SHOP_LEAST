package com.example.sqlite_add_test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ConsultarLista extends AppCompatActivity {


    RecyclerView recyclerView;

    TextView Testename;
    Adaptador adaptador;


    BandoDeDados Mydb;
    ArrayList<String> Colunaid, Colunaproduto, Colunapreco;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        setContentView(R.layout.activity_consultar_lista);


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_lista);
        recyclerView = findViewById(R.id.ListasAntigas);




        Mydb = new BandoDeDados(ConsultarLista.this);
        Colunaid = new ArrayList<>();
        Colunaproduto = new ArrayList<>();
        Colunapreco = new ArrayList<>();

        armazenadorDeDadosDeArray();

        adaptador = new Adaptador(ConsultarLista.this,Colunaid,Colunaproduto,Colunapreco);
        recyclerView.setAdapter(adaptador);
        recyclerView.setLayoutManager( new LinearLayoutManager(ConsultarLista.this));

    }
    public void armazenadorDeDadosDeArray(){
        Cursor cursor = Mydb.LerTodoBancotwo();

        if(cursor.getCount() == 0){

            Toast.makeText(this, "Sem nenhum dado", Toast.LENGTH_SHORT).show();

        }
        else
        {

            while(cursor.moveToNext()){

                Colunaid.add(cursor.getString(0));
                Colunaproduto.add(cursor.getString(1));
                Colunapreco.add(cursor.getString(3));

            }

        }

    }
}