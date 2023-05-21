package Ejercicio4;
import java.util.Collection;

public class NodeList<T> {

  private int size;
  private Node<T> root;

  public NodeList(){
    root = null;
    size = 0;
  }

  public void setSize(int size){
    this.size = size;
  }
  
  public void setRoot(Node<T> root){
    this.root = root;
  }
  
  public int getSize(){
    return this.size;
  }
  
  public Node<T> getRoot(){
    return this.root;
  }
  
  public boolean contains(T data){
    Node<T> myNode = root;
    while(myNode != null){
      if(myNode.getData().equals(data)){
        return true;
      }
      myNode = myNode.getNextNode();
    }
    return false;
  }
  
  public boolean containsAll(Node<T> datas){
    while (datas != null) {
      if (!contains(datas.getData())) {
        return false;
      }
      datas = datas.getNextNode();
    }
    return true;
  }
  
  public boolean equals(NodeList<T> datas){
    if (this == datas) {
      return true;
    }
    if (!(datas instanceof NodeList)) {
      return false;
    }
    NodeList<T> otherList = datas;
    if (this.getSize() != otherList.getSize()) {
        return false;
    }
    for (int i = 0; i < size; i++) {
        Node<T> element1 = this.getRoot();
        Node<T> element2 = otherList.getRoot();
        if (!element1.equals(element2)) {
          return false;
        }
    }
    return true;
  }

  public T get(int index){

  }
  
  public int indexOf(T data){

  }

  public boolean isEmpty(){

  }

  public int lastindexOf(T data){

  }
}
