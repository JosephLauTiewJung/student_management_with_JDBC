package inputHelper;
import java.util.Scanner;
public class StudentReader {
    public static String readStudentName() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the student's name: ");
        String name = sc.nextLine();
        return name;
    }

    public static int readStudentAge() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the student's age: ");
        int age = sc.nextInt();
        return age;
    }

    public static String readStudentGender() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the student's gender: ");
        String gender = sc.nextLine();
        return gender;
    }
}
