package technonet.com.allwitz.Views;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.Date;

import technonet.com.allwitz.R;

/**
 * Created by vakhtanggelashvili on 4/14/17.
 */

public class TopCategoryCardView extends CardView {
    ImageView categoryImageView;
    TextView categoryName;
    public TopCategoryCardView(Context context) {
        super(context);
        initView();
    }
    protected CardView mInternalOuterView;

    protected void initView() {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mInternalOuterView = (CardView)inflater.inflate(R.layout.top_category_layout, this, true);
        categoryImageView=(ImageView) mInternalOuterView.findViewById(R.id.categoryImageView);
        categoryName= (TextView)mInternalOuterView.findViewById(R.id.categoryName);
    }
    public void setImage(String url){
        Picasso.with(getContext())
                .load(url)
                .resize(800,800)
                .centerCrop()
                .placeholder(R.drawable.ic_dashboard_black_24dp)
                .error(R.drawable.ic_dashboard_black_24dp)
                .into(categoryImageView);
    }
    public void setCategoryName(String name){
        categoryName.setText(name);
    }
}
