package com.ccc.popupwindow;

import android.util.Log;

/**
 * Date：2018/11/27 14:22
 * <p>
 * author: ghc
 */
public class LogUtil {
    private static final boolean mDebugable = false;

    public static void printLog(String msg) {
        printLog(LogUtil.class.getCanonicalName(), msg);
    }

    public static void printLog(String tag, String msg) {
        printLog(tag, msg, null);
    }

    public static void printLog(String tag, String msg, Throwable t) {
        if (mDebugable) {
            Log.d(tag, msg, t);
        }
    }
}
