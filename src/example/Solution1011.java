package example;
import java.util.*;

	class Player {
		String name;
		int score;

		Player(String name, int score) {
			this.name = name;
			this.score = score;
		}
	}

	class Checker implements Comparator<Player> {
	  	// complete this method
		public int compare(Player a, Player b) {
	        if(a.score>b.score)
	        	return -1;
	        else if (a.score<b.score)
	        	return 1;
	        else {
	        	return a.name.compareTo(b.name);
	        }
	    }
	}


	public class Solution1011 {

	    public static void main(String[] args) {
	        Scanner scan = new Scanner(System.in);
	        int n = scan.nextInt();

	        Player[] player = new Player[n];
	        Checker checker = new Checker();
	        
	        for(int i = 0; i < n; i++){
	            player[i] = new Player(scan.next(), scan.nextInt());
	        }
	        scan.close();

//	        Arrays.sort(player, checker);
	        List<Player> l = Arrays.asList(player); 
	        
	        Player[] p1=(Player[]) l.toArray(Player[]::new);				//not a good way to convert list into array
	        
	        Player [] p2 = l.stream().toArray(Player[]::new);
	        
	        
	        System.out.println("first -------------------");
	        Collections.sort(l,new Comparator<Player>() {
	        	public int compare(Player a, Player b) {
	    	        if(a.score>b.score)
	    	        	return -1;
	    	        else if (a.score<b.score)
	    	        	return 1;
	    	        else {
	    	        	return a.name.compareTo(b.name);
	    	        }
	        	}
	        });
	        
	       
	        for(Player p : l)
	        System.out.println(p.name +" "+ p .score);
	        
	        
	        System.out.println("second------------------");
	        Arrays.sort(p1, new Comparator<Player>() {
	        	public int compare(Player a, Player b) {
	    	        if(a.score>b.score)
	    	        	return -1;
	    	        else if (a.score<b.score)
	    	        	return 1;
	    	        else {
	    	        	return a.name.compareTo(b.name);
	    	        }
	    	    }
	        });
	        for(int i = 0; i < p1.length; i++){
	            System.out.printf("%s %s\n", p1[i].name, p1[i].score);
	        }
	    }
	}
