import java.util.Calendar;
        import java.util.Locale;
        import java.util.Scanner;


/**
 * Created by Æàííà on 21.01.2016.
 */
public class Calendar1 {

       public static void main(String[] args) {
           Calendar calendar = Calendar.getInstance();
                String FindDay = "Fri";
                int k = 0;

                Scanner scaner = new Scanner(System.in);
                System.out.println("Enter the year:");
                int year = Integer.parseInt(scaner.nextLine());

                    if (year > 1899 && year < 2021) {
                        calendar.set(Calendar.DAY_OF_MONTH, 13);
                        calendar.set(Calendar.YEAR, year);
                            for (int i = 0; i < 11; i++) {
                                calendar.set(Calendar.MONTH, i);

                                        if (calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.SHORT, Locale.US) == FindDay) {
                                        k += 1;
                                        System.out.println(calendar.getDisplayName(Calendar.MONTH, Calendar.SHORT, Locale.US));
                                    }
                            }
                        System.out.println("The " + year + " Friday the 13th was " + k);
                    }
                else System.out.println("Error!");
            }
}



