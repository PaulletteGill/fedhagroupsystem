package ac.ku.gill.userInterface.panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class SharesPanel extends JPanel {

    private JTextField txtMemberName;
    private JTextField txtContributionAmount;
    private JLabel lblTotalShares;
    private JLabel lblFixedDeposit;
    private JLabel lblInterestEarned;
    private JButton btnAddContribution;

    // Store member shares
    private HashMap<String, Double> memberShares;
    private double fixedDeposit;

    public SharesPanel() {
        setLayout(new GridLayout(6, 2, 10, 10));

        // Initialize components
        memberShares = new HashMap<>();
        fixedDeposit = 0;

        add(new JLabel("Member Name:"));
        txtMemberName = new JTextField();
        add(txtMemberName);

        add(new JLabel("Contribution Amount (Kshs):"));
        txtContributionAmount = new JTextField();
        add(txtContributionAmount);

        btnAddContribution = new JButton("Add Contribution");
        add(btnAddContribution);

        lblTotalShares = new JLabel("Total Shares: Kshs 0");
        add(lblTotalShares);

        lblFixedDeposit = new JLabel("Fixed Deposit: Kshs 0");
        add(lblFixedDeposit);

        lblInterestEarned = new JLabel("Interest Earned on Deposit: Kshs 0");
        add(lblInterestEarned);

        // Event listener for adding a contribution
        btnAddContribution.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addMemberContribution();
            }
        });
    }

    private void addMemberContribution() {
        String memberName = txtMemberName.getText();
        double contributionAmount;

        try {
            contributionAmount = Double.parseDouble(txtContributionAmount.getText());

            if (contributionAmount < 500) {
                JOptionPane.showMessageDialog(this, "Minimum contribution is Kshs 500.", "Invalid Contribution", JOptionPane.WARNING_MESSAGE);
                return;
            }

            // Update member shares
            memberShares.put(memberName, memberShares.getOrDefault(memberName, 0.0) + contributionAmount);

            // Update the fixed deposit with the new shares (simulating all savings being deposited)
            fixedDeposit += contributionAmount;

            // Update the total shares label
            updateTotalShares();

            // Update the fixed deposit label
            lblFixedDeposit.setText("Fixed Deposit: Kshs " + fixedDeposit);

            // Calculate and update the interest earned on the fixed deposit
            double interest = calculateFixedDepositInterest();
            lblInterestEarned.setText("Interest Earned on Deposit: Kshs " + interest);

            // Clear the input fields
            txtMemberName.setText("");
            txtContributionAmount.setText("");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid amount.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateTotalShares() {
        double totalShares = memberShares.values().stream().mapToDouble(Double::doubleValue).sum();
        lblTotalShares.setText("Total Shares: Kshs " + totalShares);
    }

    private double calculateFixedDepositInterest() {
        // Interest rate is 0.6% per month
        return fixedDeposit * 0.006;
    }
}
