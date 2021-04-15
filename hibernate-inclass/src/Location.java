import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "locations")
public class Location {

    @EmbeddedId
    private LocationPK locationPK;

//    @OneToMany
//    @JoinColumns({
//            @JoinColumn(name = "build"),
//            @JoinColumn(name = "room")
//    })
//    private List<Event> events;

    public LocationPK getLocationPK() {
        return locationPK;
    }

    public void setLocationPK(LocationPK locationPK) {
        this.locationPK = locationPK;
    }

//    public List<Event> getEvents() {
//        return events;
//    }
//
//    public void setEvents(List<Event> events) {
//        this.events = events;
//    }

    @Override
    public String toString() {
        return "Location{" +
                "locationPK=" + locationPK +
                // ", events=" + events +
                '}';
    }
}
