package com.ntn.testhometiki.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ntn.testhometiki.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {
    private Context context;
    private List<String> listDataCategory;
    private LayoutInflater inflater;

    public CategoryAdapter(Context context, List<String> listDataCategory) {
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        this.listDataCategory = listDataCategory;
    }

    public void updateDataCategory(List<String> listDataCategory) {
        this.listDataCategory = listDataCategory;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, final int position) {
        View view = inflater.inflate(R.layout.category_item, viewGroup, false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        String itemCategory = listDataCategory.get(position);
        holder.tvCategory.setText(itemCategory);
    }

    @Override
    public int getItemCount() {
        return listDataCategory != null ? listDataCategory.size() : 0;
    }

    class CategoryViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tvCategory)
        TextView tvCategory;

        CategoryViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
            view.setOnClickListener(v1 -> Toast.makeText(context, tvCategory.getText(), Toast.LENGTH_SHORT).show());
        }
    }
}
