package cz.fku.designPatterns.behavioural.decorator;

class Bird
{
    public int age;

    public String fly()
    {
        return age < 10 ? "flying" : "too old";
    }
}

class Lizard
{
    public int age;

    public String crawl()
    {
        return (age > 1) ? "crawling" : "too young";
    }
}

class Dragon
{
    public Bird bird = new Bird();
    public Lizard lizard = new Lizard();
    public Dragon() {}
    public Dragon(Bird bird, Lizard lizard) {
        this.bird = bird;
        this.lizard = lizard;
    }
    private int age;
    public void setAge(int age)
    {
        bird.age = age;
        lizard.age = age;
    }
    public String fly()
    {
        return this.bird.fly();
    }
    public String crawl()
    {
        return this.lizard.crawl();
    }
}


class Demo {
    public static void main(String[] args) {
        Dragon dragon = new Dragon(new Bird(), new Lizard());
        dragon.setAge(4);
        System.out.println(dragon.fly());
    }
}
