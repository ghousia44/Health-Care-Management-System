package healthcare.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SmartHealthCareDashboard extends JFrame implements ActionListener {

    JButton btnPatients, btnDoctors, btnAppointments, btnPrescriptions;
    JButton btnNurse, btnPharmacy, btnLab, btnBilling;
    JButton btnReports, btnUsers, btnSettings, btnLogout;
    JLabel lblWelcome, lblRole;

    public SmartHealthCareDashboard() {

        // Welcome Label
        lblWelcome = new JLabel("Welcome, " + UserSession.getUserName() + "!");
        lblWelcome.setBounds(30, 20, 500, 40);
        lblWelcome.setFont(new Font("Tahoma", Font.BOLD, 28));
        lblWelcome.setForeground(new Color(0, 102, 204));
        add(lblWelcome);

        // Role Label
        lblRole = new JLabel("Role: " + UserSession.getUserRole().toUpperCase());
        lblRole.setBounds(30, 60, 300, 25);
        lblRole.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblRole.setForeground(new Color(52, 73, 94));
        add(lblRole);

        // Title
        JLabel titleLabel = new JLabel("SMART HEALTH CARE DASHBOARD");
        titleLabel.setBounds(250, 100, 600, 50);
        titleLabel.setFont(new Font("Tahoma", Font.BOLD, 32));
        titleLabel.setForeground(new Color(41, 128, 185));
        add(titleLabel);

        // ROW 1 - Patient & Doctor Management
        btnPatients = createButton("Manage Patients", 50, 180, new Color(46, 204, 113));
        btnDoctors = createButton("Manage Doctors", 320, 180, new Color(52, 152, 219));
        btnAppointments = createButton("Appointments", 590, 180, new Color(155, 89, 182));
        btnPrescriptions = createButton("Prescriptions", 860, 180, new Color(230, 126, 34));

        // ROW 2 - Staff Modules
        btnNurse = createButton("Nurse Module", 50, 280, new Color(26, 188, 156));
        btnPharmacy = createButton("Pharmacy", 320, 280, new Color(241, 196, 15));
        btnLab = createButton("Laboratory", 590, 280, new Color(231, 76, 60));
        btnBilling = createButton("Billing & Payment", 860, 280, new Color(149, 165, 166));

        // ROW 3 - Admin & Settings
        btnReports = createButton("Reports", 50, 380, new Color(22, 160, 133));
        btnUsers = createButton("User Management", 320, 380, new Color(192, 57, 43));
        btnSettings = createButton("Settings", 590, 380, new Color(142, 68, 173));
        btnLogout = createButton("Logout", 860, 380, new Color(52, 73, 94));

        // Frame settings
        getContentPane().setBackground(new Color(236, 240, 241));
        setSize(1200, 600);
        setLocation(100, 100);
        setLayout(null);
        setTitle("Smart Health Care Management System - Dashboard");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    // Helper method to create buttons
    private JButton createButton(String text, int x, int y, Color bgColor) {
        JButton button = new JButton(text);
        button.setBounds(x, y, 250, 70);
        button.setFont(new Font("Tahoma", Font.BOLD, 16));
        button.setBackground(bgColor);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.addActionListener(this);
        add(button);
        return button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnPatients) {
            // Check authorization
            if (UserSession.hasAnyRole("admin", "doctor", "nurse")) {
                new ManagePatients();
            } else {
                JOptionPane.showMessageDialog(null, "You don't have permission to access this module!");
            }

        } else if (e.getSource() == btnDoctors) {
            // Only Admin can manage doctors
            if (UserSession.hasRole("admin")) {
                new ManageDoctors();
            } else {
                JOptionPane.showMessageDialog(null, "Only Administrators can access this module!");
            }

        } else if (e.getSource() == btnAppointments) {
            // Admin, Doctor, Patient can view appointments
            if (UserSession.hasAnyRole("admin", "doctor", "patient", "nurse")) {
                new ManageAppointments();
            } else {
                JOptionPane.showMessageDialog(null, "You don't have permission to access this module!");
            }

        } else if (e.getSource() == btnPrescriptions) {
            // Doctor and Pharmacist can access
            if (UserSession.hasAnyRole("admin", "doctor", "pharmacist")) {
                new ManagePrescriptions();
            } else {
                JOptionPane.showMessageDialog(null, "Only Doctors and Pharmacists can access this module!");
            }

        } else if (e.getSource() == btnNurse) {
            // Nurse and Admin
            if (UserSession.hasAnyRole("admin", "nurse")) {
                new NurseModule();
            } else {
                JOptionPane.showMessageDialog(null, "Only Nurses can access this module!");
            }

        } else if (e.getSource() == btnPharmacy) {
            // Pharmacist and Admin
            if (UserSession.hasAnyRole("admin", "pharmacist")) {
                new PharmacyModule();
            } else {
                JOptionPane.showMessageDialog(null, "Only Pharmacists can access this module!");
            }

        } else if (e.getSource() == btnLab) {
            // Lab staff and Admin
            if (UserSession.hasAnyRole("admin", "lab")) {
                new LabModule();
            } else {
                JOptionPane.showMessageDialog(null, "Only Lab staff can access this module!");
            }

        } else if (e.getSource() == btnBilling) {
            // Accountant and Admin
            if (UserSession.hasAnyRole("admin", "accountant")) {
                new BillingModule();
            } else {
                JOptionPane.showMessageDialog(null, "Only Accountants can access this module!");
            }

        } else if (e.getSource() == btnReports) {
            // Admin only
            if (UserSession.hasRole("admin")) {
                new ReportsModule();
            } else {
                JOptionPane.showMessageDialog(null, "Only Administrators can access reports!");
            }

        } else if (e.getSource() == btnUsers) {
            // Admin only
            if (UserSession.hasRole("admin")) {
                new ManageUsers();
            } else {
                JOptionPane.showMessageDialog(null, "Only Administrators can manage users!");
            }

        } else if (e.getSource() == btnSettings) {
            new SettingsModule();

        } else if (e.getSource() == btnLogout) {
            int confirm = JOptionPane.showConfirmDialog(null,
                    "Are you sure you want to logout?",
                    "Confirm Logout",
                    JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {
                UserSession.clearSession();
                setVisible(false);
                new Login();
            }
        }
    }

    public static void main(String[] args) {
        // For testing - simulate login
        UserSession.setUserId("A001");
        UserSession.setUserName("Administrator");
        UserSession.setUserRole("admin");
        new SmartHealthCareDashboard();
    }
}
