package manager;

import manager.iManager;
import model.Student;
import model.Student;
import readAndWrite.ReadAndWrite;

import javax.security.auth.login.CredentialException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class StudentManager implements iManager<Student> {
    private List<Student> studentList;
    private ReadAndWrite readAndWrite;

    public StudentManager() {
        readAndWrite= new ReadAndWrite();
        studentList = readAndWrite.readFile();
    }

    @Override
    public void add(Student student) {
        studentList.add(student);
        readAndWrite.writeFile(studentList);
    }

    @Override
    public void delete(String id) {
        studentList.remove(findById(id));
    }

    @Override
    public Student findById(String id) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getId().equals(id)) {
                return studentList.get(i);
            }
        }        return null;
    }

    @Override
    public void update(String id, Student student) {

    }

    @Override

    public void findIndexById(String id) {

    }


    @Override
    public List<Student> findAll() {
        return studentList;
    }

    @Override
    public List<Student> findByName(String name) {
        List<Student> studentSearchName = new ArrayList<>();
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getName().toLowerCase().contains(name.toLowerCase())) {
                studentSearchName.add(studentList.get(i));
            }
        }
        return studentSearchName;
    }

    @Override
    public void getMaxAvg() {
        List<Student> listMaxAvg = new ArrayList<>();

        double maxAvg = Double.MIN_VALUE;
        for (int i = 0; i < studentList.size(); i++) {
            for (int j = 0; j < studentList.get(i).getAvg(); j++) {
                if (studentList.get(i).getAvg() > maxAvg) {
                    maxAvg = studentList.get(i).getAvg();
                }
            }
        }
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getAvg() == maxAvg) {
                listMaxAvg.add(studentList.get(i));
            }
        }
        for (Student student:listMaxAvg) {
            System.out.println(student);
        }
    }
}
