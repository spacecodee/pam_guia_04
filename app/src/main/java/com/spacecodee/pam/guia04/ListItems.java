package com.spacecodee.pam.guia04;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import com.spacecodee.pam.guia04.dto.Person;

import java.util.List;

public class ListItems extends AppCompatActivity {
    private Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_items);
        this.btnBack = findViewById(R.id.btnBack2);
        EditText txtListPersons = findViewById(R.id.txtListPersons);

        //Get data
        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();
        if (bundle != null) {
            List<Person> personList = (List<Person>) bundle.getSerializable("personList");
            StringBuilder textLine = new StringBuilder();
            for (Person person : personList) {
                textLine.append(person.getName()).append(" ")
                        .append(person.getLastName()).append("\n");
            }
            txtListPersons.setText(textLine.toString());
        }
    }

    public void backToView(View view) {
        if (view == this.btnBack) {
            Intent mainView = new Intent(this.getBaseContext(), MainActivity.class);
            this.startActivity(mainView);
        }
    }
}