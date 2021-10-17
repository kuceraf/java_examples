package cz.fku.designPatterns.behavioural.proxy;

//interface IPerson {
//    String drink();
//
//    String drive();
//
//    String drinkAndDrive();
//}

class Person
{
    private int age;

    public Person(int age)
    {
        this.age = age;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public String drink() { return "drinking"; }
    public String drive() { return "driving"; }
    public String drinkAndDrive() { return "driving while drunk"; }
}

class ResponsiblePerson extends Person
{
    private Person person;

    public ResponsiblePerson(Person person)
    {
        super(person.getAge());
        this.person = person;
        // todo
    }



    @Override
    public String drink() {
        if(getAge() < 18) {
            return "too young";
        } else {
            return super.drink();

        }
    }

    @Override
    public String drive() {
        if(super.getAge() < 16) {
            return "too young";
        } else {
            return super.drive();

        }
    }

    @Override
    public String drinkAndDrive() {
        return "dead";
    }
}

//

class Demo {
    public static void main(String[] args) {
        ResponsiblePerson responsiblePerson = new ResponsiblePerson(new Person(4));
        responsiblePerson.drink();
    }
}
