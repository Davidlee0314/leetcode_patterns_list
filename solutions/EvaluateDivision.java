class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        /*
        Construct a graph that link A to B with value as weight. Then, the query result will be the path weight product.
        time O(nm) n as query number, m as the total equation, space O(m + n)
        */
        HashMap<String, HashMap<String, Double>> graph = new HashMap<>();
        for(int i = 0; i < equations.size(); i++){
            String A = equations.get(i).get(0), B = equations.get(i).get(1);
            if(!graph.containsKey(A)) graph.put(A, new HashMap<>());
            if(!graph.containsKey(B)) graph.put(B, new HashMap<>());
            graph.get(A).put(B, values[i]);
            graph.get(B).put(A, 1 / values[i]);
        }
        
        double[] res = new double[queries.size()];
        for(int i = 0; i < queries.size(); i++){
            res[i] = dfs(1, queries.get(i).get(0), queries.get(i).get(1), graph, new HashSet<>());
        }
        return res;
    }
    private double dfs(double val, String start, String end, HashMap<String, HashMap<String, Double>> graph, HashSet<String> visited){
        if(!graph.containsKey(start) || visited.contains(start)) return -1;
        if(start.equals(end)) return val;
        visited.add(start);
        for(String next: graph.get(start).keySet()){
            double subRes = dfs(graph.get(start).get(next) * val, next, end, graph, visited);
            if(subRes != -1) return subRes;
        }
        return -1;
    }
}