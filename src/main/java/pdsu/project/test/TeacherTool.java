package pdsu.project.test;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pdsu.project.domain.ExcelTeacherDomain;
import pdsu.project.service.TescherExcelService;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ljk
 */
public class TeacherTool {

    public static void main(String[] args) throws IOException {

        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        TescherExcelService excelService = classPathXmlApplicationContext.getBean(TescherExcelService.class);
       String path= "C:\\Users\\Administrator\\Desktop\\123.xls";
        int lastIndexOf = path.lastIndexOf(".");
        System.out.println(lastIndexOf);
        String substring = path.substring(lastIndexOf, path.length() );
        System.out.println(substring);
        Workbook wb=null;
        if (".xls".equals(substring)){
            InputStream in=new FileInputStream(new File(path));
            wb =new HSSFWorkbook(in);
        }else {
            wb = new XSSFWorkbook(path);
        }
        List<ExcelTeacherDomain> excelDomainList =new ArrayList<>();
        //获取工作簿对象

        //获取工作表
        Sheet sheet = wb.getSheetAt(0);
        //获取最后一行
        int lastRowNum = sheet.getLastRowNum();
        System.out.println(lastRowNum);
        List<String> list =new ArrayList<String>();
        for (int i=2;i<=5;i++){
            //得到每一行
            Row row = sheet.getRow(i);
            if (row!=null){
                //得到每一个单元格
                short cellNum = row.getLastCellNum();
                ExcelTeacherDomain domain = new ExcelTeacherDomain();
                for (int j = 0; j <cellNum ; j++) {
                    Cell cell = row.getCell(j);
                    //设置为字符串
                    try {
                        cell.setCellType(Cell.CELL_TYPE_STRING);
                    } catch (Exception e) {

                    }
                    String value = cell.getStringCellValue();
                    if (j==0){
                        domain.setId(value);
                    }else if (j==1){
                        domain.setReportTime(value);
                    }else if (j==2){
                        domain.setDeptName(value);;
                    }else if (j==3){
                        domain.setName(value);
                    }else if (j==4){
                        domain.setSex(value);
                    }else if (j==5){
                        domain.setNum(value);
                    }  else if (j==6){
                        domain.setMyPhone(value);
                    } else if (j==7){
                        domain.setParaentName(value);
                    }else if (j==8){
                        domain.setParaentPhone(value);
                    }else if (j==9){
                        domain.setMyOffenHome(value);
                    }else if (j==10){
                        domain.setMyOffenHomeDeatil(value);
                    }else if (j==11){
                        domain.setTemp(value);
                    }else if (j==12){
                        domain.setHealthy(value);
                    }else if (j==13){
                        domain.setHealthyCondition(value);
                    }else if (j==14){
                        domain.setNowArea(value);
                    }else if (j==15){
                        domain.setNowDetailArea(value);
                    }else if (j==16){
                        domain.setBadCase(value);
                    }else if (j==17){
                        domain.setBadCaseTime(value);
                    }else if (j==18){
                        domain.setIsOut(value);
                    }else if (j==19){
                        domain.setOutTime(value);
                    }else if (j==20){
                        domain.setOutArea(value);
                        if (value!=null && value!=" "){
                            System.out.println("外出地点"+value);
                        }
                    }else if (j==21){
                        domain.setBackTime(value);
                    }else if (j==22){
                        domain.setTraffic(value);
                    }else if (j==23){
                        domain.setIsBadCase(value);
                    }else if (j==24){
                        domain.setBadArea(value);
                    }else if (j==25){

                    }else if (j==26){

                    }else if (j==27){

                    }else if (j==28){
                        domain.setIsPing(value);

                    }else if (j==29){
                        domain.setIsolation(value);
                    }else if (j==30){
                        domain.setMandatoryIsolation(value);

                    }else if (j==31){
                        domain.setInHomeIsolation(value);

                    }else if (j==32){
                        domain.setIsolationBeginTime(value);

                    }else if (j==33){
                        domain.setIsolationEndTime(value);

                    }else if (j==34){
                        domain.setIsHospital(value);

                    }else if (j==35){
                        domain.setFamilyIsGoToBadRrea(value);
                    }else if (j==36){
                        domain.setFamilyGoToBadRreaTime(value);
                    }else if (j==37){
                        domain.setContry(value);
                    }else if (j==38){
                        domain.setFamilyGoToBadRreaTime(value);
                    }else if (j==39){
                        domain.setIsBadPerson(value);
                    }else if (j==40){
                        domain.setOther(value);
                    }
                }
                excelDomainList.add(domain);
            }
        }

        for (ExcelTeacherDomain e:excelDomainList) {
            excelService.TeacherExcel(e);
            System.out.println(e);
        }

    }


}
