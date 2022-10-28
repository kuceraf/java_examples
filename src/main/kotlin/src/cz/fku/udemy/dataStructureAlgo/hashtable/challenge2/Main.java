package cz.fku.udemy.dataStructureAlgo.hashtable.challenge2;

import java.util.HashMap;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {

        LinkedList<Employee> employees = new LinkedList<>();
        employees.add(new Employee("Jane", "Jones", 123));
        employees.add(new Employee("John", "Doe", 5678));
        employees.add(new Employee("Mike", "Wilson", 45));
        employees.add(new Employee("Mary", "Smith", 5555));
        employees.add(new Employee("John", "Doe", 5678));
        employees.add(new Employee("Bill", "End", 3948));
        employees.add(new Employee("Jane", "Jones", 123));

        employees.forEach(e -> System.out.println(e));

        HashMap<Integer, Employee> hashMap = new HashMap<>();
        employees.forEach(
                e -> hashMap.put(e.getId(), e)
        );
        System.out.println("---------------");
        hashMap.values().forEach(e -> System.out.println(e));
    }
}
