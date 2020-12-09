package root;

import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {

        Food[] breakfast = new Food[20];

        int f = 0;
        boolean calories = false, sort = true;
        for (String arg : args) {
            String[] parts = arg.split("/");
            if (parts[0].equals("Cheese")) {
                breakfast[f] = new Cheese();
            } else if (parts[0].equals("Apple")) {
                breakfast[f] = new Apple(parts[1]);
            } else if (parts[0].equals("Burger")) {
                breakfast[f] = new Burger(parts[1]);
            }

            f++;

            switch (parts[0]) {
                case ("-calories") :
                    calories = true;
                    break;
                case "-sort":
                    sort = true;
                    break;
            }
        }

        for (Food item : breakfast) {
            if (item != null) {
                item.consume();
            } else break;
        }
        int sumCalories = 0;
        for (Food item : breakfast) {
                if (item != null) {
                    sumCalories += item.calculateCalories();
                } else break;
            }
        System.out.println("Общая калорийность завтрака " + sumCalories + " калорий!");



            System.out.println("");
            System.out.println("Отсортированый завтрак: ");
            Arrays.sort(breakfast, new Comparator<Food>() {
                @Override
                public int compare(Food o1, Food o2) {
                    if (o1 instanceof Burger && o2 instanceof Burger) {
                        return -(((Burger) o1).getSize().compareTo(((Burger) o2).getSize()));
                    }
                    else if (o1 instanceof Burger && o2 instanceof Apple) {
                        return -(((Burger) o1).getSize().compareTo(((Apple) o2).getSize()));
                    }
                    else if (o1 instanceof Apple && o2 instanceof Burger) {
                        return -(((Apple) o1).getSize().compareTo(((Burger) o2).getSize()));
                    }
                    else if (o1 instanceof Apple && o2 instanceof Apple) {
                        return -(((Apple) o1).getSize().compareTo(((Apple) o2).getSize()));
                    }
                    else if (o1 instanceof Cheese && (o2 instanceof Apple || o2 instanceof Burger)) {
                        return -1;
                    }
                    else if ((o1 instanceof Apple || o1 instanceof Burger) && o2 instanceof Cheese) {
                        return 1;
                    }
                    else if (o1 == null) {
                        return 1;
                    }
                    else if (o2 == null) {
                        return -1;
                    }
                    else{
                        return 0;
                    }
                }
            });
            for (Food item : breakfast) {
                if (item != null) {
                    item.consume();
                } else break;
            }
        


        System.out.println("");
        int amount = 0;
        Burger check = new Burger("средний");
        for (Food item: breakfast){
            if (item != null){
                if (item.equals(check)){
                    amount++;
                }
            }
        }
        System.out.println("Количество " + "'" + check + "'" + ": " + amount);
        amount = 0;
        for (Food item: breakfast){
            if (item != null){
                if (item.equals_type(check)){
                    amount++;
                }
            }
        }
        System.out.println("Количество " + "'" + check.getName() + "'" + ": " + amount);


        System.out.println("");
        System.out.println("Пока, следите за фигурой)");
    }
}
