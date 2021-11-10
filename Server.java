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

public class Server  extends JFrame  implements ActionListener
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

	public Server() {
		// TODO Auto-generated constructor stub
		super("Server");
	}

	public void graphics()
	{
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
		join.setFocusable(false);
		join.setFont(new Font("Buxton Sketch" , Font.BOLD, 18));
		join.setForeground(Color.red);
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
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	}

	public void receive()
	{
		try 
		{
			int portR=5555;
			MulticastSocket ms = new MulticastSocket(portR);
			byte [] bufferR = new byte[1024];
			DatagramPacket lettreR = new DatagramPacket(bufferR, bufferR.length);
			String salon = "224.100.100.100";
			InetAddress idGroupe=InetAddress.getByName(salon);
			ms.joinGroup(idGroupe);
			ms.receive(lettreR);

			receive.append("\n Message: "+( new String(lettreR.getData())));
			System.out.println("Message recu est  : ..." +(new String(lettreR.getData())));
			ms.leaveGroup(idGroupe);

		} catch (Exception e) 
		{
			System.out.println("Erreur :" + e.getMessage());
		}
	}


	public static void main(String[] args) 
	{
		Server s = new Server();
		s.graphics();
		//s.receive();

	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		JButton src = (JButton)e.getSource();
		if(src.getText().equals("Join"))
		{
			receive();
		}
		else
		{
			
		}

	}
}
