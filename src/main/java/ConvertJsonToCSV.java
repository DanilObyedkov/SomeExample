
import java.io.*;
import java.util.*;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
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

        JSONArray a = (JSONArray) parser.parse(new FileReader("C:\\WorkSpaceSm-Soft\\SYKABLYAT\\SomeExample\\src\\main\\java\\json\\Stats.json"));


     //   JSONObject jsonObject = (JSONObject) a;




        Shema shema = new Shema();


      //  DeseralizetPOJO deseralizetPOJO;


        Cell cell;
        Row row;
        HSSFWorkbook workbook = new HSSFWorkbook();
        Sheet someStats = workbook.createSheet("Stats");


        Row titleRow = someStats.createRow(0);



        HSSFCellStyle style = createStyleForTitle(workbook);


        cell = titleRow.createCell(0, CellType.STRING);
        cell.setCellValue("ID");
        cell.setCellStyle(style);

        cell = titleRow.createCell(1, CellType.STRING);
        cell.setCellValue("TITLE");
        cell.setCellStyle(style);

        cell = titleRow.createCell(2, CellType.STRING);
        cell.setCellValue("UPDATE");
        cell.setCellStyle(style);

        cell = titleRow.createCell(3, CellType.STRING);
        cell.setCellValue("NAME");
        cell.setCellStyle(style);





        for (int i=0; i<a.size(); i++) {
            JSONObject stats = (JSONObject) a.get(i);

        //   JSONArray sometest = (JSONArray) a.get("closed_by");

           // JSONArray authorName = (JSONArray) stats.get("closed_by");


            Row someRow = someStats.createRow(i + 1);
            someStats.autoSizeColumn(0);
            someStats.autoSizeColumn(1);
            someStats.autoSizeColumn(2);
            someStats.autoSizeColumn(3);

            someRow.createCell(0).setCellValue((Long) stats.get("id"));
            someRow.createCell(1).setCellValue((String) stats.get("title"));
            someRow.createCell(2).setCellValue((String) stats.get("updated_at"));
            someRow.createCell(4).setCellValue((String) stats.get("name"));
            //someRow.createCell(0).setCellValue("");






        }
        File file = new File("C:/demo/Stats.xls");
        file.getParentFile().mkdirs();

        FileOutputStream outFile = new FileOutputStream(file);
        workbook.write(outFile);
        System.out.println("Created file: " + file.getAbsolutePath());

    }

}



