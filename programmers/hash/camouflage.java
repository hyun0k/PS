package hash;

import java.util.HashMap;

public class camouflage {
	/**
	 *  옷의 종류마다 개수를 세서 곱해주면 된다. 이 때 개수+1 값을 곱해야함. 단순한 경우의 수 문제. 
	 */
	public int solution(String[][] clothes) {

		HashMap<String, Integer> map = new HashMap<String, Integer>();

		for (int i = 0; i < clothes.length; i++) {
			String key = clothes[i][1];
			if (map.containsKey(key)) { // map에 해당 key에 대한 값이 이미 있을때 
				map.put(key, map.get(key) + 1);
			} else {					// 해당 key가 처음으로 들어온 값일때 
				map.put(key, 1);
			}
		}

		int ans = 1;
		for (int value : map.values()) {
			ans *= (value + 1);
		}
		ans--; // 모두 안입는 경우는 없으므로 전체 경우의 수에서 1을 빼준다. 

		return ans;
	}
}
