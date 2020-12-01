package com.juansosa.apppuppy;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class ContactoActivity extends AppCompatActivity {

    private EditText etContactoNombre;
    private EditText etContactoEmail;
    private EditText etContactoMensaje;

    private Button btnEnviarComentario;




    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        etContactoNombre    = (EditText) findViewById(R.id.etCotactoNombre);
        etContactoEmail     = (EditText) findViewById(R.id.etContactoEmail);
        etContactoMensaje   = (EditText) findViewById(R.id.etContactoMensaje);

        btnEnviarComentario = (Button) findViewById(R.id.btnEnviarComentario);


        btnEnviarComentario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMail();
            }
        });



    }

    private void sendMail(){

        String mail = etContactoEmail.getText().toString().trim();
        String mensaje = etContactoMensaje.getText().toString();
        String subject = etContactoNombre.getText().toString().trim();

        //Send mail

        JavaMailAPI javaMailAPI = new JavaMailAPI(this, mail,subject, mensaje);
        javaMailAPI.execute();


    }

}
