/*문제
어떤 문장을 키를 이용하여 다음과 같이 암호화하려 한다. 암호화하기 전의 문장을 평문이라 하며, 암호화 된 문장은 암호문이라고 한다. 키, 평문, 암호문은 모두 영어 대문자로 된 공백 없는 문장이다.

키의 길이를 N이라고 했을 때, 우선 평문을 N 글자씩 잘라서 다음과 같이 나열한다. 예를 들어 평문이 MEETMEBYTHEOLDOAKTREENTH 이고, 키가 BATBOY라고 해 보자.

B	A	T	B	O	Y
M	E	E	T	M	E
B	Y	T	H	E	O
L	D	O	A	K	T
R	E	E	N	T	H
제일 윗줄은 이해를 돕기 위해 키를 다시 한 번 쓴 것이다. 이제 이 행렬(배열)을 열(Column) 단위로 정렬을 하는데, 정렬을 하는 키준은 키의 문자로 한다. 즉 BATBOY를 정렬하여 ABBOTY와 같이 정렬하는 것이다. B와 같이 여러 번 나타나는 문자의 경우에는 원래의 행렬에서 더 왼쪽에 있었던 것을 먼저 쓴다. 정렬을 한 행렬은 다음과 같다.

A	B	B	O	T	Y
E	M	T	M	E	E
Y	B	H	E	T	O
D	L	A	K	O	T
E	R	N	T	E	H
B는 두 가지가 있기 때문에 더 왼쪽에 있었던 (B)MBLR이 먼저 나왔다. 이제 이와 같이 정렬한 행렬을 열 번호가 작은 것 먼저, 열 번호가 같다면 행 번호가 작은 것 순으로 나열하면 암호문이 된다. 즉 위와 같은 경우의 암호문은 EYDEMBLRTHANMEKTETOEEOTH 가 된다.

키와 암호문이 주어졌을 때, 이를 이용하여 평문을 구하는 프로그램을 작성하시오.

입력
첫째 줄에 키가 주어지고, 둘째 줄에 암호문이 주어진다. 키와 암호문은 모두 영어 대문자로만 되어 있으며, 암호문의 길이가 항상 키의 길이의 배수라고 하자. 키의 길이는 10자 이하이며 암호문의 길이는 100자 이하이다.

출력
첫째 줄에 평문을 출력한다.*/
// 험딩을 알파벳으로 정렬하고 dgi --- 이렇게 받고 밑에거 쪼개서 넣은 다음에 다시 험딩으로 바꾸면서 평문 출력
/*
키 (배열로 선언)입력 받고 스트링으로 쪼개서 입력받은거 갯수를 저장 k0 k1 k2 k3 k4 --- 단어르 ㄹ쪼깨면서 갯수 저장
문장 입력 받고 단어를 쪼개고 갯수 저장
키 정렬하고
문장/ 키
k0에 문장/키 수 만큼 문장 for문 돌려서 배열 쪼개서 배열에 초기화 */

import java.util.*;
import java.io.*;

import java.io.*;
import java.util.*;

public class baek2149 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 키와 암호문 입력
        String key = br.readLine();
        String encryptedMessage = br.readLine();

        int keyLength = key.length();
        int rows = encryptedMessage.length() / keyLength; // 항상 정수로 나누어짐

        // 키 정렬 및 정렬된 키의 순서 저장
        Character[] sortedKey = new Character[keyLength];
        for (int i = 0; i < keyLength; i++) {
            sortedKey[i] = key.charAt(i);
        }
        Arrays.sort(sortedKey);

        // 정렬된 키의 열 순서 계산
        int[] keyOrder = new int[keyLength];
        for (int i = 0; i < keyLength; i++) {
            for (int j = 0; j < keyLength; j++) {
                if (sortedKey[i] == key.charAt(j)) {
                    keyOrder[i] = j; // 정렬된 키의 i번째 문자가 원래 키의 j번째 위치
                    key = key.substring(0, j) + "#" + key.substring(j + 1); // 중복 처리
                    break;
                }
            }
        }

        // 암호문을 행렬로 나누기
        char[][] encryptedMatrix = new char[rows][keyLength];
        int idx = 0;
        for (int i = 0; i < keyLength; i++) {
            for (int j = 0; j < rows; j++) {
                encryptedMatrix[j][keyOrder[i]] = encryptedMessage.charAt(idx++);
            }
        }

        // 원본 메시지 복원
        StringBuilder decryptedMessage = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < keyLength; j++) {
                decryptedMessage.append(encryptedMatrix[i][j]);
            }
        }

        // 결과 출력
        System.out.println(decryptedMessage);
    }
}

