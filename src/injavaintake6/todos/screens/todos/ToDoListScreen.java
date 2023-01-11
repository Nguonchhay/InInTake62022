package injavaintake6.todos.screens.todos;

import injavaintake6.todos.models.Task;
import injavaintake6.todos.screens.BaseScreen;
import injavaintake6.todos.screens.DashboardScreen;

import javax.swing.*;
import javax.swing.event.CellEditorListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.EventObject;
import java.util.List;

public class ToDoListScreen extends BaseScreen {

    private JTable tableToDo;
    private DefaultTableModel tableModelToDo;

    public ToDoListScreen() {
        super("ToDo List");
        setSize(800, 600);
        setLocationRelativeTo(null);
//        mySqlService = new MySqlService();
        initUI();
    }

    private void initUI() {
        JLabel lblBack = new JLabel("Back");
        lblBack.setBounds(10, 10, 100, 30);
        lblBack.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                hidden();
                DashboardScreen dashboardScreen = new DashboardScreen();
                dashboardScreen.display();
            }
        });
        add(lblBack);

        JLabel lblTitle = new JLabel("ToDo List");
        lblTitle.setBounds(350, 50, 100, 30);
        add(lblTitle);

        loadDataToTable();
        tableToDo = new JTable(tableModelToDo);
        tableToDo.setRowHeight(30);
        tableToDo.setDefaultEditor(Object.class, null);
        tableToDo.getColumn("").setCellRenderer(new ToDoTableRenderAndEditor(this, tableToDo));
        tableToDo.getColumn("").setCellEditor(new ToDoTableRenderAndEditor(this, tableToDo));

        JScrollPane scrollTable = new JScrollPane(tableToDo);
        scrollTable.setBounds(50, 100, 600, 400);
        add(scrollTable);
    }

    private void loadDataToTable() {
        String[] columnNames = {"ID", "Title", "Priority", "Status", ""};
        tableModelToDo = new DefaultTableModel(columnNames, 0);
//        Task task = new Task();
//        List<Task> result = task.list();
        Task.list().forEach(queryTask -> {
            tableModelToDo.addRow(new Object[] {
                queryTask.getId(),
                queryTask.getTitle(),
                queryTask.getPriority(),
                queryTask.getStatus()
            });
        });
    }

    class ToDoTableRenderAndEditor  implements TableCellRenderer, TableCellEditor {
        private DefaultTableModel tableModel;
        private JPanel pAction;
        private JButton btnEdit, btnDelete;
        private int selectedRow;

        public ToDoTableRenderAndEditor(JFrame screen, JTable table) {
            tableModel = (DefaultTableModel) table.getModel();
            pAction = new JPanel(new FlowLayout());
            btnEdit = new JButton("Edit");
            btnDelete = new JButton("Delete");
            pAction.add(btnEdit);
            pAction.add(btnDelete);

            btnEdit.addActionListener(e -> {
                ToDoListScreen listScreen = (ToDoListScreen) screen;
                listScreen.hidden();
                CreateAndEditScreen createAndEditScreen = new CreateAndEditScreen(false);
                createAndEditScreen.display();
            });

            btnDelete.addActionListener(e -> {
                int id = Integer.parseInt(tableModel.getValueAt(selectedRow, 0).toString());
                if (
                        JOptionPane.showConfirmDialog(screen, "Are you sure?", "Task Deletion", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION
                ) {
                    if (Task.remove(id)) {
                        tableModel.removeRow(selectedRow);
                    } else {
                        JOptionPane.showMessageDialog(screen, "Something went wrong!");
                    }
                }
            });
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            selectedRow = row;
            return pAction;
        }

        @Override
        public Object getCellEditorValue() {
            return true;
        }

        @Override
        public boolean isCellEditable(EventObject anEvent) {
            return true;
        }

        @Override
        public boolean shouldSelectCell(EventObject anEvent) {
            return true;
        }

        @Override
        public boolean stopCellEditing() {
            return true;
        }

        @Override
        public void cancelCellEditing() {

        }

        @Override
        public void addCellEditorListener(CellEditorListener l) {

        }

        @Override
        public void removeCellEditorListener(CellEditorListener l) {

        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            return pAction;
        }
    }
}
