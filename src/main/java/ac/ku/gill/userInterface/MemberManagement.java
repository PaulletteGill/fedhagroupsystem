package ac.ku.gill.userInterface;

import ac.ku.gill.models.Member;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MemberManagement extends JPanel {
    private final JTable membersTable;
    private final DefaultTableModel tableModel;

    public MemberManagement() {
        setLayout(new BorderLayout());

        // Table setup
        String[] columnNames = {"Member Name", "Age", "Shares", "Registration Fee"};
        tableModel = new DefaultTableModel(columnNames, 0);
        membersTable = new JTable(tableModel);
        JScrollPane tableScrollPane = new JScrollPane(membersTable);

        // Button setup
        JPanel buttonPanel = new JPanel();
        JButton addButton = new JButton("Add Member");
        JButton editButton = new JButton("Edit Member");
        JButton deleteButton = new JButton("Delete Member");
        JButton backButton = new JButton("Back to Dashboard");
        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(backButton);

        // Add components to main panel
        add(buttonPanel, BorderLayout.SOUTH);
        add(tableScrollPane, BorderLayout.CENTER);

        // Button action listeners
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showAddMemberForm();
            }
        });

        editButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = membersTable.getSelectedRow();
                if (selectedRow >= 0) {
                    editMember(selectedRow);
                } else {
                    JOptionPane.showMessageDialog(MemberManagement.this, "Please select a member to edit.");
                }
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = membersTable.getSelectedRow();
                if (selectedRow >= 0) {
                    tableModel.removeRow(selectedRow);
                } else {
                    JOptionPane.showMessageDialog(MemberManagement.this, "Please select a member to delete.");
                }
            }
        });

        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JTabbedPane tabbedPane = (JTabbedPane) SwingUtilities.getAncestorOfClass(JTabbedPane.class, MemberManagement.this);
                if (tabbedPane != null) {
                    tabbedPane.setSelectedIndex(0);
                }
            }
        });
    }

    private void showAddMemberForm() {
        JDialog addMemberDialog = new JDialog((JFrame) SwingUtilities.getWindowAncestor(this), "Add New Member", true);
        addMemberDialog.setSize(300, 200);
        addMemberDialog.setLocationRelativeTo(this);

        JPanel formPanel = new JPanel(new GridLayout(5, 2));
        JTextField nameField = new JTextField();
        JTextField ageField = new JTextField();
        JTextField sharesField = new JTextField();
        JTextField registrationFeeField = new JTextField();

        formPanel.add(new JLabel("Name:"));
        formPanel.add(nameField);
        formPanel.add(new JLabel("Age:"));
        formPanel.add(ageField);
        formPanel.add(new JLabel("Shares:"));
        formPanel.add(sharesField);
        formPanel.add(new JLabel("Registration Fee:"));
        formPanel.add(registrationFeeField);

        JButton saveButton = new JButton("Save");
        JButton cancelButton = new JButton("Cancel");
        formPanel.add(saveButton);
        formPanel.add(cancelButton);

        addMemberDialog.add(formPanel);

        saveButton.addActionListener(e -> {
            try {
                String name = nameField.getText();
                int age = Integer.parseInt(ageField.getText());
                double shares = Double.parseDouble(sharesField.getText());
                double registrationFee = Double.parseDouble(registrationFeeField.getText());

                // Check if age is within the valid range
                if (age >= 18 && age <= 35) {
                    Member newMember = new Member(name, age, shares, registrationFee);
                    tableModel.addRow(new Object[]{newMember.getName(), newMember.getAge(), newMember.getShares(), newMember.getRegistrationFee()});
                    addMemberDialog.dispose(); // Close dialog only on success
                } else {
                    JOptionPane.showMessageDialog(this, "Please enter a valid age (between 18 and 35).");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter a valid number.");
            }
        });

        cancelButton.addActionListener(e -> addMemberDialog.dispose());

        addMemberDialog.setVisible(true);
    }

    private void editMember(int rowIndex) {
        String currentName = tableModel.getValueAt(rowIndex, 0).toString();
        String currentAge = tableModel.getValueAt(rowIndex, 1).toString();
        String currentShares = tableModel.getValueAt(rowIndex, 2).toString();
        String currentRegistrationFee = tableModel.getValueAt(rowIndex, 3).toString();

        JDialog editMemberDialog = new JDialog((JFrame) SwingUtilities.getWindowAncestor(this), "Edit Member", true);
        editMemberDialog.setSize(300, 200);
        editMemberDialog.setLocationRelativeTo(this);

        JPanel formPanel = new JPanel(new GridLayout(5, 2));
        JTextField nameField = new JTextField(currentName);
        JTextField ageField = new JTextField(currentAge);
        JTextField sharesField = new JTextField(currentShares);
        JTextField registrationFeeField = new JTextField(currentRegistrationFee);

        formPanel.add(new JLabel("Name:"));
        formPanel.add(nameField);
        formPanel.add(new JLabel("Age:"));
        formPanel.add(ageField);
        formPanel.add(new JLabel("Shares:"));
        formPanel.add(sharesField);
        formPanel.add(new JLabel("Registration Fee:"));
        formPanel.add(registrationFeeField);

        JButton saveButton = new JButton("Save");
        JButton cancelButton = new JButton("Cancel");
        formPanel.add(saveButton);
        formPanel.add(cancelButton);

        editMemberDialog.add(formPanel);

        saveButton.addActionListener(e -> {
            try {
                String name = nameField.getText();
                int age = Integer.parseInt(ageField.getText());
                double shares = Double.parseDouble(sharesField.getText());
                double registrationFee = Double.parseDouble(registrationFeeField.getText());

                // Check if age is within the valid range
                if (age >= 18 && age <= 35) {
                    tableModel.setValueAt(name, rowIndex, 0);
                    tableModel.setValueAt(age, rowIndex, 1);
                    tableModel.setValueAt(shares, rowIndex, 2);
                    tableModel.setValueAt(registrationFee, rowIndex, 3);
                    editMemberDialog.dispose(); // Close dialog only on success
                } else {
                    JOptionPane.showMessageDialog(this, "Please enter a valid age (between 18 and 35).");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter a valid number.");
            }
        });

        cancelButton.addActionListener(e -> editMemberDialog.dispose());

        editMemberDialog.setVisible(true);
    }

    public void setDefaultCloseOperation(int disposeOnClose) {
    }
}