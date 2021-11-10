package multicast;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class Client extends JFrame  implements ActionListener
{
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


	public Client() {
		// TODO Auto-generated constructor stub
		super("Client ");
	}
	public void graphics()
	{
		envoie = new JTextField(20);
		IP = new JTextField(16);
		port = new JTextField(5);
		JLabel label = new JLabel("Salon :");
		label.setFont(new Font("Buxton Sketch" , Font.BOLD, 18));
		label.setForeground(Color.BLUE);
		send = new JButton("Send");
		send.setFocusable(false);
		send.setFont(new Font("Buxton Sketch" , Font.BOLD, 18));
		send.setForeground(Color.BLUE);
		receive = new JTextArea();
		JPanel pp = new JPanel();
		pp.add(label);
		pp.add(IP);
		pp.add(port);
		join = new JButton("Join");
		join.setFocusable(false);
		join.setFont(new Font("Buxton Sketch" , Font.BOLD, 18));
		join.setForeground(Color.BLUE);
		join.addActionListener(this);
		pp.add(join);
		add("North",pp);
		send.addActionListener(this);
		JPanel p =new JPanel();
		p.add(envoie);
		p.add(send);
		this.add("South",p);
		this.add("Center",new JScrollPane(receive));
		this.setSize(500, 600);
		this.setSize(500, 600);
		//setName("Client Multi Cast");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	}

	public void send()
	{
		try 
		{
			String message=envoie.getText();
			receive.append(envoie.getText());;
			byte[] buffer = new byte[1024];
			buffer= message.getBytes();
			String salon=IP.getText();
			InetAddress iaGroupe = InetAddress.getByName(salon);
			int portD=5555;
			DatagramPacket lettre = new DatagramPacket(buffer, buffer.length , iaGroupe,portD);
			MulticastSocket ms = new MulticastSocket();
			ms.send(lettre);

		} catch (Exception e) 
		{
			System.out.println("Erreur :" + e.getMessage());
		}
	}


	public static void main(String[] args)
	{
		Client c = new Client();
		c.graphics();

		//c.send();
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		JButton src = (JButton)e.getSource();
		if(src.getText().equals("Join"))
		{
			Server s = new Server();
			s.receive();
		}
		else
		{
			send();
		}

	}
}
