package com.dhimandasgupta.cardrecylerpalette.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by dhimandasgupta on 12/13/14.
 */
public class CardItem implements Parcelable {
    public static final Creator<CardItem> CREATOR = new Creator<CardItem>() {
        @Override
        public CardItem createFromParcel(Parcel source) {
            return new CardItem(source);
        }

        @Override
        public CardItem[] newArray(int size) {
            return new CardItem[size];
        }
    };
    private static final String DRAWABLE_RESOURCE_ID_KEY = "DRAWABLE_RESOURCE_ID";
    private static final String ITEM_NAME_KEY = "ITEM_KEY";
    public int mDrawableResourceId;
    public String mItemName;

    public CardItem() {
        super();
    }

    public CardItem(final int drawableResourceId, final String itemName) {
        mDrawableResourceId = drawableResourceId;
        mItemName = itemName;
    }

    public CardItem(final Parcel in) {
        readFromParcel(in);
    }

    public static CardItem fromBundle(final Bundle args) {
        if (args == null) {
            throw new NullPointerException(
                    "Bundle passed in fromBundle() method can not be null");
        }

        final CardItem cardItem = new CardItem();

        cardItem.mDrawableResourceId = args.getInt(DRAWABLE_RESOURCE_ID_KEY);
        cardItem.mItemName = args.getString(ITEM_NAME_KEY);

        return cardItem;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mDrawableResourceId);
        dest.writeString(mItemName);
    }

    private void readFromParcel(final Parcel in) {
        mDrawableResourceId = in.readInt();
        mItemName = in.readString();
    }

    public Bundle toBundle() {
        final Bundle args = new Bundle();

        args.putInt(DRAWABLE_RESOURCE_ID_KEY, mDrawableResourceId);
        args.putString(ITEM_NAME_KEY, mItemName);

        return args;
    }
}
