package com.ntn.testhometiki.api;

import com.ntn.testhometiki.utils.Constants;

public class ApiUtils {

    public static AppApiService getApiService() {
        return RetrofitClient.getClient(Constants.KEY_WORD_BASE_URL).create(AppApiService.class);
    }
}
