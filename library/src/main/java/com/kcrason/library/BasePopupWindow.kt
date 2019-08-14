package com.kcrason.library

import android.content.Context
import android.graphics.drawable.ColorDrawable
import android.view.View
import android.widget.PopupWindow

abstract class BasePopupWindow(context: Context, containerView: View) : PopupWindow(context) {

    var mContextView: View = containerView
    var mContext: Context = context

    init {
        this.setBackgroundDrawable(ColorDrawable(0))
        this.width = this.getWindowWidth()
        this.height = this.getWindowHeight()
        this.contentView = containerView
        this.initPopupWindow()
    }

    abstract fun getWindowHeight(): Int

    abstract fun getWindowWidth(): Int

    abstract fun initPopupWindow()
}