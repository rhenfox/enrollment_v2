/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package enrollmentsystem.gui.dialog.au;

import enrollmentsystem.data.AppQuery;
import enrollmentsystem.data.ComboBoxList;
import enrollmentsystem.records.SchoolYear;
import enrollmentsystem.records.Semester;
import enrollmentsystem.util.ComboBoxAutoFill;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.text.JTextComponent;

/**
 *
 * @author Java Programming with Aldrin
 */
public class JDialogSchoolYearAU extends javax.swing.JDialog {

    /**
     * Creates new form JDialogUserAU
     */
    
    private SchoolYear schoolYear;
    private enrollmentsystem.gui.JFrameEnrollment mainFrame;
    private AppQuery query = new AppQuery();
    private JTextComponent editor;

    public JDialogSchoolYearAU(enrollmentsystem.gui.JFrameEnrollment parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.mainFrame = parent;
        setTitle("Add school year");
        jButton1.setText("Save");
        jButton1.setMnemonic('S');
        comboBoxSemester();
        jComboBoxSemester.setEditable(true);
        editor = (JTextComponent) jComboBoxSemester.getEditor().getEditorComponent();
        editor.setDocument(new ComboBoxAutoFill(jComboBoxSemester));

    }

    public JDialogSchoolYearAU(enrollmentsystem.gui.JFrameEnrollment parent, boolean modal, SchoolYear schoolYear) {
        super(parent, modal);
        initComponents();
        this.mainFrame = parent;
        setTitle("Update school year");
        jButton1.setText("Update");
        jTextFieldSchoolYear.setText(schoolYear.schoolYear());
        jButton1.setMnemonic('U');
        this.schoolYear = schoolYear;
        comboBoxSemester();
        for (ComboBoxList a : this.query.getList()) {
            a.setSelectedId(query.getList(), String.valueOf(schoolYear.semester().id()), jComboBoxSemester);
        }
        jDateChooserStart.setDate(new Date(Integer.parseInt(schoolYear.start().toString().substring(0, 4)) - 1900, Integer.parseInt(schoolYear.start().toString().substring(5, 7)) - 1, Integer.parseInt(schoolYear.start().substring(8))));
        jDateChooserEnd.setDate(new Date(Integer.parseInt(schoolYear.end().toString().substring(0, 4)) - 1900, Integer.parseInt(schoolYear.end().toString().substring(5, 7)) - 1, Integer.parseInt(schoolYear.end().substring(8))));

    }

    public JDialogSchoolYearAU(enrollmentsystem.gui.JFrameEnrollment parent, SchoolYear course, boolean modal) {
        super(parent, modal);
        initComponents();
        this.mainFrame = parent;
        setTitle("Delete school year");
        jButton1.setText("Delete");
        jTextFieldSchoolYear.setText(course.schoolYear());
        jTextFieldSchoolYear.setFocusable(false);
        jButton1.setMnemonic('D');
        this.schoolYear = course;
        comboBoxSemester();
        for (ComboBoxList a : this.query.getList()) {
            a.setSelectedId(query.getList(), String.valueOf(course.semester().id()), jComboBoxSemester);
        }
        jDateChooserStart.setDate(new Date(Integer.parseInt(schoolYear.start().toString().substring(0, 4)) - 1900, Integer.parseInt(schoolYear.start().toString().substring(5, 7)) - 1, Integer.parseInt(schoolYear.start().substring(8))));
        jDateChooserEnd.setDate(new Date(Integer.parseInt(schoolYear.end().toString().substring(0, 4)) - 1900, Integer.parseInt(schoolYear.end().toString().substring(5, 7)) - 1, Integer.parseInt(schoolYear.end().substring(8))));

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jTextFieldSchoolYear = new javax.swing.JTextField();
        jComboBoxSemester = new javax.swing.JComboBox<>();
        jDateChooserStart = new com.toedter.calendar.JDateChooser();
        jDateChooserEnd = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new java.awt.GridLayout(0, 1, 0, 5));

        jLabel1.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("SCHOOL YEAR:");
        jPanel1.add(jLabel1);

