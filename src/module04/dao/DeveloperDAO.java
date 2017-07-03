package module04.dao;

import module04.model.Developer;

import java.io.*;
import java.util.*;


public class DeveloperDAO {

    public static final String INPUT_FILENAME = System.getProperty("user.dir") + "/src/module04/developers.txt";

    public Developer parseDeveloper(String line) throws Exception {
        Developer developer = new Developer();
        String[] arrayOfSplitDeveloper = line.split(",");
        developer.setId(Integer.parseInt(arrayOfSplitDeveloper[0]));
        developer.setFirstName(arrayOfSplitDeveloper[1]);
        developer.setLastName(arrayOfSplitDeveloper[2]);
        developer.setSpeciality(arrayOfSplitDeveloper[3]);
        developer.setExperience(Integer.parseInt(arrayOfSplitDeveloper[4]));
        developer.setSalary(Double.parseDouble(arrayOfSplitDeveloper[5]));
        return developer;
    }

    public Developer getById(Integer id) {
        Developer developer = new Developer();
        try (BufferedReader bufferReader = new BufferedReader(new FileReader(INPUT_FILENAME))){
            String line;
            while ((line = bufferReader.readLine()) != null) {
                if (line.isEmpty()) continue;
                if (parseDeveloper(line).getId() == id) {
                    developer = parseDeveloper(line);
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("Error while reading file line by line:" + e.getMessage());
        }
        return developer;
    }

    public Collection<Developer> getAllDevelopers() {
        List<Developer> developers = new ArrayList<>();
        try (BufferedReader bufferReader = new BufferedReader(new FileReader(INPUT_FILENAME))){
            String line;
            while ((line = bufferReader.readLine()) != null) {
                if (line.isEmpty()) continue;
                Developer developer = new Developer();
                developer = parseDeveloper(line);
                developers.add(developer);
            }
        } catch (Exception e) {
            System.out.println("Error while reading file line by line:" + e.getMessage());
        }
        return developers;
    }

    public void save(Developer developer) throws Exception{
        if (getById(developer.getId()).getId() != null) {
            System.out.println("Developer with this ID is already in base");
            return;
        }
        File inputFile = new File(INPUT_FILENAME);
        if (!inputFile.isFile()) {
            throw new FileIsMissingException("Input file is missing");
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(INPUT_FILENAME, true))) {
            bw.newLine();
            bw.write(developer.getId() + "," + developer.getFirstName() + "," + developer.getLastName() + "," + developer.getSpeciality() + "," + developer.getExperience() + "," + developer.getSalary());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update(Developer developer) throws Exception {
        File tempFile = new File(new File(INPUT_FILENAME) + ".tmp");
        File inputFile = new File(INPUT_FILENAME);
        if (!inputFile.isFile()) {
            throw new FileIsMissingException("Input file is missing");
        }
        try (BufferedReader bufferReader = new BufferedReader(new FileReader(INPUT_FILENAME));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(tempFile))) {
            String line;
            while ((line = bufferReader.readLine()) != null) {
                if (line.isEmpty()) continue;
                if (parseDeveloper(line).getId() != developer.getId()) {
                    bufferedWriter.write(line);
                    bufferedWriter.newLine();
                    bufferedWriter.flush();
                }
                if (parseDeveloper(line).getId() == developer.getId()) {
                    bufferedWriter.write(developer.getId() + "," + developer.getFirstName() + "," + developer.getLastName() + "," + developer.getSpeciality() + "," + developer.getExperience() + "," + developer.getSalary());
                    bufferedWriter.newLine();
                    bufferedWriter.flush();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (!inputFile.delete()) {
            throw new FileIsNotDeleteException("Could not delete file");
        }
        if (!tempFile.renameTo(inputFile)) {
            throw new FileIsNotRenameException("Could not rename file");
        }
    }


    public void delete(int id) throws Exception {
        File tempFile = new File(new File(INPUT_FILENAME) + ".tmp");
        File inputFile = new File(INPUT_FILENAME);
        if (!inputFile.isFile()) {
            throw new FileIsMissingException("Input file is missing");
        }
        try (BufferedReader bufferReader = new BufferedReader(new FileReader(INPUT_FILENAME));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(tempFile))) {
            String line;
            while ((line = bufferReader.readLine()) != null) {
                if (line.isEmpty()) continue;
                if (parseDeveloper(line).getId() != id) {
                    bufferedWriter.write(line);
                    bufferedWriter.newLine();
                    bufferedWriter.flush();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (!inputFile.delete()) {
            throw new FileIsNotDeleteException("Could not delete file");
        }
        if (!tempFile.renameTo(inputFile)) {
            throw new FileIsNotRenameException("Could not rename file");
        }
    }



    //Custom Exceptions
    static class FileIsMissingException extends Exception {
        public FileIsMissingException(String message) {
            super(message);
            System.err.println("*****************");
        }
    }

    static class FileIsNotDeleteException extends Exception {
        public FileIsNotDeleteException(String message) {
            super(message);
            System.err.println("*****************");
        }
    }

    static class FileIsNotRenameException extends Exception {
        public FileIsNotRenameException(String message) {
            super(message);
            System.err.println("*****************");
        }
    }
}
