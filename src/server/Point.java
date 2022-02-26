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
    private double x, y, r;
    private boolean hit;
    private String bornDate;

    public Point(String owner, double x, double y, double r,boolean hit) {
        this.owner = owner;
        this.x = x;
        this.y = y;
        this.r = r;
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

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getR() {
        return r;
    }

    public void setR(double r) {
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