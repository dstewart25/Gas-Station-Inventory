import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManagerView extends JPanel {
    private JFrame frame;
    private static JTabbedPane tabbedPane;
    private static ManagerOrderView orderView = new ManagerOrderView();
    private static ManagerConfirmOrderView confirmOrderView = new ManagerConfirmOrderView();

    public ManagerView(JFrame frame) {
        this.frame = frame;
        frame.setSize(600,400);
        setLayout(new BorderLayout());
        initialize();
        setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
    }

    private void initialize() {
        frame.setTitle("Manager");

        // Sub-panel to hold label and log out button
        JPanel topPanel = new JPanel(new BorderLayout());

        JLabel titleLabel = new JLabel("INVENTORY SYSTEM");
        titleLabel.setFont(new Font(titleLabel.getFont().getName(), Font.PLAIN, 24));
        topPanel.add(titleLabel, BorderLayout.WEST);
        JButton logOutButton = new JButton("Log Out");
        topPanel.add(logOutButton, BorderLayout.EAST);
        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Removing manager view and showing login screen
                frame.getContentPane().removeAll();
                frame.getContentPane().add(new LoginScreen(frame));
                frame.pack();
                frame.getContentPane().setVisible(true);
            }
        });

        // Setting up tabbed pane
        ManagerInventoryView inventoryView = new ManagerInventoryView();
        ManagerAlertsView alertsView = new ManagerAlertsView();
        tabbedPane = new JTabbedPane();
        tabbedPane.add("Order", orderView);
        tabbedPane.add("View Inventory", inventoryView);
        tabbedPane.add("View Alerts", alertsView);

        // add sub-panels to the main panel
        add(topPanel, BorderLayout.NORTH);
        add(tabbedPane, BorderLayout.CENTER);
    }

    /*
    Changes view of order pane to a confirm order view
     */
    public static void changeToConfirmOrder() {
        tabbedPane.setComponentAt(0, confirmOrderView);
        confirmOrderView.repaint();
    }

    /*
    Changes view of order pane to an order view
     */
    public static void changeToOrder() {
        tabbedPane.setComponentAt(0, orderView);
        orderView.repaint();
    }
}
