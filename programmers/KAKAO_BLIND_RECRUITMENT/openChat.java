package KAKAO_BLIND_RECRUITMENT;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class openChat { // 오픈채팅방
	/**
	 *  출력은 입장, 퇴장할 때만 하면 된다. 최종 결과만 생각하면 된다. 
	 *  map에 저장할때 id가 key, nick이 value 
	 */
	public String[] solution(String[] record) {
		HashMap<String, String> map = new HashMap<String, String>();
		List<String> list = new ArrayList();

		for (int i = 0; i < record.length; i++) {
			String[] split = record[i].split(" ");
			if (!split[0].equals("Leave")) { //  Enter, Change 일때 map에 저장. 
				map.put(split[1], split[2]); // 채팅방에서 이름 바꾸는건 put하면 해당 키의 value가 갱신되므로 상관없다 
			}
		}

		for (int i = 0; i < record.length; i++) {
			String[] split = record[i].split(" ");
			if (split[0].equals("Enter")) {
				list.add(map.get(split[1]) + "님이 들어왔습니다.");
			}
			if (split[0].equals("Leave")) {
				list.add(map.get(split[1]) + "님이 나갔습니다.");
			}
		}

		String[] answer = new String[list.size()];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = list.get(i);
		}

		return answer;
	}

}
