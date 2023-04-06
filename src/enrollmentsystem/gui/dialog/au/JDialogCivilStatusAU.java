/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package enrollmentsystem.gui.dialog.au;

import enrollmentsystem.data.AppQuery;
import enrollmentsystem.records.CivilStatus;
import javax.swing.JOptionPane;

/**
 *
 * @author Java Programming with Aldrin
 */
public class JDialogCivilStatusAU extends javax.swing.JDialog {

    /**
     * Creates new form JDialogUserAU
     */
    private CivilStatus civilStatus;
    private enrollmentsystem.gui.JFrameEnrollment mainFrame;

    public JDialogCivilStatusAU(enrollmentsystem.gui.JFrameEnrollment parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.mainFrame = parent;
        setTitle("Add Civil status");
        jButton1.setText("Save");
        jButton1.setMnemonic('S');

    }

    public JDialogCivilStatusAU(enrollmentsystem.gui.JFrameEnrollment parent, boolean modal, CivilStatus civilStatus) {
        super(parent, modal);
        initComponents();
        this.mainFrame = parent;
        setTitle("Update Civil status");
        jButton1.setText("Update");
        jTextFieldCivilStatus.setText(civilStatus.civilStatus());
        jButton1.setMnemonic('U');
        this.civilStatus = civilStatus;
        jButton1.setEnabled(false);
    }

    public JDialogCivilStatusAU(enrollmentsystem.gui.JFrameEnrollment parent, CivilStatus civilStatus, boolean modal) {
        super(parent, modal);
        initComponents();
        this.mainFrame = parent;
        setTitle("Delete Civil status");
        jButton1.setText("Delete");
        jTextFieldCivilStatus.setText(civilStatus.civilStatus());;
        jTextFieldCivilStatus.setFocusable(false);
        jButton1.setMnemonic('D');
        this.civilStatus = civilStatus;
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
        jPanel2 = new javax.swing.JPanel();
        jTextFieldCivilStatus = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new java.awt.GridLayout(0, 1, 0, 5));

        jLabel1.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Civil Status:");
        jPanel1.add(jLabel1);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 21, 120, 40));

        jPanel2.setLayout(new java.awt.GridLayout(0, 1, 0, 5));

        jTextFieldCivilStatus.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jTextFieldCivilStatus.setPreferredSize(new java.awt.Dimension(60, 23));
        jTextFieldCivilStatus.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldCivilStatusKeyReleased(evt);
            }
        });
        jPanel2.add(jTextFieldCivilStatus);

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(128, 21, 255, 40));

        jButton1.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jButton1.setText("Enter");
        jButton1.setPreferredSize(new java.awt.Dimension(72, 36));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 80, 370, -1));

        setSize(new java.awt.Dimension(413, 168));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        if (jButton1.getText().equals("Save")) {
            int response = JOptionPane.showConfirmDialog(mainFrame, "Are you sure to add " + jTextFieldCivilStatus.getText() + " ?", "Add civil status confirmation", JOptionPane.YES_NO_OPTION);
            if (response == JOptionPane.YES_OPTION) {
                CivilStatus cs = new CivilStatus(null, jTextFieldCivilStatus.getText());
                new AppQuery().addCivilStatus(cs);
                this.dispose();
            }
        } else if (jButton1.getText().equals("Update")) {
            int response = JOptionPane.showConfirmDialog(mainFrame, "Are you sure to update " + jTextFieldCivilStatus.getText() + " ?", "Add civil status confirmation", JOptionPane.YES_NO_OPTION);
            if (response == JOptionPane.YES_OPTION) {
                CivilStatus cs = new CivilStatus(this.civilStatus.id(), jTextFieldCivilStatus.getText());
                new AppQuery().updateCivilStatus(cs);
                this.dispose();
            }
        } else if (jButton1.getText().equals("Delete")) {
            int response = JOptionPane.showConfirmDialog(mainFrame, "Are you sure to delete " + jTextFieldCivilStatus.getText() + " ?", "Add civil status confirmation", JOptionPane.YES_NO_OPTION);
            if (response == JOptionPane.YES_OPTION) {
                new AppQuery().deleteCivilStatus(this.civilStatus);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextFieldCivilStatusKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldCivilStatusKeyReleased
        if (jButton1.getText().equals("Save")) {

        } else {
            isCourseUpdated();
        }
    }//GEN-LAST:event_jTextFieldCivilStatusKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextFieldCivilStatus;
    // End of variables declaration//GEN-END:variables
  private void isCourseUpdated() {
        CivilStatus c = new CivilStatus(this.civilStatus.id(), jTextFieldCivilStatus.getText());
        if ((c.civilStatus().length() == 0) || (c.civilStatus().length() == 0)) {
            jButton1.setEnabled(false);
            return;
        }
        if (this.civilStatus.equals(c)) {
            jButton1.setEnabled(false);
        } else {
            jButton1.setEnabled(true);
        }
    }

}
