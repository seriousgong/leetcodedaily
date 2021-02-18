package d12

//
//import (
//	"container/heap"
//	"sort"
//)
//
//func Day30(stones []int) int {
//	return lastStoneWeight(stones)
//}
//
//type hp struct {
//	arr []int
//}
//
////func (a *hp) () {
////
////}
//func lastStoneWeight(stones []int) int {
//	sort.Ints(stones)
//	for len(stones) > 1 {
//		l := len(stones)
//		max := stones[l-1]
//		max2nd := stones[l-2]
//		diff := max - max2nd
//		stones = stones[:l-2]
//		if diff != 0 {
//			stones = append(stones, diff)
//			heap.Push(stones, diff)
//		}
//	}
//	if len(stones) == 0 {
//		return 0
//	} else {
//		return stones[0]
//	}
//}
