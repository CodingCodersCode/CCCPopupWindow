package com.ccc.popupwindow;

import android.view.MotionEvent;
import android.view.View;

//import bakerj.backgrounddarkpopupwindow.CCCBackgroundDarkPopupWindow;

/**
 * Date：2018/4/28 09:52
 * <p>
 * author: CodingCodersCode
 */
public class CCCPopupWindowCCC extends CCCBackgroundDarkPopupWindow {
    private boolean enableOutsideCancel = true;
    private boolean mDebugable = false;

    public CCCPopupWindowCCC(View contentView, int width, int height) {
        super(contentView, width, height);
        onInitOutsideEventInterceptor();
        /*
        if (mDebugable) {
            this.mDarkView.setClickable(true);
            this.mDarkView.setFocusable(true);
            this.mDarkView.setFocusableInTouchMode(true);
            this.mDarkView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    LogUtil.printLog("mDarkView[action:OnClickListener]");
                }
            });
            this.mDarkView.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    LogUtil.printLog("mDarkView[action:OnTouchListener]");
                    return false;
                }
            });

            this.mDarkView.getRootView().setFocusableInTouchMode(true);
            this.mDarkView.getRootView().setFocusable(true);
            this.mDarkView.getRootView().setClickable(true);
            this.mDarkView.getRootView().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    LogUtil.printLog("mDarkView.getRootView()[action:OnClickListener]");
                }
            });
            this.mDarkView.getRootView().setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    LogUtil.printLog("mDarkView.getRootView()[action:OnTouchListener]");
                    return false;
                }
            });
        }
        */
    }

    private void onInitOutsideEventInterceptor() {
        onInitOutsideTouchEventInterceptor();
    }

    /**
     * 初始化6.0以上版本外部点击事件监听
     */
    private void onInitOutsideTouchEventInterceptor() {
        this.setTouchInterceptor(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (isEnableOutsideCancel()) {
                    dismiss();
                    return true;
                }

                final int x = (int) event.getX();
                final int y = (int) event.getY();
                final int contentViewLeft = getContentView().getLeft();
                final int contentViewRight = getContentView().getRight();
                final int contentViewTop = getContentView().getTop();
                final int contentViewBottom = getContentView().getBottom();

                if ((event.getAction() == MotionEvent.ACTION_DOWN) && ((x < contentViewLeft) || (x >= contentViewRight) || (y < contentViewTop) || (y >= contentViewBottom))) {
                    //消费事件
                    dismiss();
                    return true;
                } else if (event.getAction() == MotionEvent.ACTION_OUTSIDE) {
                    dismiss();
                    return true;
                }
                return false;
            }
        });
    }

    public boolean isEnableOutsideCancel() {
        return enableOutsideCancel;
    }

    public void setEnableOutsideCancel(boolean enableOutsideCancel) {
        this.enableOutsideCancel = enableOutsideCancel;
    }
}
