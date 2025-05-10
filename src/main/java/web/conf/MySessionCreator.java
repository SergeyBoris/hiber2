package web.conf;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MySessionCreator {
    private static MySessionCreator instance;
    private final SessionFactory sessionFactory;

    private MySessionCreator() {
        Configuration configuration = new Configuration().configure();
        sessionFactory = configuration.buildSessionFactory();
    }


    public static SessionFactory getSessionCreator() {
        if (instance == null) {
            instance = new MySessionCreator();
        }
        return instance.sessionFactory;
    }
}
