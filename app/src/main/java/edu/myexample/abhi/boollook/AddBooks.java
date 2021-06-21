package edu.myexample.abhi.boollook;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class AddBooks extends AppCompatActivity {
    Button btn;
    EditText mname , mauthor , mdepart;
    private FirebaseDatabase db = FirebaseDatabase.getInstance();
    private DatabaseReference root = db.getReference().child("Book");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_books);
        mname = findViewById(R.id.name1);
        mauthor = findViewById(R.id.author);
        mdepart = findViewById(R.id.dep);
        btn= findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String namebook = mname.getText().toString();
                String author = mauthor.getText().toString();
                String depart = mdepart.getText().toString();

                HashMap<String , String> usermap = new HashMap<>();
                usermap.put("Author",author);
                usermap.put("Department",depart);
                usermap.put("Name",namebook);
                root.child(namebook).setValue(usermap);
                Toast.makeText(AddBooks.this, "ADDED SUCCESSFULLY", Toast.LENGTH_SHORT).show();
            }
        });

    }
}