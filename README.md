# MotionEventPopupWindow
类似微信根据长按位置弹出的PopupWindow，自动根据左右上下边距调整显示的方向。[APK体验包](https://github.com/KCrason/MotionEventPopupWindow/blob/master/apk/app-debug.apk)

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

### 自定义界面的Popupwindow

1、创建新类继承BaseMotionEventPopupWindow即可。

```
class CustomMotionEventPopupWindow(context: Context) :BaseMotionEventPopupWindow(context) {
    override fun init() {
        //初始化一些参数
    }

    override fun getContainerLayoutId(): Int {
        //返回你需要显示的popupwindow xml
    }

    override fun getRealPopupWindowHeight(): Int {
        //返回popupwindow真实的高度，该高度在计算显示popupwindow的位置时需要用到，必须保证其准确性。
    }

    override fun getWindowWidth(): Int {
        //返回popupwindow的宽度，一般使用固定的值即可。
    }
}

```
2、在需要显示的地方调用``` showMotionEventPopupWindow(anchor: View?, currentMotionEvent: MotionEvent?) ```方法显示popupwindow

### 效果展示

<img width="270" height="480" src="https://github.com/KCrason/MotionEventPopupWindow/blob/master/screenshot/2%20(1).jpg"/><img width="270" height="480" src="https://github.com/KCrason/MotionEventPopupWindow/blob/master/screenshot/2%20(2).jpg"/><img width="270" height="480" src="https://github.com/KCrason/MotionEventPopupWindow/blob/master/screenshot/2%20(3).jpg"/>


