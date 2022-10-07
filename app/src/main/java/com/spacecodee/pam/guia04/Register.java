package com.spacecodee.pam.guia04;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import com.spacecodee.pam.guia04.dto.Person;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Register extends AppCompatActivity {

    private Button btnBack;
    private Button btnRegister;
    private EditText txtName;
    private EditText txtSurname;
    private final List<Person> personList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        this.btnBack = findViewById(R.id.btnBack);
        this.btnRegister = findViewById(R.id.btnRegister);
        this.txtName = findViewById(R.id.txtName);
        this.txtSurname = findViewById(R.id.txtSurname);
    }

    public void register(View view) {
        if (view == this.btnRegister) {
            String name = this.txtName.getText().toString().trim();
            String surname = this.txtSurname.getText().toString().trim();
            Person person = new Person(name, surname);
            this.personList.add(person);

            this.txtName.setText("");
            this.txtSurname.setText("");
            this.txtName.requestFocus();
        }
    }

    public void back(View view) {
        if (view == this.btnBack) {
            Intent mainView = new Intent(this.getBaseContext(), MainActivity.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable("personList", (Serializable) this.personList);
            mainView.putExtras(bundle);
            this.startActivity(mainView);
        }
    }
}