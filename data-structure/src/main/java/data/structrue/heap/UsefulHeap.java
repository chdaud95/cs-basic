package data.structrue.heap;

import lombok.extern.slf4j.Slf4j;

import java.util.Comparator;

@Slf4j
public class UsefulHeap<T> {
  Comparator<? super T> comp;
  int numOfData;
  T[] heapArr;

  public UsefulHeap(Comparator<? super T> comp, T[] heapArr) {
    this.comp = comp;
    this.numOfData = 0;
    this.heapArr = heapArr;
  }

  public boolean isEmpty(){
    return numOfData == 0 ;
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
      if(comp.compare(heapArr[getLeftChildIdx(idx)],heapArr[getRightChildIdx(idx)]) < 0){
        return getRightChildIdx(idx);
      }else{
        return getLeftChildIdx(idx);
      }
    }
  }

  public void insert(T data){
    int idx = numOfData + 1;

    while(idx != 1){
//      if(heapArr[getParentIdx(idx)].getPriority().getPri() > priority.getPri()){
      if(comp.compare(data,heapArr[getParentIdx(idx)]) > 0){
        heapArr[idx] = heapArr[getParentIdx(idx)];
        idx = getParentIdx(idx);
      }else break;
    }

    heapArr[idx] = data;
    numOfData++;
  }

  public T delete(){
    int parentIdx = 1;
    T deleteData = heapArr[parentIdx];
    T lastData = heapArr[numOfData];
    int childIdx;
    while((childIdx = getHighPriorityChildIdx(parentIdx)) != 0){
//      if(lastEle.getPriority().getPri() > childEle.getPriority().getPri()){
      if(comp.compare(lastData,heapArr[childIdx]) < 0){
        heapArr[parentIdx] = heapArr[childIdx];
        parentIdx = childIdx;
      }else break;
    }

    heapArr[parentIdx] = lastData;
    heapArr[numOfData] = null;
    numOfData--;
    return deleteData;
  }

  void preorderTraverse(int idx){
    if( idx > numOfData) return ;

    T data = heapArr[idx];
    log.info("data : {}",data);
    preorderTraverse(getLeftChildIdx(idx));
    preorderTraverse(getRightChildIdx(idx));
  }

}
