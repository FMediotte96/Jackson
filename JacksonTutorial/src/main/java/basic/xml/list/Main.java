package basic.xml.list;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final String XML = "<Person>" +
        "<firstName>Rohan</firstName>" +
        "<lastName>Daye</lastName>" +
        "<phoneNumbers>" +
        "    <phoneNumbers>9911034731</phoneNumbers>" +
        "    <phoneNumbers>9911033478</phoneNumbers>" +
        "</phoneNumbers>" +
        "<address>" +
        "    <streetName>Name1</streetName>" +
        "    <city>City1</city>" +
        "</address>" +
        "<address>" +
        "    <streetName>Name2</streetName>" +
        "    <city>City2</city>" +
        "</address>" +
        "</Person>";

    public static void main(String[] args) throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        Person person = new Person("Facundo", "Mediotte");

        List<String> phonesNumbers = new ArrayList<>();
        phonesNumbers.add("9911034731");
        phonesNumbers.add("9911033478");
        person.setPhoneNumbers(phonesNumbers);

        List<Address> address = new ArrayList<>();
        address.add(new Address("Name1", "City1"));
        address.add(new Address("Name2", "City2"));
        person.setAddress(address);

        //Serialize List to XML
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        xmlMapper.writeValue(byteArrayOutputStream, person);

        //Deserialize XML to List
        Person valueResult = xmlMapper.readValue(XML, Person.class);
        System.out.println(valueResult);
    }
}
