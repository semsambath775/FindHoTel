package com.example.findhotel;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import com.example.findhotel.adapter.HotelListAdapter;
import com.example.findhotel.database.DBHelper;
import com.example.findhotel.model.Hotel;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class ResultSearchActivity extends AppCompatActivity {
    GridView gv_display;
    ArrayList<Hotel> list;
    HotelListAdapter adapter = null;
//    DBHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_search);

        gv_display = findViewById(R.id.gv_hotel);
        list = new ArrayList<>();
        adapter = new HotelListAdapter(this, R.layout.hotel_items, list);
        gv_display.setAdapter(adapter);

        // Get all data from sqlite
        Cursor cursor = CrudActivity.dbHelper.getData("SELECT * FROM Hotel");
        list.clear();
        while(cursor.moveToFirst()) {
            int maSo = cursor.getInt(0);
            String tenKhachSan = cursor.getString(1);
            String diaChi = cursor.getString(2);
            String giaTien = cursor.getString(3);
            byte[] hinh = cursor.getBlob(4);
//          imagemTratada(hinh);
            list.add(new Hotel(maSo, tenKhachSan, diaChi, giaTien, hinh));
        }
        adapter.notifyDataSetChanged();
//        ArrayList<Hotel> list_hotel;
//        ArrayList<String>list_string = new ArrayList<>();
//        list_hotel = dbHelper.getAllHotel();
//        for (Hotel ht:list_hotel) {
//            list_string.add(ht.getMaSo() + "");
//            list_string.add(ht.getTenKachSan());
//            list_string.add(ht.getDiaChi());
//            list_string.add(ht.getGiaTien() + "");
//        }
//        ArrayAdapter adapter = new ArrayAdapter<>(ResultSearchActivity.this, android.R.layout.simple_list_item_1, list_string);
//        gv_display.setAdapter(adapter);
    }

//    private byte[] imagemTratada(byte[] imagem_img){
//
//        while (imagem_img.length > 500000000){
//            Bitmap bitmap = BitmapFactory.decodeByteArray(imagem_img, 0, imagem_img.length);
//            Bitmap resized = Bitmap.createScaledBitmap(bitmap, (int)(bitmap.getWidth()*0.8), (int)(bitmap.getHeight()*0.8), true);
//            ByteArrayOutputStream stream = new ByteArrayOutputStream();
//            resized.compress(Bitmap.CompressFormat.PNG, 100, stream);
//            imagem_img = stream.toByteArray();
//        }
//        return imagem_img;
//
//    }
}