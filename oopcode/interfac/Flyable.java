package interfac;

public interface Flyable {
        void fly_obj();
    }

    class Spacecraft implements Flyable {
        @Override
        public void fly_obj() {
            System.out.println("Spacecraft flies ");
        }
    }

    class Airplane implements Flyable {
        @Override
        public void fly_obj() {
            System.out.println("Airplane flies ");
        }
    }

    class Helicopter implements Flyable {
        @Override
        public void fly_obj() {
            System.out.println("Helicopter hovers and flies ");
        }
    }

    // Test class
    class FlyableDemo {
        public static void main(String[] args) {
            Flyable s = new Spacecraft();
            Flyable a = new Airplane();
            Flyable h = new Helicopter();

            s.fly_obj();
            a.fly_obj();
            h.fly_obj();
        }
    }


