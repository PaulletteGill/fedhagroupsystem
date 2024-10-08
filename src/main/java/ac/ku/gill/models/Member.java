package ac.ku.gill.models;

public class Member {
    private String name;
    private int age;
    private double shares;

    public Member(String name, int age) {
        this.name = name;
        this.age = age;
        this.shares = 0;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getShares() {
        return shares;
    }

    public void addShares(double amount) {
        shares += amount;
    }
}
