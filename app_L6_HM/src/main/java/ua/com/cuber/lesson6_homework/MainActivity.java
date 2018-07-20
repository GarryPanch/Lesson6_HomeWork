package ua.com.cuber.lesson6_homework;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Student mainStudent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainStudent = new Student();
        setContentView(R.layout.activity_main);
    }

    public void OnClick(View v){
        switch (v.getId()){
            case R.id.buttonView:
                Intent intent1 = new Intent(this, Activity2.class);
                intent1.putExtra("Student", mainStudent);
                startActivity(intent1);
                break;
            case R.id.buttonEdit:
                Intent intent2 = new Intent(this, Activity3.class);
                intent2.putExtra("Student", mainStudent);
                startActivityForResult(intent2,1);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK){
            if (requestCode == 1){
                mainStudent.FirstName = data.getStringExtra("FirstName");
                mainStudent.LastName = data.getStringExtra("LastName");
                String s1 = data.getStringExtra("Age");
                mainStudent.Age = Integer.valueOf(s1);

                TextView textViewFirstName = findViewById(R.id.textViewFirstName);
                TextView textViewLastName = findViewById(R.id.textViewLastName);
                TextView textViewAge = findViewById(R.id.textViewAge);

                textViewFirstName.setText(mainStudent.FirstName);
                textViewLastName.setText(mainStudent.LastName);
                textViewAge.setText(String.valueOf(mainStudent.Age));

            }
        }
    }
}
