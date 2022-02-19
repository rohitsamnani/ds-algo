package recurssion;

public class TowerOfHanoi {

	public static void main(String[] args) {
		int n = 3; // Number of disks
		towerOfHanoi(n, 'S', 'D', 'A'); // A, B and C are names of rods
	}

	private static void towerOfHanoi(int n, char s, char d, char a) {

		if (n == 0) {
			return;
		}
		towerOfHanoi(n-1, s,a,d);
		System.out.println("move disk "+ n +" from "+ s +" to "+ d);
		towerOfHanoi(n-1,a,d,s);

	}

}
