import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {

        List<User> users = new ArrayList<>();
        FileWriter fileWriter= new FileWriter("src/userInfo.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        while (true) {

            System.out.println("\n=====================================================\t\n");
            System.out.println("\t\t Create e-mail ");
            System.out.print(" Enter your full name example(Firstname Surname) : ");
            String fullName = scanner.nextLine();
            if (!checkName(fullName)) {
                System.out.println("Enter your name correctly example(Firstname Surname)");
                continue;
            }

            System.out.print("Enter your phone number example(+998901234567) : ");
            String phoneNumber = scanner.nextLine();
            if (!checkPhoneNumber(phoneNumber)) {
                System.out.println("Enter phone number correctly example(+998901234567) : ");
                continue;
            }


            System.out.print("Enter a valid e_mail address example(email@example.com) :");
            String e_mail = scanner.nextLine();
            if (!checkEmail(e_mail)) {
                System.out.println("Enter an acceptable e-mail example(email@example.com) : ");
                continue;
            }


            System.out.print("Enter password : ");
            String password = scanner.nextLine();
            if (!checkPassword(password)) {
                System.out.println("The password should contain at least a capital letter a lowercase letter" +
                        " a digit and a non digit and non letter character try again");
                continue;
            }

            users.add(new User(fullName,phoneNumber,e_mail, password));
            System.out.println("Your account is successfully saved you can check it from userInfo.txt file 😊");
            bufferedWriter.write(users.get(users.size()-1).toString());
            bufferedWriter.close();
        }





    }

    private static boolean checkPassword(String password) {
        int countD=0;
        int countCh=0;
        int countU=0;
        int countL=0;

        if(Pattern.matches("[A-Za-z0-9_~!@#$%^&*)(\\]\\[\\-+\\|\\.,/]{8,}",password)){
            char[] chars = password.toCharArray();
            for (char a : chars) {
                if(Character.isLetter(a)){
                    if(Character.isUpperCase(a))countU++;
                    else if (Character.isLowerCase(a))countL++;
                } else if (Character.isDigit(a))countD++;
                else countCh++;
            }
        }
        return (countCh>0&&countL>0&&countD>0&&countU>0);
    }

    private static boolean checkPhoneNumber(String phoneNumber) {
        return Pattern.matches("\\+998((55)|(88)|(9[013459]))\\d{7}",phoneNumber);
    }

    private static boolean checkEmail(String eMail) {
       return Pattern.matches("\\w+@[a-z]+\\.[a-z]{2,3}",eMail);
    }

    private static boolean checkName(String fullName) {
        return Pattern.matches("[A-Z][a-z]+(\\s[A-Z][a-z]+)?",fullName);
    }
}