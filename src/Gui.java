import java.util.Random;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Gui extends VBox{
	private int rows;
	private int cols;
	private int IntegerScalar;
	private double DoubleScalar;
	
	private TextField txtRows;
	private TextField txtCols;
	private TextField txtIntegerScalar;
	private TextField txtDoubleScalar;
	private Button btnSetMatrix;
	private Button btnAddMatrixs;
	private Button btnAddIntegerScalar;
	private Button btnAddDoubleScalar;
	private Button btnMultiplyMatrixs;
	private Button btnMultiplyIntegerScalar;
	private Button btnMultiplyDoubleScalar;
	private TextArea DisplayMatrix;
	
	public Gui(Stage stage)
	{
		SetupUi();
		Random rand= new Random();
		
		
		btnAddMatrixs.setOnAction((e)->
		{
			rows=Integer.parseInt(txtRows.getText());
			cols=Integer.parseInt(txtCols.getText());
			Matrix<Integer> matrixA = generateRandomMatrix(rand);
	        Matrix<Integer> matrixB = generateRandomMatrix(rand);
			try {
				DisplayMatrix.setText(String.valueOf(matrixA.addMatrix(matrixB)));
			} catch (MatrixExceptioon e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
		});
		
		btnAddIntegerScalar.setOnAction((e)->{
			rows=Integer.parseInt(txtRows.getText());
			cols=Integer.parseInt(txtCols.getText());
			
			if(!isInteger(txtIntegerScalar.getText()))
			{
				DisplayMatrix.setText("Please enter valid integers scalar.");
		        return;
			}
			IntegerScalar=Integer.parseInt(txtIntegerScalar.getText());
			Matrix<Integer> matrixA = generateRandomMatrix(rand);
			try {
				DisplayMatrix.setText(String.valueOf(matrixA.addScalar(IntegerScalar)));
			} catch (MatrixExceptioon e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
		btnAddDoubleScalar.setOnAction((e)->
		{
			rows=Integer.parseInt(txtRows.getText());
			cols=Integer.parseInt(txtCols.getText());
			
			if(!isDouble(txtDoubleScalar.getText()))
			{
				DisplayMatrix.setText("Please enter valid DOUBLE scalar.");
		        return;
			}
			DoubleScalar=Double.parseDouble(txtDoubleScalar.getText());
			Matrix<Integer> matrixA = generateRandomMatrix(rand);
			try {
				DisplayMatrix.setText(String.valueOf(matrixA.addScalar(DoubleScalar)));
			} catch (MatrixExceptioon e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
		btnMultiplyDoubleScalar.setOnAction((e)->
		{
			rows=Integer.parseInt(txtRows.getText());
			cols=Integer.parseInt(txtCols.getText());
			
			if(!isDouble(txtDoubleScalar.getText()))
			{
				DisplayMatrix.setText("Please enter valid DOUBLE.");
		        return;
			}
			DoubleScalar=Double.parseDouble(txtDoubleScalar.getText());
			Matrix<Integer> matrixA = generateRandomMatrix(rand);
			try {
				DisplayMatrix.setText(String.valueOf(matrixA.multiplyScalar(DoubleScalar)));
			} catch (MatrixExceptioon e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
		btnMultiplyIntegerScalar.setOnAction((e)->
		{
			rows=Integer.parseInt(txtRows.getText());
			cols=Integer.parseInt(txtCols.getText());
			
			if(!isInteger(txtIntegerScalar.getText()))
			{
				DisplayMatrix.setText("Please enter valid integers.");
		        return;
			}
			IntegerScalar=Integer.parseInt(txtIntegerScalar.getText());
			Matrix<Integer> matrixA = generateRandomMatrix(rand);
			try {
				DisplayMatrix.setText(String.valueOf(matrixA.multiplyScalar(IntegerScalar)));
			} catch (MatrixExceptioon e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
		btnMultiplyMatrixs.setOnAction((e)->
		{
			rows=Integer.parseInt(txtRows.getText());
			cols=Integer.parseInt(txtCols.getText());
			Matrix<Integer> matrixA = generateRandomMatrix(rand);
	        Matrix<Integer> matrixB = generateRandomMatrix(rand);

	        
			try {
				DisplayMatrix.setText(String.valueOf(matrixA.multiplyMatrix(matrixB)));
			} catch (MatrixExceptioon e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
	}
	private Matrix<Integer> generateRandomMatrix(Random rand) {

	    Matrix<Integer> matrix = new Matrix<>(rows, cols);

	    for (int i = 0; i < rows; i++) {
	        for (int j = 0; j < cols; j++) {
	            matrix.setElement(i, j, rand.nextInt(10));
	        }
	    }

	    return matrix;
	}

	private void SetupUi()
	{
		this.setSpacing(5);
		
		txtRows=new TextField();
		txtRows.setPromptText("Enter number of rows");
		
		txtIntegerScalar= new TextField();
		txtIntegerScalar.setPromptText("Enter Integer scalar");
		
		txtDoubleScalar=new TextField();
		txtDoubleScalar.setPromptText("Enter double scalar");
		
		txtCols=new TextField();
		txtCols.setPromptText("Enter number of cols");
		
		btnAddMatrixs= new Button("Add Matrixs");
		btnAddDoubleScalar=new Button("Add Double scalar Matrix");
		btnAddIntegerScalar=new Button("Add Integer scalar Matrix");
		btnMultiplyDoubleScalar= new Button("Multiply Double scalar Matrix" );
		btnMultiplyIntegerScalar= new Button("Multiply Integer scalar Matrix");
		btnMultiplyMatrixs=new Button("Multiply Matrixs");
		DisplayMatrix=new TextArea();
		
		HBox hbox= new HBox(2, btnAddMatrixs,btnAddDoubleScalar,btnAddIntegerScalar,btnMultiplyDoubleScalar,btnMultiplyIntegerScalar,
				btnMultiplyMatrixs);
		
		this.getChildren().addAll(txtRows,txtCols,txtDoubleScalar,txtIntegerScalar,hbox,DisplayMatrix);
	}
	private boolean isInteger(String text) {
	    try {
	        Integer.parseInt(text);
	        return true;
	    } catch (NumberFormatException e) {
	        return false;
	    }
	}
	private boolean isDouble(String text) {
	    try {
	        Double.parseDouble(text);
	        return true;
	    } catch (NumberFormatException e) {
	        return false;
	    }
	}

}
