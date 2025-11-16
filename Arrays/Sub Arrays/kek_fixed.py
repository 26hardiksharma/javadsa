
def countMajoritySubarrays(nums, target: int) -> int:
    # Check if target exists in the array
    if target not in nums:
        return 0
    
    # Generate all subarrays
    subarrays = []
    n = len(nums)
    for i in range(n):
        for j in range(n, i, -1):
            subarrays.append(nums[i:j])
    
    # Count subarrays where target is majority
    ret = 0
    for subarray in subarrays:
        half = len(subarray) / 2  # Use float division for strict majority
        count = 0
        for k in subarray:
            if k == target:
                count = count + 1
        if count >= half:  # Strict majority: more than half
            ret += 1
    
    return ret

arr = [1, 2,2,3]
print(f"Result for [1,1,1,1] with target=1: {countMajoritySubarrays(arr, 2)}")

# Let's also see all the subarrays
def show_subarrays(nums, target):
    subarrays = []
    n = len(nums)
    for i in range(n):
        for j in range(n, i, -1):
            subarrays.append(nums[i:j])
    
    print(f"\nAll subarrays of {nums}:")
    count_majority = 0
    for sub in subarrays:
        count = sum(1 for x in sub if x == target)
        is_majority = count > len(sub) / 2
        print(f"  {sub} -> count={count}, len={len(sub)}, majority={is_majority}")
        if is_majority:
            count_majority += 1
    print(f"Total with majority: {count_majority}")

show_subarrays([1, 2,2,3], 2)
