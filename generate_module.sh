#!/bin/bash

# Script to generate LeetCode challenge modules by ID
# Usage: ./generate_module.sh <leetcode_id> [class_name]
# Example: ./generate_module.sh 1234 Solution
# Example: ./generate_module.sh 1234 TwoSum

set -e

# Check if at least one argument is provided
if [ $# -lt 1 ]; then
    echo "Usage: $0 <leetcode_id> [class_name]"
    echo "Example: $0 1234 Solution"
    echo "Example: $0 1234 TwoSum"
    exit 1
fi

LEETCODE_ID=$1
CLASS_NAME=${2:-Solution}  # Default to "Solution" if not provided
MODULE_NAME="leetcode_${LEETCODE_ID}"

# Define paths
BASE_DIR="$(dirname "$0")"
MAIN_DIR="${BASE_DIR}/src/main/java/leetcode/challenge/${MODULE_NAME}"
TEST_DIR="${BASE_DIR}/src/test/java/leetcode/challenge/${MODULE_NAME}"

echo "Generating module for LeetCode problem ${LEETCODE_ID}..."
echo "Module name: ${MODULE_NAME}"
echo "Class name: ${CLASS_NAME}"

# Create directories
mkdir -p "${MAIN_DIR}"
mkdir -p "${TEST_DIR}"

# Generate main Solution class
SOLUTION_FILE="${MAIN_DIR}/${CLASS_NAME}.java"
cat > "${SOLUTION_FILE}" << EOF
package leetcode.challenge.${MODULE_NAME};

/**
 * LeetCode Problem ${LEETCODE_ID}
 * 
 * TODO: Add problem description and link
 * Link: https://leetcode.com/problems/
 * 
 * Time Complexity: O(?)
 * Space Complexity: O(?)
 */
class ${CLASS_NAME} {
    
    /**
     * TODO: Implement the solution method
     * 
     * @param param TODO: Add parameter description
     * @return TODO: Add return description
     */
    public int solutionMethod(int param) {
        // TODO: Implement the solution
        return 0;
    }
}
EOF

# Generate test class
TEST_FILE="${TEST_DIR}/${CLASS_NAME}Test.java"
cat > "${TEST_FILE}" << EOF
package leetcode.challenge.${MODULE_NAME};

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for LeetCode Problem ${LEETCODE_ID}
 */
class ${CLASS_NAME}Test {

    private ${CLASS_NAME} solution;

    @BeforeEach
    void setUp() {
        solution = new ${CLASS_NAME}();
    }

    @Test
    void testExample1() {
        // TODO: Add test case 1
        // Example:
        // int input = 1;
        // int expected = 1;
        // int actual = solution.solutionMethod(input);
        // assertEquals(expected, actual);
    }

    @Test
    void testExample2() {
        // TODO: Add test case 2
    }

    @Test
    void testEdgeCase() {
        // TODO: Add edge case tests
    }
}
EOF

echo "✅ Module generated successfully!"
echo "📁 Main class: ${SOLUTION_FILE}"
echo "📁 Test class: ${TEST_FILE}"
echo ""
echo "Next steps:"
echo "1. Update the problem description and link in ${CLASS_NAME}.java"
echo "2. Implement the solution method"
echo "3. Add test cases in ${CLASS_NAME}Test.java"
echo "4. Run tests with: ./gradlew test --tests '*${MODULE_NAME}*'"
