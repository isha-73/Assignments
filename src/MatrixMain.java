// Isha Bule UCE2021610
// Assignment 1 : using array to perform matrix operations
import java.util.Scanner;
class Matrix {
    float[][] matrix = new float[10][10];
    int rows;
    int column;
    public Scanner sc = new Scanner(System.in);
    Matrix(int row, int column) {  // constructor to initialize rows and columns of matrix
        rows = row;
        this.column = column;
    }

    void MatrixCreation() {
        System.out.println("Enter the elements in the matrix row-wise");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < column; j++) {
                matrix[i][j] = sc.nextFloat(); // accepting the elements
            }
        }
    }

    void MatrixDisplay() {
        System.out.println("This is the required matrix");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print(" " + matrix[i][j]);
            }
            System.out.println();
        }
    }

    void MatrixAddition(Matrix obj1, Matrix obj2) {
        Matrix obj3=new Matrix(rows,column);  // creating new matrix object of new result matrix
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < column; j++) {
                obj3.matrix[i][j] = obj1.matrix[i][j] + obj2.matrix[i][j];
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print(" " + obj3.matrix[i][j]);
            }
            System.out.println();
        }

    }
void TriangularityOfMatrix() {
    int flag1 = 0;  // logic checks whether zero exists in lower triangle for upper triangular matrix
    for (int i = 1; i < rows; i++) {
        for (int j = 0; j < i; j++) {
            if (matrix[i][j] == 0.0f) {
                flag1 = 1;
            } else flag1 = 2;
        }
    }

    int flag2 = 0;
    for (int i = 0; i < rows; i++) {  // logic checks whether zero exists in upper triangle for lower triangular matrix
        for (int j = i + 1; j < column; j++) {
            if (matrix[i][j] == 0.0f) {
                flag2 = 1;
            }
        }
    }

    if (flag1 == 1) {
        System.out.println("Matrix is upper triangular");
    } else if (flag2 == 1) {
        System.out.println("Matrix is lower triangular");
    } else System.out.println("Neither upper nor lower triangular matrix");
}
    //     1 0 0 0
    //     2 2 0 0
    //     3 3 3 0
    //     1 2 3 2

    void MatrixMultiplication(Matrix a, Matrix b) {
        int i = 0, j;
        Matrix obj4 = new Matrix(a.rows, b.column);// product matrix

        for (i = 0; i < a.rows; i++) {   // product of matrix happens when column for first and row of second is same ,
            // as here we are inputting square matrix condition is not checkjed
            for (j = 0; j < b.column; j++) {
                for (int k = 0; k < a.column; k++) {
                    obj4.matrix[i][j] = obj4.matrix[i][j] + a.matrix[i][k] * b.matrix[k][j];
                }
            }
        }
        for (i = 0; i < obj4.rows; i++) {
            for (j = 0; j < obj4.column; j++) {
                System.out.print(" " + obj4.matrix[i][j]);
            }
            System.out.println();
        }
    }

    void Transpose() {
        for (int i = 0; i < column; i++) {
            for(int j = 0; j < rows; j++) {
                System.out.print(" "+matrix[j][i]);
            }
            System.out.println();
        }
    }
}
    public class MatrixMain {
        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);

            int rows1, column1;
            System.out.println("Enter the number of rows and column of the matrix 1");
            rows1 = sc.nextInt();
            column1 = sc.nextInt();

            Matrix matrix1 = new Matrix(rows1, column1);
            matrix1.MatrixCreation();
            matrix1.MatrixDisplay();

            int rows2, column2;
            System.out.println("Enter the number of rows and column of the another matrix 2");
            rows2 = sc.nextInt();
            column2 = sc.nextInt();

            Matrix matrix2 = new Matrix(rows2, column2);
            matrix2.MatrixCreation();
            matrix2.MatrixDisplay();
            int choice=0;
            do {

                System.out.println("Choose which matrix operation you have to perform : \n 1:Check Square or not \n 2.Check Upper or Lower Triangular \n 3.Transpose \n 4.Addition \n 5.Multiplication \n 0: EXIT ");
                choice = sc.nextInt();
                switch (choice) {
                    case 1:

                        if (rows1 == column1 && rows2 == column2) {
                            System.out.println("\n***Both matrices are square matrix***\n");
                        } else if (rows1 == column1) {
                            System.out.println("\n***Matrix 1 is square matrix***\n");
                        } else if (rows2 == column2) {
                            System.out.println("\n***Matrix 2 is square matrix\n***");
                        } else System.out.println("\n***None of both is square matrix\n***");
                        break;
                    case 2:
                        System.out.println("\n*****Checking if either of them is upper triangular or not*****\n");
                        if (rows1 == column1) {
                            System.out.println("\nChecking for matrix 1\n");
                            matrix1.TriangularityOfMatrix();
                        }
                        if (rows2 == column2) {
                            System.out.println("\nChecking for matrix 2\n");
                            matrix2.TriangularityOfMatrix();

                        }
                        break;
                    case 3:
                        System.out.println("\n****To make transpose of matrix, which matrix you want to transpose****\n");
                        int tra = sc.nextInt();
                        if (tra == 1) {
                            matrix1.Transpose();
                        } else matrix2.Transpose();
                        break;
                    case 4:
                        if (rows1 == rows2 && column1 == column2) {
                            System.out.println("****Addition of two matrix****");
                            matrix1.MatrixAddition(matrix1, matrix2);
                        } else {
                            System.out.println("\n****In addition,the number of columns and rows should be same , try again****\n");

                        }
                        break;
                    case 5:
                        System.out.println("Multiplication of two matrices");
                        if (matrix1.column == matrix2.rows) {
                            matrix2.MatrixMultiplication(matrix1, matrix2);
                        } else System.out.println("Matrix cannot be multiplied ");
                        break;

                }
            } while (choice != 0);
        }
    }

