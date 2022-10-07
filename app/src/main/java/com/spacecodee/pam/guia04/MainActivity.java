package com.spacecodee.pam.guia04;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.spacecodee.pam.guia04.dto.Person;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private List<String> listOp;
    private ArrayAdapter<String> adapter;
    private ListView lstOptions;
    private List<Person> personList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.lstOptions = findViewById(R.id.lstOptions);
        this.lstOptions.setOnItemClickListener(this);

        this.load();
        this.adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, this.listOp);
        this.lstOptions.setAdapter(this.adapter);

        this.getDataFromRegister();
    }

    public void load() {
        this.listOp = new ArrayList<>();
        String op1 = "Registrar";
        String op2 = "Listar";
        this.listOp.add(op1);
        this.listOp.add(op2);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        switch (i) {
            case 0:
                Intent registerView = new Intent(this, Register.class);
                //Start
                this.startActivity(registerView);
                break;
            case 1:
                Intent listItems = new Intent(this, ListItems.class);
                this.setPersonListToNewActivity(listItems);
                this.startActivity(listItems);
                break;
            default:
                Toast.makeText(this, "Opción no válida", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    private void setPersonListToNewActivity(Intent intent) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("personList", (Serializable) this.personList);
        intent.putExtras(bundle);
    }

    private void getDataFromRegister() {
        //Get data
        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();
        if (bundle != null) {
            this.personList = (List<Person>) bundle.getSerializable("personList");
        }
        else {
            this.personList = new ArrayList<>();
        }
    }
}