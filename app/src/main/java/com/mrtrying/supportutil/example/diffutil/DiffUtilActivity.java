package com.mrtrying.supportutil.example.diffutil;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.mrtrying.supportutil.example.R;
import com.mrtrying.supportutil.example.common.MeiZhiData;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class DiffUtilActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    DiffAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diff_util);
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new DiffAdapter();
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setMeiZhiDataList(createMeizhiData(data));
        mAdapter.notifyDataSetChanged();
    }

    public void addItem(View view) {
        List<MeiZhiData> meiZhiDataList = cloneMeizhiData();
        MeiZhiData data = new MeiZhiData();
        data.who = "mrtrying";
        data.image = "http://7xi8d6.com1.z0.glb.clouddn.com/20171212083612_WvLcTr_Screenshot.jpeg";
        meiZhiDataList.add(1,data);

        changeUI(meiZhiDataList);
    }

    public void removeItem(View view) {
        List<MeiZhiData> meiZhiDataList = cloneMeizhiData();
        meiZhiDataList.remove(2);

        changeUI(meiZhiDataList);
    }

    public void changeItem(View view) {
        List<MeiZhiData> meiZhiDataList = cloneMeizhiData();
        MeiZhiData data = new MeiZhiData();
        data.who = "mrtrying";
        data.image = "http://7xi8d6.com1.z0.glb.clouddn.com/20171219115747_tH0TN5_Screenshot.jpeg";
        meiZhiDataList.set(1,data);

        changeUI(meiZhiDataList);
    }

    public void refreshAllItem(View view) {
        List<MeiZhiData> meiZhiDataList = createMeizhiData(data2);

        changeUI(meiZhiDataList);
    }

    String data = "[{\"url\":\"https://ws1.sinaimg.cn/large/0065oQSqly1fvexaq313uj30qo0wldr4.jpg\",\"who\":\"lijinshanmx\"}," +
            "{\"url\":\"https://ws1.sinaimg.cn/large/0065oQSqly1fv5n6daacqj30sg10f1dw.jpg\",\"who\":\"lijinshanmx\"}," +
            "{\"url\":\"https://ws1.sinaimg.cn/large/0065oQSqly1fuo54a6p0uj30sg0zdqnf.jpg\",\"who\":\"lijinshanmx\"}," +
            "{\"url\":\"https://ws1.sinaimg.cn/large/0065oQSqly1fuh5fsvlqcj30sg10onjk.jpg\",\"who\":\"lijinshanmx\"}," +
            "{\"url\":\"https://ws1.sinaimg.cn/large/0065oQSqly1fubd0blrbuj30ia0qp0yi.jpg\",\"who\":\"lijinshan\"}," +
            "{\"url\":\"https://ww1.sinaimg.cn/large/0065oQSqly1fu7xueh1gbj30hs0uwtgb.jpg\",\"who\":\"lijinshan\"}," +
            "{\"url\":\"https://ww1.sinaimg.cn/large/0065oQSqgy1fu39hosiwoj30j60qyq96.jpg\",\"who\":\"lijinshanmx\"}," +
            "{\"url\":\"https://ww1.sinaimg.cn/large/0065oQSqly1ftzsj15hgvj30sg15hkbw.jpg\",\"who\":\"lijinshan\"}," +
            "{\"url\":\"https://ww1.sinaimg.cn/large/0065oQSqgy1ftwcw4f4a5j30sg10j1g9.jpg\",\"who\":\"lijinshan\"}," +
            "{\"url\":\"https://ww1.sinaimg.cn/large/0065oQSqly1ftu6gl83ewj30k80tites.jpg\",\"who\":\"lijinshan\"}]";
    
    String data2 = "[{\"url\":\"http://ww1.sinaimg.cn/large/0065oQSqgy1ftt7g8ntdyj30j60op7dq.jpg\",\"who\":\"lijinshan\"}," +
            "{\"url\":\"https://ww1.sinaimg.cn/large/0065oQSqgy1ftrrvwjqikj30go0rtn2i.jpg\",\"who\":\"lijinshanmx\"}," +
            "{\"url\":\"https://ww1.sinaimg.cn/large/0065oQSqly1ftf1snjrjuj30se10r1kx.jpg\",\"who\":\"lijinshanmx\"}," +
            "{\"url\":\"https://ww1.sinaimg.cn/large/0065oQSqly1ftdtot8zd3j30ju0pt137.jpg\",\"who\":\"lijinshanmx\"}," +
            "{\"url\":\"http://ww1.sinaimg.cn/large/0073sXn7ly1ft82s05kpaj30j50pjq9v.jpg\",\"who\":\"lijinshanmx\"}," +
            "{\"url\":\"https://ww1.sinaimg.cn/large/0065oQSqly1ft5q7ys128j30sg10gnk5.jpg\",\"who\":\"lijinshanmx\"}," +
            "{\"url\":\"https://ww1.sinaimg.cn/large/0065oQSqgy1ft4kqrmb9bj30sg10fdzq.jpg\",\"who\":\"lijinshanmx\"}," +
            "{\"url\":\"http://ww1.sinaimg.cn/large/0065oQSqly1ft3fna1ef9j30s210skgd.jpg\",\"who\":\"lijinshanmx\"}," +
            "{\"url\":\"http://ww1.sinaimg.cn/large/0065oQSqly1fszxi9lmmzj30f00jdadv.jpg\",\"who\":\"lijinshanmx\"}," +
            "{\"url\":\"http://ww1.sinaimg.cn/large/0065oQSqly1fsysqszneoj30hi0pvqb7.jpg\",\"who\":\"lijinshanmx\"}]";

    private List<MeiZhiData> createMeizhiData(String data) {
        List<MeiZhiData> meiZhiDataList = new ArrayList<>();
        try {
            JSONArray jsonArray = new JSONArray(data);
            for (int i =0;i<jsonArray.length();i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                MeiZhiData meiZhi = new MeiZhiData();
                meiZhi.image = jsonObject.getString("url");
                meiZhi.who = jsonObject.getString("who");
                meiZhiDataList.add(meiZhi);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return meiZhiDataList;
    }

    public List<MeiZhiData> cloneMeizhiData(){
        List<MeiZhiData> newMeiZhiDataList = new ArrayList<>();
        for(MeiZhiData data:mAdapter.getMeiZhiDataList()){
            try {
                newMeiZhiDataList.add(data.clone());
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        }
        return newMeiZhiDataList;
    }

    private void changeUI(List<MeiZhiData> meiZhiDataList) {
        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(new ItemDiffCallback<>(mAdapter.getMeiZhiDataList(),meiZhiDataList));
        diffResult.dispatchUpdatesTo(mAdapter);
        mAdapter.setMeiZhiDataList(meiZhiDataList);
    }

    public static void startActivity(@NonNull Context context) {
        context.startActivity(new Intent(context, DiffUtilActivity.class));
    }
}
