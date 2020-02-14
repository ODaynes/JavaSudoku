package util;

/**
 * Enumeration for valid sudoku grid dimensions
 *
 * @author owen.daynes
 * @date 13 February 2020
 */
public enum GridDimensions {

    NINE(9, "abcdefghi"), SIXTEEN(16, "abcdefghijklmnop");

    private int dimensions;
    private String tokenString;

    GridDimensions(int dimensions, String tokenString) {
        this.dimensions = dimensions;
        this.tokenString = tokenString;
    }

    /**
     * @return dimensions
     */
    public int getDimensions() {
        return this.dimensions;
    }

    /**
     * @return tokenString
     */

    public String getTokenString() {
        return this.tokenString;
    }

    @Override
    public String toString() {
        return this.name() + "(" + this.dimensions + ")";
    }


}