/*
"C:\Program Files\Java\jdk-18\bin\java.exe" "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2021.3.3\lib\idea_rt.jar=61627:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2021.3.3\bin" -Dfile.encoding=UTF-8 -classpath E:\JavaIntellij\out\production\JavaIntellij MatrixMain
Enter the number of rows and column of the matrix 1
3 3
Enter the elements in the matrix row-wise
5 6 3 2 4 3 5 5 8
This is the required matrix
 5.0 6.0 3.0
 2.0 4.0 3.0
 5.0 5.0 8.0
Enter the number of rows and column of the another matrix 2
3 2
Enter the elements in the matrix row-wise
5 4 2 1 3 5
This is the required matrix
 5.0 4.0
 2.0 1.0
 3.0 5.0
Choose which matrix operation you have to perform :
 1:Check Square or not
 2.Check Upper or Lower Triangular
 3.Transpose
 4.Addition
 5.Multiplication
 0: EXIT
1

***Matrix 1 is square matrix***

Choose which matrix operation you have to perform :
 1:Check Square or not
 2.Check Upper or Lower Triangular
 3.Transpose
 4.Addition
 5.Multiplication
 0: EXIT
2

*****Checking if either of them is upper triangular or not*****


Checking for matrix 1

Neither upper nor lower triangular matrix

Choose which matrix operation you have to perform :
 1:Check Square or not
 2.Check Upper or Lower Triangular
 3.Transpose
 4.Addition
 5.Multiplication
 0: EXIT
3

****To make transpose of matrix, which matrix you want to transpose****

2
 5.0 2.0 3.0
 4.0 1.0 5.0
Choose which matrix operation you have to perform :
 1:Check Square or not
 2.Check Upper or Lower Triangular
 3.Transpose
 4.Addition
 5.Multiplication
 0: EXIT
4

****In addition,the number of columns and rows should be same , try again****

Choose which matrix operation you have to perform :
 1:Check Square or not
 2.Check Upper or Lower Triangular
 3.Transpose
 4.Addition
 5.Multiplication
 0: EXIT
5
Multiplication of two matrices
 46.0 41.0
 27.0 27.0
 59.0 65.0
Choose which matrix operation you have to perform :
 1:Check Square or not
 2.Check Upper or Lower Triangular
 3.Transpose
 4.Addition
 5.Multiplication
 0: EXIT
0

Process finished with exit code 0

 */


















