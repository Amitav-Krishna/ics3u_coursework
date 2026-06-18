// So, at a high level, to evaluate expressions like 1 + 2 * 6 - 5, we want a tree.
// Each node is either a number or an operator.  This tree would be:
//         (-)
//        /   \
//      (+)   (5)
//     /   \
//    (*)  (1)
//   /   \
//  (2)  (6)
// Now, for our purposes, the operator nodes are the first class citizens.  Let's state our constraints to begin with:
// 1. single digit numbers only,
// 2. binary arithmetic operators (+, -, *, /) only, no support for unary operators (- as in negation, sqrt, etc.) or parantheses
// 3. evaluated left to right
// 4. There will be no whitespace in the expression
// 5. Answers that require decimals or decimals are undefined behaviour for the MVP, as we use integers
// 6. all given expressions are valid,
// 7. following from 4, we do not seek to implement error checking in the MVP, and any invalid expressions are undefined behaviour
//
// Another expression is 3 / 2 * 3.   This is ambiguous at first glance, but because we evaluate from left to right this becomes:
//       (*)
//      /   \
//    (/)   (3)
//   /   \
//  (3)  (2)
// So, in principle, we can have just a node class.  Each node instance has either no children (digits) or two children (binary operators).  
// Each node should be instantiated by either a digit or by an operator.  Then, you create the tree by nesting the nodes, i.e:
// node(*, node(/, node(3), node(2)), node(3))
// We probably don't need the digits to be nodes as well but it looks cool.  We can build the tree left to right.  So
// 3 ->  node(3)
// / -> node(/) with child being previous node
// 2 -
// Actually, this doesn't really make sense because one of the arguments to the operator will be after, which will make it weird.  Maybe we can have a set method for the value of nodes? 
// So instead, this would be:
// 3 -> node(3)
// / -> node(/, node(3), node(null))
// 2 -> node(null).set(2)
// * -> node(*, node(/), node(null))
// 3 -> node(null).set(3)
// Now, one important emergent constraint is that every node can have only *a single parent*.  
// So as part of the state, we can store a list of nodes that can have parents and a list of nodes needing children:
// 3 -> missing_children = [], parentless = [node(3)]
// / -> missing_children = [node(/, node(3), node(null)], parentless = [node(/)]
// 2 -> missing_children = [], parentless = [node(/, node(3), node(2))] 
// * -> missing_children = [node(*, node(/, node(3), node(2)), node(null))], parentless = [node(*, node(/, node(3), node(2)), node(null))]
// 3 -> missing_children = [], parentless = [node(*, node(/, node(3), node(2)), node(3))]
// Then we're good!  I think from here it's mostly implementation details.  In particular, how do we interact with unnamed classes?  
// I think we would do this via member variables.  
// Actually, Java doesn't have native optional arguments, so no broad node class will be used
// Also, I don't think our process works for 1 + 2 * 6 - 5:
// 1 -> missing_children = [], parentless = [Digit(1)]
// + -> missing_children = [Operator(+, Digit(1), ...
// Actually, now that we don't have a broad node class, this makes it harder to have a placeholder class.  So, we'll have to redesign so that there's a broader node class, and then more specific operator and digit classes.  Maybe we should take a more holistic view of assigning nodes.  So, let's take the string "1+2*6-5".  First, we search for multiplication signs, finding one at position 3, so we assign the digits on either side of it to be its children.  
// Then, we search for more multiplication signs, finding none more.  Then, we search for division signs, not finding any.  Then, we search for addition signs, finding one at position 1.  We assign the digit on the left to it, but then the digit to the right has been used.  So, we will have to keep a list of which positions have been used already, and then another list of which nodes contain those.


