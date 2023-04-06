/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package enrollmentsystem.records;

import java.io.File;

/**
 *
 * @author Java Programming with Aldrin
 */
public record Student(Integer id,
        String firstname,
        String middlename,
        String lastname,
        Course course,
        String gender,
        CivilStatus civilStatus,
        String religion,
        String dateOfBirth,
        String mobileNo,
        String email,
        String address,
        File photo) {

}
