
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
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
        BufferedReader reader = Files.newBufferedReader(Paths.get("C:\\WorkSpaceSm-Soft\\SYKABLYAT\\SomeExample\\src\\main\\java\\json\\Stats.json"));

        Object obj = new JSONParser().parse(reader);




        JSONParser parser = new JSONParser();

        JSONArray a = (JSONArray) obj;











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


            JSONObject jo = (JSONObject) ((JSONArray) obj).get(i);

            JSONObject authorName = (JSONObject) jo.get("author");

            Object test = authorName.get("name");


            System.out.println(test);


            JSONObject stats = (JSONObject) a.get(i);



            Row someRow = someStats.createRow(i + 1);
            someStats.autoSizeColumn(0);
            someStats.autoSizeColumn(1);
            someStats.autoSizeColumn(2);
            someStats.autoSizeColumn(3);

            someRow.createCell(0).setCellValue((Long) stats.get("id"));
            someRow.createCell(1).setCellValue((String) stats.get("title"));
            someRow.createCell(2).setCellValue((String) stats.get("updated_at"));
            someRow.createCell(3).setCellValue( (String) authorName.get("name") ) ;







        }

        File file = new File("C:/demo/Stats.xls");
        file.getParentFile().mkdirs();

        FileOutputStream outFile = new FileOutputStream(file);
        workbook.write(outFile);



        System.out.println("Created file: " + file.getAbsolutePath());

    }

}



