package example;

public class SaveThePrisonerHackerRank {
	
	public static void main(String[] args) {
		
		System.out.println("prisoner who chucks bitter candy will be : "+saveThePrisoner(5,559772386,5));
	}

	//n is prisoner count, m is candy count, s is start
	private static int saveThePrisoner(int n, int m, int s) {
		return ((m-1)%n+1)+((n+s)%n+1);
	}
}
