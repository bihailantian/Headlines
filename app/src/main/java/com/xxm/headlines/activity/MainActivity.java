package com.xxm.headlines.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.widget.TableLayout;

import com.orhanobut.logger.Logger;
import com.xxm.headlines.R;
import com.xxm.headlines.adapter.HomeAdapter;
import com.xxm.headlines.base.BaseActivity;
import com.xxm.headlines.base.BaseFragment;
import com.xxm.headlines.fragment.HomeFragment;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends BaseActivity {

    private TabLayout mTableLayout;
    private ViewPager mViewPager;
    private String[] mTitleList; //标题
    private List<Fragment> mFragmentList;//fragment集合


/*    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }*/

    @Override
    protected void initData() {
        mTitleList = getResources().getStringArray(R.array.home_title);

        mFragmentList = new ArrayList<>();
        mFragmentList.add( HomeFragment.newInstance("top"));
        mFragmentList.add( HomeFragment.newInstance("shehui"));
        mFragmentList.add( HomeFragment.newInstance("guonei"));
        mFragmentList.add( HomeFragment.newInstance("guoji"));
        mFragmentList.add( HomeFragment.newInstance("yule"));
        mFragmentList.add( HomeFragment.newInstance("tiyu"));
        mFragmentList.add( HomeFragment.newInstance("junshi"));
        mFragmentList.add( HomeFragment.newInstance("keji"));
        mFragmentList.add( HomeFragment.newInstance("caijing"));
        mFragmentList.add( HomeFragment.newInstance("shishang"));


        mTableLayout.setTabMode(TabLayout.MODE_SCROLLABLE);  //MODE_SCROLLABLE tab的个数多的时候用
        HomeAdapter adapter = new HomeAdapter(getSupportFragmentManager(), mFragmentList, mTitleList);
        mViewPager.setAdapter(adapter);
        //为TabLayout设置ViewPager
        mTableLayout.setupWithViewPager(mViewPager);
    }

    @Override
    protected void initView() {
        mTableLayout = (TabLayout) findViewById(R.id.tab_layout);
        mViewPager = (ViewPager) findViewById(R.id.view_pager);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Logger.d("这是第 "+position+" 个页面");
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_main;
    }
}
