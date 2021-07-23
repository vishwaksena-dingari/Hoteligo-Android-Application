package com.example.hoteligo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class DelhiListActivity extends AppCompatActivity {

    ListView list;
    String hotels[] = {
            "Radisson Blu Hotel",
            "Vivanta By Taj",
            "Dynasty",
            "Raj Mahal",
            "Hotel Lalit",
            "Hotel MayFlower",
            "Hotel Millenium",
            "The Lily Hotel",
            "Greenwood Resort",
            "Hotel Contour",
            "Hotel Lilawait Grand",
            "Hotel Royal de casa"
    };

    Integer[] imageid = {
            R.drawable.food8,
            R.drawable.food1,
            R.drawable.food2,
            R.drawable.food3,
            R.drawable.food4,
            R.drawable.food5,
            R.drawable.food6,
            R.drawable.food7,
            R.drawable.food8,
            R.drawable.food1,
            R.drawable.food2,
            R.drawable.food3,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delhi_list);

        CustomList adapter = new CustomList(DelhiListActivity.this, hotels, imageid);

        list = findViewById(R.id.delhi_list_view);
        list.setAdapter(adapter);

    }
}