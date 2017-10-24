package com.mmbarno.relativecard;

import android.graphics.drawable.Drawable;
import android.view.View;

/**
 * Created by mmbarno on 10/25/17.
 * Email: manzur.mehedi@gagagugu.com
 */

public interface RelativeCardViewDelegate {
    void setCardBackground(Drawable drawable);
    Drawable getCardBackground();
    boolean getUseCompatPadding();
    boolean getPreventCornerOverlap();
    void setShadowPadding(int left, int top, int right, int bottom);
    void setMinWidthHeightInternal(int width, int height);
    View getCardView();
}
