import java.time.LocalDate;


public class Person {
    enum Sex{
        Male,
        Female
    }
    int ID;
    String name;
    Sex sex;
    Department department;
    int salary;
    LocalDate birthday;

    public Person(int ID, String name, String sex, Department dep, int salary, int year, int month, int day)
    {
        this.ID=ID;
        this.name=name;
        this.department =dep;
        this.sex= Sex.valueOf(sex);
        this.salary=salary;
        this.birthday=LocalDate.of(year,month,day);
    }

    @Override
    public String toString() {
        return "Person{" +
                "ID=" + ID +
                ", Name='" + name + '\'' +
                ", Sex=" + sex.toString() +
                ", Birthday=" + birthday.toString() +
                ", Department=" + department +
                ", Salary=" + salary +
                '}';
    }
}
