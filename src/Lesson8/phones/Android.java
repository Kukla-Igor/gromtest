package Lesson8.phones;

public class Android extends Phone{


    String androidVersion;
    int screenSize;
    String secretDeviseCode;

    public Android(int price, double weight, String countryProduced, String androidVersion, int screenSize, String secretDeviseCode) {
        super(price, weight, countryProduced);
        this.androidVersion = androidVersion;
        this.screenSize = screenSize;
        this.secretDeviseCode = secretDeviseCode;
    }

        void instalNewAndroidVersion() {
            System.out.println("instalNewAndroidVersion invoked...");
        }
}
