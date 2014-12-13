package com.dhimandasgupta.cardrecylerpalette.ui.adapters;

import android.graphics.drawable.BitmapDrawable;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dhimandasgupta.cardrecylerpalette.R;
import com.dhimandasgupta.cardrecylerpalette.model.CardItem;
import com.dhimandasgupta.cardrecylerpalette.ui.views.SquareImageView;

import java.util.List;

/**
 * Created by dhimandasgupta on 12/13/14.
 */
public class CardAdapter extends RecyclerView.Adapter<CardAdapter.CardViewHolder> {
    private List<CardItem> mCardItems;
    private int mColumns;

    public CardAdapter(final List<CardItem> cardItems, final int columns) {
        mCardItems = cardItems;
        mColumns = columns;
    }

    @Override
    public int getItemCount() {
        return mCardItems.size();
    }

    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final LayoutInflater inflater = LayoutInflater
                .from(parent.getContext());
        final View view = inflater.inflate(R.layout.adapter_card, parent, false);
        final int itemWidth = (int) parent.getWidth() / mColumns;
        final ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(itemWidth, itemWidth);
        view.setLayoutParams(params);
        final CardViewHolder cardViewHolder = new CardViewHolder(view);
        return cardViewHolder;
    }

    @Override
    public void onBindViewHolder(final CardViewHolder holder, int position) {
        holder.mImageView
                .setImageResource(mCardItems.get(position).mDrawableResourceId);
        holder.mTextView.setText(mCardItems.get(position).mItemName);

        final BitmapDrawable bitmapDrawable = (BitmapDrawable) holder.mImageView.getDrawable();
        Palette.generateAsync(bitmapDrawable.getBitmap(),
                new Palette.PaletteAsyncListener() {
                    @Override
                    public void onGenerated(Palette palette) {
                        final Palette.Swatch swatch = palette.getDarkMutedSwatch();

                        holder.mTextView.setBackgroundColor(swatch.getRgb());
                        holder.mTextView.setTextColor(swatch.getTitleTextColor());
                    }
                });
    }

    public static class CardViewHolder extends RecyclerView.ViewHolder {
        private SquareImageView mImageView;
        private TextView mTextView;

        public CardViewHolder(View itemView) {
            super(itemView);

            mImageView = (SquareImageView) itemView
                    .findViewById(R.id.adapter_card_square_image_view);
            mTextView = (TextView) itemView
                    .findViewById(R.id.adapter_card_text_view);
        }

        @Override
        public String toString() {
            return mImageView.toString() + "X" + mTextView.toString();
        }
    }
}
