package com.sda.abilous.cardgame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import com.sda.abilous.cardgame.presenters.RegisterPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterActivity extends AppCompatActivity {

    @BindView(R.id.email)
    EditText etEmail;

    @BindView(R.id.pass)
    EditText etPassword;

    private RegisterPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        if (presenter == null){
            presenter = new RegisterPresenter();
        }
    }



    @OnClick(R.id.logbutton)
    public void createUser(){
        String email = etEmail.getText().toString().toLowerCase().trim();
        String password = etPassword.getText().toString().toLowerCase().trim();
        presenter.registerUser(this, email, password);
    }

    @OnClick(R.id.signin)
    public void signInUser() {
        finish();
        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
    }

}
