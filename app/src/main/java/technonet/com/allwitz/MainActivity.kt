package technonet.com.allwitz

import android.content.Context
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
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


class MainActivity : AppCompatActivity() {

    internal var frame: FrameLayout? = null
    internal var searchView: RelativeLayout? = null
    internal var accoutView: LinearLayout? = null
    internal var searchResultView: LinearLayout? = null
    internal var inflater: LayoutInflater? = null
    internal var testButton: Button? = null
    internal var spinnerClass: Spinner? = null
    internal var spinnerCity: Spinner? = null
    internal var adapter: ArrayAdapter<String>? = null
    internal var adapterCity: ArrayAdapter<String>? = null
    internal var searchContainer: LinearLayout? = null
    internal var topCategoriesLayout: LinearLayout? = null
    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        frame!!.removeAllViews()
        when (item.itemId) {
            R.id.navigation_home -> {

                frame!!.addView(searchView)
                searchContainer = findViewById(R.id.searchContainer) as LinearLayout
                var layoutParams: RelativeLayout.LayoutParams = searchContainer!!.getLayoutParams() as RelativeLayout.LayoutParams
                layoutParams.removeRule(RelativeLayout.ALIGN_PARENT_TOP);
                searchContainer!!.setLayoutParams(layoutParams);
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
        setContentView(R.layout.activity_main)
        val navigation = findViewById(R.id.navigation) as BottomNavigationView
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        frame = findViewById(R.id.content) as FrameLayout
        inflater = this.applicationContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        searchView = inflater!!.inflate(R.layout.search_layout, null) as RelativeLayout
        searchResultView = inflater!!.inflate(R.layout.search_result_layout, null) as LinearLayout
        frame!!.addView(searchView)
        initSearchViewHandlers()
    }

    fun initSearchViewHandlers() {
        testButton = findViewById(R.id.button) as Button
        spinnerClass = findViewById(R.id.spinnerClass) as Spinner
        spinnerCity = findViewById(R.id.spinnerCity) as Spinner
        topCategoriesLayout = findViewById(R.id.topCategoriesLayout) as LinearLayout


        testButton!!.setOnClickListener {
            searchContainer = findViewById(R.id.searchContainer) as LinearLayout
            var layoutParams: RelativeLayout.LayoutParams = searchContainer!!.getLayoutParams() as RelativeLayout.LayoutParams
            layoutParams.addRule(RelativeLayout.ALIGN_PARENT_TOP, RelativeLayout.TRUE);
            searchContainer!!.setLayoutParams(layoutParams);
        }

        initSearchPageAdapters()

    }

    fun initSearchPageAdapters() {

        adapter = object : ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item) {

            override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

                val v = super.getView(position, convertView, parent)
                if (position == count) {
                    (v.findViewById(android.R.id.text1) as TextView).text = ""
                    (v.findViewById(android.R.id.text1) as TextView).hint = getItem(count) //"Hint to be displayed"
                }

                return v
            }

            override fun getCount(): Int {
                return super.getCount() - 1 // you dont display last item. It is used as hint.
            }

        }
        adapter!!.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        adapterCity = object : ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item) {

            override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

                val v = super.getView(position, convertView, parent)
                if (position == count) {
                    (v.findViewById(android.R.id.text1) as TextView).text = ""
                    (v.findViewById(android.R.id.text1) as TextView).hint = getItem(count) //"Hint to be displayed"
                }

                return v
            }

            override fun getCount(): Int {
                return super.getCount() - 1 // you dont display last item. It is used as hint.
            }

        }
        adapterCity!!.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        loadDataIntoSearchPageAdapters();


    }

    fun loadDataIntoSearchPageAdapters() {

        OnlineData.topCategories(Action1 {
            it.forEach {
                adapter!!.add(it.name)
            }
            adapter!!.add("Class")

            spinnerClass!!.adapter = adapter
            spinnerClass!!.setSelection(adapter!!.count);
        })
        OnlineData.cities(Action1 {
            it.forEach {
                adapterCity!!.add(it.name)
            }
            adapterCity!!.add("City")

            spinnerCity!!.adapter = adapterCity
            spinnerCity!!.setSelection(adapterCity!!.count);

        })
        OnlineData.topCategories(Action1 {
            it.forEach {
                val k=Button(this)
                k.text=it.name
                topCategoriesLayout!!.addView(k)
            }
        })

    }


}
