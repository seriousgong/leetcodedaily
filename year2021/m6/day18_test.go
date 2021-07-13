package m6

import (
	"fmt"
	"strconv"
	"testing"
)

func TestName(t *testing.T) {
	//fmt.Println(smallestGoodBase("13"))
	fmt.Println(smallestGoodBase("2251799813685247"))
}
func smallestGoodBase(n string) string {
	num, err := strconv.Atoi(n)
	if err != nil {
		fmt.Println(err)
		return ""
	}
	ans := num - 1
	for i := 64; i > 0; i-- {
		l := 2
		r := num
		for l < r {
			mid, tmp := (l+r)/2, 0
			for j := 0; j <= i; j++ {
				tmp = tmp*mid + 1
			}
			if tmp == num {
				if mid < ans {
					ans = mid
				}
				break
			} else if tmp < num {
				l = mid + 1
			} else {
				r = mid
			}

		}
	}
	return strconv.Itoa(ans)
}
