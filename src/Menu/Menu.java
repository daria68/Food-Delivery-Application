package Menu;

public abstract class Menu {

    private String name;
    private Double price;
    private Double quantity;

    public Menu(){}
    public Menu(String name, Double price, Double quantity){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName(){
        return name;
    }

    public Double getPrice(){
        return  price;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString(){
        return "Name: " + this.name + "\nQuantity: "+ this.quantity.toString()+ "\nPrice: " + this.price.toString() + "\n" ;
    }
}
