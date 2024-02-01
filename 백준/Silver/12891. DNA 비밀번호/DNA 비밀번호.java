/*
 * DNA 문자열을 받고, 외소 개수를 저장할 배열과 슬라이딩 윈도우를 할 동안 현재 문자열의 각 문자 개수를 저장할 배열 생성
 * 슬라이딩 윈도우를 하기 전에, 옮길 윈도우 == 맨 처음의 부분문자열을 0부터 P-1까지 P길이로 잘라서 확인한다.
 * 그 후 P부터 차례대로 추가하고, 0부터 차례대로 빼서 P의 길이를 유지하며 부분문자열의 개수를 최소 개수와 비교한다.
 * 최소 개수를 모두 충족하면 answer를 추가한다.
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int sLeng = 4; // DNA 문자에 사용되는 문자의 개수
	static int[] minCount; // A C G T의 최소 개수를 저장할 배열
	static int[] count; // 현재 부분 문자열의 각 문자의 개수를 셀 배열
	static int answer = 0; // 비밀번호의 개수를 저장할 변수

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 출력
		StringTokenizer stk = new StringTokenizer(br.readLine()); // br로 값 읽어오기
		int S = Integer.parseInt(stk.nextToken()); // DNA 문자열 길이 S 입력
		int P = Integer.parseInt(stk.nextToken()); // 패스워트 길이 P 입력
		stk = new StringTokenizer(br.readLine()); // br로 값 읽어오기
		char[] DNA = stk.nextToken().toCharArray(); // DNA 문자열

		// 최소 개수 값 입력
		stk = new StringTokenizer(br.readLine()); // br로 값 읽어오기
		minCount = new int[sLeng]; // sLeng만큼 초기화
		for (int i = 0; i < sLeng; i++) {
			minCount[i] = Integer.parseInt(stk.nextToken()); // 최소 개수 저장
		}

		count = new int[sLeng]; // sLeng만큼 초기화
		for (int i = 0; i < P; i++) { // 비밀번호만큼 돌면서
			switch (DNA[i]) { // 만약 DNA[i] 값이 아래와 같다면 해당하는 문자 개수 ++
			case 'A':
				count[0]++;
				break;
			case 'C':
				count[1]++;
				break;
			case 'G':
				count[2]++;
				break;
			case 'T':
				count[3]++;
				break;
			default:
				break;
			}
		}
		checkPassword(); // DNA의 0부터 P-1까지의 번호가 합당한지 확인
		
		// 슬라이딩 윈도우 기법으로 한칸씩 양옆으로 이동하며 값 확인
		for(int i=P; i<S; i++) {
			switch (DNA[i]) { // 추가할 값이 아래와 같다면 해당하는 문자 개수 ++
			case 'A':
				count[0]++;
				break;
			case 'C':
				count[1]++;
				break;
			case 'G':
				count[2]++;
				break;
			case 'T':
				count[3]++;
				break;
			default:
				break;
			}
			switch (DNA[i-P]) { // 뺄 값이 아래와 같다면 해당하는 문자 개수 --
			case 'A':
				count[0]--;
				break;
			case 'C':
				count[1]--;
				break;
			case 'G':
				count[2]--;
				break;
			case 'T':
				count[3]--;
				break;
			default:
				break;
			}
			checkPassword(); // 양쪽에서 한칸씩 옮기고, 옮길 때마다 문자 개수를 세서 비밀번호 체므
		}
		
		bw.append(Integer.toString(answer)); // bw에 min 저장
		bw.flush(); // bw 출력
		br.close(); // 입력 종료
		bw.close(); // 출력 종료
	}

	static void checkPassword() { // 현재 문자열이 합당한 번호 => answer++
		for (int i = 0; i < sLeng; i++) { // DNA 문자의 개수만큼 돌며
			if (count[i] < minCount[i]) { // 현재 문자열의 해당 문자의 개수가 최소 개수보다 작다면,
				return; // false
			}
		}
		answer++; // 합당한 비밀번호 => answer++;
	}
}
