package com.sendo.song_library;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "MusicsDB";
    private static final int DB_VERSION = 1;

    public static final String TABLE_MUSICS = "Musics";
    public static final String FIELD_MUSICS_ID = "id";
    public static final String FIELD_MUSICS_TITLE = "title";
    public static final String FIELD_MUSICS_MAKER = "maker";

    private static final String CREATE_TABLE_MUSICS =
            "CREATE TABLE IF NOT EXISTS " + TABLE_MUSICS + " (" +
                    FIELD_MUSICS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    FIELD_MUSICS_TITLE + " TEXT UNIQUE," +
                    FIELD_MUSICS_MAKER + " TEXT)";

    private static final String DROP_TABLE_MUSICS =
            "DROP TABLE IF EXISTS " + TABLE_MUSICS;

    public DBHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE_MUSICS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(DROP_TABLE_MUSICS);
        onCreate(sqLiteDatabase);
    }
}
