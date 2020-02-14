package util;

/**
 * Generate sudoku grids.
 *
 * @author owen.daynes
 * @date 13 February 2020
 */

public class SudokuGenerator {

    /** Symbol for absent value in grid */
    private static final char EMPTY = '*';

    /** width/height for x*x grid*/
    private GridDimensions dimensions;

    private char[] seedArray;

    /** Uninstantiable, use factory method */
    private SudokuGenerator() {
        this.dimensions = GridDimensions.NINE;
        this.seedArray = new char[dimensions.getDimensions()];
    }

    /** Uninstantiable, use factory method */
    private SudokuGenerator(GridDimensions dimensions) {
        this.dimensions = dimensions;
        this.seedArray = new char[dimensions.getDimensions()];
    }

    /**
     * Get a sudoku generator
     * @param gridDimensions dimensions of game grid
     * @return SudokuGenerator initialised for provided grid dimensions
     * @throws IllegalArgumentException If grid dimensions provided are not valid grid dimension configurations
     */
    public static SudokuGenerator get(GridDimensions gridDimensions) {
        switch(gridDimensions) {
            case NINE:
            case SIXTEEN:
                return new SudokuGenerator(gridDimensions);
            default:
                throw new IllegalArgumentException("Illegal grid size provided: " + gridDimensions.getDimensions());
        }
    }

    /**
     * Creates a 2D grid populated with the empty value character
     * @return 2D sudoku grid
     */
    private char[][] createEmptyGrid() {

        char[][] puzzle = new char[dimensions.getDimensions()][dimensions.getDimensions()];

        for(int y = 0; y < puzzle.length; y++) {
            for(int x = 0; x < puzzle[y].length; x++) {
                puzzle[y][x] = EMPTY;
            }
        }

        return puzzle;
    }

    /**
     * Create a seed array based on the token string from the GridDimensions enum
     * @return
     */
    private char[] createSeed() {
        char[] tokens = dimensions.getTokenString().toCharArray();
        return ArrayMethods.suffleCharArray(tokens);
    }

    /**
     * Populate the 2D array grid using the seed char array
     * @param arr 2D array grid to populate
     * @param seed first/original char array which all others will be based on
     * @return populated 2D array grid
     */
    private char[][] populateGridMask(char[][] arr, char[] seed) {
        int quadrantSize = (int) Math.sqrt(arr.length);

        for(int i = 0; i < arr.length; i++) {
            if(i != 0) {
                if(i % quadrantSize != 0) {
                    // uses the previous line to create current
                    arr[i] = ArrayMethods.shiftRight(arr[i - 1], quadrantSize);
                } else {
                    // first line of each row of quadrants
                    arr[i] = ArrayMethods.shiftQuadrantRight(arr[i - quadrantSize], 1);
                }
            } else {
                // first line
                arr[i] = seed;
            }
        }

        return arr;
    }
}
