package com.example.nikkoekasaputra.testscreensuitmedia.adapter;

/**
 * Created by Nikko Eka Saputra on 22/12/2017.
 */

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nikkoekasaputra.testscreensuitmedia.R;
import com.example.nikkoekasaputra.testscreensuitmedia.model.Guest;

import java.util.ArrayList;
import java.util.List;

import static android.app.Activity.RESULT_OK;


public class GuestAdapter extends RecyclerView.Adapter<GuestAdapter.GuestViewHolder> {
    private List<Guest> mGuestList;
    private LayoutInflater mInflater;
    private Context mContext;

    String namaGuest, tanggalLahirGuest;

    int tanggalLahir;

    public GuestAdapter(Context context) {
        mContext = context;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public GuestViewHolder onCreateViewHolder(ViewGroup parent, final int viewType) {
        View view = mInflater.inflate(R.layout.custom_grid_item, parent, false);
        final GuestViewHolder viewHolder = new GuestViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = viewHolder.getAdapterPosition();
                namaGuest = mGuestList.get(position).getNamaGuest();
                tanggalLahirGuest = mGuestList.get(position).getTanggalLahir();

                tanggalLahir = Integer.parseInt(tanggalLahirGuest.substring(8,10));

                if(tanggalLahir>1 && tanggalLahir % 2 == 0 && tanggalLahir % 3 == 0) {
                    Toast.makeText(mContext, "IOS", Toast.LENGTH_SHORT).show();
                }
                else if(tanggalLahir>1 && tanggalLahir % 2 == 0 && tanggalLahir % 3 != 0){
                    Toast.makeText(mContext, "Blackberry", Toast.LENGTH_SHORT).show();
                }
                else if(tanggalLahir>1 && tanggalLahir % 3 == 0 && tanggalLahir % 2 != 0){
                    Toast.makeText(mContext, "Android", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(mContext, "Feature Phone", Toast.LENGTH_SHORT).show();
                }

                Intent returnIntent = new Intent();
                returnIntent.putExtra("result", namaGuest);
                ((Activity) mContext).setResult(RESULT_OK, returnIntent);

                ((Activity) mContext).finish();
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(GuestViewHolder holder, int position) {
        Guest guest = mGuestList.get(position);
        holder.namaTextView.setText(mGuestList.get(position).getNamaGuest());
        if (guest.hasImage()) {
            holder.imageView.setImageResource(guest.getImageResourceId());
            holder.imageView.setVisibility(View.VISIBLE);
        }
        else {
            holder.imageView.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return (mGuestList == null) ? 0 : mGuestList.size();
    }

    public void setGuestList(List<Guest> guestList) {
        this.mGuestList = new ArrayList<>();
        this.mGuestList.addAll(guestList);
        notifyDataSetChanged();
    }

    public class GuestViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView namaTextView;
        public GuestViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.image_guest);
            namaTextView = (TextView) itemView.findViewById(R.id.tv_nama_guest);
        }
    }
}