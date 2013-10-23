import javax.swing.JFrame;
public class RouletteDriver
{
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("Roulette");
		frame.setSize(500, 400);
		frame.setLocation(100, 50);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(new RoulettePanel());
		frame.setVisible(true);
	}
}