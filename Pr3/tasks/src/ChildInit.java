public class ChildInit extends BaseInit{
    static {
        System.out.println("2s");
    }
    {
        System.out.println("2i");
    }
    ChildInit(){
        System.out.println("6");
    }
}
