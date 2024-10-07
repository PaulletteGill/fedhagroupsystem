package ac.ku.gill.userInterface.panels;

import ac.ku.gill.models.Member;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MembersPanel extends JPanel {

    private JTextField txtMemberName;
    private JTextField txtMemberAge;
    private JLabel lblTotalFees;
    private ArrayList<Member> members;

    public MembersPanel() {
        setLayout(new BorderLayout());

        members = new ArrayList<>();

        JPanel formPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        formPanel.add(new JLabel("Name:"));
        txtMemberName = new JTextField();
        formPanel.add(txtMemberName);

        formPanel.add(new JLabel("Age:"));
        txtMemberAge = new JTextField();
        formPanel.add(txtMemberAge);

        JButton btnAddMember = new JButton("Add Member");
        formPanel.add(btnAddMember);

        lblTotalFees = new JLabel("Total Registration Fees: Kshs 0");
        formPanel.add(lblTotalFees);

        add(formPanel, BorderLayout.CENTER);

        // Add Member button action listener
        btnAddMember.addActionListener(e -> addMember());
    }

    private void addMember() {
        String name = txtMemberName.getText();
        int age = Integer.parseInt(txtMemberAge.getText());
        if (age >= 18 && age <= 35) {
            members.add(new Member(name, age));
            JOptionPane.showMessageDialog(this, "Member added successfully.");
            updateTotalFees();
        } else {
            JOptionPane.showMessageDialog(this, "Member must be aged between 18 and 35.");
        }
    }

    private void updateTotalFees() {
        int totalFees = members.size() * 1000;
        lblTotalFees.setText("Total Registration Fees: Kshs " + totalFees);
    }
}
