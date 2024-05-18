package calc;

import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.BorderLayout;

public class AboutDialog extends JDialog {
   public AboutDialog() {
      setTitle("About MyCalc");
      setBounds(100, 100, 250, 150);
      getContentPane().setLayout(new BorderLayout());
      {
         JLabel lblNewLabel = new JLabel("<html><center>MyCalc<br>Version 1.0<br>Author: Your Name</center></html>");
         getContentPane().add(lblNewLabel, BorderLayout.CENTER);
      }
   }
}
