import java.util.Calendar;
import java.util.Locale;
import java.util.Scanner;

/**
 * Created by ∆анна on 21.01.2016.
 */
public class Calendar2 {
        public static void main(String[] args) {
                Calendar calendar = Calendar.getInstance();
                String FindDay = "Fri";
                int k = 0;
                Scanner scaner = new Scanner(System.in);
                System.out.println("Enter the month:");
                int month = Integer.parseInt(scaner.nextLine());
                int year = 1800; //год с которого начинаем считать
                int year1 = 1800;
                String NowDayOfWeek = calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.SHORT, Locale.US);
                int NowMonth = MonthCase(calendar.getDisplayName(Calendar.MONTH, Calendar.SHORT, Locale.US));
                int NowYear = 2016;

                       if (month > NowMonth && NowYear == year) NowYear--;//провер€ем не перепрыгнули мы текущий мес€ц
                       if (year <= NowYear && year >= 1800 && month >= 1 && month <= 12) {
                           calendar.set(Calendar.DAY_OF_MONTH, 13);
                           calendar.set(Calendar.MONTH, month);
                           calendar.set(Calendar.YEAR, year);

                                  while (year <= NowYear) {
                                  if (calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.SHORT, Locale.US) == FindDay) {
                                         k += 1;
                                         System.out.println(year);
                                     }
                                 year++;
                                 calendar.set(Calendar.YEAR, year);
                             }
                         System.out.println("\n" + "With the " + year1 + " the number of Fridays in the month of 13 " + (month+1) + "  is equal to " + k);
                    } else
                         System.out.println("Error!");
            }

                private static int MonthCase(String monthString){
                int month;
                switch (monthString) {
                        case "Jan": month = 1;
                                break;
                        case "Feb": month = 2;
                                break;
                        case "Mar": month = 3;
                                break;
                        case "Apr": month = 4;
                                break;
                        case "May": month = 5;
                                break;
                        case "Jun": month = 6;
                                break;
                        case "Jul": month = 7;
                                break;
                        case "Aug": month = 8;
                                break;
                        case "Sep": month = 9;
                                break;
                        case "Oct": month = 10;
                                break;
                        case "Nov": month = 11;
                                break;
                        case "Dec": month = 12;
                                break;
                        default: month = 15;
                                break;
                    }
                return month;
            }

}

