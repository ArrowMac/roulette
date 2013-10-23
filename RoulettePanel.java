   import javax.swing.*;
   import java.awt.*;
   import java.awt.event.*;
   public class RoulettePanel extends JPanel
   {
      private JTextField bet, guess;
      private JLabel label1, label2, label3, label4, label5, label6, label7, label8, label9, label10, label11, label12;
      private int num, points;
      public RoulettePanel()
      {
         setLayout(new BorderLayout());
         setBackground(Color.green.brighter());
         num = 0;
         points = 100;
      	
         label1 = new JLabel("Number: ?", SwingConstants.CENTER);
         label1.setFont(new Font("Serif", Font.BOLD, 50));
         add(label1, BorderLayout.NORTH);
      	
         label2 = new JLabel("Money: $"+ points, SwingConstants.CENTER);
         label2.setFont(new Font("Serif", Font.BOLD, 50));
         add(label2, BorderLayout.SOUTH);
      	
         JPanel panel = new JPanel();
         panel.setLayout(new GridLayout(4,3,10,10));
         panel.setBackground(Color.red);
         add(panel, BorderLayout.CENTER);
      	
         JButton even = new JButton("Even");
         even.addActionListener(new ListenerEven());
         panel.add(even);
      	
         JButton odd = new JButton("Odd");
         odd.addActionListener(new ListenerOdd());
         panel.add(odd);
      	
         JButton green = new JButton("Green");
         green.addActionListener(new ListenerGreen());
         panel.add(green);
      	
         JButton first = new JButton("1st 12");
         first.addActionListener(new ListenerFirst());
         panel.add(first);
      	
         JButton second = new JButton("2nd 12");
         second.addActionListener(new ListenerSecond());
         panel.add(second);
      	
         JButton third = new JButton("3rd 12");
         third.addActionListener(new ListenerThird());
         panel.add(third);
      	
         label10 = new JLabel("One Number:");
         label10.setFont(new Font("Serif", Font.PLAIN, 20));
         panel.add(label10);
      	
         guess = new JTextField("");
         guess.setFont(new Font("Serif", Font.PLAIN, 30));
         guess.setHorizontalAlignment(SwingConstants.RIGHT);
         panel.add(guess);
      	
         JButton single = new JButton("Single #");
         single.addActionListener(new ListenerSingle());
         panel.add(single);
      	
         label9 = new JLabel("Place Bet:");
         label9.setFont(new Font("Serif", Font.PLAIN, 20));
         panel.add(label9);
      	
         bet = new JTextField("0");
         bet.setFont(new Font("Serif", Font.PLAIN, 30));
         bet.setHorizontalAlignment(SwingConstants.RIGHT);
         panel.add(bet);
      	
         label12 = new JLabel("--");
         label12.setFont(new Font("Serif", Font.ITALIC, 35));
			label12.setForeground(Color.green);
			label12.setHorizontalAlignment(SwingConstants.CENTER);
         panel.add(label12);
      	
         JPanel key = new JPanel();
         key.setLayout(new GridLayout(7,1,10,10));
         key.setBackground(Color.red);
         add(key, BorderLayout.EAST);
      	
         label3 = new JLabel("Even: x2");
         label3.setFont(new Font("Serif", Font.BOLD, 20));
         label3.setForeground(Color.green.brighter());
         key.add(label3);
      	
         label4 = new JLabel("Odd: x2");
         label4.setFont(new Font("Serif", Font.BOLD, 20));
         label4.setForeground(Color.green.brighter());
         key.add(label4);
      	
         label5 = new JLabel("Green: x17");
         label5.setFont(new Font("Serif", Font.BOLD, 20));
         label5.setForeground(Color.green.brighter());
         key.add(label5);
      	
         label6 = new JLabel("1st 12: x3");
         label6.setFont(new Font("Serif", Font.BOLD, 20));
         label6.setForeground(Color.green.brighter());
         key.add(label6);
      	
         label7 = new JLabel("2nd 12: x3");
         label7.setFont(new Font("Serif", Font.BOLD, 20));
         label7.setForeground(Color.green.brighter());
         key.add(label7);
      	
         label8 = new JLabel("3rd 12: x3");
         label8.setFont(new Font("Serif", Font.BOLD, 20));
         label8.setForeground(Color.green.brighter());
         key.add(label8);
      	
         label11 = new JLabel("Single #: x35");
         label11.setFont(new Font("Serif", Font.BOLD, 20));
         label11.setForeground(Color.green.brighter());
         key.add(label11);
      }
      private class ListenerEven implements ActionListener
      {
         public void actionPerformed(ActionEvent e)
         {
            num = (int)(Math.random() * 37);
            label1.setText("Number: "+ num);
            int b = Integer.parseInt(bet.getText());
            if(points >= b && b > 0)
            {
               if(num % 2 == 0 && num > 0)
               {
                  points = points + b * 2;
                  label12.setText("Win!");
               }
               else
               {
                  points = points - b;
                  label12.setText("Lose.");
               }
            }
            label2.setText("Money: $"+ points);
         }
      }
      private class ListenerOdd implements ActionListener
      {
         public void actionPerformed(ActionEvent e)
         {
            num = (int)(Math.random() * 37);
            label1.setText("Number: "+ num);
            int b = Integer.parseInt(bet.getText());
            if(points >= b && b > 0)
            {
               if(num % 2 == 0 && num > 0)
					{
                  points = points - b;
						label12.setText("Lose.");
					}
               else
					{
                  points = points + b * 2;
						label12.setText("Win!");
					}
            }
            label2.setText("Money: $"+ points);
         }
      }
      private class ListenerGreen implements ActionListener
      {
         public void actionPerformed(ActionEvent e)
         {
            num = (int)(Math.random() * 37);
            label1.setText("Number: "+ num);
            int b = Integer.parseInt(bet.getText());
            if(points >= b && b > 0)
            {
               if(num == 0 || num == 1)
					{
                  points = points + b * 17;
						label12.setText("Win!");
					}
               else
					{
                  points = points - b;
						label12.setText("Lose.");
					}
            }
            label2.setText("Money: $"+ points);
         }
      }
      private class ListenerFirst implements ActionListener
      {
         public void actionPerformed(ActionEvent e)
         {
            num = (int)(Math.random() * 37);
            label1.setText("Number: "+ num);
            int b = Integer.parseInt(bet.getText());
            if(points >= b && b > 0)
            {
               if(num <= 12)
					{
                  points = points + b * 3;
						label12.setText("Win!");
					}
               else
					{
                  points = points - b;
						label12.setText("Lose.");
					}
            }
            label2.setText("Money: $"+ points);
         }
      }
      private class ListenerSecond implements ActionListener
      {
         public void actionPerformed(ActionEvent e)
         {
            num = (int)(Math.random() * 37);
            int b = Integer.parseInt(bet.getText());
            if(points >= b && b > 0)
            {
               label1.setText("Number: "+ num);
               if(num > 12 && num <= 24)
					{
                  points = points + b * 3;
						label12.setText("Win!");
					}
               else
					{
                  points = points - b;
						label12.setText("Lose.");
					}
            }
            label2.setText("Money: $"+ points);
         }
      }
      private class ListenerThird implements ActionListener
      {
         public void actionPerformed(ActionEvent e)
         {
            num = (int)(Math.random() * 37);
            label1.setText("Number: "+ num);
            int b = Integer.parseInt(bet.getText());
            if(points >= b && b > 0)
            {
               if(num > 24)
					{
                  points = points + b * 3;
						label12.setText("Win!");
					}
               else
					{
                  points = points - b;
						label12.setText("Lose.");
					}
            }
            label2.setText("Money: $"+ points);
         }
      }
      private class ListenerSingle implements ActionListener
      {
         public void actionPerformed(ActionEvent e)
         {
            num = (int)(Math.random() * 37);
            label1.setText("Number: "+ num);
            int b = Integer.parseInt(bet.getText());
            int g = Integer.parseInt(guess.getText());
            if(points >= b && b > 0 && g <= 36 && g >= 0)
            {
               if(g == num)
					{
                  points = points + b * 35;
						label12.setText("Win!");
					}
               else
					{
                  points = points - b;
						label12.setText("Lose.");
					}
            }
            label2.setText("Money: $"+ points);
         }
      }
   }