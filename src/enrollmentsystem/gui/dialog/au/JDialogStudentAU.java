/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package enrollmentsystem.gui.dialog.au;

import enrollmentsystem.data.AppQuery;
import enrollmentsystem.data.ComboBoxList;
import enrollmentsystem.gui.JFrameEnrollment;
import enrollmentsystem.records.CivilStatus;
import enrollmentsystem.records.Course;
import enrollmentsystem.records.Student;
import enrollmentsystem.util.ComboBoxAutoFill;
import enrollmentsystem.util.ImagePreview;
import enrollmentsystem.util.ImageFilter;
import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Blob;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.text.JTextComponent;

/**
 *
 * @author Java Programming with Aldrin
 */
public class JDialogStudentAU extends javax.swing.JDialog {

    /**
     * Creates new form JDialogStudentAU
     */
    private AppQuery query = new AppQuery();
    private JTextComponent editor;
    private JFrameEnrollment mainFrame;
    private Student student;
    private File photo = null;

    public JDialogStudentAU(enrollmentsystem.gui.JFrameEnrollment parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setTitle("Add student");
        comboBoxCourse();
        jComboBoxCourse.setEditable(true);
        editor = (JTextComponent) jComboBoxCourse.getEditor().getEditorComponent();
        editor.setDocument(new ComboBoxAutoFill(jComboBoxCourse));
        jButton1.setText("Save");
        jButton1.setMnemonic('S');

        comboBoxCivilStatus();
        jComboBoxCivilStatus.setEditable(true);
        editor = (JTextComponent) jComboBoxCivilStatus.getEditor().getEditorComponent();
        editor.setDocument(new ComboBoxAutoFill(jComboBoxCivilStatus));
    }

    public JDialogStudentAU(enrollmentsystem.gui.JFrameEnrollment parent, boolean modal, Student student) {
        super(parent, modal);
        initComponents();
        this.student = student;
        setTitle("Update student");
        comboBoxCourse();
        for (ComboBoxList a : this.query.getList()) {
            a.setSelectedId(query.getList(), String.valueOf(student.course().id()), jComboBoxCourse);
        }
        comboBoxCivilStatus();
        for (ComboBoxList a : this.query.getList()) {
            a.setSelectedId(query.getList(), String.valueOf(student.civilStatus().id()), jComboBoxCivilStatus);
        }
        jButton1.setText("Update");
        jButton1.setMnemonic('U');
        this.student = student;
        jTextFieldFirstname1.setText(student.firstname());
        jTextFieldMiddlename.setText(student.middlename());
        jTextFieldLastname.setText(student.lastname());
        jDateChooserDoB.setDate(new Date(Integer.parseInt(student.dateOfBirth().toString().substring(0, 4)) - 1900, Integer.parseInt(student.dateOfBirth().toString().substring(5, 7)) - 1, Integer.parseInt(student.dateOfBirth().substring(8))));
        jComboBoxGender.setSelectedItem(student.gender());
        jTextFieldMobile.setText(student.mobileNo());
        jTextFieldEmail.setText(student.email());
        jTextFieldAddress.setText(student.address());
        jLabelPhoto.setText("");
        displayPicture(student.id());
        jTextFieldReligion.setText(student.religion());

    }

