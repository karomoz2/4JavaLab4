import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;

import java.io.*;
import java.util.*;


public class ReaderCSV {
    public static void main(String[] args) throws IOException, CsvValidationException {
        ArrayList <Person> personList = new ArrayList<>(); //люди
        FileReader fileReader =new FileReader("src/main/resources/foreign_names.csv");
        CSVParser parser = new CSVParserBuilder()// наш ';' разделитель
                .withSeparator(';')
                .withIgnoreQuotations(true)
                .build();

        CSVReader csvReader = new CSVReaderBuilder(fileReader)
                .withSkipLines(1) //идем на первую строку, потому что на нулевой ненужные данные
                .withCSVParser(parser)
                .build();

        String[] line;
        while ((line = csvReader.readNext()) != null) { //получили массив строк с нужными значения
            int id=Integer.parseInt(line[0]);
            String name=line[1];
            String sex=line[2];
            int day=Integer.parseInt(line[3].split("\\.")[0]);
            int month=Integer.parseInt(line[3].split("\\.")[1]);
            int year=Integer.parseInt(line[3].split("\\.")[2]);

            //Генерация iD'ишников
            String depName=line[4];
            int depId=0;
            idDepartment[] idDep = idDepartment.values();
            for (var item:idDep) {
                if(item.toString().equals(depName))
                {
                    depId=item.ordinal()+1; //Чтобы не было нулевых id
                    break;
                }
            }

            int salary=Integer.parseInt(line[5]);
            personList.add(new Person(id,name,sex,new Department(depId,depName),salary,year,month,day));
        }
        //вывод всех людей
        for (Person person : personList) System.out.println(person);

    }
}
