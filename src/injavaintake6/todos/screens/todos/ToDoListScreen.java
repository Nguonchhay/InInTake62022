package injavaintake6.todos.screens.todos;

import injavaintake6.todos.screens.BaseScreen;
import injavaintake6.todos.screens.DashboardScreen;
import injavaintake6.todos.screens.RegisterScreen;
import injavaintake6.todos.services.MySqlServiceSingleton;

import javax.swing.*;
import javax.swing.event.CellEditorListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.EventObject;

public class ToDoListScreen extends BaseScreen {

    private JTable tableToDo;
    private DefaultTableModel tableModelToDo;

    public ToDoListScreen() {
        super("ToDo List");
        setSize(800, 600);

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
        tableToDo.getColumn("").setCellRenderer(new ToDoTableRenderAndEditor(this, tableToDo));
        tableToDo.getColumn("").setCellEditor(new ToDoTableRenderAndEditor(this, tableToDo));

        JScrollPane scrollTable = new JScrollPane(tableToDo);
        scrollTable.setBounds(50, 100, 600, 400);
        add(scrollTable);
    }

    private void loadDataToTable() {
        String[] columnNames = {"ID", "Title", "Priority", "Status", ""};
        tableModelToDo = new DefaultTableModel(columnNames, 0);
        try {
            Connection connection = MySqlServiceSingleton.getInstance();
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM tasks ORDER BY priority";
            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {
                tableModelToDo.addRow(new Object[] {
                        result.getInt(1),
                        result.getString(2),
                        result.getInt(3),
                        result.getInt(4)
                });
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    class ToDoTableRenderAndEditor  implements TableCellRenderer, TableCellEditor {
        private JPanel pAction;
        private JButton btnEdit, btnDelete;
        private int selectedRow;

        public ToDoTableRenderAndEditor(JFrame screen, JTable table) {
            pAction = new JPanel(new FlowLayout());
            btnEdit = new JButton("Edit");
            btnDelete = new JButton("Delete");
            pAction.add(btnEdit);
            pAction.add(btnDelete);
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
            return false;
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
