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
            if (from.getRow() == 6){
                Coordinates whiteMove2 = new Coordinates(from.getRow() - 2, from.getCol());
                Move moveAbove = new Move(from, whiteMove2);

                if (board.get(whiteMove2) == null){
                    listOfMoves.add(moveAbove);
                }
            }

            Coordinates whiteMove1 = new Coordinates(from.getRow() - 1, from.getCol());
            Move moveAbove = new Move(from, whiteMove1);
            if (board.get(whiteMove1) == null){
                listOfMoves.add(moveAbove);
            }

        }else{
            if (from.getRow() == 1){
            Coordinates blackMove2 = new Coordinates(from.getRow() + 2, from.getCol());
            Move moveBelow = new Move(from, blackMove2);
                if (board.get(blackMove2) == null){
                    listOfMoves.add(moveBelow);
                }

            }

            Coordinates blackMove1 = new Coordinates(from.getRow() + 1, from.getCol());
            Move moveBelow = new Move(from, blackMove1);
            if (board.get(blackMove1) == null){
                listOfMoves.add(moveBelow);
            }
        }

        return listOfMoves;
    }
}
