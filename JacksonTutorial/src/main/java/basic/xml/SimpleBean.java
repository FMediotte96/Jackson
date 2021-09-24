package basic.xml;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.*;

public class SimpleBean {
    private int x = 1;
    private int y = 2;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "SimpleBean{" +
            "x=" + x +
            ", y=" + y +
            '}';
    }

    public static void main(String[] args) throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        //Serialize to XML String
        String xml = xmlMapper.writeValueAsString(new SimpleBean());
        System.out.println(xml);

        //Serialize to XML File
        xmlMapper.writeValue(new File("simple_bean.xml"), new SimpleBean());
        File file = new File("simple_bean.xml");

        //Deserialize from XML String
        SimpleBean value = xmlMapper.readValue(
            "<SimpleBean><x>1</x><y>2</y></SimpleBean>", SimpleBean.class
        );
        System.out.println(value);

        //Deserialize from XML File
        String xmlFromFile = inputStreamToString(new FileInputStream(file));
        SimpleBean valueFromFile = xmlMapper.readValue(xmlFromFile, SimpleBean.class);
        System.out.println(valueFromFile);
    }

    private static String inputStreamToString(InputStream is) throws IOException {
        StringBuilder sb = new StringBuilder();
        String line;
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        br.close();
        return sb.toString();
    }
}