// Pseudocode:
// CLASS Node
//     PUBLIC PROCEDURE NEW()
//     END PROCEDURE
//     PUBLIC PROCEDURE EVAL()
//         RETURN 1
//     END PROCEDURE
// END CLASS
//
// CLASS Digit EXTENDS Node
//      PRIVATE INTEGER value; 
//      PUBLIC PROCEDURE NEW(integer value)
//          super()
//          SET this.value TO value
//      END PROCEDURE
//
//      PUBLIC PROCEDURE EVAL()
//          RETURN this.value
//      END PROCEDURE
//  END CLASS
//
// CLASS Operator EXTENDS Node
//      PRIVATE character operator; 
//      PRIVATE Node a;
//      PRIVATE Node b;
//      PUBLIC PROCEDURE NEW(character operator, Digit a, Digit b)
//          super()
//          SET this.operator TO operator
//          SET this.a TO a
//          SET this.b TO b
//      END PROCEDURE
//
//      PUBLIC PROCEDURE EVAL()
//          RETURN this.a.eval (this.operator) this.b.eval
//      END PROCEDURE
//  END CLASS
//          
// SET expression TO user_input
// SET position_to_node TO Map(integer, Node)
// SET children_buffer TO Map(integer, Node)
// FOR i FROM 0 TO expression.length
//     IF expression[i] == '*' or expression[i] == '/'
//         IF position_to_node contains i-1 or contains i+1
//             APPEND position_to_node.get(i-1 or i+1) TO children_buffer
//         END IF
//         ELSE IF position_to_node does not contain i-1 or does not contain i+1
//             APPEND expression[i-1] or expression[i+1] TO children_buffer
//         END ELSE IF
//         Operator x = new Operator(expression[i], children_buffer.get(i-1), children_buffer.get(i+1))
//         position_to_node.put(i-1, x)
//         position_to_node.put(i+1, x)
//         REPLACE ALL INSTANCES OF children_buffer[i-1] and children_buffer[i-1] IN position_to_node WITH x
//     END IF 
// END FOR
// FOR i FROM 0 TO expression.length
//     IF expression[i] == '+' or expression[i] == '-'
//     IF position_to_node contains i-1 or contains i+1
//         APPEND position_to_node.get(i-1 or i+1) TO children_buffer
//     END IF
//     ELSE IF position_to_node does not contain i-1 or does not contain i+1
//         APPEND expression[i-1] or expression[i+1] TO children_buffer
//     END ELSE IF
//     Operator x = new Operator(expression[i], children_buffer.get(i-1), children_buffer.get(i+1))
//     position_to_node.put(i-1, x)
//     position_to_node.put(i+1, x)
//     REPLACE ALL INSTANCES OF children_buffer[i-1] and children_buffer[i-1] IN position_to_node WITH x
//     END IF 
// END FOR
//      
// OUTPUT position_to_node.get(expression.length-1).eval()        
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String expression = scanner.nextLine();

		HashMap<Integer, Node> pos2node = new HashMap<>();
		HashMap<Integer, Node> temp_children = new HashMap<>();	

		for (int i = 0; i < expression.length(); i++) {
            // Loops through the string
			if (expression.charAt(i) == '*' || expression.charAt(i) == '/') { // We look just for these two because of order of operations.  BE*DM*AS
				if (pos2node.containsKey(i-1)) { // Checks if the digit to the left has already been used by another operator
					temp_children.put(i-1, pos2node.get(i-1)); // If the digit to the left has been used by another operator, we add that operator as a child
                    // For example, for 1 + 2 - 3
                    // We first create an operator with 1 and 2 as the children and with + as the operator.
                    // Then, we find -.  We discover that 2 is in pos2node, i.e. has been used by another operator, and fetch the value to discover 
                    // the specific node, i.e. 1+2.  So the - operator has 1+2 as one child and 3 as the other child
				} else {
					temp_children.put(i-1, new Digit(expression.charAt(i-1)-48)); // We subtract 48 because the ASCII code for zero is 48, so otherwise
                    // every digit would be 48 greater than they should be (known from experience)
				}

                // This block is the same as the above except for the right digit
				if (pos2node.containsKey(i+1)) {
					temp_children.put(i+1, pos2node.get(i+1));
				} else {
					temp_children.put(i+1, new Digit(expression.charAt(i+1)-48));
				}
                // End mirrored block

				Operator x = new Operator(expression.charAt(i), temp_children.get(i-1), temp_children.get(i+1)); // Creates the operator with the necessary children

                // Maps the digits on either side to the current operator 
				pos2node.put(i-1, x);
				pos2node.put(i+1, x);
                // End mapping block

                // Goes through every digit -> node mapping and replace any that are our left child with the current node
                for (Map.Entry<Integer, Node> entry: pos2node.entrySet()) {
                    // Checks if the current mapping's operator is our left cihld
                    if (entry.getValue() == temp_children.get(i-1)) {
                        pos2node.replace(entry.getKey(), x); // Replace the operator with the current node
                    }
                }

                // The same as the above block but for the right child
                for (Map.Entry<Integer, Node> entry: pos2node.entrySet()) {
                    if (entry.getValue() == temp_children.get(i+1)) {
                        pos2node.replace(entry.getKey(), x);
                    }
                }
                // End of mapping replacement block
                
			}
		}
        // Ends the block looking for division or multiplication signs

		for (int i = 0; i < expression.length(); i++) {
			if (expression.charAt(i) == '+' || expression.charAt(i) == '-') { // These are second because of BEDM*AS*
                // See explanations from above
				if (pos2node.containsKey(i-1)) {
					temp_children.put(i-1, pos2node.get(i-1));
				} else {
					temp_children.put(i-1, new Digit(expression.charAt(i-1)-48));
				}

				if (pos2node.containsKey(i+1)) {
					temp_children.put(i+1, pos2node.get(i+1));
				} else {
					temp_children.put(i+1, new Digit(expression.charAt(i+1)-48));
				}
				
				Operator x = new Operator(expression.charAt(i), temp_children.get(i-1), temp_children.get(i+1));
				pos2node.put(i-1, x);
				pos2node.put(i+1, x);
                for (Map.Entry<Integer, Node> entry: pos2node.entrySet()) {
                    if (entry.getValue() == temp_children.get(i-1)) {
                        pos2node.replace(entry.getKey(), x);
                    }
                }
                for (Map.Entry<Integer, Node> entry: pos2node.entrySet()) {
                    if (entry.getValue() == temp_children.get(i+1)) {
                        pos2node.replace(entry.getKey(), x);
                    }
                }
			}
		}
        System.out.println(pos2node.get(expression.length()-1).eval()); // Evaluates the parent node, triggering the recursive evaluation of every node
	}
}
			



