package com.xxm.headlines.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.xxm.headlines.R;
import com.xxm.headlines.damain.ResultItem;

import java.util.List;

/**
 * 主页列表适配器
 */
public class HomeItemAdapter extends RecyclerView.Adapter<HomeItemAdapter.ViewHolder> {

    private Context mContext;
    private List<ResultItem> mDatas;

    public HomeItemAdapter(Context context, List<ResultItem> datas) {
        this.mContext = context;
        this.mDatas = datas;
    }


    @Override
    public int getItemCount() {
        return mDatas != null ? mDatas.size() : 0;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.rly_item_home, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ResultItem item = mDatas.get(position);
        holder.tvTitle.setText(item.getTitle());
        holder.tvAuthorName.setText(item.getAuthor_name());
        holder.tvDate.setText(item.getDate());
        Glide.with(mContext).load(item.getThumbnail_pic_s()).placeholder(R.mipmap.ic_launcher).into(holder.ivPic);
        Glide.with(mContext).load(item.getThumbnail_pic_s02()).placeholder(R.mipmap.ic_launcher).into(holder.ivPic2);
        Glide.with(mContext).load(item.getThumbnail_pic_s03()).placeholder(R.mipmap.ic_launcher).into(holder.ivPic3);

    }


    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvTitle, tvAuthorName, tvDate;
        private ImageView ivPic,ivPic2,ivPic3;

        ViewHolder(View itemView) {
            super(itemView);
            tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
            tvAuthorName = (TextView) itemView.findViewById(R.id.tv_author_name);
            tvDate = (TextView) itemView.findViewById(R.id.tv_date);
            ivPic = (ImageView) itemView.findViewById(R.id.iv_pic);
            ivPic2 = (ImageView) itemView.findViewById(R.id.iv_pic2);
            ivPic3 = (ImageView) itemView.findViewById(R.id.iv_pic3);
        }
    }
}
