package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Queen extends ChessPiece   {


	public Queen(Board board, Color color) {
		super(board, color);
	}

	@Override
	public String toString() {
		return "Q";
	}

	private boolean canMove(Position position) {
		ChessPiece p = (ChessPiece) getBoard().piece(position);
		return p == null || p.getColor() != getColor();
	}

	@Override
	public boolean[][] possibleMovies() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

		Position p = new Position(0, 0);

		
		p.setValues(position.getRow() - 1, position.getColumn()-2);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		
		p.setValues(position.getRow() - 2, position.getColumn()-1);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		
		p.setValues(position.getRow()-2, position.getColumn() + 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		p.setValues(position.getRow()-1, position.getColumn() +2);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		
		p.setValues(position.getRow()+1, position.getColumn() +2);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		p.setValues(position.getRow()+2, position.getColumn() +1);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		
		p.setValues(position.getRow() + 2, position.getColumn() - 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		p.setValues(position.getRow() + 1, position.getColumn() - 2);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		//Noroeste
		
				p.setValues(position.getRow() -1, position.getColumn()-1);
				while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
					mat[p.getRow()][p.getColumn()]= true;
					p.setValues(p.getRow()-1, p.getColumn()-1);
				}
				if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
					mat[p.getRow()][p.getColumn()]= true;
					
				}
				
				//Esquerda
				
				p.setValues(position.getRow()-1 , position.getColumn()+1);
				while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
					mat[p.getRow()][p.getColumn()]= true;
					p.setValues(p.getRow()-1, p.getColumn()+1);
				}
				if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
					mat[p.getRow()][p.getColumn()]= true;
					
				}
				
				// sudeste

				p.setValues(position.getRow()+1, position.getColumn() + 1);
				while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
					mat[p.getRow()][p.getColumn()] = true;
					p.setValues(p.getRow()+1, p.getColumn()+1);
				}
				if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
					mat[p.getRow()][p.getColumn()] = true;

				}

				// Sudoeste
				
				p.setValues(position.getRow() + 1, position.getColumn()-1);
				while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
					mat[p.getRow()][p.getColumn()] = true;
					p.setValues(p.getRow()+1, p.getColumn()-1);
				}
				if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
					mat[p.getRow()][p.getColumn()] = true;

				}	

		return mat;

	}
}
