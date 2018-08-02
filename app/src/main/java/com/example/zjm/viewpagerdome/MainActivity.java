package com.example.zjm.viewpagerdome;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private List<View> pagers;
    private RadioGroup rgTab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pagers = new ArrayList<View>();
        pagers.add(LayoutInflater.from(this).inflate(R.layout.page01,null));
        pagers.add(LayoutInflater.from(this).inflate(R.layout.page02,null));
        pagers.add(LayoutInflater.from(this).inflate(R.layout.page03,null));
        pagers.add(LayoutInflater.from(this).inflate(R.layout.page04,null));


        viewPager = findViewById(R.id.viewpager);
        viewPager.setAdapter(new InnerViewPageAdapter());
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        rgTab.check(R.id.rb_home);
                        break;
                    case 1:
                        rgTab.check(R.id.rb_message);
                        break;
                    case 2:
                        rgTab.check(R.id.rb_setting);
                        break;
                    case 3:
                        rgTab.check(R.id.rb_my);
                        break;
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });



        rgTab = findViewById(R.id.rg_tab);
        rgTab.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rb_home:
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.rb_message:
                        viewPager.setCurrentItem(1);
                        break;
                    case R.id.rb_setting:
                        viewPager.setCurrentItem(2);
                        break;
                    case R.id.rb_my:
                        viewPager.setCurrentItem(3);
                        break;
                }
            }
        });


    }
    private class InnerViewPageAdapter extends PagerAdapter{
        @Override
        public int getCount() {
            return pagers.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(pagers.get(position));

            return pagers.get(position);
        }
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(pagers.get(position));
        }


    }
}