        jLabel2.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("SEMESTER:");
        jPanel1.add(jLabel2);

        jLabel3.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("START:");
        jPanel1.add(jLabel3);

        jLabel4.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("END:");
        jPanel1.add(jLabel4);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 21, 97, 150));

        jPanel2.setLayout(new java.awt.GridLayout(0, 1, 0, 5));

        jTextFieldSchoolYear.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jPanel2.add(jTextFieldSchoolYear);

        jPanel2.add(jComboBoxSemester);
        jPanel2.add(jDateChooserStart);
        jPanel2.add(jDateChooserEnd);

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(103, 21, 280, 150));

        jButton1.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jButton1.setText("Enter");
        jButton1.setPreferredSize(new java.awt.Dimension(72, 36));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 370, -1));

        setSize(new java.awt.Dimension(409, 275));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        if (jButton1.getText().equals("Save")) {
            int response = JOptionPane.showConfirmDialog(mainFrame, "Are you sure to add " + jTextFieldSchoolYear.getText() + " ?", "Add major confirmation", JOptionPane.YES_NO_OPTION);
            if (response == JOptionPane.YES_OPTION) {
                ComboBoxList semesterIdl = (ComboBoxList) this.jComboBoxSemester.getSelectedItem();
                Semester sem = new Semester(Integer.parseInt(semesterIdl.getId()), jComboBoxSemester.getSelectedItem().toString());
                SchoolYear sy = new SchoolYear(0, jTextFieldSchoolYear.getText(), sem, new java.sql.Date(jDateChooserStart.getDate().getTime()).toString(), new java.sql.Date(jDateChooserEnd.getDate().getTime()).toString());
                new AppQuery().addSchoolYear(sy);
                this.dispose();
            }
        } else if (jButton1.getText().equals("Update")) {
            int response = JOptionPane.showConfirmDialog(mainFrame, "Are you sure to update " + jTextFieldSchoolYear.getText() + " ?", "Add major confirmation", JOptionPane.YES_NO_OPTION);
            if (response == JOptionPane.YES_OPTION) {
                ComboBoxList semesterIdl = (ComboBoxList) this.jComboBoxSemester.getSelectedItem();
                Semester sem = new Semester(Integer.parseInt(semesterIdl.getId()), jComboBoxSemester.getSelectedItem().toString());
                SchoolYear sy = new SchoolYear(this.schoolYear.id(), jTextFieldSchoolYear.getText(), sem, new java.sql.Date(jDateChooserStart.getDate().getTime()).toString(), new java.sql.Date(jDateChooserEnd.getDate().getTime()).toString());
                new AppQuery().updateSchoolYear(sy);
                this.dispose();
            }
        } else if (jButton1.getText().equals("Delete")) {
            int response = JOptionPane.showConfirmDialog(mainFrame, "Are you sure to delete " + jTextFieldSchoolYear.getText() + " ?", "Add major confirmation", JOptionPane.YES_NO_OPTION);
            if (response == JOptionPane.YES_OPTION) {
                ComboBoxList semesterIdl = (ComboBoxList) this.jComboBoxSemester.getSelectedItem();
                Semester sem = new Semester(Integer.parseInt(semesterIdl.getId()), jComboBoxSemester.getSelectedItem().toString());
                SchoolYear sy = new SchoolYear(this.schoolYear.id(), jTextFieldSchoolYear.getText(), sem, new java.sql.Date(jDateChooserStart.getDate().getTime()).toString(), new java.sql.Date(jDateChooserEnd.getDate().getTime()).toString());
                new AppQuery().deleteSchoolYear(sy);
                this.dispose();
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<Object> jComboBoxSemester;
    private com.toedter.calendar.JDateChooser jDateChooserEnd;
    private com.toedter.calendar.JDateChooser jDateChooserStart;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextFieldSchoolYear;
    // End of variables declaration//GEN-END:variables
  private void comboBoxSemester() {
        this.jComboBoxSemester.removeAllItems();
        query.comboBoxSemester();
        for (ComboBoxList a : query.getList()) {
            this.jComboBoxSemester.addItem(a);
        }
    }

}
