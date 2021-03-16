package m3

type MyHashMap struct {
	mp []interface{}
}

/** Initialize your data structure here. */
func Constructor() MyHashMap {
	return MyHashMap{
		mp: make([]interface{}, 0),
	}
}

/** value will always be non-negative. */
func (this *MyHashMap) Put(key int, value int) {
	if key >= len(this.mp) {
		this.mp = append(this.mp, make([]interface{}, key-len(this.mp)+1)...)
	}
	this.mp[key] = value
}

/** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
func (this *MyHashMap) Get(key int) int {
	if key > len(this.mp) || this.mp[key] == nil {
		return -1
	}
	return this.mp[key].(int)
}

/** Removes the mapping of the specified value key if this map contains a mapping for the key */
func (this *MyHashMap) Remove(key int) {
	this.mp[key] = nil
}
