public class Employee {
    String fullName, position, email;
    int phoneNum, salary, age;

    public Employee(String fullName, String position, String email, int phoneNum, int salary, int age) {
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.phoneNum = phoneNum;
        this.salary = salary;
        this.age = age;
    }
    public void about() {
        System.out.printf("Ф.И.О.: %s Должность: %s Email: %s Телефон: %s Зарплата: %s Возраст: %d \n",
                fullName, position, email, phoneNum, salary, age);
    }
}