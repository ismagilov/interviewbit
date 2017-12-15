package trees;

/**
* https://www.interviewbit.com/problems/hotel-reviews/
*/
public class HotelReviews {
    public ArrayList<Integer> solve(String goodWords, ArrayList<String> reviews) {
        ArrayList<Integer> res = new ArrayList<>();
        HashMap<Integer, Integer> ranks = new HashMap<>();

        String[] gws = goodWords.split("_");

        Trie gwTrie = new Trie(gws);

        for (int i = 0; i < reviews.size(); i++) {
            String[] rws = reviews.get(i).split("_");

            int rank = 0;
            for (String rw : rws) {
                if (gwTrie.contains(rw))
                    rank++;
            }
            ranks.put(i, rank);

            //Not sure that built-in sorting is stable
            int j = res.size() - 1;
            while (j >= 0 && ranks.get(res.get(j)) < rank)
                j--;
            res.add(j + 1, i);
        }

        return res;
    }

    private static class Trie {
        private TrieNode root;

        private Trie(String[] words) {
            root = new TrieNode();

            for (String word : words) 
                addWord(word);
        }

        private void addWord(String word) {
            if (word == null || word.isEmpty()) return;

            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);

                TrieNode child = node.getChild(ch);
                if (child == null) {
                    child = new TrieNode(ch);
                    node.setChild(ch, child);
                }

                if (i == word.length() - 1)
                    child.setTerminated(true);

                node = child;
            }
        }

        private boolean contains(String word) {
            if (word == null || word.isEmpty()) return false;

            TrieNode cur = root;
            for (int i = 0; i < word.length(); i++) {
                cur = cur.getChild(word.charAt(i));

                if (cur == null)
                    return false;
            }

            return cur.isTerminated();
        }
    }

    private static class TrieNode {
        private TrieNode[] children = new TrieNode[26];
        private char character;
        private boolean isTerminated;

        private TrieNode() {
        }

        private TrieNode(char ch) {
            this();

            this.character = ch;
        }

        private TrieNode getChild(char ch) {
            return children[ch - 'a'];
        }

        private void setChild(char ch, TrieNode node) {
            children[ch - 'a'] = node;
        }

        private void setTerminated(boolean t) {
            this.isTerminated = t;
        }

        private boolean isTerminated() {
            return isTerminated;
        }
    }
}
