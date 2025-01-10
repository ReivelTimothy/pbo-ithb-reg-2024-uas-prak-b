package view;

import controller.TransactionHistoryController;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class TransactionHistoryView {
    private JFrame frame;
    private JTable historyTable;
    private JButton backButton;
    private TransactionHistoryController historyController;

    public static void main(String[] args) {
        new TransactionHistoryView();
    }

    public TransactionHistoryView() {
        historyController = new TransactionHistoryController();
        showHistoryMenu();
    }

    public void showHistoryMenu() {
        frame = new JFrame("Transaction History");
        frame.setSize(800, 500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel gradientPanel = new JPanel(new BorderLayout());
        gradientPanel.setBackground(new Color(0, 102, 204));

        JLabel titleLabel = new JLabel("Transaction History");
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 22));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        gradientPanel.add(titleLabel, BorderLayout.NORTH);

        int customerId = 1; 
        DefaultTableModel model = historyController.getHistory(customerId);

        historyTable = new JTable(model) {
            public boolean isCellEditable(int row, int column) {
                return column == model.getColumnCount() - 1;
            }
        };

        historyTable.setBackground(Color.WHITE);
        historyTable.setForeground(Color.BLACK);
        historyTable.setGridColor(new Color(220, 220, 220));
        historyTable.setRowHeight(25);
        historyTable.getTableHeader().setBackground(new Color(0, 102, 204));
        historyTable.getTableHeader().setForeground(Color.WHITE);
        historyTable.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 12));

        JScrollPane scrollPane = new JScrollPane(historyTable);
        gradientPanel.add(scrollPane, BorderLayout.CENTER);

        backButton = new JButton("Back");
        backButton.setBackground(new Color(0, 102, 204));
        backButton.setForeground(Color.WHITE);
        backButton.addActionListener(e -> {
            frame.dispose();
            new MainMenu(); 
        });

        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        bottomPanel.add(backButton);
        gradientPanel.add(bottomPanel, BorderLayout.SOUTH);

        frame.add(gradientPanel);
        frame.setVisible(true);
    }

    public void closeView() {
        frame.dispose();
        historyController.closeConnection();
    }
}
