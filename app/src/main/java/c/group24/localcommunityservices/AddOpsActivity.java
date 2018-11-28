package group24.localcommunityservice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddOpsActivity extends AppCompatActivity {

    public final static String TITLE = "title";
    public final static String LOCATION = "location";
    public final static String DESCRIPTION = "description";
    public final static String REQUIREMENTS = "requirements";

    private EditText mTitleText;
    private EditText mLocationText;
    private EditText mDescriptionText;
    private EditText mRequirementsText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_ops);

        findViewById(R.id.opsTitleLabel);
        findViewById(R.id.opsLocationLabel);
        findViewById(R.id.opsDescriptionLabel);
        findViewById(R.id.opsRequirementsLabel);
        mTitleText = findViewById(R.id.opsTitle);
        mLocationText = findViewById(R.id.opsLocation);
        mDescriptionText = findViewById(R.id.opsDescription);
        mRequirementsText = findViewById(R.id.opsRequirements);

        final Button createButton = findViewById(R.id.createButton);
        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra(TITLE, mTitleText.getText().toString());
                intent.putExtra(LOCATION, mLocationText.getText().toString());
                intent.putExtra(DESCRIPTION, mDescriptionText.getText().toString());
                intent.putExtra(REQUIREMENTS, mRequirementsText.getText().toString());
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        final Button clearButton = findViewById(R.id.clearButton);
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTitleText.setText("");
                mLocationText.setText("");
                mDescriptionText.setText("");
                mRequirementsText.setText("");
            }
        });

        final Button cancelButton = findViewById(R.id.cancelButton);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });
    }

}
