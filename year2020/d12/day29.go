package d12

func minPatches(nums []int, n int) int {

	/*二进制解释
			01   10   100   1000
	         1    2	   4      8


		   111  110 101 100 011 010 001
	      加上1000能表示多少位
		  111  110 101 100 011 010 001 （1-7）
		     1000
		  111  110 101 100 011 010 001 + 1000 （8-15）
	*/

	result := 0
	for i, i1 := 1, 0; i <= n; i++ {
		if nums[i1] <= i {
			/*1 到 i1-1 都能被覆盖 ，加上i后能覆盖到 1 i+i1-1*/
			i += nums[i1]
		} else {
			/*当前nums[i1]>i 不能覆盖i所有加上 i 这样能覆盖到 1 2*i 的范围*/
			i *= 2
			result++
		}
	}
	return result
}
