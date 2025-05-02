package sample;

import java.util.Arrays;

public class sample {

	public static void main(String[] args) {
		int num[][] = {{1,4,2,9,6,0,2,3,4},{1,4,2,9,6,0,2,8,4,7},{1,4,2,9},};
		final int SEARCH_NUMBER = 3;
		int index = 0;
		int row = -1;
		for(int i = 0; i < num.length; i++) {
			Arrays.sort(num[i]);
		index = Arrays.binarySearch(num[i], SEARCH_NUMBER);
		if(index >= 0) { //見つからなかった場合マイナスの値が返ってくるので「index >= 0」で有無の確認ができる
		row = i;
		break;
		}
		}
		if(index >= 0) {
		System.out.println(String.format("num[%s][%s]=%s", row, index, SEARCH_NUMBER));
		} else {
		System.out.println(String.format("num[][]に%sは存在しません", SEARCH_NUMBER));
		}
		
		float ans = 7 / 6;
		System.out.println(ans);
		
		for (int i = 1; i < 10; i++){ // (初期化式; 条件式; 変化式)
			System.out.println(i); // iが10より小さい場合に繰り返し実行する処理
			}
		for (int i = 1; i < 10; ++i){ // (初期化式; 条件式; 変化式)
			System.out.println(i); // iが10より小さい場合に繰り返し実行する処理
			}
	}

}
