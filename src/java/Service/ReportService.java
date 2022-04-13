/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import DAO.ReportDAO;
import Model.Report;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class ReportService {
    ReportDAO reportDao= new ReportDAO();
    
    public Report getReportByMonth(int month) {
        return reportDao.getReportByMonth(month);
    }
    
    public Report getReportByMonthNow() {
        return reportDao.getReportByMonthNow();
    }
    
    public Report getReportByQuarter(int quarter) {
        return reportDao.getReportByQuarter(quarter);
    }
    
    public Report getReportByQuarterNow() {
        return reportDao.getReportByQuarterNow();
    }
    
    public ArrayList<Report> getListReportByMonth(){
        ArrayList<Report> rp = new ArrayList<>();
        for(int i =1; i<=12 ;i++){           
            rp.add(reportDao.getReportByMonth(i));
        }
        return  rp;
    }
    
}
