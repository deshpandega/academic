/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoproject_v1_1;

import java.util.TimerTask;

/**
 *
 * @author Gaurang Deshpande
 * <deshpande.ga@husky.neu.edu/gaurangdeshpande89@gmail.com>
 */
public class TimerTaskMgt extends TimerTask{

    static int a = 0;
    @Override
    public void run() {
        System.out.println("In Timer"+ a++);
    }
    
}
