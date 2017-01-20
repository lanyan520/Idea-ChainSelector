package idea.analyzesystem.hover.door;

import java.io.Serializable;

/**
 * Created by idea on 2017/1/20.
 */
public class DoorBean implements Serializable{

    private int area_id;
    private int id;
    private String door_name;
    private String beacon_id;
    private String controller_sn;

    public int getArea_id() {
        return area_id;
    }

    public void setArea_id(int area_id) {
        this.area_id = area_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDoor_name() {
        return door_name;
    }

    public void setDoor_name(String door_name) {
        this.door_name = door_name;
    }

    public String getBeacon_id() {
        return beacon_id;
    }

    public void setBeacon_id(String beacon_id) {
        this.beacon_id = beacon_id;
    }

    public String getController_sn() {
        return controller_sn;
    }

    public void setController_sn(String controller_sn) {
        this.controller_sn = controller_sn;
    }

    @Override
    public String toString() {
        return "DoorBean{" +
                "area_id=" + area_id +
                ", id=" + id +
                ", door_name='" + door_name + '\'' +
                ", beacon_id='" + beacon_id + '\'' +
                ", controller_sn='" + controller_sn + '\'' +
                '}';
    }
}
