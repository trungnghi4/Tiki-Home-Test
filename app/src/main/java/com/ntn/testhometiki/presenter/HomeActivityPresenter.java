package com.ntn.testhometiki.presenter;

import com.ntn.testhometiki.R;
import com.ntn.testhometiki.api.ApiUtils;
import com.ntn.testhometiki.api.AppApiService;
import com.ntn.testhometiki.model.TikiDeal;
import com.ntn.testhometiki.model.TikiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.ntn.testhometiki.utils.Constants.SERVER_BAD_REQUEST_CODE;
import static com.ntn.testhometiki.utils.Constants.SERVER_ERROR_CODE;
import static com.ntn.testhometiki.utils.Constants.SERVER_PAGE_NOT_FOUND_CODE;
import static com.ntn.testhometiki.utils.Constants.SERVER_SUCCESS_CODE;

public class HomeActivityPresenter {

    private HomeActivityView homeActivityView;

    public HomeActivityPresenter(HomeActivityView homeActivityView) {
        this.homeActivityView = homeActivityView;
    }

    public void initData() {

        List<String> dataCategories = new ArrayList<>();
        dataCategories.add("Mẹ & Bé");
        dataCategories.add("Dịch vụ");
        dataCategories.add("Sức khỏe");
        dataCategories.add("Tiêu dùng");
        dataCategories.add("Nội thất");
        dataCategories.add("Giảm giá");
        dataCategories.add("Thể thao");
        dataCategories.add("Điện tử");
        homeActivityView.handleCategoryAdapter(dataCategories);

        List<TikiService> dataServices = new ArrayList<>();
        dataServices.add(new TikiService(R.drawable.ic_airplane, "Vé máy bay"));
        dataServices.add(new TikiService(R.drawable.ic_insurrance, "Mua bảo hiểm online"));
        dataServices.add(new TikiService(R.drawable.ic_buy_card_phone, "Mua thẻ điện thoại"));
        dataServices.add(new TikiService(R.drawable.ic_insurrance, "Thẻ game"));
        dataServices.add(new TikiService(R.drawable.ic_buy_card_phone, "Service 1"));
        dataServices.add(new TikiService(R.drawable.ic_airplane, "Service 2"));
        homeActivityView.handleServiceAdapter(dataServices);

        List<TikiDeal> dataDeals = new ArrayList<>();
        dataDeals.add(new TikiDeal(R.drawable.deal1, "deal 1"));
        dataDeals.add(new TikiDeal(R.drawable.deal2, "deal 2"));
        dataDeals.add(new TikiDeal(R.drawable.deal3, "deal 3"));
        dataDeals.add(new TikiDeal(R.drawable.deal4, "deal 4"));
        homeActivityView.handleTikiDealAdapter(dataDeals);
    }

    public void initDataKeyWord(){
        AppApiService mService = ApiUtils.getApiService();
        mService.getKeyWords().enqueue(new Callback<List<String>>() {
            @Override
            public void onResponse(Call<List<String>> call, Response<List<String>> response) {
                if (response.code() == SERVER_SUCCESS_CODE) {
                    if (response.body() != null && !response.body().isEmpty()) {
                        homeActivityView.handleKeyWordAdapter(response.body());
                    }
                } else {
                    switch (response.code()){
                        case SERVER_BAD_REQUEST_CODE:
                            homeActivityView.handeMessageErrorAPI(R.string.server_bad_request_error);
                            break;
                        case SERVER_ERROR_CODE:
                            homeActivityView.handeMessageErrorAPI(R.string.server_failed_error);
                            break;
                        case SERVER_PAGE_NOT_FOUND_CODE:
                            homeActivityView.handeMessageErrorAPI(R.string.server_page_not_found_error);
                            break;
                        default:
                            homeActivityView.handeMessageErrorAPI(R.string.server_unknown_error);
                            break;
                    }
                }
            }

            @Override
            public void onFailure(Call<List<String>> call, Throwable t) {
                // Do nothing
            }
        });
    }

    public interface HomeActivityView {
        void handleCategoryAdapter(List<String> data);

        void handleServiceAdapter(List<TikiService> data);

        void handleKeyWordAdapter(List<String> data);

        void handleTikiDealAdapter(List<TikiDeal> data);

        void handeMessageErrorAPI(int message);
    }
}
