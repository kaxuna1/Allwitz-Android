package technonet.com.allwitz.Views

import android.content.Context
import android.graphics.Color
import android.support.design.widget.CoordinatorLayout
import android.support.v7.widget.CardView
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView

import technonet.com.allwitz.R
import android.graphics.Color.parseColor
import android.support.constraint.ConstraintLayout
import info.hoang8f.android.segmented.SegmentedGroup



/**
 * Created by vakhtanggelashvili on 4/16/17.
 */

class SearchView(context: Context) : CoordinatorLayout(context) {
    init {
        initView()
    }
    protected var mInternalOuterView: ConstraintLayout?=null
    protected fun initView() {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        mInternalOuterView = inflater.inflate(R.layout.search_layout,null) as ConstraintLayout
        this.addView(mInternalOuterView)
    }
}
