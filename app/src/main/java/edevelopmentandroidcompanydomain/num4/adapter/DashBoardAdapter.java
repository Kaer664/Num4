package edevelopmentandroidcompanydomain.num4.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import edevelopmentandroidcompanydomain.num4.R;
import edevelopmentandroidcompanydomain.num4.bean.DashBoardBean;

/**
 * Created by 风雨诺 on 2019/3/5.
 */

public class DashBoardAdapter extends BaseAdapter {
    List<DashBoardBean> list;
    Context context;

    public DashBoardAdapter(List<DashBoardBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view1=null;
        if (view==null){
             view1= LayoutInflater.from(context).inflate(R.layout.dashboard_list_item,null);
             view=view1;
        }else{
            view1=view;
        }
        DashBoardBean dashBoardBean = list.get(i);

        TextView tvId = view1.findViewById(R.id.tv_id);
        TextView tvUsable = view1.findViewById(R.id.tv_usable);
        TextView tvDistance = view1.findViewById(R.id.tv_distance);
        TextView tvPrice = view1.findViewById(R.id.tv_price);
        tvId.setText("P"+dashBoardBean.getId());
        tvUsable.setText("可用："+dashBoardBean.getUsable());
        tvDistance.setText("距离："+dashBoardBean.getDistance()+"公里");
        tvPrice.setText("单价："+dashBoardBean.getPrica()+"元");
        return view1;
    }
}
