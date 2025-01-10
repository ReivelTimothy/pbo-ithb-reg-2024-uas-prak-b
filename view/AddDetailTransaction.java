package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.text.SimpleDateFormat;
import java.sql.Date;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controller.AddDetailTrainsaction;
import models.classes.DeliverDetail;
import models.enumeration.DeliverStatus;

public class AddDetailTransaction {
    public static void main(String[] args) {
        new AddDetailTransaction();
    }

    public AddDetailTransaction() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("REGISTER DELIVERY TRANSACTION");
        frame.setLayout(new BorderLayout());

        JPanel topPanel = new JPanel(new BorderLayout());
        JButton backButton = new JButton("Back");
        backButton.setPreferredSize(new Dimension(80, 30));
        topPanel.add(backButton, BorderLayout.WEST);
        topPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        formPanel.setBackground(Color.WHITE);

        String[] statuss = new String[] { DeliverStatus.PENDING.name(), DeliverStatus.IN_PROGRESS.name(),
                DeliverStatus.ON_DELIVER.name(), DeliverStatus.ARRIVED.name() };

        JPanel transaction_id = Templete.getInstance().createInputText("Transaction Id ");
        JPanel status = Templete.getInstance().createInputComboBox("Status ", statuss);
        JPanel curentPosition = Templete.getInstance().createInputText("Current Position ");
        JPanel evidence = Templete.getInstance().createInputFileChooser("Evidence", frame);
        JPanel updatedBy = Templete.getInstance().createInputText("Updated By : ");

        JComboBox<?> comboBox = (JComboBox<?>) status.getComponent(1);
        comboBox.addActionListener(e -> {
            if (Templete.getInstance().getSelectedOption(status).equalsIgnoreCase("ARRIVED")) {
                evidence.setVisible(true);
            } else {
                evidence.setVisible(false);
            }
        });

        formPanel.add(transaction_id);
        formPanel.add(status);
        formPanel.add(curentPosition);
        formPanel.add(updatedBy);
        formPanel.add(evidence);
        evidence.setVisible(false);

        JButton submitButton = new JButton("Submit");
        submitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        formPanel.add(submitButton);

        

        submitButton.addActionListener(e -> {
            String transactionId = Templete.getInstance().getText(transaction_id);
            String statusOption = Templete.getInstance().getSelectedOption(status);
            String currentPos = Templete.getInstance().getText(curentPosition);
            String evidencePath = Templete.getInstance().getText(evidence);
            String updatedByText = Templete.getInstance().getText(updatedBy);

            if (transactionId.isEmpty() || currentPos.isEmpty() || updatedByText.isEmpty() || statusOption.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Tolong isi semua field yang ada");
                return;
            }

            DeliverDetail deliverDetail = null;

            if (statusOption.equalsIgnoreCase("ARRIVED")) {
                if (evidencePath.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Tolong isi field Evidence");
                    return;
                }
                deliverDetail = new DeliverDetail(
                        Integer.parseInt(transactionId),
                        DeliverStatus.valueOf(statusOption),
                        currentPos,
                        evidencePath,
                        updatedByText,
                        new Date(0) 
                );
            } else {
                deliverDetail = new DeliverDetail(
                        Integer.parseInt(transactionId),
                        DeliverStatus.valueOf(statusOption),
                        currentPos,
                        evidencePath,
                        updatedByText,
                        new Date(0) 
                );
            }
            frame.dispose();
            new MainMenu();
        });

        backButton.addActionListener(e ->{
            frame.dispose();
            new MainMenu();
        });

        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(formPanel, BorderLayout.CENTER);
        frame.pack();
        frame.setSize(400, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
