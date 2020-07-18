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

import com.ntn.testhometiki.R;
import com.ntn.testhometiki.model.TikiService;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ServiceAdapter extends RecyclerView.Adapter<ServiceAdapter.ServiceViewHolder> {
    private Context context;
    private List<TikiService> listDataService;
    private LayoutInflater inflater;

    public ServiceAdapter(Context context, List<TikiService> listDataService) {
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        this.listDataService = listDataService;
    }

    public void updateDataService(List<TikiService> listDataService) {
        this.listDataService = listDataService;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ServiceViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View view = inflater.inflate(R.layout.service_item, viewGroup, false);
        return new ServiceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ServiceViewHolder holder, int position) {
        TikiService service = listDataService.get(position);
        holder.tvServiceName.setText(service.getServiceName());
        holder.imgViewService.setImageResource(service.getServiceLogo());
    }

    @Override
    public int getItemCount() {
        return listDataService != null ? listDataService.size() : 0;
    }

    class ServiceViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.img_service)
        ImageView imgViewService;

        @BindView(R.id.tv_service_name)
        TextView tvServiceName;

        ServiceViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);

            view.setOnClickListener(v -> Toast.makeText(context, tvServiceName.getText(), Toast.LENGTH_SHORT).show());
        }
    }
}
