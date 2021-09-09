package com.example.ejemplo1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{

    String outputInfo;
    EditText etName, etAddress, etEmail, etPhone;
    TextView tvList, tvMsj;
    int i = 0;
    int count = 0;
    //String names [] = {"a", "b", "c", "d", "a", "b", "c", "d"};
    String names[] = new String[10];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etName = findViewById(R.id.etName);
        etAddress = findViewById(R.id.etAddress);
        etEmail = findViewById(R.id.etEmail);
        etPhone = findViewById(R.id.etPhone);
        tvList = findViewById(R.id.tvList);
        tvMsj = findViewById(R.id.tvMsj);
        etName.setText("");
        etAddress.setText("");
        etEmail.setText("");
        etPhone.setText("");
        tvMsj.setText("No hay datos que mostrar \n");
    }

    public void onSave(View view) {
        names[i] = etName.getText().toString();
        i++;
        Toast.makeText(getApplicationContext(), "Registros agregados al array", Toast.LENGTH_SHORT).show();
        cleanDates();
    }

    public void onCancel(View view) {
        count = 0;
        cleanDates();
        tvMsj.setText("Los datos están ocultos, clic en LIST repetidamente para mostrar los registros");
        Toast.makeText(getApplicationContext(), "Los campos han sido limpiados.", Toast.LENGTH_SHORT).show();
    }
    public void cleanDates(){
        etName.setText("");
        etAddress.setText("");
        etEmail.setText("");
        etPhone.setText("");
    }
    public void onList(View view) {
        tvMsj.setText("Los datos guardados son");
        if(count < i){
            Toast.makeText(getApplicationContext(), "Los campos están siendo Mostrados.", Toast.LENGTH_SHORT).show();
            tvList.setText(tvList.getText().toString() + " " +names[count]);
            count++;
        }
        else{
            Toast.makeText(getApplicationContext(), "No hay mas datos que mostrar, Reiniciando pantalla", Toast.LENGTH_SHORT).show();
            count = 0;
            tvList.setText("");
            tvMsj.setText("No hay datos que mostrar \n");
        }
    }
}