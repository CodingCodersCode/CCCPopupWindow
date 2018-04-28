package com.ccc.popupwindow;

import android.view.MotionEvent;
import android.view.View;

import bakerj.backgrounddarkpopupwindow.BackgroundDarkPopupWindow;

/**
 * Date：2018/4/28 09:52
 * <p>
 * author: CodingCodersCode
 */
public class CCCPopupWindow extends BackgroundDarkPopupWindow {
    private boolean enableOutsideCancel = true;

    public CCCPopupWindow(View contentView, int width, int height) {
        super(contentView, width, height);

        onInitOutsideEventInterceptor();

    }

    private void onInitOutsideEventInterceptor() {
        try {
            onInitOutsideTouchEventInterceptor();
        } catch (Exception e) {

        }
    }

    /**
     * 初始化6.0以上版本外部点击事件监听
     */
    private void onInitOutsideTouchEventInterceptor() {
        try {
            this.setTouchInterceptor(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {

                    if (isEnableOutsideCancel()) {
                        return false;
                    }

                    final int x = (int) event.getX();
                    final int y = (int) event.getY();
                    final int contentViewLeft = getContentView().getLeft();
                    final int contentViewRight = getContentView().getRight();
                    final int contentViewTop = getContentView().getTop();
                    final int contentViewBottom = getContentView().getBottom();


                    if ((event.getAction() == MotionEvent.ACTION_DOWN) && ((x < contentViewLeft) || (x >= contentViewRight) || (y < contentViewTop) || (y >= contentViewBottom))) {
                        //消费事件
                        return true;
                    } else if (event.getAction() == MotionEvent.ACTION_OUTSIDE) {
                        return true;
                    }

                    return false;
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isEnableOutsideCancel() {
        return enableOutsideCancel;
    }

    public void setEnableOutsideCancel(boolean enableOutsideCancel) {
        this.enableOutsideCancel = enableOutsideCancel;
    }
}
