/**
   * valjda ovako
   */
class LinkedListDeque<blabla>{
	
	public class blaNode{
		public blabla item;
		public blaNode next;
		public blaNode prev;
		public blaNode(blabla item, blaNode prev, blaNode next){
			this.item = item;
			this.next = next;
			this.prev = prev;
		}
	}
	public blaNode sentinel;
	public LinkedListDeque(){
		size = 0;
		sentinel = new blaNode(null, null, null);
		sentinel.next = sentinel;
		sentinel.prev = sentinel;
	}
//	public Item getRecursive(int index){}
	int size;
	public void addFirst(blabla item){
		if (size == 0){
			blaNode first = new blaNode(item, sentinel, sentinel);
			sentinel.next = first;
			sentinel.prev = first;
			size = 1;
		}
		else {
			blaNode curFirst = sentinel.next;
			blaNode newFirst = new blaNode(item, sentinel, curFirst);
			sentinel.next = newFirst;
			curFirst.prev = newFirst;
			size += 1;
		}

	}
	public void addLast(blabla item){
		blaNode curLast = sentinel.prev;
		blaNode newLast = new blaNode(item, curLast,sentinel);
		sentinel.prev = newLast;
		curLast.next = newLast;
		size += 1;
	}
	public boolean isEmpty(){
		return this.size == 0;
	}
	public int size(){
		return this.size;
	}
	public void printDeque(){
		blaNode start = sentinel.next;
		while (start != sentinel){
			System.out.print(start.item + " ");
			start = start.next;
		}
	}
	public blabla removeFirst(){
		blabla first = null;
		if (size == 1){
			first = sentinel.next.item;
			sentinel.next = sentinel;
			sentinel.prev = sentinel;
			size =0;		
		}
		else if (size > 1){
			first = sentinel.next.item;
			sentinel.next = sentinel.next.next;
			sentinel.next.next.prev = sentinel;
			size -= 1;
		}
		return first;
	}
	public blabla removeLast(){
		blabla last = null;
		if (size == 1){
			last = sentinel.prev.item;
			sentinel.next = sentinel;
			sentinel.prev = sentinel;
			size = 0;
		}
		else if (size > 1){
			last = sentinel.prev.item;
			sentinel.prev.prev.next = sentinel;
			sentinel.prev.next = null;
			sentinel.prev = sentinel.prev.prev;
			size -= 1;
		}
		return last;
	}
	public blabla get(int index){
		blaNode pnt;
		if (size == 0 || size < index){return null;}
		else{
			pnt = sentinel.next;
			for (int i = 0; i < index; i++){
				pnt = pnt.next;
			}
		}

		return pnt.item;
	}

}