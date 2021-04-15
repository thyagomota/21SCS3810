import javax.persistence.*;

@Entity
@Table(name = "events")
public class Event {

    @EmbeddedId
    private EventPK eventPK;

    private String title;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "build", insertable = false, updatable = false),
            @JoinColumn(name = "room", insertable = false, updatable = false)
    })
    private Location location;

    public EventPK getEventPK() {
        return eventPK;
    }

    public void setEventPK(EventPK eventPK) {
        this.eventPK = eventPK;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Event{" +
                "eventPK=" + eventPK +
                ", title='" + title + '\'' +
                ", location=" + location +
                '}';
    }
}
