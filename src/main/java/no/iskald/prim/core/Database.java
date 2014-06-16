package no.iskald.prim.core;

import java.net.URL;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;

public class Database {

    private Connection connection;

    Connection getConnection() throws Exception{
        if (this.connection == null) {
            Class.forName("org.h2.Driver");
            this.connection = DriverManager.getConnection("jdbc:h2:C:/Users/Lasse/workspace/prim/src/main/resources/db");
        }
        return this.connection;
    }


    String getResourcePath() throws Exception {
        URL resource = Database.class.getResource("");
        System.out.print(resource.toString());
        return Paths.get(resource.toURI()).toFile().toString();
    }
}
