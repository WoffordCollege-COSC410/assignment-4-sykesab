package edu.wofford;


public class TicTacToeModel {

    public enum Mark { 
        EMPTY(" "), 
        XMARK("X"), 
        OMARK("O");

        private Mark(String s) {
            rep = s;
        } 
        public String toString() { return rep; }
        private String rep;
    }

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
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                model[row][col] = Mark.EMPTY;
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

        // If game is over, no new marks should be allowed.
        if (getResult() != Result.NONE) { 
            return false;
        }

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

    @return Mark : {@code XMARK, OMARK, EMPTY}.
    */
    public Mark getMarkAt(int row, int col) {
        return model[row][col];
    }

    /**
    Function getResult:
    Returns the result of the game.

    @return Result : {@code XWIN, OWIN, NONE, TIE}.
    */
    public Result getResult() {
        if (hasEmptySpaces()) {
            return testBoardForWin();
        }
        else {
            return Result.TIE;
        }
    }

    /**
    * Simple wrapper for the 3 {@code test___ForWin} helper functions
    */
    private Result testBoardForWin() {
        Result rowsResult = testRowsForWin();
        if (rowsResult != Result.NONE) {
            return rowsResult;
        }

        Result columnsResult = testColumnsForWin();
        if (columnsResult != Result.NONE) {
            return columnsResult;
        }

        Result diagsResult = testDiagonalsForWin();
        if (diagsResult != Result.NONE) {
            return diagsResult;
        }

        return Result.NONE;
    }

    /**
    * Function testRowsForWin:
    * Helper function which checks the rows in {@code model} for a winning player.
    *
    * @return {@code Result.XWIN} or {@code Result.OWIN} if X or O player wins; {@code Result.NONE} if neither has won.
    */
    private Result testRowsForWin() {
        for (Mark[] row : model) {
            Mark firstMarkInRow = row[0];

            if (firstMarkInRow == Mark.EMPTY) {
                continue;
            }
            if (row[1] == firstMarkInRow && row[2] == firstMarkInRow) {
                if (firstMarkInRow == Mark.XMARK) {
                    return Result.XWIN;
                }
                if (firstMarkInRow == Mark.OMARK) {
                    return Result.OWIN;
                }
            }
        }
        return Result.NONE;
    }

    /**
    * Function testColumnsForWin:
    * Helper function which checks the columns in {@code model} for a winning player.
    *
    * @return {@code Result.XWIN} or {@code Result.OWIN} if X or O player wins; {@code Result.NONE} if neither has won.
    */
    private Result testColumnsForWin() {
        for (int col = 0; col < 3; col++) {
            Mark firstMarkInColumn = model[0][col];

            if (firstMarkInColumn ==  Mark.EMPTY) {
                continue;
            }

            if (model[1][col] == firstMarkInColumn && model[2][col] == firstMarkInColumn) {
                if (firstMarkInColumn == Mark.XMARK) {
                    return Result.XWIN;
                }
                if (firstMarkInColumn == Mark.OMARK) {
                    return Result.OWIN;
                }
            }
        }
        return Result.NONE;
    }

    /**
    * Function testDiagonalsForWin:
    * Helper function which checks the diagonals in {@code model} for a winning player.
    *
    * @return {@code Result.XWIN} or {@code Result.OWIN} if X or O player wins; {@code Result.NONE} if neither has won.
    */
    private Result testDiagonalsForWin() {
        Mark topLeftMark = model[0][0];
        if (topLeftMark != Mark.EMPTY) {
            if (model[1][1] == topLeftMark && model[2][2] == topLeftMark) {
                if (topLeftMark == Mark.XMARK) {
                    return Result.XWIN;
                }
                if (topLeftMark == Mark.OMARK) {
                    return Result.OWIN;
                }
            }
        }

        Mark topRightMark = model[0][2];
        if (topRightMark != Mark.EMPTY) {
            if (model[1][1] == topRightMark && model[2][0] == topRightMark) {
                if (topRightMark == Mark.XMARK) {
                    return Result.XWIN;
                }
                if (topRightMark == Mark.OMARK) {
                    return Result.OWIN;
                }
            }
        }

        return Result.NONE;
    }

    /**
    * Function hasEmptySpaces:
    * Helper function which checks the current model for any positions that are {@code Mark.EMPTY}
    * 
    * @return boolean {@code true} if model contains any Mark.EMPTY enum, {@code false} otherwise.
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
                if (columnCounter == 1) {
                    board += "|" + col + "|";
                } else {
                    board += col;
                }
                columnCounter++;
            }

            if (rowCounter == 0 || rowCounter == 1) {
                board += "\n";
                board += "-----";
                board += "\n";
            }

            rowCounter++;
        }

        return board;
    }

}
