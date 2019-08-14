# MotionEventPopupWindow
类似微信根据长按位置弹出的PopupWindow，自动根据左右上下边距调整显示的方向。

### 简单使用(纯微信效果)

1、在需要显示的Activity重写dispatchTouchEvent，并设置一个变量用于保存motionEvent。

```
override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        this.mMotionEvent = ev
        return super.dispatchTouchEvent(ev)
    }
```

2、给需要触发显示popupwindow的view设置单击或长按时显示popupwindow，显示popupwindow时，将motionEvent变量传递进去。

```
txtCenterClick.setOnLongClickListener {
            CommonMotionEventPopupWindow(this)
                .showOptions(arrayListOf("复制", "粘贴", "发送", "翻译", "发送给好友"))
                .setOnClickItemOptionsListener { position, optionName ->
                    Toast.makeText(this, "this is $position , optionName:$optionName", Toast.LENGTH_SHORT).show()
                }
                .showMotionEventPopupWindow(it, mMotionEvent)
            return@setOnLongClickListener true
        }
```
