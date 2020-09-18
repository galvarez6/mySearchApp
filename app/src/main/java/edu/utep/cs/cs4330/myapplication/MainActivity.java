package edu.utep.cs.cs4330.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText searchField;
    private Button imgs, vids, news, alls;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        searchField = findViewById(R.id.searcher);
        /*imgs = findViewById(R.id.imageSearcher);
        vids = findViewById(R.id.videoSearcher);
        news = findViewById(R.id.newsSearcher);
        alls = findViewById(R.id.allSearcher);*/
        registerClickListener(R.id.imageSearcher, SearchUp.SearchType.IMAGE);
        registerClickListener(R.id.videoSearcher, SearchUp.SearchType.VIDEO);
        registerClickListener(R.id.newsSearcher, SearchUp.SearchType.NEWS);
        registerClickListener(R.id.allSearcher, SearchUp.SearchType.ALL);
    }

    private void registerClickListener(int rid, SearchUp.SearchType type){
        Button button = findViewById(rid);
        button.setOnClickListener(v -> clicked(type));
    }

    private void clicked(SearchUp.SearchType type){
        String text = searchField.getText().toString();
        Intent intent = new Intent(this,SearchUp.class);
        intent.putExtra("text", text);
        intent.putExtra("type", type.ordinal());
        startActivity(intent);
    }


}