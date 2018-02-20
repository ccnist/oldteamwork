package csc.learning.project.stepDefinitions;

import com.sun.xml.internal.fastinfoset.util.CharArray;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;


/**
 * Created by cchandragiri on 4/21/2017.
 */
public class Test {

    static Random random = new Random();
    static Logger log = Logger.getLogger(Test.class);

    public static void main(String Args[]) throws IOException {
//        ArrayList<HashMap> value1 = [{duration=2h 10m, depart_time=16:15, arrival_time=18:25, price=Rs.13,894, airline=Air India AI-541}, {duration=2h 25m, depart_time=10:05, arrival_time=12:30, price=Rs.14,352, airline=Vistara UK-830}, {duration=2h 15m, depart_time=16:00, arrival_time=18:15, price=Rs.14,352, airline=Vistara UK-858}, {duration=2h 15m, depart_time=20:00, arrival_time=22:15, price=Rs.14,352, airline=Vistara UK-870}, {duration=2h 20m, depart_time=21:25, arrival_time=23:45, price=Rs.14,436, airline=SpiceJet SG-126}, {duration=2h 20m, depart_time=21:25, arrival_time=23:45, price=Rs.14,480, airline=SpiceJet SG-126}, {duration=2h, depart_time=05:50, arrival_time=07:50, price=Rs.16,900, airline=SpiceJet SG-471}, {duration=2h 20m, depart_time=08:40, arrival_time=11:00, price=Rs.16,900, airline=SpiceJet SG-124}, {duration=2h, depart_time=05:50, arrival_time=07:50, price=Rs.17,112, airline=SpiceJet SG-471}, {duration=2h 20m, depart_time=08:40, arrival_time=11:00, price=Rs.17,112, airline=SpiceJet SG-124}, {duration=2h 15m, depart_time=06:35, arrival_time=08:50, price=Rs.19,622, airline=Air India AI-559}, {duration=2h 25m, depart_time=09:55, arrival_time=12:20, price=Rs.19,622, airline=Air India AI-543}, {duration=2h 15m, depart_time=18:55, arrival_time=21:10, price=Rs.19,622, airline=Air India AI-840}, {duration=2h 15m, depart_time=20:55, arrival_time=23:10, price=Rs.19,622, airline=Air India AI-127}, {duration=2h 15m, depart_time=07:35, arrival_time=09:50, price=Rs.25,272, airline=Jet Airways 9W-644}]
//        ArrayList<HashMap> value2 = [{duration=2h 10m, depart_time=16:15, arrival_time=18:25, price=Rs.13,894, airline=Air India AI-541}, {duration=2h 25m, depart_time=10:05, arrival_time=12:30, price=Rs.14,352, airline=Vistara UK-830}, {duration=2h 15m, depart_time=16:00, arrival_time=18:15, price=Rs.14,352, airline=Vistara UK-858}, {duration=2h 15m, depart_time=20:00, arrival_time=22:15, price=Rs.14,352, airline=Vistara UK-870}, {duration=2h 20m, depart_time=21:25, arrival_time=23:45, price=Rs.14,436, airline=SpiceJet SG-126}, {duration=2h 20m, depart_time=21:25, arrival_time=23:45, price=Rs.14,480, airline=SpiceJet SG-126}, {duration=2h, depart_time=05:50, arrival_time=07:50, price=Rs.16,900, airline=SpiceJet SG-471}, {duration=2h 20m, depart_time=08:40, arrival_time=11:00, price=Rs.16,900, airline=SpiceJet SG-124}, {duration=2h, depart_time=05:50, arrival_time=07:50, price=Rs.17,112, airline=SpiceJet SG-471}, {duration=2h 20m, depart_time=08:40, arrival_time=11:00, price=Rs.17,112, airline=SpiceJet SG-124}, {duration=2h 15m, depart_time=06:35, arrival_time=08:50, price=Rs.19,622, airline=Air India AI-559}, {duration=2h 25m, depart_time=09:55, arrival_time=12:20, price=Rs.19,622, airline=Air India AI-543}, {duration=2h 15m, depart_time=18:55, arrival_time=21:10, price=Rs.19,622, airline=Air India AI-840}, {duration=2h 15m, depart_time=20:55, arrival_time=23:10, price=Rs.19,622, airline=Air India AI-127}, {duration=2h 15m, depart_time=07:35, arrival_time=09:50, price=Rs.25,272, airline=Jet Airways 9W-644}]
        Test test = new Test();
        BasicConfigurator.configure();
        String name = test.enterInput().readLine();
        double h = test.enterInput().read();
        double i = test.enterInput().read();
        double w = test.enterInput().read();
        log.info("BMI Was " + test.BMI(h,i,w));
        test.idleWeightInfo(h,i,w,name);
       // BufferedReader br = new BufferedReader();




        //    test.stacksLearn();
        }

