package ac.ku.gill.userInterface;

import ac.ku.gill.userInterface.panels.LoansPanel;
import ac.ku.gill.userInterface.panels.MembersPanel;
import ac.ku.gill.userInterface.panels.ReportsPanel;
import ac.ku.gill.userInterface.panels.SharesPanel;

import javax.swing.*;
import java.awt.*;

public class FedhaYouthGroupSystem extends JFrame {

    private CardLayout cardLayout;
    private JPanel mainPanel;

    public FedhaYouthGroupSystem() {
        setTitle("Fedha Youth Group System");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Initialize the CardLayout and mainPanel
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        // Create instances of each panel
        MembersPanel membersPanel = new MembersPanel();
        LoansPanel loansPanel = new LoansPanel();
        SharesPanel sharesPanel = new SharesPanel();
        ReportsPanel reportsPanel = new ReportsPanel();

        // Add the panels to the mainPanel with a unique name
        mainPanel.add(membersPanel, "Members");
        mainPanel.add(loansPanel, "Loans");
        mainPanel.add(sharesPanel, "Shares");
        mainPanel.add(reportsPanel, "Reports");

        // Create buttons for the main menu
        JPanel menuPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        JButton btnMembers = new JButton("Manage Members");
        JButton btnLoans = new JButton("Manage Loans");
        JButton btnShares = new JButton("Manage Shares & Deposits");
        JButton btnReports = new JButton("Generate Reports");
        JButton btnExit = new JButton("Exit");

        menuPanel.add(btnMembers);
        menuPanel.add(btnLoans);
        menuPanel.add(btnShares);
        menuPanel.add(btnReports);
        menuPanel.add(btnExit);

        // Add action listeners for the buttons to switch panels
        btnMembers.addActionListener(e -> showMembersPanel());
        btnLoans.addActionListener(e -> showLoansPanel());
        btnShares.addActionListener(e -> showSharesPanel());
        btnReports.addActionListener(e -> showReportsPanel());
        btnExit.addActionListener(e -> System.exit(0));

        // Set up the layout for the main frame
        setLayout(new BorderLayout());
        add(menuPanel, BorderLayout.NORTH);
        add(mainPanel, BorderLayout.CENTER);
    }

    // Methods to show the different panels
    private void showMembersPanel() {
        cardLayout.show(mainPanel, "Members");
    }

    private void showLoansPanel() {
        cardLayout.show(mainPanel, "Loans");
    }

    private void showSharesPanel() {
        cardLayout.show(mainPanel, "Shares");
    }

    private void showReportsPanel() {
        cardLayout.show(mainPanel, "Reports");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FedhaYouthGroupSystem app = new FedhaYouthGroupSystem();
            app.setVisible(true);
        });
    }
}
