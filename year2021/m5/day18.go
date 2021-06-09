package m5

func countTriplets(arr []int) int {
	prefix := make([]int, len(arr)+1)
	for i := 0; i < len(arr); i++ {
		prefix[i+1] = prefix[i] ^ arr[i]
	}
	res := 0
	for i := 0; i < len(arr)-1; i++ {
		sum := arr[i] ^ arr[i+1]
		for j := i + 2; j < len(arr); j++ {
			sum ^= arr[j]
			if sum == 0 {
				for n := i; n <= j; n++ {
					if prefix[n+1]^prefix[i+1] == prefix[j+1]^prefix[n] {
						res++
					}
				}
			}
		}
	}
	return res
}
