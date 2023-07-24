import java.util.Random;

public class LD1_08_201RDB002 {
	public static void fillSpecialMatrica(int[][] matrice) {
		Random random = new Random();
		int a;
		for (int i = 0; i < matrice.length; i++) {
			for (int j = 0; j < matrice.length; j++) {
				if (j >= i) {
					matrice[i][j] = random.nextInt((50 - (-50)) +1) + (-50);
				do {
					a = random.nextInt(100) - 50;
					matrice[i][j] = a;
				} while (a == 0);
				}
				else
				matrice[i][j] = 0;
			}
		}
	}

	public static void PrintMatrice(int[][] matrice) {
		System.out.println();
		System.out.println("5x5 matrice:");
		System.out.println();
		for (int i = 0; i < matrice.length; i++) {
			for (int j = 0; j < matrice.length; j++) {
				System.out.print(matrice[i][j] + "\t");
			}
			System.out.print("\n");
		}
		System.out.println();
	}

	public static int[] matricaToVector(int[][] matrice) {
		int[] vector = new int[(matrice.length * (matrice.length + 1)) / 2];
		int k = 0;
		for (int i = 0; i < matrice.length; i++) {
			for (int j = 0; j < matrice.length; j++) {
				if (matrice[i][j] != 0)
					vector[k++] = matrice[i][j];
			}
		}
		return vector;
	}

	public static void executeTask(int[][] matrice, int[] vector) {
		long startTime, endTime, executionTimeMatrica, executionTimeVektors;
		startTime = System.nanoTime();
		int n1 = 0;
		for (int i = 0; i < matrice.length; ++i) {
			for (int j = 0; j < matrice[i].length; ++j) {
				if (matrice[i][j] < 0) {
					n1++;
				}
			}
		}
		endTime = System.nanoTime();
		executionTimeMatrica = (endTime - startTime);
		startTime = System.nanoTime();
		int f2 = 0;
		for (int i = 0; i < vector.length; ++i) {
			if (vector[i] > 0) {
				f2++;
			}
		}
		endTime = System.nanoTime();
		executionTimeVektors = (endTime - startTime);
		System.out.printf("|| %3dx%3d\t|| %5d\t|| %14d\t|| %14d\t|| %5d\t||\n", matrice.length, matrice.length, n1,
				executionTimeMatrica, executionTimeVektors, (executionTimeMatrica - executionTimeVektors));
	}

	public static void main(String[] args) {
		System.out.println("Pauls Brikmanis 201RDB002 5.grupa");
		int[][] a, b, c;
		a = new int[5][5];
		b = new int[500][500];
		c = new int[5000][5000];
		fillSpecialMatrica(a);
		fillSpecialMatrica(b);
		fillSpecialMatrica(c);
		PrintMatrice(a);
		int[] av, bv, cv;
		av = matricaToVector(a);
		bv = matricaToVector(b);
		cv = matricaToVector(c);
		System.out.println("=================================================================================================");
		System.out.println("|| Izmers\t|| Rezultats\t|| Laiks 1\t|| Laiks 2\t|| Starpiba\t||");
		System.out.println("=================================================================================================");
		executeTask(a, av);
		executeTask(b, bv);
		executeTask(c, cv);

	}
}