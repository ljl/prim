package no.iskald.prim.core;

import java.sql.Statement;

public class Main {
    public static void main(String...args) throws Exception {
        Database db = new Database();
        Statement s = db.getConnection().createStatement();
        s.execute("CREATE TABLE Entries (title varchar(255))");
    }
}
