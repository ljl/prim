package no.iskald.prim.core;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connector {

    private Connection connection;
    private static SessionFactory sessionFactory;

    Connection getConnection() throws Exception{
        if (this.connection == null) {
            Class.forName("org.h2.Driver");
            this.connection = DriverManager.getConnection("jdbc:h2:C:/Users/Lasse/workspace/footy/src/main/resources/db");
        }
        return this.connection;
    }

    public static SessionFactory getSessionFactory() {
        if (Connector.sessionFactory == null) {
            Connector.sessionFactory = new Configuration().configure().buildSessionFactory();
        }
        return Connector.sessionFactory;
    }

}
