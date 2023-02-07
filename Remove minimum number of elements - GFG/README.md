# Remove minimum number of elements
## Easy
<div class="problems_problem_content__Xm_eO"><p><span style="font-size:20px">Given two arrays <strong>A[] </strong>and<strong> B[] </strong>consisting of <strong>N </strong>and<strong> M</strong> elements respectively. The task is to find minimum number of elements to remove from each array such that no common element exist in both the arrays.</span><br>
&nbsp;</p>

<p><span style="font-size:20px"><strong>Example 1:</strong></span></p>

<pre><span style="font-size:20px"><strong>Input :
</strong>A[] = { 2, 3, 4, 5, 8 }
B[] = { 1, 2, 3, 4}
<strong>Output :
</strong>3
<strong>Explanation:</strong>
We need to remove 2, 3 and 4 from any 
array.</span></pre>

<p>&nbsp;</p>

<p><span style="font-size:20px"><strong>Example 2:</strong></span></p>

<pre><span style="font-size:20px"><strong>Input :
</strong>A[] = { 4, 2, 4, 4}
B[] = { 4, 3 }
<strong>Output :
</strong>1
<strong>Explanation:</strong>
We need to remove 4 from B[]</span></pre>

<p>&nbsp;</p>

<p><span style="font-size:20px"><strong>Example 3:</strong></span></p>

<pre><span style="font-size:20px"><strong>Input:
</strong>A[] = { 1, 2, 3, 4 }
B[] = { 5, 6, 7 }
<strong>Output:
</strong>0
<strong>Explanation:</strong>
There is no common element in both.</span></pre>

<p>&nbsp;</p>

<p><span style="font-size:20px"><strong>Your Task:&nbsp;&nbsp;</strong><br>
You don't need to read input or print anything. Your task is to complete the function&nbsp;<strong>minRemove()</strong>&nbsp;which takes the array <strong>A[]</strong>, <strong>B[]</strong> and its size <strong>N</strong><strong>, M </strong>as inputs and returns the minimum number of elements to be deleted.</span></p>

<p>&nbsp;</p>

<p><span style="font-size:20px"><strong>Expected Time Complexity:</strong> O(N)<br>
<strong>Expected Auxiliary Space:</strong> O(N)</span></p>

<p>&nbsp;</p>

<p><span style="font-size:20px"><strong>Constraints:</strong><br>
1&lt;=N,M&lt;=10<sup>5</sup><br>
1&lt;=A[i],B[i]&lt;=10<sup>5</sup></span></p>

<p>&nbsp;</p>
</div>