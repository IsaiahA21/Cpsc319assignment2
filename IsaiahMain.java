//Using Winscp
/**
 *  doubly linked list
 * @author: Isaiah Asaolu
 * @course: CPSC 319
 */
import java.io.*;
import java.util.*;

public class IsaiahMain {
    Node head;

    static class Node{
        private String data;
        private Node next;
        private Node prev;
            
        Node(String d){
            this.data = d;
            this.next = null;
            this.prev = null;
        }
    }
    // this finds the last node in the list
    Node lastNode(Node node){

        while(node.next!=null)
            node = node.next;
            System.out.println("Last node is "+ node.data);
        return node;
    }

    Node intoTwo(Node l,Node h){
        // set pivot as h element
        String x = h.data;
        Node i = l.prev;
        checkList(l);

        for(Node j=l; j!=h; j=j.next){
            try{
            if(Double.parseDouble(j.data)<= Double.parseDouble(x)){
                if (i == null){
                    i = l;
                }
                else{
                    i = i.next;
                }
                String temp = i.data;
                i.data = j.data;
                j.data = temp;
            } 
        }
            catch(NumberFormatException e){
                System.out.println("caught" + j.data);
            }
        }
        if (i == null){
            i = l;
        }
        else{
            i = i.next;
        }
        String temp = i.data;
        i.data = h.data;
        h.data = temp;
        return i;
    }
        // recursive  quicksort for linked list
        void recursiveSort(Node l,Node h){
            if(h!=null && l!=h && l!=h.next){
                Node temp = intoTwo(l,h);
                recursiveSort(l,temp.prev);
                recursiveSort(temp.next,h);
            }
        }

    // The main function to sort a linked list. It mainly calls _quickSort()
    public void quickSort(Node node){

        Node last = lastNode(node);

        // Call the recursive QuickSort
        recursiveSort(node,last);
        correctList(head);
    }

    //will checks the list for allowed special characters
    public static void checkList(Node head){
               while(head!=null){
            if (head.data.equals("666")){
                head.data = "3.2";
            }
            else if (head.data.equals("Do")){
                head.data = "0.5";
            }
            else if(head.data.equals("Re")){
                head.data = "100.5";
            } 
            else if(head.data.equals("Mi")){
                head.data = "1000.5";
            } 
            else if(head.data.equals("&")){
                head.data = "3.5";
            }
            else if(head.data.equals("@")){
                head.data = "3.2";
            }
            else if(head.data.equals("%")){
                head.data = "1005000.5";
            }
            else if(head.data.length() > 15){
                head.data = "55.5";
            }   
            else if(head.data.equals("$")){
                head.data = "20.5";
            }
            else if(head.data.equals("Fa")){
                head.data = "15.5";
            }
            else if(head.data.equals("One")){
                head.data = "103.5";
            }
            else if(head.data.equals("Three")){
                head.data = "103.8";
            }
            else if(head.data.equals("Two")){
                head.data = "103.6";
            }
            head = head.next;
        }
    }

    public static boolean checkSymbol(String data){
        
        if (data.equals("Do")) {
            return true;
        } else if (data.equals("Re")) {
            return true;

        } else if (data.equals("Mi")){
            return true;
        } else if (data.equals("Fa")){
            return true;
        } else if( data.equals("@") ){
            return true;
        }
        else if (data.equals("$")){
            return true;
        } else if (data.equals("%")) {
            return true;
        } else if (data.equals("&")) {
            return true;
        } else if (data.equals("One")) {
            return true;
        } else if ( data.equals("Two") ){
            return true;
        }
        else if (data.equals("Three")) {
            return true;
        } 
        else if ( data.equals("Asymbolwithareallylongname")){
                return true;
        }

        else{
            return false;
        }
    }

