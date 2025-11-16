def all_subarrays(arr):
    """Return a list containing all subarrays of arr.

    Order matches the original Java implementation:
    For each start index i from 0..n-1, j goes from n down to i+1 and
    we take the slice arr[i:j].
    """
    result = []
    n = len(arr)
    for i in range(n):
        for j in range(n, i, -1):
            result.append(arr[i:j])
    return result


if __name__ == "__main__":
    arr = [1,2,2,3]
    subarrays = all_subarrays(arr)
    print(subarrays)
