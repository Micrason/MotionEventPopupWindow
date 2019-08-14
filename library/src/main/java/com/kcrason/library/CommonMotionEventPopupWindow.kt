package com.kcrason.library

import android.content.Context
import android.widget.ListView

/**
 * @author KCrason
 * @date 2019/8/14 9:52
 * @description
 */
class CommonMotionEventPopupWindow(context: Context) :
    BaseMotionEventPopupWindow(context) {

    override fun getRealPopupWindowHeight(): Int {
        return (mCommonOptionsAdapter?.count ?: 0) * Utils.dip2px(mContext, 48)
    }

    override fun getContainerLayoutId(): Int {
        return R.layout.popup_window_motionevent_view
    }

    override fun init() {
        this.isOutsideTouchable = true
        val listView = this.mContextView.findViewById<ListView>(R.id.listView)
        mCommonOptionsAdapter = CommonOptionsAdapter()
        listView.adapter = mCommonOptionsAdapter

        listView.setOnItemClickListener { _, _, i, _ ->
            dismiss()
            mOnClickItemOptionsListener?.invoke(i, mCommonOptionsAdapter?.getItem(i) ?: "")
        }
    }

    private var mCommonOptionsAdapter: CommonOptionsAdapter? = null

    private var mOnClickItemOptionsListener: ((position: Int, optionName: String) -> Unit)? = null


    override fun getWindowWidth(): Int {
        return (150 * mContext.resources.displayMetrics.density).toInt()
    }

    fun showOptions(options: List<String>): CommonMotionEventPopupWindow {
        this.mCommonOptionsAdapter?.showOptions(options)
        return this
    }

    fun setOnClickItemOptionsListener(onClickItemOptionsListener: ((position: Int, optionName: String) -> Unit)): CommonMotionEventPopupWindow {
        this.mOnClickItemOptionsListener = onClickItemOptionsListener
        return this
    }
}