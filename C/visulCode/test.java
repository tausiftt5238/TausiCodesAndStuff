class test{
	int range = 1;
	void start(){
		for(int i = 0 ; i < range ; i ++)
			System.out.print(i + " ");
		System.out.println("");
		range++;
	}
	public static void main(String args[]){
		test ct = new test();
		for(int i = 1 ; i <= 5; i++){
			ct.start();
		}
	}
}