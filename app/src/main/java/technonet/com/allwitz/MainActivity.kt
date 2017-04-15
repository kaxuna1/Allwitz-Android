package technonet.com.allwitz

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.design.widget.CoordinatorLayout
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.CardView
import android.text.Layout
import android.util.Log
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.widget.*
import java.util.function.Consumer

import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import rx.functions.Action1
import rx.schedulers.Schedulers
import technonet.com.allwitz.Models.Category
import technonet.com.allwitz.Models.EmailLoginRequestBody
import technonet.com.allwitz.Models.GalleryPicture
import technonet.com.allwitz.Models.Page
import technonet.com.allwitz.Models.Session
import technonet.com.allwitz.Networking.OnlineData
import android.widget.TextView
import android.view.ViewGroup
import android.widget.ArrayAdapter
import technonet.com.allwitz.Static.Variables.url
import technonet.com.allwitz.Views.SearchView
import technonet.com.allwitz.Views.TopCategoryCardView


class MainActivity : AppCompatActivity() {

    internal var frame: FrameLayout? = null
    internal var searchView: technonet.com.allwitz.Views.SearchView? = null
    internal var coor:CoordinatorLayout?=null
    internal var accoutView: LinearLayout? = null
    internal var searchResultView: LinearLayout? = null
    internal var inflater: LayoutInflater? = null
    internal var testButton: Button? = null
    internal var adapter: ArrayAdapter<String>? = null
    internal var adapterCity: ArrayAdapter<String>? = null
    internal var searchContainer: LinearLayout? = null
    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        frame!!.removeAllViews()
        when (item.itemId) {
            R.id.navigation_home -> {

                frame!!.addView(searchView)
                initSearchViewHandlers()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard ->

                return@OnNavigationItemSelectedListener true
            R.id.navigation_notifications ->

                return@OnNavigationItemSelectedListener true
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.setTheme(R.style.AppTheme)
        setContentView(R.layout.activity_main)
        val navigation = findViewById(R.id.navigation) as BottomNavigationView
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        frame = findViewById(R.id.content) as FrameLayout
        inflater = this.applicationContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        searchView = SearchView(this)
        searchResultView = inflater!!.inflate(R.layout.search_result_layout, null) as LinearLayout
        frame!!.addView(searchView)
        initSearchViewHandlers()
    }

    fun initSearchViewHandlers() {

        OnlineData.topCategories(Action1 {
            searchView!!.topCategoriesLayout!!.removeAllViews()
            it.forEach {
                val k=TopCategoryCardView(this)
                //k.addView(Button(this))
                k.setImage("${url}categorylogo/${it.id}")
                k.setBackgroundColor(Color.TRANSPARENT);
                k.setCategoryName(it.name)
                searchView!!.topCategoriesLayout!!.addView(k)
            }
        })

    }





}
