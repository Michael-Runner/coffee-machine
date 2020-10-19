import java.util.Scanner;

public abstract class CoffeeMachines {
    private int water;
    private int coffee;
    private int tank;
    private int maxTank;

    CoffeeMachines(int water, int coffee, int maxTank)
    {
        this.water = water;
        this.coffee = coffee;
        this.maxTank = maxTank;
    }

    public void setWater(int water) {
        this.water = water;
    }

    public int getWater() {
        return water;
    }

    public void setCoffee(int coffee) {
        this.coffee = coffee;
    }

    public int getCoffee() {
        return coffee;
    }

    public void setTank(int tank) {
        this.tank = tank;
    }

    public int getTank() {
        return tank;
    }

    public void setMaxTank(int maxTank) {
        this.maxTank = maxTank;
    }

    public int getMaxTank() {
        return maxTank;
    }

    //public abstract void makeEspresso(int cup);

    //public abstract void makeAmericano(int cup);

    public void makeEspresso(int cup)
    {
        if(this.water < 30 * cup)
        {
            System.out.println("It is not enough water!!!");
            return;
        }
        else if (this.coffee < 22 * cup)
        {
            System.out.println("It is not enough coffee!!!");
            return;
        }

        this.water = this.water - 30 * cup;
        this.coffee = this.coffee - 22 * cup;
        this.tank = this.tank + 22 * cup;
        System.out.println("Success!!! There are " + cup + " cups of Espresso");

        if(this.tank >= this.maxTank)
        {
            System.out.println("Tank is overloaded!!!");
        }
    }

    public void makeAmericano(int cup)
    {
        if(this.water < 100 * cup)
        {
            System.out.println("It is not enough water!!!");
            return;
        }
        else if (this.coffee < 22 * cup)
        {
            System.out.println("It is not enough coffee!!!");
            return;
        }

        this.water = this.water - 100 * cup;
        this.coffee = this.coffee - 22 * cup;
        this.tank = this.tank + 22 * cup;
        System.out.println("Success!!! There are " + cup + " cups of Americano");

        if(this.tank >= this.maxTank)
        {
            System.out.println("Tank is overloaded!!!");
        }
    }

    public void clearTank()
    {
        this.tank = 0;
    }
}

class FirstMachine extends CoffeeMachines
{
    public FirstMachine(int water, int coffee, int maxTank)
    {
        super(water, coffee, maxTank);
    }

    @Override
    public String toString() {
        String str = new String();

        str = "Water left: " + String.valueOf(getWater()) + " | " + "Coffee left: " + String.valueOf(getCoffee()) + " | " + "Tank: " + String.valueOf(getTank()) + " | " + "Tank maximum: " + String.valueOf(getMaxTank());

        return str;
    }
}

class SecondMachine extends CoffeeMachines
{
    private int milk;

    SecondMachine(int water, int coffee, int maxTank, int milk)
    {
        super(water, coffee, maxTank);
        this.milk = milk;
    }

    public void setMilk(int milk) {
        this.milk = milk;
    }

    public int getMilk() {
        return milk;
    }

    public void makeLatteAndCappuccino(int cup, int milk, String coffeeType) {
        if(getMilk() < milk * cup)
        {
            System.out.println("It is not enough milk!!!");
            return;
        }

        if(getWater() < 30 * cup)
        {
            System.out.println("It is not enough water!!!");
            return;
        }
        else if (getCoffee() < 22 * cup)
        {
            System.out.println("It is not enough coffee!!!");
            return;
        }

        setMilk(getMilk() - milk * cup);
        setWater(getWater() - 30 * cup);
        setCoffee(getCoffee() - 22 * cup);
        setTank(getTank() + 22 * cup);
        if(coffeeType == "Latte")
        {
            System.out.println("Success!!! There are " + cup + " cups of Latte");
        }
        else
        {
            System.out.println("Success!!! There are " + cup + " cups of Cappuccino");
        }

        if(getTank() >= getMaxTank())
        {
            System.out.println("Tank is overloaded!!!");
        }


    }

    @Override
    public String toString() {
        String str = new String();

        str = "Water left: " + String.valueOf(getWater()) + " | " + "Coffee left: " + String.valueOf(getCoffee()) + " | " + "Milk left: " + String.valueOf(getMilk()) + " | " + "Tank: " + String.valueOf(getTank()) + " | " + "Tank maximum: " + String.valueOf(getMaxTank());

        return str;
    }
}

class ThirdMachine extends SecondMachine
{
    private int coffeeBeans;
    ThirdMachine(int water, int coffee, int maxTank, int milk, int coffeeBeans)
    {
        super(water, coffee, maxTank, milk);
        this.coffeeBeans = coffeeBeans;
    }

    public void setCoffeeBeans(int coffeeBeans) {
        this.coffeeBeans = coffeeBeans;
    }

    public int getCoffeeBeans() {
        return coffeeBeans;
    }
}