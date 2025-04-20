package Stack;

public class HTMLmatchTag {

  private static boolean htmlTagMatch(String html) {
    int i = html.indexOf("<");
    LinkedListStack<String> buffer = new LinkedListStack<String>();
    while (i != -1) {
      int j = html.indexOf(">", i + 1);
      if (j == -1)
        return false;
      String tag = html.substring(i + 1, j);
      if (!tag.startsWith("/")) {
        buffer.push(tag);
      } else {
        if (buffer.isEmpty())
          return false;
        if (!tag.substring(1).equals(buffer.pop()))
          return false;
      }
      i = html.indexOf("<", j + 1);
    }
    return true;
  }

}
