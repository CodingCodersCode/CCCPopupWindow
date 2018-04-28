package com.ccc.popupwindow.demo;

import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.ccc.popupwindow.CCCPopupWindow;

public class MainActivity extends AppCompatActivity {

    private TextView tv_btn_only_backkey;
    private TextView tv_btn_outside_and_backkey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.tv_btn_only_backkey = (TextView) findViewById(R.id.tv_btn_only_backkey);
        this.tv_btn_only_backkey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupWindow(tv_btn_only_backkey, false);
            }
        });

        this.tv_btn_outside_and_backkey = (TextView) findViewById(R.id.tv_btn_outside_and_backkey);
        this.tv_btn_outside_and_backkey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupWindow(tv_btn_outside_and_backkey, true);
            }
        });
    }

    private void showPopupWindow(View anchorView, boolean outside) {

        View view = LayoutInflater.from(this).inflate(R.layout.layout_popup, null);

        //创建弹窗PopupWindow
        CCCPopupWindow popupWindow = createPopupWindowWithView(view, outside);
        if (popupWindow == null) {
            return;
        }

        popupWindow.darkBelow(anchorView);
        //popupWindow.setWidth(1200);
        popupWindow.showAsDropDown(anchorView);

    }

    private CCCPopupWindow createPopupWindowWithView(View view, boolean cancelOutside) {
        CCCPopupWindow popupWindow = null;
        try {
            popupWindow = new CCCPopupWindow(view, WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
            popupWindow.getContentView().measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);
            popupWindow.setFocusable(true);
            popupWindow.setBackgroundDrawable(new BitmapDrawable());
            popupWindow.setAnimationStyle(R.style.Animation_Popup);
            popupWindow.setDarkStyle(-1);
            popupWindow.setDarkColor(Color.parseColor("#21000000"));
            popupWindow.resetDarkPosition();

            popupWindow.setEnableOutsideCancel(cancelOutside);


        } catch (Exception e) {
            e.printStackTrace();
        }
        return popupWindow;
    }

}
