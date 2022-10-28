package synchrinization;

import java.io.*;  
import java.util.Scanner;

public class BullyAlgo {
	static int n;
	static int status[] = new int [20];
	static int electionContenders[] = new int[20];
	static int elecInitiator;
	static int ptr;
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("What is the total number of processes?");
		n = s.nextInt();
		for(int i=1;i<n;i++) {
			System.out.println("Enter the status of process " + i + " : ");
			status[i] = s.nextInt(); //enter only 0 for inactive and only 1 for active
		}
		System.out.println("If " + n + "th process fails, which process will initiate the election?");
		elecInitiator = s.nextInt();
		
		//If chosen initiator is active then only start elections
		if(status[elecInitiator]==1) {
			//Main Logic
			ptr = elecInitiator;
			System.out.println(elecInitiator + "th process is initiating elections...");
			electionContenders[elecInitiator] = 1;
		}
		else {
			System.out.println("The process you chose is inactive!");
		}
		while(ptr<n) {
			if(electionContenders[ptr]==1) {
				for(int m=0; m<ptr; m++) {
					electionContenders[m]=0;
				}
				for(int j = ptr+1; j<n; j++) {
					System.out.println("Process " +ptr+ " is sending message to process " +j+ ".");
				}
				for(int k=ptr+1; k<n; k++) {
					if(status[k]==1) {
						System.out.println("Process " +k+ " is active and has sent a response.");
						electionContenders[k]=1;
					}
				}
			}
			ptr = ptr+1;
		}		
		for(int l=0; l<n; l++) {
		if(electionContenders[l]==1) {
			System.out.println("Process " + l + " is now the co-ordinator. ");
		}
	}
		s.close();
	}
}