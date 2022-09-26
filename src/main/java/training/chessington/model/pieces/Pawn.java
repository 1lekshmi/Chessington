package training.chessington.model.pieces;

import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends AbstractPiece {
    public Pawn(PlayerColour colour) {
        super(Piece.PieceType.PAWN, colour);
    }

    @Override
    public List<Move> getAllowedMoves(Coordinates from, Board board) {
        List<Move> listOfMoves = new ArrayList<>();
        if (colour == PlayerColour.WHITE){
            getAllowedMovesForPlayerColour(from, board, listOfMoves,colour);
    
        }else{
            getAllowedMovesForPlayerColour(from, board, listOfMoves, colour);
        }
        return listOfMoves;

    }

    public List<Move> getAllowedMovesForPlayerColour(Coordinates from, Board board, List<Move> listOfMoves, PlayerColour playerColour){
        int rowNumber = playerColour.equals(PlayerColour.BLACK) ? 1 : 6 ;
        int initialRowMoves = playerColour.equals(PlayerColour.BLACK)? from.getRow() + 2 : from.getRow() - 2;
        int rowMoves = playerColour.equals(PlayerColour.BLACK) ? from.getRow() + 1 : from.getRow() - 1;

        if (from.getRow() == rowNumber){
            Coordinates moveTwo = new Coordinates(initialRowMoves, from.getCol());
            Move moveAbove = new Move(from, moveTwo);
            if (board.get(moveTwo) == null){
                listOfMoves.add(moveAbove);
            }
        }

        Coordinates moveOne = new Coordinates(rowMoves, from.getCol());
        Move moveAbove = new Move(from, moveOne);
        if (board.get(moveOne) == null){
            listOfMoves.add(moveAbove);
        }

        return listOfMoves;
    }
}
