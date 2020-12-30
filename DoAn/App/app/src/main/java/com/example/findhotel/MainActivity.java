package com.example.findhotel;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.findhotel.database.DBHelper;

public class MainActivity extends AppCompatActivity {
    public static DBHelper database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("TIÊU ĐỀ ACTIVITY"); //Thiết lập tiêu đề nếu muốn
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_login:
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                Toast.makeText(this, "Đã chọn đăng nhập", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item_crud:
                Intent intent2 = new Intent(MainActivity.this, CrudActivity.class);
                startActivity(intent2);
                Toast.makeText(this, "Đã chọn nhập dữ liệu", Toast.LENGTH_SHORT).show();
                break;
            case  R.id.item_exit:
                finish();
                break;
            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }

}