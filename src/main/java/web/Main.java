package web;

import org.hibernate.Session;
import org.hibernate.query.Query;
import web.conf.MySessionCreator;
import web.entity.Film;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        try (Session session = MySessionCreator.getSessionCreator().openSession()) {
            Query<Film> query = session.createQuery("from Film ", Film.class);
            query.setMaxResults(100);
            List<Film> films = query.list();
            for (Film film : films) {
                System.out.println(film);
            }

        }
    }
}