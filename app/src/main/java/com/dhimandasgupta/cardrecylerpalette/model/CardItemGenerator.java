package com.dhimandasgupta.cardrecylerpalette.model;

import com.dhimandasgupta.cardrecylerpalette.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dhimandasgupta on 12/13/14.
 */
public class CardItemGenerator {
    public static List<CardItem> getCardItems() {
        final List<CardItem> cardItems = new ArrayList<CardItem>();

        for (int i = 0; i < 100; i++) {
            final int reminder = i % 5;

            switch (reminder) {
                case 0:
                    cardItems.add(new CardItem(R.drawable.christ_01, "This is item "
                            + (i + 1)));
                    break;

                case 1:
                    cardItems.add(new CardItem(R.drawable.christ_02, "This is item "
                            + (i + 1)));
                    break;

                case 2:
                    cardItems.add(new CardItem(R.drawable.holi_color, "This is item "
                            + (i + 1)));
                    break;

                case 3:
                    cardItems.add(new CardItem(R.drawable.golden_gate_bridge, "This is item "
                            + (i + 1)));
                    break;

                case 4:
                    cardItems.add(new CardItem(R.drawable.holi_color, "This is item "
                            + (i + 1)));
                    break;
            }
        }

        return cardItems;
    }
}
