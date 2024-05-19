
package mycalc;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class MyCalc extends JFrame {
   
   private String exp = "";
   private static final long serialVersionUID = 1L;
   private JPanel contentPane;
   private JTextField textField;
   /**
    * @wbp.nonvisual location=559,234
    */
   private AboutDialog aboutDialog;

   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               MyCalc frame = new MyCalc();
               frame.setVisible(true);
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      });
   }

   /**
    * Create the frame.
    */
   public MyCalc() {
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100, 301, 382);
      
      JMenuBar menuBar = new JMenuBar();
      setJMenuBar(menuBar);
      
      JMenu mnNewMenu = new JMenu("Type");
      menuBar.add(mnNewMenu);
      
      JMenuItem mntmNewMenuItem_2 = new JMenuItem("표준화");
      mnNewMenu.add(mntmNewMenuItem_2);
      
      JMenuItem mntmNewMenuItem_3 = new JMenuItem("공학용");
      mnNewMenu.add(mntmNewMenuItem_3);
      
      JMenu mnNewMenu_1 = new JMenu("Help");
      menuBar.add(mnNewMenu_1);
      
      JMenuItem mntmNewMenuItem_1 = new JMenuItem("About");
      mntmNewMenuItem_1.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
      		getAboutDialog().setVisible(true);
      	}
      });
      mnNewMenu_1.add(mntmNewMenuItem_1);
      
      JMenuItem mntmNewMenuItem = new JMenuItem("Exit");
      mntmNewMenuItem.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
      		System.exit(0);
      	}
      });
      mnNewMenu_1.add(mntmNewMenuItem);
      contentPane = new JPanel();
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

      setContentPane(contentPane);
      contentPane.setLayout(new BorderLayout(0, 0));
      
      JPanel panel = new JPanel();
      contentPane.add(panel, BorderLayout.NORTH);
      panel.setLayout(new BorderLayout(0, 0));
      
      textField = new JTextField();
      textField.setFont(new Font("굴림", Font.PLAIN, 15));
      textField.setText("0");
      textField.setHorizontalAlignment(SwingConstants.RIGHT);
      textField.setEditable(false);
      panel.add(textField, BorderLayout.NORTH);
      textField.setColumns(10);
      
      JPanel panel_1 = new JPanel();
      FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
      flowLayout.setAlignment(FlowLayout.LEFT);
      contentPane.add(panel_1, BorderLayout.SOUTH);
      
      JLabel lblNewLabel = new JLabel("Status");
      panel_1.add(lblNewLabel);
      
      JPanel panel_2 = new JPanel();
      contentPane.add(panel_2, BorderLayout.CENTER);
      panel_2.setLayout(new GridLayout(5, 5, 10, 5));
      
      JButton btnNewButton = new JButton("7");
      btnNewButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            exp = exp + "7";
            textField.setText(exp);
         }
      });
      
      JButton btnNewButton_16 = new JButton("(");
      btnNewButton_16.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            exp = exp + "(";
            textField.setText(exp);
         }
      });
      btnNewButton_16.setFont(new Font("굴림", Font.BOLD, 15));
      panel_2.add(btnNewButton_16);
      
      JButton btnNewButton_17 = new JButton(")");
      btnNewButton_17.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            exp = exp + ")";
            textField.setText(exp);
         }
      });
      btnNewButton_17.setFont(new Font("굴림", Font.BOLD, 15));
      panel_2.add(btnNewButton_17);
      
      JButton btnNewButton_6 = new JButton("÷");
      btnNewButton_6.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            exp = exp + "/";
            textField.setText(exp);
         }
      });
      
      JButton btnNewButton_19 = new JButton("Del");
      btnNewButton_19.setFont(new Font("굴림", Font.PLAIN, 15));
      btnNewButton_19.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            if(exp.length() <= 1 ) {
               exp = "";
               textField.setText("0");
            }else{
               exp = exp.substring(0, exp.length()-1);
               textField.setText(exp);
            }
         }
      });
      panel_2.add(btnNewButton_19);
      btnNewButton_6.setFont(new Font("Dialog", Font.PLAIN, 20));
      panel_2.add(btnNewButton_6);
      btnNewButton.setFont(new Font("Dialog", Font.PLAIN, 15));
      panel_2.add(btnNewButton);
      
      JButton btnNewButton_5 = new JButton("8");
      btnNewButton_5.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            exp = exp + "8";
            textField.setText(exp);
         }
      });
      btnNewButton_5.setFont(new Font("Dialog", Font.PLAIN, 15));
      panel_2.add(btnNewButton_5);
      
      JButton btnNewButton_4 = new JButton("9");
      btnNewButton_4.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            exp = exp + "9";
            textField.setText(exp);
         }
      });
      btnNewButton_4.setFont(new Font("Dialog", Font.PLAIN, 15));
      panel_2.add(btnNewButton_4);
      
      JButton btnNewButton_7 = new JButton("4");
      btnNewButton_7.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            exp = exp + "4";
            textField.setText(exp);
         }
      });
      
      JButton btnNewButton_10 = new JButton("X");
      btnNewButton_10.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            exp = exp + "*";
            textField.setText(exp);
         }
      });
      btnNewButton_10.setFont(new Font("Dialog", Font.PLAIN, 15));
      panel_2.add(btnNewButton_10);
      btnNewButton_7.setFont(new Font("Dialog", Font.PLAIN, 15));
      panel_2.add(btnNewButton_7);
      
      JButton btnNewButton_8 = new JButton("5");
      btnNewButton_8.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            exp = exp + "5";
            textField.setText(exp);
         }
      });
      btnNewButton_8.setFont(new Font("Dialog", Font.PLAIN, 15));
      panel_2.add(btnNewButton_8);
      
      JButton btnNewButton_9 = new JButton("6");
      btnNewButton_9.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            exp = exp + "6";
            textField.setText(exp);
         }
      });
      btnNewButton_9.setFont(new Font("Dialog", Font.PLAIN, 15));
      panel_2.add(btnNewButton_9);
      
      JButton btnNewButton_11 = new JButton("1");
      btnNewButton_11.setFont(new Font("Dialog", Font.PLAIN, 15));
      btnNewButton_11.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            exp = exp + "1";
            textField.setText(exp);
         }
      });
      
      JButton btnNewButton_13 = new JButton("-");
      btnNewButton_13.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            exp = exp + "-";
            textField.setText(exp);
         }
      });
      btnNewButton_13.setFont(new Font("Dialog", Font.PLAIN, 20));
      panel_2.add(btnNewButton_13);
      panel_2.add(btnNewButton_11);
      
      JButton btnNewButton_12 = new JButton("2");
      btnNewButton_12.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            exp = exp + "2";
            textField.setText(exp);
         }
      });
      btnNewButton_12.setFont(new Font("Dialog", Font.PLAIN, 15));
      panel_2.add(btnNewButton_12);
      
      JButton btnNewButton_3 = new JButton("3");
      btnNewButton_3.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            exp = exp + "3";
            textField.setText(exp);
         }
      });
      btnNewButton_3.setFont(new Font("Dialog", Font.PLAIN, 15));
      panel_2.add(btnNewButton_3);
      
      JButton btnNewButton_2 = new JButton("+");
      btnNewButton_2.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            exp = exp + "+";
            textField.setText(exp);
         }
      });
      btnNewButton_2.setFont(new Font("Dialog", Font.PLAIN, 20));
      panel_2.add(btnNewButton_2);
      
      JButton btnNewButton_14 = new JButton("0");
      btnNewButton_14.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            exp = exp + "0";
            textField.setText(exp);
         }
      });
      
      JButton btnNewButton_18 = new JButton("+/-");
      btnNewButton_18.setFont(new Font("굴림", Font.BOLD, 15));
      btnNewButton_18.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            if (!exp.isEmpty()) {
					try {
						double num = Double.parseDouble(exp);
						num = -num;
						exp = String.valueOf(num);
					} catch (NumberFormatException ex) {
						int lastOpIndex = Math.max(exp.lastIndexOf('+'), Math.max(exp.lastIndexOf('-'), Math.max(exp.lastIndexOf('*'), exp.lastIndexOf('/'))));
						if (lastOpIndex != -1) {
							String lastNum = exp.substring(lastOpIndex + 1);
							if (!lastNum.isEmpty()) {
								double num = Double.parseDouble(lastNum);
								num = -num;
								exp = exp.substring(0, lastOpIndex + 1) + num;
							}
						} else {
							double num = Double.parseDouble(exp);
							num = -num;
							exp = String.valueOf(num);
						}
					}
					textField.setText(exp);
        	 }
         }
      });
      panel_2.add(btnNewButton_18);
      btnNewButton_14.setFont(new Font("Dialog", Font.PLAIN, 15));
      panel_2.add(btnNewButton_14);
      
      JButton btnNewButton_1 = new JButton("=");
      btnNewButton_1.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            String postfix = Infix2Postfix.convert(exp);
            double value = Calc.eval(postfix);
            textField.setText(String.valueOf(value));
         }
      });
      
      JButton btnNewButton_15 = new JButton("C");
      btnNewButton_15.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            exp = "";
            textField.setText("0");
         }
      });
      btnNewButton_15.setFont(new Font("Dialog", Font.PLAIN, 15));
      panel_2.add(btnNewButton_15);
      btnNewButton_1.setFont(new Font("Dialog", Font.PLAIN, 20));
      panel_2.add(btnNewButton_1);
   }

	public AboutDialog getAboutDialog() {
		if(aboutDialog == null) {
			aboutDialog = new AboutDialog();
		}
		return aboutDialog;
	}
}