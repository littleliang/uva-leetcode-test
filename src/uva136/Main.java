package uva136;

class Main {

	public static void main(String[] args) {
		int[] num = {2, 3, 5};
		int[] freq = {1, 1, 1};
		int[] res = new int[1501];
		res[1] = 1;
		int count = 2;
		while(count < 1501){
			int min = Integer.MAX_VALUE;
			for(int i = 0; i < 3; i++){
				if(min > num[i] * res[freq[i]]){
					min = num[i] * res[freq[i]];
				}
			}
			for(int i = 0; i < 3; i++){
				if(min == num[i] * res[freq[i]]){
					freq[i]++;
				}
			}
			res[count++] = min;
		}
		System.out.println("The 1500'th ugly number is "+ res[1500] +".");  
		
	}

}