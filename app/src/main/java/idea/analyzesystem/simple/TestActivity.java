package idea.analyzesystem.simple;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

import idea.analyzesystem.hover.chain.ChainSelectorView;
import idea.analyzesystem.hover.door.AreaBean;
import idea.analyzesystem.hover.door.DoorPinnedSectionBean;
import idea.analyzesystem.hover.door.ResponseBean;
import idea.analyzesystem.hover.pinnedsection.OnPinnedSectionListener;

/**
 * Created by idea on 2017/1/20.
 */
public class TestActivity extends AppCompatActivity {

    private ChainSelectorView chainSelectorView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        chainSelectorView = (ChainSelectorView) findViewById(R.id.chainSelectorView);

        ResponseBean responseBean = new ResponseBean();
        final AreaBean areaBean = new AreaBean();
        areaBean.setArea_id(1);
        areaBean.setArea_name("中国移动");
        responseBean.setFirstArea(areaBean);
        areaBean.setList(getTestData());

        chainSelectorView.init(responseBean, new OnPinnedSectionListener<DoorPinnedSectionBean>() {
            @Override
            public void onPinnedSectionItem(DoorPinnedSectionBean result) {

            }

            @Override
            public void onPinnedSectionNext(DoorPinnedSectionBean result) {
                AreaBean areaBean1 = new AreaBean();
                areaBean.setParent_id(result.getParent_id());
                areaBean.setArea_id(result.getArea_id());
                areaBean.setArea_name(result.getAreaName());
                areaBean.setList(getTestData());
                chainSelectorView.proccesRequestData(areaBean);
            }
        });
    }

    private ArrayList<DoorPinnedSectionBean> getTestData() {

        ArrayList<DoorPinnedSectionBean> result = new ArrayList<>();


        DoorPinnedSectionBean parentDoorPinnedSectionBean = new DoorPinnedSectionBean();
        parentDoorPinnedSectionBean.setType(DoorPinnedSectionBean.SECTION);
        parentDoorPinnedSectionBean.setName("下级区域");
        //TODO setImageRes()
        parentDoorPinnedSectionBean.setImageRes(idea.analyzesystem.hover.R.drawable.ic_action_area);
        result.add(parentDoorPinnedSectionBean);

        for (int i = 0; i < 10; i++) {
            DoorPinnedSectionBean doorPinnedSectionBean = new DoorPinnedSectionBean();
            doorPinnedSectionBean.setIsShowArrow(true);
            doorPinnedSectionBean.setArea_id(10 * i);
            doorPinnedSectionBean.setAreaName("areaName" + i);
            doorPinnedSectionBean.setParent_id(100 * i);
            result.add(doorPinnedSectionBean);
        }


        DoorPinnedSectionBean parentDoorPinnedSectionBean2 = new DoorPinnedSectionBean();
        parentDoorPinnedSectionBean2.setType(DoorPinnedSectionBean.SECTION);
        parentDoorPinnedSectionBean2.setName("门禁列表");
        //TODO setImageRes()
        parentDoorPinnedSectionBean2.setImageRes(idea.analyzesystem.hover.R.drawable.ic_action_doorlist);
        result.add(parentDoorPinnedSectionBean2);
        for (int i = 0; i < 20; i++) {
            DoorPinnedSectionBean doorPinnedSectionBean = new DoorPinnedSectionBean();
            doorPinnedSectionBean.setIsShowArrow(false);

            doorPinnedSectionBean.setDoor_name("doorName" + i);
            doorPinnedSectionBean.setBeaconId("beaconId" + i);
            doorPinnedSectionBean.setId(i);
            doorPinnedSectionBean.setArea_id(10 * i);
            doorPinnedSectionBean.setController_sn("controller_sn:" + i);
            result.add(doorPinnedSectionBean);
        }

        return result;
    }
}
