package m6

import (
	"fmt"
	"testing"
)

func Test(t *testing.T) {
	fmt.Println(maxLength([]string{"zog", "nvwsuikgndmfexxgjtkb", "nxko"}))
	//fmt.Println(maxLength([]string{"jnfbyktlrqumowxd", "mvhgcpxnjzrdei"}))
	//fmt.Println(maxLength([]string{"un", "iq", "ue"}))
	//fmt.Println(maxLength([]string{"cha", "r", "act", "ers"}))
}
func maxLength(arr []string) int {

	ints := make([]int, 0)
	i := 0
root:
	for ; i < len(arr); i++ {
		val := 0
		for j := 0; j < len(arr[i]); j++ {
			lo := arr[i][j] - 'a'
			if val>>lo&1 != 0 {
				continue root
			}
			val |= 1 << lo
		}
		ints = append(ints, val)
		fmt.Printf("%b\n", val)
	}
	var dfs func(index, cnt int) int
	dfs = func(index, cnt int) int {
		if index == len(ints) {
			return count(cnt)
		}
		res := 0
		for j := index; j < len(ints); j++ {
			if cnt^ints[j] == cnt|ints[j] {
				if tmp := dfs(j+1, cnt|ints[j]); tmp > res {
					res = tmp
				}
			}
			if tmp := dfs(j+1, cnt); tmp > res {
				res = tmp
			}
		}
		return res
	}
	return dfs(0, 0)
}
func count(a int) int {
	res := 0
	for ; a > 0; a = a >> 1 {
		res += a & 1
	}
	return res
}
