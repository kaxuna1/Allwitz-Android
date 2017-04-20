package technonet.com.allwitz

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView
import rx.functions.Action1
import technonet.com.allwitz.EventTypes.CityChooseEvent
import technonet.com.allwitz.EventTypes.ClassChooseEvent
import technonet.com.allwitz.Models.Category
import technonet.com.allwitz.Models.City
import technonet.com.allwitz.Networking.OnlineData
import technonet.com.allwitz.Static.Variables

class CityChooseActivity : AppCompatActivity() {

    var currentData:List<City>?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_city_choose)
        OnlineData.cities(Action1 {
            val lv = findViewById(R.id.cityList) as ListView
            lv.adapter = ListExampleAdapter(this,it)
            currentData=it
            lv.setOnItemClickListener { parent, view, position, id ->
                var selected=currentData!![position]
                Variables.eventBus.post(CityChooseEvent(selected.name,selected.id))
                this.finish()
            }
        })
    }

    private class ListExampleAdapter(context: Context, data:List<City>) : BaseAdapter() {


        private val mInflator: LayoutInflater
        private val data:List<City>

        init {
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
            val vh: ListRowHolder
            if (convertView == null) {
                view = this.mInflator.inflate(R.layout.list_row_class, parent, false)
                vh = ListRowHolder(view)
                view.tag = vh
            } else {
                view = convertView
                vh = view.tag as ListRowHolder
            }

            vh.label.text = data[position].name
            return view
        }
    }

    private class ListRowHolder(row: View?) {
        public val label: TextView

        init {
            this.label = row?.findViewById(R.id.label) as TextView
        }
    }
}
