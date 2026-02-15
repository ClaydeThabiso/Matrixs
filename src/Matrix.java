
public class Matrix<T extends Number> implements IMatrix<T> {

	private int cols;
	private int rows;
	private final Object[][] data;
	/**
     * Default constructor. Creates an empty (0×0) matrix.
     */
	public Matrix()
	{
		this(0,0);
	}
	/**
     * Constructs a matrix with the specified number of rows and columns.
     * @param rows number of rows
     * @param cols number of columns
     * @throws MatrixException if rows or cols is negative
     */
	public Matrix(int row, int col) {
		// TODO Auto-generated constructor stub
		this.cols=col;
		this.rows=row;
		this.data=new Object[row][col];
	}
	/**
     * Constructs a matrix from a 2D array of initial values.
     * @param initialData 2D array containing the initial matrix values
     * @throws MatrixException if the input is null, empty, or not rectangular
     */
	public Matrix(T[][] initialData)
	{
		this.data = null;
		for(int i=0;i<rows;i++)
		{
			for(int j=0;j<cols;j++)
			{
				data[i][j]=initialData[i][j];
			}
		}
	}
	@Override
	public Integer numberRows() {
		// TODO Auto-generated method stub
		return rows;
	}

	@Override
	public Integer numberCols() {
		// TODO Auto-generated method stub
		return cols;
	}

	@Override
	public IMatrix<T> getRow(Integer i) throws MatrixExceptioon {
		// TODO Auto-generated method stub
		Matrix<T> row=new Matrix<>(1,cols);
		for(int j=0;j<cols;j++)
		{
			row.getElement(i, j);
		}
		return row;
	}

	@Override
	public IMatrix<T> getCol(Integer j) throws MatrixExceptioon {
		// TODO Auto-generated method stub
		Matrix<T> col= new Matrix<>(rows,1);
		for(int i=0;i<rows;i++)
		{
			col.getElement(j, j);
		}
		return col;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T getElement(Integer i, Integer j) throws MatrixExceptioon {
		// TODO Auto-generated method stub
		return (T) data[i][j];
	}

	@Override
	public IMatrix<T> addMatrix(IMatrix<T> otherMatrix) throws MatrixExceptioon {
		// TODO Auto-generated method stub
		Matrix<T> result=new Matrix<>(rows, cols);
		for(int i=0;i<rows;i++)
		{
			for(int j=0;j<cols;j++)
			{
				T sum=addValues(getElement(i,j),otherMatrix.getElement(i, j));
				result.setElement(i, j, sum);
			}
		}
		return result;
	}
	/**
     * Sets the value at the specified position (internal helper - not part of interface).
     *
     * @param row   row index (0-based)
     * @param col   column index (0-based)
     * @param value value to set
     * @throws MatrixException if indices are out of bounds
     */
	public void setElement(int row,int col,T value)
	{
		data[row][col]=value;
	}
	
	//Helper function that return the sum of a double or integer
	@SuppressWarnings({ "unchecked" })
	private T addValues(Number a, Number b) {
        if (a instanceof Double || b instanceof Double) {
            return (T) Double.valueOf(a.doubleValue() + b.doubleValue());
        } else {
            return (T) Integer.valueOf(a.intValue() + b.intValue());
        }
	}

	@Override
	public IMatrix<T> addScalar(Integer c) throws MatrixExceptioon {
		// TODO Auto-generated method stub
		Matrix<T> result=new Matrix<>(rows, cols);
		for(int i=0;i<rows;i++)
		{
			for(int j=0;j<cols;j++)
			{
				T sum=addValues(getElement(i,j),c);
				result.setElement(i, j, sum);
			}
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public IMatrix<Double> addScalar(Double c) throws MatrixExceptioon {
		// TODO Auto-generated method stub
		Matrix<T> result=new Matrix<>(rows, cols);
		for(int i=0;i<rows;i++)
		{
			for(int j=0;j<cols;j++)
			{
				T sum=addValues(getElement(i,j),c);
				result.setElement(i, j, sum);
			}
		}
		return (IMatrix<Double>) result;
	}

	@Override
	public IMatrix<T> multiplyScalar(Integer c) throws MatrixExceptioon {
		// TODO Auto-generated method stub
		
		Matrix<T> result=new Matrix<>(rows, cols);
		for(int i=0;i<rows;i++)
		{
			for(int j=0;j<cols;j++)
			{
				Number sum=MultiplyValues(getElement(i,j),c);
				result.setElement(i, j, (T) sum);
			}
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public IMatrix<Double> multiplyScalar(Double c) throws MatrixExceptioon {
		// TODO Auto-generated method stub
		Matrix<T> result=new Matrix<>(rows, cols);
		for(int i=0;i<rows;i++)
		{
			for(int j=0;j<cols;j++)
			{
				Number sum=MultiplyValues(getElement(i,j),c);
				result.setElement(i, j, (T) sum);
			}
		}
		return (IMatrix<Double>) result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public IMatrix<T> multiplyMatrix(IMatrix<T> otherMatrix) throws MatrixExceptioon {
		// TODO Auto-generated method stub
		Matrix<T> result = new Matrix<>(rows, otherMatrix.numberCols());
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < otherMatrix.numberCols(); j++) {
                Number sum = 0;
                for (int k = 0; k < cols; k++) {
                    sum = addValues(sum, MultiplyValues(getElement(i, k), otherMatrix.getElement(k, j)));
                }
                result.setElement(i, j, (T) sum);
            }
        }
        return result;
	}

	@Override
	public IMatrix<T> transpose() throws MatrixExceptioon {
		// TODO Auto-generated method stub
		Matrix<T> result= new Matrix<>(rows, cols);
		for(int i=0;i<rows;i++)
		{
			for(int j=0;j<cols;j++)
			{
				T trans=getElement(i,j);
				result.setElement(j, i, trans);
			}
		}
		return result;
	}
	
	public String toString() {
	    if (rows == 0 || cols == 0) {
	        return "Empty matrix (" + rows + "×" + cols + ")";
	    }

	    StringBuilder sb = new StringBuilder();
	    for (int i = 0; i < rows; i++) {
	        sb.append("[");
	        for (int j = 0; j < cols; j++) {
	            try {
	                sb.append(getElement(i, j));
	                if (j < cols - 1) {
	                    sb.append("  ");   
	                }
	            } catch (MatrixExceptioon e) {
	                sb.append("ERR"); 
	            }
	        }
	        sb.append("]\n");
	    }
	    return sb.toString();
	}
	
	//helper function that return the product of double or integer
	private Number MultiplyValues(Number a,Number b)
	{
		if(a instanceof Double || b instanceof Double)
		{
			return a.doubleValue() * b.doubleValue();
		}
		else
		{
			return a.intValue() * b.intValue();
		}
	}

}
