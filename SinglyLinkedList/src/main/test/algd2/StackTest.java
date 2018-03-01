package algd2;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class StackTest {

	@Test
	void sackbahnhof() {

		Stack<String> S1 = new Stack<String>();
		Stack<String> S2 = new Stack<String>();
		Stack<String> S3 = new Stack<String>();

		S1.push("A");
		S1.push("B");
		S1.push("A");
		S1.push("B");

		S2.push("B");
		S2.push("A");
		S2.push("A");
		
		Stack<String>[] geleise = new Stack[] { S1, S2, S3 };

		for (int i = 0; i < geleise.length; i++) {
			int index = i + 1 == geleise.length ? 0 : i + 1;
			Stack<String> tempGeleis = geleise[index];

			Stack<String> s = geleise[i];
			while (!s.isEmpty()) {
				if (s.top().equals("A") && S1 != s) {
					S1.push(s.pop());
				} else if (s.top().equals("B") && S2 != s) {
					S2.push(s.pop());
				} else {
					tempGeleis.push(s.pop());
				}
				System.out.println("---------------");
				System.out.println("S3: " + S3);
				System.out.println("S2: " + S2);
				System.out.println("S1: " + S1);
				System.out.println("---------------");
			}

		}

	}

}
