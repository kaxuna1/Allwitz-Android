package technonet.com.allwitz;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;


import java.util.List;
import java.util.function.Consumer;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
import technonet.com.allwitz.Models.Category;
import technonet.com.allwitz.Models.EmailLoginRequestBody;
import technonet.com.allwitz.Models.GalleryPicture;
import technonet.com.allwitz.Models.Page;
import technonet.com.allwitz.Models.Session;
import technonet.com.allwitz.Networking.OnlineData;

public class MainActivity extends AppCompatActivity {

    FrameLayout frame;
    LinearLayout searchView;
    LinearLayout accoutView;
    LayoutInflater inflater;
    Button testButton;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            frame.removeAllViews();
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    frame.addView(searchView);
                    initSearchViewHandlers();
                    return true;
                case R.id.navigation_dashboard:

                    return true;
                case R.id.navigation_notifications:

                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        frame = (FrameLayout) findViewById(R.id.content);
        inflater = (LayoutInflater) this.getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        searchView = (LinearLayout) inflater.inflate(R.layout.search_layout, null);
        frame.addView(searchView);
        initSearchViewHandlers();
    }

    public void initSearchViewHandlers() {
        testButton = (Button) findViewById(R.id.button);
        testButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               OnlineData.userGallery(1, 0, galleryPicturePage -> {
                   galleryPicturePage.getContent().forEach(galleryPicture -> {
                       Log.d("kaxaK",galleryPicture.getId()+"img");
                   });
               });

            }
        });
    }

}
