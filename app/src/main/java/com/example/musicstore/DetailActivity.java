package com.example.musicstore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    TextView title;
    TextView subtitle;
    ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        title = findViewById(R.id.textView1Detail);
        subtitle=findViewById(R.id.textView2Detail);
        image=findViewById(R.id.img_instrumentDetail);

        Intent intent = getIntent();

        title.setText(intent.getStringExtra("title"));
        subtitle.setText(intent.getStringExtra("subtitle"));
        image.setImageResource(intent.getIntExtra("image",0));
    }
}