class Node {
	public Node() {
	}
	public int eval() {
		return 1;
        // Necessary to avoid static typing errors, despite no naked nodes being used
	}
}

class Operator extends Node {
    // Child nodes, i.e. Operators or Digits
	private Node a;
	private Node b;

    // The actual operator 
	private char operator;

	public Operator(char operator, Node a, Node b) {
		super();
		this.a = a;
		this.b = b;
		this.operator = operator;
	}

    // This method is key to the recursion.  Oftentimes the operator itself will be a child of another operator.  Consider the expression 4/2+3.  The main class turns this into the following tree:
    //     (+)
    //    /   \
    //   (/)  (3)
    //  /   \
    // (4)  (2)
    // The main class calls eval on the root node
    //     (+) <- EVAL
    //    /   \
    //   (/)  (3)
    //  /   \
    // (4)  (2)
    // That node then calls eval on both of its child nodes
    //     (    +    )
    //    /           \
    //   (/)<- EVAL   (3) <- EVAL
    //  /   \
    // (4)  (2)
    // The 3 returns itself, but the divide node in turn calls eval on both of its child nodes
    //  
    //          (+3)
    //         /   
    //   (     /    )  
    //  /            \
    // (4)<- EVAL    (2)<- EVAL
    // Each of the digit nodes return themeselves:
    //    (+3)
    //   /
    // (4/2)
    // Finally, the division node returns the result of its operation:
    // (2+3)
    // which returns the final result: 5
	public int eval() {
		if (operator == '+') {
			return this.a.eval() + this.b.eval(); // Evaluates each of the child nodes and adds them together.  
		} else if (operator == '-') {
			return this.a.eval() - this.b.eval();
		} else if (operator == '*') {
			return this.a.eval() * this.b.eval();
		} else if (operator == '/') {
			return this.a.eval() / this.b.eval();
		} else {
			return -24134125; // Should never be reached on valid input, but used to avoid static typing errors
		} 
	}

}

class Digit extends Node{
	private int value;

	public Digit(int value) {
		super();
		this.value = value;
	}
	public int eval() {
		return this.value;
	}
}
