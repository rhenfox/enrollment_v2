/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package enrollmentsystem.gui.dialog.au;

import enrollmentsystem.data.AppQuery;
import enrollmentsystem.records.Unit;
import javax.swing.JOptionPane;

/**
 *
 * @author Java Programming with Aldrin
 */
public class JDialogUnitAU extends javax.swing.JDialog {

    /**
     * Creates new form JDialogUserAU
     */
    private Unit unit;
    private enrollmentsystem.gui.JFrameEnrollment mainFrame;
    private AppQuery query = new AppQuery();

    public JDialogUnitAU(enrollmentsystem.gui.JFrameEnrollment parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.mainFrame = parent;
        setTitle("Add unit");
        jButton1.setText("Save");
        jButton1.setMnemonic('S');
        

    }

    public JDialogUnitAU(enrollmentsystem.gui.JFrameEnrollment parent, boolean modal, Unit unit) {
        super(parent, modal);
        initComponents();
        this.mainFrame = parent;
        setTitle("Update unit");
        jButton1.setText("Update");
        jTextFieldUnit.setText(String.valueOf(unit.unit()));
        jButton1.setMnemonic('U');
        this.unit = unit;
        jButton1.setEnabled(false);
    }

    public JDialogUnitAU(enrollmentsystem.gui.JFrameEnrollment parent, Unit time, boolean modal) {
        super(parent, modal);
        initComponents();
        this.mainFrame = parent;
        setTitle("Delete unit");
        jButton1.setText("Delete");
        jTextFieldUnit.setText(String.valueOf(unit.unit()));
        jTextFieldUnit.setFocusable(false);
        jButton1.setMnemonic('D');
        this.unit = time;
        
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
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jTextFieldUnit = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new java.awt.GridLayout(0, 1, 0, 5));

        jLabel2.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("UNIT:");
        jPanel1.add(jLabel2);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 21, 97, 40));

        jPanel2.setLayout(new java.awt.GridLayout(0, 1, 0, 5));

        jTextFieldUnit.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jTextFieldUnit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldUnitKeyReleased(evt);
            }
        });
        jPanel2.add(jTextFieldUnit);

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(103, 21, 280, 40));

        jButton1.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jButton1.setText("Enter");
        jButton1.setPreferredSize(new java.awt.Dimension(72, 36));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 110, -1));

        setSize(new java.awt.Dimension(413, 163));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        if (jButton1.getText().equals("Save")) {
            int response = JOptionPane.showConfirmDialog(mainFrame, "Are you sure to add " + jTextFieldUnit.getText() + " ?", "Add time confirmation", JOptionPane.YES_NO_OPTION);
            if (response == JOptionPane.YES_OPTION) {
                Unit unit = new Unit(0, Integer.parseInt(jTextFieldUnit.getText()));
                new AppQuery().addUnit(unit);
                this.dispose();
            }
        } else if (jButton1.getText().equals("Update")) {
            int response = JOptionPane.showConfirmDialog(mainFrame, "Are you sure to update " + jTextFieldUnit.getText() + " ?", "Add time confirmation", JOptionPane.YES_NO_OPTION);
            if (response == JOptionPane.YES_OPTION) {
                Unit unit = new Unit(this.unit.id(), Integer.parseInt(jTextFieldUnit.getText()));
                new AppQuery().updateUnit(unit);
                this.dispose();
            }
        } else if (jButton1.getText().equals("Delete")) {
            int response = JOptionPane.showConfirmDialog(mainFrame, "Are you sure to delete " + jTextFieldUnit.getText() + " ?", "Add time confirmation", JOptionPane.YES_NO_OPTION);
            if (response == JOptionPane.YES_OPTION) {
                Unit unit = new Unit(this.unit.id(),this.unit.unit());
                new AppQuery().deleteUnit(unit);
                this.dispose();
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextFieldUnitKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldUnitKeyReleased

    }//GEN-LAST:event_jTextFieldUnitKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextFieldUnit;
    // End of variables declaration//GEN-END:variables
  

}
