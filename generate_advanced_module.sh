#!/bin/bash

# Advanced LeetCode Module Generator
# Generates modules with more comprehensive templates and options
# Usage: ./generate_advanced_module.sh <leetcode_id> [options]
# Options:
#   -c, --class <name>     Custom class name (default: Solution)
#   -t, --type <type>      Problem type (array, tree, graph, dp, etc.)
#   -d, --difficulty <level> Difficulty level (easy, medium, hard)
#   -h, --help             Show help message

set -e

# Default values
LEETCODE_ID=""
CLASS_NAME="Solution"
PROBLEM_TYPE=""
DIFFICULTY=""
SHOW_HELP=false

# Parse command line arguments
while [[ $# -gt 0 ]]; do
    case $1 in
        -c|--class)
            CLASS_NAME="$2"
            shift 2
            ;;
        -t|--type)
            PROBLEM_TYPE="$2"
            shift 2
            ;;
        -d|--difficulty)
            DIFFICULTY="$2"
            shift 2
            ;;
        -h|--help)
            SHOW_HELP=true
            shift
            ;;
        -*)
            echo "Unknown option $1"
            exit 1
            ;;
        *)
            if [ -z "$LEETCODE_ID" ]; then
                LEETCODE_ID="$1"
            else
                echo "Multiple IDs provided. Using first one: $LEETCODE_ID"
            fi
            shift
            ;;
    esac
done

# Show help
if [ "$SHOW_HELP" = true ] || [ -z "$LEETCODE_ID" ]; then
    cat << EOF
Advanced LeetCode Module Generator

Usage: $0 <leetcode_id> [options]

Arguments:
  leetcode_id           The LeetCode problem ID (required)

Options:
  -c, --class <name>    Custom class name (default: Solution)
  -t, --type <type>     Problem type (array, tree, graph, dp, string, etc.)
  -d, --difficulty <level> Difficulty level (easy, medium, hard)
  -h, --help            Show this help message

Examples:
  $0 1234                                    # Basic module
  $0 1234 -c TwoSum                         # Custom class name
  $0 1234 -t array -d easy                  # With type and difficulty
  $0 1234 -c BinaryTreeInorder -t tree -d medium

Problem Types:
  - array, string, tree, graph, dp, greedy
  - math, backtracking, sorting, searching
  - linkedlist, stack, queue, heap, trie
EOF
    exit 0
fi

MODULE_NAME="leetcode_${LEETCODE_ID}"

# Define paths
BASE_DIR="$(dirname "$0")"
MAIN_DIR="${BASE_DIR}/src/main/java/leetcode/challenge/${MODULE_NAME}"
TEST_DIR="${BASE_DIR}/src/test/java/leetcode/challenge/${MODULE_NAME}"

echo "🚀 Generating advanced module for LeetCode problem ${LEETCODE_ID}..."
echo "📋 Module name: ${MODULE_NAME}"
echo "🏷️  Class name: ${CLASS_NAME}"
[ -n "$PROBLEM_TYPE" ] && echo "📂 Problem type: ${PROBLEM_TYPE}"
[ -n "$DIFFICULTY" ] && echo "⭐ Difficulty: ${DIFFICULTY}"

# Create directories
mkdir -p "${MAIN_DIR}"
mkdir -p "${TEST_DIR}"

# Generate difficulty badge
DIFFICULTY_BADGE=""
case "$DIFFICULTY" in
    "easy")
        DIFFICULTY_BADGE="🟢 Easy"
        ;;
    "medium")
        DIFFICULTY_BADGE="🟡 Medium"
        ;;
    "hard")
        DIFFICULTY_BADGE="🔴 Hard"
        ;;
    *)
        DIFFICULTY_BADGE="Difficulty: TBD"
        ;;
esac

# Generate type-specific method template
METHOD_TEMPLATE=""
IMPORT_STATEMENTS=""
case "$PROBLEM_TYPE" in
    "array")
        METHOD_TEMPLATE="public int[] solve(int[] nums) {
        // TODO: Implement array solution
        return new int[0];
    }"
        ;;
    "tree")
        IMPORT_STATEMENTS="
// import leetcode.challenge.shared.TreeNode;"
        METHOD_TEMPLATE="public TreeNode solve(TreeNode root) {
        // TODO: Implement tree solution
        return null;
    }"
        ;;
    "string")
        METHOD_TEMPLATE="public String solve(String s) {
        // TODO: Implement string solution
        return \"\";
    }"
        ;;
    "linkedlist")
        IMPORT_STATEMENTS="
// import leetcode.challenge.shared.ListNode;"
        METHOD_TEMPLATE="public ListNode solve(ListNode head) {
        // TODO: Implement linked list solution
        return null;
    }"
        ;;
    "graph")
        METHOD_TEMPLATE="public boolean solve(int[][] graph) {
        // TODO: Implement graph solution
        return false;
    }"
        ;;
    *)
        METHOD_TEMPLATE="public int solve(int param) {
        // TODO: Implement the solution
        return 0;
    }"
        ;;
esac

# Generate main Solution class
SOLUTION_FILE="${MAIN_DIR}/${CLASS_NAME}.java"
cat > "${SOLUTION_FILE}" << EOF
package leetcode.challenge.${MODULE_NAME};
${IMPORT_STATEMENTS}

