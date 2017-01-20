package idea.analyzesystem.hover.chain;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;

import idea.analyzesystem.hover.R;
import idea.analyzesystem.hover.door.AreaBean;
import idea.analyzesystem.hover.door.DoorPinnedSectionAdapter;
import idea.analyzesystem.hover.door.DoorPinnedSectionBean;
import idea.analyzesystem.hover.door.ResponseBean;
import idea.analyzesystem.hover.pinnedsection.AdapterListView;
import idea.analyzesystem.hover.pinnedsection.BasePinnedSectionBean;
import idea.analyzesystem.hover.pinnedsection.OnPinnedSectionListener;
import idea.analyzesystem.hover.pinnedsection.PinnedSectionListView;

/**
 * Created by idea on 2017/1/17.
 */
public class ChainSelectorView extends LinearLayout{

    PinnedSectionListView pinnedSectionListView;
    HorizontalScrollView scrollView;
    LinearLayout tabParent;

    int unSelectorColor = Color.parseColor("#97C3DF");

    int selectorColor = Color.parseColor("#666666");

    ArrayList<AreaBean> tabList = new ArrayList<>();

    protected DoorPinnedSectionAdapter adapter;

    public ChainSelectorView(Context context) {
        this(context, null, 0);
    }

    public ChainSelectorView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ChainSelectorView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        //init view
        inflate(context, R.layout.inflater_content, this);
        pinnedSectionListView = (PinnedSectionListView) findViewById(R.id.pinnedSectionListView);
        scrollView = (HorizontalScrollView) findViewById(R.id.chainTabView);
        tabParent = (LinearLayout)findViewById(R.id.tabParent);

    }
    public void init(ResponseBean responseBean,OnPinnedSectionListener<DoorPinnedSectionBean> onPinnedSectionListener){
        AreaBean areaBean = responseBean.getFirstAreaBean();
        // add first tab data
        tabList.add(areaBean);
        //init listview
        setAdapter(areaBean.getList(),onPinnedSectionListener);
        // add tabs
        refreshTabs();
    }

    private void setAdapter(ArrayList<DoorPinnedSectionBean> list,OnPinnedSectionListener<DoorPinnedSectionBean> onPinnedSectionListener){
        adapter = new DoorPinnedSectionAdapter(getContext(),list,onPinnedSectionListener);
        pinnedSectionListView.setAdapter(adapter);
    }

    private void refreshTabs() {
        int startIndex = tabParent.getChildCount();
        int endIndex = tabList.size();
        for (int i = startIndex; i < endIndex; i++) {
            TextView textView = (TextView) inflate(getContext(), R.layout.item_tab, null);
            textView.setText(tabList.get(i).getArea_name());
            if (i == endIndex - 1) {
                //TODO
                textView.setTextColor(selectorColor);
                textView.setCompoundDrawablesWithIntrinsicBounds(null,null,null,null);
            } else {
                textView.setTextColor(unSelectorColor);
            }

            textView.setTag(i);
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int tag = (int) v.getTag();

                    if (tag != tabList.size() - 1) {
                        adapter.onRefresh(tabList.get(tag).getList());
                        removeItems(tag);
                    }
                }
            });
            tabParent.addView(textView);
        }

        //change <-- textview textcolor and icon
        if (startIndex > 0) {
            //TODO
            TextView textView = (TextView) tabParent.getChildAt(startIndex - 1);
            textView.setTextColor(unSelectorColor);
            textView.setCompoundDrawablesWithIntrinsicBounds(null, null, ContextCompat.getDrawable(getContext(),R.drawable.ic_pinnedtab_righticon), null);
        }

        //change tab location to last
        compileScroll();
        //change listview location to first
        resetListViewSelector();
    }



    private void removeItems(int tag) {

        for (int i = tabList.size() - 1; i > tag; i--) {
            tabList.remove(i);
            tabParent.removeViewAt(i);
        }
        TextView textView = (TextView) tabParent.getChildAt(tag);
        textView.setTextColor(selectorColor);
        textView.setCompoundDrawablesWithIntrinsicBounds(null,null,null,null);
        compileScroll();
        resetListViewSelector();
    }

    private void compileScroll() {
        postDelayed(new Runnable() {
            @Override
            public void run() {
                scrollView.fullScroll(ScrollView.FOCUS_RIGHT);
            }
        }, 100);
    }

    public void setUnSelectorColor(int unSelectorColor) {
        this.unSelectorColor = unSelectorColor;
        for (int i = 0; i < tabParent.getChildCount(); i++) {
            if (i != tabParent.getChildCount() - 1) {
                ((TextView) tabParent.getChildAt(i)).setTextColor(unSelectorColor);
            }
        }
    }

    public void setSelectorColor(int selectorColor) {
        this.selectorColor = selectorColor;
        ((TextView) tabParent.getChildAt(getChildCount() - 1)).setTextColor(selectorColor);
    }

    private void resetListViewSelector(){
        pinnedSectionListView.setSelection(0);
    }

    /**
     * request new data to refresh tab 、adapter
     * @param areaBean
     */
    public void proccesRequestData(AreaBean areaBean){
        tabList.add(areaBean);
        adapter.onRefresh(areaBean.getList());
        refreshTabs();
    }

}
