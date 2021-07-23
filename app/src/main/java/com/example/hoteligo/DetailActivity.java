package com.example.hoteligo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DetailActivity extends AppCompatActivity {

    public static final String TAG = "Database";

    public String title;
    private TextView t1, t2, t3, t4;
    Button submit;
    DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Bundle bundle = getIntent().getExtras();
        title = bundle.getString("key");

        Toast.makeText(this, title, Toast.LENGTH_SHORT).show();


        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference Ref = database.getReference("cities");
        myRef = Ref.child("delhi").child(title); //cities - delhi -> primary key (in our case title)

        t1 = findViewById(R.id.name);
        t2 = findViewById(R.id.address);
        t3 = findViewById(R.id.detail);
        t4 = findViewById(R.id.price);

        submit = findViewById(R.id.btn_confirm);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DetailActivity.this, "Your booking as been confirmed", Toast.LENGTH_SHORT).show();
            }
        });

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Detail temp = snapshot.getValue(Detail.class);

                t1.setText(temp.title);
                t2.setText(temp.address);
                t3.setText(temp.description);
                t4.setText(temp.price);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                //Failed to read value
                Log.w(TAG, "Failed to read value", error.toException());
                Toast.makeText(DetailActivity.this, "Failed to load post", Toast.LENGTH_SHORT).show();
            }
        });
    }
}