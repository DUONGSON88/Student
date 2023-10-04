package readAndWrite;

import model.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWrite {
    File file = new File("src/student.csv");

    public void writeFile(List<Student> list) {
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String line = "";
            for (Student student : list) {
                line += student.getId() + ","+student.getName()+"," + student.getGender()+"," +student.getYearOfBirth()+","+student.getPoint()[0]+","+student.getPoint()[1]+","+student.getPoint()[2]+","+student.getAvg()+ "\n";
            }
            bufferedWriter.write(line);
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Student> readFile() {
        List<Student> list = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");
                double[] listpoint=new double[]{Double.parseDouble(data[4]),Double.parseDouble(data[5]),Double.parseDouble(data[6])};

                Student student = new Student(data[0], data[1], Integer.parseInt(data[3]),data[2], listpoint);
                list.add(student);
            }
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
}
