package m3

import "fmt"

type MyQueue struct {
	stack1 []int
	stack2 []int
	index1 int
	index2 int
}

/** Initialize your data structure here. */
func Constructor() MyQueue {
	return MyQueue{
		stack1: []int{},
		stack2: []int{},
		index1: 0,
		index2: 0,
	}
}

/** Push element x to the back of queue. */
func (this *MyQueue) Push(x int) {
	if this.index1 >= len(this.stack1) {
		this.stack1 = append(this.stack1, x)
		this.index1++
	} else {
		this.stack1[this.index1] = x
		this.index1++
	}
}

/** Removes the element from in front of queue and returns that element. */
func (this *MyQueue) Pop() int {
	if this.Empty() {
		return -1
	}
	var val int
	if this.index2 == 0 {
		val, this.stack1 = this.stack1[0], this.stack1[1:]
		this.index1--
	} else {
		this.index2--
		val = this.stack2[this.index2]
	}
	return val
}

/** Get the front element. */
func (this *MyQueue) Peek() int {
	fmt.Println(this.stack1, this.stack2)
	if this.index2 > 0 {
		return this.stack2[this.index2-1]
	} else if this.index1 > 0 {
		return this.stack1[0]
	}
	return -1
}

/** Returns whether the queue is empty. */
func (this *MyQueue) Empty() bool {
	return this.index1 == 0 && this.index2 == 0
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * obj := Constructor();
 * obj.Push(x);
 * param_2 := obj.Pop();
 * param_3 := obj.Peek();
 * param_4 := obj.Empty();
 */
