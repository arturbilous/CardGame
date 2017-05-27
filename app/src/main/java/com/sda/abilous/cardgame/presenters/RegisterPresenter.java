package com.sda.abilous.cardgame.presenters;

import android.app.Activity;
import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.sda.abilous.cardgame.Utils;

public class RegisterPresenter {

    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;


    public RegisterPresenter() {
    }

    public void registerUser(final Activity activity, String email, String password) {

        firebaseAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(activity);

        if (TextUtils.isEmpty(email)) {
            Utils.showToast(activity, "Wprowadz poprawny e-mail dziwko");
            return;
        } else if (!Utils.isEmailValid(email)) {
            Utils.showToast(activity, "Wpisz poprawny");
            return;
        }

        if (TextUtils.isEmpty(password)) {
            Utils.showToast(activity, "Wprowadz hasło dziwko");
            return;
        } else if (!Utils.isPasswordValid(password)) {
            Utils.showToast(activity, "HASLOOO!!!");
            return;
        }

        if (!Utils.checkInternetConnection(activity)){
            Utils.showToast(activity, "brak neta ziom");
        }

        progressDialog.setMessage("Rejestracja");
        progressDialog.show();

        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(activity, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(activity, "Stworzone", Toast.LENGTH_SHORT).show();

                        } else {
                            Toast.makeText(activity, "Nie stworzone", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}
