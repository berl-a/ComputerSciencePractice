/**
 * Created by romanberla on 18.10.15.
 */
public class Room<T> {

    String number;

    Customer customer;

    Room(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Customer getCustomer() {
        return customer;
    }

    public boolean setCustomer(Customer customer) {
        if(customer == null) {
            this.customer = customer;
            return true;
        } else
            return false;
    }

    public boolean isOccupied() {
        return customer != null;
    }

    public void removeCustomer() {
        customer = null;
    }
}
