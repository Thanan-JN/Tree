public class Tree{
	Object[] array;
	
	public Tree(){
		array = new Object[128];
	}
	
	public boolean empty(){
		return (array[1] == null);
	}
	
	public int left(int i){
		return 2*i;
	}
	
	public int right(int i){
		return 2*i + 1;
	}
	
	public int parent(int i){
		return i/2;
	}
	
	public Object getCargo(int i){
		if(i<1 || i>=array.length){
			return null;
		}
		return array[i];
	}
	
	public void setCargo(int i,Object obj){
		if(i<1 || i>=array.length){
			return;
		}else if(i == 1){
			array[i] = obj;
		}else if(array[i/2] == null){
			return;
		}else{
			array[i] = obj;
		}
	}
	
	public void printPreorder(int i){
		if (getCargo(i) == null){
			return;
		}
		System.out.println (getCargo(i));
		printPreorder(left (i));
		printPreorder(right (i));
	}
	
	public void printInorder(int i){
		if (getCargo(i) == null){
			return;
		}
		printPreorder(left (i));
		System.out.println (getCargo(i));
		printPreorder(right (i));
	}
	
	public void printPostorder(int i){
		if (getCargo(i) == null){
			return;
		}
		printPreorder(left (i));
		printPreorder(right (i));
		System.out.println (getCargo(i));
	}
}

class testTree{
	public static void main(String []args){
		
		Tree tree1 = new Tree();
		int root=1;
		
		tree1.setCargo(root,"root");
		tree1.setCargo(tree1.left(root),"index 2");
		tree1.setCargo(tree1.right(root),"index 3");
		tree1.setCargo(tree1.left(2),"index 4");
		tree1.setCargo(tree1.right(2),"index 5");
		tree1.setCargo(tree1.left(3),"index 6");
		tree1.setCargo(tree1.right(3),"index 7");
		
		System.out.println("Pre:");
		tree1.printPreorder(1);
		System.out.println();
		System.out.println("In:");
		tree1.printInorder(1);
		System.out.println();
		System.out.println("Post:");
		tree1.printPostorder(1);
	}
}