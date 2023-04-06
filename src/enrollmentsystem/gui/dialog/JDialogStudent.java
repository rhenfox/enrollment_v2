/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package enrollmentsystem.gui.dialog;

import enrollmentsystem.data.AppQuery;
import enrollmentsystem.gui.JFrameEnrollment;
import enrollmentsystem.gui.dialog.au.JDialogStudentAU;
import enrollmentsystem.records.CivilStatus;
import enrollmentsystem.records.Course;
import enrollmentsystem.records.Student;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Java Programming with Aldrin
 */
public class JDialogStudent extends javax.swing.JDialog implements MouseListener {

    /**
     * Creates new form JDialogUser
     */
    private JFrameEnrollment mainFrame;
    private Student student;

    public JDialogStudent(enrollmentsystem.gui.JFrameEnrollment parent, boolean modal) {
        super(parent, modal);
        this.mainFrame = parent;
        initComponents();
        jButtonUpdate.setEnabled(false);
        jButtonDelete.setEnabled(false);
        setTable();
        selectStudent();

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
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jButtonAdd = new javax.swing.JButton();
        jButtonUpdate = new javax.swing.JButton();
        jButtonDelete = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jTextFieldSearch = new enrollmentsystem.util.JTextFieldIcon();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Students");
        setResizable(false);

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel5.setLayout(new java.awt.BorderLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel5.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel5, java.awt.BorderLayout.CENTER);

        jPanel6.setPreferredSize(new java.awt.Dimension(951, 10));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1034, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel6, java.awt.BorderLayout.SOUTH);

