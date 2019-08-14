package com.kcrason.library

import android.content.Context
import android.view.*
import com.dd.ShadowLayout

/**
 * @author KCrason
 * @date 2019/8/14 11:00
 * @description
 */
abstract class BaseMotionEventPopupWindow(context: Context) :
    BaseCommonPopupWindow(context, R.layout.popup_window_base_motionevent_view) {

    final override fun initPopupWindow() {
        val shadowLayout = this.mContextView.findViewById<ShadowLayout>(R.id.shadowLayout)
        shadowLayout.addView(
            LayoutInflater.from(mContext)
                .inflate(getContainerLayoutId(), shadowLayout, false)
        )
        init()
    }

    abstract fun init()

    abstract fun getContainerLayoutId(): Int

    abstract fun getRealPopupWindowHeight(): Int

    override fun getWindowHeight(): Int {
        return WindowManager.LayoutParams.WRAP_CONTENT
    }

    fun showMotionEventPopupWindow(anchor: View?, currentMotionEvent: MotionEvent?) {
        if (anchor != null && currentMotionEvent != null) {

            val popupWindowHeight = getRealPopupWindowHeight()
            val popupWindowWidth = getWindowWidth()

            val screenWidth = mContext.resources.displayMetrics.widthPixels
            val statusBarHeight = Utils.statusBarHeight(mContext)

            val curMotionX = currentMotionEvent.x
            val curMotionY = currentMotionEvent.y

            val offsetX: Int
            val offsetY: Int

            val defaultX = Utils.dip2px(mContext, 10)
            val defaultY = Utils.dip2px(mContext, 10)

            if (screenWidth - curMotionX > popupWindowWidth) {
                offsetX = curMotionX.toInt() - defaultX
                if (curMotionY - statusBarHeight > popupWindowHeight) {
                    this.animationStyle = R.style.MotionEventPopupWindowTopLeftAnimation
                    offsetY = (curMotionY - popupWindowHeight - defaultY).toInt()
                } else {
                    this.animationStyle = R.style.MotionEventPopupWindowBottomLeftAnimation
                    offsetY = curMotionY.toInt() + defaultY
                }
                showAtLocation(
                    anchor,
                    Gravity.NO_GRAVITY,
                    offsetX,
                    offsetY
                )
            } else {
                offsetX = (screenWidth - curMotionX - defaultX).toInt()
                if (curMotionY - statusBarHeight > popupWindowHeight) {
                    this.animationStyle = R.style.MotionEventPopupWindowTopRightAnimation
                    offsetY = (curMotionY - popupWindowHeight - defaultY).toInt()
                } else {
                    this.animationStyle = R.style.MotionEventPopupWindowBottomRightAnimation
                    offsetY = curMotionY.toInt() + defaultY
                }
                showAtLocation(
                    anchor,
                    Gravity.END or Gravity.TOP,
                    offsetX,
                    offsetY
                )
            }
        }
    }
}