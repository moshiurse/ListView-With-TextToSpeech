package com.akaimma.listviewfirstwork;

import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    TextToSpeech textToSpeech;
    ListView listView;
    String etName[] = {"Moshiur", "Motiur", "Nahid", "Utpal", "Hasan", "Ashraf", "Babu", "Arif", "Borhan"};
    String etEmail[] = {"Moshiur@gmail.com", "Motiur@gmail.com", "Nahid@gmail.com", "Utpal@gmail.com", "Hasan@gmail.com",
            "Ashraf@gmail.com", "Babu@gmail.com", "Arif@gmail.com", "Borhan@gmail.com"};
    String etPhone[] = {"01828", "34567", "565562", "9845525", "3325966", "9845266", "86241", "32585", "852414"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.list_view);

        textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR){
                    textToSpeech.setLanguage(Locale.ENGLISH);
                }
            }
        });

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, etName);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String toSpeak = etName[position].toString();
                Toast.makeText(getApplicationContext(), toSpeak, Toast.LENGTH_SHORT).show();
                textToSpeech.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
                Intent i = new Intent(MainActivity.this, LastActivity.class);
                i.putExtra("name", etName[position]);
                i.putExtra("phone", etPhone[position]);
                i.putExtra("email", etEmail[position]);
                startActivity(i);
//                Toast.makeText(MainActivity.this, "Clicked At "+etName[position], Toast.LENGTH_SHORT).show();
            }
        });

    }


}
