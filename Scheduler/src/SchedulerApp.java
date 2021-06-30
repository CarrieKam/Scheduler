import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SchedulerApp extends JFrame {

	private JPanel contentPane;
	
	private AddTaskPannel taskPannel;
	
	private ArrayList<Task> taskList = new ArrayList<>();
	
	private JLabel lblTitle;
	private JLabel lblNewLabel;
	private JLabel lblTime;
	private JLabel lblTask;
	private JScrollPane scrollPane;
	private JButton btnAddTask;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SchedulerApp frame = new SchedulerApp();
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
	public SchedulerApp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 837, 505);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		setTitle("Scheduler");

		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension ecranDimension = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(ecranDimension.width / 2 - getSize().width / 2, ecranDimension.height / 2 - getSize().height / 2);

		setLocationRelativeTo(null);
		
		taskPannel = new AddTaskPannel();
		
		lblTitle = new JLabel("Scheduler");
		lblTitle.setFont(new Font("Source Sans Pro", Font.BOLD, 26));
		lblTitle.setBounds(340, 11, 171, 32);
		contentPane.add(lblTitle);

		lblNewLabel = new JLabel("Date:");
		lblNewLabel.setFont(new Font("Tw Cen MT", Font.BOLD, 21));
		lblNewLabel.setBounds(65, 72, 130, 32);
		contentPane.add(lblNewLabel);

		lblTime = new JLabel("Time:");
		lblTime.setFont(new Font("Tw Cen MT", Font.BOLD, 21));
		lblTime.setBounds(152, 72, 96, 32);
		contentPane.add(lblTime);

		lblTask = new JLabel("Tasks:");
		lblTask.setFont(new Font("Tw Cen MT", Font.BOLD, 21));
		lblTask.setBounds(279, 72, 130, 32);
		contentPane.add(lblTask);

		scrollPane = new JScrollPane();
		scrollPane.setEnabled(false);
		scrollPane.setBounds(20, 103, 770, 306);
		contentPane.add(scrollPane);

		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setEditable(false);
		textArea.setLineWrap(true);
		
		btnAddTask = new JButton("Add task");
		btnAddTask.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!taskPannel.isVisible()) {
					taskPannel.setVisible(true);
					setVisible(false);
				}		
			}
		});
		btnAddTask.setBounds(30, 424, 130, 32);
		contentPane.add(btnAddTask);
	}
}
