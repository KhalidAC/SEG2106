package seg2106_lab7;
import java.util.concurrent.Semaphore;

public class Chopstick {
	private int ID;
	//private boolean isFree;
	
// hint: use a local variable to indicate whether the chopstick is free 
//                        (lying on the table), e.g.  private boolean free;

	Chopstick(int ID) {
		  this.ID = ID;
		 // this.isFree = true;
	
	}

	// need to create a semaphore to count how many starting chopsticks are taken
	Semaphore availChop = new Semaphore(4);
	
	synchronized void take() {

		while(ID <= 0){
			try{
				wait();
				availChop.acquire();
			}catch (InterruptedException ex)  {
                ex.printStackTrace();
            }
        }
		
		ID--;
		    

	}
	
	synchronized void release() {
		
		ID++;
		availChop.release();
        notifyAll();		
	
	}
	    
	public int getID() {
	    return(ID);
	}

}


