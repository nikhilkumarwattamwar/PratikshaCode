package abstaction;

abstract public class People {
    abstract void eat();
    abstract void exercise();

}
class Athlete extends People{
    @Override
   public void eat() {
        System.out.println("Athlete eats on time");
    }

    @Override
    final void exercise() {
        System.out.println("athlete exercses daily");
    }
}

class LazyPeople extends People{
    @Override
    void eat() {
        System.out.println("LazyPeople only eat");
    }

    @Override
    void exercise() {
        System.out.println("lazypeople do not exercise");
    }

    public static void main(String[] args) {
        People p = new Athlete();
        p.exercise();
    }
}