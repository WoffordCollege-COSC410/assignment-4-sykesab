package edu.wofford;


public class TicTacToeModel {

    public enum Mark { EMPTY, XMARK, OMARK };
    public enum Result { XWIN, OWIN, TIE, NONE };
    public enum Turn { XTURN, OTURN };

    private Mark[][] model;
    private Turn currentTurn;

    /**
    Constructor:
    Initializes the model variable to a 2-dimensional array of Mark enums and sets all positions to {@code Mark.EMPTY}.
    */
    public TicTacToeModel() {
        model = new Mark[3][3];
        for (Mark[] row : model) {
            for (Mark col : row) {
                col = Mark.EMPTY;
            }
        }
        currentTurn = Turn.XTURN;
    }

    public Turn getCurrentTurn() {
        return currentTurn;
    }

    /**
    setMarkAt:
    Sets the Mark at the specified position. Returns {@code true} if mark was set, {@code false} if there is already a mark at that position.
    */
    public boolean setMarkAt(int row, int col) {
        if (getMarkAt(row, col) == Mark.EMPTY) {
            if (currentTurn == Turn.XTURN) {
                model[row][col] = Mark.XMARK;
                currentTurn = Turn.OTURN;
            } else {
                model[row][col] = Mark.OMARK;
                currentTurn = Turn.XTURN;
            }
            return true;
        } else {
            return false;
        }
    }

    /**
    Function getMarkAt:
    Returns the current Mark at the specified row and column.

    @returns Mark : {@code XMARK, OMARK, EMPTY}.
    */
    public Mark getMarkAt(int row, int col) {
        return model[row][col];
    }

    /**
    Function getResult:
    Returns the result of the game.

    @returns Result : {@code XWIN, OWIN, NONE, TIE}.
    */
    public Result getResult() {
        if (hasEmptySpaces()) {
            //if there are 3 XMARKs in a row then
            //return Result.XWIN;
            //else there are 3 OMARKs in a row then
            //return Result.OWIN;
            //else
            return Result.NONE;
        }
        else {
            return Result.TIE;
        }
    }

    /**
    Function hasEmptySpaces:
    Helper function which checks the current model for any positions that are {@code Mark.EMPTY}

    @returns boolean {@code true} if model contains any Mark.EMPTY enum, {@code false} otherwise.
    */
    private boolean hasEmptySpaces() {
        for (int row = 0; row < 3; ++row) {
            for (int col = 0; col < 3; ++col) {
                if (getMarkAt(row, col) == Mark.EMPTY) {
                    return true;
                }
            }
        }
        return false;
    }

    public String toString() {
        String board = "";

        int rowCounter = 0;
        for (Mark[] row : model) {
            int columnCounter = 0;
            for (Mark col : row) {
                String mark = "";
                switch (col) {
                    case XMARK: mark = "X";
                                break;
                    case OMARK: mark = "O";
                                break;
                    default:    mark = " ";
                                break;
                }
                if (columnCounter == 1) {
                    board += "|" + mark + "|";
                } else {
                    board += mark;
                }
                columnCounter++;
            }
            if (rowCounter == 0 || rowCounter == 1) {
                board += "\n";
                board += "-----";
                board += "\n";
            }
        }

        return board;
    }

}
