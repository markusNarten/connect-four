/**
 * a position on a connect four grid
 * @author 18narten
 *@version 5/29/2017
 */
public class Position {
	private int row, col;
	
	/**
	 * default constructor for a new position
	 */
	public Position() {
		row = 0;
		col = 0;
	}
	
	/**
	 * paramaterized constructor for a position
	 * @param r the row of the position
	 * @param c the column of the position
	 */
	public Position(int r, int c) {
		row = r;
		col = c;
	}
	
	/**
	 * accessor method for the row of the position
	 * @return the row
	 */
	public int getRow() { return row;}
	/**
	 * accessor method for the column of the position
	 * @return the column
	 */
	public int getColumn() {return col;}
	
	/**
	 * mutator method for the row
	 * @param r the new row
	 */
	public void setRow(int r) {row = r;}
	
	/**
	 * mutator method for the column
	 * @param c the new column
	 */
	public void setColumn(int c) {col = c;}
	
	/**
	 * compares to positions to see if they are equal
	 * @return whether they are equal
	 */
	public boolean equals(Object other) {
		if(other instanceof Position) {
			return(this.col == ((Position)other).getColumn() && this.row == ((Position)other).getRow());
		}
	return false;
	}
}
