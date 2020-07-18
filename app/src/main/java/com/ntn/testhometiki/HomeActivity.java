package com.ntn.testhometiki;

import android.app.AlertDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ntn.testhometiki.adapter.CategoryAdapter;
import com.ntn.testhometiki.adapter.KeyWordAdapter;
import com.ntn.testhometiki.adapter.ServiceAdapter;
import com.ntn.testhometiki.adapter.TikiDealAdapter;
import com.ntn.testhometiki.model.TikiDeal;
import com.ntn.testhometiki.model.TikiService;
import com.ntn.testhometiki.presenter.HomeActivityPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends AppCompatActivity implements HomeActivityPresenter.HomeActivityView {

    @BindView(R.id.recycler_view_category)
    RecyclerView recyclerViewCategory;
    @BindView(R.id.recycler_view_service)
    RecyclerView recyclerViewService;
    @BindView(R.id.recycler_view_hot_key_word)
    RecyclerView recyclerViewHotKeyWord;
    @BindView(R.id.recycler_view_deal)
    RecyclerView recyclerViewDeal;
    @BindView(R.id.btn_register)
    Button btnRegister;
    @BindView(R.id.btn_login)
    Button btnLogin;

    CategoryAdapter categoryAdapter;
    ServiceAdapter serviceAdapter;
    KeyWordAdapter keyWordAdapter;
    TikiDealAdapter dealAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

        // Set layout
        recyclerViewCategory.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerViewService.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerViewHotKeyWord.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerViewDeal.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        // View category
        categoryAdapter = new CategoryAdapter(this, null);
        recyclerViewCategory.setAdapter(categoryAdapter);

        // View service
        serviceAdapter = new ServiceAdapter(this, null);
        recyclerViewService.setAdapter(serviceAdapter);

        // View hot key word
        keyWordAdapter = new KeyWordAdapter(this, null);
        recyclerViewHotKeyWord.setAdapter(keyWordAdapter);

        // View deal
        dealAdapter = new TikiDealAdapter(this, null);
        recyclerViewDeal.setAdapter(dealAdapter);

        HomeActivityPresenter homeActivityPresenter = new HomeActivityPresenter(this);
        homeActivityPresenter.initData();

        if(isNetworkAvailable()){
            homeActivityPresenter.initDataKeyWord();
        }else{
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
            alertDialogBuilder.setMessage(getResources().getString(R.string.error_internet_no_connection))
                    .setPositiveButton("OK", (dialogInterface, i) -> dialogInterface.cancel())
                    .setCancelable(false);
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        }
    }

    @Override
    public void handleCategoryAdapter(List<String> data) {
        categoryAdapter.updateDataCategory(data);
    }

    @Override
    public void handleServiceAdapter(List<TikiService> data) {
        serviceAdapter.updateDataService(data);
    }

    @Override
    public void handleKeyWordAdapter(List<String> data) {
        keyWordAdapter.updateDataKeyWord(data);
    }

    @Override
    public void handleTikiDealAdapter(List<TikiDeal> data) {
        dealAdapter.updateDataDeal(data);
    }

    @Override
    public void handeMessageErrorAPI(int message) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage(getResources().getString(message))
                .setPositiveButton("OK", (dialogInterface, i) -> dialogInterface.cancel())
                .setCancelable(false);
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    protected boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService (Context.CONNECTIVITY_SERVICE);
        return connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isConnected();
    }
}

