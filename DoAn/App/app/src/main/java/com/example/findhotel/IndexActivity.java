package com.example.findhotel;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;

import com.example.findhotel.adapter.RecentsAdapter;
import com.example.findhotel.adapter.TopHotelsAdapter;
import com.example.findhotel.database.DBHelper;
import com.example.findhotel.model.Hotel;
import com.example.findhotel.model.RecentsData;
import com.example.findhotel.model.TopHotelsData;

import java.util.ArrayList;
import java.util.List;

public class IndexActivity extends AppCompatActivity {
    RecyclerView recentRecycler, topHotelsRecycler;
    RecentsAdapter recentsAdapter;
    Button btnSearch;
    TopHotelsAdapter topHotelsAdapter;
    DBHelper dbHelper;
    EditText editTim;
    GridView gv_display;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);

        ActionBar actionBar = this.getSupportActionBar();
        actionBar.hide();

        editTim = findViewById(R.id.edit_tim);
        gv_display = findViewById(R.id.gv_hotel);

        List<RecentsData> recentsDataList = new ArrayList<>();
        recentsDataList.add(new RecentsData("Khách sạn 1", "Tp. Hồ Chí Minh", "From $25", R.drawable.hinh01));
        recentsDataList.add(new RecentsData("Khách sạn 2", "Tp. Hồ Chí Minh", "From $25", R.drawable.hinh02));
        recentsDataList.add(new RecentsData("Khách sạn 3", "Tp. Hồ Chí Minh", "From $25", R.drawable.hinh03));
        recentsDataList.add(new RecentsData("Khách sạn 4", "Tp. Hồ Chí Minh", "From $25", R.drawable.hinh04));

        setRecentRecycler(recentsDataList);

        List<TopHotelsData> topHotelsDataList = new ArrayList<>();
        topHotelsDataList.add(new TopHotelsData("Khách sạn 1", "Tp. Hồ Chí Minh", "From $25", R.drawable.hinh01));
        topHotelsDataList.add(new TopHotelsData("Khách sạn 2", "Tp. Hồ Chí Minh", "From $25", R.drawable.hinh02));
        topHotelsDataList.add(new TopHotelsData("Khách sạn 3", "Tp. Hồ Chí Minh", "From $25", R.drawable.hinh03));
        topHotelsDataList.add(new TopHotelsData("Khách sạn 4", "Tp. Hồ Chí Minh", "From $25", R.drawable.hinh04));

        setTopHotelsRecycler(topHotelsDataList);

        btnSearch = findViewById(R.id.btn_Tim);
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editTim.getText().length() == 0) {
                    Intent intent = new Intent(IndexActivity.this, ResultSearchActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    private void setRecentRecycler(List<RecentsData> recentsDataList) {

        recentRecycler = (RecyclerView) findViewById(R.id.recent_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        recentRecycler.setLayoutManager(layoutManager);
        recentsAdapter = new RecentsAdapter(this, recentsDataList);
        recentRecycler.setAdapter(recentsAdapter);
    }

    private void setTopHotelsRecycler(List<TopHotelsData> topHotelsDataList) {

        recentRecycler = (RecyclerView) findViewById(R.id.top_hotels_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recentRecycler.setLayoutManager(layoutManager);
        topHotelsAdapter = new TopHotelsAdapter(this, topHotelsDataList);
        recentRecycler.setAdapter(topHotelsAdapter);
    }
}