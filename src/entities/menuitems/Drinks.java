package entities.menuitems;

public class Drinks extends MenuItem {

    private DrinkType drinkType;
    public Drinks() {}
    public Drinks(String name, Double price,Double quantity, DrinkType drinkType){
        super(name, price, quantity);
        this.drinkType = drinkType;
    }

    public DrinkType getDrinkType() {
        return drinkType;
    }

    public void setDrinkType(DrinkType drinkType) {
        this.drinkType = drinkType;
    }

    @Override
    public String toString(){
        return super.toString() +
                "Type of dish: " + drinkType;
    }
}
