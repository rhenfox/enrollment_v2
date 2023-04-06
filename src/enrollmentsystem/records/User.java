/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package enrollmentsystem.records;

/**
 *
 * @author Java Programming with Aldrin
 */
public record User(Integer id, String firstname, String middlename, String lastname, String username, String password, Role role) {
    
}
