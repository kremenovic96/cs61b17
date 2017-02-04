public class ArrayDeque<blabla>{
	private int size;
	private blabla[] items;
	private int nextFirst;
	private int nextLast;
	private static double ratio = 1/4;
	private static int FACTOR = 2;
/**
  *Constructor for ArrayDeuqe class
  */
		public ArrayDeque(){
			size = 0;
			items = (blabla[]) new Object[8];
			nextFirst = 4;
			nextLast = 5;
		}
/**
  *End of constructor for this class
  */
	public void resize(int size){
		private blabla[] nova = (blabla[]) new Object[size];
		System.arraycopy(items,0,nova,0,size());
		items = nova;
		nextFirst = items.length - 1;
		nextLast = nextFirst + size + 1;
	}
	public void addFirst(blabla item){
		items[nextFirst] = item;
		if (nextFirst == 0){
			nextFirst = items.length - 1;
		}
		else{nextFirst--;}

	}	
	public void addLast(blabla item){
		items[nextLast] = item;
		if(nextLast == items.length - 1){
			nextLast = 0;
		}
		else{nextLast++;}

	}
	public boolean isEmpty(){
		return size == 0;
	}
	public int size(){
		return size;
	}
	public void printDeque(){
		for(int i = 0; i < items.length; i++){
			System.out.print(items[i] + " ");
		}

	}
	public blabla removeFirst(){
		if(nextFirst == items.length - 1){
			nextFirst = 0;
		}
		else{
			nextFirst++;
		}
		blabla first = items[nextFirst];
		items[nextFirst] = null;
		return first;
	}
	public blabla removeLast(){
		if(nextLast == 0){
			nextLast = items.length -1;
		}
		else{
			nextLast--;
		}
		blabla last = items[nextLast];
		items[nextLast] = null;
		return last;		

	}
	public blabla get(int index){
		return items[index];
	}



}
