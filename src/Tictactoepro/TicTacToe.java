package Tictactoepro;
import java.util.*;

public class TicTacToe {
	private Player player1,player2;
	private Board board;
	private int numPlayers;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TicTacToe t=new TicTacToe();
		t.startgame();

	}
	public void startgame() {
		Scanner s=new Scanner(System.in);
		player1=takeinput(++numPlayers);
		player2=takeinput(++numPlayers);
		
		while(player1.getsymbol()==player2.getsymbol()) {
			System.out.println("Symbol already taken! Please enter the new symbol");
			player2.setsymbol(s.next().charAt(0));
		}
		board=new Board(player1.getsymbol(),player2.getsymbol());
		boolean player1turn=true;
		int status=Board.INCOMPLETE;
		while(status==Board.INCOMPLETE || status==Board.INVALID) {
			if(player1turn) {
				System.out.println("Player-1" + " " + player1.getname() + "'s turn");
				System.out.println("Enter the x:");
				int x=s.nextInt();
				System.out.println("Enter the y:");
				int y=s.nextInt();
				
				status=board.move(player1.getsymbol(),x,y);
				if(status==Board.INVALID) {
					System.out.println("Invalid entry!! Enter x and y value again");
				}
				
			}
			else {
				System.out.println("Player-2" + " " + player2.getname() + "'s turn");
				System.out.println("Enter the x value:");
				int x=s.nextInt();
				System.out.println("Enter the y value:");
				int y=s.nextInt();
				
				status=board.move(player2.getsymbol(),x,y);
				if(status==Board.INVALID) {
					System.out.println("Invalid entry!! Enter x and y value again");
				}
				
			}
			player1turn=!player1turn;
			board.print();
		}
		if(status==Board.PLAYER1WINS) {
			System.out.println("Player-1" + " " + player1.getname() + " " +"Wins");
		}
		else if(status==Board.PLAYER2WINS) {
			System.out.println("Player-2" + " " + player2.getname() + " " + "Wins");
		}
		else {
			System.out.println("DRAW");
		}
		
	}
	private Player takeinput(int num) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the Player " + num + " name:");
		String name=s.nextLine();
		System.out.println("Enter the Player " + num + " Symbol:");
		char symbol=s.next().charAt(0);
		Player p=new Player(name,symbol);
		return p;
	}

}
