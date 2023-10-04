package view;

import manager.StudentManager;
import model.Student;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MenuManager {
    private static final String ID_REGEX = "^[C]+\\d{4}[G]+\\d{1}$";
    private static final String POINT_REGEX = "^(10(\\.0{1,2})?|[0-9](\\.[0-9]{1,2})?)$";
    Scanner inInt = new Scanner(System.in);
    Scanner inStr = new Scanner(System.in);
    StudentManager studentManager = new StudentManager();

//    Student student=new Student("C1723G1","Son",1999,"Nam",new double[]{1,9,3});
//    Student student2=new Student("C2723G1","Thanh",2000,"Nam",new double[]{1,2,3});
//    Student student3=new Student("C3723G1","Mai",1998,"Nam",new double[]{1,9,3});
//    Student student4=new Student("C4723G1","Ha",1997,"Nam",new double[]{1,2,3});



    public void showMenu() {
//        studentManager.add(student);
//        studentManager.add(student2);
//        studentManager.add(student3);
//        studentManager.add(student4);
        int choice = 0;
        do {
            System.out.println("=====Menu Quản Lý Học Sinh=====");
            System.out.println("1.Hiển thị thông tin tất cả học sinh.");
            System.out.println("2.Thêm học sinh mới.");
            System.out.println("3.Sửa thông tin học sinh.");
            System.out.println("4.Xóa học sinh.");
            System.out.println("5.Tìm kiếm học sinh.");
            System.out.println("6.Học sinh có điểm trung bình môn cao nhất.");
            System.out.println("0.Thoát");
            System.out.println("Hãy nhập lựa chọn của bạn:");
            choice = inInt.nextInt();
            switch (choice) {
                case 1:
                    showAllStudent();
                    break;
                case 2:
                    addStudent();
                    break;
                case 3:
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    showMenuSearch();
                    break;
                case 6:
                    getMaxAvg();
                    break;
            }

        } while (choice != 0);
    }

    public void addStudent() {
        boolean checkIdRegex;
        String id = "";
        do {
            System.out.println("Nhập ID: ");
            id = inStr.nextLine();
            checkIdRegex = id.matches(ID_REGEX);
            if (!checkIdRegex) {
                System.out.println("Nhập theo định dạng (VD:CxxxxGx)");
            }
        } while (!checkIdRegex);
        System.out.println("Nhập tên :");
        String name = inStr.nextLine();
        int yearBirth = 0;
        do {
            System.out.println("Nhập năm sinh (VD: 199x)");
            yearBirth = inInt.nextInt();
            if (yearBirth < 1990 || yearBirth > 2015) {
                System.out.println("Bạn hãy nhập đúng định dạng");
            }
        } while (yearBirth < 1990 || yearBirth > 2015);
        String gender = "";
        do {
            System.out.println("Nhập giới tính (Nam/Nữ):");
            gender = inStr.nextLine();
            if (!gender.equals("Nam") && !gender.equals("Nữ")) {
                System.out.println("Bạn hãy nhập đúng định dạng");
            }
        } while (!gender.equals("Nam") && !gender.equals("Nữ"));
        double[] point = new double[3];
        int COUNT_POINT = 0;
        while (COUNT_POINT < point.length) {
            for (int i = 0; i < point.length; i++) {
                do {
                    System.out.println("Nhập điểm số " + (i + 1) + " :");
                    try {
                        point[COUNT_POINT] = inInt.nextDouble();
                        if (point[COUNT_POINT] < 0 || point[COUNT_POINT] > 10) {
                            System.out.println("Bạn hãy nhập đúng định dạng");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Không nhập sai định dạng ");
                    }
                } while (point[COUNT_POINT] < 0 || point[COUNT_POINT] > 10);
                COUNT_POINT++;
            }

        }

        Student student = new Student(id, name, yearBirth, gender, point);
        studentManager.add(student);
        System.out.println("Bạn đã thêm thành công 1 học sinh.");
    }

    public void showAllStudent() {
        for (Object student : studentManager.findAll()) {
            System.out.println(student);
        }
    }

    public void searchById() {
        System.out.println("Bạn hãy nhập Id của học sinh cần tìm:");
        String idSearch = inStr.nextLine();
        if (studentManager.findById(idSearch) == null) {
            System.out.println("Không tìm thấy học sinh có id " + idSearch);
            return;
        }
        System.out.println("Học sinh có Id " + idSearch + " là :");
        System.out.println(studentManager.findById(idSearch));
    }

    public void searchByName() {
        System.out.println("Bạn  hãy nhập tên học sinh cần tìm kiếm:");
        String nameSearch = inStr.nextLine();
        if (studentManager.findByName(nameSearch).isEmpty()) {
            System.out.println("Không tìm thấy học sinh có tên " + nameSearch);
            return;
        }
        System.out.println("Học sinh có tên " + nameSearch + " là :");
        for (Student student1 : studentManager.findByName(nameSearch)) {
            System.out.println(student1);
        }
    }

    public void exitInfor() {

    }

    public void deleteStudent() {
        System.out.println("Bạn hãy nhập id học sinh muốn xóa:");
        String idDelete = inStr.nextLine();
        if (studentManager.findById(idDelete) == null) {
            System.out.println("Không tìm thấy học sinh có id " + idDelete);
            return;
        }
        studentManager.delete(idDelete);
        System.out.println("Bạn đã xóa thành công học sinh có id " + idDelete);
    }

    public void showMenuSearch() {
        int choice = 0;
        do {
            System.out.println("=====Menu Tìm Kiếm=====");
            System.out.println("1.TÌm kiếm theo id.");
            System.out.println("2.TÌm kiếm theo tên.");
            System.out.println("0.Thoát");
            System.out.println("Hãy nhập lựa chọn của bạn:");
            choice = inInt.nextInt();
            switch (choice) {
                case 1:
                    searchById();
                    break;
                case 2:
                    searchByName();
                    break;
            }
        } while (choice != 0);

    }

    public void getMaxAvg() {
        System.out.println("Học sinh có điểm trung bình mồn lớn nhất là:");
        studentManager.getMaxAvg();
    }
}