    public static void correctList(Node head){
        while(head != null){
            if (head.data == "0.5"){
                head.data = "Do";
            }
            else if(head.data == "103.6"){
                head.data = "Two";
            }
            else if(head.data == "100.5"){
                head.data = "Re";
            } 
            else if(head.data == "1000.5"){
                head.data = "Mi";
            } 
            else if(head.data == "3.5"){
                head.data = "&";
            }
            else if(head.data == "55.5"){
                head.data = "Asymbolwithareallylongname";
            } 
            else if(head.data == "15.5"){
                head.data = "Fa";
            }
            else if(head.data == "1005000.5"){
                head.data = "%";
            }
            else if(head.data == "20.5"){
                head.data = "$";
            }
            else if(head.data == "103.5"){
                head.data = "One";
            }
            else if(head.data == "3.2"){
                head.data = "@";
            }
            else if(head.data == "103.8"){
                head.data = "Three";
            }

            head = head.next;
        }
    }
        /* Function to insert a node at the beginning of the Doubly Linked List */
    void push(String new_Data){
        Node new_Node = new Node(new_Data);
            
            System.out.println("pushing [" + new_Data + "]");
        // if head is null, head = new_Node
        if(head==null){
            head = new_Node;
            return;
        }    
        new_Node.next = head;
        head.prev = new_Node;
        //since we are adding at the beginning, prev is always NULL
        new_Node.prev = null;
        head = new_Node;

    }
    // checking if the input is a really number
    public static boolean checkNatural(String inp){
		//handles the empty push exception
		if (inp.length()== 0){
			return false;
		}
		//checsk if first element is  zero  
		 if (inp.charAt(0) == '0' && inp.length()>1 ){
			return false;
		}
        if (inp.charAt(0)== '-') {
			return false;
        }

		//checks if the string can be parsed to an integer
		try{
			Integer.parseInt(inp);
			return  true;

		} catch(NumberFormatException e){
			return false;
		}

		
	}

        public void printlist(Node node)
    {
        Node last = null;
 
        while (node != null) {
            System.out.print("["+node.data + "] ");
            last = node;
            node = node.next;
        }
 
        System.out.println();
    }


public static void main(String[] args)throws IOException{
        IsaiahMain list = new IsaiahMain();
        File inputFile;
        File outputFile;
        FileWriter writer =null;
        Scanner readerScanner =null;
        boolean decending = true;
        String readData =null;
        int count =0;
        int delLocation =1;

        try {

			 outputFile = new File(args[1]);
			 inputFile = new File(args[0]);

             readerScanner = new Scanner(inputFile);
			 writer = new FileWriter(outputFile);



            // reading the file
            while (readerScanner.hasNextLine()) {

                 readData = readerScanner.nextLine();
                count++;
                if (checkSymbol(readData) && count ==1  || (count ==1 && readData.equals("666"))) {
                    System.out.println("working for " + readData + " and " + count);

                    list.push("0");
                    System.out.println("first input is the symbol " + readData);
                }
                if(readData.equals("666") && decending == true){
                    decending = false;
                }

                else if (readData.equals("666") && decending == false){
                    continue;
                }

                //check if it's a natural number and also checks if anything is in the input file
                else if (!checkNatural(readData)){
                    if (checkSymbol(readData)){
                        //System.out.print(data + " is a good symbol\n");
                    }
                    else{
                        System.out.println("error can't put " + readData);
                        writer.write("Input error.");
                        readerScanner.close();
			            writer.close();
                        System.exit(0);
                    }
                }
                list.push(readData);
            }

            list.quickSort(list.head);
            System.out.println(decending);

            list.printlist(list.head);

if (list.head.data == "0"){
System.out.println("head.next is " + list.head.next.data);
list.head = list.head.next;
System.out.println("head.next is " + list.head.next.data);

list.head.prev =null;
}
            
            //list.head = move;
            System.out.println("yes, not writing the empty line ");

            list.printlist(list.head);

            if (decending){
                list.head = list.lastNode(list.head);
                while(list.head != null){
                    System.out.println("inside descending "+ list.head.data);
                    writer.write(list.head.data);
                    if(list.head.prev != null){
                    writer.write("\n");
                    }
                list.head = list.head.prev;
                }
            }
            else if(!decending){
                while(list.head != null){
                writer.write(list.head.data );
                if(list.head.next != null){
                    writer.write("\n");
                    }
                list.head = list.head.next;
                }
            }

        }
        catch (FileNotFoundException e) {
			System.out.println("Your file wasn't found");
		}   
        catch (NullPointerException e) {
            System.out.println("you ain't got any input");
        }
        finally {
            readerScanner.close();
			writer.close();
        }
    }

}
