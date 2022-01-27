package homework;
import com.github.javafaker.Faker;

public class HomeWorkApp5 {

    public static void main (String args[]){
       //test();
        test1();
    }
    public static void test1(){
        int numOfEmployees=5;
        int n=0;
        Employee[] listEmployee= new Employee[numOfEmployees];
        for (Employee emp :listEmployee){
            emp =new Employee();
            listEmployee[n++]=emp;
        }
        for (Employee emp : listEmployee){
            if (emp.getAge()>40){
                System.out.println("Employee (age>40) #"+ n--);
                emp.printEmployeeInfo(emp);
            }
        }
    }
    public static void test (){
        Employee emp1= Employee.makeRandomEmployee();
        Employee emp2= new Employee();
        Employee emp3 = new Employee
                ("fname", "lname","engineer","test@gmail.com",
                        "444555544",44433.30, 33.2);
         /*
        how to avoid double injection of employee? Without making method static
         emp1.printEmployeeInfo();
         emp2.printEmployeeInfo();
         */
        emp1.printEmployeeInfo(emp1);
        emp2.printEmployeeInfo(emp2);
        emp3.printEmployeeInfo(emp3);
    }
}
/*
1. Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст.
2. Конструктор класса должен заполнять эти поля при создании объекта.
3. Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль.
4. Создать массив из 5 сотрудников.
Создать массив из 5 сотрудников.
Пример:
Person[] persArray = new Person[5]; // Вначале объявляем массив объектов
persArray[0] = new Person("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 30); // потом для каждой ячейки массива задаем объект
persArray[1] = new Person(...);
...
persArray[4] = new Person(...);

5. С помощью цикла вывести информацию только о сотрудниках старше 40 лет.
 */
class Employee{
    private static Faker faker = new Faker();
    private String lastName ;
    private String firstName;
    private String title ;
    private String email;
    private String phone;
    private double salary;
    private double age;

    Employee(){
        this.firstName = faker.name().firstName();
        this.lastName = faker.name().lastName();
        this.title =faker.name().title();
        this.age =faker.number().randomDouble(1,20,65);
        this.salary = faker.number().randomDouble(2, 10000,20000000);
        this.email = firstName+lastName+"@gmail.com";
        this.phone = faker.phoneNumber().cellPhone();
    }
    Employee(String firstName, String lastName, String title,String email, String phone,double salary, double age){
     this.firstName=firstName;
     this.lastName=lastName;
     this.title=title;
     this.email=email;
     this.phone=phone;
     this.salary=salary;
     this.age=age;
    }

    public void printEmployeeInfo(Employee emp){
        System.out.println("First name:"+ emp.getFirstName());
        System.out.println("Last Name:"+ emp.getLastName());
        System.out.println("Title:"+ emp.getTitle());
        System.out.println("Email:"+ emp.getEmail());
        System.out.println("Phone:"+ emp.getPhone());
        System.out.println("Salary:"+ emp.getSalary());
        System.out.println("Age:"+ emp.getAge());
        System.out.println("========================");
    }
    public void setFirstName(String firstName){
        this.firstName=firstName;
    }
    public void setLastName(String lastName){
        this.lastName=lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getTitle() {
        return title;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public double getSalary() {
        return salary;
    }

    public double getAge() {
        return age;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setAge(double age) {
        this.age = age;
    }

    public void setTitle(String title){
        this.title=title;
    }

    //http://dius.github.io/java-faker/apidocs/index.html
    public static Employee makeRandomEmployee(){
        Employee emp = new Employee();
        //String firstName = faker.name().fullName();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String title =faker.name().title();
        double age =faker.number().randomDouble(1,20,65);
        double salary = faker.number().randomDouble(2, 10000,20000000);
        String email = firstName+lastName+"@gmail.com".toLowerCase();
        String phone = faker.phoneNumber().cellPhone();
        emp.setFirstName(firstName);
        emp.setLastName(lastName);
        emp.setTitle(title);
        emp.setAge(age);
        emp.setSalary(salary);
        return emp;
    }

}