package no.iskald.prim.model.image;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table( name = "Entries" )
public class Entry {
    private Long id;
    private Date created;
    private String title;

    @ManyToOne
    @JoinColumn(name="id")
    private Album album;

    public Entry(Date created, String title) {
        this.created = created;
        this.title = title;
    }

    public Entry() {
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

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }
}
