package technonet.com.allwitz

import android.app.PendingIntent.getActivity
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.design.widget.BottomNavigationView
import android.support.design.widget.CoordinatorLayout
import android.support.v4.view.LayoutInflaterCompat
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
import com.github.florent37.materialtextfield.MaterialTextField
import com.mikepenz.iconics.context.IconicsLayoutInflater
import com.squareup.picasso.Picasso
import com.yalantis.phoenix.PullToRefreshView
import info.hoang8f.android.segmented.SegmentedGroup
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import technonet.com.allwitz.EventTypes.CityChooseEvent
import technonet.com.allwitz.EventTypes.ClassChooseEvent
import technonet.com.allwitz.Static.Variables.eventBus
import technonet.com.allwitz.Static.Variables.url
import technonet.com.allwitz.Views.SearchView
import technonet.com.allwitz.Views.TopCategoryCardView


class MainActivity : AppCompatActivity() {

    internal var frame: FrameLayout? = null
    internal var searchView: ConstraintLayout? = null
    internal var exploreView: PullToRefreshView? = null
    internal var loginView: LinearLayout? = null


    internal var exploreCategoriesListView: ListView? = null
    internal var accoutView: LinearLayout? = null
    internal var searchResultView: LinearLayout? = null
    internal var inflater: LayoutInflater? = null
    internal var adapter: ArrayAdapter<String>? = null
    internal var adapterCity: ArrayAdapter<String>? = null
    internal var searchContainer: LinearLayout? = null

    internal var emailLoginField: MaterialTextField?= null
    internal var passwordLoginField: MaterialTextField?= null

    var classId: Long = 0;
    var cityId: Long = 0;

    internal var classChooseBtn: Button? = null
    internal var cityChooseBtn: Button? = null
    internal var searchBtn: Button? = null


    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        frame!!.removeAllViews()
        when (item.itemId) {
            R.id.navigation_home -> {

                frame!!.addView(searchView)
                initSearchViewHandlers()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                frame!!.addView(exploreView)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                frame!!.addView(loginView)
                return@OnNavigationItemSelectedListener true

            }

        }
        false
    }


    public var activity: MainActivity? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        activity = this;
        LayoutInflaterCompat.setFactory(getLayoutInflater(), IconicsLayoutInflater(getDelegate()));
        super.onCreate(savedInstanceState)
        this.setTheme(R.style.AppTheme)
        setContentView(R.layout.activity_main)
        val navigation = findViewById(R.id.navigation) as BottomNavigationView
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        frame = findViewById(R.id.content) as FrameLayout
        inflater = this.applicationContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        searchView = inflater!!.inflate(R.layout.search_layout, null) as ConstraintLayout
        exploreView = inflater!!.inflate(R.layout.explore_layout, null) as PullToRefreshView
        loginView = inflater!!.inflate(R.layout.login, null) as LinearLayout
        exploreCategoriesListView = exploreView!!.findViewById(R.id.explore_list) as ListView
        exploreView!!.setOnRefreshListener({
            loadDataInExploreCategoriesListView();
        })
        loadDataInExploreCategoriesListView();
        searchResultView = inflater!!.inflate(R.layout.search_result_layout, null) as LinearLayout

        emailLoginField = loginView!!.findViewById(R.id.emailfieldmaterial) as MaterialTextField



        passwordLoginField = loginView!!.findViewById(R.id.passwordfieldmaterial) as MaterialTextField

        passwordLoginField!!.expand()
        emailLoginField!!.expand()


        frame!!.addView(searchView)
        classChooseBtn = searchView!!.findViewById(R.id.classBtnSearch) as Button
        cityChooseBtn = searchView!!.findViewById(R.id.cityBtnSearch) as Button
        searchBtn = searchView!!.findViewById(R.id.search_btn) as Button

        classChooseBtn!!.setOnClickListener {
            val intent = Intent(this, ClassChooseActivity::class.java)
            startActivity(intent);
        }
        cityChooseBtn!!.setOnClickListener {
            val intent = Intent(this, CityChooseActivity::class.java)
            startActivity(intent);
        }
        searchBtn!!.setOnClickListener {
            Log.d("kaxa", "${cityId} ${classId}")

        }

        initSearchViewHandlers()
    }

    fun loadDataInExploreCategoriesListView() {
        OnlineData.categories(Action1 {
            exploreCategoriesListView!!.adapter = ListCategoryExploreAdapter(this, it)
            exploreView!!.setRefreshing(false)
        })
    }

    fun initSearchViewHandlers() {

    }

    override fun onStart() {
        super.onStart()
        if (!eventBus.isRegistered(this)) {
            eventBus.register(this);
        }

    }

    override fun onStop() {
        //eventBus.unregister(this);
        super.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
        eventBus.unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onMessageEvent(event: ClassChooseEvent) {
        Log.d("fromMainPAge", event.name);
        classChooseBtn!!.text = event.name;
        classId = event.id;

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onMessageEvent(event: CityChooseEvent) {
        Log.d("fromMainPAge", event.name);
        cityChooseBtn!!.text = event.name;
        cityId = event.id
    }

    private class ListCategoryExploreAdapter(context: Context, data: List<Category>) : BaseAdapter() {


        private val mInflator: LayoutInflater
        private val data: List<Category>
        private val context: Context

        init {
            this.context = context;
            this.mInflator = LayoutInflater.from(context)
            this.data = data
        }

        override fun getCount(): Int {
            return data.size
        }

        override fun getItem(position: Int): Any {
            return data[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View? {
            val view: View?
            if (convertView == null) {
                if (position % 2 == 0)
                    view = this.mInflator.inflate(R.layout.explore_item, parent, false)
                else
                    view = this.mInflator.inflate(R.layout.explore_item2, parent, false)
            } else {
                view = convertView
            }
            val label = view?.findViewById(R.id.explore_list_item_label) as TextView
            val pic = view?.findViewById(R.id.explore_list_item_img) as ImageView
            label.text = data[position].name
            Picasso.with(context).load("${url}/categorylogo/${data[position].id}").resize(700, 700).centerCrop().into(pic)




            return view
        }
    }
    /*   private class ListRowHolder(row: View?) {
           public val label: TextView
           public val pic: ImageView

           init {
               this.label = row?.findViewById(R.id.explore_list_item_label) as TextView
               this.pic = row?.findViewById(R.id.explore_list_item_img) as ImageView
           }
       }*/


}
