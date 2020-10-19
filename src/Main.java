import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose coffee machine:");
        System.out.println("[1] First machine");
        System.out.println("[2] Second machine");
        System.out.println("[3] Third machine");
        byte menu = scanner.nextByte();

        switch (menu)
        {
            case 1:
            {
                FirstMachine first = new FirstMachine(1000, 500, 300);

                do{
                    menu = 1;
                    showMenu(menu);
                    menu = scanner.nextByte();

                    switch (menu)
                    {
                        case 1:
                        {
                            System.out.print("Enter cups: ");
                            first.makeEspresso(scanner.nextInt());
                            System.out.println(first.toString());
                            break;
                        }

                        case 2:
                        {
                            System.out.print("Enter cups: ");
                            first.makeAmericano(scanner.nextInt());
                            System.out.println(first.toString());
                            break;
                        }

                        case 3:
                        {
                            first.clearTank();
                            System.out.println(first.toString());
                            break;
                        }
                    }
                }while(menu!=4);

                break;
            }

            case 2:
            {
                SecondMachine second = new SecondMachine(1000, 500, 500, 300);
                do {
                    menu = 2;
                    showMenu(menu);
                    menu = scanner.nextByte();

                    switch (menu)
                    {
                        case 1:
                        {
                            System.out.print("Enter cups: ");
                            second.makeEspresso(scanner.nextInt());
                            System.out.println(second.toString());
                            break;
                        }

                        case 2:
                        {
                            System.out.print("Enter cups: ");
                            second.makeAmericano(scanner.nextInt());
                            System.out.println(second.toString());
                            break;
                        }

                        case 3:
                        {
                            System.out.print("Enter cups: ");
                            int cups = scanner.nextInt();

                            System.out.print("Enter milk:");
                            int milk = scanner.nextInt();

                            second.makeLatteAndCappuccino(cups, milk, "Latte");
                            System.out.println(second.toString());
                            break;
                        }

                        case 4:
                        {
                            System.out.print("Enter cups: ");
                            int cups = scanner.nextInt();

                            System.out.print("Enter milk:");
                            int milk = scanner.nextInt();

                            second.makeLatteAndCappuccino(cups, milk, "Cappuccino");
                            System.out.println(second.toString());
                            break;
                        }

                        case 5:
                        {
                            second.clearTank();
                            System.out.println(second.toString());
                            break;
                        }
                    }

                }
                while (menu != 6);

                break;
            }

            case 3:
            {
                ThirdMachine third = new ThirdMachine(1000, 500, 600, 400, 200);

                do {
                    menu = 3;
                    showMenu(menu);
                    menu = scanner.nextByte();

                    switch (menu)
                    {
                        case 1:
                        {
                            System.out.print("Enter cups: ");
                            third.makeAmericano(scanner.nextInt());
                            System.out.println(third.toString());
                            break;
                        }

                        case 2:
                        {
                            System.out.print("Enter cups: ");
                            int cups = scanner.nextInt();

                            System.out.print("Enter milk:");
                            int milk = scanner.nextInt();

                            third.makeLatteAndCappuccino(cups, milk, "Latte");
                            System.out.println(third.toString());
                            break;
                        }

                        case 3:
                        {
                            third.clearTank();
                            System.out.println(third.toString());
                            break;
                        }
                    }
                }while (menu != 4);
                break;
            }
        }
    }

    public static void showMenu(int menu)
    {
        if(menu == 1)
        {
            System.out.println("[1] Make Espresso");
            System.out.println("[2] Make Americano");
            System.out.println("[3] Clear tank");
            System.out.println("[4] Turn off");
        }
        else if(menu == 2)
        {
            System.out.println("[1] Make Espresso");
            System.out.println("[2] Make Americano");
            System.out.println("[3] Make Latte");
            System.out.println("[4] Make Cappuccino");
            System.out.println("[5] Clear tank");
            System.out.println("[6] Turn off");
        }
        else if(menu == 3)
        {
            System.out.println("[1] Make Americano");
            System.out.println("[2] Make Latte");
            System.out.println("[3] Clear tank");
            System.out.println("[4] Turn off");
        }
    }
}
