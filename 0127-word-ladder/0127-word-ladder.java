class Solution {
    class Pair{
        String word;
        int ind;
        public  Pair (String word,int ind){
            this.word=word;
            this.ind=ind;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set=new HashSet<>();
        set.addAll(wordList);
        if (!set.contains(endWord)) {
            return 0;
        }
        Queue<Pair> q=new ArrayDeque<>();
        q.add(new Pair(beginWord,1));

        while(!q.isEmpty()){
            Pair curr = q.poll();

            String word = curr.word;
            int level = curr.ind;
             if (word.equals(endWord)) {
                return level;
            }
            for (int i = 0; i < word.length(); i++) {

                char original = word.charAt(i);

                for (char ch = 'a'; ch <= 'z'; ch++) {
                    if (ch == original) {
                        continue;
                    }

                    StringBuilder sb = new StringBuilder(word);
                    sb.setCharAt(i, ch);

                    String newWord = sb.toString();
                    if (set.contains(newWord)) {
                        set.remove(newWord);
                        q.add(new Pair(newWord, level + 1));
                    }
                }
            }
        }return 0;
    }
}