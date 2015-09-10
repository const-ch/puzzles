package test.collection;


public class TestList{

	public static void main(String[] argv){
	DuoList l = new DuoList();
		l.addToTail(1+"");
		l.addToTail(2+"");
		l.addToTail(3+"");
		l.addToTail(4+"");
		l.addToTail(5+"");
		l.fillRandomSecondLinx();

		l.printList();
		System.out.println();
		System.out.println();
		System.out.println();
		DuoList dl=null;
		try{
			dl = l.clone();
		}catch(Exception e){}
		dl.printList();
		
		l.addToTail(9+"");
		System.out.println();
		System.out.println("----------------");
		System.out.println("after copiyng");
		System.out.println();
		l.printList();
		System.out.println();
		System.out.println();
		dl.printList();
	}
	
}
