/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package enrollmentsystem.gui.dialog.au;

import enrollmentsystem.data.AppQuery;
import enrollmentsystem.data.ComboBoxList;
import enrollmentsystem.records.Course;
import enrollmentsystem.records.Day;
import enrollmentsystem.records.Instructor;
import enrollmentsystem.records.Room;
import enrollmentsystem.records.SchoolYear;
import enrollmentsystem.records.Semester;
import enrollmentsystem.records.Student;
import enrollmentsystem.records.Subject;
import enrollmentsystem.records.Time;
import enrollmentsystem.records.User;
import enrollmentsystem.util.ComboBoxAutoFill;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.text.JTextComponent;

/**
 *
 * @author Java Programming with Aldrin
 */
public class JDialogClassAU extends javax.swing.JDialog {

    /**
     * Creates new form JDialogUserAU
     */
    private enrollmentsystem.records.Class clss;
    private enrollmentsystem.gui.JFrameEnrollment mainFrame;
    private AppQuery query = new AppQuery();
    private JTextComponent editor;
    private JTextComponent editorSubject;

    public JDialogClassAU(enrollmentsystem.gui.JFrameEnrollment parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.mainFrame = parent;
        setTitle("Add class offer");
        jButton1.setText("Save");
        jButton1.setMnemonic('S');
        comboBoxCourse();
        jComboBoxCourse.setEditable(true);
        editor = (JTextComponent) jComboBoxCourse.getEditor().getEditorComponent();
        editor.setDocument(new ComboBoxAutoFill(jComboBoxCourse));
        comboBoxInstructor();
        jComboBoxInstructor.setEditable(true);
        editor = (JTextComponent) jComboBoxInstructor.getEditor().getEditorComponent();
        editor.setDocument(new ComboBoxAutoFill(jComboBoxInstructor));
        comboBoxDay();
        jComboBoxDay.setEditable(true);
        editor = (JTextComponent) jComboBoxDay.getEditor().getEditorComponent();
        editor.setDocument(new ComboBoxAutoFill(jComboBoxDay));
        comboBoxRoom();
        jComboBoxRoom.setEditable(true);
        editor = (JTextComponent) jComboBoxRoom.getEditor().getEditorComponent();
        editor.setDocument(new ComboBoxAutoFill(jComboBoxRoom));
        jComboBoxTime.setEditable(true);
        editor = (JTextComponent) jComboBoxTime.getEditor().getEditorComponent();
        editor.setDocument(new ComboBoxAutoFill(jComboBoxTime));
        jButton1.setEnabled(false);
        jTextFieldClassCode.setEnabled(false);
        jComboBoxInstructor.setEnabled(false);
        jComboBoxDay.setEnabled(false);
        jComboBoxTime.setEnabled(false);
        jComboBoxRoom.setEnabled(false);

    }

    public JDialogClassAU(enrollmentsystem.gui.JFrameEnrollment parent, boolean modal, enrollmentsystem.records.Class clss) {
        super(parent, modal);
        initComponents();
        this.mainFrame = parent;
        setTitle("Update class offer");
        jButton1.setText("Update");
        jTextFieldClassCode.setText(clss.classCode());
        jButton1.setMnemonic('U');
        this.clss = clss;
        comboBoxCourse();
        for (ComboBoxList a : this.query.getList()) {
            a.setSelectedId(query.getList(), String.valueOf(clss.course().id()), jComboBoxCourse);
        }
        comboBoxSubject();
        for (ComboBoxList a : this.query.getList()) {
            a.setSelectedId(query.getList(), String.valueOf(clss.subject().id()), jComboBoxSubject);
        }
        comboBoxInstructor();
        for (ComboBoxList a : this.query.getList()) {
            a.setSelectedId(query.getList(), String.valueOf(clss.instructor().id()), jComboBoxInstructor);
        }
        comboBoxDay();
        for (ComboBoxList a : this.query.getList()) {
            a.setSelectedId(query.getList(), String.valueOf(clss.day().id()), jComboBoxDay);
        }
        ComboBoxList dayIdl = (ComboBoxList) this.jComboBoxDay.getSelectedItem();
        comboBoxTime(Integer.parseInt(dayIdl.getId()));
        for (ComboBoxList a : this.query.getList()) {
            a.setSelectedId(query.getList(), String.valueOf(clss.time().id()), jComboBoxTime);
        }
        comboBoxRoom();
        for (ComboBoxList a : this.query.getList()) {
            a.setSelectedId(query.getList(), String.valueOf(clss.room().id()), jComboBoxRoom);
        }

    }

