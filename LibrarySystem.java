import java.util.ArrayList;
import java.util.Scanner;

public class LibrarySystem {
	static ArrayList<Book> books = new ArrayList<>();
	static ArrayList<User> users = new ArrayList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("\n==== Library Menu ====");
			System.out.println("1. Add Book");
			System.out.println("2. Add User");
			System.out.println("3. Show Books");
			System.out.println("4. Issue Book");
			System.out.println("5. Return Book");
			System.out.println("6. Show Users");
			System.out.println("7. EXIT");
			
			System.out.println("Enter choice:");
			int choice=sc.nextInt();
			
			switch (choice) {
			case 1:
				addBook(sc);
				break;
			case 2:
				addUser(sc);
				break;
			case 3:
				showBooks();
				break;
			case 4:
				issueBook(sc);
				break;
			case 5:
				returnBook(sc);
				break;
			case 6:
				showUsers();
				break;
			case 7:
				System.out.println("Exiting...");
				return;
			default:
				System.out.println("Invalid choice");
			
			
			}

			
		}
		
		
	}
	
	static void addBook(Scanner sc) {
		System.out.print("Enter Book ID:");
		int id=sc.nextInt();
		sc.nextLine();
		
		System.out.print("Enter Title:");
		String title=sc.nextLine();
		
		System.out.print("Enter Author:");
		String author=sc.nextLine();
		
		books.add(new Book(id,title,author));
		System.out.println("Book added successfully");
		
	}
	
	static void addUser(Scanner sc) {
		System.out.print("Enter User ID: ");
		int id = sc.nextInt();
		sc.nextLine();
		
		System.out.print("Enter Name: ");
		String name= sc.nextLine();
		
		users.add(new User(id, name));
		System.out.println("User added successfully");
	}
	
	static void showBooks() {
		if(books.isEmpty()) {
			System.out.println("No books available");
			return;
		}
		
		System.out.println("\n----Book List----");
		
		for(Book b : books) {
			System.out.println("Book ID:" + b.bookId);
			System.out.println("Title:" + b.title);
			System.out.println("Author: " + b.author);
			System.out.println("Issued: " + b.isIssued);
			System.out.println("Status: " + (b.isIssued ? "Issued" : "Available"));
			System.out.println("--------------------------------");
					            
					 
		}
	}
	
	static void issueBook(Scanner sc) {
		System.out.print("Enter Book ID to issue: ");
		int id = sc.nextInt();
		
		for(Book b : books) {
			if(b.bookId==id) {
				if(!b.isIssued) {
					b.isIssued=true;
					System.out.println("Book issued successfully");
				}else {
					System.out.println("Book already issued");
				}
				return;
			}
		}
			System.out.println("Book not found");
		}

	
	static void returnBook(Scanner sc) {
		System.out.println("Enter Book ID to return: ");
		int id = sc.nextInt();
		
		for(Book b : books) {
			if(b.bookId==id) {
				if(b.isIssued) {
					b.isIssued=false;
					
					System.out.print("Enter the number of days books was kept");
					int days=sc.nextInt();
					
					if (days>7) {
						int fine = (days-7) * 5; // 5 rupees per extra day
						System.out.println("Late return , Fine=" + fine);
					}else {
						System.out.println("Returned on time. No fine.");
					}
					
					System.out.println("Book returned successfully");
				}else {
					System.out.println("This book was not issued");
				}
				return;
			}
		}
		System.out.println("Book not found");
	}
	
	static void showUsers() {
		if(users.isEmpty()) {
			System.out.println("No user available");
			return;
		}
		System.out.println("\n--- User List---");
		for(User u : users) {
			System.out.println("User ID: " + u.userId);
			System.out.println("Name: " + u.name);
			System.out.println("---------------------------");
		}
	}
	
	

}
