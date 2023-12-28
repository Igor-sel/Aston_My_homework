public class Main {

    public static void main(String[] args) {
        Employee[] persArray = new Employee[5];
        persArray[0] = new Employee("Ivanov Ivan", "Engineer", "iv.ivan@mailbox.com", 892312312, 30000, 30);
        persArray[1] = new Employee("Petrov Peter", "QA", "pet.peter@mailbox.com", 892312001, 25000, 25);
        persArray[2] = new Employee("Semenov Semen", "BA", "sem.sem@mailbox.com", 892312002, 26000, 26);
        persArray[3] = new Employee("Sidorov Sergei", "AQA", "sid.serg@mailbox.com", 892312003, 27000, 27);
        persArray[4] = new Employee("Bykov Alex", "PM", "bykov.alex@mailbox.com", 892312004, 28000, 28);

        for (int i = 0; i < persArray.length; i++) {
             persArray[i].about();
        }
    }
}