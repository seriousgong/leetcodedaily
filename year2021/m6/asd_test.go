package m6

import (
	"encoding/hex"
	"fmt"
	"testing"
)

func Test1(t *testing.T) {
	bs := []byte{96, 63, 184, 242, 1, 16, 4, 0, 135, 119, 3, 39, 139, 198, 205, 176, 131, 37, 114, 64}
	fmt.Println(hex.EncodeToString(bs))

	a := 1
	b := 2
	if a > b && a != 1 || b == 2 {
		fmt.Println("a")
	} else {
		fmt.Println("b")
	}
}
