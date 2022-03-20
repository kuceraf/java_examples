package cz.fku.designPatterns.creational;

public class Factory {

    class Person
    {
        public int id;
        public String name;

        public Person(int id, String name)
        {
            this.id = id;
            this.name = name;
        }
    }

    class PersonFactory
    {
        int index = 0;
        public Person createPerson(String name)
        {
            Person person = new Person(index, name);
            index++;
            return person;
        }
    }

    public static void main(String[] args) {

    }

}
