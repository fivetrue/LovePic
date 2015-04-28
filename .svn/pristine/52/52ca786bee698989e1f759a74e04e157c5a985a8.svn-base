package com.fivetrue.lovepic.billing;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by kwonojin on 15. 3. 10..
 */
public class PurchasedResult extends Product{

    public static final String PARAM_ORDER_ID = "orderId";
    public static final String PARAM_PACKAGE_NAME = "packageName";
    public static final String PARAM_PURCHASE_TIME = "purchaseTime";
    public static final String PARAM_PURCHASE_STATE = "purchaseState";
    public static final String PARAM_DEVELOP_PAYLOAD = "developerPayload";
    public static final String PARAM_PURCHASE_TOKEN = "purchaseToken";

    private String orderId = null;
    private String packageName = null;
    private String purchaseTime = null;
    private String purchaseState = null;
    private String developerPayload = null;
    private String purchaseToken = null;
    private String purchaseSignature = null;

    public PurchasedResult(){};

    public PurchasedResult(JSONObject json) throws JSONException {
        super(json);

        if(!json.isNull(PARAM_PACKAGE_NAME)){
            packageName = json.getString(PARAM_PACKAGE_NAME);
        }
        if(!json.isNull(PARAM_ORDER_ID)){
            orderId = json.getString(PARAM_ORDER_ID);
        }
        if(!json.isNull(PARAM_PURCHASE_TIME)){
            purchaseTime = json.getString(PARAM_PURCHASE_TIME);
        }
        if(!json.isNull(PARAM_PURCHASE_STATE)){
            purchaseState = json.getString(PARAM_PURCHASE_STATE);
        }
        if(!json.isNull(PARAM_DEVELOP_PAYLOAD)){
            developerPayload = json.getString(PARAM_DEVELOP_PAYLOAD);
        }
        if(!json.isNull(PARAM_PURCHASE_TOKEN)){
            purchaseToken = json.getString(PARAM_PURCHASE_TOKEN);
        }
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getPurchaseTime() {
        return purchaseTime;
    }

    public void setPurchaseTime(String purchaseTime) {
        this.purchaseTime = purchaseTime;
    }

    public String getPurchaseState() {
        return purchaseState;
    }

    public void setPurchaseState(String purchaseState) {
        this.purchaseState = purchaseState;
    }

    public String getDeveloperPayload() {
        return developerPayload;
    }

    public void setDeveloperPayload(String developerPayload) {
        this.developerPayload = developerPayload;
    }

    public String getPurchaseToken() {
        return purchaseToken;
    }

    public void setPurchaseToken(String purchaseToken) {
        this.purchaseToken = purchaseToken;
    }
    public String getPurchaseSignature() {
        return purchaseSignature;
    }

    public void setPurchaseSignature(String purchaseSignature) {
        this.purchaseSignature = purchaseSignature;
    }

    public PurchasedResult(Parcel out){
        super(out);
        orderId = out.readString();
        packageName = out.readString();
        purchaseTime = out.readString();
        purchaseState = out.readString();
        developerPayload = out.readString();
        purchaseToken = out.readString();
        purchaseSignature = out.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeString(orderId);
        dest.writeString(packageName);
        dest.writeString(purchaseTime);
        dest.writeString(purchaseState);
        dest.writeString(developerPayload);
        dest.writeString(purchaseToken);
        dest.writeString(purchaseSignature);
    }

    public static final Parcelable.Creator<PurchasedResult> CREATOR = new Parcelable.Creator<PurchasedResult>() {
        @Override
        public PurchasedResult createFromParcel(Parcel source) {
            return new PurchasedResult(source);
        }

        @Override
        public PurchasedResult[] newArray(int size) {
            return new PurchasedResult[size];
        }
    };

    @Override
    public String toString() {
        return super.toString() + "PurchasedResult{" +
                "orderId='" + orderId + '\'' +
                ", packageName='" + packageName + '\'' +
                ", purchaseTime='" + purchaseTime + '\'' +
                ", purchaseState='" + purchaseState + '\'' +
                ", developerPayload='" + developerPayload + '\'' +
                ", purchaseToken='" + purchaseToken + '\'' +
                '}';
    }
}