    public JDialogClassAU(enrollmentsystem.gui.JFrameEnrollment parent, enrollmentsystem.records.Class clss, boolean modal) {
        super(parent, modal);
        initComponents();
        this.mainFrame = parent;
        setTitle("Delete class offer");
        jButton1.setText("Delete");
        jTextFieldClassCode.setText(clss.classCode());
//        jTextFieldClassCode.setFocusable(false);
        jButton1.setMnemonic('D');
        this.clss = clss;
        comboBoxSubject();
        for (ComboBoxList a : this.query.getList()) {
            a.setSelectedId(query.getList(), String.valueOf(clss.subject().id()), jComboBoxSubject);
        }
        comboBoxCourse();
        for (ComboBoxList a : this.query.getList()) {
            a.setSelectedId(query.getList(), String.valueOf(clss.course().id()), jComboBoxCourse);
        }
        comboBoxInstructor();
        for (ComboBoxList a : this.query.getList()) {
            a.setSelectedId(query.getList(), String.valueOf(clss.instructor().id()), jComboBoxInstructor);
        }
        comboBoxDay();
        for (ComboBoxList a : this.query.getList()) {
            a.setSelectedId(query.getList(), String.valueOf(clss.day().id()), jComboBoxDay);
        }
        ComboBoxList dayIdl = (ComboBoxList) this.jComboBoxDay.getSelectedItem();
        comboBoxTime(Integer.parseInt(dayIdl.getId()));
        for (ComboBoxList a : this.query.getList()) {
            a.setSelectedId(query.getList(), String.valueOf(clss.time().id()), jComboBoxTime);
        }
        comboBoxRoom();
        for (ComboBoxList a : this.query.getList()) {
            a.setSelectedId(query.getList(), String.valueOf(clss.room().id()), jComboBoxRoom);
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

        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jComboBoxCourse = new javax.swing.JComboBox<>();
        jComboBoxSubject = new javax.swing.JComboBox<>();
        jTextFieldClassCode = new javax.swing.JTextField();
        jComboBoxInstructor = new javax.swing.JComboBox<>();
        jComboBoxDay = new javax.swing.JComboBox<>();
        jComboBoxTime = new javax.swing.JComboBox<>();
        jComboBoxRoom = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jButton1.setText("Enter");
        jButton1.setPreferredSize(new java.awt.Dimension(72, 36));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 500, -1));

        jPanel1.setLayout(new java.awt.GridLayout(0, 1, 0, 6));

        jLabel2.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("COURSE:");
        jPanel1.add(jLabel2);

        jLabel4.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("SUBJECT:");
        jPanel1.add(jLabel4);

        jLabel5.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("CLASS CODE:");
        jPanel1.add(jLabel5);

        jLabel6.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("INSTRUCTOR:");
        jPanel1.add(jLabel6);

        jLabel7.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("DAY:");
        jPanel1.add(jLabel7);

        jLabel8.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("TIME:");
        jPanel1.add(jLabel8);

