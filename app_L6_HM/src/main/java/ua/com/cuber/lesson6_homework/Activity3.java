package ua.com.cuber.lesson6_homework;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Activity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        Intent intent = getIntent();
        Student activity2Student = intent.getParcelableExtra("Student");
        String p1 = activity2Student.FirstName;
        String p2 = activity2Student.LastName;
        int p3 = activity2Student.Age;
        EditText editTextViewFirstName = findViewById(R.id.editTextFirstName);
        EditText editTextLastName = findViewById(R.id.editTextLastName);
        EditText editTextAge = findViewById(R.id.editTextAge);

        editTextViewFirstName.setText(p1);
        editTextLastName.setText(p2);
        editTextAge.setText(String.valueOf(p3));


        findViewById(R.id.buttonSave).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("FirstName", ((EditText)findViewById(R.id.editTextFirstName)).getText().toString());
                intent.putExtra("LastName", ((EditText)findViewById(R.id.editTextLastName)).getText().toString());
                intent.putExtra("Age", ((EditText)findViewById(R.id.editTextAge)).getText().toString());
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
