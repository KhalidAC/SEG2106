import java.util.Scanner;

 
public class Main {
	
	


	public static void main(String[] args) {
		
	       
		    int n = 0; 
	        try (Scanner s=new Scanner(System.in)) {
	        	while (true){
	        		System.out.println("Enter the number of Queens :");
	        		n = s.nextInt();
	        		if ( n == 2 || n ==3) {
	        			System.out.println("No Solution possible for "+ n +" Queens. Please enter another number");
	        		}
	        		else
	        			break;
	        	}
	        }
	        long timestamp1 = System.currentTimeMillis();
	        
	        System.out.println("Solution to "+ n +" queens using hill climbing search:");
	        
	        HillClimbingSearch hcs = new HillClimbingSearch(n);
			HillClimbingSearch hcsTwo = new HillClimbingSearch(n);
			HillClimbingSearch hcsThree = new HillClimbingSearch(n);
			HillClimbingSearch hcsFour = new HillClimbingSearch(n);
	        
	        hcs.run();

			ThreadGroup threadSearch = new ThreadGroup("GroupSearch");

			Thread thread1 = new Thread(threadSearch, hcs, "searchOne");
			Thread thread2 = new Thread(threadSearch, hcsTwo, "searchTwo");
			Thread thread3 = new Thread(threadSearch, hcsThree, "searchThree");
			Thread thread4 = new Thread(threadSearch, hcsFour, "searchFour");
	        
	        if (hcs.getFinalSolution() != null)
				threadSearch.interrupt();
	        	hcs.printState(hcs.getFinalSolution());
	        
	        
	        
	        //Printing the solution
	        long timestamp2 = System.currentTimeMillis();
			
			long timeDiff = timestamp2 - timestamp1;
			System.out.println("Execution Time: "+timeDiff+" ms");
	        
	       
	    }
}