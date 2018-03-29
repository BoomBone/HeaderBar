package com.dexin.headerbar

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import kotlinx.android.synthetic.main.view_head_bar.view.*

/**
 * @author Ting
 * @date 2018/3/28
 */
class HeaderBar @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {
    private var isShowBack = true
    private var titleText: String? = null
    private var isShowSearch = false

    init {
        //与资源文件关联
        val typeArray = context.obtainStyledAttributes(attrs,R.styleable.HeaderBar)

        isShowBack = typeArray.getBoolean(R.styleable.HeaderBar_isShowBack, true)
        titleText = typeArray.getString(R.styleable.HeaderBar_titleText)
        isShowSearch = typeArray.getBoolean(R.styleable.HeaderBar_isShowSearch, false)

        initView()
        typeArray.recycle()
    }

    private fun initView() {
        View.inflate(context, R.layout.view_head_bar, this)

        mBack.visibility = if (isShowBack) View.VISIBLE else View.GONE

        titleText?.let {
            mTitle.text = it
        }

        mSearch.visibility = if (isShowSearch) View.VISIBLE else View.GONE

    }
}