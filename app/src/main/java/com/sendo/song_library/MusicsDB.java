package com.sendo.song_library;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class MusicsDB {

    DBHelper dbHelper;

    public MusicsDB(Context context) {
        this.dbHelper = new DBHelper(context);
    }

    public void insertMusic(Music music) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(
                DBHelper.FIELD_MUSICS_TITLE,
                music.getMusicTitle()
        );
        contentValues.put(
                DBHelper.FIELD_MUSICS_MAKER,
                music.getMusicMaker()
        );
        db.insert(DBHelper.TABLE_MUSICS, null, contentValues);
        db.close();
    }

    public Music getMusicByTitle(String title) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selection= "title=?";
        String[] selectionArgs= {title};
        Cursor cursor = db.query(DBHelper.TABLE_MUSICS,
                null,
                selection,
                selectionArgs,
                null,
                null,
                null
        );

        Music music = new Music();

        if (cursor.moveToFirst()) {
            // read data
            music.setMusicTitle(
                    cursor.getString(
                            cursor.getColumnIndex(DBHelper.FIELD_MUSICS_TITLE)
                    )
            );
            music.setMusicMaker(
                    cursor.getString(
                            cursor.getColumnIndex(DBHelper.FIELD_MUSICS_MAKER)
                    )
            );
        }

        return music;
    }

}
