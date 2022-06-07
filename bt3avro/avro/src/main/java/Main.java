import com.bigdatums.avro.Person;
import com.bigdatums.avro.Address;
import org.apache.avro.file.DataFileReader;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.io.DatumReader;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.specific.SpecificDatumReader;
import org.apache.avro.specific.SpecificDatumWriter;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        WriteIn writeIn1 = new WriteIn();
        ReadOut readOut = new ReadOut();

        //create person 1
        Person p1 = new Person();
        p1.setId(1);
        p1.setUsername("anhlq");
        p1.setEmailAddress("anhlq36");
        p1.setPhoneNumber("124553");
        p1.setSex("male");
        Address addressp1 = new Address();
        addressp1.setCity("Ha Noi");
        addressp1.setStreetaddress("Pham Hung");
        p1.setAddress(addressp1);

        //create person 2
        Person p2 = new Person();
        p2.setId(2);
        p2.setUsername("ye");
        Address addressp2 = new Address();
        addressp2.setCity("Ha Noi");
        addressp2.setStreetaddress("Nguyen Trai");
        p2.setAddress(addressp2);

        //write person1 and person2 to avro
        writeIn1.main(new Person[]{p1, p2});

        // read from avro
        readOut.read();
    }

}
