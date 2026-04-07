//package healthcare.management.system;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.*;
//
//public class Dashboard extends JFrame implements ActionListener {
//
//    JButton patientBtn, doctorBtn, appointmentBtn, billingBtn, logoutBtn;
//
//    // Background Panel Class
//    class BackgroundPanel extends JPanel {
//        Image bg;
//
//        public BackgroundPanel() {
//            bg = new ImageIcon("C:\\Users\\tauhe\\IdeaProjects\\Healthcare Management System\\src\\icon\\bg.png").getImage(); // put your image here
//        }
//
//        @Override
//        protected void paintComponent(Graphics g) {
//            super.paintComponent(g);
//            g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
//        }
//    }
//
//    Dashboard() {
//
//        setTitle("Healthcare Management Dashboard");
//        setSize(800, 500);
//        setLocationRelativeTo(null);
//
//        BackgroundPanel panel = new BackgroundPanel();
//        panel.setLayout(null);
//        setContentPane(panel);
//
//        // 🌟 TITLE
//        JLabel title = new JLabel("Smart Healthcare Dashboard");
//        title.setBounds(180, 20, 500, 40);
//        title.setFont(new Font("Arial", Font.BOLD, 26));
//        title.setForeground(Color.MAGENTA);
//        panel.add(title);
//
//        // 🌟 BUTTON STYLE
//        Font btnFont = new Font("Arial", Font.BOLD, 16);
//
//        // 🧑 Patient Button
//        patientBtn = new JButton("Patient");
//        patientBtn.setBounds(100, 120, 200, 50);
//        patientBtn.setFont(btnFont);
//        patientBtn.setBackground(new Color(255, 255, 255));
//        patientBtn.setForeground(Color.BLUE);
//        panel.add(patientBtn);
//
//        // 🩺 Doctor Button
//        doctorBtn = new JButton("Doctor");
//        doctorBtn.setBounds(450, 120, 200, 50);
//        doctorBtn.setFont(btnFont);
//        doctorBtn.setBackground(new Color(255, 255, 255));
//        doctorBtn.setForeground(Color.BLUE);
//        panel.add(doctorBtn);
//
//        // 📅 Appointment Button
//        appointmentBtn = new JButton("Appointment");
//        appointmentBtn.setBounds(100, 220, 200, 50);
//        appointmentBtn.setFont(btnFont);
//        appointmentBtn.setBackground(new Color(52,152,219));
//        appointmentBtn.setForeground(Color.WHITE);
//        panel.add(appointmentBtn);
//
//        // 💰 Billing Button
//        billingBtn = new JButton("Billing");
//        billingBtn.setBounds(450, 220, 200, 50);
//        billingBtn.setFont(btnFont);
//        billingBtn.setBackground(new Color(52,152,219));
//        billingBtn.setForeground(Color.WHITE);
//        panel.add(billingBtn);
//
//        // 🚪 Logout Button
//        logoutBtn = new JButton("Logout");
//        logoutBtn.setBounds(300, 330, 150, 40);
//        logoutBtn.setFont(btnFont);
//        logoutBtn.setBackground(Color.RED);
//        logoutBtn.setForeground(Color.WHITE);
//        panel.add(logoutBtn);
//
//        // 🎯 ACTION LISTENERS
//        patientBtn.addActionListener(this);
//        doctorBtn.addActionListener(this);
//        appointmentBtn.addActionListener(this);
//        billingBtn.addActionListener(this);
//        logoutBtn.addActionListener(this);
//
//        setVisible(true);
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//
//        if (e.getSource() == patientBtn) {
//            JOptionPane.showMessageDialog(this, "Patient Module");
//            // new PatientUI();
//        }
//
//        if (e.getSource() == doctorBtn) {
//            JOptionPane.showMessageDialog(this, "Doctor Module");
//        }
//
//        if (e.getSource() == appointmentBtn) {
//            JOptionPane.showMessageDialog(this, "Appointment Module");
//        }
//
//        if (e.getSource() == billingBtn) {
//            JOptionPane.showMessageDialog(this, "Billing Module");
//        }
//
//        if (e.getSource() == logoutBtn) {
//            JOptionPane.showMessageDialog(this, "Logged Out");
//            new Login();
//            this.setVisible(false);
//        }
//    }
//
//    public static void main(String[] args) {
//        new Dashboard();
//    }
//}
//package healthcare.management.system;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.*;
//
//public class Dashboard extends JFrame implements ActionListener {
//
//    String userId, name, role;
//
//    JButton patientBtn, doctorBtn, appointmentBtn, billingBtn, logoutBtn;
//
//    Dashboard(String userId, String name, String role) {
//
//        this.userId = userId;
//        this.name = name;
//        this.role = role;
//
//        setTitle("Healthcare Dashboard");
//        setSize(900, 500);
//        setLocationRelativeTo(null);
//        setLayout(null);
//
//        // Welcome label
//        JLabel welcome = new JLabel("Welcome: " + name + " (" + role + ")");
//        welcome.setBounds(250, 20, 400, 30);
//        welcome.setFont(new Font("Arial", Font.BOLD, 18));
//        add(welcome);
//
//        // Buttons
//        patientBtn = new JButton("Patient");
//        patientBtn.setBounds(100, 100, 200, 50);
//        add(patientBtn);
//
//        doctorBtn = new JButton("Doctor");
//        doctorBtn.setBounds(350, 100, 200, 50);
//        add(doctorBtn);
//
//        appointmentBtn = new JButton("Appointment");
//        appointmentBtn.setBounds(100, 200, 200, 50);
//        add(appointmentBtn);
//
//        billingBtn = new JButton("Billing");
//        billingBtn.setBounds(350, 200, 200, 50);
//        add(billingBtn);
//
//        logoutBtn = new JButton("Logout");
//        logoutBtn.setBounds(250, 300, 150, 40);
//        logoutBtn.setBackground(Color.RED);
//        logoutBtn.setForeground(Color.WHITE);
//        add(logoutBtn);
//
//        // Actions
//        patientBtn.addActionListener(this);
//        doctorBtn.addActionListener(this);
//        appointmentBtn.addActionListener(this);
//        billingBtn.addActionListener(this);
//        logoutBtn.addActionListener(this);
//
//        // 🔥 ROLE-BASED ACCESS CONTROL
//        applyRoleAccess();
//
//        setVisible(true);
//    }
//
//    // 🔥 CONTROL ACCESS BASED ON ROLE
//    private void applyRoleAccess() {
//
//        if (role.equalsIgnoreCase("admin")) {
//            // admin sees everything
//        }
//
//        else if (role.equalsIgnoreCase("doctor")) {
//            billingBtn.setVisible(false);
//        }
//
//        else if (role.equalsIgnoreCase("patient")) {
//            doctorBtn.setVisible(false);
//            billingBtn.setVisible(false);
//        }
//
//        else if (role.equalsIgnoreCase("accountant")) {
//            patientBtn.setVisible(false);
//            doctorBtn.setVisible(false);
//            appointmentBtn.setVisible(false);
//        }
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//
//        if (e.getSource() == patientBtn) {
//            new PatientDashboard(userId, name); // open module
//        }
//
//        if (e.getSource() == doctorBtn) {
//            new DoctorDashboard(userId, name);
//        }
//
//        if (e.getSource() == appointmentBtn) {
//            JOptionPane.showMessageDialog(this, "Appointment Module");
//        }
//
//        if (e.getSource() == billingBtn) {
//            new AccountantDashboard(userId, name);
//        }
//
//        if (e.getSource() == logoutBtn) {
//            new Login();
//            this.setVisible(false);
//        }
//    }
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