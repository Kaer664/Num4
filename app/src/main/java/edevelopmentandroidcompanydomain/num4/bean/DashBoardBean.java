package edevelopmentandroidcompanydomain.num4.bean;

/**
 * Created by 风雨诺 on 2019/3/5.
 */

public class DashBoardBean {
    private int id;
    //可用
    private int usable;
    //距离
    private double distance;

    private int prica;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUsable() {
        return usable;
    }

    public void setUsable(int usable) {
        this.usable = usable;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public int getPrica() {
        return prica;
    }

    public void setPrica(int prica) {
        this.prica = prica;
    }

    public DashBoardBean(int id, int usable, double distance, int prica) {
        this.id = id;
        this.usable = usable;
        this.distance = distance;
        this.prica = prica;
    }
}
