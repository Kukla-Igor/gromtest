package lesson31.homework;

public class Demo {

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.countSymbols("hhhhhhh"));
        System.out.println(solution.countSymbols("qwertyqwerty"));
        System.out.println(solution.countSymbols("qwerty qwerty"));
        System.out.println(solution.countSymbols(""));
        System.out.println(solution.countSymbols(null));


        System.out.println(solution.words("qwerty qwerty"));
        System.out.println(solution.words("qwerty qwertyqwerty"));
        System.out.println(solution.words("qwerty q qw"));
        System.out.println(solution.words(""));
        System.out.println(solution.words(null));
    }
}
