
// Alexander Chukwuka
// The "MajicData" class.
import javax.swing.JOptionPane;

public class MajicData {
   public static void main(String[] args) {
      String d, y, m;
      int day, year, month, date;
      d = JOptionPane.showInputDialog("plese write a day");
      day = Integer.parseInt(d);

      y = JOptionPane.showInputDialog("please write a year");
      year = Integer.parseInt(y);

      m = JOptionPane.showInputDialog("please write a month");
      month = Integer.parseInt(m);

      date = day * month;

      {
         if (year < 3512) {
            if (date == year)
               JOptionPane.showMessageDialog(null, "This date is majic");
            else
               JOptionPane.showMessageDialog(null, "Not a majic date");
         } else
            JOptionPane.showMessageDialog(null, "error");
      }

      System.exit(0);

   }
} // main method
  // MajicData class
