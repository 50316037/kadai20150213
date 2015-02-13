package kadai;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import kadai.KadaiController;



public class Kadai_View extends Frame implements ActionListener,WindowListener {
	Button button1;
	TextArea text1 ;
	public Kadai_View(KadaiController controller) {
		// TODO Auto-generated constructor stub
		addWindowListener(this);
		setTitle("Kadai");
		text1 = new TextArea();
		add(text1, BorderLayout.CENTER);
		Panel pn1 = new Panel();
	    pn1.setLayout(new GridLayout(1, 3));
	    button1 = new Button("表示");
	    button1.addActionListener(this);
	    pn1.add(button1);
		add(pn1, BorderLayout.SOUTH);
		
		
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		System.exit(0);
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == button1) {
		      prefDisplay();
		    }
	}
	private void prefDisplay() {
		int month,precipitation ;
		String name;
		ResultSet rs;
		
		MySQL mysql = new MySQL();
		rs = mysql.selectAll();
		StringBuffer temp  = new StringBuffer();
		try {
			while(rs.next()){
				try {
					month = rs.getInt("month");
					name = rs.getString("name");
					precipitation = rs.getInt("precipitation");
					temp.append("月：" + month);
					temp.append("名前：" + name);
					temp.append("降水量：" + precipitation);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();

			    } //try catchで囲む
				text1.setText(temp.toString());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

}
