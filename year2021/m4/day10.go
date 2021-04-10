package m4

func isUgly(n int) bool {

	tmp := n
	for ; tmp%2 == 0; tmp /= 2 {
	}
	for ; tmp%3 == 0; tmp /= 3 {
	}
	for ; tmp%5 == 0; tmp /= 5 {
	}
	return tmp == 1 && n != 1
}
