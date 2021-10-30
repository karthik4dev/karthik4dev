import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonDemo extends Frame implements ActionListener{


	Label l;
	Button b ;
	Button add;
	int count = 0;

	public ButtonDemo() throws HeadlessException {
		super("Application Demo");

		setLayout(new FlowLayout());

		l =new Label(""+count);
		b = new Button("Count");
		add = new Button("Add +2 ");
		b.addActionListener(this);

		add.addActionListener(this);

		add(l);
		add(b);
		add(add);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equalsIgnoreCase("Count")) {
			count++;
		}
		if (e.getActionCommand().equalsIgnoreCase("Add +2 ")) {
			count = count +2;
		}
		l.setText("   "+count);

	}

	public static void main(String[] args) {
		ButtonDemo bd = new ButtonDemo();
		bd.setSize(500,500);
		bd.setVisible(true);
	}

}
