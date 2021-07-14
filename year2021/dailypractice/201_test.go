package dailypractice

import (
	"fmt"
	"testing"
)

func Test201(t *testing.T) {
	//fmt.Println(rangeBitwiseAnd(5, 7))
	fmt.Println(rangeBitwiseAnd(2, 2))
}
func rangeBitwiseAnd(left int, right int) int {
	res := 0
	for i := 0; i < 32 && left != 0; i++ {
		if left != 0 && left == right {
			res += left & 1 << i
		}
		left >>= 1
		right >>= 1
	}
	return res
}
