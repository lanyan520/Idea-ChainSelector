package idea.analyzesystem.hover.door;

import android.content.Context;
import android.view.View;

import java.util.ArrayList;

import idea.analyzesystem.hover.R;
import idea.analyzesystem.hover.pinnedsection.AdapterListView;
import idea.analyzesystem.hover.pinnedsection.BasePinnedSectionBean;
import idea.analyzesystem.hover.pinnedsection.OnPinnedSectionListener;
import idea.analyzesystem.hover.pinnedsection.ViewHolder;

/**
 * Created by idea on 2017/1/20.
 */
public class DoorPinnedSectionAdapter extends AdapterListView<DoorPinnedSectionBean> {


    public DoorPinnedSectionAdapter(Context context, ArrayList<DoorPinnedSectionBean> list, OnPinnedSectionListener<DoorPinnedSectionBean> onPinnedSectionListener) {
        super(context, list, onPinnedSectionListener);
    }

    @Override
    protected void convertSection(ViewHolder viewHolder, final DoorPinnedSectionBean item, int position) {
        //TODO init view

        viewHolder.setText(R.id.name,item.getName());
        viewHolder.setImageResource(R.id.leftImageView,item.getImageRes());

        changeVisibility(true, viewHolder);
    }

    @Override
    protected void convertItem(ViewHolder viewHolder, final DoorPinnedSectionBean item, int position) {
        //TODO init view

        viewHolder.setText(R.id.title,item.isShowArrow()?item.getAreaName():item.getDoor_name());
        viewHolder.getView(R.id.arrowImageView).setVisibility(item.isShowArrow() ? View.VISIBLE : View.GONE);

        changeVisibility(false, viewHolder);

        viewHolder.getConvertView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (item.isShowArrow()) {
                    onPinnedSectionListener.onPinnedSectionNext(item);
                } else {

                    onPinnedSectionListener.onPinnedSectionItem(item);
                }
            }
        });
    }

    @Override
    protected int setLayoutRes() {
        //TODO init layoutRes
        return R.layout.item_pinnedsection;
    }

    public void changeVisibility(boolean isShowSectionView,ViewHolder viewHolder){
        viewHolder.getView(R.id.group).setVisibility(isShowSectionView ? View.VISIBLE:View.GONE);
        viewHolder.getView(R.id.child).setVisibility(isShowSectionView?View.GONE:View.VISIBLE);
    }

    public void onRefresh(ArrayList<DoorPinnedSectionBean> alist){
        setList(list);
        notifyDataSetChanged();
    }
}
