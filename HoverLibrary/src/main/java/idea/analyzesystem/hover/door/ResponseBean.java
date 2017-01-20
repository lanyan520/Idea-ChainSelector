package idea.analyzesystem.hover.door;

import java.util.ArrayList;

import idea.analyzesystem.hover.R;

/**
 * Created by idea on 2017/1/20.
 */
public class ResponseBean {

    private int code;
    private String message;
    private ArrayList<DoorBean> controllerList;
    private ArrayList<AreaBean> areaList;
    private AreaBean firstArea;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ArrayList<DoorBean> getControllerList() {
        return controllerList;
    }

    public void setControllerList(ArrayList<DoorBean> controllerList) {
        this.controllerList = controllerList;
    }

    public ArrayList<AreaBean> getAreaList() {
        return areaList;
    }

    public void setAreaList(ArrayList<AreaBean> areaList) {
        this.areaList = areaList;
    }

    public AreaBean getFirstArea() {
        return firstArea;
    }

    public void setFirstArea(AreaBean firstArea) {
        this.firstArea = firstArea;
    }

    public boolean isSuccessful(){
        return code==1;
    }

    public ArrayList<DoorPinnedSectionBean> getDoorPinnedSectionBeans(){

        ArrayList<DoorPinnedSectionBean> result = new ArrayList<>();
        if(!areaList.isEmpty()){
            DoorPinnedSectionBean parentDoorPinnedSectionBean = new DoorPinnedSectionBean();
            parentDoorPinnedSectionBean.setType(DoorPinnedSectionBean.SECTION);
            parentDoorPinnedSectionBean.setName("下级区域");
            //TODO setImageRes()
            parentDoorPinnedSectionBean.setImageRes(R.drawable.ic_action_area);
            result.add(parentDoorPinnedSectionBean);

            for (int i=0;i<areaList.size();i++){
                DoorPinnedSectionBean doorPinnedSectionBean = new DoorPinnedSectionBean();
                AreaBean areaBean = areaList.get(i);
                doorPinnedSectionBean.setIsShowArrow(true);
                doorPinnedSectionBean.setArea_id(areaBean.getArea_id());
                doorPinnedSectionBean.setAreaName(areaBean.getArea_name());
                doorPinnedSectionBean.setParent_id(areaBean.getParent_id());
                result.add(doorPinnedSectionBean);
            }
        }



        if(!controllerList.isEmpty()){
            DoorPinnedSectionBean parentDoorPinnedSectionBean = new DoorPinnedSectionBean();
            parentDoorPinnedSectionBean.setType(DoorPinnedSectionBean.SECTION);
            parentDoorPinnedSectionBean.setName("门禁列表");
            //TODO setImageRes()
            parentDoorPinnedSectionBean.setImageRes(R.drawable.ic_action_doorlist);
            result.add(parentDoorPinnedSectionBean);
            for (int i=0;i<controllerList.size();i++){
                DoorPinnedSectionBean doorPinnedSectionBean = new DoorPinnedSectionBean();
                DoorBean doorBean = controllerList.get(i);
                doorPinnedSectionBean.setIsShowArrow(false);

                doorPinnedSectionBean.setDoor_name(doorBean.getDoor_name());
                doorPinnedSectionBean.setBeaconId(doorBean.getBeacon_id());
                doorPinnedSectionBean.setId(doorBean.getId());
                doorPinnedSectionBean.setArea_id(doorBean.getArea_id());
                doorPinnedSectionBean.setController_sn(doorBean.getController_sn());

                result.add(doorPinnedSectionBean);
            }
        }


        return result;
    }

    public AreaBean getAreaBean(AreaBean areaBean){
        areaBean.setList(getDoorPinnedSectionBeans());
        return areaBean;
    }

    /**
     * areadId=1,get first tab data.
     * @return
     */
    public AreaBean getFirstAreaBean(){
        //TODO
        // firstArea.setList(getDoorPinnedSectionBeans());
        return firstArea;
    }

}
