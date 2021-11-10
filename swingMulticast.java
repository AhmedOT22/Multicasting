package swing;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import multicast.Client;



public class swingMulticast extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField envoie;
	private JButton send;
	private JButton join;
	private JTextArea receive;
	private JTextField IP;
	private JTextField port;
	
	
	public swingMulticast() {
		super("Server");
		envoie = new JTextField(20);
		IP = new JTextField(16);
		port = new JTextField(5);
		JLabel label = new JLabel("Salon :");
		label.setFont(new Font("Buxton Sketch" , Font.BOLD, 18));
		label.setForeground(Color.red);
		send = new JButton("Send");
		send.setFont(new Font("Buxton Sketch" , Font.BOLD, 18));
		send.setForeground(Color.red);
		send.setFocusable(false);
		receive = new JTextArea();
		JPanel pp = new JPanel();
		pp.add(label);
		pp.add(IP);
		pp.add(port);
		join = new JButton("Join");
		join.addActionListener(this);
		join.setFont(new Font("Buxton Sketch" , Font.BOLD, 18));
		join.setForeground(Color.red);
		join.setFocusable(false);
		pp.add(join);
		add("North",pp);
		send.addActionListener(this);
		JPanel p =new JPanel();
		p.add(envoie);
		p.add(send);
		this.add("South",p);
		this.add("Center",new JScrollPane(receive));
		this.setSize(500, 600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	}


	public void send(){

		Client client = new Client();
		client.main(null);
		
	}

	public static void main(String[] args) {
		swingMulticast s =new swingMulticast();
		s.send();
		//s.receive();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton src = (JButton)e.getSource();
		switch (src.getText()) {
		case "Send":
			//	send();
			break;

		default:
			break;
		}

	}
}
