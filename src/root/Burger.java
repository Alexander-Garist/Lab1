package root;

public class Burger extends Food {

    private String size;

    public Burger(String size) {
        super("Бургер");
        this.size = size;
    }

    public void consume() {
        System.out.println(this + " съедено");
    }

    public int calculateCalories() {
        if(size.equals("малый")){
            return 300;
        } else if(size.equals("средний")){
            return 380;
        } else if(size.equals("большой")){
            return 460;
        }
        else {
            return 0;
        }
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public boolean equals(Object arg0) {
        if (super.equals(arg0)) { // Шаг 1
            if (!(arg0 instanceof Burger)) return false; // Шаг 2
            return size.equals(((Burger)arg0).size); // Шаг 3
        } else
            return false;
    }

    public String toString() {
        return super.toString() + " размера '" + size.toUpperCase() + "'";
    }
}