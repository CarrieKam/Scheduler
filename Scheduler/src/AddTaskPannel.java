import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import interfaces.NewTaskListener;

public class AddTaskPannel extends JFrame {

	private JPanel contentPane;
	private JLabel lblAddNewTask;
	private JTextField textFieldName;
	private JTextField textFieldDate;
	private JTextField textFieldTime;
	private JTextField textDescription;

	private ArrayList<NewTaskListener> listListener = new ArrayList<NewTaskListener>();

	private Task task;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddTaskPannel frame = new AddTaskPannel();
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
	public AddTaskPannel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 935, 690);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension ecranDimension = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(ecranDimension.width / 2 - getSize().width / 2, ecranDimension.height / 2 - getSize().height / 2);

		task = new Task();

		lblAddNewTask = new JLabel("Add New Task");
		lblAddNewTask.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 26));
		lblAddNewTask.setBounds(330, 29, 172, 27);
		contentPane.add(lblAddNewTask);

		JLabel lblTaskName = new JLabel("Task name :");
		lblTaskName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTaskName.setBounds(57, 101, 108, 27);
		contentPane.add(lblTaskName);

		textFieldName = new JTextField();
		textFieldName.setBounds(227, 101, 562, 32);
		contentPane.add(textFieldName);
		textFieldName.setColumns(10);

		
		JLabel lblDate = new JLabel("Date :");
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDate.setBounds(108, 166, 57, 13);
		contentPane.add(lblDate);

		textFieldDate = new JTextField();

		textFieldDate.setBounds(227, 160, 562, 32);
		contentPane.add(textFieldDate);
		textFieldDate.setColumns(10);

		JLabel lblDateFormat = new JLabel("e.g. (mm/dd/yyyy)");
		lblDateFormat.setForeground(Color.GRAY);
		lblDateFormat.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDateFormat.setBounds(237, 202, 172, 27);
		contentPane.add(lblDateFormat);

		JLabel lblTime = new JLabel("Time :");
		lblTime.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTime.setBounds(108, 252, 57, 13);
		contentPane.add(lblTime);

		textFieldTime = new JTextField();

		textFieldTime.setColumns(10);
		textFieldTime.setBounds(227, 246, 562, 32);
		contentPane.add(textFieldTime);

		JLabel lblTimeFormat = new JLabel("e.g. (hh:mm)");
		lblTimeFormat.setForeground(Color.GRAY);
		lblTimeFormat.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTimeFormat.setBounds(237, 288, 172, 27);
		contentPane.add(lblTimeFormat);

		JLabel lblDescription = new JLabel("Description :");
		lblDescription.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDescription.setBounds(57, 351, 108, 27);
		contentPane.add(lblDescription);

		textDescription = new JTextField();
		textDescription.setBounds(227, 351, 562, 218);
		contentPane.add(textDescription);
		textDescription.setColumns(10);

		JButton btnSave = new JButton("Save");
		btnSave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				leverModeAccueil();
			}
		});

		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSave.setBounds(813, 600, 86, 39);
		contentPane.add(btnSave);

		setLocationRelativeTo(null);
		setTitle("Add New Task");

	}

	public void addNewTaskListener(NewTaskListener objEcout) {
		listListener.add(objEcout);
	}

	private void leverModeAccueil() {
		for (NewTaskListener objEcout : listListener) {
			objEcout.modeHome(true);
		}
		for (NewTaskListener objEcout : listListener) {
			objEcout.setName(textFieldName.getText());
			objEcout.setTime(textFieldTime.getText());
			objEcout.setDate(textFieldDate.getText());
			objEcout.setDescription(textDescription.getText());
			
			textFieldDate.setText("");
			textFieldTime.setText("");
			textFieldName.setText("");
			textDescription.setText("");
;		}
	
	}
}
