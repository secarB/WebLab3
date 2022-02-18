package server;

import javax.persistence.*;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

@Entity
@Table(name = "points")
public class Point implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    @Transient private static final long serialVersionUID = 4L;
    private String owner;
    private String x, y, r;
    private boolean hit;
    private String bornDate;

    public Point(String owner, String x, String y, String r,boolean hit) {
        this.owner = owner;
        this.x = x;
        this.y = y;
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        bornDate = dateFormat.format(date);
    }

    public Point() {}


    @Override
    public String toString() {
        return "{x="+x+",y="+y +",r="+r+",hit="+ hit +",time="+bornDate+"}";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y;
    }

    public String getR() {
        return r;
    }

    public void setR(String r) {
        this.r = r;
    }

    public boolean isHit() {
        return hit;
    }

    public void setHit(boolean hit) {
        this.hit = hit;
    }

    public String getBornDate() {
        return bornDate;
    }

    public void setBornDate(String bornDate) {
        this.bornDate = bornDate;
    }
}