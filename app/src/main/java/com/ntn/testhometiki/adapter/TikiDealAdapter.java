package com.ntn.testhometiki.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.ntn.testhometiki.R;
import com.ntn.testhometiki.model.TikiDeal;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TikiDealAdapter extends RecyclerView.Adapter<TikiDealAdapter.TikiDealViewHolder> {
    private Context context;
    private List<TikiDeal> listDataDeal;
    private LayoutInflater inflater;

    public TikiDealAdapter(Context context, List<TikiDeal> listDataDeal) {
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        this.listDataDeal = listDataDeal;
    }

    public void updateDataDeal(List<TikiDeal> listDataDeal) {
        this.listDataDeal = listDataDeal;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TikiDealViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.deals_item, viewGroup, false);
        return new TikiDealViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TikiDealViewHolder holder, int pos) {
        TikiDeal tikiDeal = listDataDeal.get(pos);
        loadRandomImage(holder.imgViewDeal, 120, 160, tikiDeal.getImage());
        holder.tvTitle.setText(tikiDeal.getTitle());
    }

    @Override
    public int getItemCount() {
        return listDataDeal != null ? listDataDeal.size() : 0;
    }

    class TikiDealViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.img_deal)
        ImageView imgViewDeal;
        @BindView(R.id.tv_title)
        TextView tvTitle;

        TikiDealViewHolder(@NonNull View view) {
            super(view);
            ButterKnife.bind(this, view);

            view.setOnClickListener(v -> Toast.makeText(context, tvTitle.getText(), Toast.LENGTH_SHORT).show());
        }
    }

    private void loadRandomImage(ImageView imageView, int width, int height, int resourceImage) {
        Glide.with(context).load(resourceImage).override(width,height).into(imageView);
    }
}
