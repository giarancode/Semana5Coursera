package com.example.semana3.interfaces;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.semana3.R;

public class Contacto extends AppCompatActivity {
    EditText etNombre, etEmail,etAsunto,etMensaje;
    Button btnBotonEnviarMensaje;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        btnBotonEnviarMensaje = findViewById(R.id.btnBotonEnviarMensaje);
        Toolbar toolbar2 = findViewById(R.id.toolbar2);
        etNombre = findViewById(R.id.etNombre);
        etEmail = findViewById(R.id.etEmail);
        etAsunto = findViewById(R.id.etAsunto);
        etMensaje = findViewById(R.id.etMensaje);
        btnBotonEnviarMensaje = findViewById(R.id.btnBotonEnviarMensaje);

        setSupportActionBar(toolbar2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        btnBotonEnviarMensaje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                senEmail();
                Toast.makeText(getBaseContext(),"Correo Enviado!",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void senEmail() {
        String mEmail = etEmail.getText().toString();
        String mAsunto= etAsunto.getText().toString();
        String mMensaje = etMensaje.getText().toString();

        ContactoJavaMail contactoJavaMail = new ContactoJavaMail(this, mEmail , mAsunto, mMensaje);
        contactoJavaMail.execute();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_interface2, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.puntos_3) {
            Toast.makeText(getBaseContext(),"Estas en Contactos", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}