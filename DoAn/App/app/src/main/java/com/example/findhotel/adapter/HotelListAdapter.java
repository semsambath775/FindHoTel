package com.example.findhotel.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.findhotel.R;
import com.example.findhotel.model.Hotel;

import java.util.ArrayList;

public class HotelListAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private ArrayList<Hotel> hotelList;

    public HotelListAdapter(Context context, int layout, ArrayList<Hotel> hotelList) {
        this.context = context;
        this.layout = layout;
        this.hotelList = hotelList;
    }

    @Override
    public int getCount() {
        return hotelList.size();
    }

    @Override
    public Object getItem(int position) {
        return hotelList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private class ViewHolder {
        ImageView imageView;
        TextView txtMaSo, txtTen, txtDiaChi, txtGia;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        ViewHolder holder = new ViewHolder();

        if(row == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(layout, null);

//            holder.txtMaSo = row.findViewById(R.id.edit_MaSo);
            holder.txtTen = row.findViewById(R.id.edit_NhapTenKachSan);
            holder.txtDiaChi = row.findViewById(R.id.edit_NhapDiaChi);
            holder.txtGia = row.findViewById(R.id.edit_NhapGia);
            holder.imageView = row.findViewById(R.id.imgHotel);
            row.setTag(holder);
        }
        else {
            holder = (ViewHolder) row.getTag();
        }

        Hotel hotel = hotelList.get(position);

        holder.txtMaSo.setText(hotel.getMaSo());
        holder.txtTen.setText(hotel.getTenKachSan());
        holder.txtDiaChi.setText(hotel.getDiaChi());
        holder.txtGia.setText(hotel.getGiaTien());

        byte[] hotelImage = hotel.getHinh();
        Bitmap bitmap = BitmapFactory.decodeByteArray(hotelImage, 0, hotelImage.length);
        holder.imageView.setImageBitmap(bitmap);

        return row;
    }
}
