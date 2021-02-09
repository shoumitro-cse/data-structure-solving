# Permutation of numbers such that sum of two consecutive numbers is a perfect square

# python Permutation.py

# Function to check wheter we can add number v with the path in the position pos. 
def issafe(v, graph, path, pos): 
	if (graph[path[pos - 1]][v] == 0): 
		return False
	for i in range(pos): 
		if (path[i] == v): 
			return False
	return True

# Function to form a path based on the graph. 
def formpath(graph, path, pos): 

	n = len(graph) - 1
	if (pos == n + 1): 
		return True

	for v in range(1, n + 1): 
		if issafe(v, graph, path, pos): 
			path[pos] = v 
			# Recurs for next element of the path. 
			if (formpath(graph, path, pos + 1) == True): 
				return True
			# If adding v does not give a solution then remove it from path 
			path[pos] = -1
			
	# if any vertex cannot be added with the 
	# formed path then return false and backtracks. 
	return False

# Function to find out sum-square series. 
def hampath(n):
	# base case: if n = 1 there is no solution 
	if n == 1: 
		return 'No Solution'
	# Make an array of perfect squares from 1 to (2 * n-1) 
	l = list() 
	for i in range(1, int((2 * n-1) ** 0.5) + 1): 
		l.append(i**2) 
	# Form the graph where sum of two adjacent vertices is a perfect square 
	graph = [[0 for i in range(n + 1)] for j in range(n + 1)] 
	for i in range(1, n + 1): 
		for ele in l: 
			if ((ele-i) > 0 and (ele-i) <= n and (2 * i != ele)): 
				graph[i][ele-i] = 1
				graph[ele-i][i] = 1

	for j in range(1, n + 1): 
		path = [-1 for k in range(n + 1)] 
		path[1] = j 
		# If starting from j we can form any path then we will return the path 
		if formpath(graph, path, 2) == True: 
			return path[1:] 
	# If no path can be formed at all return no solution. 
	return 'No Solution'

	
# Driver Function 
print(17, '->', hampath(17)) 
print(20, '->', hampath(20)) 
print(25, '->', hampath(25)) 



# Permutation of numbers such that sum of two consecutive numbers is a perfect square


# Prerequisite: Hamiltonian Cycle

# Given an integer n(>=2), find a permutation of numbers from 1 to n such that the sum of two 
# consecutive numbers of that permutation is a perfect square. If that kind of permutation 
# is not possible to print “No Solution”.

# Examples:

# Input : 17
# Output : [16, 9, 7, 2, 14, 11, 5, 4, 12, 13, 3, 6, 10, 15, 1, 8, 17]
# Explanation : 16+9 = 25 = 5*5, 9+7 = 16 = 4*4, 7+2 = 9 = 3*3 and so on.

# Input: 20
# Output: No Solution

# Input : 25
# Output : [2, 23, 13, 12, 24, 25, 11, 14, 22, 3, 1, 8,  
#           17, 19, 6, 10, 15, 21, 4, 5, 20, 16, 9, 7, 18]