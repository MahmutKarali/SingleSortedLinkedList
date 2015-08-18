import java.util.Scanner;
import java.*;

class Node
{
    protected int tcNo;
    protected Node link;
 
    public Node()
    {
        link = null;
        tcNo = 0;
    }    
    public Node(int d,Node n)
    {
        tcNo = d;
        link = n;
    }    
    public void setLink(Node n)
    {
        link = n;
    }    
    public void setData(int d)
    {
        tcNo = d;
    }    
    public Node getLink()
    {
        return link;
    }    
    public int getData()
    {
        return tcNo;
    }
}

class LLinkedList
{
    protected Node start;
 
    public LLinkedList()
    {
        start=null;
    }
   
    public void insert(int val)
    {
        Node nptr, ptr, tmp = null;
        nptr = new Node(val, null);
      
        boolean temp = false;
        
		if (start == null)
           start = nptr;
		
        else if (val <= start.getData())
        {
            nptr.setLink(start);
            start = nptr;
        }
        else
        {
            tmp = start;
            ptr = start.getLink();
           
    		while(ptr != null)
            {
                if (val >= tmp.getData() && val <= ptr.getData())
                {
                    tmp.setLink(nptr);
                    nptr.setLink(ptr);
                    
                    temp = true;
                    break;
                }
                else
                {
                    tmp = ptr;
                    ptr = ptr.getLink();
                }
            }
    		
            if (temp == false)
            {
                tmp.setLink(nptr);
            }
        }
    }
	
    public void display()
    {
        System.out.print("Sorted Singly Linked List = ");
        
        Node ptr = start;
        System.out.print(start.getData()+ "->");
        ptr = start.getLink();
       
        while (ptr.getLink() != null) {
            System.out.print(ptr.getData()+ "->");
            ptr = ptr.getLink();
        }
        System.out.print(ptr.getData()+ "\n");
    }
}

public class LinkedList
{
    public static void main(String[] args)
    {             
       Scanner scan = new Scanner(System.in);
       
       LLinkedList list = new LLinkedList(); 
		
	    char ch;
       
        do
        {
            int choice = scan.nextInt();            
           
			System.out.println("Enter integer element to insert");
			list.insert(choice);                     
            
            ch = scan.next().charAt(0);      
        }
		while (ch == 'Y'); 
        
        list.display();
    }
}