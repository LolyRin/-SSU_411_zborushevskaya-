


public class Transactions {

    private String nameSender;
    private String nameReceiver;
    private int scoreSender;
    private int scoreReceiver;
    private int number;
    private int money;

    public String getNameSender() {
        return nameSender;
    }
    public void setNameSender(String name) {
        this.nameSender = name;
    }

    public String getNameReceiver() {
        return nameReceiver;
    }
    public void setNameReciever(String name) {
        this.nameReceiver = name;
    }

    public int getScoreSender() {
        return scoreSender;
    }
    public void setScoreSender(int name) {
        this.scoreSender = name;
    }

    public int getScoreReciever() {
        return scoreReceiver;
    }
    public void setScoreReciever(int name) {
        this.scoreReceiver = name;
    }

    public int getNumber() {
        return number;
    }
    public void setNumber(int name) {
        this.number = name;
    }

    public int getMoney() {
        return money;
    }
    public void setMoney(int name) {
        this.money = name;
    }

    @Override
    public String toString(){
        System.out.println();
        return  padRight(getNameSender(),20) + padRight(String.valueOf(getScoreSender()),20) +
                padRight(String.valueOf(getNameReceiver()),20) + padRight(String.valueOf(getScoreReciever()),20) +
                padRight(String.valueOf(getNumber()),20) + padRight(String.valueOf(getMoney()),10) +"\n";
    }

    public static String padRight(String s, int n) {
        return String.format("%1$-" + n + "s", s);
    }
}
