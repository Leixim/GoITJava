package module01_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MainApp {
    public static void main(String[] args) throws Exception {
        System.out.println("Enter Your name: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        System.out.println("Hello, " + name);
    }
}
