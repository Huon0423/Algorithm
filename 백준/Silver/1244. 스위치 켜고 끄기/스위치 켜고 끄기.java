import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 출력
		StringBuilder sb = new StringBuilder();

		// 입력 받기
		int count = Integer.parseInt(br.readLine()); // 스위치의 총 개수
		int[] switches = new int[count]; // 스위치의 상태를 저장할 배열
		StringTokenizer st = new StringTokenizer(br.readLine()); // 스위치 상태를 받을 st
		for (int i = 0; i < count; i++) {
			switches[i] = Integer.parseInt(st.nextToken()); // 스위치 배열에 스위치 상태 넣기
		}

		int students = Integer.parseInt(br.readLine()); // 총 학생 수

		// 학생을 입력받을 때마다 스위치 상태 변환
		for (int s = 0; s < students; s++) {
			st = new StringTokenizer(br.readLine()); // 학생 수를 st에 저장
			int gender = Integer.parseInt(st.nextToken()); // 성별 입력
			int receivedSwitch = Integer.parseInt(st.nextToken()); // 받은 스위치 입력

			if (gender == 1) { // 남학생의 경우
				for (int j = 0; j < count; j++) { // 스위치 전체를 돌며
					if ((j + 1) % receivedSwitch == 0) { // index는 0부터 시작 / 받은 스위치는 1부터 시작 => +1해서 계산
						if (switches[j] == 0) { // 배수의 상태가 0이면
							switches[j] = 1; // 1로 전환
							continue; // 넘김
						}
						switches[j] = 0; // 배수의 상태가 1이면 0으로 전환
					}
				}
				continue; // 받은 값이 남학생이었으므로, 여학생 경우 필요X => 다음 입력을 위해 넘김
			}

			// 여학생의 경우

			if (switches[receivedSwitch-1] == 0) { // 받은 스위치의 상태가 0이면
				switches[receivedSwitch-1] = 1; // 1로 전환
			} else {
				switches[receivedSwitch-1] = 0; // 상태가 1이면 0으로 전환
			}

			for (int j = 1; j < count / 2; j++) { // 1부터 스위치의 절반까지 돌며 => 대칭이므로 +-처리 => 절반만 있어도 됨
				if (receivedSwitch - 1 + j >= count || receivedSwitch - 1 - j < 0) { // index가 배열 크기 밖이라면
					break; // 넘김
				}
				if (switches[receivedSwitch - 1 - j] == switches[receivedSwitch - 1 + j]) { // 대칭이라면
					if (switches[receivedSwitch - 1 - j] == 0) { // 상태가 0이라면
						switches[receivedSwitch - 1 - j] = 1; // 1로 바꿈
						switches[receivedSwitch - 1 + j] = 1; // 대칭이므로 같은 값 => 1로 바꿈
					} else {
						switches[receivedSwitch - 1 - j] = 0; // 상태가 1이라면 0으로 바꿈
						switches[receivedSwitch - 1 + j] = 0; // 대칭이므로 같이 바꿈
					}
					continue; // 넘김
				}
				break; // 대칭이 아니라면 그만 돌기
			}
		}

		for (int i = 0; i < count; i++) { // 스위치 개수만큼 돌며
			sb.append(switches[i]).append(" "); // 스위치의 상태와 빈칸 추가
			if ((i + 1) % 20 == 0) // 다음값이 20의 배수+1번째라면
				sb.append("\n"); // 줄 추가
		}
		bw.append(sb); // bw에 sb 추가
		bw.flush(); // 모두 출력
		br.close(); // 입력 종료
		bw.close(); // 출력 종료
	}
}
