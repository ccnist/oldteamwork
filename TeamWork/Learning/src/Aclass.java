import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.spi.Configurator;

import javax.security.auth.login.Configuration;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by cchandragiri on 5/4/2017.
 *
 */
public class Aclass extends Generic {


    public static void main(String Args[]) throws IOException {
       Aclass ac = new Aclass();
       String name1 = ac.user_input();
       String name2 = ac.user_input();
        BasicConfigurator.configure();
       log.info(ac.flames(name1,name2));
//       for(int i = 0; i < 100 ; i = i+2){
//           int diff = ((i+2)*(i+2)) - (i*i);
//        //   System.out.println(diff);
//           if( diff == 84 ){
//               System.out.println(i);
//               System.out.println(i+2);
//               break;
//           }






    }



    public String flames(String name_1, String name_2)
    {
        StringBuilder name1 = new StringBuilder(name_1);
        StringBuilder name2 = new StringBuilder(name_2);
        Character[] letters = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        System.out.println("Validating");
        int i = name1.length();
        int j = name2.length();
        ArrayList<Character> non_matching = new ArrayList<>();
        do{
            int m = 0;
            char nf = name1.charAt(m);
            for (int n = 0 ; n < j-1; n++){
              if(result(nf,name2.charAt(n))){
                  name1.deleteCharAt(m);
                  name2.deleteCharAt(n);
              }
              }
       //     if(non_matching.add(name1.charAt(m));
            name1.deleteCharAt(m);

        }while (i > 0);





//
//        for (int i=0; i < name1.length()-1 ; i++){
//            m = name1.charAt(i);
//          for(int j =0; j < name2.length()-1; j ++){
//             if(result(m,name2.charAt(j))){
//                name1.deleteCharAt(i);
//                name2.deleteCharAt(j);
//            }
//         }
//        }
        log.info(non_matching);
        log.info(name2);
        return name1.toString();
    }


     public boolean result(char a, char b){
        boolean flag = false;
        if(Character.toLowerCase(a) == Character.toLowerCase(b)){
            flag = true;
        }
        return flag;
     }

}
