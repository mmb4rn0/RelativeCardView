package com.mmbarno.relativecard;

import android.content.Context;
import android.content.res.ColorStateList;
import android.support.annotation.Nullable;

/**
 * Created by mmbarno on 10/25/17.
 * Email: manzur.mehedi@gagagugu.com
 */

public interface RelativeCardImpl {
    void initialize(RelativeCardViewDelegate cardView, Context context, ColorStateList backgroundColor,
                    float radius, float elevation, float maxElevation);

    void setRadius(RelativeCardViewDelegate cardView, float radius);

    float getRadius(RelativeCardViewDelegate cardView);

    void setElevation(RelativeCardViewDelegate cardView, float elevation);

    float getElevation(RelativeCardViewDelegate cardView);

    void initStatic();

    void setMaxElevation(RelativeCardViewDelegate cardView, float maxElevation);

    float getMaxElevation(RelativeCardViewDelegate cardView);

    float getMinWidth(RelativeCardViewDelegate cardView);

    float getMinHeight(RelativeCardViewDelegate cardView);

    void updatePadding(RelativeCardViewDelegate cardView);

    void onCompatPaddingChanged(RelativeCardViewDelegate cardView);

    void onPreventCornerOverlapChanged(RelativeCardViewDelegate cardView);

    void setBackgroundColor(RelativeCardViewDelegate cardView, @Nullable ColorStateList color);

    ColorStateList getBackgroundColor(RelativeCardViewDelegate cardView);

}
