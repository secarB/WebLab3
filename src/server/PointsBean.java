package server;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Named("pointsBean")
@ApplicationScoped
public class PointsBean implements Serializable {

    private static final long serialVersionUID = 4L;
    private List<Point> points;
    private FacesContext facesContext;
    private String sessionId;
    private Point newPoint = new Point();
    public PointsBean() {
        facesContext = FacesContext.getCurrentInstance();
        List<Point> list = PointDAO.load();
        points = new LinkedList<>();
        for(final Object o : list) {
            points.add((Point) o);
        }
    }
    public boolean isValidData(Point point)
    {
        try {
            if (point.getX() != null && point.getY() != null && point.getR() != null) {
                double x = Double.parseDouble(point.getX().replace(',', '.'));
                double y = Double.parseDouble(point.getY().replace(',', '.'));
                double r = Double.parseDouble(point.getR().replace(',', '.'));
                if (isValid(x, y, r)) {
                    point.setHit(check(x, y, r));
                    return true;
                } else return false;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }
    public void addEntry()
    {

        if (isValidData(newPoint)) {
            try {
                validate(newPoint);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        newPoint = new Point();
    }

    public static boolean isValid(double x, double y, double r) {
        return (x >= -5 && x <= 5) && (y >= -5 && y <= 3) && (r >= 1 && r <= 5);
    }
    public void validate(Point point) {
        try {

            Date date = new Date();
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            point.setBornDate(dateFormat.format(date));
            facesContext = FacesContext.getCurrentInstance();
            System.out.println("lol");
            Map<String, String> params = facesContext.getExternalContext().getRequestParameterMap();
            PointDAO.persist(point);
            points.add(point);
        } catch (Exception e) {
            System.out.println("//");
            e.printStackTrace();
            System.out.println(points);
            System.out.println("//");
        }
    }

    private boolean check(double x, double y, double r) {
        return (x <= 0 && y<=0 && -x-y<=r)||(x<=0 && y>=0 && x*x+y*y<=r*r)
                ||(x>=0 && y>=0 && x<=r && y<=r);
    }
    public List<Point> getPoints() {
        return points;
    }

    public Point getNewPoint() {
        return newPoint;
    }

    public void setNewPoint(Point newPoint) {
        this.newPoint = newPoint;
    }

    public void setPoints(List<Point> points) {
        this.points = points;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PointsBean)) return false;
        PointsBean that = (PointsBean) o;
        return Objects.equals(points, that.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }

    @Override
    public String toString() {
        return "points = "+points+"\n";
    }
}