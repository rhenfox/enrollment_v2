/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package enrollmentsystem.records;

/**
 *
 * @author Java Programming with Aldrin
 */
public record Class(Integer id,
        String classCode,
        Course course,
        Subject subject,
        Instructor instructor,
        Day day,
        Time time,
        Room room,
        SchoolYear schoolYear,
        User user) {

}