    public JDialogStudentAU(enrollmentsystem.gui.JFrameEnrollment parent, Student student, boolean modal) {
        super(parent, modal);
        initComponents();
        this.student = student;
        setTitle("Delete student");

        jButton1.setText("Delete");
        jButton1.setMnemonic('U');
        this.student = student;
        jTextFieldFirstname1.setText(student.firstname());
        jTextFieldMiddlename.setText(student.middlename());
        jTextFieldLastname.setText(student.lastname());
        comboBoxCourse();
        for (ComboBoxList a : this.query.getList()) {
            a.setSelectedId(query.getList(), String.valueOf(student.course().id()), jComboBoxCourse);
        }
        comboBoxCivilStatus();
        for (ComboBoxList a : this.query.getList()) {
            a.setSelectedId(query.getList(), String.valueOf(student.civilStatus().id()), jComboBoxCivilStatus);
        }
        jDateChooserDoB.setDate(new Date(Integer.parseInt(student.dateOfBirth().toString().substring(0, 4)) - 1900, Integer.parseInt(student.dateOfBirth().toString().substring(5, 7)) - 1, Integer.parseInt(student.dateOfBirth().substring(8))));
        jComboBoxGender.setSelectedItem(student.gender());
        jTextFieldMobile.setText(student.mobileNo());
        jTextFieldEmail.setText(student.email());
        jTextFieldAddress.setText(student.address());
        jLabelPhoto.setText("");
        displayPicture(student.id());
        comboBoxCourse();
        for (ComboBoxList a : this.query.getList()) {
            a.setSelectedId(query.getList(), String.valueOf(student.course().id()), jComboBoxCourse);
        }
        jTextFieldReligion.setText(student.religion());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabelPhoto = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldFirstname1 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jTextFieldMiddlename = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jTextFieldLastname = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jComboBoxCourse = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        jComboBoxGender = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        jComboBoxCivilStatus = new javax.swing.JComboBox<>();
        jTextFieldReligion = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jDateChooserDoB = new com.toedter.calendar.JDateChooser();
        jLabel19 = new javax.swing.JLabel();
        jTextFieldMobile = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jTextFieldEmail = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jTextFieldAddress = new javax.swing.JTextField();

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
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 290, 90, -1));

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setMaximumSize(new java.awt.Dimension(192, 192));
        jPanel3.setMinimumSize(new java.awt.Dimension(192, 192));
        jPanel3.setPreferredSize(new java.awt.Dimension(192, 192));
        jPanel3.setLayout(new java.awt.BorderLayout());

        jLabelPhoto.setFont(new java.awt.Font("Courier New", 0, 24)); // NOI18N
        jLabelPhoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPhoto.setText("No Photo");
        jLabelPhoto.setMaximumSize(new java.awt.Dimension(220, 220));
        jLabelPhoto.setMinimumSize(new java.awt.Dimension(220, 220));
        jLabelPhoto.setPreferredSize(new java.awt.Dimension(220, 220));
        jLabelPhoto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelPhotoMouseClicked(evt);
            }
        });
        jPanel3.add(jLabelPhoto, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        jLabel1.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("MIDDLE NAME");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jLabel1.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 17, 180, 20));

        jTextFieldFirstname1.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        getContentPane().add(jTextFieldFirstname1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 35, 190, 30));

        jLabel12.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel12.setText("CIVIL STATUS");
        jLabel12.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jLabel12.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 120, 190, -1));

        jTextFieldMiddlename.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        getContentPane().add(jTextFieldMiddlename, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 35, 180, 30));

        jLabel13.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel13.setText("LAST NAME");
        jLabel13.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jLabel13.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 17, 190, 20));

        jTextFieldLastname.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        getContentPane().add(jTextFieldLastname, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 35, 190, 30));

        jLabel14.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel14.setText("FIRST NAME");
        jLabel14.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jLabel14.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 20, 190, -1));

        jComboBoxCourse.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        getContentPane().add(jComboBoxCourse, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 85, 380, 30));

        jLabel15.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel15.setText("GENDER");
        jLabel15.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jLabel15.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 70, 190, -1));

        jComboBoxGender.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jComboBoxGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MALE", "FEMALE" }));
        getContentPane().add(jComboBoxGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 85, 190, 31));

        jLabel16.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel16.setText("COURSE");
        jLabel16.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jLabel16.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 70, 380, -1));

        getContentPane().add(jComboBoxCivilStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 135, 190, 30));

        jTextFieldReligion.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jTextFieldReligion.setText("ROMAN CATHOLIC CHURCH");
        getContentPane().add(jTextFieldReligion, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 135, 380, 30));

        jLabel17.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel17.setText("RELIGION");
        jLabel17.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jLabel17.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 120, 380, -1));

        jLabel18.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel18.setText("ADDRESS");
        jLabel18.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jLabel18.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 220, 190, -1));

        jDateChooserDoB.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        getContentPane().add(jDateChooserDoB, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 185, 190, 30));

        jLabel19.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel19.setText("EMAIL");
        jLabel19.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jLabel19.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 170, 190, -1));

        jTextFieldMobile.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jTextFieldMobile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldMobileActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldMobile, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 185, 180, 30));

        jLabel20.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel20.setText("MOBILE");
        jLabel20.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jLabel20.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        getContentPane().add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 170, 180, -1));

        jTextFieldEmail.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        getContentPane().add(jTextFieldEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 185, 190, 30));

        jLabel21.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel21.setText("DATE OF BIRTH");
        jLabel21.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jLabel21.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        getContentPane().add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 170, 190, -1));

        jTextFieldAddress.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        getContentPane().add(jTextFieldAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 235, 580, 30));

        setSize(new java.awt.Dimension(817, 379));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldMobileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldMobileActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldMobileActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (jButton1.getText().equals("Save")) {
            int response = JOptionPane.showConfirmDialog(mainFrame, "Are you sure to add " + jTextFieldFirstname1.getText() + " " + jTextFieldLastname.getText() + " ?", "Add student confirmation", JOptionPane.YES_NO_OPTION);
            if (response == JOptionPane.YES_OPTION) {
                ComboBoxList courseId = (ComboBoxList) this.jComboBoxCourse.getSelectedItem();
                Course course = new Course(Integer.parseInt(courseId.getId()), courseId.getName(), courseId.getName());
                ComboBoxList civilStatusId = (ComboBoxList) this.jComboBoxCourse.getSelectedItem();
                CivilStatus civilStatus = new CivilStatus(Integer.parseInt(civilStatusId.getId()), civilStatusId.getName());
                Student student;
                if (this.photo == null) {
                    student = new Student(query.createdStudentId(), jTextFieldFirstname1.getText(), jTextFieldMiddlename.getText(), jTextFieldLastname.getText(), course, jComboBoxGender.getSelectedItem().toString(), civilStatus, jTextFieldReligion.getText(), new java.sql.Date(jDateChooserDoB.getDate().getTime()).toString(), jTextFieldMobile.getText(), jTextFieldEmail.getText(), jTextFieldAddress.getText(), new File(System.getProperty("user.dir") + "/src/enrollmentsystem/icons/no photo.jpg"));
                    new AppQuery().addStudent(student, false);
                } else {
                    student = new Student(query.createdStudentId(), jTextFieldFirstname1.getText(), jTextFieldMiddlename.getText(), jTextFieldLastname.getText(), course, jComboBoxGender.getSelectedItem().toString(), civilStatus, jTextFieldReligion.getText(), new java.sql.Date(jDateChooserDoB.getDate().getTime()).toString(), jTextFieldMobile.getText(), jTextFieldEmail.getText(), jTextFieldAddress.getText(), new File(System.getProperty("user.dir") + "/src/enrollmentsystem/icons/model.jpg"));
                    new AppQuery().addStudent(student, true);
                }
                this.dispose();
            }
        } else if (jButton1.getText().equals("Update")) {
            int response = JOptionPane.showConfirmDialog(mainFrame, "Are you sure to update " + jTextFieldFirstname1.getText() + " " + jTextFieldLastname.getText() + " ?", "Add student confirmation", JOptionPane.YES_NO_OPTION);
            if (response == JOptionPane.YES_OPTION) {
                ComboBoxList courseId = (ComboBoxList) this.jComboBoxCourse.getSelectedItem();
                Course course = new Course(Integer.parseInt(courseId.getId()), courseId.getName(), courseId.getName());
                ComboBoxList civilStatusId = (ComboBoxList) this.jComboBoxCivilStatus.getSelectedItem();
                CivilStatus civilStatus = new CivilStatus(Integer.parseInt(civilStatusId.getId()), civilStatusId.getName());
                Student student;
                if (this.photo == null) {
                    student = new Student(this.student.id(), jTextFieldFirstname1.getText(), jTextFieldMiddlename.getText(), jTextFieldLastname.getText(), course, jComboBoxGender.getSelectedItem().toString(),civilStatus, jTextFieldReligion.getText(), new java.sql.Date(jDateChooserDoB.getDate().getTime()).toString(), jTextFieldMobile.getText(), jTextFieldEmail.getText(), jTextFieldAddress.getText(), new File(System.getProperty("user.dir") + "/src/enrollmentsystem/icons/no photo.jpg"));
                    new AppQuery().updateStudent(student, false);
                } else {
                    student = new Student(this.student.id(), jTextFieldFirstname1.getText(), jTextFieldMiddlename.getText(), jTextFieldLastname.getText(), course, jComboBoxGender.getSelectedItem().toString(),civilStatus, jTextFieldReligion.getText(), new java.sql.Date(jDateChooserDoB.getDate().getTime()).toString(), jTextFieldMobile.getText(), jTextFieldEmail.getText(), jTextFieldAddress.getText(), new File(System.getProperty("user.dir") + "/src/enrollmentsystem/icons/model.jpg"));
                    new AppQuery().updateStudent(student, true);
                }
                this.dispose();
            }
        } else if (jButton1.getText().equals("Delete")) {
            int response = JOptionPane.showConfirmDialog(mainFrame, "Are you sure to update " + jTextFieldFirstname1.getText() + " " + jTextFieldLastname.getText() + " ?", "Add student confirmation", JOptionPane.YES_NO_OPTION);
            if (response == JOptionPane.YES_OPTION) {
                new AppQuery().deleteStudent(this.student);
                this.dispose();
            }
    }//GEN-LAST:event_jButton1ActionPerformed
    }
    private void jLabelPhotoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelPhotoMouseClicked

        browse();
    }//GEN-LAST:event_jLabelPhotoMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<Object> jComboBoxCivilStatus;
    private javax.swing.JComboBox<Object> jComboBoxCourse;
    private javax.swing.JComboBox<Object> jComboBoxGender;
    private com.toedter.calendar.JDateChooser jDateChooserDoB;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabelPhoto;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField jTextFieldAddress;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldFirstname1;
    private javax.swing.JTextField jTextFieldLastname;
    private javax.swing.JTextField jTextFieldMiddlename;
    private javax.swing.JTextField jTextFieldMobile;
    private javax.swing.JTextField jTextFieldReligion;
    // End of variables declaration//GEN-END:variables

    private void comboBoxCourse() {
        this.jComboBoxCourse.removeAllItems();
        query.comboBoxCourse();
        for (ComboBoxList a : query.getList()) {
            this.jComboBoxCourse.addItem(a);
        }
    }

    private void comboBoxCivilStatus() {
        this.jComboBoxCivilStatus.removeAllItems();
        query.comboBoxCivilStatus();
        for (ComboBoxList a : query.getList()) {
            this.jComboBoxCivilStatus.addItem(a);
        }
    }

    private void browse() {
        try {
            jFileChooser1.setAccessory(new ImagePreview(jFileChooser1));
            jFileChooser1.setFileFilter(new ImageFilter());
            int returnVal = jFileChooser1.showOpenDialog(this);
            if (returnVal == javax.swing.JFileChooser.APPROVE_OPTION) {
                photo = jFileChooser1.getSelectedFile();

                int IMG_WIDTH = jLabelPhoto.getWidth();
                int IMG_HEIGHT = jLabelPhoto.getHeight();
                jLabelPhoto.setText("");
                try {
                    BufferedImage originalImage = ImageIO.read(photo);
                    int type = originalImage.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : originalImage.getType();

                    BufferedImage resizedImage = new BufferedImage(IMG_WIDTH, IMG_HEIGHT, type);
                    Graphics2D g = resizedImage.createGraphics();
                    g.drawImage(originalImage, 0, 0, IMG_WIDTH, IMG_HEIGHT, null);
                    g.dispose();
                    g.setComposite(AlphaComposite.Src);

                    g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                            RenderingHints.VALUE_INTERPOLATION_BILINEAR);
                    g.setRenderingHint(RenderingHints.KEY_RENDERING,
                            RenderingHints.VALUE_RENDER_QUALITY);
                    g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                            RenderingHints.VALUE_ANTIALIAS_ON);
                    jLabelPhoto.setIcon(new ImageIcon(resizedImage)); //to eliminate .jpeg from picture filename
                    ImageIO.write(resizedImage, "png", new File("src\\enrollmentsystem\\icons\\model.jpg"));

                } catch (final IOException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Opss...", JOptionPane.ERROR_MESSAGE);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void displayPicture(Integer id) {
        try {
            Blob blobImage = (Blob) query.selectedStudentPhoto(id);
            ImageIcon icon = new ImageIcon(blobImage.getBytes(1L, (int) blobImage.length()));

            Image image = icon.getImage();

            int IMG_WIDTH = 220;
            int IMG_HEIGHT = 220;
            int type = BufferedImage.TYPE_INT_ARGB;

            BufferedImage resizedImage = new BufferedImage(IMG_WIDTH, IMG_HEIGHT, type);
            Graphics2D g = resizedImage.createGraphics();
            g.drawImage(image, 0, 0, IMG_WIDTH, IMG_HEIGHT, null);
            g.dispose();
            g.setComposite(AlphaComposite.Src);

            g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                    RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g.setRenderingHint(RenderingHints.KEY_RENDERING,
                    RenderingHints.VALUE_RENDER_QUALITY);
            g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);

            jLabelPhoto.setIcon(new ImageIcon(resizedImage));//image to label

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
