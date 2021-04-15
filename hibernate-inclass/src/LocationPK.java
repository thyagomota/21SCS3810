import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class LocationPK implements Serializable {

    private int build;
    private int room;

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

    @Override
    public String toString() {
        return "LocationPK{" +
                "build=" + build +
                ", room=" + room +
                '}';
    }
}
