/**
 * 
 */
package com.dp;

/**
 * @author nakul Given a value N, if we want to make change for N cents, and we
 *         have infinite supply of each of S = { S1, S2, .. , Sm} valued coins,
 *         how many ways can we make the change? The order of coins doesn’t
 *         matter.
 * 
 *         Reference : https://www.youtube.com/watch?v=jaNZ83Q3QGc
 */
public class CoinChangeProblem {

	static int coinChange(int coins[], int amount) {
		int combinations[] = new int[amount + 1];

		combinations[0] = 1;

		for (int coin : coins) {
			for (int i = 1; i < combinations.length; i++) {
				if (i >= coin) {
					combinations[i] += combinations[i - coin];
				}
			}
		}

		return combinations[amount];
	}

	static void show(int table[]) {
		System.out.println("array : ");
		for (int i = 0; i < table.length; i++) {
			System.out.print(table[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3 };
		System.out.println(coinChange(arr, 4));
	}

}
