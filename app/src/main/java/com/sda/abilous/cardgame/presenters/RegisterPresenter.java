package com.sda.abilous.cardgame.presenters;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterPresenter {

    private FirebaseAuth firebaseAuth;

    public RegisterPresenter() {
    }

    public void registerUser(final Activity activity, String email, String password){

        firebaseAuth = FirebaseAuth.getInstance();

        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(activity, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(activity, "Stworzone", Toast.LENGTH_SHORT).show();

                        }else {
                            Toast.makeText(activity, "Nie stworzone", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}
