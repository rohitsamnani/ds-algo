package multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

public class CountDownLatchRealTime {
	CountDownLatch latch = new CountDownLatch(3);

	public static void main(String[] args) {

	}

	static class Eligibility {

	}

	static class AddressEligibility extends Eligibility implements Callable<Eligibility> {
		public Eligibility call() {
			return new Eligibility();
		}
	}

	static class PersonalDetailsEligibility extends Eligibility implements Callable<Eligibility> {
		public Eligibility call() {
			return new Eligibility();
		}
	}

	static class ContactDetailsEligibility extends Eligibility implements Callable<Eligibility> {
		public Eligibility call() {
			return new Eligibility();
		}
	}

}
