package server;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.TypedQuery;
import java.util.List;

public class PointDAO {
    public static void persist(Point p) throws HibernateException {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSession()) {
            tx = session.beginTransaction();
            session.save(p);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        }
    }
    public static List<Point> load() {
        Session session = HibernateUtil.getSession();
        TypedQuery<Point> typedQuery = session.createQuery("select p from Point p where p.owner = :i");
        typedQuery.setParameter("i","Test");
        return typedQuery.getResultList();
    }

}
