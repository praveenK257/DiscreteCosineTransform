package dct;

public class DiscreteCosineTransform {
	
	/*
	* @praveenK257
	*
	*/
	
	public static int n;
	public static int m;
	public int[][] matrix;
	public static double pi = 3.142857;
		
	static strictfp double[][] dctTransform(int matrix[][])
	{
		int i, j, k, l;

		double[][] dct = new double[m][n];

		double ci, cj, dct1, sum;

		for (i = 0; i < m; i++)
		{
			for (j = 0; j < n; j++)
			{
				if (i == 0)
					ci = 1 / Math.sqrt(m);
				else
					ci = Math.sqrt(2) / Math.sqrt(m);
					
				if (j == 0)
					cj = 1 / Math.sqrt(n);
				else
					cj = Math.sqrt(2) / Math.sqrt(n);

				sum = 0;
				for (k = 0; k < m; k++)
				{
					for (l = 0; l < n; l++)
					{
						dct1 = matrix[k][l] *
								Math.cos((2 * k + 1) * i * pi / (2 * m)) *
								Math.cos((2 * l + 1) * j * pi / (2 * n));
						sum = sum + dct1;
					}
				}
				dct[i][j] = ci * cj * sum;
			}
		}

		return dct;
	}
		
		public DiscreteCosineTransform(int[][] matrix) {
			this.m = matrix.length;
			this.n = matrix[0].length;
			this.matrix = matrix;
		}
	
	}