/**
 * LeetCode Problem ${LEETCODE_ID}
 * 
 * ${DIFFICULTY_BADGE}
 * $([ -n "$PROBLEM_TYPE" ] && echo "Type: ${PROBLEM_TYPE}")
 * 
 * Problem Description:
 * TODO: Add problem description here
 * 
 * Link: https://leetcode.com/problems/
 * 
 * Approach:
 * TODO: Describe your approach
 * 
 * Time Complexity: O(?)
 * Space Complexity: O(?)
 * 
 * @author Generated on $(date +"%Y-%m-%d")
 */
class ${CLASS_NAME} {
    
    /**
     * Main solution method
     * 
     * @param param TODO: Add parameter description
     * @return TODO: Add return description
     */
    ${METHOD_TEMPLATE}
}
EOF

# Generate comprehensive test class
TEST_FILE="${TEST_DIR}/${CLASS_NAME}Test.java"
cat > "${TEST_FILE}" << EOF
package leetcode.challenge.${MODULE_NAME};

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Comprehensive test suite for LeetCode Problem ${LEETCODE_ID}
 * 
 * Test Categories:
 * - Basic functionality tests
 * - Edge cases
 * - Performance tests (if applicable)
 * 
 * @author Generated on $(date +"%Y-%m-%d")
 */
@DisplayName("LeetCode ${LEETCODE_ID}: ${CLASS_NAME}")
class ${CLASS_NAME}Test {

    private ${CLASS_NAME} solution;

    @BeforeEach
    void setUp() {
        solution = new ${CLASS_NAME}();
    }

    @Nested
    @DisplayName("Basic Test Cases")
    class BasicTests {

        @Test
        @DisplayName("Example 1 from problem description")
        void testExample1() {
            // TODO: Add test case from problem example 1
            // Given:
            // When:
            // Then:
            
            // Uncomment and modify:
            // assertEquals(expected, solution.solve(input));
        }

        @Test
        @DisplayName("Example 2 from problem description")
        void testExample2() {
            // TODO: Add test case from problem example 2
        }

        @Test
        @DisplayName("Example 3 from problem description")
        void testExample3() {
            // TODO: Add test case from problem example 3 (if exists)
        }
    }

    @Nested
    @DisplayName("Edge Cases")
    class EdgeCaseTests {

        @Test
        @DisplayName("Empty input")
        void testEmptyInput() {
            // TODO: Test with empty/minimal input
        }

        @Test
        @DisplayName("Single element")
        void testSingleElement() {
            // TODO: Test with single element input
        }

        @Test
        @DisplayName("Maximum constraints")
        void testMaximumConstraints() {
            // TODO: Test with maximum allowed input size
        }

        @Test
        @DisplayName("Minimum constraints")
        void testMinimumConstraints() {
            // TODO: Test with minimum allowed input values
        }
    }

    @Nested
    @DisplayName("Special Cases")
    class SpecialCaseTests {

        @Test
        @DisplayName("All same elements")
        void testAllSameElements() {
            // TODO: Test with all identical elements (if applicable)
        }

        @Test
        @DisplayName("Sorted input")
        void testSortedInput() {
            // TODO: Test with pre-sorted input (if applicable)
        }

        @Test
        @DisplayName("Reverse sorted input")
        void testReverseSortedInput() {
            // TODO: Test with reverse sorted input (if applicable)
        }
    }
}
EOF

# Generate README for the module
README_FILE="${MAIN_DIR}/README.md"
cat > "${README_FILE}" << EOF
# LeetCode Problem ${LEETCODE_ID}

${DIFFICULTY_BADGE}$([ -n "$PROBLEM_TYPE" ] && echo " | Type: ${PROBLEM_TYPE}")

## Problem Description

TODO: Add the problem description here

## Approach

TODO: Describe your solution approach

### Algorithm Steps

1. TODO: Step 1
2. TODO: Step 2
3. TODO: Step 3

## Complexity Analysis

- **Time Complexity:** O(?)
- **Space Complexity:** O(?)

## Test Cases

### Example 1
\`\`\`
Input: 
Output: 
Explanation: 
\`\`\`

### Example 2
\`\`\`
Input: 
Output: 
Explanation: 
\`\`\`

## Notes

- TODO: Add any additional notes or observations
- TODO: Alternative approaches
- TODO: Follow-up questions

## Links

- [Problem Link](https://leetcode.com/problems/)
- [Discussion](https://leetcode.com/problems//discuss/)

---
*Generated on $(date +"%Y-%m-%d %H:%M:%S")*
EOF

echo ""
echo "✅ Advanced module generated successfully!"
echo ""
echo "📁 Files created:"
echo "   📄 Main class: ${SOLUTION_FILE}"
echo "   🧪 Test class: ${TEST_FILE}"
echo "   📖 README: ${README_FILE}"
echo ""
echo "🚀 Next steps:"
echo "   1. 📝 Update the problem description and link"
echo "   2. 💡 Implement the solution method"
echo "   3. 🧪 Add comprehensive test cases"
echo "   4. ▶️  Run tests: ./gradlew test --tests '*${MODULE_NAME}*'"
echo "   5. 📊 Verify time/space complexity"
echo ""
echo "💡 Tip: Use './gradlew test --tests '*${MODULE_NAME}*' --info' for detailed test output"
