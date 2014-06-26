package no.iskald.prim.model.image;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table( name = "Albums" )
public class Album {
    private Long id;
    private String title;

    @OneToMany(mappedBy="album")
    private List<Entry> entries;

    public Album(String title) {
        this.title = title;
    }

    public Album() {
    }

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Entry> getEntries() {
        return entries;
    }

    public void setEntries(List<Entry> entries) {
        if (this.entries == null) {
            this.entries = new ArrayList<Entry>();
        }
        this.entries.addAll(entries);
    }
}
