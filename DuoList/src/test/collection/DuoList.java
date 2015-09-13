package test.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

class Node {
    Node nextLink;
    Node randomLink;
    String value;                 
    //tst
    @Override
    public String toString(){
    	return value+"--> (" + ((nextLink==null) ? nextLink.value : null) + ", "+ ((randomLink==null) ? randomLink.value : null)+")";
    }
}

public class DuoList implements Cloneable {
    private Node firstEl;       
    private Node lastEl;       
 
    
    
    void addToTail(String data) {        
        Node newNode = new Node();   
        newNode.value = data;
        if (lastEl == null)       
        {                         
            firstEl = newNode;               
            lastEl = newNode;
        } else {
            lastEl.nextLink = newNode;        
            lastEl = newNode;         
        }
    }
 
    void fillRandomSecondLinx(){
    	ArrayList<Node> secNodes = new ArrayList<Node>();
    	Node iterNode = firstEl;         
        while (iterNode != null)        
        {
        	secNodes.add(iterNode);
            iterNode = iterNode.nextLink;     
        }
        Random random = new Random();
        iterNode = firstEl;
        while (iterNode != null)         
        {
        	iterNode.randomLink=secNodes.get( random.nextInt(secNodes.size()));
            iterNode = iterNode.nextLink;     
        }

    }
    
    void printList()                
    {
        Node iterNode = firstEl;          
        List<Node> deq= new LinkedList<Node>();
        while (iterNode != null)           
        {
        	deq.add(iterNode.randomLink);
            System.out.print(iterNode.value + " --> "); 
            iterNode = iterNode.nextLink;     
        }

        System.out.println();
        for(int i=0;i<deq.size();i++){
        	System.out.print("|     "); 
        }
        System.out.println();
        for (Node node : deq) {
          	  System.out.print( (node==null) ? "_     " : node.value+ "     "); 
        }
    }
        
    @Override
    public DuoList clone() throws CloneNotSupportedException{
        DuoList list = new DuoList();
        HashMap<Node, Node> copiedNodes = new HashMap<>();
        list.firstEl=copyNode(firstEl,copiedNodes);
        
        return list;
    }
       
    private Node copyNode(Node inpNode, HashMap<Node,Node> copiedNodes){
    	if(inpNode==null){
    		return null;
    	}
    	if(copiedNodes.containsKey(inpNode))
    		return copiedNodes.get(inpNode);
    	Node outNode = new Node();
    	outNode.value=inpNode.value;
    	copiedNodes.put(inpNode, outNode);
    
    	outNode.nextLink = copyNode(inpNode.nextLink,copiedNodes);
    	outNode.randomLink = copyNode(inpNode.randomLink,copiedNodes);
    	
    	return outNode;
    }
}