package com.khmoon.recyclerview_swipe3.RECYCLERVIEW;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.core.view.GestureDetectorCompat;
import androidx.recyclerview.widget.RecyclerView;

public class OnSwipeTouchListener implements RecyclerView.OnItemTouchListener {
    private static final int SWIPE_MIN_DISTANCE = 120;
    private static final int SWIPE_THRESHOLD_VELOCITY = 200;
    private static final int SWIPE_MAX_OFF_PATH = 250;
    private OnTouchActionListener mOnTouchActionListener;
    private GestureDetectorCompat mGestureDetector;


    public static interface OnTouchActionListener {
        public void onLeftSwipe(View view, int position);
        public void onRightSwipe(View view, int position);
        public void onClick(View view, int position);
        public void onLongClick(View view, int position);
        public void onDoubleClick(View view, int position);
    }

    public OnSwipeTouchListener(Context context, final RecyclerView rv, OnTouchActionListener onTouchActionListener) {
        mOnTouchActionListener = onTouchActionListener;
        mGestureDetector = new GestureDetectorCompat(context, new GestureDetector.SimpleOnGestureListener() {
            @Override
            public void onLongPress(MotionEvent e) {
                View child = rv.findChildViewUnder(e.getX(), e.getY());
                int childPostion = rv.getChildPosition(child);
                mOnTouchActionListener.onLongClick(child, childPostion);

            }

            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                try {
                    if (Math.abs(e1.getY() - e2.getY()) > SWIPE_MAX_OFF_PATH) {
                        return false;
                    }

                    // Find the item view that was swiped based on the coordinates
                    View child = rv.findChildViewUnder(e1.getX(), e1.getY());
                    int childPosition = rv.getChildPosition(child);

                    // right to left swipe
                    if (e1.getX() - e2.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {

                        if (mOnTouchActionListener != null && child != null) {
                            mOnTouchActionListener.onLeftSwipe(child, childPosition);
                        }

                    } else if (e2.getX() - e1.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
                        if (mOnTouchActionListener != null && child != null) {
                            mOnTouchActionListener.onRightSwipe(child, childPosition);
                        }
                    }
                } catch (Exception e) {
                    // nothing
                }

                return false;
            }

            @Override
            public boolean onDoubleTap(MotionEvent e) {
                View child = rv.findChildViewUnder(e.getX(), e.getY());
                int childPostion = rv.getChildPosition(child);
                mOnTouchActionListener.onDoubleClick(child, childPostion);

                return false;
            }

            @Override
            public boolean onSingleTapConfirmed(MotionEvent e) {
                View child = rv.findChildViewUnder(e.getX(), e.getY());
                int childPostion = rv.getChildPosition(child);
                if(childPostion >= 0) {
                    mOnTouchActionListener.onClick(child, childPostion);
                    return false;
                } else {
                    return true;
                }
            }
        });
    }

    @Override
    public boolean onInterceptTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {
        mGestureDetector.onTouchEvent(e);
        return false;
    }

    @Override
    public void onTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {

    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }
}
