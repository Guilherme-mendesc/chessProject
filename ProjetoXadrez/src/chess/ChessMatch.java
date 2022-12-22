package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;
import chess.pieces.King;
import chess.pieces.Rook;

public class ChessMatch {
	
	private Board board;
	
	public ChessMatch() throws Exception {
		board = new Board(8,8);
		initialSetup();
	}
	
	public ChessPiece[][] getPieces(){
		ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
		for (int i=0; i<board.getRows(); i++) {
			for(int j=0; j<board.getColumns(); j++) {
				mat[i][j] = (ChessPiece) board.piece(i,j);
			}
		}
		return mat;
	}
	
	public ChessPiece performamChessMove(ChessPosition sourcePosition, ChessPosition targetPosition) {
		Position source = sourcePosition.toPosition();
		Position target = sourcePosition.toPosition();
		validateSourcePosition(source);
		Piece capturedPiece = makeMove(source, target);
		return(ChessPiece) capturedPiece;
	}
	
	
	private Piece makeMove(Position source, Position target) {
		Piece p = board.removePeice(source);
		Piece capturedPiece = board.removePeice(target);
		board.placePiece(p, target);
		return capturedPiece;
	}
	
	
	private void validateSourcePosition(Position position) {
		if (!board.thereIsAPiece(position)) {
			throw new ChessException("there is no piece on source position");
		}
	}
	
	
	
	
	private void placeNewPeice(char column, int row, ChessPiece piece) {
		board.placePiece(piece, new ChessPosition(column, row).toPosition());
	}
	
	private void initialSetup() {
		placeNewPeice('c', 1, new Rook(board, Color.WHITE));
        placeNewPeice('c', 2, new Rook(board, Color.WHITE));
        placeNewPeice('d', 2, new Rook(board, Color.WHITE));
        placeNewPeice('e', 2, new Rook(board, Color.WHITE));
        placeNewPeice('e', 1, new Rook(board, Color.WHITE));
        placeNewPeice('d', 1, new King(board, Color.WHITE));

        placeNewPeice('c', 7, new Rook(board, Color.BLACK));
        placeNewPeice('c', 8, new Rook(board, Color.BLACK));
        placeNewPeice('d', 7, new Rook(board, Color.BLACK));
        placeNewPeice('e', 7, new Rook(board, Color.BLACK));
        placeNewPeice('e', 8, new Rook(board, Color.BLACK));
        placeNewPeice('d', 8, new King(board, Color.BLACK));
	}
	
}
