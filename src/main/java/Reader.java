import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class Reader {



        public  static String SomeTest(JSONParser string) {

        JSONParser parser = new JSONParser();

            JSONArray a = null;
            try {
                a = (JSONArray) parser.parse(new FileReader("H:\\ExeleExample\\src\\main\\java\\json\\Stats.json"));
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            }

            Shema shema = new Shema();


        for (Object o : a) {

            {
                JSONObject person = (JSONObject) o;

                shema.setId((Long) person.get("id"));
                System.out.println(shema.getId());

                shema.setTitle((String) person.get("title"));
                System.out.println(shema.getTitle());

                shema.setUpdate_At((String) person.get("updated_at"));
                System.out.println(shema.getUpdate_At());

            }


        }
        return shema.getTitle();

        }

}