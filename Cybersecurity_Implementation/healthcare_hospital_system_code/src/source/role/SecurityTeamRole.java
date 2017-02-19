/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package source.role;

import javax.swing.JPanel;
import screen.securityTeam.SecurityTeamWorkAreaJPanel;
import source.EcoSystem;
import source.department.Department;
import source.hospital.Hospital;
import source.userAccount.UserAccount;

/**
 *
 * @author GaurangDeshpande
 */
public class SecurityTeamRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel cardContainer, UserAccount account, Department department, Hospital hospital, EcoSystem ecoSystem) {
        return new SecurityTeamWorkAreaJPanel(cardContainer, account, department, hospital, ecoSystem);
    }
}