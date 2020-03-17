package App;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class alienDictionary {
    //  the key to this problem is realizing that this is about "topological order".
    //         a topological ordering is possible if and only if the graph has no directed cycles.
    //         solution strategy will be about building a graph & then performing a DFS on this graph.
    //         the following states will manage & make things easier:
    //         a. visited[i] = -1 // Not even exists
    //         a. visited[i] =  0 // Exists but not visited yet
    //         a. visited[i] =  1 // Visiting
    //         a. visited[i] =  2 // Visited
    private static final int N = 26;
    public String alienOrderDFS(String[] words) {

            int[] visited = new int[N];
            boolean[][] graph = new boolean[N][N];
            buildGraph(words, graph, visited);

            StringBuilder str = new StringBuilder();
            for (int i = 0; i < N; i++) {
                if(visited[i] == 0) {
                    if(!dfs(graph, visited, i, str))
                        return "";
                }
            }
            return str.reverse().toString();
    }
    // m words, n length each word, o(m * n)
    private void buildGraph(String[] words, boolean[][] graph, int[] visited) {

        // -1 means does not exist.
        Arrays.fill(visited, -1);
        //init the visited[N] array for all the characters in the current word
        for (int i = 0; i < words.length; i++) {
            char[] arr = words[i].toCharArray();
            for (char c : arr) {
                visited[c - 'a'] = 0;
            }

            if(i > 0) {
                String w1 = words[i - 1];
                String w2 = words[i];
                int length = Math.min(w1.length(), w2.length());
                for (int j = 0; j < length; j++) {
                    char c1 = w1.charAt(j);
                    char c2 = w2.charAt(j);
                    if(c1 != c2) {
                        graph[c1 - 'a'][c2 - 'a'] = true;
                        break;
                    }
                }
            }
        }
    }

    private boolean dfs(boolean[][] graph, int[] visited, int i, StringBuilder str) {
            visited[i] = 1;
            for (int j = 0; j < N; j++) {
                if(graph[i][j]) {
                    if(visited[j] == 1)
                        return false;
                    if(visited[j] == 0) {
                        if(!dfs(graph, visited, j, str))
                            return false;
                    }
                }
            }
            visited[i] = 2;
            str.append((char)(i + 'a'));
            return true;
    }

    public String alineOrderBFS(String[] words) {

            int[] visited = new int[N];
            boolean[][] graph = new boolean[N][N];
            buildGraph(words, graph, visited);
            int[] indegree = new int[N];
            StringBuilder str = new StringBuilder();

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(graph[i][j]) {
                        indegree[j]++;
                    }
                }
            }

            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < N; i++) {
                if(visited[i] == 0 && indegree[i] == 0) {
                    queue.offer(i);
                    str.append((char)(i + 'a'));
                }
            }
            while(!queue.isEmpty()) {
                int curr = queue.poll();
                for (int i = 0; i < N; i++) {
                    if(graph[curr][i]) {
                        indegree[i]--;
                        if(indegree[i] == 0) {
                            queue.offer(i);
                            str.append((char)(i + 'a'));
                        }
                    }
                }
            }
            int total = 0;
            for (int i = 0; i < N; i++) {
                if(visited[i] != -1)
                    total++;
            }
            if(total != str.length())
                return "";
            return str.toString();
    }
}
