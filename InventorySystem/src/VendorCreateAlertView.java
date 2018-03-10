import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VendorCreateAlertView extends JPanel {
    public VendorCreateAlertView() {
        setLayout(new BorderLayout());
        initialize();
    }

    private void initialize() {
        // Sub-panels to hold different components for the view
        JPanel alertSubjectPanel = new JPanel(new BorderLayout());
        //alertSubjectPanel.setLayout(new BoxLayout(alertSubjectPanel, BoxLayout.Y_AXIS));
        JPanel alertBodyPanel = new JPanel(new BorderLayout());
        //alertBodyPanel.setLayout(new BoxLayout(alertBodyPanel, BoxLayout.Y_AXIS));
        JPanel buttonPanel = new JPanel(new BorderLayout());

        // Creating subject components
        JLabel alertSubjectLabel = new JLabel("Subject:");
        alertSubjectPanel.add(alertSubjectLabel, BorderLayout.NORTH);
        JTextField alertSubjectField = new JTextField();
        alertSubjectField.setColumns(20);
        alertSubjectPanel.add(alertSubjectField, BorderLayout.CENTER);

        // Creating body components
        JLabel alertBodyLabel = new JLabel("Body:");
        alertBodyPanel.add(alertBodyLabel, BorderLayout.NORTH);
        JEditorPane alertBodyPane = new JEditorPane();
        alertBodyPanel.add(alertBodyPane, BorderLayout.CENTER);

        // Buttons for creating an alert
        JButton resetAlert = new JButton("Reset");
        resetAlert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Erasing text from subject and body fields
                alertSubjectField.setText("");
                alertBodyPane.setText("");
            }
        });
        buttonPanel.add(resetAlert, BorderLayout.WEST);
        JButton sendAlert = new JButton("Send");
        sendAlert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
        buttonPanel.add(sendAlert, BorderLayout.EAST);

        // Adding sub-panels to the main panel
        add(alertSubjectPanel, BorderLayout.NORTH);
        add(alertBodyPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }
}
