import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import javax.swing.text.html.HTMLDocument;
import javax.xml.crypto.NodeSetData;
import java.awt.print.Book;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by cchandragiri on 5/8/2017.
 */
public class CollectionLearning extends Thread
{


//    Node<String> prev = null;
//    Node<Integer> cur = head;


    public void run() {

        for(int i=0; i < 10 ; i++){
            try{Thread.sleep(1000);}catch (Exception e){}
            System.out.println(i);
        }

    }
    Logger log = Logger.getLogger(CollectionLearning.class);
    public static void main(String Args[]) throws InterruptedException {
        BasicConfigurator.configure();
        CollectionLearning cl = new CollectionLearning();
        CollectionLearning cl2 = new CollectionLearning();
//        cl. ArrayListLearn();
//        cl.LinkedListLearn();
        cl.start();
        cl2.start();
    }







    public void ArrayListBasic()
    {

        List<String> als = new ArrayList<>();
        als.add("Chandrasekhar Ch");
        als.add("Malathi Ch");
        als.add("Thushaarkiran Ch");
        als.add("KarthikeyanSrinivas Ch");
        log.info(als);
        List<String> nals = new ArrayList<>();
        nals.add("Madhu");
        als.addAll(nals);
        log.info(als);
        String to_remove = "Malathi Ch";
     //   als.remove(to_remove);
        for(String a : als)
        {
            log.info(a);
        }
        do
        {
           als.remove(als.size()-1);

        }while (als.iterator().hasNext());

      log.info(als + " Cleared");
    }

    public void LinkedListLearn()
    {
        LinkedList<Integer> ls = new LinkedList<>();
        long startTime = System.nanoTime();
        for(int i=0; i <= 100000; i ++)
        {
         ls.add(i);
        }
        long endTime = System.nanoTime();
        log.info(startTime-endTime + " Time taken in Linked List");
        startTime = System.nanoTime();
        for(int i=0; i < ls.size()-1; i ++)
        {
            ls.get(i);
        }
        endTime = System.nanoTime();
        log.info(startTime-endTime + " Time taken in Linked List to read");
    }

    public void ArrayListLearn() {
        ArrayList<Integer> ls = new ArrayList<>();
        long startTime = System.nanoTime();
        for (int i = 0; i <= 100000; i++) {
            ls.add(i);
        }
        long endTime = System.nanoTime();
        log.info(startTime - endTime + " Time taken in Array List");
        startTime = System.nanoTime();
        for(int i=0; i < ls.size()-1; i ++)
        {
            ls.get(i);
        }
        endTime = System.nanoTime();
        log.info(startTime-endTime + " Time taken in Array List  to read");
    }
}
