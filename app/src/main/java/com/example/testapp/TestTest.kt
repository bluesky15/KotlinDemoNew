package com.example.testapp

import java.util.LinkedList
import java.util.Queue

fun main() {
//    println("make me happy".happy())
//    println(sum(3,4))
//    printSum(4,5, sum)
//    print(parenthesisChecker(""))
//    constructTree(arrayOf(1, 2, 3, 4, 5, 6, 6, 6, 6))?.let { print(it) }
//    println(largestSum(intArrayOf(-2,-3,-4,-5, 6,1,4, -1)))
}


//extension function
//why extension function needed.

fun String.happy(): String {
    val emoji = "\uD83D\uDE0A"
    return "$this $emoji"
}

// what is lambda expression in kotlin.
//Lambda expressions and anonymous functions are the function literals.
//Function literals are the functions which are not declared but passed immediately as an expression.

val sum = { x: Int, y: Int -> x + y }


//Higher order function
fun printSum(x: Int, y: Int, block: (Int, Int) -> Int) {
    println(block.invoke(x, y))
}


//parenthesis checker

fun parenthesisChecker(str: String): Boolean {
    val stack = ArrayDeque<Char>()
    str.forEach {
        if (it == '(' || it == '{' || it == '[') {
            stack.addFirst(it)
        }
        when (it) {
            ')' -> {
                if (stack.removeFirst() != '(') return false
            }

            '}' -> {
                if (stack.removeFirst() != '{') return false
            }

            ']' -> {
                if (stack.removeFirst() != '[') return false
            }
        }
    }
    return stack.isEmpty()

}

data class TreeNode(var data: Int, var left: TreeNode? = null, var right: TreeNode? = null)

fun constructTree(arr: Array<Int>): TreeNode? {
    if (arr == null || arr.isEmpty()) {
        return null
    }
    val root = TreeNode(data = arr[0])
    val q: Queue<TreeNode> = LinkedList()
    q.add(root)
    var i = 1
    while (i < arr.size) {
        val currNode = q.remove()
        if (i < arr.size) {
            currNode.left = TreeNode(data = arr[i++])
            q.add(currNode.left)
        }

        if (i < arr.size) {
            currNode.right = TreeNode(data = arr[i++])
            q.add(currNode.right)
        }
    }
    return root
}

fun printTree(tree:TreeNode){
    if (tree == null) {
        return
    }
    tree.left?.let { printTree(it) }
    print( "${tree.data} ")
    tree.right?.let { printTree(it) }
}


// largest sub array sum brute force algorithm
fun largestSum(arr:IntArray){
    var maxSum = Int.MIN_VALUE
    for(i in arr.indices){
        var currentSum = 0
        for(j in i until arr.size){
            currentSum+=arr[j]
            if(currentSum>maxSum){
                maxSum = currentSum
            }
        }
    }
    println("max sum =$maxSum")
}

// Kadane's algorithm very Important
fun largestSum1(arr: IntArray): Int {
    var currSum = 0
    var maxSum = Int.MIN_VALUE
    for (i in arr.indices) {
        currSum += arr[i]
        if (currSum > maxSum) {
            maxSum = currSum
        }
        if (currSum < 0) {
            currSum = 0
        }
    }
    return maxSum
}