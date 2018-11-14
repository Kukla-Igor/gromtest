package lesson15.cast;

public class InstanceOfDemo {
    public static void main(String[] args) {
        Provider provider = new Provider();
        IntrnetProvider intrnetProvider = new IntrnetProvider();
        FoodProvider foodProvider = new FoodProvider();

        System.out.println(provider instanceof Provider);
        System.out.println(provider instanceof IntrnetProvider);
        System.out.println(provider instanceof FoodProvider);
        System.out.println(intrnetProvider instanceof Provider);

        if (test() instanceof IntrnetProvider){

        } else if (test() instanceof FoodProvider){

        }
    }

    private static Provider test(){
        return new IntrnetProvider();
    }
}
