package ac.ku.gill.userInterface.panels;


import javax.swing.*;
import java.awt.*;

public class ReportsPanel extends JPanel {

    public ReportsPanel() {
        setLayout(new GridLayout(5, 1, 10, 10));

        JButton btnMemberFeesReport = new JButton("Registration Fees Report");
        JButton btnSharesReport = new JButton("Shares Contributions Report");
        JButton btnLoansReport = new JButton("Loans Report");
        JButton btnDividendsReport = new JButton("Dividends Report");

        add(btnMemberFeesReport);
        add(btnSharesReport);
        add(btnLoansReport);
        add(btnDividendsReport);

        // Action listeners for generating reports
        btnMemberFeesReport.addActionListener(e -> generateMemberFeesReport());
        btnSharesReport.addActionListener(e -> generateSharesReport());
        btnLoansReport.addActionListener(e -> generateLoansReport());
        btnDividendsReport.addActionListener(e -> generateDividendsReport());
    }

    private void generateMemberFeesReport() {
        // TODO: Add logic to generate member fees report
        JOptionPane.showMessageDialog(this, "Registration Fees Report generated.");
    }

    private void generateSharesReport() {
        // TODO: add ogic to generate shares report
        JOptionPane.showMessageDialog(this, "Shares Contributions Report generated.");
    }

    private void generateLoansReport() {
        // TODO: Add logic to generate loans report
        JOptionPane.showMessageDialog(this, "Loans Report generated.");
    }

    private void generateDividendsReport() {
        // Logic to generate dividends report
        JOptionPane.showMessageDialog(this, "Dividends Report generated.");
    }
}
