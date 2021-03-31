package Orders;

import Users.*;
public class Order {

    private int id;
    private Double transport_fee;
    private Client client;
    private Deliveryman deliveryman;
    private Restaurant restaurant;
    private Status status;

    public Order(){
        status = Status.PROCESSED;
    }

    public Order(int id, Double transport_fee, Client client, Deliveryman deliveryman, Restaurant restaurant, Status status){
        this.id = id;
        this.client = client;
        this.deliveryman = deliveryman;
        this.restaurant = restaurant;
        this.status = status;
    }

    public Client getClient() {
        return client;
    }

    public Deliveryman getDeliveryman() {
        return deliveryman;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setDeliveryman(Deliveryman deliveryman) {
        this.deliveryman = deliveryman;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public String toString(){
        return "Client: " + this.client.getFirstName() + " " + this.client.getLastName() +
                "\nDeliveryman: " + this.deliveryman.getFirstName() + this.deliveryman.getLastName() +
                "\nRestaurant " + this.restaurant.getName() + " located in "+ this.restaurant.getLocation();
    }
}
