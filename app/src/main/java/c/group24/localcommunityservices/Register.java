package c.group24.localcommunityservices;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;


public class Register extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_process);
        Button goLogin = findViewById(R.id.login);
       final Button register = findViewById(R.id.register);
        final EditText name = (EditText)findViewById(R.id.regname);
        final EditText email = (EditText)findViewById(R.id.regEmail);
        final EditText pass = (EditText)findViewById(R.id.regPass);

        goLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goLog = new Intent(Register.this,Login.class);
                startActivity(goLog);
            }
        });
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.studentOrg);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            String pickedIdentity;
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                RadioButton checkedRadioButton = (RadioButton) findViewById(checkedId);
                String text = checkedRadioButton.getText().toString();
                pickedIdentity = text;
                Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
                register.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        final ProgressDialog progressDialog = ProgressDialog.show(Register.this, "Please wait...", "Processing...", true);
                        (FirebaseAuth.getInstance().createUserWithEmailAndPassword(email.getText().toString(), pass.getText().toString()))
                                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                    @Override
                                    public void onComplete(@NonNull Task<AuthResult> task) {
                                        progressDialog.dismiss();

                                        if (task.isSuccessful()&& !name.getText().toString().contains(":")) {
                                            Toast.makeText(Register.this, "Registration successful", Toast.LENGTH_LONG).show();
                                            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                                            UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder().setDisplayName(pickedIdentity + ":"+ name.getText().toString()).build();
                                            user.updateProfile(profileUpdates);
                                            final FirebaseUser currUser = FirebaseAuth.getInstance().getCurrentUser();
                                            user.sendEmailVerification();
                                            Intent i = new Intent(Register.this, EmailVerificatiion.class);
                                            startActivityForResult(i,0);


                                        }
                                        else
                                        {
                                            Log.e("ERROR", task.getException().toString());
                                            Toast.makeText(Register.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                                        }
                                    }
                                });
                    }
                });
            }

        });





    }
}
