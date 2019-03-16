package com.example.francisco.loginmvp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.francisco.loginmvp.Model.LoginInteractorImpl;
import com.example.francisco.loginmvp.Presenter.LoginPresenter;
import com.example.francisco.loginmvp.Presenter.LoginPresenterImpl;
import com.example.francisco.loginmvp.View.LoginView;

public class LoginActivity extends Activity implements LoginView, View.OnClickListener {

    ProgressBar progressBar;
    EditText usuario, passw;
    LoginPresenter loginPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        progressBar = (ProgressBar)findViewById(R.id.progressBar);
        usuario = (EditText)findViewById(R.id.txt_username);
        passw = (EditText)findViewById(R.id.txt_password);

        findViewById(R.id.btn_ingresar).setOnClickListener(this);
        progressBar.setVisibility(View.GONE);

        loginPresenter = new LoginPresenterImpl(this,new LoginInteractorImpl());

    }


    @Override
    protected void onDestroy() {
        loginPresenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void onClick(View view) {

        loginPresenter.validateCredentials(usuario.getText().toString(),passw.getText().toString());

            }

    @Override
    public void showProgress() {

        progressBar.setVisibility(View.VISIBLE);

    }

    @Override
    public void hideProgress() {

        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void setUsernameError() {

        usuario.setError("Error de usuario");

    }

    @Override
    public void setPasswordError() {

        passw.setError("Error de password");

    }

    @Override
    public void navigateToHome() {

        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);

        Toast.makeText(this, "Ingreso Correcto", Toast.LENGTH_SHORT).show();

    }
}
