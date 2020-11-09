
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ConvertJsonToCSV {

    private static HSSFCellStyle createStyleForTitle(HSSFWorkbook workbook) {
        HSSFFont font = workbook.createFont();
        font.setBold(true);
        HSSFCellStyle style = workbook.createCellStyle();
        style.setFont(font);
        return style;
    }

    public static void main(String[] args) throws IOException, ParseException {

        JSONParser parser = new JSONParser();

        JSONArray a = (JSONArray) parser.parse(new FileReader("H:\\ExeleExample\\src\\main\\java\\json\\Stats.json"));

        Shema shema = new Shema();




        Cell cell;
        Row row;
        HSSFWorkbook workbook = null;
        for (Object o : a) {
            JSONObject person = (JSONObject) o;

            shema.setId((Long) person.get("id"));
            System.out.println(shema.getId());

            shema.setTitle((String) person.get("title"));
            System.out.println(shema.getTitle());

            shema.setUpdate_At((String) person.get("updated_at"));
            System.out.println(shema.getUpdate_At());



            for (int rownum = 0; rownum<a.size(); rownum++) {
                workbook = new HSSFWorkbook();
                HSSFSheet sheet = workbook.createSheet("Employees sheet");


                //
                HSSFCellStyle style = createStyleForTitle(workbook);

                row = sheet.createRow(rownum);

                // EmpNo
                cell = row.createCell(0, CellType.STRING);
                cell.setCellValue("ID");
                cell.setCellStyle(style);
                // EmpName
                cell = row.createCell(1, CellType.STRING);
                cell.setCellValue("TITLE");
                cell.setCellStyle(style);
                // Salary
                cell = row.createCell(2, CellType.STRING);
                cell.setCellValue("UPDATE");
                cell.setCellStyle(style);
                // Grade
                cell = row.createCell(3, CellType.STRING);
                cell.setCellValue("Grade");
                cell.setCellStyle(style);

                // Data


                row = sheet.createRow(rownum);

                cell = row.createCell(0, CellType.STRING);
                cell.setCellValue((Long) person.get("id"));

                cell = row.createCell(1, CellType.STRING);
                cell.setCellValue(shema.getUpdate_At());

                cell = row.createCell(2, CellType.STRING);
                cell.setCellValue((String) person.get("updated_at"));

            }

        }
        File file = new File("C:/demo/Stats.xls");
        file.getParentFile().mkdirs();

        FileOutputStream outFile = new FileOutputStream(file);
        workbook.write(outFile);
        System.out.println("Created file: " + file.getAbsolutePath());

    }

        }



