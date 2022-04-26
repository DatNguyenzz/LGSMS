/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utility;

import java.text.DecimalFormat;

/**
 *
 * @author dat19
 */
public class FormatNumber {
    public String formatDoubleToVND(double in){
        DecimalFormat formatter = new DecimalFormat("###,###,###.##");
        return formatter.format(in) + " VNĐ";
    }
    
    public String formatDoubleToString(double in){
        DecimalFormat formatter = new DecimalFormat("###,###,###.##");
        return formatter.format(in);
    }
    
    public String formatDoubleToNumber(double in){
        DecimalFormat formatter = new DecimalFormat("#########.##");
        return formatter.format(in);
    }
}
