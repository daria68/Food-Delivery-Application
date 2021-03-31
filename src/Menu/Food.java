package Menu;

public class Food extends Menu{
    private FoodType foodType;

    public Food() {}
    public Food(String name, Double price,Double quantity, FoodType foodType)
    {
        super(name,price,quantity);
        this.foodType = foodType;
    }

    public FoodType getFoodType() {
        return foodType;
    }

    public void setFoodType(FoodType foodType) {
        this.foodType = foodType;
    }

    @Override
    public String toString(){
        return super.toString() +
                "Type of dish: " + foodType;
    }

}
