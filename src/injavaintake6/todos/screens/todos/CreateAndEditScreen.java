package injavaintake6.todos.screens.todos;

import injavaintake6.todos.screens.BaseScreen;
import injavaintake6.todos.screens.DashboardScreen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

public class CreateAndEditScreen extends BaseScreen {
    private boolean isCreate;
    private JTextField txtID, txtTitle;
    private JComboBox cboPriority, cboStatus;

    public CreateAndEditScreen(boolean isCreate) {
        super(isCreate ? "Create New Task" : "Edit a Task");
        setIsCreate(isCreate);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setUndecorated(true);

        initUI();
    }

    public void setIsCreate(boolean create) {
        isCreate = create;
    }

    private void initUI() {
        JLabel lblCross = new JLabel("X");
        lblCross.setBounds(570, 0, 30, 30);
        lblCross.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                hidden();
                ToDoListScreen toDoListScreen = new ToDoListScreen();
                toDoListScreen.display();
            }
        });
        add(lblCross);

        JLabel lblTitle = new JLabel(isCreate ? "Create New Task" : "Edit a Task");
        lblTitle.setBounds(250, 50, 100, 30);
        add(lblTitle);

        JPanel pForm = new JPanel();
        GridLayout grid = new GridLayout(0, 2);
        grid.setVgap(5);
        pForm.setLayout(grid);
        pForm.setBounds(50, 100, 400, 120);

        pForm.add(new JLabel("ID"));
        txtID = new JTextField(20);
        pForm.add(txtID);

        pForm.add(new JLabel("Title"));
        txtTitle = new JTextField(100);
        pForm.add(txtTitle);

        pForm.add(new JLabel("Priority"));
        String[] cboDataPriority = {"High", "Medium", "Low"};
        cboPriority = new JComboBox(cboDataPriority);
        pForm.add(cboPriority);

        pForm.add(new JLabel("Status"));
        String[] cboDataStatus = {"To Do", "In Progress", "Closed"};
        cboStatus = new JComboBox(cboDataStatus);
        pForm.add(cboStatus);

        add(pForm);
    }
}
