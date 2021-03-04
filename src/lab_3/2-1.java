// Создать классы, спецификации которых приведены ниже. Определить конструкторы и методы setТип(), getТип(), toString().
// Определить дополнительно методы в классе, создающем массив объектов. Задать критерий выбора данных и вывести эти данные на консоль.

// 1. Student: id, Фамилия, Имя, Отчество, Дата рождения, Адрес, Телефон, Факультет, Курс, Группа.
// Создать массив объектов. Вывести:
// a) список студентов заданного факультета;
// b) списки студентов для каждого факультета и курса;
// c) список студентов, родившихся после заданного года;
// d) список учебной группы.

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;

class Lab3_2_1 {
    public static void main(String[] args) {
        Student st1 = new Student(
                "1",
                "Apple",
                "John",
                "Michael",
                new Date(),
                "asd",
                "819203813",
                "IU",
                2,
                "21"
        );

        Student st2 = new Student(
                "2",
                "Samsung",
                "Paul",
                "Andrew",
                new Date(),
                "asdasd aas dasda asd",
                "000000000",
                "IU",
                2,
                "22"
        );

        Students array = new Students(new Student[]{st1, st2});

        Student[] filtered = array.getByGroup("22");
        for (Student st: filtered) {
            System.out.println(st);
        }
    }
}

class Students {
    protected Student[] data;

    public Students(Student[] data) {
        this.data = data;
    }

    public Student[] getByFaculty(String faculty) {
        ArrayList<Student> result = new ArrayList<Student>();

        for (Student st: this.data) {
            if (st.faculty.equals(faculty)) {
                result.add(st);
            }
        }

        return result.toArray(new Student[result.size()]);
    }

    public HashMap<String, ArrayList<Student>> getAllStudentsByFaculty() {
        HashSet<String> faculties = new HashSet<String>();

        for (Student st: this.data) {
            faculties.add(st.faculty);
        }

        HashMap<String, ArrayList<Student>> studentsByFaculty = new HashMap<String, ArrayList<Student>>();

        for (Student st: this.data) {
            String faculty = st.faculty;
            if (studentsByFaculty.containsKey(faculty)) {
                studentsByFaculty.get(faculty).add(st);

            } else {
                ArrayList<Student> list = new ArrayList<Student>();
                list.add(st);
                studentsByFaculty.put(faculty, list);
            }
        }

        return studentsByFaculty;
    }

    public HashMap<Integer, ArrayList<Student>> getAllStudentsByYearOfStudy() {
        HashSet<Integer> years = new HashSet<Integer>();

        for (Student st: this.data) {
            years.add(st.yearOfStudy);
        }

        HashMap<Integer, ArrayList<Student>> studentsByYears = new HashMap<Integer, ArrayList<Student>>();

        for (Student st: this.data) {
            int year = st.yearOfStudy;
            if (studentsByYears.containsKey(year)) {
                studentsByYears.get(year).add(st);

            } else {
                ArrayList<Student> list = new ArrayList<Student>();
                list.add(st);
                studentsByYears.put(year, list);
            }
        }

        return studentsByYears;
    }

    public Student[] getBornAfterYear(int year) {
        ArrayList<Student> result = new ArrayList<Student>();

        for (Student st: this.data) {
            LocalDate date = st.dateOfBirth.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            if (date.getYear() > year) {
                result.add(st);
            }
        }

        return result.toArray(new Student[result.size()]);
    }

    public Student[] getByGroup(String group) {
        ArrayList<Student> result = new ArrayList<Student>();

        for (Student st: this.data) {
            if (st.group.equals(group)) {
                result.add(st);
            }
        }

        return result.toArray(new Student[result.size()]);
    }
}

class Student {
    protected String id;
    protected String lastName;
    protected String firstName;
    protected String patronymic;
    protected Date dateOfBirth;
    protected String address;
    protected String telNumber;
    protected String faculty;
    protected int yearOfStudy;
    protected String group;

    public Student(String id, String lastName, String firstName, String patronymic, Date dateOfBirth, String address, String telNumber, String faculty, int yearOfStudy, String group) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.telNumber = telNumber;
        this.faculty = faculty;
        this.yearOfStudy = yearOfStudy;
        this.group = group;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPatronymic() {
        return this.patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public Date getDateOfBirth() {
        return this.dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelNumber() {
        return this.telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    public String getFaculty() {
        return this.faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public int getYearOfStudy() {
        return this.yearOfStudy;
    }

    public void setYearOfStudy(int yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }

    public String getGroup() {
        return this.group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", address='" + address + '\'' +
                ", telNumber='" + telNumber + '\'' +
                ", faculty='" + faculty + '\'' +
                ", yearOfStudy='" + yearOfStudy + '\'' +
                ", group='" + group + '\'' +
                '}';
    }
}