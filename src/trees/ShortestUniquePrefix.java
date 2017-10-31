package trees;

/**
* https://www.interviewbit.com/problems/shortest-unique-prefix/
*/
public class ShortestUniquePrefix {
	public ArrayList<String> prefix(ArrayList<String> words) {
	    Trie trie = new Trie(words);

        ArrayList<String> prfxs = new ArrayList<>();	    
	    for (String word : words)
	        prfxs.add(trie.getUniquePrefix(word));
	        
	    return prfxs;
	}
	
	private final class Trie {
	    private TrieNode root = new TrieNode();
	    
	    private Trie(List<String> words) {
	        for (String w : words)
	            root.addWord(w);
	    }
	    
	    private String getUniquePrefix(String word) {
	        StringBuilder sb = new StringBuilder();
	        
	        boolean found = false;
	        TrieNode it = root;
	        char[] chs = word.toCharArray();
	        for (int i = 0; i < chs.length; i++) {
	            it = it.getChild(chs[i]);
	            if (null == it)
	                return null;
	                
	            sb.append(chs[i]);    
	            if (it.getWordsCounter() == 1) {
	                found = true;
	                break;
	            }
	        }

	        return (found) ? sb.toString() : null;
	    }
	}
	
	private final class TrieNode {
	    private HashMap<Character, TrieNode> children = new HashMap<>();
	    private boolean isTerminated = false;
	    
	    private Character character;
	    private int wordsCounter = 0;
	    
	    private TrieNode() {
	    }
	    
	    private TrieNode(Character c) {
	        this();
	        
	        this.character = c;
	    }
	    
	    private void addWord(String word) {
	        if (word == null || word.isEmpty())
	            return;
	            
	        Character c = word.charAt(0);
	        TrieNode child;
	        if (!children.containsKey(c)) {
	            child = new TrieNode();
	            children.put(c, child);
	        } else {
	            child = children.get(c);
	        }
        
            child.wordsCounter++;
            
	        if (word.length() > 1) {
	            child.setTerminated(false);
	            child.addWord(word.substring(1));
	        } else {
	            child.setTerminated(true);
	        }
	    }
	    
	    private TrieNode getChild(Character c) {
	        return children.get(c);
	    }
	    
	    private int getWordsCounter() {
	        return wordsCounter; 
	    }
	    
	    private void setTerminated(boolean t) {
	        isTerminated = t;
	    }
	    
	    private boolean isTerminated() {
	        return isTerminated;
	    }
	}
}
