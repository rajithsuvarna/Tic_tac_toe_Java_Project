package Tictactoepro;

public class Board {
	private char p1symbol,p2symbol;
	private char[][] board;
	private int boardsize=3;
	private int count;
	private static final char EMPTY=' ';
	public static final int INVALID=5;
	public static final int PLAYER1WINS=1;
	public static final int PLAYER2WINS=2;
	public static final int DRAW=3;
	public static final int INCOMPLETE=4;
	
	public Board(char p1symbol,char p2symbol) {
		board=new char[boardsize][boardsize];
		for(int i=0;i<boardsize;i++) {
			for(int j=0;j<boardsize;j++) {
				board[i][j]=EMPTY;
			}
		}
		this.p1symbol=p1symbol;
		this.p2symbol=p2symbol;
	}

	public int move(char getsymbol, int x, int y) {
		// TODO Auto-generated method stub
		if(x<0 || y<0 || x>=boardsize || y>=boardsize || board[x][y]!=EMPTY) {
			return INVALID;
		}
		board[x][y]=getsymbol;
		count++;
		if(board[x][0]==board[x][1] && board[x][0]==board[x][2]) {
			return getsymbol==p1symbol?PLAYER1WINS:PLAYER2WINS;
		}
		if(board[0][y]==board[1][y] && board[0][y]==board[2][y]) {
			return getsymbol==p1symbol?PLAYER1WINS:PLAYER2WINS;
		}
		if(board[0][0]!=EMPTY && board[0][0]==board[1][1] && board[0][0]==board[2][2]) {
			return getsymbol==p1symbol?PLAYER1WINS:PLAYER2WINS;
		}
		if(board[0][2]!=EMPTY && board[0][2]==board[1][1] && board[0][2]==board[2][0]) {
			return getsymbol==p1symbol?PLAYER1WINS:PLAYER2WINS;
		}
		if(count==boardsize*boardsize) {
			return DRAW;
		}
		return INCOMPLETE;
	}

	public void print() {
		System.out.println("----------------------------");
		for(int i=0;i<boardsize;i++) {
			for(int j=0;j<boardsize;j++) {
				System.out.print("|" + " " + board[i][j] + " " + "|");
			}
			System.out.println();
		}
		System.out.println("----------------------------");
		
	}
	

}
