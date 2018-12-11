package lesson23;

public final class Validator {
    private String name;
    private final int checkCount = 10;

    public Validator(String name) {
        this.name = name;
       // this.checkCount = checkCount;
    }

    public final boolean validate(){
        return false;
    }

    public String getName() {
        return name;
    }

    public int getCheckCount() {
        return checkCount;
    }
}
