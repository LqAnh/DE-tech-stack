import com.bigdatums.avro.Person;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.specific.SpecificDatumWriter;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WriteIn {
    public void main(Person[] args) {
        List<Person> input = new ArrayList<>(Arrays.asList(args));

        File avroOutput = new File("src/main/resources/person.avro");
        try {
            DatumWriter<Person> bdPersonDatumWriter = new SpecificDatumWriter<Person>(Person.class);
            DataFileWriter<Person> dataFileWriter = new DataFileWriter<Person>(bdPersonDatumWriter);
            dataFileWriter.create(input.get(0).getSchema(), avroOutput);
            for (Person p : input) {
                dataFileWriter.append(p);
            }
            dataFileWriter.close();
        } catch (IOException e) {
            System.out.println("Error writing Avro");
        }
    }
}
