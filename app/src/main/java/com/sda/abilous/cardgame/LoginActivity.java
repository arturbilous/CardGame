package com.sda.abilous.cardgame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import com.sda.abilous.cardgame.presenters.LoginPresenter;
import com.sda.abilous.cardgame.presenters.RegisterPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.email_signin)
    EditText etEmailSI;

    @BindView(R.id.pass_signin)
    EditText etPasswordSI;

    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        if (loginPresenter == null){
            loginPresenter = new LoginPresenter();
        }
    }

    @OnClick(R.id.logbutton_signin)
    public void loginUser(){
        String email = etEmailSI.getText().toString().toLowerCase().trim();
        String password = etPasswordSI.getText().toString().toLowerCase().trim();
        loginPresenter.loginUser(this, email, password);
    }

    @OnClick(R.id.login)
    public void inLoginUser() {
        finish();
        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
    }
}
