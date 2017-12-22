package com.example.nikkoekasaputra.testscreensuitmedia.adapter;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nikkoekasaputra.testscreensuitmedia.R;
import com.example.nikkoekasaputra.testscreensuitmedia.model.Event;

import java.util.ArrayList;

/**
 * Created by Nikko Eka Saputra on 22/12/2017.
 */

public class EventAdapter extends ArrayAdapter<Event> {

    public EventAdapter(Context context, ArrayList<Event> events) {
        super(context, 0, events);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.custom_list_item, parent, false);
        }

        Event currentEvent = getItem(position);

        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image_event);
        TextView tvNamaEvent = (TextView) listItemView.findViewById(R.id.tv_nama_event);
        TextView tvTanggalEvent = (TextView) listItemView.findViewById(R.id.tv_tanggal_event);

        //set to view
        if (currentEvent.hasImage()) {
            imageView.setImageResource(currentEvent.getImageResourceId());
            imageView.setVisibility(View.VISIBLE);
        }
        else {
            imageView.setVisibility(View.GONE);
        }
        tvNamaEvent.setText(currentEvent.getNamaEvent());
        tvTanggalEvent.setText(currentEvent.getTanggalEvent());


        return listItemView;
    }

}
