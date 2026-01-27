public class MemoryTask {
    public static void main(String[] args){
        run();

    }
    static void run(){
        int num = 56;
        int[] a = {1, 2, 3, 4};
        Animal animal1 = new Animal("Rex");
        Animal animal2 = animal1;

        System.out.println("num = "+num);
        System.out.println("a[0] = "+ a[0]);
        System.out.println("animal1 = "+animal1);
        System.out.println("animal2 = "+animal2);
        System.out.println("animal1 == animal2? "+(animal1 == animal2));
    }
}
