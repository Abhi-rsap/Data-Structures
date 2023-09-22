package net.codejava.swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import java.awt.CardLayout;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import javax.swing.border.TitledBorder;
import java.awt.ComponentOrientation;
import java.awt.GridLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.JComboBox;
import java.awt.Point;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.Window.Type;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class PolyApp extends JFrame {
	private JTextField p1coe1;
	private JTextField p1coe0;
	private JTextField p2coe2;
	private JTextField p2coe1;
	private JTextField p2coe0;
	private JTextField p3coe3;
	private JTextField p3coe2;
	private JTextField p3coe1;
	private JTextField p3coe0;
	private int d1, d2;
	private JTextField p1co1_2;
	private JTextField p1co0_2;
	private JTextField p2co2_2;
	private JTextField p2co1_2;
	private JTextField p2co0_2;
	private JTextField p3co3_2;
	private JTextField p3co2_2;
	private JTextField p3co1_2;
	private JTextField p3co0_2;
	private JComboBox degree;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PolyApp frame = new PolyApp();
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
	public PolyApp() {

		setTitle("Polynomial Calculator");
		getContentPane().setLayout(new MigLayout("", "[grow][grow]", "[][grow]"));

		JLabel lblDegree = new JLabel("Degree of the polynomial :");
		lblDegree.setFont(new Font("Tahoma", Font.PLAIN, 15));
		getContentPane().add(lblDegree, "flowx,cell 0 0");

		JLayeredPane layeredPane = new JLayeredPane();
		getContentPane().add(layeredPane, "cell 0 1,grow");

		JPanel Power_two = new JPanel();
		Power_two.setBounds(-6, 0, 472, 36);
		layeredPane.add(Power_two);
		Power_two.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		p2coe2 = new JTextField();
		p2coe2.setColumns(10);
		Power_two.add(p2coe2);

		JLabel lblX_1 = new JLabel("x^2  +  ");
		lblX_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Power_two.add(lblX_1);

		p2coe1 = new JTextField();
		p2coe1.setColumns(10);
		Power_two.add(p2coe1);

		JLabel lblX_1_1 = new JLabel("x  +  ");
		lblX_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Power_two.add(lblX_1_1);

		p2coe0 = new JTextField();
		Power_two.add(p2coe0);
		p2coe0.setColumns(10);

		layeredPane.remove(Power_two);

		JPanel Power_One = new JPanel();
		layeredPane.add(Power_One);
		Power_One.setBounds(new Rectangle(1, 0, 336, 36));
		Power_One.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		Power_One.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		p1coe1 = new JTextField();
		Power_One.add(p1coe1);
		p1coe1.setColumns(10);

		JLabel lblX = new JLabel("x  +  ");
		lblX.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Power_One.add(lblX);

		p1coe0 = new JTextField();
		Power_One.add(p1coe0);
		p1coe0.setColumns(10);
		layeredPane.remove(Power_One);

		JPanel Power_three = new JPanel();
		Power_three.setBounds(2, 0, 561, 63);
		layeredPane.add(Power_three);
		Power_three.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		p3coe3 = new JTextField();
		p3coe3.setColumns(10);
		Power_three.add(p3coe3);

		JLabel lblX_1_2 = new JLabel("x^3  +  ");
		lblX_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Power_three.add(lblX_1_2);

		p3coe2 = new JTextField();
		p3coe2.setColumns(10);
		Power_three.add(p3coe2);

		JLabel lblX_1_1_1 = new JLabel("x ^2 +  ");
		lblX_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Power_three.add(lblX_1_1_1);

		p3coe1 = new JTextField();
		p3coe1.setColumns(10);
		Power_three.add(p3coe1);

		JLabel lblX_1_1_2 = new JLabel("x  +  ");
		lblX_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Power_three.add(lblX_1_1_2);

		p3coe0 = new JTextField();
		p3coe0.setColumns(10);
		Power_three.add(p3coe0);
		layeredPane.remove(Power_three);

		JButton btnSolveMe = new JButton("Solve ME!");
		layeredPane.remove(btnSolveMe);
		btnSolveMe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				polysolver g = new polysolver();
				g.solveP2(Float.parseFloat(p2coe2.getText()), Float.parseFloat(p2coe1.getText()),
						Float.parseFloat(p2coe0.getText()));
				String s = "Root 1: ";
				s = s + Float.toString(g.getP2x1()) + "   Root 2 : " + Float.toString(g.getP2x2());
				JOptionPane.showMessageDialog(PolyApp.this, s);
			}
		});
		btnSolveMe.setBounds(199, 97, 126, 27);
		// layeredPane.add(btnSolveMe);
		btnSolveMe.setFont(new Font("Tahoma", Font.PLAIN, 15));
		JLabel lblDegree_1 = new JLabel("Degree of the polynomial :");
		lblDegree_1.setBounds(10, 148, 179, 19);
		layeredPane.add(lblDegree_1);
		lblDegree_1.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JComboBox degree2 = new JComboBox();

		degree2.setModel(new DefaultComboBoxModel(new String[] { "1", "2", "3" }));
		degree2.setBounds(199, 149, 43, 21);
		layeredPane.add(degree2);

		JPanel PowerOne2 = new JPanel();
		PowerOne2.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		PowerOne2.setBounds(new Rectangle(1, 0, 336, 36));
		PowerOne2.setBounds(10, 197, 336, 36);
		layeredPane.add(PowerOne2);
		PowerOne2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		p1co1_2 = new JTextField();
		p1co1_2.setColumns(10);
		PowerOne2.add(p1co1_2);

		JLabel lblX_2 = new JLabel("x  +  ");
		lblX_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		PowerOne2.add(lblX_2);

		p1co0_2 = new JTextField();
		p1co0_2.setColumns(10);
		PowerOne2.add(p1co0_2);
		layeredPane.remove(PowerOne2);

		JPanel Powertwo2 = new JPanel();
		Powertwo2.setBounds(10, 197, 472, 36);
		layeredPane.add(Powertwo2);
		Powertwo2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		p2co2_2 = new JTextField();
		p2co2_2.setColumns(10);
		Powertwo2.add(p2co2_2);

		JLabel lblX_1_3 = new JLabel("x^2  +  ");
		lblX_1_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Powertwo2.add(lblX_1_3);

		p2co1_2 = new JTextField();
		p2co1_2.setColumns(10);
		Powertwo2.add(p2co1_2);

		JLabel lblX_1_1_3 = new JLabel("x  +  ");
		lblX_1_1_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Powertwo2.add(lblX_1_1_3);

		p2co0_2 = new JTextField();
		p2co0_2.setColumns(10);
		Powertwo2.add(p2co0_2);
		layeredPane.remove(Powertwo2);

		JPanel Powerthree2 = new JPanel();
		Powerthree2.setBounds(1, 198, 561, 63);
		layeredPane.add(Powerthree2);
		Powerthree2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		p3co3_2 = new JTextField();
		p3co3_2.setColumns(10);
		Powerthree2.add(p3co3_2);

		JLabel lblX_1_2_1 = new JLabel("x^3  +  ");
		lblX_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Powerthree2.add(lblX_1_2_1);

		p3co2_2 = new JTextField();
		p3co2_2.setColumns(10);
		Powerthree2.add(p3co2_2);

		JLabel lblX_1_1_1_1 = new JLabel("x ^2 +  ");
		lblX_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Powerthree2.add(lblX_1_1_1_1);

		p3co1_2 = new JTextField();
		p3co1_2.setColumns(10);
		Powerthree2.add(p3co1_2);

		JLabel lblX_1_1_2_1 = new JLabel("x  +  ");
		lblX_1_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Powerthree2.add(lblX_1_1_2_1);

		p3co0_2 = new JTextField();
		p3co0_2.setColumns(10);
		Powerthree2.add(p3co0_2);
		layeredPane.remove(Powerthree2);

		JLabel lblChooseAnyOne = new JLabel("Choose any one of the following options:");
		lblChooseAnyOne.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblChooseAnyOne.setBounds(1, 271, 279, 19);
		layeredPane.add(lblChooseAnyOne);

		JRadioButton rdbtnAdd = new JRadioButton("ADD");
		buttonGroup.add(rdbtnAdd);
		rdbtnAdd.setBounds(277, 272, 56, 21);
		layeredPane.add(rdbtnAdd);

		JRadioButton rdbtnSubtract = new JRadioButton("SUBTRACT");
		buttonGroup.add(rdbtnSubtract);
		rdbtnSubtract.setBounds(277, 296, 98, 21);
		layeredPane.add(rdbtnSubtract);

		JRadioButton rdbtnMultiply = new JRadioButton("MULTIPLY");
		buttonGroup.add(rdbtnMultiply);
		rdbtnMultiply.setBounds(277, 323, 122, 21);
		layeredPane.add(rdbtnMultiply);

		JButton btnCalculate = new JButton("GET ANSWER!");
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				polysolver a = new polysolver();
				polysolver b = new polysolver();
				polysolver c = new polysolver();
				if (degree.getSelectedItem() == "1") {
					a.insert(Float.parseFloat(p1coe1.getText()), 1);
					a.insert(Float.parseFloat(p1coe0.getText()), 0);

				} else if (degree.getSelectedItem() == "2") {
					a.insert(Float.parseFloat(p2coe2.getText()), 2);
					a.insert(Float.parseFloat(p2coe1.getText()), 1);
					a.insert(Float.parseFloat(p2coe0.getText()), 0);

				} else if (degree.getSelectedItem() == "3") {

					a.insert(Float.parseFloat(p3coe3.getText()), 3);
					a.insert(Float.parseFloat(p3coe2.getText()), 2);
					a.insert(Float.parseFloat(p3coe1.getText()), 1);
					a.insert(Float.parseFloat(p3coe0.getText()), 0);

				}

				if (degree2.getSelectedItem() == "1") {

					b.insert(Float.parseFloat(p1co1_2.getText()), 1);
					b.insert(Float.parseFloat(p1co0_2.getText()), 0);
				} else if (degree2.getSelectedItem() == "2") {

					b.insert(Float.parseFloat(p2co2_2.getText()), 2);
					b.insert(Float.parseFloat(p2co1_2.getText()), 1);
					b.insert(Float.parseFloat(p2co0_2.getText()), 0);
				} else if (degree2.getSelectedItem() == "3") {
					b.insert(Float.parseFloat(p3co3_2.getText()), 3);
					b.insert(Float.parseFloat(p3co2_2.getText()), 2);
					b.insert(Float.parseFloat(p3co1_2.getText()), 1);
					b.insert(Float.parseFloat(p3co0_2.getText()), 0);

				}
				if (rdbtnAdd.isSelected() == true) {
					c = a.add(b);
					String message = "The resultant polynomial is :  " + c.display();
					JOptionPane.showMessageDialog(PolyApp.this, message);
				} else if (rdbtnSubtract.isSelected() == true) {
					c = a.sub(b);
					String message = "The resultant polynomial is :  " + c.display();
					JOptionPane.showMessageDialog(PolyApp.this, message);
				} else if (rdbtnMultiply.isSelected() == true) {
					c = a.mult(b);
					String message = "The resultant polynomial is :  " + c.display();
					JOptionPane.showMessageDialog(PolyApp.this, message);
				}

			}
		});
		btnCalculate.setBounds(10, 383, 139, 27);
		layeredPane.add(btnCalculate);

		degree2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				layeredPane.remove(PowerOne2);
				layeredPane.remove(Powertwo2);
				layeredPane.remove(Powerthree2);
				if (degree2.getSelectedItem().toString() == "1") {
					d1 = 1;
					layeredPane.remove(Powertwo2);
					layeredPane.add(PowerOne2);
					layeredPane.repaint();
					layeredPane.revalidate();
				} else if (degree2.getSelectedItem().toString() == "2") {
					d1 = 2;
					layeredPane.remove(PowerOne2);
					layeredPane.add(Powertwo2);
					layeredPane.repaint();
					layeredPane.revalidate();
				} else if (degree2.getSelectedItem().toString() == "3") {
					d1 = 3;
					layeredPane.remove(PowerOne2);
					layeredPane.add(Powerthree2);
					layeredPane.repaint();
					layeredPane.revalidate();
				}

			}
		});

		degree = new JComboBox();
		degree.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				layeredPane.remove(Power_One);
				layeredPane.remove(Power_two);
				layeredPane.remove(Power_three);
				if (degree.getSelectedItem().toString() == "1") {
					d1 = 1;
					layeredPane.remove(btnSolveMe);
					layeredPane.remove(Power_two);
					layeredPane.add(Power_One);
					layeredPane.repaint();
					layeredPane.revalidate();
				} else if (degree.getSelectedItem().toString() == "2") {
					d1 = 2;
					layeredPane.add(btnSolveMe);
					layeredPane.remove(Power_One);
					layeredPane.add(Power_two);
					layeredPane.repaint();
					layeredPane.revalidate();
				} else if (degree.getSelectedItem().toString() == "3") {
					d1 = 3;
					layeredPane.remove(btnSolveMe);
					layeredPane.remove(Power_One);
					layeredPane.add(Power_three);
					layeredPane.repaint();
					layeredPane.revalidate();
				}

			}

		});

		degree.setModel(new DefaultComboBoxModel(new String[] { "1", "2", "3" }));
		degree.setLocation(new Point(1, 10));
		degree.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		getContentPane().add(degree, "cell 0 0");
	}
}
