package com.xxm.headlines.fragment;


import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.orhanobut.logger.Logger;
import com.xxm.headlines.HeadLinesApplication;
import com.xxm.headlines.R;
import com.xxm.headlines.adapter.HomeItemAdapter;
import com.xxm.headlines.api.API;
import com.xxm.headlines.base.BaseFragment;
import com.xxm.headlines.damain.DisplayResult;
import com.xxm.headlines.damain.HomeEntry;
import com.xxm.headlines.damain.ResultItem;
import com.xxm.headlines.utils.StreamTools;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.io.InputStream;
import java.util.List;

import okhttp3.Call;

/**
 * 主页
 */
public class HomeFragment extends Fragment {

    private SwipeRefreshLayout mSwiperefresh;
    private RecyclerView mRecyclerView;

    protected Context mContext; //上下文
    private String mType = "top"; //类型
    private LinearLayoutManager mLayoutManager;   //创建默认的线性LayoutManager
    boolean isLoadingMore = false; //是否加载更多

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, null);
        mSwiperefresh = (SwipeRefreshLayout) view.findViewById(R.id.swiperefresh);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        initView(inflater, savedInstanceState);
        return view;
    }


    protected void initView(LayoutInflater inflater, Bundle savedInstanceState) {
        //创建默认的线性LayoutManager
        mLayoutManager = new LinearLayoutManager(mContext);
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mLayoutManager);
        //如果可以确定每个item的高度是固定的，设置这个选项可以提高性能
        mRecyclerView.setHasFixedSize(true);
        //添加分割线
        mRecyclerView.addItemDecoration(new DividerItemDecoration(mContext, DividerItemDecoration.HORIZONTAL));
        //设置滚动监听
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                //Logger.d("dx=" + dx + ", dy=" + dy);
                int lastVisibleItem = ((LinearLayoutManager) mLayoutManager).findLastVisibleItemPosition();
                int totalItemCount = mLayoutManager.getItemCount();
              //  Logger.d("lastVisibleItem=" + lastVisibleItem + ", totalItemCount=" + totalItemCount);
                //lastVisibleItem >= totalItemCount - 4 表示剩下4个item自动加载，自由选择
                // dy>0 表示向下滑动
                //dx > 0 表示向左滑动
                if (lastVisibleItem >= totalItemCount - 4 && dx > 0) {
                    if (!isLoadingMore) {  //不是正在加载更多
                        //loadMoreData();
                    }
                }
            }
        });

        //设置卷内的颜色
//        mSwiperefresh.setColorSchemeResources(android.R.color.holo_blue_bright,
//                android.R.color.holo_green_light, android.R.color.holo_orange_light, android.R.color.holo_red_light);
        mSwiperefresh.setColorSchemeColors(Color.parseColor("#FF4081"), Color.parseColor("#303F9F"));

        //设置下拉刷新监听
        mSwiperefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //Logger.d("下拉刷新");
                // TODO: 2017/10/22
                mSwiperefresh.setRefreshing(false);
            }
        });
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData(savedInstanceState);
    }


    protected void initData(Bundle savedInstanceState) {
        //加载本地的json
        String result = loadCacheJson(mType);
        if (result != null) {
            parseJson(result);
        }
        //加载网络的数据
        if (HeadLinesApplication.isLoadServerData) {
            loadServerData();
        }


    }

    /**
     * 加载网络数据
     */
    private void loadServerData() {
        OkHttpUtils.get().url(API.getUrl(mType))
                .build()
                .buildCall(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int i) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onResponse(String s, int i) {
                        parseJson(s);
                    }
                });
    }

    //解析json
    private void parseJson(String result) {
        Gson gson = new Gson();
        HomeEntry homeEntry = gson.fromJson(result, HomeEntry.class);
        DisplayResult displayResult = homeEntry.getResult();
        List<ResultItem> datas = displayResult.getData();
        HomeItemAdapter itemAdapter = new HomeItemAdapter(mContext,datas);
        mRecyclerView.setAdapter(itemAdapter);
    }

    /**
     * 加载本地的json
     *
     * @param fileName 文件名
     * @return result
     */
    private String loadCacheJson(String fileName) {
        String result = null;
        try {
            InputStream is = mContext.getAssets().open(fileName);
            result = StreamTools.readFromStream(is);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return result;
        }
    }

}
