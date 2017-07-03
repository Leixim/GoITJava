package module04;




import module04.dao.DeveloperDAO;
import module04.model.Developer;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class DeveloperApp {
    public static void main(String[] args) throws Exception {
    startMenu();
    }

    public static void startMenu() throws Exception {
        DeveloperDAO dev = new DeveloperDAO();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Select the desired menu item");
        System.out.println("********************************");
        System.out.println("1 - get developer from file by ID");
        System.out.println("2 - get all developers from file");
        System.out.println("3 - save new developer to file");
        System.out.println("4 - remove developer from file");
        System.out.println("5 - update developer from file");
        System.out.println("6 - exit");
        System.out.println("*********************************");
        int menu = readInt();
        switch (menu) {
            case 1:
                System.out.println("Input ID to get develop");
                int developerID = readInt();
                if (dev.getById(developerID).getId() == null) {
                    System.out.println("Developer with entered ID not found");
                } else {
                    System.out.println(dev.getById(developerID));
                }
                startMenu();
                break;
            case 2:
                System.out.println("All developers");
                for (Developer developer : dev.getAllDevelopers()) {
                    System.out.println(developer);
                }
                startMenu();
                break;
            case 3:
                System.out.println("Input id,first name, last name, speciality, experience, salary");
                dev.save(dev.parseDeveloper(reader.readLine()));
                startMenu();
                break;
            case 4:
                System.out.println("Input id of developer to delete");
                dev.delete(readInt());
                startMenu();
                break;
            case 5:
                System.out.println("Input id,first name, last name, speciality, experience, salary");
                dev.update(dev.parseDeveloper(reader.readLine()));
                startMenu();
                break;
            case 6:
                break;
            default:
                System.err.println("Invalid menu item");
                startMenu();
        }

    }

    private static int readInt() throws Exception {
        int result;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                result = Integer.parseInt(reader.readLine());
                break;
            } catch (NumberFormatException ex) {
                System.err.println("Invalid input. Enter the number");
            }
            reader.close();
        }
        return result;
    }

}
