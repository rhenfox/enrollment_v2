/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package enrollmentsystem.gui.dialog.au;

import enrollmentsystem.data.AppQuery;
import enrollmentsystem.records.Course;
import javax.swing.JOptionPane;

/**
 *
 * @author Java Programming with Aldrin
 */
public class JDialogCourseAU extends javax.swing.JDialog {

    /**
     * Creates new form JDialogUserAU
     */
    private Course course;
    private enrollmentsystem.gui.JFrameEnrollment mainFrame;

    public JDialogCourseAU(enrollmentsystem.gui.JFrameEnrollment parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.mainFrame = parent;
        setTitle("Add Course");
        jButton1.setText("Save");
        jButton1.setMnemonic('S');

    }

    public JDialogCourseAU(enrollmentsystem.gui.JFrameEnrollment parent, boolean modal, Course course) {
        super(parent, modal);
        initComponents();
        this.mainFrame = parent;
        setTitle("Update Course");
        jButton1.setText("Update");
        jTextFieldCourse.setText(course.course());
        jTextFieldAcronym.setText(course.acronym());
        jButton1.setMnemonic('U');
        this.course = course;
        jButton1.setEnabled(false);
    }

    public JDialogCourseAU(enrollmentsystem.gui.JFrameEnrollment parent, Course course, boolean modal) {
        super(parent, modal);
        initComponents();
        this.mainFrame = parent;
        setTitle("Delete Course");
        jButton1.setText("Delete");
        jTextFieldCourse.setText(course.course());
        jTextFieldAcronym.setText(course.acronym());
        jTextFieldCourse.setFocusable(false);
        jTextFieldAcronym.setFocusable(false);
        jButton1.setMnemonic('D');
        this.course = course;
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
        jPanel2 = new javax.swing.JPanel();
        jTextFieldCourse = new javax.swing.JTextField();
        jTextFieldAcronym = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new java.awt.GridLayout(0, 1, 0, 5));

        jLabel1.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("COURSE:");
        jPanel1.add(jLabel1);

        jLabel2.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("ACRONYM:");
        jPanel1.add(jLabel2);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 21, 97, 80));

        jPanel2.setLayout(new java.awt.GridLayout(0, 1, 0, 5));

        jTextFieldCourse.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jTextFieldCourse.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldCourseKeyReleased(evt);
            }
        });
        jPanel2.add(jTextFieldCourse);

        jTextFieldAcronym.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jTextFieldAcronym.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldAcronymKeyReleased(evt);
            }
        });
        jPanel2.add(jTextFieldAcronym);

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(103, 21, 280, 80));

        jButton1.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jButton1.setText("Enter");
        jButton1.setPreferredSize(new java.awt.Dimension(72, 36));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 370, -1));

        setSize(new java.awt.Dimension(413, 200));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        if (jButton1.getText().equals("Save")) {
            int response = JOptionPane.showConfirmDialog(mainFrame, "Are you sure to add " + jTextFieldCourse.getText() + " ?", "Add course confirmation", JOptionPane.YES_NO_OPTION);
            if (response == JOptionPane.YES_OPTION) {
                Course course = new Course(null, jTextFieldCourse.getText(), jTextFieldAcronym.getText());
                new AppQuery().addCourse(course);
                this.dispose();
            }
        } else if (jButton1.getText().equals("Update")) {
            int response = JOptionPane.showConfirmDialog(mainFrame, "Are you sure to update " + jTextFieldCourse.getText() + " ?", "Add course confirmation", JOptionPane.YES_NO_OPTION);
            if (response == JOptionPane.YES_OPTION) {
                Course course = new Course(this.course.id(), jTextFieldCourse.getText(), jTextFieldAcronym.getText());
                new AppQuery().updateCourse(course);
                this.dispose();
            }
        } else if (jButton1.getText().equals("Delete")) {
            int response = JOptionPane.showConfirmDialog(mainFrame, "Are you sure to delete " + jTextFieldCourse.getText() + " ?", "Add course confirmation", JOptionPane.YES_NO_OPTION);
            if (response == JOptionPane.YES_OPTION) {
                Course course = new Course(this.course.id(), jTextFieldCourse.getText(), jTextFieldAcronym.getText());
                new AppQuery().deleteCourse(course);
                this.dispose();
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextFieldCourseKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldCourseKeyReleased
        if (jButton1.getText().equals("Save")) {

        } else {
            isCourseUpdated();
        }


    }//GEN-LAST:event_jTextFieldCourseKeyReleased

    private void jTextFieldAcronymKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldAcronymKeyReleased
        if (jButton1.getText().equals("Save")) {

        } else {
            isCourseUpdated();
        }
    }//GEN-LAST:event_jTextFieldAcronymKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextFieldAcronym;
    private javax.swing.JTextField jTextFieldCourse;
    // End of variables declaration//GEN-END:variables
  private void isCourseUpdated() {
        Course c = new Course(this.course.id(), jTextFieldCourse.getText(), jTextFieldAcronym.getText());
        if ((c.course().length() == 0) || (c.acronym().length() == 0)) {
            jButton1.setEnabled(false);
            return;
        }
        if (this.course.equals(c)) {
            jButton1.setEnabled(false);
        } else {
            jButton1.setEnabled(true);
        }
    }

}
