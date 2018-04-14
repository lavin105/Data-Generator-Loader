import java.io.*;
import java.text.DecimalFormat;
import java.util.Random;
import org.fluttercode.datafactory.impl.DataFactory;


public class Generator {
   private Random num=new Random();

    private DecimalFormat formatter = new DecimalFormat("0");
    private String fileName;
    private int tuple;

    public Generator(String _fileName, int _tuple){
        fileName=_fileName;
        tuple=_tuple;
    }

    public void generateData(){
        try{
            DataFactory df = new DataFactory();
            PrintWriter pw=new PrintWriter(new File(fileName));
            StringBuilder s=new StringBuilder();

            s.append("First");
            s.append(',');
            s.append("Last");
            s.append(',');
            s.append("SSN");
            s.append(',');
            s.append("Email");
            s.append(',');
            s.append("Business Name");
            s.append(',');
            s.append("Business Address");
            s.append(',');
            s.append("Business City");
            s.append(',');
            s.append("Address");
            s.append(',');
            s.append("Address City");
            s.append(',');
            s.append("Hobby");
            s.append("\n");
            String[] hobby={"Golf", "Surfing", "Soccer", "Running", "Swimming", "Football", "Basketball", "Fishing", "Hunting"};

            for (int i = 0; i < tuple; i++) {
                double number=100000000+num.nextInt(999999990);

                s.append(df.getFirstName());
                s.append(',');
                s.append(df.getLastName());
                s.append(',');
                s.append(formatter.format(number));
                s.append(',');
                s.append(df.getEmailAddress());
                s.append(',');
                s.append(df.getBusinessName());
                s.append(',');
                s.append(df.getAddress());
                s.append(',');
                s.append(df.getCity());
                s.append(',');
                s.append(df.getAddress());
                s.append(',');
                s.append(df.getCity());
                s.append(',');
                s.append(df.getItem(hobby));
                s.append("\n");
            }

            pw.write(s.toString());
            pw.close();

        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }



}
