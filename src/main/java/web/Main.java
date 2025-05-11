package web;

import org.hibernate.Session;
import org.hibernate.query.Query;
import web.conf.MySessionCreator;
import web.entity.*;

import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        newCustomer();

    }
    public static void newCustomer(){
        try (Session session = MySessionCreator.getSessionCreator().openSession()) {
            session.beginTransaction();
            Customer customer = new Customer();
            customer.setStore(session.createQuery("from Store", Store.class).setMaxResults(1).getSingleResult());
            customer.setFirstName("Sergey");
            customer.setLastName("Borisov");
            customer.setEmail("sergant@bk.ru");
            Optional<Country> country = session.createQuery("from Country c where c.country=:country", Country.class)
                    .setParameter("country", "Russia").uniqueResultOptional();
            Country countryGetted=null;
            if (country.isPresent()){
                 countryGetted = session.get(Country.class, country.get().getId());

            }else {
                 countryGetted = new Country();
                countryGetted.setCountry("Russia");
                session.save(countryGetted);

            }

            City city = new City();
            city.setCity("Prokopievsk");
            city.setCountry(countryGetted);
            session.persist(city);
            Address address = new Address();
            address.setAddress("Sovetov 26,80");
            address.setCity(city);
            address.setDistrict("Kemerovskaya obl");
            address.setPhone("+7904900000");
            session.persist(address);
            customer.setAddress(address);
            customer.setActive(true);
            session.save(customer);
            session.getTransaction().commit();
        }
    }
}