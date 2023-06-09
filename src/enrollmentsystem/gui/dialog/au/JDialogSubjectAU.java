/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package enrollmentsystem.gui.dialog.au;

import enrollmentsystem.data.AppQuery;
import enrollmentsystem.data.ComboBoxList;
import enrollmentsystem.records.Course;
import enrollmentsystem.records.CourseMajor;
import enrollmentsystem.records.Subject;
import enrollmentsystem.records.Unit;
import enrollmentsystem.util.ComboBoxAutoFill;
import javax.swing.JOptionPane;
import javax.swing.text.JTextComponent;

/**
 *
 * @author Java Programming with Aldrin
 */
public class JDialogSubjectAU extends javax.swing.JDialog {

    /**
     * Creates new form JDialogUserAU
     */
    private Subject subject;
    private enrollmentsystem.gui.JFrameEnrollment mainFrame;
    private AppQuery query = new AppQuery();
    private JTextComponent editor;

    public JDialogSubjectAU(enrollmentsystem.gui.JFrameEnrollment parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.mainFrame = parent;
        setTitle("Add subject");
        jButton1.setText("Save");
        jButton1.setMnemonic('S');
        comboBoxUnits();
        jComboBoxUnit.setEditable(true);
        editor = (JTextComponent) jComboBoxUnit.getEditor().getEditorComponent();
        editor.setDocument(new ComboBoxAutoFill(jComboBoxUnit));
        comboBoxCourse();
        jComboBoxUnit.setEditable(true);
        editor = (JTextComponent) jComboBoxUnit.getEditor().getEditorComponent();
        editor.setDocument(new ComboBoxAutoFill(jComboBoxUnit));

    }

    public JDialogSubjectAU(enrollmentsystem.gui.JFrameEnrollment parent, boolean modal, Subject subject) {
        super(parent, modal);
        initComponents();
        this.mainFrame = parent;
        setTitle("Update subject");
        jButton1.setText("Update");
        jTextFieldCode.setText(subject.code());
        jTextFieldSubject.setText(subject.subject());
        jButton1.setMnemonic('U');
        this.subject = subject;
        System.out.println("unitId:" + subject.units().id());
        comboBoxUnits();
        for (ComboBoxList a : this.query.getList()) {
            a.setSelectedId(query.getList(), String.valueOf(subject.units().id()), jComboBoxUnit);
        }
        comboBoxCourse();
        for (ComboBoxList a : this.query.getList()) {
            a.setSelectedId(query.getList(), String.valueOf(subject.course().id()), jComboBoxCourse);
        }
    }

    public JDialogSubjectAU(enrollmentsystem.gui.JFrameEnrollment parent, Subject subject, boolean modal) {
        super(parent, modal);
        initComponents();
        this.mainFrame = parent;
        setTitle("Delete subject");
        jButton1.setText("Delete");
        jTextFieldCode.setText(subject.code());
        jTextFieldSubject.setText(subject.subject());
        jTextFieldCode.setFocusable(false);
        jTextFieldSubject.setFocusable(false);
        jButton1.setMnemonic('D');
        this.subject = subject;
        comboBoxUnits();
        for (ComboBoxList a : this.query.getList()) {
            a.setSelectedId(query.getList(), String.valueOf(subject.units().id()), jComboBoxUnit);
        }
        comboBoxCourse();
        for (ComboBoxList a : this.query.getList()) {
            a.setSelectedId(query.getList(), String.valueOf(subject.course().id()), jComboBoxCourse);
        }
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
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jComboBoxCourse = new javax.swing.JComboBox<>();
        jTextFieldCode = new javax.swing.JTextField();
        jTextFieldSubject = new javax.swing.JTextField();
        jComboBoxUnit = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new java.awt.GridLayout(0, 1, 0, 5));

        jLabel4.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("COURSE:");
        jPanel1.add(jLabel4);

        jLabel1.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("CODE:");
        jPanel1.add(jLabel1);

        jLabel2.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("SUBJECT:");
        jPanel1.add(jLabel2);

