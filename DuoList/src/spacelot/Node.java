package spacelot;

 class Node {
	private String value;
	private Node nextLink;
	private Node randomLink;
	public Node(String value, Node randomLink ){
		this.value=value;
		this.randomLink=randomLink;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public Node getNextLink() {
		return nextLink;
	}
	public void setNextLink(Node nextLink) {
		this.nextLink = nextLink;
	}
	public Node getRandomLink() {
		return randomLink;
	}
	public void setRandomLink(Node randomLink) {
		this.randomLink = randomLink;
	}
	
}
