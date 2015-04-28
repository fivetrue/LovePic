package com.fivetrue.lovepic.billing;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import com.android.vending.billing.IInAppBillingService;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by kwonojin on 15. 3. 10..
 */
public class IAPHelper {

    public interface IAPSkuDetailListener{
        void onReceiveProductList(ArrayList<Product> products);
    }

    public interface IAPPurchasesListener{
        void onReceivePurchasesList(ArrayList<PurchasedResult> purchasedResults);
    }
    public static final String TAG = "IAPHelper";
    public static final int INVALIDE_VALUE = -1;

    //패키지 정보 및 Bind action
    public static final String BILLING_PACKAGE = "com.android.vending";
    public static final String BILLING_BIND_ACTION = "com.android.vending.billing.InAppBillingService.BIND";
    public static final int BILLING_API_VERSION = 3;
    public static final String BILLING_TYPE = "inapp";

    //SKU ITEM 로딩 관련.
    public static final String BILLING_SKU_ITEM_ID_LIST = "ITEM_ID_LIST";
    public static final String BILLING_SKU_DETAIL_LIST = "DETAILS_LIST";

    //구매 요청 관련
    public static final String BILLING_BUY_INTENT = "BUY_INTENT";

    //구매정보 관련
    public static final String RESPONSE_CODE = "RESPONSE_CODE";
    public static final String BILLING_INAPP_PURCHASE_DATA = "INAPP_PURCHASE_DATA";
    public static final String BILLING_INAPP_PURCHASE_ITEM_LIST = "INAPP_PURCHASE_ITEM_LIST";
    public static final String BILLING_INAPP_PURCHASE_DATA_LIST = "INAPP_PURCHASE_DATA_LIST";
    public static final String BILLING_INAPP_DATA_SIGNATURE = "INAPP_DATA_SIGNATURE";
    public static final String BILLING_INAPP_CONTINUATION_TOKEN = "INAPP_CONTINUATION_TOKEN";

    //서버 리스폰 코드.
    public static final int BILLING_RESPONSE_RESULT_OK = 0; //	Success
    public static final int BILLING_RESPONSE_RESULT_USER_CANCELED	= 1;	//User pressed back or canceled a dialog
    public static final int BILLING_RESPONSE_RESULT_SERVICE_UNAVAILABLE = 2;	//Network connection is down
    public static final int BILLING_RESPONSE_RESULT_BILLING_UNAVAILABLE = 3;	//Billing API version is not supported for the type requested
    public static final int BILLING_RESPONSE_RESULT_ITEM_UNAVAILABLE = 4;	//Requested product is not available for purchase
    public static final int BILLING_RESPONSE_RESULT_DEVELOPER_ERROR =	5;	//Invalid arguments provided to the API. This error can also indicate that the application was not correctly signed or properly set up for In-app Billing in Google Play, or does not have the necessary permissions in its manifest
    public static final int BILLING_RESPONSE_RESULT_ERROR	= 6;	//Fatal error during the API action
    public static final int BILLING_RESPONSE_RESULT_ITEM_ALREADY_OWNED =	7;	//Failure to purchase since item is already owned
    public static final int BILLING_RESPONSE_RESULT_ITEM_NOT_OWNED = 8;	//Failure to consume since item is not owned


    private static IInAppBillingService sInAppBillingService = null;

    public static void bindBillingService(Context context){
        if(context == null){
            new IllegalArgumentException("context is null");
        }

        Intent i = new Intent(BILLING_BIND_ACTION);
        i.setPackage(BILLING_PACKAGE);
        context.bindService(i, sServiceConnection, Context.BIND_AUTO_CREATE);
    }

    public static void unbindBillingService(Context context){
        if(context == null){
            new IllegalArgumentException("context is null");
        }
        context.unbindService(sServiceConnection);
    }

