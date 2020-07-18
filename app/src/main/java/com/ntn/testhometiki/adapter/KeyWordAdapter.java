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
import com.ntn.testhometiki.utils.FormatKeywork;
import com.ntn.testhometiki.utils.Utils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class KeyWordAdapter extends RecyclerView.Adapter<KeyWordAdapter.KeyWordViewHolder> {
    private List<String> listDataKeyWord;

    private Context context;
    private LayoutInflater inflater;

    public KeyWordAdapter(Context context, List<String> listDataKeyWord) {
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        this.listDataKeyWord = listDataKeyWord;
    }

    public void updateDataKeyWord(List<String> dataKeyWord) {
        this.listDataKeyWord = dataKeyWord;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public KeyWordViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.key_word_item, viewGroup, false);
        return new KeyWordAdapter.KeyWordViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull KeyWordViewHolder holder, int i) {
        String keyWord = listDataKeyWord.get(i);
        holder.layoutKeyWord.setBackground(Utils.getRoundBackground(context, Utils.getRandomColor()));
        holder.tvKeyWord.setText(FormatKeywork.splitKeyword(keyWord));
    }

    @Override
    public int getItemCount() {
        return listDataKeyWord != null ? listDataKeyWord.size() : 0;
    }

    class KeyWordViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.layout_key_word)
        View layoutKeyWord;
        @BindView(R.id.tv_key_word)
        TextView tvKeyWord;

        KeyWordViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);

            view.setOnClickListener(v1 -> Toast.makeText(context, tvKeyWord.getText(), Toast.LENGTH_SHORT).show());
        }
    }
}
