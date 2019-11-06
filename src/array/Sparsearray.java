package array;

public class Sparsearray {

	public static void main(String[] args) {
		//创建原始的二维数组，0表示暂无数据
		int[][] arr = new int[11][11];
		arr[1][2]=1;
		arr[2][3]=2;
		arr[6][9]=5;
		arr[8][2]=3;
		
		int[][] sparseArray = toSparseArray(arr);
		print(sparseArray);
		
		System.out.println("----------------");
		
		int[][] rawArray = toRawArray(sparseArray);
		print(rawArray);
	}
	
	public static int[][] toSparseArray(int[][] arr) {
		
		int count = 0;
		int row =0;
		int col =0;
		
		//将二维数组转稀疏数组
		//获取有效数据个数(非0值)
		for(int i=0;i<(row=arr.length);i++) {
			for(int j=0;j<(col=arr[i].length);j++) {
				if(arr[i][j]!=0) {
					count++;
				}
			}
		}
		
		//根据有效数据个数创建稀疏数组
		int[][] sparseArr = new int[count+1][3];
		//为稀疏数组赋值
		sparseArr[0][0] = row;
		sparseArr[0][1] = col;
		sparseArr[0][2] = count;
		
		//遍历二维数组，将非0值数据付给稀疏数组
		int k=0;//用于记录是第几个非0数据
		for(int i=0;i<(row=arr.length);i++) {
			for(int j=0;j<arr[i].length;j++) {
				if(arr[i][j]!=0) {
					k++;
					sparseArr[k][0] = i;
					sparseArr[k][1] = j;
					sparseArr[k][2] = arr[i][j];
				}
			}
		}
		
		return sparseArr;
	}
	
	public static int[][] toRawArray(int[][] arr){
		
		int rawRow=arr[0][0];
		int rawcol=arr[0][1];
		int rawvalues=arr[0][2];
		
		int[][] rawArr = new int[rawRow][rawcol];
		
		for(int i=0;i<rawvalues;i++) {
			int r =arr[i+1][0];
			int c =arr[i+1][1];
			int v =arr[i+1][2];
			rawArr[r][c]=v;
		}
		
		return rawArr;
	}
	
	
	
	public static void print(int[][] arr) {
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
					System.out.printf(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
}
