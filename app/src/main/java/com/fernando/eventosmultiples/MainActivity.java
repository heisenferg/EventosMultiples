package com.fernando.eventosmultiples;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements ListView.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //Array de elementos
        String [] elementos = {"Toledo", "Ciudad Real", "Cuenca", "Guadalajara", "Albacete"};

        // Adaptador de texto (String)
        ArrayAdapter<String> adaptador;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Lista de referencia
        ListView l = findViewById(R.id.listViewProvincias);
        l.setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE);
        //Crear adaptador
        adaptador= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, elementos );

        //Pasamos adaptador a la lista
        l.setAdapter(adaptador);
        l.setOnItemClickListener(this);

    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        TextView t = (TextView) findViewById(R.id.textView);
        ListView l = (ListView) findViewById(R.id.listViewProvincias);
        String seleccionado = new String();
        SparseBooleanArray checked = l.getCheckedItemPositions();

        for (int i=0; i<checked.size(); i++){
            if (checked.valueAt(i)){
                seleccionado = seleccionado+ parent.getItemAtPosition(checked.keyAt(i)).toString()+";";
            }
            t.setText(seleccionado);
        }
    }


}