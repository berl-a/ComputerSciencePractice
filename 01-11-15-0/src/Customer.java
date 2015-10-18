import java.util.LinkedList;

public class Customer {

    private String name, surname;
    private LinkedList<Room> occupiedRooms = new LinkedList<Room>();

    Customer(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public boolean addOccupiedRoom(Room r) {
        if (!occupiedRooms.contains(r)) {
            occupiedRooms.add(r);
            r.setCustomer(this);
            return true;
        } else
            return false;
    }

    public boolean removeOccupiedRoom(Room r) {
        if (occupiedRooms.contains(r)) {
            occupiedRooms.remove(r);
            return true;
        } else
            return false;

    }

    public LinkedList<Room> getOccupiedRooms() {
        return occupiedRooms;
    }

    private void setOccupiedRooms(LinkedList<Room> occupiedRooms) {
        this.occupiedRooms = occupiedRooms;
    }
}
