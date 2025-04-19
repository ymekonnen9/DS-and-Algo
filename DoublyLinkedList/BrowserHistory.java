package DoublyLinkedList;

class BrowserHistory {

  private static class Webpage {
    private String webpage;
    private Webpage next;
    private Webpage prev;

    public Webpage(String web, Webpage prev, Webpage next) {
      this.webpage = web;
      this.prev = prev;
      this.next = next;
    }

    public String getWebPage() {
      return this.webpage;
    }

    public Webpage getNext() {
      return this.next;
    }

    public Webpage getPrev() {
      return this.prev;
    }

    public void setNext(Webpage nex) {
      this.next = nex;
    }

    public void setPrev(Webpage prev) {
      this.prev = prev;
    }
  }

  private Webpage homepage;
  private Webpage lastpage;
  private Webpage currentpage;
  private int size;

  public BrowserHistory(String homepage) {
    this.homepage = new Webpage(homepage, null, null);
    this.homepage.setNext(lastpage);
    this.lastpage = this.homepage;
    this.currentpage = this.homepage;
  }

  public String getFirst() {
    return this.homepage.getWebPage();
  }

  public String getLast() {
    return lastpage.getWebPage();
  }

  public void visit(String url) {
    Webpage newOne = new Webpage(url, null, null);
    this.lastpage.setNext(newOne);
    newOne.setPrev(this.currentpage);
    this.lastpage = newOne;
    this.currentpage = newOne;
    size++;
  }

  public String back(int steps) {
    Webpage temp = this.currentpage;
    for (int i = 0; i < steps; i++) {
      temp = temp.getPrev();
    }
    this.currentpage = temp;
    return this.currentpage.getWebPage();
  }

  public String forward(int steps) {
    Webpage temp = this.currentpage;
    for (int i = 0; i < steps; i++) {
      temp = temp.getNext();
    }
    this.currentpage = temp;
    return temp.toString();
  }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */