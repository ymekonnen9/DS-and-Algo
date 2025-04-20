package Stack;

// test commit
public class MatchParenthesis {
  private static boolean parenthesisMatches(String expression) {

    LinkedListStack<Character> buffer = new LinkedListStack<>();
    final String opening = "({[";
    final String closing = ")}]";
    for (char c : expression.toCharArray()) {
      if (opening.indexOf(c) != -1) {
        buffer.push(c);
      } else if (closing.indexOf(c) != -1) {
        if (buffer.isEmpty())
          return false;
        if (closing.indexOf(c) != opening.indexOf(buffer.pop()))
          return false;
      }
    }
    return buffer.isEmpty();
  }
}
