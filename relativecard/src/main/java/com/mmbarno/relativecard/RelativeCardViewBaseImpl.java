package com.mmbarno.relativecard;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;

/**
 * Created by mmbarno on 10/25/17.
 * Email: manzur.mehedi@gagagugu.com
 */

class RelativeCardViewBaseImpl implements RelativeCardImpl {
    private final RectF mCornerRect = new RectF();

    @Override
    public void initStatic() {
        // Draws a round rect using 7 draw operations. This is faster than using
        // canvas.drawRoundRect before JBMR1 because API 11-16 used alpha mask textures to draw
        // shapes.
        RoundRectDrawableWithShadow.sRoundRectHelper = new RoundRectDrawableWithShadow.RoundRectHelper() {
                    @Override
                    public void drawRoundRect(Canvas canvas, RectF bounds, float cornerRadius,
                                              Paint paint) {
                        final float twoRadius = cornerRadius * 2;
                        final float innerWidth = bounds.width() - twoRadius - 1;
                        final float innerHeight = bounds.height() - twoRadius - 1;
                        if (cornerRadius >= 1f) {
                            // increment corner radius to account for half pixels.
                            float roundedCornerRadius = cornerRadius + .5f;
                            mCornerRect.set(-roundedCornerRadius, -roundedCornerRadius, roundedCornerRadius,
                                    roundedCornerRadius);
                            int saved = canvas.save();
                            canvas.translate(bounds.left + roundedCornerRadius,
                                    bounds.top + roundedCornerRadius);
                            canvas.drawArc(mCornerRect, 180, 90, true, paint);
                            canvas.translate(innerWidth, 0);
                            canvas.rotate(90);
                            canvas.drawArc(mCornerRect, 180, 90, true, paint);
                            canvas.translate(innerHeight, 0);
                            canvas.rotate(90);
                            canvas.drawArc(mCornerRect, 180, 90, true, paint);
                            canvas.translate(innerWidth, 0);
                            canvas.rotate(90);
                            canvas.drawArc(mCornerRect, 180, 90, true, paint);
                            canvas.restoreToCount(saved);
                            //draw top and bottom pieces
                            canvas.drawRect(bounds.left + roundedCornerRadius - 1f, bounds.top,
                                    bounds.right - roundedCornerRadius + 1f,
                                    bounds.top + roundedCornerRadius, paint);

                            canvas.drawRect(bounds.left + roundedCornerRadius - 1f,
                                    bounds.bottom - roundedCornerRadius,
                                    bounds.right - roundedCornerRadius + 1f, bounds.bottom, paint);
                        }
                        // center
                        canvas.drawRect(bounds.left, bounds.top + cornerRadius,
                                bounds.right, bounds.bottom - cornerRadius , paint);
                    }
                };
    }

    @Override
    public void initialize(RelativeCardViewDelegate cardView, Context context,
                           ColorStateList backgroundColor, float radius, float elevation, float maxElevation) {
        RoundRectDrawableWithShadow background = createBackground(context, backgroundColor, radius, elevation, maxElevation);
        background.setAddPaddingForCorners(cardView.getPreventCornerOverlap());
        cardView.setCardBackground(background);
        updatePadding(cardView);
    }

    private RoundRectDrawableWithShadow createBackground(Context context,
                                                                                   ColorStateList backgroundColor, float radius, float elevation,
                                                                                   float maxElevation) {
        return new RoundRectDrawableWithShadow(context.getResources(), backgroundColor, radius,
                elevation, maxElevation);
    }

    @Override
    public void updatePadding(RelativeCardViewDelegate cardView) {
        Rect shadowPadding = new Rect();
        getShadowBackground(cardView).getMaxShadowAndCornerPadding(shadowPadding);
        cardView.setMinWidthHeightInternal((int) Math.ceil(getMinWidth(cardView)),
                (int) Math.ceil(getMinHeight(cardView)));
        cardView.setShadowPadding(shadowPadding.left, shadowPadding.top,
                shadowPadding.right, shadowPadding.bottom);
    }

    @Override
    public void onCompatPaddingChanged(RelativeCardViewDelegate cardView) {
        // NO OP
    }

    @Override
    public void onPreventCornerOverlapChanged(RelativeCardViewDelegate cardView) {
        getShadowBackground(cardView).setAddPaddingForCorners(cardView.getPreventCornerOverlap());
        updatePadding(cardView);
    }

    @Override
    public void setBackgroundColor(RelativeCardViewDelegate cardView, @Nullable ColorStateList color) {
        getShadowBackground(cardView).setColor(color);
    }

    @Override
    public ColorStateList getBackgroundColor(RelativeCardViewDelegate cardView) {
        return getShadowBackground(cardView).getColor();
    }

    @Override
    public void setRadius(RelativeCardViewDelegate cardView, float radius) {
        getShadowBackground(cardView).setCornerRadius(radius);
        updatePadding(cardView);
    }

    @Override
    public float getRadius(RelativeCardViewDelegate cardView) {
        return getShadowBackground(cardView).getCornerRadius();
    }

    @Override
    public void setElevation(RelativeCardViewDelegate cardView, float elevation) {
        getShadowBackground(cardView).setShadowSize(elevation);
    }

    @Override
    public float getElevation(RelativeCardViewDelegate cardView) {
        return getShadowBackground(cardView).getShadowSize();
    }

    @Override
    public void setMaxElevation(RelativeCardViewDelegate cardView, float maxElevation) {
        getShadowBackground(cardView).setMaxShadowSize(maxElevation);
        updatePadding(cardView);
    }

    @Override
    public float getMaxElevation(RelativeCardViewDelegate cardView) {
        return getShadowBackground(cardView).getMaxShadowSize();
    }

    @Override
    public float getMinWidth(RelativeCardViewDelegate cardView) {
        return getShadowBackground(cardView).getMinWidth();
    }

    @Override
    public float getMinHeight(RelativeCardViewDelegate cardView) {
        return getShadowBackground(cardView).getMinHeight();
    }

    private RoundRectDrawableWithShadow getShadowBackground(RelativeCardViewDelegate cardView) {
        return ((RoundRectDrawableWithShadow) cardView.getCardBackground());
    }

}
