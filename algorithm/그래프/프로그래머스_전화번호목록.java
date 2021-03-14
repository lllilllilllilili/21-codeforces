class Solution {
	public static int NUMS = 10;
	public static class TrieNode {
		TrieNode[] children = new TrieNode[NUMS];
		boolean isEndOfNum;
		public TrieNode() {
			isEndOfNum = false;
			for(int i=0; i<NUMS; ++i) {
				children[i] = null;
			}
		}
	}
	public static TrieNode root;
	public static void insert(String key) {
		int level;
		int length = key.length();
		int index;
		TrieNode pCrawl = root;
		for(level = 0; level<length; ++level) {
			index = key.charAt(level)-'0';
			if(pCrawl.children[index] == null)
				pCrawl.children[index] = new TrieNode();
			pCrawl = pCrawl.children[index];
		}
		pCrawl.isEndOfNum = true;
	}
	public static boolean Search(String key) {
		int level;
		int length = key.length();
		int index;
		TrieNode pCrawl = root;
		for(level = 0; level<length; ++level) {
			index = key.charAt(level)-'0';
			if(pCrawl.isEndOfNum)
				return false;
			pCrawl = pCrawl.children[index];
		}
		return true;
	}
	public boolean solution(String[] phone_book) {
		root = new TrieNode();
		for(int i=0; i<phone_book.length; i++) {
			insert(phone_book[i]);
		}
		boolean ans = true;
		for(int i=0; i<phone_book.length; i++) {
			if(!Search(phone_book[i])) {
				ans = false;
				break;
			}
		}
		return ans;
	}
}