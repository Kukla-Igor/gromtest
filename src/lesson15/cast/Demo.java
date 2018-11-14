package lesson15.cast;

public class Demo {
    public static void main(String[] args) {
        IntrnetProvider provider = (IntrnetProvider) test();
        FoodProvider foodProvider = (FoodProvider) testFood();

        System.out.println(provider);
    }

    private static Provider test(){
        return new IntrnetProvider();
    }

    private static Provider testFood(){
        return new IntrnetProvider();
    }
}
