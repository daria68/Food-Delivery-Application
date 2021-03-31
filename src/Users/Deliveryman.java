package Users;

import java.util.*;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class Deliveryman extends User implements Comparable<Deliveryman> {

    private Date hireDate;
    private VehicleType vehicleType;

    public Deliveryman (){
    }

    public Deliveryman (String firstName, String lastName, String username, String password, String phoneNumber, Date birthDate, Date hireDate, VehicleType vehicleType)
    {
        super(firstName, lastName, username, password, phoneNumber, birthDate);
        this.hireDate = hireDate;
        this.vehicleType = vehicleType;

    }

    public Date getHireDate() {
        return hireDate;
    }

    public VehicleType getVehicleType(){
        return vehicleType;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public void setVehicleType(){
        this.vehicleType = vehicleType;
    }


    @Override
    public String toString(){
        return super.toString();
    }

    @Override
    public int compareTo(Deliveryman deliveryman){
        if(this.getFirstName().equals(deliveryman.getFirstName())) {
            return this.getLastName().compareTo(deliveryman.getLastName());
        }
        return this.getFirstName().compareTo(deliveryman.getFirstName());
    }

}
