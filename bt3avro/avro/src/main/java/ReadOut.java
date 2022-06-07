import com.bigdatums.avro.Person;
import org.apache.avro.file.DataFileReader;
import org.apache.avro.io.DatumReader;
import org.apache.avro.specific.SpecificDatumReader;

import java.io.File;
import java.io.IOException;

public class ReadOut {

    public void read() {
        File avroOutput = new File("src/main/resources/person.avro");
        try {
            DatumReader<Person> bdPersonDatumReader = new SpecificDatumReader(Person.class);
            DataFileReader<Person> dataFileReader = new DataFileReader<Person>(avroOutput, bdPersonDatumReader);
            Person p = null;
            while (dataFileReader.hasNext()) {
                p = dataFileReader.next(p);
                System.out.println(p);
            }
        } catch (IOException e) {
            System.out.println("Error reading Avro");
        }
    }
}



