package online;

public class CheckBST {
				public static void main(String[] args) {
					Node root = new Node(3);  
				    root.left = new Node(2);  
				    root.right = new Node(5);  
				    root.left.left = new Node(1);  
				    root.left.right = new Node(4);  
				  
				    if (isBST(root,null,null))  
				        System.out.print("Is BST");  
				    else
				        System.out.print("Not a BST");  
				} 
				
				
static class Node{
	int data;
	Node right, left;
	Node(int key)
	{
		this.data=key;
		this.right=this.left=null;
	}
}

static boolean isBST(Node root,Node l,Node r)
{
	if(root==null)
	{
		return true;
	}
	else if(l!=null && l.data>=root.data)
		return false;
	else if(r!=null && r.data<=root.data)
		return false;
	
 return isBST(root.left,l,root)&&
  isBST(root.right,root,r);
}



}



