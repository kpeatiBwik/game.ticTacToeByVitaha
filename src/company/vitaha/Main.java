package company.vitaha;

import java.util.Scanner;

/*Плохо написаный код труднее сломать ;)*/
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Hello, my dear friend\nПожалуйста выбери чем будешь играть x или o\n1. x\n2. o");
		String chooseSymbol = sc.nextLine();
		String pl = null;
		String ii = null;
		try {
			if (Integer.parseInt(chooseSymbol) == 1) {
				pl = "x";
				ii = "o";
			} else if (Integer.parseInt(chooseSymbol) == 2) {
				pl = "o";
				ii = "x";
			} else {
				System.out.println("Ты неправильно выбрал символ.\nТвой символ -> x");
				pl = "x";
				ii = "o";
			}
		} catch (Exception e) {
			System.out.println("Ты неправильно выбрал символ.\nТвой символ -> x");
			pl = "x";
			ii = "o";
		}
		String s[][] = new String[3][3];
		int temp = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				s[i][j] = "" + temp + "";
				temp++;
			}
		}
		int res = 0;
		int finish = 0;
		int count = 0;
		while (finish == 0) {
			int sw;
			draw(s);
			if (count % 2 == 0) {
				sw = 0;
			} else {
				sw = 1;
			}
			if (sw == 0) {
				System.out.println("Ходит игрок -> " + pl);
				try {
					String enter = sc.nextLine();
					if (Integer.parseInt(enter) >= 0 || Integer.parseInt(enter) < 9) {
						for (int i = 0; i < 3; i++) {
							for (int j = 0; j < 3; j++) {
								if (s[i][j].equals(enter)) {
									s[i][j] = pl;
								}
							}
						}
					}
				} catch (Exception e) {
					System.out.println("Вы ввели неверное значение и поэтому повторите ход");
					res--;
				}
			} else {
				System.out.println("Ходит игрок -> " + ii);
				boolean bool = false;
				while (!bool) {
					int enterIi = (int) (Math.random() * 8);
					for (int i = 0; i < 3; i++) {
						for (int j = 0; j < 3; j++) {
							if (s[i][j].equals(Integer.toString(enterIi))) {
								s[i][j] = ii;
								bool = true;
							}
						}
					}
				}
			}
			count++;
			// logic lines;
			for (int i = 0; i < 3; i++) {
				int x = 0;
				for (int j = 1; j < 3; j++) {
					if (s[i][0].equals(s[i][j])) {
						x++;
					}
					if (x != 0 && x % 2 == 0) {
						System.out.println("Победил игрок игравший = " + s[i][0]);
						finish++;
						draw(s);
						break;
					}
				}
			}
			// logic columns;
			for (int j = 0; j < 3; j++) {
				int x = 0;
				for (int i = 1; i < 3; i++) {
					if (s[0][j].equals(s[i][j])) {
						x++;
					}
					if (x != 0 && x % 2 == 0) {
						System.out.println("Победил игрок игравший = " + s[0][j]);
						finish++;
						draw(s);
						break;
					}
				}
			}
			// logic diagonal_1;
			int x = 0;
			for (int i = 1; i < 3; i++) {
				if (s[0][0].equals(s[i][i])) {
					x++;
				}
				if (x != 0 && x % 2 == 0) {
					System.out.println("Победил игрок игравший = " + s[0][0]);
					finish++;
					draw(s);
					break;
				}
			}
			// logic diagonal_2;
			int c = 0;
			int y = 1;
			int a = s[0].length - 1;
			for (int i = 1; i < 3; i++) {
				if (s[0][a].equals(s[i][y])) {
					c++;
				}
				y--;
				if (c != 0 && c % 2 == 0) {
					System.out.println("Победил игрок игравший = " + s[0][a]);
					finish++;
					draw(s);
					break;
				}
			}
			res++;
			if (res == 9 && finish == 0) {
				System.out.println("Ничья");
				break;
			}
		}
		sc.close();
	}

	private static void draw(String[][] s) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(s[i][j] + " ");
				if (j == 2) {
					System.out.println();
				}
			}
		}
	}
}
