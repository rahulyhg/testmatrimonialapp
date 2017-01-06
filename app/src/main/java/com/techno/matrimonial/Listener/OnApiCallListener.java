package com.techno.matrimonial.Listener;

/**
 * Created by arbaz on 19/7/16.
 */
public interface OnApiCallListener {
    public void onFailure(String message);

    public void onSuccess(int responseCode, String responseString, String url);

}
