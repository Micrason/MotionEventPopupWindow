package com.kcrason.library

import android.content.Context

/**
 * @author KCrason
 * @date 2019/8/14 9:56
 * @description
 */

object Utils {


    fun dip2px(context: Context, value: Int): Int {
        return (value * context.resources.displayMetrics.density).toInt()
    }


    fun statusBarHeight(context: Context): Int {
        val resources = context.resources
        val resourceId = resources.getIdentifier("status_bar_height", "dimen", "android")
        return resources.getDimensionPixelSize(resourceId)
    }
}
