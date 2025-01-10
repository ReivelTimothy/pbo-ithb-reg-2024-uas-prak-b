package view;

import java.awt.*;
import javax.swing.*;

import controller.AddTransaction;
import controller.GetDeliveryTypeData;
import controller.LoginSingleton;
import models.classes.Transaction;

public class AddDeliveryTransaction {

    public AddDeliveryTransaction() {
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

        JPanel nama = Templete.getInstance().createInputText("Nama : ");
        JPanel alamat = Templete.getInstance().createInputText("Alamat: ");
        JPanel telp = Templete.getInstance().createInputText("Nomor Telp: ");
        JPanel berat = Templete.getInstance().createInputText("Berat barang (KG): ");
        JPanel comboBox = Templete.getInstance().createInputComboBox("Pilih Jenis Pengiriman", GetDeliveryTypeData.getType());

        formPanel.add(nama);
        formPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        formPanel.add(alamat);
        formPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        formPanel.add(telp);
        formPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        formPanel.add(berat);
        formPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        formPanel.add(comboBox);
        formPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        JButton submitButton = new JButton("Submit");
        submitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        formPanel.add(submitButton);

        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(formPanel, BorderLayout.CENTER);

        backButton.addActionListener(e -> {
            frame.dispose();
            new MainMenu();  
        });
        submitButton.addActionListener(e ->{
            System.out.println(Templete.getInstance().getSelectedOption(comboBox));
            if (Templete.getInstance().getText(nama).isEmpty() ||
            Templete.getInstance().getText(alamat).isEmpty() ||
            Templete.getInstance().getText(telp).isEmpty() ||
            Templete.getInstance().getText(berat).isEmpty() ||
            Templete.getInstance().getSelectedOption(comboBox).isEmpty() 
            ) {
                JOptionPane.showMessageDialog(null, "Tolong masukan semua field yang sudah disediakan");
            } else if (Integer.parseInt(Templete.getInstance().getText(berat)) <= 0){
                JOptionPane.showMessageDialog(null, "Tolong Masukan input berat diatas 0");
            } else {
                Transaction transaction = new Transaction(
                    LoginSingleton.getInstance().getId(), 
                    Integer.parseInt(Templete.getInstance().getText(berat)), 
                    GetDeliveryTypeData.getPrice(Templete.getInstance().getSelectedOption(comboBox)) * Integer.parseInt(Templete.getInstance().getText(berat)), 
                    Templete.getInstance().getSelectedOption(comboBox), 
                    Templete.getInstance().getText(alamat), 
                    Templete.getInstance().getText(telp)
                );
                transaction.toString();
                if (AddTransaction.RecordTransaction(transaction)) {
                    JOptionPane.showMessageDialog(null, "Transaksi telah berhasil dicatat");
                    frame.dispose();
                    new MainMenu();
                } else {
                    JOptionPane.showMessageDialog(null, "Maaf ada kesalahan komputer");
                }
            }
                
            
        });
        frame.pack();
        frame.setSize(400, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
