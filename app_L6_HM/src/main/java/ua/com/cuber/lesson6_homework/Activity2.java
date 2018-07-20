package ua.com.cuber.lesson6_homework;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        Intent intent = getIntent();
        Student activity2Student = intent.getParcelableExtra("Student");
        String p1 = activity2Student.FirstName;
        String p2 = activity2Student.LastName;
        int p3 = activity2Student.Age;
        TextView textViewFirstName = findViewById(R.id.textViewFirstName);
        TextView textViewLastName = findViewById(R.id.textViewLastName);
        TextView textViewAge = findViewById(R.id.textViewAge);

        textViewFirstName.setText(p1);
        textViewLastName.setText(p2);
        textViewAge.setText(String.valueOf(p3));
    }
}
