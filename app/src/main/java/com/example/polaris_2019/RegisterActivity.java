package com.example.polaris_2019;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/*
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
*/

/**
 * A login screen that offers login via email/password.
 */
public class RegisterActivity extends AppCompatActivity {

    private EditText nameField;
    private EditText emailField;
    private EditText passField;

    private Toolbar mToolbar;

    String mDisplayName;
    String mEmail;
    String mPass;

    //private FirebaseAuth mAuth;

    private Button RegisterButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //mAuth = FirebaseAuth.getInstance();

        nameField = findViewById(R.id.RegDisplayNameField);
        emailField = findViewById(R.id.RegEmailField);
        passField = findViewById(R.id.RegPassField);

        mToolbar = (Toolbar) findViewById(R.id.registertoolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("Register Account");
        mToolbar.setNavigationIcon(R.drawable.baseline_arrow_back_black_18dp);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        RegisterButton = findViewById(R.id.RegisterButton);
        RegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDisplayName = nameField.getText().toString();
                mEmail = emailField.getText().toString();
                mPass = passField.getText().toString();

                Toast.makeText(RegisterActivity.this, mDisplayName + " " + mEmail
                        + " " + mPass, Toast.LENGTH_LONG).show();
                /*
                if(mPass.equals("") | mDisplayName.equals("") | mEmail.equals("")){
                    Toast.makeText(RegisterActivity.this, "Please fill out all fields.",
                            Toast.LENGTH_LONG).show();
                }else{
                    FirebaseFirestore db = FirebaseFirestore.getInstance();
                    DocumentReference docIdRef = db.collection("employees").document(mEmail);
                    docIdRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                            if (task.isSuccessful()) {
                                DocumentSnapshot document = task.getResult();
                                if (document.exists()) {
                                    Toast.makeText(RegisterActivity.this, "Registering your account...",
                                            Toast.LENGTH_SHORT).show();
                                    createAcc(mDisplayName,mEmail,mPass);
                                    try {
                                        Thread.sleep(1000);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                    Toast.makeText(RegisterActivity.this, "Registered! Returning to login...",
                                            Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                                    intent.putExtra("from","register");
                                    try {
                                        Thread.sleep(1000);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                    startActivity(intent);
                                    finish();
                                } else {
                                    Toast.makeText(RegisterActivity.this, "Error: your email is not in the database. Check the email address provided for typos.",
                                            Toast.LENGTH_LONG).show();
                                }
                            } else {
                                Log.d("", "Failed with: ", task.getException());
                            }
                        }
                    });

                }*/
            }
        });

    }

    /*
    private void createAcc(final String mDisplayName, String mEmail, String mPass) {
        mAuth.createUserWithEmailAndPassword(mEmail, mPass).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    // Sign in success
                    FirebaseUser user = mAuth.getCurrentUser();

                    UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                            .setDisplayName(mDisplayName).build();

                    user.updateProfile(profileUpdates);

                }
            }

        });
    }
    */
}

