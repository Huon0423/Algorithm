import java.util.*;

class Solution {
    static Map<Integer, int[]> nodes;
    
    public int[] solution(int[][] edges) {
        nodes = new HashMap<>();
        int[] answer = {0, 0, 0, 0};
        int[] count;
        
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            if (!nodes.containsKey(a)) {
                nodes.put(a, new int[]{0, 0});
            }
            if (!nodes.containsKey(b)) {
                nodes.put(b, new int[]{0, 0});
            }
            nodes.get(a)[0] += 1;
            nodes.get(b)[1] += 1;
        }
        
        for (int key : nodes.keySet()) {
            count = nodes.get(key);
            if (count[0] >= 2 && count[1] == 0) {
                answer[0] = key;
                continue;
            }
            if (count[0] == 0 && count[1] > 0) {
                answer[2]++;
                continue;
            } 
            if (count[0] >= 2 && count[1] >= 2) {
                answer[3]++;
            }
        }
        answer[1] = nodes.get(answer[0])[0] - answer[2] - answer[3];
        return answer;
    }
}