 //   Test test = new Test();
//    Boolean flag = test.palindrom("NURUN");
//    test.gerRandomAlphenumeric();
//    System.out.println(flag);

    //  test.checkValidSymbols();


    public double inMeters(double f, double i)
    {
        double meters = ((f*0.3048) + (i*0.0254));
        return meters;
    }


    public double BMI(double f, double i, double weight)
    {
        double met = inMeters(f,i);
        double bmi = 0.00;
        bmi = (weight/(met*met));
        return bmi;
    }


    public void idleWeightInfo(double height_feet, double height_inch, double weight, String name)
    {

        double bmi = BMI(height_feet,height_inch,weight);
        if(bmi > 35.000){
          log.info(name + " are in problms, please consult doctor immediately");

        }else if(bmi <= 34.999 && bmi >= 30.000){
            log.info(name + " will get problems in soon, please reduce your weight");

        }else if(bmi <= 29.999 && bmi >= 25.000) {
            log.info(name + " Please reduce weight, you are overweight");

        }else if(bmi <= 24.999 && bmi >= 18.500) {
            log.info(name + ", KEEP IT UP");
        } else if(bmi <= 18.500){
            log.info(name + ", Eat some thing good, you are under weight");
        }
        log.info(name + " Idle weight was " +idleWeight(height_feet, height_inch, weight));
        log.info(name + " you can reduce in next " + (weight-idleWeight(height_feet,height_inch,weight))/4 + " months");
    }


    private double idleWeight(double height_feet, double height_inch, double weight){
        double idlew = 0;
        double idleBMI = 20.000;
        double metets = inMeters(height_feet, height_inch);
        idlew = (metets*metets) * 20.0000;
        return idlew;
    }



    public boolean palindrom(Object obj)
    {
        boolean flag  = false;
        String palindrom_obj =  null;
        StringBuffer sb = new StringBuffer();
        System.out.println("Given input is type of " + obj.getClass());
        palindrom_obj = obj.toString();
        String new_obj = palindrom_obj;
        if(obj instanceof String)
        {
            System.out.println("No need to convert as it is was String only , Enjoy");
        }else if(obj instanceof Integer)
        {
            System.out.println("Lets convert this Integer to String....");
            obj =  String.valueOf(obj);
        }else
        {
            System.out.println("invalid input " + obj.toString());
        }
          for(int i = new_obj.length() ; i > 0; i -- )
          {
              sb = sb.append(new_obj.charAt(i-1));
          }
           if((sb.toString().equals(palindrom_obj))){
              flag = true;
           }
            System.out.println("Given Object ::" + palindrom_obj);
            System.out.println("Palindrom Value::" + sb);
            if((sb.toString().equals(palindrom_obj))){
                flag = true;
            }
     return flag;
   }


    public String gerRandomAlphenumeric()
    {

        String digits = "0123456789";
        String caps = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String small = "abcdefghijklmnopqrstuvwxyz";
        StringBuffer sb = new StringBuffer();
        int num = random.nextInt(9999) + 1000;

        System.out.println(num);
        return sb.toString();
    }


    public void checkValidSymbols() throws IOException {
         log.info("Please give input: -");
         StringBuffer sb = new StringBuffer();
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         String symbols = br.readLine();
         log.info("Symbols are: " + symbols);
         results(symbols);
    }

    public boolean results(String sym)
    {
        boolean flag =  false;
        int position = 0;
        StringBuffer sb = new StringBuffer(sym);
        log.info("Symbols are : " + sb + "and Length was : " + sb.length());
        if(sym.length()%2 !=0)
        {
            log.info("Given Input value is invalid");
        }else{
            String opening[] = {"{","(","["};
            String closed[] = {"}",")","]"};

            for(int i =0 ; i > sym.length()-1; i++)
            {
                Character a = sb.charAt(i);
                if(a.equals(opening[i]))
                {
                    position = i;
                }
                for(int j =  position+1 ; j > sym.length()-1; j++) {

                }
            }
            log.info("Given Input value is valid");
            flag = true;
        }
        return flag;
    }

    public BufferedReader enterInput() throws IOException {
        StringBuffer sb = new StringBuffer();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return br;
    }

//
//    public void stacksLearn() {
//        Stack<String> strs = new Stack<>();
//
//
//         strs.push(input);
//        if(input.length()>30){
//            log.info("Length is exceeeded");
//            strs.pop();
//        }else
//        {
//            log.info(strs);
//        }
 //   }

}
