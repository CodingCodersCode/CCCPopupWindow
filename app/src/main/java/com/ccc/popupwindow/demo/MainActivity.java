package com.ccc.popupwindow.demo;

import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ccc.popupwindow.CCCPopupWindowCCC;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tv_btn_only_backkey;
    private TextView tv_btn_outside_and_backkey;

    private TextView tv_1;

    private LinearLayout ll_1;
    private View view_1;

    private LinearLayout ll_2;
    private View view_2;

    LayoutInflater layoutInflater;

    private LinearLayout ll_root;

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

        this.tv_1 = (TextView) findViewById(R.id.tv_1);
        this.tv_1.setOnClickListener(this);

        this.ll_1 = (LinearLayout) findViewById(R.id.ll_1);
        this.ll_1.setOnClickListener(this);

        this.ll_2 = (LinearLayout) findViewById(R.id.ll_2);
        this.ll_2.setOnClickListener(this);

        this.view_1 = (View) findViewById(R.id.view_1);
        this.view_2 = (View) findViewById(R.id.view_2);

        layoutInflater = LayoutInflater.from(this);

        this.ll_root = (LinearLayout) findViewById(R.id.ll_root);
        this.ll_root.setOnClickListener(this);
    }

    private void showPopupWindow(View anchorView, boolean outside) {

        View view = LayoutInflater.from(this).inflate(R.layout.layout_popup, null);

        //创建弹窗PopupWindow
        CCCPopupWindowCCC popupWindow = createPopupWindowWithView(view, outside);
        if (popupWindow == null) {
            return;
        }

        popupWindow.darkBelow(anchorView);
        //popupWindow.setWidth(1200);
        popupWindow.showAsDropDown(anchorView);
    }

    private void printLog(String msg) {
        Log.e(getClass().getCanonicalName(), msg);
    }

    @Override
    public void onClick(View v) {
        if (v == this.tv_1) {
            this.onShowPopupWindow1();
        } else if (v == this.ll_1) {
            this.onShowPopupWindow2();
        } else if (v == this.ll_2) {
            this.onShowPopupWindow3();
        } else if (v == this.ll_root) {
            Toast.makeText(this, "点击了背景", Toast.LENGTH_SHORT).show();
        }
    }

    private void onShowPopupWindow1() {
        View view = layoutInflater.inflate(R.layout.layout_user_avatar_source_select, null);

        PopupWindowUtil popupWindowUtil = new PopupWindowUtil();
        popupWindowUtil.createPopupWindowWithView(this.tv_1, view, getFilledView(), this);

    }

    private void onShowPopupWindow2() {
        View view = layoutInflater.inflate(R.layout.layout_user_avatar_source_select, null);

        PopupWindowUtil popupWindowUtil = new PopupWindowUtil();
        popupWindowUtil.createPopupWindowWithView(this.view_1, view, getFilledView(), this);
    }

    private void onShowPopupWindow3() {
        View view = layoutInflater.inflate(R.layout.layout_user_avatar_source_select, null);

        PopupWindowUtil popupWindowUtil = new PopupWindowUtil();
        popupWindowUtil.createPopupWindowWithView(this.view_2, view, getFilledView(), this);
    }

    private View getFilledView() {
        return this.getWindow().getDecorView();
    }

    private CCCPopupWindowCCC createPopupWindowWithView(View view, boolean cancelOutside) {
        CCCPopupWindowCCC popupWindow = null;
        try {
            popupWindow = new CCCPopupWindowCCC(view, WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
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
