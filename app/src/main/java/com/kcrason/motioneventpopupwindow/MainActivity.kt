package com.kcrason.motioneventpopupwindow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.widget.Toast
import com.kcrason.library.CommonMotionEventPopupWindow
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var mMotionEvent: MotionEvent? = null

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        this.mMotionEvent = ev
        return super.dispatchTouchEvent(ev)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        txtCenterClick.setOnLongClickListener {
            CommonMotionEventPopupWindow(this)
                .showOptions(arrayListOf("复制", "粘贴", "发送", "翻译", "发送给好友"))
                .setOnClickItemOptionsListener { position, optionName ->
                    Toast.makeText(this, "this is $position , optionName:$optionName", Toast.LENGTH_SHORT).show()
                }
                .showMotionEventPopupWindow(it, mMotionEvent)
            return@setOnLongClickListener true
        }

        txtTopClick.setOnLongClickListener {
            CommonMotionEventPopupWindow(this)
                .showOptions(arrayListOf("复制", "粘贴", "发送", "翻译", "发送给好友"))
                .setOnClickItemOptionsListener { position, optionName ->
                    Toast.makeText(this, "this is $position , optionName:$optionName", Toast.LENGTH_SHORT).show()
                }
                .showMotionEventPopupWindow(it, mMotionEvent)
            return@setOnLongClickListener true
        }

        txtBottomClick.setOnLongClickListener {
            CommonMotionEventPopupWindow(this)
                .showOptions(arrayListOf("复制", "粘贴", "发送", "翻译", "发送给好友"))
                .setOnClickItemOptionsListener { position, optionName ->
                    Toast.makeText(this, "this is $position , optionName:$optionName", Toast.LENGTH_SHORT).show()
                }
                .showMotionEventPopupWindow(it, mMotionEvent)
            return@setOnLongClickListener true
        }
    }
}
