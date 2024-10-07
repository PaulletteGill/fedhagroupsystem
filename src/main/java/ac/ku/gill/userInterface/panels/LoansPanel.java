package ac.ku.gill.userInterface.panels;


import javax.swing.*;
import java.awt.*;

public class LoansPanel extends JPanel {

    private JTextField txtLoanAmount;
    private JComboBox<String> cbLoanType;
    private JTextField txtRepaymentPeriod;

    public LoansPanel() {
        setLayout(new GridLayout(4, 2, 10, 10));

        add(new JLabel("Loan Amount:"));
        txtLoanAmount = new JTextField();
        add(txtLoanAmount);

        add(new JLabel("Loan Type:"));
        cbLoanType = new JComboBox<>(new String[]{"Business Loan", "Personal Loan", "Emergency Loan"});
        add(cbLoanType);

        add(new JLabel("Repayment Period (Months):"));
        txtRepaymentPeriod = new JTextField();
        add(txtRepaymentPeriod);

        JButton btnApplyLoan = new JButton("Apply Loan");
        add(btnApplyLoan);

        // Action listener for applying for a loan
        btnApplyLoan.addActionListener(e -> applyForLoan());
    }

    private void applyForLoan() {
        // Logic to process the loan application
        String loanType = (String) cbLoanType.getSelectedItem();
        int amount = Integer.parseInt(txtLoanAmount.getText());
        int period = Integer.parseInt(txtRepaymentPeriod.getText());

        // Compute interest, guarantor, etc.
        // Display loan details to the user
        JOptionPane.showMessageDialog(this, "Loan applied successfully.");
    }
}
