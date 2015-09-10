package spacelot;
 
public class DuoList implements BidirectionalList{

	private Node firstNode;

	private Node lastNode;
	
	private int size;

	@Override
	public void add(String value, Node randomLink){
	
		Node newNode = new Node(value, randomLink);
		if(firstNode==null){
			lastNode=firstNode=newNode;
		}
		else{
			lastNode.setNextLink(newNode);
		}
		size++;
	}

	@Override
	public boolean remove(String value) {
		Node iterNode = firstNode;
		
		if(size>0)
		while (iterNode.getNextLink()!=null) {
			if(value==iterNode.getValue()){
				
			}
			iterNode=iterNode.getNextLink();
		}
				
		return false;
	}

	public int size() {
		return size;
	}
	
	
	
}
