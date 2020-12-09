package root;

public class Cheese extends Food {

    public Cheese() {
        super("Сыр");
    }

    public int calculateCalories() {
        return 200;
    }
    public void consume() {
        System.out.println(this + " съеден");
    }

}
