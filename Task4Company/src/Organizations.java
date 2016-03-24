


public class Organizations {

    private String name;
    private int score;
    private int money;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }

    public int getMoney() {
        return money;
    }
    public void setMoney(int money) {
        this.money = money;
    }

    @Override
    public String toString(){
        System.out.println();
        return (padRight(getName(),20) + padRight(String.valueOf(getScore()),20)
                + padRight(String.valueOf(getMoney()),10) + "\n");
    }

    public static String padRight(String s, int n) {
        return String.format("%1$-" + n + "s", s);
    }
}
