import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import interfaces.NewTaskListener;

public class SchedulerApp extends JFrame {

	private JPanel contentPane;

	private AddTaskPannel taskPannel;

	private ArrayList<Task> taskList = new ArrayList<>();

	private JLabel lblTitle;
	private JScrollPane scrollPane;
	private JButton btnAddTask;
	private JTextArea textArea;

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

		scrollPane = new JScrollPane();
		scrollPane.setEnabled(false);
		scrollPane.setBounds(29, 63, 761, 346);
		contentPane.add(scrollPane);

		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);

		textArea.setEditable(false);
		textArea.setLineWrap(true);

		btnAddTask = new JButton("Add task");
		btnAddTask.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!taskPannel.isVisible()) {
					 taskPannel.dispose();
					taskPannel.setVisible(true);
					setVisible(false);
				}
			}
		});
		btnAddTask.setBounds(30, 424, 130, 32);
		contentPane.add(btnAddTask);
		
		
		taskPannel.addNewTaskListener(new NewTaskListener() {
			@Override
			public void modeHome(boolean modeHome) {
				if (modeHome) {
					windowHome();
				}
			}

		});
	}
    private void windowHome() {
        taskList.add(taskPannel.getTask());
       
        for (int k = 0; k < taskList.size(); k++) {
        System.out.println("Niao    " + taskList.get(k).getName());
        }
        
        taskPannel.dispose();
        textArea.setText(text());
        setVisible(true);
        
    }

    private String text() {
        String text = "";
        System.out.println("Niao 2   " + taskList.get(0).getName());
        for (int i = 0; i < taskList.size(); i++) {
            text += "Date : " + taskList.get(i).getDate() + "\n" + "Time : " + taskList.get(i).getTime() + "\n"
                    + "Task name : "  + taskList.get(i).getName() + "\n" + "Description : "
                    + taskList.get(i).getDescription() + "\n" + "\n";
        }
        System.out.println("TExt  = = " + text);
        return text;
    }

}
