/**
 * The basic representation for a Matrix.
 * 
 * This interface contains the items that must be realised by a Matrix class 
 * implementation.
 * @author Thabiso
 * @param <T> This will be the type of each element in the Matrix. At least it
 * should be Integer or Double.
 */
public interface IMatrix<T>{
    
    /**
     * The number of rows in this Matrix
     * @return The number of rows
     */
    public Integer numberRows();
    /**
     * The number of columns in the Matrix.
     * @return the number of columns
     */
    public Integer numberCols();
    /**
     * Returns an IMatrix<T> that contains the specified row. This will be a nx1
     * Matrix.
     * @param i The row number in the Matrix
     * @return An IMatrix<T> that contains the specified row.
     * @throws MatrixException if the row number is invalid.
     */
    public IMatrix<T> getRow(Integer i) throws MatrixExceptioon;
    /**
     * Returns an IMatrix<T> that contains the specified column. This will be an
     * 1xn Matrix.
     * @param j the column number in the matrix
     * @return An IMatrix<T> that contains the specified column
     * @throws MatrixException if the column number is invalid
     */
    public IMatrix<T> getCol(Integer j) throws MatrixExceptioon;
    /**
     * Returns an element of type <T> from the Matrix.
     * @param i The row number
     * @param j The column number
     * @return The item of type <T> from the Matrix
     * @throws MatrixException if the row or column number is invalid
     */
    public T getElement(Integer i, Integer j) throws MatrixExceptioon;
    
    /**
     * Add another Matrix to the current matrix. A new matrix should be returned
     * @param otherMatrix The other matrix that should be added to this matrix.
     * @return A new matrix that contains the result.
     * @throws MatrixException if otherMatrix cannot be added to this matrix
     */
    public IMatrix<T> addMatrix(IMatrix<T> otherMatrix) throws MatrixExceptioon;
    /**
     * Add a scalar value to this matrix
     * @param c the Integer scalar value
     * @return A new matrix  that contains the result.
     * @throws MatrixException if c cannot be added to this matrix.
     */
    public IMatrix<T> addScalar(Integer c) throws MatrixExceptioon;
    /**
     * Add a Double scalar to this matrix
     * @param c the Double scalar value
     * @return A new IMatrix<Double> that contains the result.
     * @throws MatrixException if c cannot be added to this matrix
     */
    public IMatrix<Double> addScalar(Double c) throws MatrixExceptioon;
    /**
     * Multiple a scalar with the current matrix.
     * @param c the Integer scalar value
     * @return A new IMatrix<T> that contains the result.
     * @throws MatrixException if c cannot be added to this matrix
     */
    public IMatrix<T> multiplyScalar(Integer c) throws MatrixExceptioon;
     /**
     * Multiple a scalar with the current matrix.
     * @param c the Double scalar value
     * @return A new IMatrix<Double> that contains the result.
     * @throws MatrixException if c cannot be added to this matrix
     */
    public IMatrix<Double> multiplyScalar(Double c) throws MatrixExceptioon; 
    /**
     * Multiply otherMatrix with the current Matrix.
     * @param otherMatrix another Matrix that will be multiplied with the current matrix
     * @return A new IMatrix<T> that contains the result.
     * @throws MatrixException if otherMatrix cannot be multiplied with the current matrix
     */
    public IMatrix<T> multiplyMatrix(IMatrix<T> otherMatrix) throws MatrixExceptioon;
    
    /**
     * Transpose the current matrix.
     * @return A new IMatrix<T> that contains the transpose of the current matrix.
     */
    public IMatrix<T> transpose() throws MatrixExceptioon;
    
}
