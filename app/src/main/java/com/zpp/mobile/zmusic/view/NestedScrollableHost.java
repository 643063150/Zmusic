package com.zpp.mobile.zmusic.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager2.widget.ViewPager2;

import com.stx.xhb.androidx.XBanner;

/**
 * @ProjectName: MyMusic
 * @Package: com.zpp.mobile.mymusic.view
 * @ClassName: NestedScrollableHost
 * @Description:
 * @Author: zpp
 * @CreateDate: 2023/3/8 10:24
 * @UpdateUser:
 * @UpdateDate: 2023/3/8 10:24
 * @UpdateRemark:
 */
public class NestedScrollableHost extends FrameLayout {
    private int touchSlop = 0;
    private float initialX = 0f;
    private float initialY = 0f;

    public NestedScrollableHost(@NonNull Context context) {
        super(context);
        init(context);
    }

    public NestedScrollableHost(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(@NonNull Context context) {
        touchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @Nullable
    private ViewPager2 getParentViewPager() {
        ViewParent v = getParent();
        while (v != null && !(v instanceof ViewPager2)) {
            v = v.getParent();
        }
        return (ViewPager2) v;
    }

    @Nullable
    private View getChild() {
        if (getChildCount() > 0) {
            if (getChildAt(0) instanceof XBanner) {
                return ((XBanner) getChildAt(0)).getViewPager();
            } else {
                return getChildAt(0);
            }
        } else {
            return null;
        }
    }

    private boolean canChildScroll(int orientation, float delta) {
        int direction = -(int) delta;
        View child = getChild();
        boolean result;
        switch (orientation) {
            case 0:
                result = child != null && child.canScrollHorizontally(direction);
                break;
            case 1:
                result = child != null && child.canScrollVertically(direction);
                break;
            default:
                throw new IllegalArgumentException();
        }
        return result;
    }

    @Override
    public boolean onInterceptTouchEvent(@NonNull MotionEvent e) {
        handleInterceptTouchEvent(e);
        return super.onInterceptTouchEvent(e);
    }

    private void handleInterceptTouchEvent(@NonNull MotionEvent e) {
        ViewPager2 parentViewPager = getParentViewPager();
        if (parentViewPager == null) {
            return;
        }

        int orientation = parentViewPager.getOrientation();

        if (!canChildScroll(orientation, -1f) && !canChildScroll(orientation, 1f)) {
            return;
        }

        if (e.getAction() == MotionEvent.ACTION_DOWN) {
            initialX = e.getX();
            initialY = e.getY();
            getParent().requestDisallowInterceptTouchEvent(true);
        } else if (e.getAction() == MotionEvent.ACTION_MOVE) {
            float dx = e.getX() - initialX;
            float dy = e.getY() - initialY;
            boolean isVpHorizontal = orientation == ViewPager2.ORIENTATION_HORIZONTAL;

            float scaledDx = Math.abs(dx) * (isVpHorizontal ? .5f : 1f);
            float scaledDy = Math.abs(dy) * (isVpHorizontal ? 1f : .5f);

            if (scaledDx > touchSlop || scaledDy > touchSlop) {
                if (isVpHorizontal == (scaledDy > scaledDx)) {
                    getParent().requestDisallowInterceptTouchEvent(false);
                } else {
                    if (canChildScroll(orientation, isVpHorizontal ? dx : dy)) {
                        getParent().requestDisallowInterceptTouchEvent(true);
                    } else {
                        getParent().requestDisallowInterceptTouchEvent(false);
                    }
                }
            }
        }
    }
}
