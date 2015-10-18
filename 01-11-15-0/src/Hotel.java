import java.util.LinkedList;
import java.util.Random;

/**
 * Created by romanberla on 18.10.15.
 */
public class Hotel {

    public static final String ROOM_NUMBER_SYMBOL = ".";
    public static final String MAGIC_APPENDIX = "a";
    public static final String MAGIC_APPEND = MAGIC_APPENDIX;
    private static final int MAX_FLOUR_NUMBER = 1000;
    private int numberOfFlours;

    private int numberOfRooms;

    private RoomNumeration roomNumeration;

    private LinkedList<LinkedList<Room>> rooms = new LinkedList<>();

    Hotel(int numberOfFlours, int numberOfRooms, RoomNumeration roomNumeration) {
        setNumberOfFlours(numberOfFlours);
        setNumberOfRooms(numberOfRooms);

        setRoomNumeration(roomNumeration);
        fillWithRooms();

        Customer c = new Customer("Bob", "Spangers");

        for (int i = 0; i < 3; i++) {
            addRandomRoomToCustomer(c);
        }

        showRooms();

        System.out.println();

        for (Room room : getRoomsInARow(3)) {
            c.addOccupiedRoom(room);
        }

        showRooms();
    }

    private LinkedList<Room> getRoomsInARow(int neededNumberOfRooms) {
        LinkedList<Room> foundRooms = null;
        for (int flourNumber = 0; flourNumber < numberOfFlours && foundRooms == null; flourNumber++) {
            int currentNumberOfRooms = 0;
            for (int roomNumber = 0; roomNumber < numberOfRooms && foundRooms == null; roomNumber++) {
                if (!rooms.get(flourNumber).get(roomNumber).isOccupied()) {
                    currentNumberOfRooms++;
                    if (currentNumberOfRooms == neededNumberOfRooms) {
                        foundRooms = new LinkedList<>();
                        for (int roomNumberAddition = 0; roomNumberAddition < currentNumberOfRooms; roomNumberAddition++) {
                            foundRooms.add(rooms.get(flourNumber).get(roomNumber - (currentNumberOfRooms - 1) + roomNumberAddition));
                        }
                    }
                } else {
                    currentNumberOfRooms = 0;
                }
            }
        }
        return foundRooms;
    }

    private void showRooms() {
        for (int i = numberOfFlours - 1; i >= 0; i--) {
            for (int a = 0; a < numberOfRooms; a++) {
//                System.out.print(rooms.get(i).get(a).isOccupied() ? "[Ж]" : "[ ]");
                System.out.print(rooms.get(i).get(a).getNumber() + " ");
            }
            System.out.println();
        }
    }

    private void fillWithRooms() {
        if (this.roomNumeration == RoomNumeration.NUMBERS)
            for (int f = 0; f < this.numberOfFlours; f++) {
                addFlour();
                for (int r = 1; r <= numberOfRooms; r++) {
                    addRoom(f, new Room((f + 1) + ROOM_NUMBER_SYMBOL + r));
                }
            }
        else if (roomNumeration == RoomNumeration.LETTERS)
            for (int f = 0; f < numberOfFlours; f++) {
                addFlour();
                for (int r = 0; r < numberOfRooms; r++)
                    addRoom(f, new Room((char) (f + 65) + ROOM_NUMBER_SYMBOL + (char) (r + 65)));
            }
        else if (roomNumeration == RoomNumeration.MAGICAL) {
            for (int f = 1; f <= numberOfFlours; f++) {
                addFlour();
                for (int r = 1; r <= numberOfRooms; r++) {
                    addRoom(f - 1, new Room((String.valueOf(f).contains("8") ? ((f - 1) + MAGIC_APPEND) : f) + ROOM_NUMBER_SYMBOL + ((String.valueOf(r).contains("8") ? (r - 1) + MAGIC_APPEND : (r)))));
                }
            }
        }
    }

    public Room addRandomRoomToCustomer(Customer c) {
        LinkedList<Room> freeRooms = getFreeRooms();
        if (freeRooms.size() != 0) {
            int index = new Random().nextInt(freeRooms.size());
            Room randomFreeRoom = freeRooms.get(index);
            addRoomToCustomer(c, randomFreeRoom);
            return randomFreeRoom;
        } else {
            return null;
        }
    }

    public boolean addRoomToCustomer(Customer c, Room r) {
        return c.addOccupiedRoom(r);
    }

    public LinkedList<Room> getFreeRooms() {
        LinkedList<Room> freeRooms = new LinkedList<>();
        rooms.stream().forEach(f -> f.stream().filter(s -> !s.isOccupied()).forEach(s -> freeRooms.add(s)));
        return freeRooms;
    }

    public boolean areRoomsOccupiedByCustomer(String name, String surname) {
        return getRoomsOccupiedByCustomer(name, surname).size() != 0;
    }

    public LinkedList<Room> getRoomsOccupiedByCustomer(String name, String surname) {
        LinkedList<Room> occupiedRooms = new LinkedList<Room>();
        for (LinkedList<Room> flour : rooms)
            for (Room room : flour)
                if (room.isOccupied())
                    if ((name != null ? room.getCustomer().getName().equals(name) : true) && surname != null ? room.getCustomer().getSurname().equals(surname) : true)
                        occupiedRooms.add(room);
        return occupiedRooms;
    }

    public void freeRoomsOccupiedByCustomer(String name, String surname) {
        for (LinkedList<Room> flour : rooms) {
            for (Room room : flour) {
                if (room.isOccupied()) {
                    if ((name != null ? room.getCustomer().getName().equals(name) : true) && surname != null ? room.getCustomer().getSurname().equals(surname) : true) {
                        room.getCustomer().removeOccupiedRoom(room);
                        room.removeCustomer();
                    }
                }
            }
        }
    }

    public int getNumberOfFreeRooms() {
        int numberOfFreeRooms = 0;
        for (LinkedList<Room> flour : rooms) {
            for (Room room : flour) {
                if (!room.isOccupied()) numberOfFreeRooms++;
            }
        }
        return numberOfFreeRooms;
    }

    public int getNumberOfFlours() {
        return numberOfFlours;
    }

    public void setNumberOfFlours(int numberOfFlours) {
        if (numberOfFlours > 0 && numberOfFlours <= MAX_FLOUR_NUMBER)
            this.numberOfFlours = numberOfFlours;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public RoomNumeration getRoomNumeration() {
        return roomNumeration;
    }

    public void setRoomNumeration(RoomNumeration roomNumeration) {
        if (roomNumeration == RoomNumeration.LETTERS) {
            if (numberOfFlours < 25 && numberOfRooms < 25)
                this.roomNumeration = roomNumeration;
        } else
            this.roomNumeration = roomNumeration;
    }

    private void addFlour() {
        rooms.add(new LinkedList<Room>());
    }

    private void addRoom(int flour, Room room) {
        if (room != null)
            rooms.get(flour).add(room);
    }
}
