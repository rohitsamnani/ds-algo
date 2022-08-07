package collections;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * An OTT platform wants to build a key word index of all the movie titles. You
 * will be given a list of movie titles and list of words to ignore. You have to
 * write a program which generates contextual key word inex of the titles.
 * Basically you will have to list the title once for every keyword.
 * 
 * Any word which is not in "List of words to ignore" is potential keyword. For
 * example if list of words to ignore are
 * 
 * ["the", "of", "and", "as", "a", "in", "you", "your", "him", "his", "I", "am",
 * ":","s"] and list of movie titles are :
 * 
 * The Shawshank Redemption The Godfather The Dark Knight The Lord of the Rings
 * The Return of the King Harry Potter Chamber of Secrets Harry Potter
 * Philosopher's Stone
 * 
 * The index would be : harry potter and the CHAMBER of secrets the DARK knight
 * HARRY potter and the chamber of secrets the lord of the rings : the return of
 * the KING the dark KNIGHT the LORD of the rings : the return of the king harry
 * potter and the PHILOSOPHER's stone harry POTTER and the chamber of secrets
 * the shawshank REDEMPTION the lord of the rings : the RETURN of the king the
 * lord of the RINGS : the return of the king harry potter and the chamber of
 * SECRETS the SHAWSHANK redemption harry potter and the philosopher's STONE
 * 
 * 
 *
 */

public class FindPotentialKeyIndex {

	public static void main(String[] args) {

		Set<String> ignoreSet = new HashSet<>(Arrays.asList("the", "of", "and", "as", "a", "in", "you", "The", "your",
				"him", "his", "I", "am", ":", "s"));

		List<String> movie = Arrays.asList("The Shawshank Redemption", "The Godfather", "The Dark Knight",
				"The Lord of the Rings : The Return of the King", "Harry Potter and the Chamber of Secrets",
				"Harry Potter and the Philosopher's Stone");

		Map<String, String> map = new HashMap<>();

		for (String movieName : movie) {
			String[] nameArray = movieName.split(" ");

			for (String pIndex : nameArray) {

				if (!ignoreSet.contains(pIndex)) {
					String key = movieName.toLowerCase().replaceAll(pIndex.toLowerCase(), pIndex.toUpperCase());
					map.put(key, pIndex.toUpperCase());

				}

			}
		}

		map.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(e -> System.out.println(e.getKey()));

	}

}
