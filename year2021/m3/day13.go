package m3

/** Initialize your data structure here. */

type MyHashSet struct {
	bitmap []byte
}

func Constructor() MyHashSet {
	return MyHashSet{
		bitmap: make([]byte, 1000000/8+1),
	}
}

func (this *MyHashSet) Add(key int) {
	if this.bitmap[key/8]>>(key%8)%2 == 0 {
		this.bitmap[key/8] += 1 << (key % 8)
	}
}

func (this *MyHashSet) Remove(key int) {
	if this.bitmap[key/8]>>(key%8)%2 == 1 {
		this.bitmap[key/8] -= 1 << (key % 8)
	}
}

/** Returns true if this set contains the specified element */
func (this *MyHashSet) Contains(key int) bool {
	return this.bitmap[key/8]>>(key%8)%2 == 1
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * obj := Constructor();
 * obj.Add(key);
 * obj.Remove(key);
 * param_3 := obj.Contains(key);
 */
