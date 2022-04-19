/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import DAO.ImportationDAO;
import DAO.ReportDAO;
import Model.Report;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class ReportService {
    ReportDAO reportDao= new ReportDAO();
   
    
    public Report getRevenuesByMonth(int month) {
        return reportDao.getRevenuesByMonth(month);
    }
    
    public Report getRevenuesByMonthNow() {
        Report rp = reportDao.getRevenuesByMonthNow();
        if( rp == null){
            rp = new Report();
            rp.setRevenue(0);
        }
        return rp;
        
    }
    
    public Report getRevenuesByQuarter(int quarter) {
        return reportDao.getRevenuesByQuarter(quarter);
    }
    
    public Report getRevenuesByQuarterNow() {
        Report rp = reportDao.getRevenuesByQuarterNow();
        if( rp == null){
            rp = new Report();
            rp.setRevenue(0);
        }
        return rp;
        
    }
    
    public ArrayList<Report> getListRevenuesByMonth(){
        ArrayList<Report> rp = new ArrayList<>();
        for(int i =1; i<=12 ;i++){           
            rp.add(reportDao.getRevenuesByMonth(i));
        }
        return  rp;
    }
    
    public ArrayList<Report> getListCostByMonth(){
        ArrayList<Report> rp = new ArrayList<>();
        for(int i =1; i<=12 ;i++){           
            rp.add(reportDao.getCostByMonth(i));
        }
        return  rp;
    }
    
     public ArrayList<Double> getListBenefitByMonth(){
        ArrayList<Double> rp = new ArrayList<>();
        ArrayList<Report> rp1 = getListRevenuesByMonth();
        ArrayList<Report> rp2 = getListCostByMonth();
        for(int i =0; i<12 ;i++){   
            if(rp1.get(i)==null){
                if(rp2.get(i)==null){
                    rp.add(0.0);
                }else{
                   rp.add((double)rp2.get(i).getCost()*(-1.0));
                }
            }else{
                if(rp2.get(i)==null){
                     rp.add((double)rp1.get(i).getRevenue());
                }else{
                  rp.add((double)rp1.get(i).getRevenue()-(double)rp2.get(i).getCost());
                }
            }
            
        }
        return  rp;
    }
    
     public Report getCostByMonth(int month) {
        return reportDao.getCostByMonth(month);
    }
    
    public Report getCostByMonthNow() {
        Report rp = reportDao.getCostByMonthNow();
        if( rp == null){
            rp = new Report();
            rp.setCost(0);
        }
        return rp;
        
    }
    
    public Report getCostByQuarter(int quarter) {
        return reportDao.getCostByQuarter(quarter);
    }
    
    public Report getCostByQuarterNow() {
        Report rp = reportDao.getCostByQuarterNow();
        if( rp == null){
            rp = new Report();
            rp.setCost(0);
        }
        return rp;
    }
    
    public Report getRevenuesByQuarterBefore(){
        Report rp = reportDao.getRevenuesByQuarterBefore();
        if( rp == null){
            rp = new Report();
            rp.setRevenue(0);
        }
        return rp;
    }
    
    public Report getCostByQuarterBefore(){
        Report rp = reportDao.getCostByQuarterBefore();
        if( rp == null){
            rp = new Report();
            rp.setCost(0);
        }
        return rp;
        
    }
    
}
