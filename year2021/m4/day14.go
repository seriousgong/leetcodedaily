package m4

type Trie struct {
	alphet []*Trie
	isStr  bool
}

/** Initialize your data structure here. */
func Constructor() Trie {
	return Trie{
		alphet: make([]*Trie, 26),
	}
}

/** Inserts a word into the trie. */
func (this *Trie) Insert(word string) {
	trie := this
	for _, char := range word {
		if trie.alphet[char-'a'] == nil {
			trie.alphet[char-'a'] = &Trie{
				alphet: make([]*Trie, 26),
			}
		}
		trie = trie.alphet[char-'a']
	}
	trie.isStr = true
}

/** Returns if the word is in the trie. */
func (this *Trie) Search(word string) bool {
	trie, exist := this.search(word)
	return exist && trie.isStr
}
func (this *Trie) search(prefix string) (*Trie, bool) {
	trie := this
	for _, char := range prefix {
		if trie.alphet[char-'a'] == nil {
			return nil, false
		}
		trie = trie.alphet[char-'a']
	}
	return trie, true
}

/** Returns if there is any word in the trie that starts with the given prefix. */
func (this *Trie) StartsWith(prefix string) bool {
	_, exist := this.search(prefix)
	return exist
}

/**
 * Your Trie object will be instantiated and called as such:
 * obj := Constructor();
 * obj.Insert(word);
 * param_2 := obj.Search(word);
 * param_3 := obj.StartsWith(prefix);
 */
