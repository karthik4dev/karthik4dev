import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.*;

import javax.swing.*;

public class SwingsDemo extends JFrame implements ActionListener {

	JButton b ;
	JLabel l;
	int count =0 ;
	JTextField jt = new JTextField("Count is ",10);
	
	
	public SwingsDemo() {
	b = new JButton("count");
	l=new JLabel("Count is "+count);
	
	jt.setEditable(false);
	b.addActionListener(this);
	b.setDefaultCapable(true);b.setBackground(new Color(3,22,11));
	setLayout(new FlowLayout());
	
	add(b);
	add(l);
	add(jt);
	
			
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		count++;
		l.setText("Count is  "+count);
		jt.setText("Count is  "+count);
	}
	
	public static void main(String[] args) {
		SwingsDemo sd = new SwingsDemo();
		sd.setVisible(true);
		sd.setSize(1000,800);
		sd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
