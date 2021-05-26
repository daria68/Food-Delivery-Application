package entities.users;



import java.util.Date;


public class Client extends User implements Comparable<Client>{

    public Client(String firstName, String lastName, String username, String password, String phoneNumber, Date birthDate) {
        super(firstName, lastName, username, password, phoneNumber, birthDate);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public int compareTo(Client client){
        if(this.getFirstName().equals(client.getFirstName())) {
            return this.getLastName().compareTo(client.getLastName());
        }
        return this.getFirstName().compareTo(client.getFirstName());
    }
    
}
