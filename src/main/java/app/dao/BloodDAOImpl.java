package app.dao;

import app.model.Blood;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BloodDAOImpl implements BloodDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    @Override
    public List<Blood> getAllBloods() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Blood> bloodList = session.createQuery("from completebloodcount").list();
        return bloodList;
    }

    @Override
    public Blood getCompleteBloodCount(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Blood blood = (Blood) session.get(Blood.class, id);
        return blood;
    }

    @Override
    public Blood addCompleteBloodCount(Blood blood) {
        Session session = this.sessionFactory.getCurrentSession();
        session.save(blood);
        return blood;
    }

    @Override
    public void updateCompleteBloodCount(Blood blood) {
        Session session = this.sessionFactory.getCurrentSession();
        Hibernate.initialize(blood);
        session.update(blood);

    }

    @Override
    public void deleteCompleteBloodCount(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Blood p = (Blood) session.load(Blood.class, new Integer(id));
        if (null != p) {
            session.delete(p);
        }
    }
}
