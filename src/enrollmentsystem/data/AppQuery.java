/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enrollmentsystem.data;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Java Programming with Aldrin b cabusog
 */
public class AppQuery {

    DBConnection c = new DBConnection();
    private ArrayList<ComboBoxList> list;

    /**
     * @return the list
     */
    public ArrayList<ComboBoxList> getList() {
        return list;
    }

    /**
     * @param list the list to set
     */
    public void setList(ArrayList<ComboBoxList> list) {
        this.list = list;
    }

    public Integer selectYear() {
        Integer year = null;
        try {
            c.getDBConn();
            PreparedStatement statement = c.getCon().prepareStatement("SELECT YEAR(CURDATE()) AS `year`;");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                year = rs.getInt("year");
            }
            rs.close();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Opss...", JOptionPane.ERROR_MESSAGE);
        }
        return year;
    }

    public Integer selectMaxStudentID() {
        Integer maxId = null;
        try {
            c.getDBConn();
            PreparedStatement statement = c.getCon().prepareStatement("SELECT \n"
                    + "  MAX(`id`) AS maxid\n"
                    + "FROM\n"
                    + "  `student` WHERE deleted =0 ");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                maxId = rs.getInt("maxid");
            }
            rs.close();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Opss...", JOptionPane.ERROR_MESSAGE);
        }
        return maxId;
    }

    public Integer createdStudentId() {
        Integer idGenerated = null;
        try {
            if (selectMaxStudentID() < 1) {
                String firstId = String.valueOf(selectYear()) + "00001";
                idGenerated = Integer.parseInt(firstId);
            } else {
                Integer years = Integer.parseInt(String.valueOf(selectMaxStudentID()).substring(0, 4));
                if (selectYear().equals(years)) {
                    idGenerated = (selectMaxStudentID() + 1);
                } else {
                    String id = String.valueOf(selectYear()) + "00001";
                    idGenerated = Integer.parseInt(id);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Opss...", JOptionPane.ERROR_MESSAGE);
        }
        return idGenerated;
    }

    public Integer selectMaxInstructorId() {
        Integer maxId = null;
        try {
            c.getDBConn();
            PreparedStatement statement = c.getCon().prepareStatement("SELECT \n"
                    + "  MAX(`id`) AS maxid\n"
                    + "FROM\n"
                    + " `instructor` WHERE `deleted` =0");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                maxId = rs.getInt("maxid");
            }
            rs.close();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Opss...", JOptionPane.ERROR_MESSAGE);
        }
        return maxId;
    }

    public Integer createdInstructorId() {
        Integer idGenerated = null;
        try {
            if (selectMaxInstructorId() < 1) {
                String firstId = String.valueOf(selectYear()) + "0001";
                idGenerated = Integer.parseInt(firstId);
            } else {
                Integer years = Integer.parseInt(String.valueOf(selectMaxInstructorId()).substring(0, 4));
                System.out.println("year");
                if (selectYear().equals(years)) {
                    idGenerated = (selectMaxInstructorId() + 1);
                } else {
                    String id = String.valueOf(selectYear()) + "0001";
                    idGenerated = Integer.parseInt(id);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Opss...", JOptionPane.ERROR_MESSAGE);
        }
        return idGenerated;
    }

    public static void main(String[] args) {
        AppQuery aq = new AppQuery();
//        String x=String.valueOf(aq.selectMaxStudentID()).substring(0, 4);
//        System.out.println("currentYear"+x+1);
//        System.out.println("equalYear:"+(aq.selectMaxStudentID() + 1));
        String years = String.valueOf(aq.selectMaxStudentID()).substring(0, 4);
        Integer yeari = aq.selectYear();
        System.out.println("years:" + years);
        System.out.println("yeari:" + aq.selectYear());
        System.out.println("xxx:" + aq.createdStudentId());
    }

    public void addCourse(enrollmentsystem.records.Course course) {
        try {
            c.getDBConn();
            java.sql.PreparedStatement ps = c.getCon().prepareStatement("INSERT INTO `course` (`course`,\n"
                    + "  `acronym`\n"
                    + ") \n"
                    + "VALUES\n"
                    + "  (?,?) ;");
            ps.setString(1, course.course());
            ps.setString(2, course.acronym());
            ps.execute();
            ps.close();
            c.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateCourse(enrollmentsystem.records.Course course) {
        try {
            c.getDBConn();
            java.sql.PreparedStatement ps = c.getCon().prepareStatement("UPDATE \n"
                    + "  `course` \n"
                    + "SET  \n"
                    + "  `course` =?,\n"
                    + "  `acronym` = ? \n"
                    + "WHERE `id` = ? ;");
            ps.setString(1, course.course());
            ps.setString(2, course.acronym());
            ps.setInt(3, course.id());
            ps.execute();
            ps.close();
            c.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteCourse(enrollmentsystem.records.Course course) {
        try {
            c.getDBConn();
            java.sql.PreparedStatement ps = c.getCon().prepareStatement("UPDATE \n"
                    + "  `course` \n"
                    + "SET  \n"
                    + "  `deleted` = 1 \n"
                    + "WHERE `id` = ? ;");
            ps.setInt(1, course.id());
            ps.execute();
            ps.close();
            c.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<enrollmentsystem.records.Course> getCourse() {
        List<enrollmentsystem.records.Course> list = new ArrayList<>();
        try {
            String query = "SELECT \n"
                    + "  `id`,\n"
                    + "  `course`,\n"
                    + "  `acronym` \n"
                    + "FROM `course` WHERE `deleted` =0 ORDER BY `acronym` ASC;";
            c.getDBConn();
            Statement st = c.getCon().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                enrollmentsystem.records.Course s = new enrollmentsystem.records.Course(rs.getInt("id"), rs.getString("course"), rs.getString("acronym"));
                list.add(s);
            }
            rs.close();
            st.close();
            c.closeConnection();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public void comboBoxCourse() {
        this.setList(new ArrayList<ComboBoxList>());
        try {
            c.getDBConn();
            PreparedStatement statement;
            ResultSet rs;
            statement = c.getCon().prepareStatement("SELECT \n"
                    + "  `id`,\n"
                    + "  `course`,\n"
                    + "  `acronym`\n"
                    + "FROM `course` WHERE deleted =0 ORDER BY course ASC");
            rs = statement.executeQuery();
            while (rs.next()) {
                String idl = rs.getString("id");
                String namel = rs.getString("course");

                // Process data here
                this.getList().add(new ComboBoxList(idl, namel));
            }

            rs.close();
            statement.close();
            c.closeConnection();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void addCourseMajor(enrollmentsystem.records.CourseMajor course) {
        try {
            c.getDBConn();
            java.sql.PreparedStatement ps = c.getCon().prepareStatement("INSERT INTO `course_major` (\n"
                    + "  `major`,\n"
                    + "  `course_id`\n"
                    + ") \n"
                    + "VALUES\n"
                    + "  (?,?)");
            ps.setString(1, course.major());
            ps.setInt(2, course.course().id());
            ps.execute();
            ps.close();
            c.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateCourseMajor(enrollmentsystem.records.CourseMajor cm) {
        try {
            c.getDBConn();

            java.sql.PreparedStatement ps = c.getCon().prepareStatement("UPDATE \n"
                    + "  `course_major` \n"
                    + "SET \n"
                    + "  `major` = ?,\n"
                    + "  `course_id` =?\n"
                    + "WHERE `id` = ? ;");
            ps.setString(1, cm.major());
            ps.setInt(2, cm.course().id());
            ps.setInt(3, cm.id());
            ps.execute();
            ps.close();
            c.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteCourseMajor(enrollmentsystem.records.CourseMajor course) {
        try {
            c.getDBConn();
            java.sql.PreparedStatement ps = c.getCon().prepareStatement("UPDATE \n"
                    + "  `course_major` \n"
                    + "SET  \n"
                    + "  `deleted` = 1 \n"
                    + "WHERE `id` = ? ;");
            ps.setInt(1, course.id());
            ps.execute();
            ps.close();
            c.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<enrollmentsystem.records.CourseMajor> getCourseMajor() {
        List<enrollmentsystem.records.CourseMajor> list = new ArrayList<>();
        try {

            String query = "SELECT\n"
                    + "    `course_major`.`id`\n"
                    + "    , `course`.`id` as course_id\n"
                    + "    , `course`.`course`\n"
                    + "    , `course`.`acronym`\n"
                    + "    , `course_major`.`major`\n"
                    + "\n"
                    + "FROM  `course`\n"
                    + "     LEFT JOIN `course_major`\n"
                    + "     ON (`course`.`id` = `course_major`.`course_id`) WHERE `course`.`deleted` =0  ORDER BY `course`.`course` ASC";
            c.getDBConn();
            Statement st = c.getCon().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                enrollmentsystem.records.Course course = new enrollmentsystem.records.Course(rs.getInt("course_id"), rs.getString("course"), rs.getString("acronym"));
                enrollmentsystem.records.CourseMajor s = new enrollmentsystem.records.CourseMajor(rs.getInt("id"), course, rs.getString("major"));
                list.add(s);
            }
            rs.close();
            st.close();
            c.closeConnection();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public void addRole(enrollmentsystem.records.Role role) {
        try {

            c.getDBConn();
            java.sql.PreparedStatement ps = c.getCon().prepareStatement("INSERT INTO `role` (\n"
                    + "  `role`,\n"
                    + "  `m_user`,\n"
                    + "  `m_register`,\n"
                    + "  `m_class_offer`\n"
                    + ") \n"
                    + "VALUES\n"
                    + "  (?,?,?,?) ;");
            ps.setString(1, role.role());
            ps.setBoolean(2, role.mUser());
            ps.setBoolean(3, role.mRegister());
            ps.setBoolean(4, role.mSubjectOffer());
            ps.execute();
            ps.close();
            c.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateRole(enrollmentsystem.records.Role role) {
        try {
            c.getDBConn();
            java.sql.PreparedStatement ps = c.getCon().prepareStatement("UPDATE \n"
                    + "  `role` \n"
                    + "SET \n"
                    + "  `role` = ?,\n"
                    + "  `m_user` = ?,\n"
                    + "  `m_register` = ?,\n"
                    + "  `m_class_offer` = ?\n"
                    + "WHERE `id` = ? ;");
            ps.setString(1, role.role());
            ps.setBoolean(2, role.mUser());
            ps.setBoolean(3, role.mRegister());
            ps.setBoolean(4, role.mSubjectOffer());
            ps.setInt(5, role.id());
            ps.execute();
            ps.close();
            c.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteRole(enrollmentsystem.records.Role role) {
        try {
            c.getDBConn();
            java.sql.PreparedStatement ps = c.getCon().prepareStatement("UPDATE \n"
                    + "  `role` \n"
                    + "SET  \n"
                    + "  `deleted` = 1 \n"
                    + "WHERE `id` = ? ;");
            ps.setInt(1, role.id());
            ps.execute();
            ps.close();
            c.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<enrollmentsystem.records.Role> getRole() {
        List<enrollmentsystem.records.Role> list = new ArrayList<>();
        try {
            String query = "SELECT \n"
                    + "  `id`,\n"
                    + "  `role`,\n"
                    + "  `m_user`,\n"
                    + "  `m_register`,\n"
                    + "  `m_class_offer` \n"
                    + "FROM\n"
                    + "  `role` WHERE deleted =0 ORDER BY `m_user` AND `m_register` AND `m_class_offer` DESC;";
            c.getDBConn();
            Statement st = c.getCon().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                enrollmentsystem.records.Role s = new enrollmentsystem.records.Role(rs.getInt("id"), rs.getString("role"), rs.getBoolean("m_user"), rs.getBoolean("m_register"), rs.getBoolean("m_class_offer"));
                list.add(s);
            }
            rs.close();
            st.close();
            c.closeConnection();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public void comboBoxRole() {
        this.setList(new ArrayList<ComboBoxList>());
        try {
            c.getDBConn();
            PreparedStatement statement;
            ResultSet rs;
            statement = c.getCon().prepareStatement("SELECT \n"
                    + "  `id`,\n"
                    + "  `role`,\n"
                    + "  `m_user`,\n"
                    + "  `m_register`,\n"
                    + "  `m_class_offer` \n"
                    + "FROM\n"
                    + "  `role` WHERE deleted =0 ORDER BY `m_user` AND `m_register` AND `m_class_offer` DESC; ");
            rs = statement.executeQuery();
            while (rs.next()) {
                String idl = rs.getString("id");
                String rolel = rs.getString("role");

                // Process data here
                this.getList().add(new ComboBoxList(idl, rolel));
            }

            rs.close();
            statement.close();
            c.closeConnection();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void addUser(enrollmentsystem.records.User user) {
        try {
            c.getDBConn();
            java.sql.PreparedStatement ps = c.getCon().prepareStatement("INSERT INTO `user_account` (\n"
                    + "  `firstname`,\n"
                    + "  `middlename`,\n"
                    + "  `lastname`,\n"
                    + "  `username`,\n"
                    + "  `password`,\n"
                    + "  `role_id`\n"
                    + ") \n"
                    + "VALUES\n"
                    + "  (?,?,?,?,?,?) ;");
            ps.setString(1, user.firstname());
            ps.setString(2, user.middlename());
            ps.setString(3, user.lastname());
            ps.setString(4, user.username());
            ps.setString(5, user.password());
            ps.setInt(6, user.role().id());
            ps.execute();
            ps.close();
            c.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateUser(enrollmentsystem.records.User user) {
        try {
            c.getDBConn();
            java.sql.PreparedStatement ps = c.getCon().prepareStatement("UPDATE \n"
                    + "  `user_account` \n"
                    + "SET \n"
                    + "  `firstname` = ?,\n"
                    + "  `middlename` =?,\n"
                    + "  `lastname` = ?,\n"
                    + "  `username` = ?,\n"
                    + "  `password` = ?,\n"
                    + "  `role_id` = ? \n"
                    + "WHERE `id` = ? ;");
            ps.setString(1, user.firstname());
            ps.setString(2, user.middlename());
            ps.setString(3, user.lastname());
            ps.setString(4, user.username());
            ps.setString(5, user.password());
            ps.setInt(6, user.role().id());
            ps.setInt(7, user.id());
            ps.execute();
            ps.close();
            c.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(enrollmentsystem.records.User user) {
        try {
            c.getDBConn();
            java.sql.PreparedStatement ps = c.getCon().prepareStatement("UPDATE \n"
                    + "  `user_account` \n"
                    + "SET  \n"
                    + "  `deleted` = 1 \n"
                    + "WHERE `id` = ? ;");
            ps.setInt(1, user.id());
            ps.execute();
            ps.close();
            c.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<enrollmentsystem.records.User> getUser() {
        List<enrollmentsystem.records.User> list = new ArrayList<>();
        try {

            String query = "SELECT\n"
                    + "    `user_account`.`id`\n"
                    + "    , `user_account`.`firstname`\n"
                    + "    , `user_account`.`middlename`\n"
                    + "    , `user_account`.`lastname`\n"
                    + "    , `user_account`.`username`\n"
                    + "    , `user_account`.`password`\n"
                    + "    , `user_account`.`role_id`\n"
                    + "    , `role`.`role`\n"
                    + "    , `role`.`m_user`\n"
                    + "    , `role`.`m_register`\n"
                    + "    , `role`.`m_class_offer`\n"
                    + "FROM\n"
                    + "    `iregister`.`user_account`\n"
                    + "    INNER JOIN `iregister`.`role` \n"
                    + "        ON (`user_account`.`role_id` = `role`.`id`) WHERE `user_account`.`deleted` =0 ORDER BY `user_account`.`lastname` ASC ; ";
            c.getDBConn();
            Statement st = c.getCon().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                enrollmentsystem.records.Role role = new enrollmentsystem.records.Role(rs.getInt("role_id"), rs.getString("role"), rs.getBoolean("m_user"), rs.getBoolean("m_register"), rs.getBoolean("m_class_offer"));
                enrollmentsystem.records.User s = new enrollmentsystem.records.User(rs.getInt("id"), rs.getString("firstname"), rs.getString("middlename"), rs.getString("lastname"), rs.getString("username"), rs.getString("password"), role);
                list.add(s);
            }
            rs.close();
            st.close();
            c.closeConnection();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public void addStudent(enrollmentsystem.records.Student student, boolean hasPhoto) {
        FileInputStream fis = null;
        try {
            c.getDBConn();
            fis = new FileInputStream(student.photo());
            java.sql.PreparedStatement ps = null;
            if (hasPhoto == true) {
                ps = c.getCon().prepareStatement("INSERT INTO `student` (\n"
                        + "  `firstname`,\n"
                        + "  `middlename`,\n"
                        + "  `lastname`,\n"
                        + "  `course_id`,\n"
                        + "  `gender`,\n"
                        + "  `dateOfBirth`,\n"
                        + "  `mobile`,\n"
                        + "  `email`,\n"
                        + "  `address`,\n"
                        + "  `photo`,`id` ,`civil_status_id`,`religion` \n"
                        + ") \n"
                        + "VALUES\n"
                        + "  (?,?,?,?,?,?,?,?,?,?,?,?,?) ;");
                ps.setString(1, student.firstname());
                ps.setString(2, student.middlename());
                ps.setString(3, student.lastname());
                ps.setInt(4, student.course().id());
                ps.setString(5, student.gender());
                ps.setString(6, student.dateOfBirth());
                ps.setString(7, student.mobileNo());
                ps.setString(8, student.email());
                ps.setString(9, student.address());
                ps.setBlob(10, fis, (int) student.photo().length());
                ps.setInt(11, student.id());
                ps.setInt(12, student.civilStatus().id());
                ps.setString(13, student.religion());
            } else {
                ps = c.getCon().prepareStatement("INSERT INTO `student` (\n"
                        + "  `id`,`firstname`,\n"
                        + "  `middlename`,\n"
                        + "  `lastname`,\n"
                        + "  `course_id`,\n"
                        + "  `gender`,\n"
                        + "  `dateOfBirth`,\n"
                        + "  `mobile`,\n"
                        + "  `email`,\n"
                        + "  `address`,`civil_status_id`,`religion` \n"
                        + ") \n"
                        + "VALUES\n"
                        + "  (?,?,?,?,?,?,?,?,?,?,?,?) ;");
                ps.setInt(1, student.id());
                ps.setString(2, student.firstname());
                ps.setString(3, student.middlename());
                ps.setString(4, student.lastname());
                ps.setInt(5, student.course().id());
                ps.setString(6, student.gender());
                ps.setString(7, student.dateOfBirth());
                ps.setString(8, student.mobileNo());
                ps.setString(9, student.email());
                ps.setString(10, student.address());
                ps.setInt(11, student.civilStatus().id());
                ps.setString(12, student.religion());
            }

            ps.execute();
            ps.close();
            c.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateStudent(enrollmentsystem.records.Student student, boolean hasPhoto) {
        FileInputStream fis = null;
        try {
            c.getDBConn();
            fis = new FileInputStream(student.photo());
            java.sql.PreparedStatement ps = null;
            if (hasPhoto == true) {
                ps = c.getCon().prepareStatement("UPDATE \n"
                        + "  `student` \n"
                        + "SET\n"
                        + "  `firstname` = ?,\n"
                        + "  `middlename` = ?,\n"
                        + "  `lastname` = ?,\n"
                        + "  `course_id` = ?,\n"
                        + "  `gender` = ?,\n"
                        + "  `dateOfBirth` = ?,\n"
                        + "  `mobile` = ?,\n"
                        + "  `email` = ?,\n"
                        + "  `address` = ?,`civil_status_id` =?,`religion` =?,\n"
                        + "  `photo` = ? \n"
                        + " WHERE `id` = ? ");
                ps.setString(1, student.firstname());
                ps.setString(2, student.middlename());
                ps.setString(3, student.lastname());
                ps.setInt(4, student.course().id());
                ps.setString(5, student.gender());
                ps.setString(6, student.dateOfBirth());
                ps.setString(7, student.mobileNo());
                ps.setString(8, student.email());
                ps.setString(9, student.address());
                ps.setInt(10, student.civilStatus().id());
                ps.setString(11, student.religion());
                ps.setBlob(12, fis, (int) student.photo().length());
                ps.setInt(13, student.id());
                ps.execute();
                ps.close();
            } else {
                ps = c.getCon().prepareStatement("UPDATE \n"
                        + "  `student` \n"
                        + "SET\n"
                        + "  `firstname` = ?,\n"
                        + "  `middlename` = ?,\n"
                        + "  `lastname` = ?,\n"
                        + "  `course_id` = ?,\n"
                        + "  `gender` = ?,\n"
                        + "  `dateOfBirth` = ?,\n"
                        + "  `mobile` = ?,\n"
                        + "  `email` = ?,\n"
                        + "  `address` = ? , `civil_status_id` =?, `religion` =? \n"
                        + " WHERE `id` = ? ");
                ps.setString(1, student.firstname());
                ps.setString(2, student.middlename());
                ps.setString(3, student.lastname());
                ps.setInt(4, student.course().id());
                ps.setString(5, student.gender());
                ps.setString(6, student.dateOfBirth());
                ps.setString(7, student.mobileNo());
                ps.setString(8, student.email());
                ps.setString(9, student.address());
                ps.setInt(10, student.civilStatus().id());
                ps.setString(11, student.religion());
                ps.setInt(12, student.id());
                ps.execute();
                ps.close();
            }

            c.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteStudent(enrollmentsystem.records.Student user) {
        try {
            c.getDBConn();
            java.sql.PreparedStatement ps = c.getCon().prepareStatement("UPDATE \n"
                    + "  `student` \n"
                    + "SET  \n"
                    + "  `deleted` = 1 \n"
                    + "WHERE `id` = ? ;");
            ps.setInt(1, user.id());
            ps.execute();
            ps.close();
            c.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<enrollmentsystem.records.Student> getStudent() {
        List<enrollmentsystem.records.Student> list = new ArrayList<>();
        try {

            String query = "SELECT\n"
                    + "     `student`.`id`\n"
                    + "    ,`student`.`firstname`\n"
                    + "    , `student`.`middlename`\n"
                    + "    , `student`.`lastname`\n"
                    + "    , `student`.`course_id`\n"
                    + "    , `student`.`gender`\n"
                    + "    , `student`.`civil_status_id`\n"
                    + "    , `civil_status`.`civil_status`\n"
                    + "    , `student`.`dateOfBirth`\n"
                    + "    , `student`.`mobile`\n"
                    + "    , `student`.`email`\n"
                    + "    , `student`.`address`\n"
                    + "    , `course`.`course`\n"
                    + "    , `course`.`acronym`,`student`.`religion`\n"
                    + "FROM\n"
                    + "    `student`\n"
                    + "    INNER JOIN `civil_status` \n"
                    + "        ON (`student`.`civil_status_id` = `civil_status`.`id`)\n"
                    + "    INNER JOIN `course` \n"
                    + "        ON (`student`.`course_id` = `course`.`id`) WHERE `student`.`deleted` =0 ORDER BY `student`.`lastname` ASC ;";
            c.getDBConn();
            Statement st = c.getCon().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                enrollmentsystem.records.CivilStatus civilStatus = new enrollmentsystem.records.CivilStatus(rs.getInt("civil_status_id"), rs.getString("civil_status"));
                enrollmentsystem.records.Course course = new enrollmentsystem.records.Course(rs.getInt("course_id"), rs.getString("course"), rs.getString("acronym"));
                enrollmentsystem.records.Student student = new enrollmentsystem.records.Student(rs.getInt("id"), rs.getString("firstname"), rs.getString("middlename"), rs.getString("lastname"), course, rs.getString("gender"), civilStatus, rs.getString("religion"), rs.getString("dateOfBirth"), rs.getString("mobile"), rs.getString("email"), rs.getString("address"), null);
                list.add(student);
            }
            rs.close();
            st.close();
            c.closeConnection();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public void comboBoxStudentId() {
        this.setList(new ArrayList<ComboBoxList>());
        try {

            c.getDBConn();
            PreparedStatement statement;
            ResultSet rs;
            statement = c.getCon().prepareStatement("SELECT \n"
                    + "  `id`\n"
                    + "FROM\n"
                    + "  `student` WHERE `deleted`=0 ORDER BY id ASC;");
            rs = statement.executeQuery();
            while (rs.next()) {
                String idl = rs.getString("id");
                String codel = rs.getString("id");

                // Process data here
                this.getList().add(new ComboBoxList(idl, codel));
            }

            rs.close();
            statement.close();
            c.closeConnection();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public Blob selectedStudentPhoto(Integer id) {
        Blob photo = null;
        try {
            c.getDBConn();
            PreparedStatement statement = c.getCon().prepareStatement("SELECT  photo FROM student  where id  =" + id + "");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                photo = rs.getBlob("photo");
            }
            rs.close();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Opss...", JOptionPane.ERROR_MESSAGE);
        }
        return photo;
    }

    public void addInstructor(enrollmentsystem.records.Instructor instructor, boolean hasPhoto) {
        FileInputStream fis = null;
        try {
            c.getDBConn();
            fis = new FileInputStream(instructor.photo());
            java.sql.PreparedStatement ps = null;
            if (hasPhoto == true) {
                ps = c.getCon().prepareStatement("INSERT INTO `instructor` (\n"
                        + "  `id`,`firstname`,\n"
                        + "  `middlename`,\n"
                        + "  `lastname`,\n"
                        + "  `gender`,"
                        + "  `civil_status_id`,\n"
                        + "  `dateOfBirth`,\n"
                        + "  `mobile`,\n"
                        + "  `email`,\n"
                        + "  `address`,\n"
                        + "  `photo`\n"
                        + ") \n"
                        + "VALUES\n"
                        + "  (?,?,?,?,?,?,?,?,?,?,?) ;");
                ps.setInt(1, instructor.id());
                ps.setString(2, instructor.firstname());
                ps.setString(3, instructor.middlename());
                ps.setString(4, instructor.lastname());
                ps.setString(5, instructor.gender());
                ps.setInt(6, instructor.civilStatus().id());
                ps.setString(7, instructor.dateOfBirth());
                ps.setString(8, instructor.mobileNo());
                ps.setString(9, instructor.email());
                ps.setString(10, instructor.address());
                ps.setBlob(11, fis, (int) instructor.photo().length());
            } else {
                ps = c.getCon().prepareStatement("INSERT INTO `instructor` (\n"
                        + "  `id`,`firstname`,\n"
                        + "  `middlename`,\n"
                        + "  `lastname`,\n"
                        + "  `gender`,\n"
                        + "  `civil_status_id`,\n"
                        + "  `dateOfBirth`,\n"
                        + "  `mobile`,\n"
                        + "  `email`,\n"
                        + "  `address`\n"
                        + ") \n"
                        + "VALUES\n"
                        + "  (?,?,?,?,?,?,?,?,?,?) ;");
                ps.setInt(1, instructor.id());
                ps.setString(2, instructor.firstname());
                ps.setString(3, instructor.middlename());
                ps.setString(4, instructor.lastname());
                ps.setString(5, instructor.gender());
                ps.setInt(6, instructor.civilStatus().id());
                ps.setString(7, instructor.dateOfBirth());
                ps.setString(8, instructor.mobileNo());
                ps.setString(9, instructor.email());
                ps.setString(10, instructor.address());
            }

            ps.execute();
            ps.close();
            c.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateInstructor(enrollmentsystem.records.Instructor instructor, boolean hasPhoto) {
        FileInputStream fis = null;
        try {
            c.getDBConn();
            fis = new FileInputStream(instructor.photo());
            java.sql.PreparedStatement ps = null;
            if (hasPhoto == true) {
                ps = c.getCon().prepareStatement("UPDATE \n"
                        + "  `instructor` \n"
                        + "SET \n"
                        + "  `firstname` = ?,\n"
                        + "  `middlename` = ?,\n"
                        + "  `lastname` = ?,\n"
                        + "  `gender` = ?,\n"
                        + "  `civil_status_id` =?,\n"
                        + "  `dateOfBirth` = ?,\n"
                        + "  `mobile` = ?,\n"
                        + "  `email` = ?,\n"
                        + "  `address` = ?,\n"
                        + "  `photo` = ?\n"
                        + "WHERE `id` = ? ;");
                ps.setString(1, instructor.firstname());
                ps.setString(2, instructor.middlename());
                ps.setString(3, instructor.lastname());
                ps.setString(4, instructor.gender());
                ps.setInt(5, instructor.civilStatus().id());
                ps.setString(6, instructor.dateOfBirth());
                ps.setString(7, instructor.mobileNo());
                ps.setString(8, instructor.email());
                ps.setString(9, instructor.address());
                ps.setBlob(10, fis, (int) instructor.photo().length());
                ps.setInt(11, instructor.id());
                ps.execute();
                ps.close();
            } else {
                ps = c.getCon().prepareStatement("UPDATE \n"
                        + "  `instructor` \n"
                        + "SET \n"
                        + "  `firstname` = ?,\n"
                        + "  `middlename` = ?,\n"
                        + "  `lastname` = ?,\n"
                        + "  `gender` = ?,\n"
                        + "  `civil_status_id` =?,\n"
                        + "  `dateOfBirth` = ?,\n"
                        + "  `mobile` = ?,\n"
                        + "  `email` = ?,\n"
                        + "  `address` = ? \n"
                        + "WHERE `id` = ? ;");
                ps.setString(1, instructor.firstname());
                ps.setString(2, instructor.middlename());
                ps.setString(3, instructor.lastname());
                ps.setString(4, instructor.gender());
                ps.setInt(5, instructor.civilStatus().id());
                ps.setString(6, instructor.dateOfBirth());
                ps.setString(7, instructor.mobileNo());
                ps.setString(8, instructor.email());
                ps.setString(9, instructor.address());
                ps.setInt(10, instructor.id());
                ps.execute();
                ps.close();
            }

            c.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteInstructor(enrollmentsystem.records.Instructor instructor) {
        try {
            c.getDBConn();
            java.sql.PreparedStatement ps = c.getCon().prepareStatement("UPDATE \n"
                    + "  `instructor` \n"
                    + "SET  \n"
                    + "  `deleted` = 1 \n"
                    + "WHERE `id` = ? ;");
            ps.setInt(1, instructor.id());
            ps.execute();
            ps.close();
            c.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<enrollmentsystem.records.Instructor> getInstructor() {
        List<enrollmentsystem.records.Instructor> list = new ArrayList<>();
        try {

            String query = "SELECT \n"
                    + "  `instructor`.`id`,\n"
                    + "  `instructor`.`firstname`,\n"
                    + "  `instructor`.`middlename`,\n"
                    + "  `instructor`.`lastname`,\n"
                    + "  `instructor`.`gender`,\n"
                    + "  `instructor`.`civil_status_id`,\n"
                    + "  `instructor`.`dateOfBirth`,\n"
                    + "  `instructor`.`mobile`,\n"
                    + "  `instructor`.`email`,\n"
                    + "  `instructor`.`address` , `civil_status`.`civil_status` \n"
                    + " FROM\n"
                    + "    `instructor`\n"
                    + "    INNER JOIN `civil_status` \n"
                    + "        ON (`instructor`.`civil_status_id` = `civil_status`.`id`) WHERE `instructor`.`deleted` =0 ORDER BY `lastname` ASC;";
            c.getDBConn();
            Statement st = c.getCon().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                enrollmentsystem.records.CivilStatus civilStatus = new enrollmentsystem.records.CivilStatus(rs.getInt("civil_status_id"), rs.getString("civil_status"));
                enrollmentsystem.records.Instructor instructor = new enrollmentsystem.records.Instructor(rs.getInt("id"), rs.getString("firstname"), rs.getString("middlename"), rs.getString("lastname"), rs.getString("gender"), civilStatus, rs.getString("dateOfBirth"), rs.getString("mobile"), rs.getString("email"), rs.getString("address"), null);
                list.add(instructor);
            }
            rs.close();
            st.close();
            c.closeConnection();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public Blob selectedInstructorPhoto(Integer id) {
        Blob photo = null;
        try {
            c.getDBConn();
            PreparedStatement statement = c.getCon().prepareStatement("SELECT  photo FROM instructor  where id  =" + id + "");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                photo = rs.getBlob("photo");
            }
            rs.close();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Opss...", JOptionPane.ERROR_MESSAGE);
        }
        return photo;
    }

    public void comboBoxInstructor() {
        this.setList(new ArrayList<ComboBoxList>());
        try {
            c.getDBConn();
            PreparedStatement statement;
            ResultSet rs;
            statement = c.getCon().prepareStatement("SELECT \n"
                    + "  `id`,\n"
                    + "  `firstname`,\n"
                    + "  `middlename`,\n"
                    + "  `lastname`\n"
                    + "FROM\n"
                    + "  `instructor` WHERE deleted =0 ORDER BY lastname ASC;");
            rs = statement.executeQuery();
            while (rs.next()) {
                String idl = rs.getString("id");
                String firstnamel = rs.getString("firstname");
                String middlenamel = rs.getString("middlename");
                String lastnamel = rs.getString("lastname");
                String name = lastnamel + ", " + firstnamel + " " + middlenamel.substring(0, 1) + ".";

                // Process data here
                this.getList().add(new ComboBoxList(idl, name));
            }

            rs.close();
            statement.close();
            c.closeConnection();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void addCivilStatus(enrollmentsystem.records.CivilStatus civilStatus) {
        try {
            System.out.println("cs:" + civilStatus.civilStatus());
            c.getDBConn();
            java.sql.PreparedStatement ps = c.getCon().prepareStatement("INSERT INTO `civil_status` (`civil_status`) VALUES (?) ;");
            ps.setString(1, civilStatus.civilStatus());
            ps.execute();
            ps.close();
            c.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateCivilStatus(enrollmentsystem.records.CivilStatus civilStatus) {
        try {
            c.getDBConn();
            java.sql.PreparedStatement ps = c.getCon().prepareStatement(" UPDATE \n"
                    + "  `civil_status`  \n"
                    + "SET  \n"
                    + "  `civil_status` = ?  \n"
                    + "WHERE `id` = ?;");
            ps.setString(1, civilStatus.civilStatus());
            ps.setInt(2, civilStatus.id());
            ps.execute();
            ps.close();
            c.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteCivilStatus(enrollmentsystem.records.CivilStatus civilStatus) {
        try {
            c.getDBConn();
            java.sql.PreparedStatement ps = c.getCon().prepareStatement("UPDATE \n"
                    + "  `civil_status` \n"
                    + "SET  \n"
                    + "  `deleted` = 1 \n"
                    + "WHERE `id` = ? ;");
            ps.setInt(1, civilStatus.id());
            ps.execute();
            ps.close();
            c.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<enrollmentsystem.records.CivilStatus> getCivilStatus() {
        List<enrollmentsystem.records.CivilStatus> list = new ArrayList<>();
        try {
            String query = "SELECT \n"
                    + "  `id`,\n"
                    + "  `civil_status` \n"
                    + "FROM\n"
                    + "  `civil_status` where `deleted`=0 ORDER BY `id` ASC";
            c.getDBConn();
            Statement st = c.getCon().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                enrollmentsystem.records.CivilStatus c = new enrollmentsystem.records.CivilStatus(rs.getInt("id"), rs.getString("civil_status"));
                list.add(c);
            }
            rs.close();
            st.close();
            c.closeConnection();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public void comboBoxCivilStatus() {
        this.setList(new ArrayList<ComboBoxList>());
        try {
            c.getDBConn();
            PreparedStatement statement;
            ResultSet rs;
            statement = c.getCon().prepareStatement("SELECT \n"
                    + "  `id`,\n"
                    + "  `civil_status` \n"
                    + "FROM\n"
                    + "  `civil_status` where `deleted`=0  ORDER BY `id` ASC");
            rs = statement.executeQuery();
            while (rs.next()) {
                String idl = rs.getString("id");
                String namel = rs.getString("civil_status");

                // Process data here
                this.getList().add(new ComboBoxList(idl, namel));
            }

            rs.close();
            statement.close();
            c.closeConnection();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void addRoom(enrollmentsystem.records.Room room) {
        try {
            c.getDBConn();
            java.sql.PreparedStatement ps = c.getCon().prepareStatement("INSERT INTO `room` ( `room`, `location`) VALUES (?,?) ;");
            ps.setString(1, room.room());
            ps.setString(2, room.location());
            ps.execute();
            ps.close();
            c.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateRoom(enrollmentsystem.records.Room course) {
        try {
            c.getDBConn();
            java.sql.PreparedStatement ps = c.getCon().prepareStatement("UPDATE \n"
                    + "  `room` \n"
                    + "SET  \n"
                    + "  `room` = ?,\n"
                    + "  `location` = ?\n"
                    + "  WHERE `id` = ? ;");
            ps.setString(1, course.room());
            ps.setString(2, course.location());
            ps.setInt(3, course.id());
            ps.execute();
            ps.close();
            c.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteRoom(enrollmentsystem.records.Room room) {
        try {
            c.getDBConn();
            java.sql.PreparedStatement ps = c.getCon().prepareStatement("UPDATE \n"
                    + "  `room` \n"
                    + "SET  \n"
                    + "  `deleted` = 1 \n"
                    + "WHERE `id` = ? ;");
            ps.setInt(1, room.id());
            ps.execute();
            ps.close();
            c.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<enrollmentsystem.records.Room> getRooms() {
        List<enrollmentsystem.records.Room> list = new ArrayList<>();
        try {
            String query = "SELECT \n"
                    + "  `id`,\n"
                    + "  `room`,\n"
                    + "  `location`\n"
                    + "FROM\n"
                    + "  `room` WHERE `deleted` =0  ORDER BY room ASC; ";
            c.getDBConn();
            Statement st = c.getCon().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                enrollmentsystem.records.Room s = new enrollmentsystem.records.Room(rs.getInt("id"), rs.getString("room"), rs.getString("location"));
                list.add(s);
            }
            rs.close();
            st.close();
            c.closeConnection();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public void comboBoxRoom() {
        this.setList(new ArrayList<ComboBoxList>());
        try {
            c.getDBConn();
            PreparedStatement statement;
            ResultSet rs;
            statement = c.getCon().prepareStatement("SELECT \n"
                    + "  `id`,\n"
                    + "  `room`,\n"
                    + "  `location`\n"
                    + "FROM\n"
                    + "  `room` WHERE `deleted` =0  ORDER BY room ASC; ");
            rs = statement.executeQuery();
            while (rs.next()) {
                String idl = rs.getString("id");
                String rooml = rs.getString("room");
                String locationl = rs.getString("room");

                // Process data here
                this.getList().add(new ComboBoxList(idl, rooml + "(" + locationl + ")"));
            }

            rs.close();
            statement.close();
            c.closeConnection();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void addDay(enrollmentsystem.records.Day day) {
        try {
            c.getDBConn();
            java.sql.PreparedStatement ps = c.getCon().prepareStatement("INSERT INTO `day` (\n"
                    + "  `day`,\n"
                    + "  `description`\n"
                    + ") \n"
                    + "VALUES(?,?) ;");
            ps.setString(1, day.day());
            ps.setString(2, day.description());
            ps.execute();
            ps.close();
            c.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateDay(enrollmentsystem.records.Day day) {
        try {
            c.getDBConn();
            java.sql.PreparedStatement ps = c.getCon().prepareStatement("UPDATE \n"
                    + "  `room` \n"
                    + "SET  \n"
                    + "  `room` = ?,\n"
                    + "  `location` = ?\n"
                    + "  WHERE `id` = ? ;");
            ps.setString(1, day.day());
            ps.setString(2, day.description());
            ps.setInt(3, day.id());
            ps.execute();
            ps.close();
            c.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteDay(enrollmentsystem.records.Day day) {
        try {
            c.getDBConn();
            java.sql.PreparedStatement ps = c.getCon().prepareStatement("UPDATE \n"
                    + "  `day` \n"
                    + "SET  \n"
                    + "  `deleted` = 1 \n"
                    + "WHERE `id` = ? ;");
            ps.setInt(1, day.id());
            ps.execute();
            ps.close();
            c.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<enrollmentsystem.records.Day> getDay() {
        List<enrollmentsystem.records.Day> list = new ArrayList<>();
        try {
            String query = "SELECT \n"
                    + "  `id`,\n"
                    + "  `day`,\n"
                    + "  `description`\n"
                    + "FROM\n"
                    + "  `iregister`.`day` WHERE `deleted` =0 ORDER BY DAY ASC;";
            c.getDBConn();
            Statement st = c.getCon().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                enrollmentsystem.records.Day s = new enrollmentsystem.records.Day(rs.getInt("id"), rs.getString("day"), rs.getString("description"));
                list.add(s);
            }
            rs.close();
            st.close();
            c.closeConnection();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public void comboBoxDay() {
        this.setList(new ArrayList<ComboBoxList>());
        try {
            c.getDBConn();
            PreparedStatement statement;
            ResultSet rs;
            statement = c.getCon().prepareStatement("SELECT \n"
                    + "  `id`,\n"
                    + "  `day`,\n"
                    + "  `description`\n"
                    + "FROM\n"
                    + "  `iregister`.`day` WHERE `deleted` =0 ORDER BY `day` ASC ; ");
            rs = statement.executeQuery();
            while (rs.next()) {
                String idl = rs.getString("id");
                String rooml = rs.getString("day");
                String locationl = rs.getString("description");

                // Process data here
                this.getList().add(new ComboBoxList(idl, rooml + "  (" + locationl + ")"));
            }

            rs.close();
            statement.close();
            c.closeConnection();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void addTime(enrollmentsystem.records.Time time) {
        try {
            c.getDBConn();
            java.sql.PreparedStatement ps = c.getCon().prepareStatement("INSERT INTO `time` ( `day_id`, `time`) values  (?,?) ;");

            ps.setInt(1, time.day().id());
            ps.setString(2, time.time());
            ps.execute();
            ps.close();
            c.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateTime(enrollmentsystem.records.Time time) {
        try {
            c.getDBConn();
            java.sql.PreparedStatement ps = c.getCon().prepareStatement("UPDATE `time` SET  `day_id` = ?, `time` = ? WHERE `id` =? ;");
            ps.setInt(1, time.day().id());
            ps.setString(2, time.time());
            ps.setInt(3, time.id());
            ps.execute();
            ps.close();
            c.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteTime(enrollmentsystem.records.Time time) {
        try {
            c.getDBConn();
            java.sql.PreparedStatement ps = c.getCon().prepareStatement("UPDATE \n"
                    + "  `time` \n"
                    + "SET  \n"
                    + "  `deleted` = 1 \n"
                    + "WHERE `id` = ? ;");
            ps.setInt(1, time.id());
            ps.execute();
            ps.close();
            c.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<enrollmentsystem.records.Time> getTime() {
        List<enrollmentsystem.records.Time> list = new ArrayList<>();
        try {
            String query = "SELECT\n"
                    + "    `time`.`id`\n"
                    + "    , `time`.`day_id`\n"
                    + "    , `day`.`day`\n"
                    + "    , `time`.`time`\n"
                    + "\n"
                    + "FROM\n"
                    + "   `day`\n"
                    + "    INNER JOIN `time` \n"
                    + "        ON (`day`.`id` = `time`.`day_id`) WHERE `time`.`deleted` =0 ORDER BY `day`.`day`,`time`.`time` ASC";
            c.getDBConn();
            Statement st = c.getCon().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                enrollmentsystem.records.Day day = new enrollmentsystem.records.Day(rs.getInt("day_id"), rs.getString("day"), rs.getString("day"));
                enrollmentsystem.records.Time t = new enrollmentsystem.records.Time(rs.getInt("id"), day, rs.getString("time"));
                list.add(t);
            }
            rs.close();
            st.close();
            c.closeConnection();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public void comboBoxTime(Integer dayId) {
        this.setList(new ArrayList<ComboBoxList>());
        try {
            c.getDBConn();
            PreparedStatement statement;
            ResultSet rs;
            statement = c.getCon().prepareStatement("SELECT\n"
                    + "    `time`.`id`\n"
                    + "    , `time`.`time`\n"
                    + "FROM\n"
                    + "    `time`\n"
                    + "    INNER JOIN `day` \n"
                    + "        ON (`time`.`day_id` = `day`.`id`) WHERE time.`deleted` =0 AND time.`day_id` = " + dayId + " ORDER BY time.`day_id` ASC;");
            rs = statement.executeQuery();
            while (rs.next()) {
                String idl = rs.getString("id");
                String timel = rs.getString("time");
                // Process data here
                this.getList().add(new ComboBoxList(idl, timel));
            }

            rs.close();
            statement.close();
            c.closeConnection();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void addSubject(enrollmentsystem.records.Subject subject) {
        try {
            c.getDBConn();
            java.sql.PreparedStatement ps = c.getCon().prepareStatement("INSERT INTO `subject` (\n"
                    + "  `course_id`,\n"
                    + "  `code`,\n"
                    + "  `subject`,\n"
                    + "  `unit_id`\n"
                    + ") \n"
                    + "VALUES\n"
                    + "  ( ?,?,?,?) ;");
            ps.setInt(1, subject.course().id());
            ps.setString(2, subject.code());
            ps.setString(3, subject.subject());
            ps.setInt(4, subject.units().id());
            ps.execute();
            ps.close();
            c.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateSubject(enrollmentsystem.records.Subject subject) {
        try {
            c.getDBConn();
            java.sql.PreparedStatement ps = c.getCon().prepareStatement("UPDATE \n"
                    + "  `subject` \n"
                    + "SET  \n"
                    + "  `course_id` =?,\n"
                    + "  `code` = ?,\n"
                    + "  `subject` = ?,\n"
                    + "  `unit_id` = ? \n"
                    + "WHERE `id` = ? ;");
            ps.setInt(1, subject.course().id());
            ps.setString(2, subject.code());
            ps.setString(3, subject.subject());
            ps.setInt(4, subject.units().id());
            ps.setInt(5, subject.id());
            ps.execute();
            ps.close();
            c.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteSubject(enrollmentsystem.records.Subject subject) {
        try {
            c.getDBConn();
            java.sql.PreparedStatement ps = c.getCon().prepareStatement("UPDATE \n"
                    + "  `subject` \n"
                    + "SET  \n"
                    + "  `deleted` = 1 \n"
                    + "WHERE `id` = ? ;");
            ps.setInt(1, subject.id());
            ps.execute();
            ps.close();
            c.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<enrollmentsystem.records.Subject> getSubject() {
        List<enrollmentsystem.records.Subject> list = new ArrayList<>();
        try {
            String query = "SELECT\n"
                    + "    `subject`.`id`\n"
                    + "    , `subject`.`course_id`\n"
                    + "    , `subject`.`unit_id`\n"
                    + "    , `subject`.`code`\n"
                    + "    , `subject`.`subject`\n"
                    + "    , `unit`.`unit`, `course`.`course`,`course`.`acronym`\n"
                    + "FROM\n"
                    + "    `subject`\n"
                    + "    INNER JOIN `unit` \n"
                    + "        ON (`subject`.`unit_id` = `unit`.`id`)\n"
                    + "    INNER JOIN `course` \n"
                    + "        ON (`subject`.`course_id` = `course`.`id`)WHERE `subject`.`deleted` =0 ORDER BY `course`.`course` ASC ";
            c.getDBConn();
            Statement st = c.getCon().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                enrollmentsystem.records.Unit u = new enrollmentsystem.records.Unit(rs.getInt("unit_id"), rs.getInt("unit"));
                enrollmentsystem.records.Course c = new enrollmentsystem.records.Course(rs.getInt("course_id"), rs.getString("course"), rs.getString("acronym"));
                enrollmentsystem.records.Subject s = new enrollmentsystem.records.Subject(rs.getInt("id"), c, rs.getString("code"), rs.getString("subject"), u);
                list.add(s);
            }
            rs.close();
            st.close();
            c.closeConnection();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public void comboBoxSubject() {
        this.setList(new ArrayList<ComboBoxList>());
        try {

            c.getDBConn();
            PreparedStatement statement;
            ResultSet rs;
            statement = c.getCon().prepareStatement("SELECT \n"
                    + "  `id`,\n"
                    + "  `code`,\n"
                    + "  `subject` \n"
                    + "FROM\n"
                    + "  `subject` WHERE deleted=0 ORDER BY `subject` ASC;");
            rs = statement.executeQuery();
            while (rs.next()) {
                String idl = rs.getString("id");
                String codel = rs.getString("code");
                String subjectl = rs.getString("subject");

                // Process data here
                this.getList().add(new ComboBoxList(idl, subjectl + " (" + codel + ")"));
            }

            rs.close();
            statement.close();
            c.closeConnection();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void comboBoxSubject(Integer courseId) {
        this.setList(new ArrayList<ComboBoxList>());
        try {

            c.getDBConn();
            PreparedStatement statement;
            ResultSet rs;
            statement = c.getCon().prepareStatement("SELECT \n"
                    + "  `id`,\n"
                    + "  `code`,\n"
                    + "  `subject` \n"
                    + "FROM\n"
                    + "  `subject` WHERE course_id =? and deleted=0 ORDER BY `subject` ASC;");
            statement.setInt(1, courseId);
            rs = statement.executeQuery();
            while (rs.next()) {
                String idl = rs.getString("id");
                String codel = rs.getString("code");
                String subjectl = rs.getString("subject");

                // Process data here
                this.getList().add(new ComboBoxList(idl, subjectl + " (" + codel + ")"));
            }

            rs.close();
            statement.close();
            c.closeConnection();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void addUnit(enrollmentsystem.records.Unit unit) {
        try {
            c.getDBConn();
            java.sql.PreparedStatement ps = c.getCon().prepareStatement("INSERT INTO `unit` (`unit`) VALUES (?) ;");
            ps.setInt(1, unit.unit());
            ps.execute();
            ps.close();
            c.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateUnit(enrollmentsystem.records.Unit unit) {
        try {
            c.getDBConn();
            java.sql.PreparedStatement ps = c.getCon().prepareStatement("UPDATE  `unit` SET `unit` = ?  WHERE `id` = ? ;");
            ps.setInt(1, unit.unit());
            ps.setInt(2, unit.id());
            ps.execute();
            ps.close();
            c.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteUnit(enrollmentsystem.records.Unit time) {
        try {
            c.getDBConn();
            java.sql.PreparedStatement ps = c.getCon().prepareStatement("UPDATE \n"
                    + "  `unit` \n"
                    + "SET  \n"
                    + "  `deleted` = 1 \n"
                    + "WHERE `id` = ? ;");
            ps.setInt(1, time.id());
            ps.execute();
            ps.close();
            c.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<enrollmentsystem.records.Unit> getUnit() {
        List<enrollmentsystem.records.Unit> list = new ArrayList<>();
        try {
            String query = "SELECT \n"
                    + "  `id`,\n"
                    + "  `unit`\n"
                    + "FROM\n"
                    + " `unit` WHERE `deleted` =0 ORDER BY unit ASC;";
            c.getDBConn();
            Statement st = c.getCon().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                enrollmentsystem.records.Unit unit = new enrollmentsystem.records.Unit(rs.getInt("id"), rs.getInt("unit"));
                list.add(unit);
            }
            rs.close();
            st.close();
            c.closeConnection();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public void comboBoxUnits() {
        this.setList(new ArrayList<ComboBoxList>());
        try {
            c.getDBConn();
            PreparedStatement statement;
            ResultSet rs;
            statement = c.getCon().prepareStatement("SELECT \n"
                    + "  `id`,\n"
                    + "  `unit` \n"
                    + "FROM\n"
                    + "  `unit` WHERE deleted =0 ORDER BY unit ASC;");
            rs = statement.executeQuery();
            while (rs.next()) {
                String idl = rs.getString("id");
                String namel = rs.getString("unit");

                // Process data here
                this.getList().add(new ComboBoxList(idl, namel));
            }

            rs.close();
            statement.close();
            c.closeConnection();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void addSchoolYear(enrollmentsystem.records.SchoolYear sy) {
        try {
            c.getDBConn();
            java.sql.PreparedStatement ps = c.getCon().prepareStatement("INSERT INTO `school_year` (\n"
                    + "  `school_year`,\n"
                    + "  `semester_id`,\n"
                    + "  `start`,\n"
                    + "  `end`\n"
                    + ") \n"
                    + "VALUES\n"
                    + "  (?,?,?,?) ;");
            ps.setString(1, sy.schoolYear());
            ps.setInt(2, sy.semester().id());
            ps.setString(3, sy.start());
            ps.setString(4, sy.end());
            ps.execute();
            ps.close();
            c.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateSchoolYear(enrollmentsystem.records.SchoolYear sy) {
        try {
            c.getDBConn();
            java.sql.PreparedStatement ps = c.getCon().prepareStatement("UPDATE \n"
                    + "  `school_year` \n"
                    + "SET \n"
                    + "  `school_year` = ?,\n"
                    + "  `semester_id` = ?,\n"
                    + "  `start` = ?,\n"
                    + "  `end` = ?\n"
                    + "WHERE `id` = ? ;");
            ps.setString(1, sy.schoolYear());
            ps.setInt(2, sy.semester().id());
            ps.setString(3, sy.start());
            ps.setString(4, sy.end());
            ps.setInt(5, sy.id());
            ps.execute();
            ps.close();
            c.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteSchoolYear(enrollmentsystem.records.SchoolYear sy) {
        try {
            c.getDBConn();
            java.sql.PreparedStatement ps = c.getCon().prepareStatement("UPDATE   `school_year` SET `deleted` = 1  WHERE `id` = ? ;");
            ps.setInt(1, sy.id());
            ps.execute();
            ps.close();
            c.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<enrollmentsystem.records.SchoolYear> getSchoolYear() {
        List<enrollmentsystem.records.SchoolYear> list = new ArrayList<>();
        try {
            String query = "SELECT\n"
                    + "    `school_year`.`id`\n"
                    + "    , `school_year`.`semester_id`\n"
                    + "    , `school_year`.`school_year`\n"
                    + "    , `semester`.`semester`\n"
                    + "    , `school_year`.`start`\n"
                    + "    , `school_year`.`end`\n"
                    + "FROM\n"
                    + "    `school_year`\n"
                    + "    INNER JOIN `semester` \n"
                    + "        ON (`school_year`.`semester_id` = `semester`.`id`) WHERE `school_year`.`deleted` =0 ORDER BY `school_year`.`id` DESC ;";
            c.getDBConn();
            Statement st = c.getCon().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                enrollmentsystem.records.Semester semester = new enrollmentsystem.records.Semester(rs.getInt("semester_id"), rs.getString("semester"));
                enrollmentsystem.records.SchoolYear sy = new enrollmentsystem.records.SchoolYear(rs.getInt("id"), rs.getString("school_year"), semester, rs.getString("start"), rs.getString("end"));
                list.add(sy);
            }
            rs.close();
            st.close();
            c.closeConnection();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public void comboBoxSchoolYear() {
        this.setList(new ArrayList<ComboBoxList>());
        try {
            c.getDBConn();
            PreparedStatement statement;
            ResultSet rs;
            statement = c.getCon().prepareStatement("SELECT\n"
                    + "    `school_year`.`id`\n"
                    + "    , `school_year`.`school_year`\n"
                    + "    , `semester`.`semester`\n"
                    + "FROM\n"
                    + "    `school_year`\n"
                    + "    INNER JOIN `semester` \n"
                    + "        ON (`school_year`.`semester_id` = `semester`.`id`) WHERE `school_year`.`deleted` =0 ORDER BY `school_year`.`id` DESC ;");
            rs = statement.executeQuery();
            while (rs.next()) {
                String idl = rs.getString("id");
                String syl = rs.getString("school_year");
                String seml = rs.getString("semester");

                // Process data here
                this.getList().add(new ComboBoxList(idl, syl + "  " + seml));
            }

            rs.close();
            statement.close();
            c.closeConnection();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void addSemester(enrollmentsystem.records.Semester semester) {
        try {
            c.getDBConn();
            java.sql.PreparedStatement ps = c.getCon().prepareStatement("INSERT INTO `semester` (`semester`) VALUES (?) ;");
            ps.setString(1, semester.semester());
            ps.execute();
            ps.close();
            c.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateSemester(enrollmentsystem.records.Semester semester) {
        try {
            c.getDBConn();
            java.sql.PreparedStatement ps = c.getCon().prepareStatement("UPDATE \n"
                    + "  `semester` \n"
                    + "SET  \n"
                    + "  `semester` = ? \n"
                    + "WHERE `id` = ? ;");
            ps.setString(1, semester.semester());
            ps.setInt(2, semester.id());
            ps.execute();
            ps.close();
            c.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteSemester(enrollmentsystem.records.Semester semester) {
        try {
            c.getDBConn();
            java.sql.PreparedStatement ps = c.getCon().prepareStatement("UPDATE   `semester` SET `deleted` = 1  WHERE `id` = ? ;");
            ps.setInt(1, semester.id());
            ps.execute();
            ps.close();
            c.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<enrollmentsystem.records.Semester> getSemester() {
        List<enrollmentsystem.records.Semester> list = new ArrayList<>();
        try {
            String query = "SELECT \n"
                    + "  `id`,\n"
                    + "  `semester`\n"
                    + "FROM  `semester` WHERE `deleted` =0 ORDER BY `semester` ASC";
            c.getDBConn();
            Statement st = c.getCon().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                enrollmentsystem.records.Semester unit = new enrollmentsystem.records.Semester(rs.getInt("id"), rs.getString("semester"));
                list.add(unit);
            }
            rs.close();
            st.close();
            c.closeConnection();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public void comboBoxSemester() {
        this.setList(new ArrayList<ComboBoxList>());
        try {
            c.getDBConn();
            PreparedStatement statement;
            ResultSet rs;
            statement = c.getCon().prepareStatement("SELECT \n"
                    + "  `id`,\n"
                    + "  `semester`\n"
                    + "FROM  `semester` WHERE `deleted` =0 ORDER BY `semester` ASC");
            rs = statement.executeQuery();
            while (rs.next()) {
                String idl = rs.getString("id");
                String namel = rs.getString("semester");

                // Process data here
                this.getList().add(new ComboBoxList(idl, namel));
            }

            rs.close();
            statement.close();
            c.closeConnection();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void addClass(enrollmentsystem.records.Class clss) {
        try {
            c.getDBConn();
            java.sql.PreparedStatement ps = c.getCon().prepareStatement("INSERT INTO `class` (\n"
                    + "  `class_code`,\n"
                    + "  `course_id`,\n"
                    + "  `subject_id`,\n"
                    + "  `instructor_id`,\n"
                    + "  `day_id`,\n"
                    + "  `time_id`,\n"
                    + "  `room_id`,\n"
                    + "  `school_year_id`,\n"
                    + "  `user_id`\n"
                    + ") VALUES (?,?,?,?,?,?,?,?,?) ;");
            ps.setString(1, clss.classCode());
            ps.setInt(2, clss.course().id());
            ps.setInt(3, clss.subject().id());
            ps.setInt(4, clss.instructor().id());
            ps.setInt(5, clss.day().id());
            ps.setInt(6, clss.time().id());
            ps.setInt(7, clss.room().id());
            ps.setInt(8, clss.schoolYear().id());
            ps.setInt(9, clss.user().id());
            ps.execute();
            ps.close();
            c.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateClass(enrollmentsystem.records.Class clss) {
        try {

            c.getDBConn();
            java.sql.PreparedStatement ps = c.getCon().prepareStatement("UPDATE \n"
                    + "  `class` \n"
                    + "SET \n"
                    + "  `class_code` = ?,\n"
                    + "  `course_id` = ?,\n"
                    + "  `subject_id` = ?,\n"
                    + "  `instructor_id` = ?,\n"
                    + "  `day_id` = ?,\n"
                    + "  `time_id` = ?,\n"
                    + "  `room_id` = ?,\n"
                    + "  `school_year_id` = ?,\n"
                    + "  `user_id` = ?\n"
                    + "WHERE `id` = ? ;");
            ps.setString(1, clss.classCode());
            ps.setInt(2, clss.course().id());
            ps.setInt(3, clss.subject().id());
            ps.setInt(4, clss.instructor().id());
            ps.setInt(5, clss.day().id());
            ps.setInt(6, clss.time().id());
            ps.setInt(7, clss.room().id());
            ps.setInt(8, clss.schoolYear().id());
            ps.setInt(9, clss.user().id());
            ps.setInt(10, clss.id());
            ps.execute();
            ps.close();
            c.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteClass(enrollmentsystem.records.Class clss) {
        try {
            c.getDBConn();
            java.sql.PreparedStatement ps = c.getCon().prepareStatement("UPDATE   `class` SET `deleted` = 1  WHERE `id` = ? ;");
            ps.setInt(1, clss.id());
            ps.execute();
            ps.close();
            c.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Integer getCurrentSchoolYear() {
        Integer id = null;
        try {
            String query = "SELECT \n"
                    + "  `id`\n"
                    + "FROM\n"
                    + "  `school_year` WHERE `deleted`=0 AND `start` <CURDATE() AND `end`>CURDATE()";
            c.getDBConn();
            Statement st = c.getCon().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                id = rs.getInt("id");
            }
            rs.close();
            st.close();
            c.closeConnection();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return id;
    }

    public List<enrollmentsystem.records.Class> getClasses() {
        List<enrollmentsystem.records.Class> list = new ArrayList<>();
        try {
            String query = "SELECT\n"
                    + "    `class`.`id`\n"
                    + "    , `class`.`course_id`\n"
                    + "    , `class`.`subject_id`\n"
                    + "    , `class`.`instructor_id`\n"
                    + "    , `class`.`day_id`\n"
                    + "    , `class`.`time_id`\n"
                    + "    , `class`.`room_id`\n"
                    + "    , `class`.`school_year_id`\n"
                    + "    , `class`.`class_code`\n"
                    + "    , `course`.`course`\n"
                    + "    , `subject`.`subject`\n"
                    + "    , `instructor`.`firstname`\n"
                    + "    , `instructor`.`middlename`\n"
                    + "    , `instructor`.`lastname`\n"
                    + "    , `day`.`day`\n"
                    + "    , `room`.`room`\n"
                    + "    , `unit`.`unit`,`time`.`time`\n"
                    + "FROM\n"
                    + "    `class`\n"
                    + "    INNER JOIN `course` \n"
                    + "        ON (`class`.`course_id` = `course`.`id`)\n"
                    + "    INNER JOIN `subject` \n"
                    + "        ON (`class`.`subject_id` = `subject`.`id`)\n"
                    + "    INNER JOIN `instructor` \n"
                    + "        ON (`class`.`instructor_id` = `instructor`.`id`)\n"
                    + "    INNER JOIN `day` \n"
                    + "        ON (`class`.`day_id` = `day`.`id`)\n"
                    + "    INNER JOIN `room` \n"
                    + "        ON (`class`.`room_id` = `room`.`id`)\n"
                    + "    INNER JOIN `time` \n"
                    + "        ON (`class`.`time_id` = `time`.`id`)\n"
                    + "    INNER JOIN `unit` \n"
                    + "        ON (`subject`.`unit_id` = `unit`.`id`)WHERE `class`.`deleted` =0 ORDER BY `class`.`class_code` ASC;";
            c.getDBConn();
            Statement st = c.getCon().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                enrollmentsystem.records.Unit units = new enrollmentsystem.records.Unit(1, rs.getInt("unit"));
                enrollmentsystem.records.Course courseIdl = new enrollmentsystem.records.Course(rs.getInt("course_id"), rs.getString("course"), null);
                enrollmentsystem.records.Subject subjectIdl = new enrollmentsystem.records.Subject(rs.getInt("subject_id"), courseIdl, null, rs.getString("subject"), units);
                enrollmentsystem.records.Instructor instructorIdl = new enrollmentsystem.records.Instructor(rs.getInt("instructor_id"), rs.getString("firstname"), rs.getString("middlename"), rs.getString("lastname"), null, null, null, null, null, null, null);
                enrollmentsystem.records.Day dayIdl = new enrollmentsystem.records.Day(rs.getInt("day_id"), rs.getString("day"), null);
                enrollmentsystem.records.Time timeIdl = new enrollmentsystem.records.Time(rs.getInt("time_id"), dayIdl, rs.getString("time"));
                enrollmentsystem.records.Room roomIdl = new enrollmentsystem.records.Room(rs.getInt("room_id"), rs.getString("room"), null);
                enrollmentsystem.records.Class unit = new enrollmentsystem.records.Class(rs.getInt("id"), rs.getString("class_code"), courseIdl, subjectIdl, instructorIdl, dayIdl, timeIdl, roomIdl, null, null);
                list.add(unit);
            }
            rs.close();
            st.close();
            c.closeConnection();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public List<enrollmentsystem.records.Class> getClassesWithCourseParam(Integer courseId) {
        List<enrollmentsystem.records.Class> list = new ArrayList<>();
        try {
            String query = "SELECT\n"
                    + "    `class`.`id`\n"
                    + "    , `class`.`course_id`\n"
                    + "    , `class`.`subject_id`\n"
                    + "    , `class`.`instructor_id`\n"
                    + "    , `class`.`day_id`\n"
                    + "    , `class`.`time_id`\n"
                    + "    , `class`.`room_id`\n"
                    + "    , `class`.`school_year_id`\n"
                    + "    , `class`.`class_code`\n"
                    + "    , `course`.`course`\n"
                    + "    , `subject`.`subject`\n"
                    + "    , `instructor`.`firstname`\n"
                    + "    , `instructor`.`middlename`\n"
                    + "    , `instructor`.`lastname`\n"
                    + "    , `day`.`day`\n"
                    + "    , `room`.`room`\n"
                    + "    , `unit`.`unit`,`time`.`time`\n"
                    + "FROM\n"
                    + "    `class`\n"
                    + "    INNER JOIN `course` \n"
                    + "        ON (`class`.`course_id` = `course`.`id`)\n"
                    + "    INNER JOIN `subject` \n"
                    + "        ON (`class`.`subject_id` = `subject`.`id`)\n"
                    + "    INNER JOIN `instructor` \n"
                    + "        ON (`class`.`instructor_id` = `instructor`.`id`)\n"
                    + "    INNER JOIN `day` \n"
                    + "        ON (`class`.`day_id` = `day`.`id`)\n"
                    + "    INNER JOIN `room` \n"
                    + "        ON (`class`.`room_id` = `room`.`id`)\n"
                    + "    INNER JOIN `time` \n"
                    + "        ON (`class`.`time_id` = `time`.`id`)\n"
                    + "    INNER JOIN `unit` \n"
                    + "        ON (`subject`.`unit_id` = `unit`.`id`)WHERE `class`.`course_id`=?  and `class`.`deleted` =0 ORDER BY `class`.`class_code` ASC;";
            c.getDBConn();
            PreparedStatement statement = c.getCon().prepareStatement(query);
            statement.setInt(1, courseId);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                enrollmentsystem.records.Unit units = new enrollmentsystem.records.Unit(1, rs.getInt("unit"));
                enrollmentsystem.records.Course courseIdl = new enrollmentsystem.records.Course(rs.getInt("course_id"), rs.getString("course"), null);
                enrollmentsystem.records.Subject subjectIdl = new enrollmentsystem.records.Subject(rs.getInt("subject_id"), courseIdl, null, rs.getString("subject"), units);
                enrollmentsystem.records.Instructor instructorIdl = new enrollmentsystem.records.Instructor(rs.getInt("instructor_id"), rs.getString("firstname"), rs.getString("middlename"), rs.getString("lastname"), null, null, null, null, null, null, null);
                enrollmentsystem.records.Day dayIdl = new enrollmentsystem.records.Day(rs.getInt("day_id"), rs.getString("day"), null);
                enrollmentsystem.records.Time timeIdl = new enrollmentsystem.records.Time(rs.getInt("time_id"), dayIdl, rs.getString("time"));
                enrollmentsystem.records.Room roomIdl = new enrollmentsystem.records.Room(rs.getInt("room_id"), rs.getString("room"), null);
                enrollmentsystem.records.Class unit = new enrollmentsystem.records.Class(rs.getInt("id"), rs.getString("class_code"), courseIdl, subjectIdl, instructorIdl, dayIdl, timeIdl, roomIdl, null, null);
                list.add(unit);
            }
            rs.close();
            statement.close();
            c.closeConnection();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public List<enrollmentsystem.records.Class> getClassesWithSchoolYearParam(Integer syId) {
        List<enrollmentsystem.records.Class> list = new ArrayList<>();
        try {
            String query = "SELECT\n"
                    + "    `class`.`id`\n"
                    + "    , `class`.`course_id`\n"
                    + "    , `class`.`subject_id`\n"
                    + "    , `class`.`instructor_id`\n"
                    + "    , `class`.`day_id`\n"
                    + "    , `class`.`time_id`\n"
                    + "    , `class`.`room_id`\n"
                    + "    , `class`.`school_year_id`\n"
                    + "    , `class`.`class_code`\n"
                    + "    , `course`.`course`\n"
                    + "    , `subject`.`subject`\n"
                    + "    , `instructor`.`firstname`\n"
                    + "    , `instructor`.`middlename`\n"
                    + "    , `instructor`.`lastname`\n"
                    + "    , `day`.`day`\n"
                    + "    , `room`.`room`\n"
                    + "    , `unit`.`unit`,`time`.`time`\n"
                    + "FROM\n"
                    + "    `class`\n"
                    + "    INNER JOIN `course` \n"
                    + "        ON (`class`.`course_id` = `course`.`id`)\n"
                    + "    INNER JOIN `subject` \n"
                    + "        ON (`class`.`subject_id` = `subject`.`id`)\n"
                    + "    INNER JOIN `instructor` \n"
                    + "        ON (`class`.`instructor_id` = `instructor`.`id`)\n"
                    + "    INNER JOIN `day` \n"
                    + "        ON (`class`.`day_id` = `day`.`id`)\n"
                    + "    INNER JOIN `room` \n"
                    + "        ON (`class`.`room_id` = `room`.`id`)\n"
                    + "    INNER JOIN `time` \n"
                    + "        ON (`class`.`time_id` = `time`.`id`)\n"
                    + "    INNER JOIN `unit` \n"
                    + "        ON (`subject`.`unit_id` = `unit`.`id`)WHERE `class`.`school_year_id`=?  and `class`.`deleted` =0 ORDER BY `class`.`class_code` ASC;";
            c.getDBConn();
            PreparedStatement statement = c.getCon().prepareStatement(query);
            statement.setInt(1, syId);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                enrollmentsystem.records.Unit units = new enrollmentsystem.records.Unit(1, rs.getInt("unit"));
                enrollmentsystem.records.Course courseIdl = new enrollmentsystem.records.Course(rs.getInt("course_id"), rs.getString("course"), null);
                enrollmentsystem.records.Subject subjectIdl = new enrollmentsystem.records.Subject(rs.getInt("subject_id"), courseIdl, null, rs.getString("subject"), units);
                enrollmentsystem.records.Instructor instructorIdl = new enrollmentsystem.records.Instructor(rs.getInt("instructor_id"), rs.getString("firstname"), rs.getString("middlename"), rs.getString("lastname"), null, null, null, null, null, null, null);
                enrollmentsystem.records.Day dayIdl = new enrollmentsystem.records.Day(rs.getInt("day_id"), rs.getString("day"), null);
                enrollmentsystem.records.Time timeIdl = new enrollmentsystem.records.Time(rs.getInt("time_id"), dayIdl, rs.getString("time"));
                enrollmentsystem.records.Room roomIdl = new enrollmentsystem.records.Room(rs.getInt("room_id"), rs.getString("room"), null);
                enrollmentsystem.records.Class unit = new enrollmentsystem.records.Class(rs.getInt("id"), rs.getString("class_code"), courseIdl, subjectIdl, instructorIdl, dayIdl, timeIdl, roomIdl, null, null);
                list.add(unit);
            }
            rs.close();
            statement.close();
            c.closeConnection();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public List<enrollmentsystem.records.Class> getClassesWithSchoolYearAndCourseParam(Integer schoolYearId, Integer courseId) {
        List<enrollmentsystem.records.Class> list = new ArrayList<>();
        try {
            String query = "SELECT\n"
                    + "    `class`.`id`\n"
                    + "    , `class`.`course_id`\n"
                    + "    , `class`.`subject_id`\n"
                    + "    , `class`.`instructor_id`\n"
                    + "    , `class`.`day_id`\n"
                    + "    , `class`.`time_id`\n"
                    + "    , `class`.`room_id`\n"
                    + "    , `class`.`school_year_id`\n"
                    + "    , `class`.`class_code`\n"
                    + "    , `course`.`course`\n"
                    + "    , `subject`.`subject`\n"
                    + "    , `instructor`.`firstname`\n"
                    + "    , `instructor`.`middlename`\n"
                    + "    , `instructor`.`lastname`\n"
                    + "    , `day`.`day`\n"
                    + "    , `room`.`room`\n"
                    + "    , `unit`.`unit`,`time`.`time`\n"
                    + "FROM\n"
                    + "    `class`\n"
                    + "    INNER JOIN `course` \n"
                    + "        ON (`class`.`course_id` = `course`.`id`)\n"
                    + "    INNER JOIN `subject` \n"
                    + "        ON (`class`.`subject_id` = `subject`.`id`)\n"
                    + "    INNER JOIN `instructor` \n"
                    + "        ON (`class`.`instructor_id` = `instructor`.`id`)\n"
                    + "    INNER JOIN `day` \n"
                    + "        ON (`class`.`day_id` = `day`.`id`)\n"
                    + "    INNER JOIN `room` \n"
                    + "        ON (`class`.`room_id` = `room`.`id`)\n"
                    + "    INNER JOIN `time` \n"
                    + "        ON (`class`.`time_id` = `time`.`id`)\n"
                    + "    INNER JOIN `unit` \n"
                    + "        ON (`subject`.`unit_id` = `unit`.`id`)WHERE `class`.`course_id`=? and `class`.`school_year_id`=? and `class`.`deleted` =0 ORDER BY `class`.`class_code` ASC;";
            c.getDBConn();
            PreparedStatement statement = c.getCon().prepareStatement(query);
            statement.setInt(1, courseId);
            statement.setInt(2, schoolYearId);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                enrollmentsystem.records.Unit units = new enrollmentsystem.records.Unit(1, rs.getInt("unit"));
                enrollmentsystem.records.Course courseIdl = new enrollmentsystem.records.Course(rs.getInt("course_id"), rs.getString("course"), null);
                enrollmentsystem.records.Subject subjectIdl = new enrollmentsystem.records.Subject(rs.getInt("subject_id"), courseIdl, null, rs.getString("subject"), units);
                enrollmentsystem.records.Instructor instructorIdl = new enrollmentsystem.records.Instructor(rs.getInt("instructor_id"), rs.getString("firstname"), rs.getString("middlename"), rs.getString("lastname"), null, null, null, null, null, null, null);
                enrollmentsystem.records.Day dayIdl = new enrollmentsystem.records.Day(rs.getInt("day_id"), rs.getString("day"), null);
                enrollmentsystem.records.Time timeIdl = new enrollmentsystem.records.Time(rs.getInt("time_id"), dayIdl, rs.getString("time"));
                enrollmentsystem.records.Room roomIdl = new enrollmentsystem.records.Room(rs.getInt("room_id"), rs.getString("room"), null);
                enrollmentsystem.records.Class unit = new enrollmentsystem.records.Class(rs.getInt("id"), rs.getString("class_code"), courseIdl, subjectIdl, instructorIdl, dayIdl, timeIdl, roomIdl, null, null);
                list.add(unit);
            }
            rs.close();
            statement.close();
            c.closeConnection();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public void comboBoxClassCode() {
        this.setList(new ArrayList<ComboBoxList>());
        try {
            c.getDBConn();
            PreparedStatement statement;
            ResultSet rs;
            statement = c.getCon().prepareStatement("SELECT\n"
                    + "    `id`\n"
                    + "    , `class_code`\n"
                    + "FROM\n"
                    + "    `class` WHERE `deleted` =0 ORDER BY `class_code` ASC; ");
            rs = statement.executeQuery();
            while (rs.next()) {
                String idl = rs.getString("id");
                String namel = rs.getString("class_code");

                // Process data here
                this.getList().add(new ComboBoxList(idl, namel));
            }
            rs.close();
            statement.close();
            c.closeConnection();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public String selectClassCodeSuggested(Integer subject) {
        String code = null;
        try {
            c.getDBConn();
            PreparedStatement statement = c.getCon().prepareStatement("SELECT \n"
                    + "  `class_code`\n"
                    + "FROM\n"
                    + "  `class` WHERE `subject_id` =? AND`deleted` =0");
            statement.setInt(1, subject);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                code = rs.getString("class_code");
            }
            rs.close();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Opss...", JOptionPane.ERROR_MESSAGE);
        }
        return code;
    }

    public enrollmentsystem.records.Student getStudentInformation(Integer id) {
        enrollmentsystem.records.Student student = null;
        try {
            c.getDBConn();
            PreparedStatement statement = c.getCon().prepareStatement("SELECT\n"
                    + "    `student`.`firstname`\n"
                    + "    , `student`.`middlename`\n"
                    + "    , `student`.`lastname`\n"
                    + "    , `course`.`course`\n"
                    + "    , `student`.`gender`\n"
                    + "    , `civil_status`.`civil_status`\n"
                    + "    , `student`.`religion`\n"
                    + "    , `student`.`address`\n"
                    + "    , `student`.`id`\n"
                    + "FROM\n"
                    + "    `student`\n"
                    + "    INNER JOIN `civil_status` \n"
                    + "        ON (`student`.`civil_status_id` = `civil_status`.`id`)\n"
                    + "    INNER JOIN `course` \n"
                    + "        ON (`student`.`course_id` = `course`.`id`) WHERE `student`.`deleted`=0 AND `student`.`id`=?");
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                enrollmentsystem.records.Course c = new enrollmentsystem.records.Course(null, rs.getString("course"), null);
                enrollmentsystem.records.CivilStatus cs = new enrollmentsystem.records.CivilStatus(id, rs.getString("civil_status"));
                student = new enrollmentsystem.records.Student(id, rs.getString("firstname"), rs.getString("middlename"), rs.getString("lastname"), c, rs.getString("gender"), cs, rs.getString("religion"), null, null, null, rs.getString("address"), null);
            }
            rs.close();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Opss...", JOptionPane.ERROR_MESSAGE);
        }
        return student;
    }

    public ArrayList<enrollmentsystem.records.Class> selectClassCodeToStudent(Integer id) {
        ArrayList<enrollmentsystem.records.Class> clss = null;
        try {
            c.getDBConn();
            PreparedStatement statement = c.getCon().prepareStatement("SELECT  photo FROM student  where id  =" + id + "");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                enrollmentsystem.records.Class studentClass = new enrollmentsystem.records.Class(id, null, null, null, null, null, null, null, null, null);
                clss.add(studentClass);
            }
            rs.close();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Opss...", JOptionPane.ERROR_MESSAGE);
        }
        return clss;
    }

    public void addTuitionFee(enrollmentsystem.records.TuitionFee tuitionFee) {
        try {
            c.getDBConn();
            java.sql.PreparedStatement ps = c.getCon().prepareStatement("INSERT INTO `tuition` (\n"
                    + "  `tuition_fee`,\n"
                    + "  `school_year_id`\n"
                    + ") \n"
                    + "VALUES\n"
                    + "  (?,?) ;");
            ps.setFloat(1, tuitionFee.tuitionFee());
            ps.setInt(2, tuitionFee.schoolYear().id());

            ps.execute();
            ps.close();
            c.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateTuitionFee(enrollmentsystem.records.TuitionFee tuitionFee) {
        try {
            c.getDBConn();

            java.sql.PreparedStatement ps = c.getCon().prepareStatement("UPDATE `tuition` \n"
                    + "SET \n"
                    + "  `tuition_fee` = ?,\n"
                    + "  `school_year_id` = ?\n"
                    + "WHERE `id` = ?;");
            ps.setFloat(1, tuitionFee.tuitionFee());
            ps.setInt(2, tuitionFee.schoolYear().id());
            ps.setInt(3, tuitionFee.id());
            ps.execute();
            ps.close();
            c.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteTuitionFee(enrollmentsystem.records.TuitionFee tuitionFee) {
        try {
            c.getDBConn();
            java.sql.PreparedStatement ps = c.getCon().prepareStatement("UPDATE \n"
                    + "  `tuition` \n"
                    + "SET  \n"
                    + "  `deleted` = 1 \n"
                    + "WHERE `id` = ? ;");
            ps.setInt(1, tuitionFee.id());
            ps.execute();
            ps.close();
            c.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<enrollmentsystem.records.TuitionFee> getTuitionFee() {
        List<enrollmentsystem.records.TuitionFee> list = new ArrayList<>();
        try {

            String query = "SELECT\n"
                    + "    `tuition`.`id`\n"
                    + "    , `tuition`.`tuition_fee`\n"
                    + "    , `tuition`.`school_year_id`\n"
                    + "    , `school_year`.`school_year`\n"
                    + "FROM\n"
                    + "    `tuition`\n"
                    + "    INNER JOIN `school_year` \n"
                    + "        ON (`tuition`.`school_year_id` = `school_year`.`id`) WHERE `tuition`.`deleted` =0 ORDER BY `school_year`.`id` DESC ;";
            c.getDBConn();
            Statement st = c.getCon().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                enrollmentsystem.records.SchoolYear schoolYear = new enrollmentsystem.records.SchoolYear(rs.getInt("school_year_id"), rs.getString("school_year"), null, null, null);
                enrollmentsystem.records.TuitionFee tuitionFee = new enrollmentsystem.records.TuitionFee(rs.getInt("id"), rs.getFloat("tuition_fee"), schoolYear);
                list.add(tuitionFee);
            }
            rs.close();
            st.close();
            c.closeConnection();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

}
