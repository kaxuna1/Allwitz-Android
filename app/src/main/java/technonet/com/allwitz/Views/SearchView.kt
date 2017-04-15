package technonet.com.allwitz.Views

import android.content.Context
import android.support.design.widget.CoordinatorLayout
import android.support.v7.widget.CardView
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView

import technonet.com.allwitz.R

/**
 * Created by vakhtanggelashvili on 4/16/17.
 */

class SearchView(context: Context) : CoordinatorLayout(context) {
    init {
        initView()
    }
    public var topCategoriesLayout: LinearLayout?=null
    protected var mInternalOuterView: CoordinatorLayout?=null
    protected fun initView() {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        mInternalOuterView = inflater.inflate(R.layout.search_layout,null) as CoordinatorLayout
        topCategoriesLayout = mInternalOuterView!!.findViewById(R.id.topCategoriesLayout) as LinearLayout
        this.addView(mInternalOuterView)

    }
}