        jPanel7.setPreferredSize(new java.awt.Dimension(10, 399));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 453, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel7, java.awt.BorderLayout.EAST);

        jPanel8.setPreferredSize(new java.awt.Dimension(10, 399));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 453, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel8, java.awt.BorderLayout.WEST);

        jPanel9.setPreferredSize(new java.awt.Dimension(951, 10));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1034, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel9, java.awt.BorderLayout.PAGE_START);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        jPanel2.setPreferredSize(new java.awt.Dimension(951, 50));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 10, 10));

        jButtonAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/enrollmentsystem/icons/24 plus.png"))); // NOI18N
        jButtonAdd.setMnemonic('A');
        jButtonAdd.setText("Add");
        jButtonAdd.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButtonAdd.setPreferredSize(new java.awt.Dimension(90, 34));
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed(evt);
            }
        });
        jPanel3.add(jButtonAdd);

        jButtonUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/enrollmentsystem/icons/32 edit.png"))); // NOI18N
        jButtonUpdate.setMnemonic('U');
        jButtonUpdate.setText("Update");
        jButtonUpdate.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButtonUpdate.setPreferredSize(new java.awt.Dimension(90, 34));
        jButtonUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdateActionPerformed(evt);
            }
        });
        jPanel3.add(jButtonUpdate);

        jButtonDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/enrollmentsystem/icons/32 delete.png"))); // NOI18N
        jButtonDelete.setMnemonic('D');
        jButtonDelete.setText("Delete");
        jButtonDelete.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButtonDelete.setPreferredSize(new java.awt.Dimension(90, 34));
        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });
        jPanel3.add(jButtonDelete);

        jPanel2.add(jPanel3, java.awt.BorderLayout.CENTER);

        jPanel4.setPreferredSize(new java.awt.Dimension(300, 50));
        jPanel4.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 10));

        jTextFieldSearch.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jTextFieldSearch.setLeftIcon(new javax.swing.ImageIcon(getClass().getResource("/enrollmentsystem/icons/24 search.png"))); // NOI18N
        jTextFieldSearch.setMargin(new java.awt.Insets(2, 28, 2, 6));
        jTextFieldSearch.setPlaceHolder("Search");
        jTextFieldSearch.setPreferredSize(new java.awt.Dimension(285, 32));
        jTextFieldSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldSearchKeyReleased(evt);
            }
        });
        jPanel4.add(jTextFieldSearch);

        jPanel2.add(jPanel4, java.awt.BorderLayout.EAST);

        getContentPane().add(jPanel2, java.awt.BorderLayout.NORTH);

        setSize(new java.awt.Dimension(1050, 531));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed
        JDialogStudentAU uau = new JDialogStudentAU(mainFrame, true);
        uau.setVisible(true);
        selectStudent();
    }//GEN-LAST:event_jButtonAddActionPerformed

    private void jTextFieldSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldSearchKeyReleased
        String text = jTextFieldSearch.getText().trim();
        if (text.length() == 0) {
            sorter.setRowFilter(null);
        } else {
            sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text + ",*"));
        }
    }//GEN-LAST:event_jTextFieldSearchKeyReleased

    private void jButtonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateActionPerformed
        JDialogStudentAU uau = new JDialogStudentAU(mainFrame, true, this.student);
        uau.setVisible(true);
        selectStudent();
    }//GEN-LAST:event_jButtonUpdateActionPerformed

    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
        JDialogStudentAU uau = new JDialogStudentAU(mainFrame, this.student, true);
        uau.setVisible(true);
        selectStudent();
    }//GEN-LAST:event_jButtonDeleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonUpdate;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private enrollmentsystem.util.JTextFieldIcon jTextFieldSearch;
    // End of variables declaration//GEN-END:variables

    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == jTable1) {
            if (e.getButton() == MouseEvent.BUTTON1) {
                if (e.getClickCount() == 1) {
                    jButtonUpdate.setEnabled(true);
                    jButtonDelete.setEnabled(true);
                    int row = jTable1.getSelectedRow();
                    if (row != -1) {

                        Integer idl = Integer.parseInt(jTable1.getValueAt(row, 0).toString());
                        Integer courseIdl = Integer.parseInt(jTable1.getValueAt(row, 1).toString());
                        String studentl = jTable1.getValueAt(row, 2).toString();
                        String coursel = jTable1.getValueAt(row, 3).toString();
                        String firstnamel = jTable1.getValueAt(row, 4).toString();
                        String middlenamel = jTable1.getValueAt(row, 5).toString();
                        String lastnamel = jTable1.getValueAt(row, 6).toString();
                        String genderl = jTable1.getValueAt(row, 7).toString();
                        Integer civilStatusIdl = Integer.parseInt(jTable1.getValueAt(row, 8).toString());
                        String civilStatusl = jTable1.getValueAt(row, 9).toString();
                        String dateOfBirtl = jTable1.getValueAt(row, 10).toString();
                        String mobilel = jTable1.getValueAt(row, 11).toString();
                        String emaill = jTable1.getValueAt(row, 12).toString();
                        String addressl = jTable1.getValueAt(row, 13).toString();
                        Course course = new Course(courseIdl, coursel, coursel);
                        CivilStatus civilStatus = new CivilStatus(civilStatusIdl, civilStatusl);
                        String religionl = jTable1.getValueAt(row, 14).toString();
                        String dOBl = jTable1.getValueAt(row, 15).toString();
                        Student student = new Student(idl, firstnamel, middlenamel, lastnamel, course, genderl, civilStatus, religionl, dOBl, mobilel, emaill, addressl, null);
                        this.student = student;
//                       
                    }
                }
            }
        }
    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public DefaultTableModel tableModel = new DefaultTableModel() {
        public Class getColumnClass(int columnIndex) {
            return String.class;
        }

        public boolean isCellEditable(int row, int col) {
            return false;
        }
    };
    private TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(tableModel);

    private void setTable() {
        try {
            String[] columnNames = {
                //        studentid ,courseId,student , course,firstname,middlename,lastname,  
                //        String gender,String dateOfBirth,String mobileNo,String email, String address
                "studentId",//
                "courseId",//1
                "STUDENT",//2
                "COURSE",//3
                "FIRST NAME",//4
                "MIDDLE NAME",
                "LAST NAME",
                "GENDER",
                "Civil statusID",
                "CIVIL STATUS",
                "DATE OF BIRTH",//10
                "MOBILE",//11
                "EMAIL",//12
                "ADDRESS",//13
                "RELIGION",//14
                "dOB"//15
            };//15
            jTable1.setCellSelectionEnabled(true);
            jTable1 = new JTable(tableModel);
            JTableHeader header = jTable1.getTableHeader();
            header.setPreferredSize(new Dimension(100, 32));
            header.setFont(new Font("Courier New", Font.PLAIN, 14));
//            header.setBackground(new java.awt.Color(153, 153, 153));
            jTable1.setRowSorter(sorter);
            jTable1.addMouseListener(this);
            jTable1.setRowHeight(28);
            jTable1.setFont(new Font("Courier New", Font.PLAIN, 14));
            jScrollPane1.setViewportView(jTable1);
            for (int i = 0; i < columnNames.length;) {
                tableModel.addColumn(columnNames[i]);
                i++;
            }

            TableColumn[] column = new TableColumn[100];

            column[0] = jTable1.getColumnModel().getColumn(0);
            column[0].setPreferredWidth(40);

            column[1] = jTable1.getColumnModel().getColumn(1);
            column[1].setPreferredWidth(250);

            column[2] = jTable1.getColumnModel().getColumn(2);
            column[2].setPreferredWidth(170);

            column[3] = jTable1.getColumnModel().getColumn(3);
            column[3].setPreferredWidth(70);

            TableColumn hidden1 = jTable1.getColumnModel().getColumn(0);
            hidden1.setMinWidth(0);
            hidden1.setPreferredWidth(0);
            hidden1.setMaxWidth(0);
            TableColumn hidden2 = jTable1.getColumnModel().getColumn(1);
            hidden2.setMinWidth(0);
            hidden2.setPreferredWidth(0);
            hidden2.setMaxWidth(0);
            TableColumn hidden3 = jTable1.getColumnModel().getColumn(4);
            hidden3.setMinWidth(0);
            hidden3.setPreferredWidth(0);
            hidden3.setMaxWidth(0);
            TableColumn hidden4 = jTable1.getColumnModel().getColumn(5);
            hidden4.setMinWidth(0);
            hidden4.setPreferredWidth(0);
            hidden4.setMaxWidth(0);
            TableColumn hidden5 = jTable1.getColumnModel().getColumn(6);
            hidden5.setMinWidth(0);
            hidden5.setPreferredWidth(0);
            hidden5.setMaxWidth(0);
            TableColumn hidden6 = jTable1.getColumnModel().getColumn(7);
            hidden6.setMinWidth(0);
            hidden6.setPreferredWidth(0);
            hidden6.setMaxWidth(0);
            TableColumn hidden7 = jTable1.getColumnModel().getColumn(8);
            hidden7.setMinWidth(0);
            hidden7.setPreferredWidth(0);
            hidden7.setMaxWidth(0);
            TableColumn hidden8 = jTable1.getColumnModel().getColumn(15);
            hidden8.setMinWidth(0);
            hidden8.setPreferredWidth(0);
            hidden8.setMaxWidth(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void selectStudent() {
        List<enrollmentsystem.records.Student> studentList = new AppQuery().getStudent();
        tableModel.setRowCount(0);
        for (enrollmentsystem.records.Student s : studentList) {
            String student = s.lastname() + "," + s.firstname() + " " + s.middlename().substring(0, 1) + ".";
            Date dOB = new Date(Integer.parseInt(s.dateOfBirth().toString().substring(0, 4)) - 1900, Integer.parseInt(s.dateOfBirth().toString().substring(5, 7)) - 1, Integer.parseInt(s.dateOfBirth().substring(8)));
            String pattern = "MMM dd, yyyy";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            String sDate = simpleDateFormat.format(dOB);
            tableModel.addRow(new Object[]{s.id(), s.course().id(), student, s.course().acronym(), s.firstname(), s.middlename(), s.lastname(), s.gender(), s.civilStatus().id(), s.civilStatus().civilStatus(), sDate, s.mobileNo(), s.email(), s.address(), s.religion(), s.dateOfBirth()});
        }
    }
}