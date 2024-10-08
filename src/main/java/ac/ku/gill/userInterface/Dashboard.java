package ac.ku.gill.userInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard extends JFrame {
    public Dashboard() {
        setTitle("Fedha Youth Group System - Dashboard");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JTabbedPane tabbedPane = new JTabbedPane();

        // Add tabs directly without a dashboard panel
        tabbedPane.addTab("Manage Members", new MemberManagement());
        tabbedPane.addTab("View Loans", createLoanPanel());
        tabbedPane.addTab("Manage Shares", createSharesPanel());
        tabbedPane.addTab("Fixed Deposits", createFixedDepositsPanel());
        tabbedPane.addTab("Generate Reports", createReportsPanel());

        // Logout button functionality
        JButton logoutButton = new JButton("Logout");
        logoutButton.addActionListener(e -> {
            int confirm = JOptionPane.showConfirmDialog(Dashboard.this, "Are you sure you want to logout?", "Logout", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                dispose(); // Close the dashboard
                new FedhaLogin(); // Open the login screen
            }
        });

        // Add the tabbed pane and logout button to the frame
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(tabbedPane, BorderLayout.CENTER);
        mainPanel.add(logoutButton, BorderLayout.SOUTH);

        add(mainPanel);
        setVisible(true); // Display the dashboard
    }

    private JPanel createLoanPanel() {
        JPanel loanPanel = new JPanel();
        loanPanel.add(new JLabel("Loan Management - Feature Coming Soon!"));
        return loanPanel;
    }

    private JPanel createSharesPanel() {
        JPanel sharesPanel = new JPanel();
        sharesPanel.add(new JLabel("Shares Management - Feature Coming Soon!"));
        return sharesPanel;
    }

    private JPanel createFixedDepositsPanel() {
        JPanel fixedDepositsPanel = new JPanel();
        fixedDepositsPanel.add(new JLabel("Fixed Deposits Management - Feature Coming Soon!"));
        return fixedDepositsPanel;
    }

    private JPanel createReportsPanel() {
        JPanel reportsPanel = new JPanel();
        reportsPanel.add(new JLabel("Reports Generation - Feature Coming Soon!"));
        return reportsPanel;
    }

    public static void main(String[] args) {
        new Dashboard();
    }
}
