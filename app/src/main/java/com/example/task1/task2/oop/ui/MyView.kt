package com.example.task1.task2.oop.ui

import android.content.Context
import android.util.AttributeSet
import android.view.View

//trong 1 lớp mà ko có Constructor chính thì thì các constructor phụ phải khởi tạo cơ sở bằng super
class MyView: View {
    constructor(context: Context):super(context)
    constructor(context: Context, attrs: AttributeSet):super(context,attrs)
}
