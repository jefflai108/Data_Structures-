package model;

import static org.junit.Assert.assertTrue;

import java.util.Random;

import tests.TestsSupport;


public class Test {
	public static void main(String[] args) { 
	int maxRows = 8, maxCols = 8, strategy = 1;
	Game ccGame = new SimpleTetris(maxRows, maxCols, new Random(1L), strategy);
   
	ccGame.setBoardWithColor(BoardCell.BLUE);
	ccGame.setRowWithColor(maxRows - 1, BoardCell.EMPTY);
	ccGame.setRowWithColor(1, BoardCell.YELLOW);
	ccGame.setBoardCell(1, maxCols - 1, BoardCell.RED);
	ccGame.setRowWithColor(3, BoardCell.GREEN);
	ccGame.setRowWithColor(6, BoardCell.RED);
	
	String answer = "Before processCell\n\n";
	answer += getBoardStr(ccGame);
	ccGame.processCell(2, 0);
	answer += "\nAfter processCell\n";
	answer += getBoardStr(ccGame);
	ccGame.processCell(1, maxCols - 1);
	answer += "\nAfter processCell\n";
	answer += getBoardStr(ccGame);
	System.out.println(answer);
}
	private static String getBoardStr(Game game) {
		int maxRows = game.getMaxRows(), maxCols = game.getMaxCols();

		String answer = "Board(Rows: " + maxRows + ", Columns: " + maxCols + ")\n";
		for (int row = 0; row < maxRows; row++) {
			for (int col = 0; col < maxCols; col++) {
				answer += game.getBoardCell(row, col).getName();
			}
			answer += "\n";
		}

		return answer;
	}

}
