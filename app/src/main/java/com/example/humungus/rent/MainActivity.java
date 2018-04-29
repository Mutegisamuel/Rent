package com.example.humungus.rent;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;

import com.xw.repo.BubbleSeekBar;

public class MainActivity extends AppCompatActivity {

    BubbleSeekBar mBubbleSeekBar;
    FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBubbleSeekBar = findViewById(R.id.bubbleseekbar);
        floatingActionButton = findViewById(R.id.to_Plist_activity);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ListProductsActivity.class);
                startActivity(intent);
            }
        });

//setting up the seekbar
        mBubbleSeekBar.setCustomSectionTextArray(new BubbleSeekBar.CustomSectionTextArray() {
            @NonNull
            @Override
            public SparseArray<String> onCustomize(int sectionCount, @NonNull SparseArray<String> array) {

                array.clear();
                array.put(0, "10k");
                array.put(1, "20k");
                array.put(2, "50k");
                array.put(3, "80k");
                array.put(4, "100k");
                array.put(5, "101k");

                return array;
            }
        });


        initHorizantalRecyclerview();

    }

    private void initHorizantalRecyclerview(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,true);
        RecyclerView recyclerView = findViewById(R.id.latestView);
        recyclerView.setLayoutManager(linearLayoutManager);
        HomeDetailsAdapter adapter = new HomeDetailsAdapter();
        recyclerView.setAdapter(adapter);

    }
}