        jLabel3.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("UNIT:");
        jPanel1.add(jLabel3);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 21, 70, 140));

        jPanel2.setLayout(new java.awt.GridLayout(0, 1, 0, 5));

        jComboBoxCourse.setFont(new java.awt.Font("Courier New", 0, 16)); // NOI18N
        jPanel2.add(jComboBoxCourse);

        jTextFieldCode.setFont(new java.awt.Font("Courier New", 0, 16)); // NOI18N
        jPanel2.add(jTextFieldCode);

        jTextFieldSubject.setFont(new java.awt.Font("Courier New", 0, 16)); // NOI18N
        jPanel2.add(jTextFieldSubject);

        jComboBoxUnit.setFont(new java.awt.Font("Courier New", 0, 16)); // NOI18N
        jPanel2.add(jComboBoxUnit);

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 21, 440, 140));

        jButton1.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jButton1.setText("Enter");
        jButton1.setPreferredSize(new java.awt.Dimension(72, 36));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 180, 110, -1));

        setSize(new java.awt.Dimension(539, 259));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        if (jButton1.getText().equals("Save")) {
            int response = JOptionPane.showConfirmDialog(mainFrame, "Are you sure to add " + jTextFieldCode.getText() + " ?", "Add major confirmation", JOptionPane.YES_NO_OPTION);
            if (response == JOptionPane.YES_OPTION) {
                ComboBoxList unitIdl = (ComboBoxList) this.jComboBoxUnit.getSelectedItem();
                Unit unit = new Unit(Integer.parseInt(unitIdl.getId()), Integer.parseInt(jComboBoxUnit.getSelectedItem().toString()));
                ComboBoxList courseIdl = (ComboBoxList) this.jComboBoxCourse.getSelectedItem();
                Course course = new Course(Integer.parseInt(courseIdl.getId()), null, null);
                Subject subject = new Subject(0, course, jTextFieldCode.getText(), jTextFieldSubject.getText(), unit);
                new AppQuery().addSubject(subject);
                this.dispose();
            }
        } else if (jButton1.getText().equals("Update")) {
            int response = JOptionPane.showConfirmDialog(mainFrame, "Are you sure to update " + jTextFieldCode.getText() + " ?", "Add major confirmation", JOptionPane.YES_NO_OPTION);
            if (response == JOptionPane.YES_OPTION) {
                ComboBoxList unitIdl = (ComboBoxList) this.jComboBoxUnit.getSelectedItem();
                Unit unit = new Unit(Integer.parseInt(unitIdl.getId()), Integer.parseInt(jComboBoxUnit.getSelectedItem().toString()));
                ComboBoxList courseIdl = (ComboBoxList) this.jComboBoxCourse.getSelectedItem();
                Course course = new Course(Integer.parseInt(courseIdl.getId()), null, null);
                Subject subject = new Subject(this.subject.id(), course, jTextFieldCode.getText(), jTextFieldSubject.getText(), unit);
                new AppQuery().updateSubject(subject);
                this.dispose();
            }
        } else if (jButton1.getText().equals("Delete")) {
            int response = JOptionPane.showConfirmDialog(mainFrame, "Are you sure to delete " + jTextFieldCode.getText() + " ?", "Add major confirmation", JOptionPane.YES_NO_OPTION);
            if (response == JOptionPane.YES_OPTION) {
                ComboBoxList unitIdl = (ComboBoxList) this.jComboBoxUnit.getSelectedItem();
                Unit unit = new Unit(Integer.parseInt(unitIdl.getId()), Integer.parseInt(jComboBoxUnit.getSelectedItem().toString()));
                ComboBoxList courseIdl = (ComboBoxList) this.jComboBoxCourse.getSelectedItem();
                Course course = new Course(Integer.parseInt(courseIdl.getId()), null, null);
                Subject subject = new Subject(this.subject.id(), course, jTextFieldCode.getText(), jTextFieldSubject.getText(), unit);
                new AppQuery().deleteSubject(subject);
                this.dispose();
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<Object> jComboBoxCourse;
    private javax.swing.JComboBox<Object> jComboBoxUnit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextFieldCode;
    private javax.swing.JTextField jTextFieldSubject;
    // End of variables declaration//GEN-END:variables
  private void comboBoxUnits() {
        this.jComboBoxUnit.removeAllItems();
        query.comboBoxUnits();
        for (ComboBoxList a : query.getList()) {
            this.jComboBoxUnit.addItem(a);
        }
    }

    private void comboBoxCourse() {
        this.jComboBoxCourse.removeAllItems();
        query.comboBoxCourse();
        for (ComboBoxList a : query.getList()) {
            this.jComboBoxCourse.addItem(a);
        }
    }

}
