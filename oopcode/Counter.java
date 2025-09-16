public class Counter {
    static int count;
    public Counter(){
        count++;
    }
    void destroy(){
        count--;
    }

    public static void main(String[] args) {
        Counter c1= new Counter();
        Counter c2= new Counter();
        Counter c3= new Counter();
        System.out.println(count);
        c3.destroy();
        System.out.println(count);

    }
}
