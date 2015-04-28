package com.fivetrue.lovepic.billing;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by kwonojin on 15. 3. 10..
 */
public class Product implements Parcelable{

    public static final String PARAM_PRODUCT_ID = "productId";
    public static final String PARAM_TYPE = "type";
    public static final String PARAM_PRICE = "price";
    public static final String PARAM_PRICE_AMOUNT_MICROS = "price_amount_micros";
    public static final String PARAM_PRICE_CURRENCY_CODE = "price_currency_code";
    public static final String PARAM_TITLE = "title";
    public static final String PARAM_DESCRIPTION = "description";


    private String productId = null;
    private String price = null;
    private String type = null;
    private String priceAmountMicros = null;
    private String priceCurrencyCode = null;
    private String title = null;
    private String description = null;

    public Product(){}

    public Product(JSONObject json) throws JSONException {
        if (!json.isNull(PARAM_PRODUCT_ID)) {
            productId = json.getString(PARAM_PRODUCT_ID);
        }
        if (!json.isNull(PARAM_PRICE)) {
            price = json.getString(PARAM_PRICE);
        }

        if (!json.isNull(PARAM_TYPE)) {
            type = json.getString(PARAM_TYPE);
        }

        if (!json.isNull(PARAM_PRICE_AMOUNT_MICROS)) {
            priceAmountMicros = json.getString(PARAM_PRICE_AMOUNT_MICROS);
        }

        if (!json.isNull(PARAM_PRICE_CURRENCY_CODE)) {
            priceCurrencyCode = json.getString(PARAM_PRICE_CURRENCY_CODE);
        }

        if (!json.isNull(PARAM_TITLE)) {
            title = json.getString(PARAM_TITLE);
        }

        if (!json.isNull(PARAM_DESCRIPTION)) {
            description = json.getString(PARAM_DESCRIPTION);
        }
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPriceAmountMicros() {
        return priceAmountMicros;
    }

    public void setPriceAmountMicros(String priceAmountMicros) {
        this.priceAmountMicros = priceAmountMicros;
    }

    public String getPriceCurrencyCode() {
        return priceCurrencyCode;
    }

    public void setPriceCurrencyCode(String priceCurrencyCode) {
        this.priceCurrencyCode = priceCurrencyCode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId='" + productId + '\'' +
                ", price='" + price + '\'' +
                ", type='" + type + '\'' +
                ", priceAmountMicros='" + priceAmountMicros + '\'' +
                ", priceCurrencyCode='" + priceCurrencyCode + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public Product(Parcel out){
        productId = out.readString();
        price = out.readString();
        type = out.readString();
        priceAmountMicros = out.readString();
        priceCurrencyCode = out.readString();
        title = out.readString();
        description = out.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(productId);
        dest.writeString(price);
        dest.writeString(type);
        dest.writeString(priceAmountMicros);
        dest.writeString(priceCurrencyCode);
        dest.writeString(title);
        dest.writeString(description);
    }

    public static final Creator<Product> CREATOR = new Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel source) {
            return new Product(source);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };
}
