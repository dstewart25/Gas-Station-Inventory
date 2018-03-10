import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManagerAlertsView extends JPanel {
    public ManagerAlertsView() {
        setLayout(new BorderLayout());
        initialize();
    }

    private void initialize() {
        JPanel buttonPanel = new JPanel(new BorderLayout());

        // Setting up table to show alerts
        /*
        The 0 below would be the size of the primary key in the inventory database
         */
        String[] column = {"Alerts"};
        String[][] data = new String[0][column.length]; // Holds information for columns
        DefaultTableModel alertsTableModel = new DefaultTableModel(data, column);
        JTable alertsTable = new JTable(alertsTableModel);
        JScrollPane alertScrollPane = new JScrollPane(alertsTable,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        alertScrollPane.setPreferredSize(new Dimension(600, 350));

        JButton viewAlertButton = new JButton("View Alert");
        buttonPanel.add(viewAlertButton, BorderLayout.EAST);
        viewAlertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });

        add(alertScrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }
}
