import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class EventPK implements Serializable {

    private int build;
    private int room;
    private int id;

    public EventPK(int build, int room, int id) {
        this.build = build;
        this.room = room;
        this.id = id;
    }

    public EventPK() {

    }

    public int getBuild() {
        return build;
    }

    public void setBuild(int build) {
        this.build = build;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "EventPK{" +
                "build=" + build +
                ", room=" + room +
                ", id=" + id +
                '}';
    }
}
