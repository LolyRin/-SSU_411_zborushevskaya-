import javenue.csv.Csv;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class Scaner {

    public static ArrayList<String> deletedOrganization = new ArrayList<String>();

    public static void main(String[] args) throws IOException {

        ArrayList<Organizations> organizations = getOrganizations();
        ArrayList<Transactions> transactions = getTransactions();
        System.out.println();

        for (int i = 0; i < organizations.size(); i++) {
            for (int j = 0; j < transactions.size(); j++) {
                if ((organizations.get(i).getScore() == (transactions.get(j).getScoreSender()))) {
                    if (organizations.get(i).getMoney() >= transactions.get(j).getMoney()) {

                        for (int l = 0; l < organizations.size(); l++) {
                            int scoreReciever = transactions.get(j).getScoreReciever();
                            int score = organizations.get(l).getScore();
                            if (scoreReciever == score) {
                                int money = transactions.get(j).getMoney() + organizations.get(l).getMoney();
                                organizations.get(l).setMoney(money);
                            }
                        }
                        int res = organizations.get(i).getMoney() - transactions.get(j).getMoney();
                        organizations.get(i).setMoney(res);
                    }
                    else {
                        System.out.println("Недостаточно средств (счет покупки № " + transactions.get(j).getNumber() + ")");
                    }
                }
            }
        }
        writeTransactions(organizations);
    }

    public static ArrayList<Organizations> getOrganizations() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("sources\\Organizations.csv"));
        String line = "";
        int index = 0;
        ArrayList<Organizations> orgList = new ArrayList<Organizations>();
        String[] mas = new String[orgList.size() + 1];
        boolean firstLine = true;
        while ((line = reader.readLine()) != null) {
            if (firstLine) {
                firstLine = false;
                continue;
            }
            Organizations org = new Organizations();
            Scanner scanner = new Scanner(line);
            scanner.useDelimiter(";");

            while (scanner.hasNext()) {
                String data = scanner.next();
                if (index == 0)
                    org.setName(data);
                else if (index == 1) {
                    for (int i = 0; i <= orgList.size(); i++) {
                        if (!data.equals(mas[i])) {
                            mas[i] = data;
                            org.setScore(Integer.parseInt(data));
                            break;
                        } else {
                            deletedOrganization.add(org.getName());
                            org.setScore(-1);
                            break;
                        }
                    }
                } else if (index == 2)
                    org.setMoney(Integer.parseInt(data));
                else
                    System.out.println("Некорректные данные::" + data);
                index++;
            }
            index = 0;
            if (org.getScore() > 0) {
                orgList.add(org);
            } else {
                System.out.println("В списке обнаружена организация с повторяющимся лицевым счетом." +
                        " Данная организация (" + org.getName() + ") будет удалена из списка.");
                orgList.remove(org);
            }
        }
        reader.close();
        return orgList;
    }

    public static ArrayList<Transactions> getTransactions() throws IOException {
        String line = "";
        int index = 0;
        ArrayList<Transactions> transList = new ArrayList<Transactions>();
        boolean firstLine = true;
        File directory = new File("sources");

        for (File file:directory.listFiles()) {
            if (file.getName().matches("^Transactions[0-9]+\\.csv$")) {
                Scanner scanner = new Scanner(new FileInputStream(file));
                scanner.useDelimiter(";");
                line = scanner.nextLine();
                while (line  != "") {
                    if (firstLine) {
                        firstLine = false;
                        continue;
                    }
                    Transactions trans = new Transactions();
                    while (scanner.hasNext()) {
                        String data = scanner.next();
                        if (index == 0)
                            trans.setNameSender(data);
                        else if (index == 1)
                            trans.setScoreSender(Integer.parseInt(data));
                        else if (index == 2)
                            trans.setNameReciever(data);
                        else if (index == 3)
                            trans.setScoreReciever(Integer.parseInt(data));
                        else if (index == 4)
                            trans.setNumber(Integer.parseInt(data));
                        else if (index == 5)
                            trans.setMoney(Integer.parseInt(data));
                        else
                            System.out.println("Некорректные данные::" + data);
                        index++;
                        if (index == 6) {
                            transList.add(trans);
                            index = 0;
                        }
                    }
                    index = 0;
                    break;
                }
            }
        }

        System.out.println("Также будут удалены транзакции для данной организации.");
        for (int i = 0; i < transList.size(); i++) {
            for (int j = 0; j < deletedOrganization.size(); j++) {
                if ((deletedOrganization.get(j).equals(transList.get(i).getNameSender()) ||
                        (deletedOrganization.get(j).equals(transList.get(i).getNameReceiver())))) {
                    transList.remove(i);
                }
}
       }
        return transList;
    }

    public static void writeTransactions(ArrayList<Organizations> organization) throws IOException {
        Csv.Writer writer = new Csv.Writer("sources\\Result.csv").delimiter(';');
        writer.value("Название").value("Счет").value("Бюджет").newLine();
        for (int i = 0; i < organization.size(); i++) {
            writer.value(String.valueOf(organization.get(i).getName()))
                    .value(String.valueOf(organization.get(i).getScore()))
                    .value(String.valueOf(organization.get(i).getMoney())).newLine();
        }
        writer.close();
    }

    public static String padRight(String s, int n) {
        return String.format("%1$-" + n + "s", s);
    }
}
