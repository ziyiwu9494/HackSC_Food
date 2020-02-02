package com.example.hacksc_food;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.FirebaseDatabase;

public class CreateAccount extends AppCompatActivity implements View.OnClickListener {
    // [START declare_auth]
    private FirebaseAuth mAuth;
    // [END declare_auth]
    private EditText mEmailField;
    private EditText mPasswordField;
    private EditText mNameField;
    private static final String TAG = "EmailPassword";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        mEmailField = findViewById(R.id.input_email);
        mPasswordField = findViewById(R.id.input_password);
        mNameField = findViewById(R.id.input_name);
        findViewById(R.id.btn_signup).setOnClickListener(this);
        findViewById(R.id.link_login).setOnClickListener(this);
        mAuth = FirebaseAuth.getInstance();
    }
    private void createAccount(final String name, String email, String password) {
        Log.d(TAG, "createAccount:" + email);
        if (!validateForm()) {
            return;
        }
        // [START create_user_with_email]
        mAuth.createUserWithEmailAndPassword( email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                                    .setDisplayName(name).build();
                            user.updateProfile(profileUpdates);
                            Toast.makeText(CreateAccount.this, "Account Created!", Toast.LENGTH_SHORT).show();
                            finish();
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(CreateAccount.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();;
                        }
                    }
                });
        // [END create_user_with_email]

    }
    private boolean validateForm() {
        boolean valid = true;

        String email = mEmailField.getText().toString();
        if (TextUtils.isEmpty(email)) {
            mEmailField.setError("Required.");
            valid = false;
        } else {
            mEmailField.setError(null);
        }

        String password = mPasswordField.getText().toString();
        if (TextUtils.isEmpty(password)) {
            mPasswordField.setError("Required.");
            valid = false;
        } else {
            mPasswordField.setError(null);
        }

        String name = mNameField.getText().toString();
        if(TextUtils.isEmpty((name))) {
            mNameField.setError("Required.");
            valid = false;
        } else {
            mNameField.setError(null);
        }
        Log.println(0, "validity", Boolean.valueOf(valid).toString());
        return valid;
    }
    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.btn_signup) {
            Log.println(0,"signup", "sign up clicked");
            createAccount(mNameField.getText().toString(), mEmailField.getText().toString(), mPasswordField.getText().toString());
        }
        if (i == R.id.link_login) {
            finish();
        }
    }
}
