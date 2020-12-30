package com.example.findhotel.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.example.findhotel.model.Hotel;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public void queryData(String sql) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(sql);
    }

    public void insertData(String ten, String diachi, String gia, byte[] image ) {
        SQLiteDatabase db = getWritableDatabase();
        String sql = "INSERT INTO Hotel VALUES(null, ?, ?, ?, ?)";

        SQLiteStatement statement = db.compileStatement(sql);
        statement.clearBindings();

        statement.bindString(1, ten);
        statement.bindString(2, diachi);
        statement.bindString(3, gia);
        statement.bindBlob(4, image);

        statement.executeInsert();
    }


    public Cursor getData(String sql) {
        SQLiteDatabase db = getReadableDatabase();
        return db.rawQuery(sql, null);
    }

//    @Override
//    public void onCreate(SQLiteDatabase db) {
//        db.execSQL("CREATE TABLE Hotel(" + "maso integer primary key, " + "ten text," + "diachi," + "gia integer," + "hinh blob)");
//    }
//
//    @Override
//    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        db.execSQL("DROP TABLE IF EXISTS Hotel");
//        onCreate(db);
//    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Hotel");
        onCreate(db);
    }

    // Truy vấn thêm - xóa - sửa khách sạn
    public int insertHotel(Hotel ht) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("maso", ht.getMaSo());
        contentValues.put("ten", ht.getTenKachSan());
        contentValues.put("diachi", ht.getDiaChi());
        contentValues.put("gia", ht.getGiaTien());
        int result = (int) db.insert("Hotel", null, contentValues);
        db.close();
        return result;
    }

    // Tìm tất cả khách sạn
    public ArrayList<Hotel> getAllHotel() {
        ArrayList<Hotel> list = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from Hotel", null);
        if (cursor != null) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                list.add(new Hotel(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getBlob(4)));
                cursor.moveToNext();
            }
        }
        cursor.close();
        db.close();
        return list;
    }

    public ArrayList<Hotel> getHotel(int maso) {
        ArrayList<Hotel> list = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from Hotel where maso=" + maso, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        Hotel ht = new Hotel();
        list.add(ht);
        cursor.close();
        db.close();
        return list;
    }



}
