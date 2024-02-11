package data.structrue.heap;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SimpleHeap<T> {
  private int numOfData;
  private HeapElem<T>[] heapArr;

  public SimpleHeap( HeapElem<T>[] heapArr) {
    this.numOfData = 0;
    this.heapArr = heapArr;
  }
  public int getParentIdx(int idx){
    return idx/2;
  }
  public int getLeftChildIdx(int idx){
    return idx*2;
  }
  public int getRightChildIdx(int idx){
    return getLeftChildIdx(idx)+1;
  }

  public int getHighPriorityChildIdx(int idx){

    if(getLeftChildIdx(idx) > numOfData){
      return 0;
    }else if(getLeftChildIdx(idx) == numOfData){
      return getLeftChildIdx(idx);
    }else{
      int leftChildIdx = getLeftChildIdx(idx);
      int rightChildIdx = getRightChildIdx(idx);
      Priority leftPri = heapArr[leftChildIdx].getPriority();
      Priority rightPri = heapArr[rightChildIdx].getPriority();
      if(rightPri.getPri() < leftPri.getPri()){
        return getRightChildIdx(idx);
      }else{
        return getLeftChildIdx(idx);
      }
    }
  }
  public boolean isEmpty(){
    return numOfData == 0 ;
  }
  public void insert(T data,Priority priority){
    HeapElem<T> insertHeap = new HeapElem<>(data,priority);
    int idx = numOfData + 1;

    while(idx != 1){
      if(heapArr[getParentIdx(idx)].getPriority().getPri() > priority.getPri()){
        heapArr[idx] = heapArr[getParentIdx(idx)];
        idx = getParentIdx(idx);
      }else break;
    }

    heapArr[idx] = insertHeap;
    numOfData++;
  }

  public T delete(){
    int idx = 1;
    HeapElem<T> removeEle = heapArr[idx];
    HeapElem<T> lastEle = heapArr[numOfData];

    int childIdx;
    while((childIdx = getHighPriorityChildIdx(idx)) != 0){
      HeapElem<T> childEle = heapArr[childIdx];
      if(lastEle.getPriority().getPri() > childEle.getPriority().getPri()){
        heapArr[idx] = childEle;
        idx = childIdx;
      }else break;
    }

    heapArr[idx] = lastEle;
    numOfData--;
    return removeEle.getData();
  }

  void preorderTraverse(int idx){
    if( idx > numOfData) return ;

    HeapElem<T> element = heapArr[idx];
    log.info("data : {}",element.getData());
    preorderTraverse(getLeftChildIdx(idx));
    preorderTraverse(getRightChildIdx(idx));
  }
}
