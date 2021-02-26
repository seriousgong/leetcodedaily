package m2

import (
	"fmt"
)

func findNumOfValidWords(words []string, puzzles []string) (res []int) {
	root := NewTrieNode()
	for _, word := range words {
		arr := nodup([]byte(word))
		root.Insert(arr)
	}
	for _, puzzle := range puzzles {
		bys, first := nodup([]byte(puzzle)), int(puzzle[0]-'a')
		var traceback func(index int, node *TrieNode) int
		traceback = func(index int, node *TrieNode) (res int) {
			if node == nil {
				return
			}
			for ; index < len(bys) && bys[index] == 0; index++ {
			}
			if index == len(bys) {
				return node.Cnt
			}
			res += traceback(index+1, node.Child[index])
			if index != first {
				res += traceback(index+1, node)
			}
			return
		}
		res = append(res, traceback(0, root))
	}
	return res
}

func nodup(target []byte) []byte {
	alphet := make([]byte, 26)
	for _, b := range target {
		b -= 'a'
		alphet[b]++
	}
	return alphet
}

type TrieNode struct {
	Child [26]*TrieNode
	Cnt   int
}

func (t *TrieNode) String() {
	var loop func(node *TrieNode)
	loop = func(node *TrieNode) {
		if node != nil {
			for i, val := range node.Child {
				if val != nil {
					fmt.Print(i+'a', " ")
				}
			}
			fmt.Println()
			for _, child := range node.Child {
				loop(child)
			}
		}
	}
	loop(t)
}

func NewTrieNode() *TrieNode {
	return &TrieNode{
		Child: [26]*TrieNode{},
	}
}
func (t *TrieNode) Insert(arr []byte) {
	curr := t
	for b, val := range arr {
		if val != 0 {
			if curr.Child[b] == nil {
				curr.Child[b] = NewTrieNode()
			}
			curr = curr.Child[b]
		}
	}
	curr.Cnt++
}