        jLabel3.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("ROOM:");
        jPanel1.add(jLabel3);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 90, 280));

        jPanel2.setLayout(new java.awt.GridLayout(0, 1, 0, 6));

        jComboBoxCourse.setFont(new java.awt.Font("Courier New", 0, 16)); // NOI18N
        jComboBoxCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxCourseActionPerformed(evt);
            }
        });
        jPanel2.add(jComboBoxCourse);

        jComboBoxSubject.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jComboBoxSubject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxSubjectActionPerformed(evt);
            }
        });
        jPanel2.add(jComboBoxSubject);

        jTextFieldClassCode.setFont(new java.awt.Font("Courier New", 0, 16)); // NOI18N
        jTextFieldClassCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldClassCodeActionPerformed(evt);
            }
        });
        jTextFieldClassCode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldClassCodeKeyReleased(evt);
            }
        });
        jPanel2.add(jTextFieldClassCode);

        jComboBoxInstructor.setFont(new java.awt.Font("Courier New", 0, 16)); // NOI18N
        jComboBoxInstructor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxInstructorActionPerformed(evt);
            }
        });
        jPanel2.add(jComboBoxInstructor);

        jComboBoxDay.setFont(new java.awt.Font("Courier New", 0, 16)); // NOI18N
        jComboBoxDay.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxDayItemStateChanged(evt);
            }
        });
        jComboBoxDay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxDayActionPerformed(evt);
            }
        });
        jComboBoxDay.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jComboBoxDayPropertyChange(evt);
            }
        });
        jPanel2.add(jComboBoxDay);

        jComboBoxTime.setFont(new java.awt.Font("Courier New", 0, 16)); // NOI18N
        jComboBoxTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxTimeActionPerformed(evt);
            }
        });
        jPanel2.add(jComboBoxTime);

        jComboBoxRoom.setFont(new java.awt.Font("Courier New", 0, 16)); // NOI18N
        jComboBoxRoom.setPreferredSize(new java.awt.Dimension(72, 30));
        jComboBoxRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxRoomActionPerformed(evt);
            }
        });
        jPanel2.add(jComboBoxRoom);

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 410, 280));

        setSize(new java.awt.Dimension(535, 414));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        if (jButton1.getText().equals("Save")) {
            int response = JOptionPane.showConfirmDialog(mainFrame, "Are you sure to add " + jTextFieldClassCode.getText() + " ?", "Add major confirmation", JOptionPane.YES_NO_OPTION);
            if (response == JOptionPane.YES_OPTION) {
                ComboBoxList subjectId = (ComboBoxList) this.jComboBoxSubject.getSelectedItem();
                ComboBoxList courseId = (ComboBoxList) this.jComboBoxCourse.getSelectedItem();
                ComboBoxList instructorId = (ComboBoxList) this.jComboBoxInstructor.getSelectedItem();
                ComboBoxList dayId = (ComboBoxList) this.jComboBoxDay.getSelectedItem();
                ComboBoxList timeId = (ComboBoxList) this.jComboBoxTime.getSelectedItem();
                ComboBoxList roomId = (ComboBoxList) this.jComboBoxRoom.getSelectedItem();

                Course courseIdl = new Course(Integer.parseInt(courseId.getId()), null, null);
                Subject subjectIdl = new Subject(Integer.parseInt(subjectId.getId()), courseIdl, null, null, null);
                Instructor instructorIdl = new Instructor(Integer.parseInt(instructorId.getId()), null, null, null, null, null, null, null, null, null, null);
                Day dayIdl = new Day(Integer.parseInt(dayId.getId()), null, null);
                Time timeIdl = new Time(Integer.parseInt(timeId.getId()), null, null);
                Room roomIdl = new Room(Integer.parseInt(roomId.getId()), null, null);
                AppQuery query = new AppQuery();
                SchoolYear sy = new SchoolYear(query.getCurrentSchoolYear(), null, null, null, null);
                User user = new User(1, null, null, null, null, null, null);

                enrollmentsystem.records.Class clss = new enrollmentsystem.records.Class(null, jTextFieldClassCode.getText(), courseIdl, subjectIdl, instructorIdl, dayIdl, timeIdl, roomIdl, sy, user);
                new AppQuery().addClass(clss);
                this.dispose();
            }
        } else if (jButton1.getText().equals("Update")) {
            int response = JOptionPane.showConfirmDialog(mainFrame, "Are you sure to update " + jTextFieldClassCode.getText() + " ?", "Add major confirmation", JOptionPane.YES_NO_OPTION);
            if (response == JOptionPane.YES_OPTION) {
                ComboBoxList subjectId = (ComboBoxList) this.jComboBoxSubject.getSelectedItem();
                ComboBoxList courseId = (ComboBoxList) this.jComboBoxCourse.getSelectedItem();
                ComboBoxList instructorId = (ComboBoxList) this.jComboBoxInstructor.getSelectedItem();
                ComboBoxList dayId = (ComboBoxList) this.jComboBoxDay.getSelectedItem();
                ComboBoxList timeId = (ComboBoxList) this.jComboBoxTime.getSelectedItem();
                ComboBoxList roomId = (ComboBoxList) this.jComboBoxRoom.getSelectedItem();

                Course courseIdl = new Course(Integer.parseInt(courseId.getId()), null, null);
                Subject subjectIdl = new Subject(Integer.parseInt(subjectId.getId()), courseIdl, null, null, null);
                Instructor instructorIdl = new Instructor(Integer.parseInt(courseId.getId()), null, null, null, null, null, null, null, null, null, null);
                Day dayIdl = new Day(Integer.parseInt(courseId.getId()), null, null);
                Time timeIdl = new Time(Integer.parseInt(courseId.getId()), null, null);
                Room roomIdl = new Room(Integer.parseInt(courseId.getId()), null, null);
                AppQuery query = new AppQuery();
                SchoolYear sy = new SchoolYear(query.getCurrentSchoolYear(), null, null, null, null);
                User user = new User(1, null, null, null, null, null, null);

                enrollmentsystem.records.Class clss = new enrollmentsystem.records.Class(null, jTextFieldClassCode.getText(), courseIdl, subjectIdl, instructorIdl, dayIdl, timeIdl, roomIdl, sy, user);
                new AppQuery().updateClass(clss);
                this.dispose();
            }
        } else if (jButton1.getText().equals("Delete")) {
            int response = JOptionPane.showConfirmDialog(mainFrame, "Are you sure to delete " + jTextFieldClassCode.getText() + " ?", "Add major confirmation", JOptionPane.YES_NO_OPTION);
            if (response == JOptionPane.YES_OPTION) {
                enrollmentsystem.records.Class clss = new enrollmentsystem.records.Class(this.clss.id(), jTextFieldClassCode.getText(), null, null, null, null, null, null, null, null);
                new AppQuery().deleteClass(clss);
                this.dispose();
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBoxDayItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxDayItemStateChanged

    }//GEN-LAST:event_jComboBoxDayItemStateChanged

    private void jComboBoxDayPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jComboBoxDayPropertyChange

    }//GEN-LAST:event_jComboBoxDayPropertyChange

    private void jComboBoxDayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxDayActionPerformed
        
        editor = (JTextComponent) jComboBoxSubject.getEditor().getEditorComponent();
        if (editor.getText().isBlank()) {
            jComboBoxTime.setEnabled(false);
        } else {
            jComboBoxTime.setEnabled(true);
            ComboBoxList dayIdl = (ComboBoxList) this.jComboBoxDay.getSelectedItem();
            comboBoxTime(Integer.parseInt(dayIdl.getId()));
        }
       
    }//GEN-LAST:event_jComboBoxDayActionPerformed

    private void jTextFieldClassCodeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldClassCodeKeyReleased
        if (jTextFieldClassCode.getText().length() < 5) {
            jComboBoxInstructor.setEnabled(false);
        } else {
            jComboBoxInstructor.setEnabled(true);
        }
    }//GEN-LAST:event_jTextFieldClassCodeKeyReleased

    private void jComboBoxSubjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxSubjectActionPerformed
        editor = (JTextComponent) jComboBoxSubject.getEditor().getEditorComponent();
        if (editor.getText().isBlank()) {
            jTextFieldClassCode.setEnabled(false);
        } else {
            jTextFieldClassCode.setEnabled(true);
        }

    }//GEN-LAST:event_jComboBoxSubjectActionPerformed

    private void jComboBoxCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxCourseActionPerformed
        editor = (JTextComponent) jComboBoxCourse.getEditor().getEditorComponent();
        if (editor.getText().isBlank()) {
            jComboBoxSubject.setEnabled(false);
        } else {
            ComboBoxList courseId = (ComboBoxList) this.jComboBoxCourse.getSelectedItem();
            comboBoxSubject(Integer.parseInt(courseId.getId()));
            jComboBoxSubject.setEditable(true);
            editorSubject = (JTextComponent) jComboBoxSubject.getEditor().getEditorComponent();
            editorSubject.setDocument(new ComboBoxAutoFill(jComboBoxSubject));

            query.comboBoxSubject(Integer.parseInt(courseId.getId()));
            ArrayList<ComboBoxList> list = query.getList();
            if (list.isEmpty()) {
                jComboBoxSubject.setEnabled(false);
            } else {
                jComboBoxSubject.setEnabled(true);
            }
        }
    }//GEN-LAST:event_jComboBoxCourseActionPerformed

    private void jComboBoxInstructorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxInstructorActionPerformed
        editor = (JTextComponent) jComboBoxInstructor.getEditor().getEditorComponent();
        if (editor.getText().isBlank()) {
            jComboBoxDay.setEnabled(false);
        } else {
            jComboBoxDay.setEnabled(true);
        }
    }//GEN-LAST:event_jComboBoxInstructorActionPerformed

    private void jComboBoxRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxRoomActionPerformed
       editor = (JTextComponent) jComboBoxRoom.getEditor().getEditorComponent();
        if (editor.getText().isBlank()) {
            jButton1.setEnabled(false);
        } else {
            jButton1.setEnabled(true);
        }
    }//GEN-LAST:event_jComboBoxRoomActionPerformed

    private void jComboBoxTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxTimeActionPerformed
        editor = (JTextComponent) jComboBoxTime.getEditor().getEditorComponent();
        if (editor.getText().isBlank()) {
            jComboBoxRoom.setEnabled(false);
        } else {
            jComboBoxRoom.setEnabled(true);
        }
    }//GEN-LAST:event_jComboBoxTimeActionPerformed

    private void jTextFieldClassCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldClassCodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldClassCodeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<Object> jComboBoxCourse;
    private javax.swing.JComboBox<Object> jComboBoxDay;
    private javax.swing.JComboBox<Object> jComboBoxInstructor;
    private javax.swing.JComboBox<Object> jComboBoxRoom;
    private javax.swing.JComboBox<Object> jComboBoxSubject;
    private javax.swing.JComboBox<Object> jComboBoxTime;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextFieldClassCode;
    // End of variables declaration//GEN-END:variables
  private void comboBoxSubject() {
        this.jComboBoxSubject.removeAllItems();
        query.comboBoxSubject();
        for (ComboBoxList a : query.getList()) {
            this.jComboBoxSubject.addItem(a);
        }
    }

    private void comboBoxSubject(Integer courseId) {
        this.jComboBoxSubject.removeAllItems();
        query.comboBoxSubject(courseId);
        for (ComboBoxList a : query.getList()) {
            this.jComboBoxSubject.addItem(a);
        }
    }

    private void comboBoxCourse() {
        this.jComboBoxCourse.removeAllItems();
        query.comboBoxCourse();
        for (ComboBoxList a : query.getList()) {
            this.jComboBoxCourse.addItem(a);
        }
    }

    private void comboBoxInstructor() {
        this.jComboBoxInstructor.removeAllItems();
        query.comboBoxInstructor();
        for (ComboBoxList a : query.getList()) {
            this.jComboBoxInstructor.addItem(a);
        }
    }

    private void comboBoxDay() {
        this.jComboBoxDay.removeAllItems();
        query.comboBoxDay();
        for (ComboBoxList a : query.getList()) {
            this.jComboBoxDay.addItem(a);
        }
    }

    private void comboBoxTime(Integer id) {
        this.jComboBoxTime.removeAllItems();
        query.comboBoxTime(id);
        for (ComboBoxList a : query.getList()) {
            this.jComboBoxTime.addItem(a);
        }
    }

    private void comboBoxRoom() {
        this.jComboBoxRoom.removeAllItems();
        query.comboBoxRoom();
        for (ComboBoxList a : query.getList()) {
            this.jComboBoxRoom.addItem(a);
        }
    }

}
