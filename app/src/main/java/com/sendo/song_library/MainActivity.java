package com.sendo.song_library;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvMusicTitle, tvMusicMaker;
    EditText etMusicTitle, etMusicMaker;
    Button btnSave, btnLoad;

    MusicsDB musicsDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        musicsDB = new MusicsDB(this);

        etMusicMaker = findViewById(R.id.et_music_maker);
        etMusicTitle = findViewById(R.id.et_music_title);
        tvMusicTitle = findViewById(R.id.tv_music_title);
        tvMusicMaker = findViewById(R.id.tv_music_maker);
        btnSave = findViewById(R.id.btn_save);
        btnLoad = findViewById(R.id.btn_load);

    }

    public void saveMusic(View view) {
        if (validateBtnSave()) {
            Music music = new Music(
                    etMusicTitle.getText().toString(),
                    etMusicMaker.getText().toString()
            );
            musicsDB.insertMusic(music);
        }
        etMusicTitle.setText("");
        etMusicMaker.setText("");
    }

    public void loadMusic(View view) {
        Music music = musicsDB.getMusicByTitle(etMusicTitle.getText().toString());
        tvMusicTitle.setText(music.getMusicTitle());
        tvMusicMaker.setText(music.getMusicMaker());
        etMusicTitle.setText("");
        etMusicMaker.setText("");
    }

    private boolean validateBtnSave() {
        if (etMusicTitle.getText().toString().isEmpty()
                || etMusicMaker.getText().toString().isEmpty()) {
            etMusicTitle.setError("Title must be filled");
            etMusicMaker.setError("Maker must be filled");
            return false;
        }
        return true;
    }
}