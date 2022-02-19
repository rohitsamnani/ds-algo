package example;

import java.util.Arrays;
import java.util.Scanner;

public class ComprableExample {
	
	static class Player implements Comparable<Player> {
		String name;
		int score;

		Player(String name, int score) {
			this.name = name;
			this.score = score;
		}
		
		@Override
		public int compareTo(Player p) {
			if(this.score>p.score)
				return -1;
			else if(this.score<p.score) {
				return 1;
			}
			else {
				return this.name.compareTo(p.name);
			}
		}
	}
	
	public static void main(String[] args) {
	     Scanner scan = new Scanner(System.in);
	        int n = scan.nextInt();

	        Player[] player = new Player[n];
//	        List<Player> playerList = new ArrayList<Player>();
//	        playerList.add(new Player("rohit", 100));
//	        playerList.add(new Player("Mohit", 100));
//	        Collections.sort(playerList);
//	        System.out.println("first");
	        
	        
	        for(int i = 0; i < n; i++){
	        	 player[i] = new Player(scan.next(), scan.nextInt());
	        }
	        scan.close();

	        Arrays.sort(player);
   
	     
	        for(int i = 0; i < player.length; i++){
	            System.out.printf("%s %s\n", player[i].name, player[i].score);
	        }
	    }
	}