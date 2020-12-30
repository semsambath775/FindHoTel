package com.example.findhotel;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.findhotel.database.DBHelper;
import com.example.findhotel.model.Hotel;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class CrudActivity extends AppCompatActivity {
    Button btnLuu, btnThoat;
    EditText editMaSo, editTen, editDiaChi, editGia;
    ImageButton btnChonAnh;
    GridView gv_display;
    ImageView imgHinh;

    public static DBHelper dbHelper;

    int REQUEST_CODE_GALLERY = 123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crud);

        //editMaSo = findViewById(R.id.edit_MaSo);
        editTen = findViewById(R.id.edit_NhapTenKachSan);
        editDiaChi = findViewById(R.id.edit_NhapDiaChi);
        editGia = findViewById(R.id.edit_NhapGia);
        imgHinh = findViewById(R.id.image_Hinh);
        gv_display = findViewById(R.id.gv_hotel);

        dbHelper = new DBHelper(this, "Hotel.sqlite", null, 1);

        dbHelper.queryData("CREATE TABLE IF NOT EXISTS Hotel (Id INTEGER PRIMARY KEY AUTOINCREMENT, ten VARCHAR(50), diachi VARCHAR(50), gia INTEGER, hinh BLOB)");


        btnChonAnh = findViewById(R.id.imgBtn_Camera);
        btnChonAnh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//                startActivityForResult(intent, REQUEST_CODE_GALLERY);
                ActivityCompat.requestPermissions(
                        CrudActivity.this,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        REQUEST_CODE_GALLERY
                );
            }
        });

        btnLuu = findViewById(R.id.btn_Luu);
        btnLuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Hotel ht = new Hotel();
//                ht.setMaSo(Integer.parseInt(editMaSo.getText().toString()));
//                ht.setTenKachSan(editTen.getText().toString());
//                ht.setDiaChi(editDiaChi.getText().toString());
//                ht.setGiaTien(Integer.parseInt(editGia.getText().toString()));
//                if(dbHelper.insertHotel(ht) > 0) {
//                    Toast.makeText(getApplication(), "Đã lưu thành công", Toast.LENGTH_SHORT).show();
//                } else {
//                    Toast.makeText(getApplication(), "Lưu không thành công", Toast.LENGTH_SHORT).show();
//                }
                try {
                    dbHelper.insertData(
//                            Integer.parseInt(editMaSo.getText().toString()),
                            editTen.getText().toString(),
                            editDiaChi.getText().toString(),
                            editGia.getText().toString(),
                            imageViewToByte(imgHinh)
                    );
                    Toast.makeText(getApplicationContext(), "Thêm thành công", Toast.LENGTH_SHORT).show();
                    imgHinh.setImageResource(R.mipmap.ic_launcher);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        btnThoat = findViewById(R.id.btn_Thoat);
        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private byte[] imageViewToByte(ImageView image) {
        Bitmap bitmap = ((BitmapDrawable) image.getDrawable()).getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 50, stream);
        byte[] imgByte = stream.toByteArray();
        return imgByte;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == REQUEST_CODE_GALLERY) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent, REQUEST_CODE_GALLERY);
            } else {
                Toast.makeText(getApplicationContext(), "You don' have permission to access file location!", Toast.LENGTH_SHORT).show();
            }
            return;
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == REQUEST_CODE_GALLERY && resultCode == RESULT_OK && data != null) {
//            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
//            imgHinh.setImageBitmap(bitmap);
            Uri uri = data.getData();

            try {
                InputStream inputStream = getContentResolver().openInputStream(uri);

                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                imgHinh.setImageBitmap(bitmap);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}