package com.hardcodecoder.pulsemusic.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textview.MaterialTextView;
import com.hardcodecoder.pulsemusic.R;
import com.hardcodecoder.pulsemusic.interfaces.SimpleItemClickListener;
import com.hardcodecoder.pulsemusic.model.MusicModel;
import com.hardcodecoder.pulsemusic.views.MediaArtImageView;

import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder> {

    private List<MusicModel> mList;
    private SimpleItemClickListener mListener;
    @LayoutRes
    private int mLayout;
    private LayoutStyle mLayoutStyle;
    private LayoutInflater mInflater;

    public HomeAdapter(LayoutInflater inflater, List<MusicModel> list, SimpleItemClickListener clickListener, LayoutStyle style) {
        this.mListener = clickListener;
        this.mList = list;
        this.mLayoutStyle = style;
        this.mInflater = inflater;
        if (style == LayoutStyle.CIRCLE) mLayout = R.layout.rv_home_item_cir;
        else mLayout = R.layout.rv_home_item_sq;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(mInflater.inflate(mLayout, parent, false), mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.setItemData(mList.get(position), mLayoutStyle);
    }

    @Override
    public int getItemCount() {
        if (mList != null)
            return mList.size();
        return 0;
    }

    public enum LayoutStyle {
        CIRCLE,
        ROUNDED_RECTANGLE
    }

    /*
     * Custom View holder class
     */
    static class MyViewHolder extends RecyclerView.ViewHolder {

        private MaterialTextView title, text;
        private MediaArtImageView albumArt;

        MyViewHolder(View itemView, SimpleItemClickListener listener) {
            super(itemView);

            title = itemView.findViewById(R.id.home_rv_list_item_title);
            text = itemView.findViewById(R.id.home_rv_list_item_text);
            albumArt = itemView.findViewById(R.id.home_rv_list_item_album_art);

            itemView.setOnLongClickListener(v -> {
                listener.onOptionsClick(getAdapterPosition());
                return true;
            });
            itemView.setOnClickListener(v -> listener.onItemClick(getAdapterPosition()));
        }

        void setItemData(MusicModel md, LayoutStyle style) {
            title.setText(md.getTrackName());
            text.setText(md.getArtist());
            albumArt.loadAlbumArt(md.getAlbumArtUrl(), md.getAlbumId());
        }
    }
}