    public static void getSkuDetailList(final Context context, final ArrayList<String> itemList, final IAPSkuDetailListener ll){
        if(context != null && itemList != null && ll != null){
            new AsyncTask<ArrayList<String>, Void, ArrayList<Product>>(){

                @Override
                protected ArrayList<Product> doInBackground(ArrayList<String>... params) {
                    ArrayList<String> list = params[0];

                    if(list != null){
                        //SKU list 불러오기.
                        Bundle itemList = new Bundle();
                        itemList.putStringArrayList(BILLING_SKU_ITEM_ID_LIST, list);
                        Bundle itemDetailList = new Bundle();
                        try {
                            itemDetailList = sInAppBillingService.getSkuDetails(BILLING_API_VERSION, context.getPackageName(), BILLING_TYPE, itemList);
                        } catch (RemoteException e) {
                            e.printStackTrace();
                        }
                        if(itemDetailList != null){
                            Log.d(TAG, "Sku Detail Response code = " + itemDetailList.getInt(RESPONSE_CODE, INVALIDE_VALUE));
                            final int responseCode = itemDetailList.getInt(RESPONSE_CODE, INVALIDE_VALUE);
                            switch(responseCode){
                                case BILLING_RESPONSE_RESULT_OK :
                                    try {
                                        ArrayList<String> skuDetailList = itemDetailList.getStringArrayList(BILLING_SKU_DETAIL_LIST);
                                        Log.d(TAG, skuDetailList.toString());
                                        ArrayList<Product> productList = new ArrayList<Product>();
                                        Log.d(TAG, "getDetail Sku");
                                        for(String response : skuDetailList) {
                                            Product product = new Product(new JSONObject(response));
                                            productList.add(product);
                                            Log.d(TAG, product.toString());
                                        }
                                        return productList;
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                    break;
                            }
                        }
                    }

                    return null;
                }

                @Override
                protected void onPostExecute(ArrayList<Product> products) {
                    super.onPostExecute(products);
                    ll.onReceiveProductList(products);
                }
            }.execute(itemList);
        }
    }

    public static boolean isSupportInAppBilling(Context context){
        if(sInAppBillingService != null){
            Log.d(TAG, "isSupportInAppBilling");
            int resultCode = INVALIDE_VALUE;
            try {
                resultCode = sInAppBillingService.isBillingSupported(BILLING_API_VERSION, context.getPackageName(), BILLING_TYPE);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
            Log.d(TAG, "isSupportInAppBilling Result Code = " + resultCode);
            switch(resultCode){
                case BILLING_RESPONSE_RESULT_OK :
                    return true;

            }
        }
        return false;
    };

    public static void requestBuy(final Activity activity, final  Product product, final  int requestCode){
        if(sInAppBillingService != null && activity != null && product != null){
            Bundle buyIntent = null;
            try {
                buyIntent = sInAppBillingService.getBuyIntent(BILLING_API_VERSION, activity.getPackageName(), product.getProductId(), BILLING_TYPE, "");
            } catch (RemoteException e) {
                e.printStackTrace();
            }
            if(buyIntent != null){
                final int responseCode = buyIntent.getInt(RESPONSE_CODE, INVALIDE_VALUE);
                switch(responseCode){
                    case BILLING_RESPONSE_RESULT_OK :
                        PendingIntent pendingIntent = buyIntent.getParcelable(BILLING_BUY_INTENT);
                        if(pendingIntent != null){
                            try {
                                activity.startIntentSenderForResult(pendingIntent.getIntentSender(), requestCode, new Intent(), Integer.valueOf(0),
                                        Integer.valueOf(0),Integer.valueOf(0));
                            } catch (IntentSender.SendIntentException e) {
                                e.printStackTrace();
                            }
                        }
                        break;
                }
            }
        }
    }

    public static PurchasedResult getPurchaseResultData(Intent intent){
        if(intent != null){
            String purchaseData = intent.getStringExtra(BILLING_INAPP_PURCHASE_DATA);
            try {
                PurchasedResult result = new PurchasedResult(new JSONObject(purchaseData));
//                result.setPurchaseToken(intent.getStringExtra(BILLING_INAPP_PURCHASE_DATA));
                result.setPurchaseSignature(intent.getStringExtra(BILLING_INAPP_DATA_SIGNATURE));
                Log.d(TAG, "purchaseData = " + purchaseData);
                return result;
            }
            catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static ArrayList<PurchasedResult> getPurchasesList(Context context){
        if(context != null){
            Bundle ownedItems = null;
            try {
                ownedItems = sInAppBillingService.getPurchases(BILLING_API_VERSION, context.getPackageName(), BILLING_TYPE, null);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
            if(ownedItems != null) {
                ArrayList<PurchasedResult> purchasedResults = new ArrayList<>();
                int response = ownedItems.getInt(RESPONSE_CODE, INVALIDE_VALUE);

                switch(response){
                    case BILLING_RESPONSE_RESULT_OK :{
                        ArrayList<String> ownedSkus =
                                ownedItems.getStringArrayList(BILLING_INAPP_PURCHASE_ITEM_LIST);
                        ArrayList<String> purchaseDataList =
                                ownedItems.getStringArrayList(BILLING_INAPP_PURCHASE_DATA_LIST);
                        ArrayList<String> signatureList =
                                ownedItems.getStringArrayList(BILLING_INAPP_DATA_SIGNATURE);

                        String continuationToken =
                                ownedItems.getString(BILLING_INAPP_CONTINUATION_TOKEN);

                        for (int i = 0; i < purchaseDataList.size(); ++i) {
                            Log.d(TAG, "================================= ");
                            String purchaseData = purchaseDataList.get(i);
                            try {
                                PurchasedResult pData = new PurchasedResult(new JSONObject(purchaseData));
                                pData.setPurchaseToken(continuationToken);

                                if(signatureList != null && signatureList.size() > i){
                                    String signature = signatureList.get(i);
                                    Log.d(TAG, "signature = " + signature);
                                }
                                if(ownedSkus != null && ownedSkus.size() > i){
                                    String sku = ownedSkus.get(i);
                                    Log.d(TAG, "sku = " + sku);
                                }
                                Log.d(TAG, "purchaseData = " + pData.toString());
                                Log.d(TAG, "purchaseData json = " + purchaseData);
                                purchasedResults.add(pData);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            Log.d(TAG, "================================= ");

                            // 구매한 상품의 정보를 이용하여 무언가를 처리하면 됩니다.
                            // e.g. 유저가 보유한 상품의 리스트를 업데이트
                        }
                        if(continuationToken != null){
                            getPurchasesList(context);
                        }
                        // 만약 continuationToken != null 이라면 getPurchases를 한번더 호출합니다.
                        // INAPP_CONTINUATION_TOKEN 토큰값을 사용하여 이후의 데이터를 받아올 수 있습니다.
                    }
                    break;
                }
                return purchasedResults;
            }
        }
        return null;
    }


    public static void getPurchasesList(final Context context, final IAPPurchasesListener ll){
        if(context != null && ll != null){
            new AsyncTask<Context, Void, ArrayList<PurchasedResult>>(){

                @Override
                protected ArrayList<PurchasedResult> doInBackground(Context... params) {
                    Context context = params[0];
                    if(context != null){
                        Bundle ownedItems = null;
                        try {
                            ownedItems = sInAppBillingService.getPurchases(BILLING_API_VERSION, context.getPackageName(), BILLING_TYPE, null);
                        } catch (RemoteException e) {
                            e.printStackTrace();
                        }
                        if(ownedItems != null) {
                            ArrayList<PurchasedResult> purchasedResults = new ArrayList<>();
                            int response = ownedItems.getInt(RESPONSE_CODE, INVALIDE_VALUE);

                            switch(response){
                                case BILLING_RESPONSE_RESULT_OK :{
                                    ArrayList<String> ownedSkus =
                                            ownedItems.getStringArrayList(BILLING_INAPP_PURCHASE_ITEM_LIST);
                                    ArrayList<String> purchaseDataList =
                                            ownedItems.getStringArrayList(BILLING_INAPP_PURCHASE_DATA_LIST);
                                    ArrayList<String> signatureList =
                                            ownedItems.getStringArrayList(BILLING_INAPP_DATA_SIGNATURE);

                                    String continuationToken =
                                            ownedItems.getString(BILLING_INAPP_CONTINUATION_TOKEN);

                                    for (int i = 0; i < purchaseDataList.size(); ++i) {
                                        Log.d(TAG, "================================= ");
                                        String purchaseData = purchaseDataList.get(i);
                                        try {
                                            PurchasedResult pData = new PurchasedResult(new JSONObject(purchaseData));
                                            pData.setPurchaseToken(continuationToken);

                                            if(signatureList != null && signatureList.size() > i){
                                                String signature = signatureList.get(i);
                                                Log.d(TAG, "signature = " + signature);
                                            }
                                            if(ownedSkus != null && ownedSkus.size() > i){
                                                String sku = ownedSkus.get(i);
                                                Log.d(TAG, "sku = " + sku);
                                            }
                                            Log.d(TAG, "purchaseData = " + pData.toString());
                                            Log.d(TAG, "purchaseData json = " + purchaseData);
                                            purchasedResults.add(pData);
                                        } catch (JSONException e) {
                                            e.printStackTrace();
                                        }
                                        Log.d(TAG, "================================= ");

                                        // 구매한 상품의 정보를 이용하여 무언가를 처리하면 됩니다.
                                        // e.g. 유저가 보유한 상품의 리스트를 업데이트
                                    }
                                    if(continuationToken != null){
                                        doInBackground(params);
                                    }
                                    // 만약 continuationToken != null 이라면 getPurchases를 한번더 호출합니다.
                                    // INAPP_CONTINUATION_TOKEN 토큰값을 사용하여 이후의 데이터를 받아올 수 있습니다.
                                }
                                break;
                            }
                            return purchasedResults;
                        }
                    }
                    return null;
                }

                @Override
                protected void onPostExecute(ArrayList<PurchasedResult> purchasedResults) {
                    super.onPostExecute(purchasedResults);
                    if(purchasedResults != null){
                        ll.onReceivePurchasesList(purchasedResults);
                    }
                }
            }.execute(context);
        }
    }

    //반드시 Main Thread에서 호출해야함.
    public static boolean consumePurchase(Context context, String token){
        if(context != null && token != null){
            try {
                Log.d(TAG, "consumePurchase token = "  + token);
                int response = sInAppBillingService.consumePurchase(BILLING_API_VERSION, context.getPackageName(), token);
                Log.d(TAG, "consumePurchase response = "  + response);
                return response == BILLING_RESPONSE_RESULT_OK;
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    private static ServiceConnection sServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            sInAppBillingService = IInAppBillingService.Stub.asInterface(service);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            sInAppBillingService = null;
        }
    };
}
