package com.ccc.popupwindow.demo;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;

import com.ccc.popupwindow.CCCPopupWindowCCC;

/**
 * Date：2018/11/26 16:25
 * <p>
 * author: CodingCodersCode
 */
public class PopupWindowUtil {

    public CCCPopupWindowCCC createPopupWindowWithView(View anchorView, View view, View drakFillView, Context context) {
        CCCPopupWindowCCC popupWindow = null;
        try {
            popupWindow = new CCCPopupWindowCCC(view, WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
            popupWindow.getContentView().measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);
            popupWindow.setFocusable(false);
            popupWindow.setBackgroundDrawable(new BitmapDrawable());
            popupWindow.setAnimationStyle(R.style.Animation_Search_Rule_Select);//R.style.Animation_Search_Rule_Select
            popupWindow.setDarkStyle(-1);
            popupWindow.setDarkColor(Color.parseColor("#21000000"));
            popupWindow.resetDarkPosition();

            popupWindow.setOutsideTouchable(true);
            popupWindow.setEnableOutsideCancel(true);

            popupWindow.setOnDismissListener(new InnerQuickRuleSelectLayoutDismissListener(this));

            if (drakFillView != null) {
                popupWindow.drakFillView(drakFillView);
            }

            popupWindow.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

            popupWindow.darkBelow(anchorView);
            popupWindow.showAsDropDown(anchorView);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return popupWindow;
    }



    public static class InnerQuickRuleSelectLayoutDismissListener implements PopupWindow.OnDismissListener {

        private PopupWindowUtil outerPresenter;

        public InnerQuickRuleSelectLayoutDismissListener(PopupWindowUtil outerPresenter) {
            this.outerPresenter = outerPresenter;
        }

        @Override
        public void onDismiss() {
            if (this.outerPresenter != null) {
                this.outerPresenter.onInnerQuickRuleSelectLayoutDismiss();
            }
        }
    }

    /**
     * 检索条件隐藏事件监听器
     */
    private void onInnerQuickRuleSelectLayoutDismiss() {

    }

}
