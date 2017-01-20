package idea.analyzesystem.hover.door;

import idea.analyzesystem.hover.pinnedsection.BasePinnedSectionBean;

/**
 * Created by idea on 2017/1/20.
 */
public class DoorPinnedSectionBean extends BasePinnedSectionBean {

    private boolean isShowArrow;
    private int area_id;
    private int parent_id;
    private String areaName;
    private String beaconId;
    private String controller_sn;
    private String door_name;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isShowArrow() {
        return isShowArrow;
    }

    public void setIsShowArrow(boolean isShowArrow) {
        this.isShowArrow = isShowArrow;
    }

    public int getArea_id() {
        return area_id;
    }

    public void setArea_id(int area_id) {
        this.area_id = area_id;
    }

    public int getParent_id() {
        return parent_id;
    }

    public void setParent_id(int parent_id) {
        this.parent_id = parent_id;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getBeaconId() {
        return beaconId;
    }

    public void setBeaconId(String beaconId) {
        this.beaconId = beaconId;
    }

    public String getController_sn() {
        return controller_sn;
    }

    public void setController_sn(String controller_sn) {
        this.controller_sn = controller_sn;
    }

    public String getDoor_name() {
        return door_name;
    }

    public void setDoor_name(String door_name) {
        this.door_name = door_name;
    }

    @Override
    public String toString() {
        return "DoorPinnedSectionBean{" +
                "isShowArrow=" + isShowArrow +
                ", area_id=" + area_id +
                ", parent_id=" + parent_id +
                ", areaName='" + areaName + '\'' +
                ", beaconId='" + beaconId + '\'' +
                ", controller_sn='" + controller_sn + '\'' +
                ", door_name='" + door_name + '\'' +
                ", id=" + id +
                '}';
    }
}
