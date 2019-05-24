package com.xpf.aop_example

import android.view.View

/**
 * Created by x-sir on 2019-05-24 :)
 * Function:点击工具类
 */
object ClickUtils {

    /**
     * 最近一次点击的时间
     */
    private var mLastClickTime: Long = 0
    /**
     * 最近一次点击的控件ID
     */
    private var mLastClickViewId: Int = 0

    /**
     * 是否是快速点击
     *
     * @param v              点击的控件
     * @param intervalMillis 时间间期（毫秒）
     * @return true:是，false:不是
     */
    fun isFastDoubleClick(v: View, intervalMillis: Long): Boolean {
        val viewId = v.id
        val time = System.currentTimeMillis()
        val timeInterval = Math.abs(time - mLastClickTime)
        if (timeInterval < intervalMillis && viewId == mLastClickViewId) {
            return true
        } else {
            mLastClickTime = time
            mLastClickViewId = viewId
            return false
        }
    }
}
