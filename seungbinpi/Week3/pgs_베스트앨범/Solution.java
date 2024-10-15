import java.util.*;

class Solution {
    public Object[] solution(String[] genres, int[] plays) {
		
		int N = genres.length;
		
		HashMap<String, Integer> map = new HashMap<>();
		for (int i=0; i<N; i++) {
			String genre = genres[i];
			if (!map.containsKey(genre)) {
				map.put(genre, plays[i]);
			}
			else {
				map.replace(genre, map.get(genre)+plays[i]);
			}
		}
		
		ArrayList<Object[]> list = new ArrayList<>();
		for (String genre : map.keySet()) {
			Object[] tmp = new Object[2];
			tmp[0] = genre;
			tmp[1] = map.get(genre);
			list.add(tmp);
		}
		Collections.sort(list, (a,b) -> (Integer) b[1] - (Integer) a[1]);
		
		HashMap<String, List<Integer[]>> map2 = new HashMap<>();
		for (int i=0; i<N; i++) {
			String genre = genres[i];
			Integer[] tmp = new Integer[2];
			tmp[0] = i;
			tmp[1] = plays[i];
			if (!map2.containsKey(genre)) {
				List<Integer[]> tmpList = new ArrayList<>();
				map2.put(genre, tmpList);
			}
			map2.get(genre).add(tmp);
		}
		
		for (String genre : map2.keySet()) {
			Collections.sort(map2.get(genre), (a,b) -> a[0] - b[0]);
			Collections.sort(map2.get(genre), (a,b) -> b[1] - a[1]);
		}
		
		List<Integer> result = new ArrayList<>();
		
		for (int i=0; i<list.size(); i++) {
			String genre = (String) list.get(i)[0];
			for (int j=0; j<2; j++) {
				if (map2.get(genre).size()==1 && j==1) continue;
				result.add(map2.get(genre).get(j)[0]);
			}
		}
		
		return result.toArray();
	}
}