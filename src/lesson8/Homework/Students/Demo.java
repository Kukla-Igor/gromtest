package lesson8.Homework.Students;

public class Demo {
    Student createHighestParent(){
        Course[] course = new Course[5];
        Student student = new Student("Klint", "Eastwood", 5,  course);
        return student;
    }

    SpecialStudent createLowestChild(){
        Course[] course = new Course[5];
        SpecialStudent specialStudent = new SpecialStudent("Tony", "Stark", 7, course, 99, "gmail");
        return specialStudent;
    }
}
