package lesson25;

public class Demo {
    public static void main(String[] args) throws Exception {
        GeneralDAO generalDAO = new GeneralDAO();

        Order order = new Order(1);

        generalDAO.validate(order);

        TestClass<String, Order, Long> testClass = new TestClass<>();

        System.out.println(testClass.doSomething1("rrr"));

        long variable = 111;
        int test = 100;
        Long variable2 = new Long(222);

         generalDAO.validate(variable2);
         generalDAO.validate(variable);

         Long variable3 = variable;

        generalDAO.validate(test);


    }
}
