package edu.utep.cs.cs4330.myapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.widget.Button;
import android.widget.TextView;

public class SearchUp extends AppCompatActivity {

    public enum SearchType{
        ALL(""),
        IMAGE("isch"),
        BOOK("bks"),
        NEWS("nws"),
        VIDEO("vid");

        public final String tbm;

        SearchType(String tbm){
            this.tbm = tbm;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_up);


        String text = getIntent().getStringExtra("text");
        int ord = getIntent().getIntExtra("type", SearchType.ALL.ordinal());
        SearchType type = SearchType.values()[ord];
        TextView textView = findViewById(R.id.textView);
        textView.setText(Html.fromHtml("<b>Request</b><br/>Text:"+ text +"<br/>Type:" + type));


        Button proceedButton = findViewById(R.id.proceedButton);
        proceedButton.setOnClickListener(v -> {
            Intent i = new Intent(android.content.Intent.ACTION_VIEW,
                    Uri.parse("https://www.google.com/serch?tbm="+type.tbm+"&q="+ text));
            startActivity(i);
        });


    }
}