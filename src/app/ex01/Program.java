package app.ex01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import entities.ex01.logEntry;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Entre file full path: ");
		String path = sc.nextLine();

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			Set<logEntry> mySet = new HashSet<>(); // hash set because does not matter the order and it does not permit
													// to repeat names.
			String line = br.readLine();

			while (line != null) {
				String[] fields = line.split(" ");
				String userName = fields[0];
				Date moment = Date.from(Instant.parse(fields[1]));

				mySet.add(new logEntry(userName, moment)); // Repeated data will be blocked by the Set structure itself.
				line = br.readLine();
			}
			System.out.println("Total users: "+mySet.size());
			
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		sc.close();
	}

}
