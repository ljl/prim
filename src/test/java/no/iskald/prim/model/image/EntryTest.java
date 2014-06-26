package no.iskald.prim.model.image;

import no.iskald.prim.core.Connector;
import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;
import java.util.Date;
import java.util.List;

public class EntryTest {

    private Session session;


    @Before
    public void setUp() throws Exception {
        session = Connector.getSessionFactory().openSession();
        session.beginTransaction();
        Album a = new Album("MyAlbum");
        session.persist(a);

        Entry e = new Entry(new Date(), "Hei");
        e.setAlbum(a);
        session.persist(e);
        session.persist(new Entry(new Date(), "Ho"));
        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void test1() throws Exception {
        session = Connector.getSessionFactory().openSession();
        session.beginTransaction();

        List<Entry> result = session.createQuery( "from Entry").list();
        for ( Entry entry : result ) {
            System.out.println( "Entry (" + entry.getTitle() );
        }

        session.getTransaction().commit();
        session.close();
    }
}
