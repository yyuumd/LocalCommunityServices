package c.group24.localcommunityservices;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Welcome extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        Button login = findViewById(R.id.Login_button);
        Button register = findViewById(R.id.Register_button);
        ImageView welcome_img = findViewById(R.id.imageView3);
        welcome_img.setVisibility(View.VISIBLE);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startLogin();
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go_register = new Intent(Welcome.this, Register.class);
                startActivity(go_register);
            }
        });
    }
    private void startLogin() {

        Intent go_login = new Intent(Welcome.this,Login.class);
        startActivity(go_login);

    }

}
