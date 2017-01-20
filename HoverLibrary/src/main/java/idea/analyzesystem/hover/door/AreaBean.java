package idea.analyzesystem.hover.door;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by idea on 2017/1/20.
 */
public class AreaBean implements Serializable{

    private String area_name;
    private int area_id;
    private int parent_id;

    private ArrayList<DoorPinnedSectionBean> list;

    public ArrayList<DoorPinnedSectionBean> getList() {
        return list;
    }

    public void setList(ArrayList<DoorPinnedSectionBean> list) {
        this.list = list;
    }

    public String getArea_name() {
        return area_name;
    }

    public void setArea_name(String area_name) {
        this.area_name = area_name;
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

    @Override
    public String toString() {
        return "AreaBean{" +
                "area_name='" + area_name + '\'' +
                ", area_id=" + area_id +
                ", parent_id=" + parent_id +
                '}';
    }
}
