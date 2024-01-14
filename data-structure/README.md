# 자료구조 (Data Structures)

자료구조에 대한 기본적인 개념과 관련된 주제들을 다루고 있습니다.<br>
자료구조에서는 데이터의 표현 및 데이터를 저장하는 방법을 설명합니다

## [시간복잡도 (Time Complexity)]
시간복잡도는 속도에 해당하는 알고지름의 수행시간 분석결과를 가르키며 연산 횟수를 샌 후 처리해야될 데이터 N 개에 대한 연산횟수의 함수를 구성합니다.

예시: 이진 탐색 (Binary Search)
이진 탐색은 정렬된 배열에서 중간 값과 비교하여 탐색 범위를 반으로 줄여가며 원하는 원소를 찾는 알고리즘입니다. 
```java
public int binarySearch(int[] arr,int target){
    int start = 0;
    int end = arr.length - 1;
    int mid;
    
    while(start <= end){
      mid = (start+end)/2;
      if(arr[mid] == target){ //핵심 비교연산
        return mid;
      }else if( arr[mid] > target){
        end = mid - 1;
      }else{
        start = mid + 1;
      }
    }
    return -1;
  }
```
모든 알고리즘에는 최선의 경우와 최악의 경우가 있는데 시간복잡도를 계산하기 위해선 최악의 경우를 선택해서 연산횟수의 함수를 구성합니다.

이진 탐색에서 핵심은 동등비교를 하는 비교연산에 있습니다. 이진 탐색 최악의 경우에 대한 시간복잡도를 구해보겠습니다.

처음에 데이터 개수가 N개 일때 1회 비교연산 진행<br>
데이터 수를 반으로 줄여 N/2일때  1회 비교연산 진행<br>
데이터 수를 반으로 줄여 N/4일때  1회 비교연산 진행 <br>
...<br>
데이터 수를 반으로 줄여 1일때 1회 비교연산 진행<br>

N이 1이 될때까지 나눈 횟수 K , 나눈 값이 1일때 비교연산 진행 1 이므로 시간 복잡도는 $T(n) = K+1$ 이며, K를 구해야 합니다.

$n*(1/2)^K = 1$    &rarr;  $n = 2^K$    &rarr;  $log_{2}n = log_{2}2^K$    &rarr; $log_{2}n = k$ 이므로 
이진탐색의 시간 복잡도는 $T(n) = log_{2}n + 1$ 입니다.

## [빅오표기법 (Big O Notation)]
빅오표기법은 알고리즘의 성능을 표현하는 수학적인 표기법으로, 최악의 경우에 얼마나 빠르게 실행되는지를 나타냅니다.<br>
시간복잡도가 $T(n) = n^2+2n+1$일 경우에 최고차항이 차지하는 연산 횟수 비율을 테이블로 정리했습니다.

|   n     |        $n^2$    |   $2n$   |     $T(n)$   | $n^2$의 비율|
|--------:|----------------:|---------:|-------------:|------------:|
|       10|              100|        20|           120|       83.33%|
|      100|           10,000|       200|        10,200|       98.04%|
|    1,000|        1,000,000|     2,000|     1,002,000|       99.80%|
|   10,000|       10,000,000|    20,000|   100,020,000|       99.98%|
|  100,000|   10,000,000,000|   200,000|10,000,200,000|       99.99%|

n이 증가함에 따라서 2n+1이 미치는 영향은 미미해지므로 다음과 같이 시간복잡도를 간략화 할 수 있으며 $T(n) = n^2$ 이를 빅-오 표기법으로 표현하면 다음과 같습니다 $O(n^2)$.
빅-오 표기들의 성능(수행시간, 연산횟수)의 대소를 정리하면 다음과 같습니다.<br>

<p align="center">
  <img src="https://github.com/chdaud95/cs-basic/assets/155866807/26713b8d-4df0-4742-b54d-c2b36efe47cd"/>
  <br>
  $O(l)$ $<$ $O(log_{2}n)$ $<$ $O(n)$ $<$ $O(nlog_{2}n)$ $<$ $O(n^2)$ $<$ $O(n^3)$ $<$ $O(2^n)$
</p>

## [재귀함수 (Recursion)]

재귀함수는 함수가 자기 자신을 호출하는 특별한 형태의 함수입니다.
재귀함수 호출을 쉽게 이해하기 위해선 함수가 호출되면 해당 함수의 복사본을 만들어서 실행하는 구조이다.

![image](https://github.com/chdaud95/cs-basic/assets/155866807/f6eeb139-ec76-4f0f-859e-5e91aedce480)
------
예시 : 하노이 타워<br>
<p align="center">
  <img src="https://github.com/chdaud95/cs-basic/assets/155866807/89015eba-0005-4f44-a837-ab0a8b1abb8b"/>
</p>
하노이 타워는 원판의 갯수가 증가해도 일련의 과정을 반복하기 때문에대표적인 재귀함수 사용 예시입니다. 
원판의 갯수 N개이며 출발지 A 도착지 C 경유지 B로 예시를 들겠습니다.

1. 제일 큰 원반을 제외한 n-1개의 원반을 A에서 B로 이동
2. 제일 큰 원반을 A에서 C로 이동
3. 제일 큰 원반을 제외한 n-1개의 원반을 B에서 C로 이동

위의 규칙처럼 원반 5개 옮기는 과정은 4개,3개 옮길때 과정이 포함되어있는 과정이므로 일련의 과정을 반복합니다. 단지 출발지와 경유지 도착지만 변경될 뿐입니다.
```java
void hanoiTowerMove(int num,String a,String b,String c){
    if(num == 1){
      log.info("{}번 {} -> {} 이동",num,a,c); //2번과정
    }else{
      hanoiTowerMove(num - 1 , a,c,b);  // 1번 과정 
      log.info("{}번 {} -> {} 이동",num,a,c);
      hanoiTowerMove(num - 1 , b,a,c); //3번 과정
    }
  }
```
## [연결 리스트 (Linked List)]
ADT(Abstract Data Type)는 C언어나 JAVA에서 표현하는 자료형이 아닌 순수한 기능을 나열한 것입니다.
어떠한 자료구조이건 간에 자료구조의 구현 과 구현된 자료구조의 활용을 완전히 구분되도록 ADT를 정의해야 합니다.
리스트에서 순수한 기능은 4가지 입니다.
1. 입력
2. 첫번째 데이터 조회
3. 다음 데이터 조회
4. 삭제
<br>
조회에서 2,3 번으로 분리한 이유는 모든데이터 순회 후 인덱스를 초기화 하기 위해서 기능을 분리하였습니다.

### 배열을 이용한 리스트
```java
@Slf4j
public class ArrayList<T> {

  public T[] array;
  int numOfData;
  int curPosition;

  public ArrayList(T[] array) {
    this.array = array;
    this.numOfData = 0;
    this.curPosition = -1;
  }

  public void insert(T data){
    if(numOfData >= array.length) {
      log.error("데이터를 더이상 저장할 수 없습니다.");
      return;
    }
    array[numOfData++] = data;
  }

  public T first(){
    if(numOfData == 0) {
      log.error("저장된 데이터가 없습니다.");
      return null;
    }
    curPosition = 0;
    return array[curPosition];
  }

  public T next(){
    if(curPosition >= array.length - 1 ){
      log.error("다음 데이터가 없습니다.");
      return null;
    }
    return array[++curPosition];
  }

  public T remove(){
    int pos = curPosition;
    int num = numOfData;
    T removeData = array[curPosition];

    for( int i = pos ; i< num - 1 ; i++){
      array[i] = array[i+1];

      //마지막 데이터를 땡겨왔으니 메모리에서 제거해줘야한다.
      if( i == num - 2 ){
        array[i+1] = null;
      }
    }
    numOfData--;
    curPosition--;
    return removeData;
  }
}
```

### 노드를 이용한 연결 리스트
배열을 이용한 리스트에 단점은 배열의 길이가 가변적이지 않아 배열의 길이 이상으로 데이터를 추가할 수 없습니다. 이러한 단점을 해결하기 위해 메모리에 노드를 할당하여 각각의 노드를 연결한 형태의 리스트를 구현할 수 있습니다.
필자가 구현할 연결 리스트는 헤드가 존재하며, 해당 헤드는 더미 노드를 가지고 있는 형태이다.
```java
public class LinkedList<T> {
  Node<T> head;
  Node<T> cur;
  Node<T> before;
  int numOfData;

  Comparator<T> comp;

  public LinkedList() {
    this.head = new Node<>();
    this.cur = null;
    this.before = null;
    numOfData = 0;
  }

  void insert(T data){
    Node<T> newNode = new Node<>(data);

    //정렬문
    Node<T> point = head;

    while(point.getNext() != null && comp.compare(point.getNext().getData(),newNode.getData()) != 0){
      point = point.getNext();
    }

    newNode.setNext(point.getNext());
    point.setNext(newNode);
    numOfData++;
  }

  T first(){
    if(head.getNext() == null){
      log.error("저장된 데이터가 없습니다.");
      return null;
    }
    before = head;
    cur = head.getNext();
    return cur.getData();
  }

  T next(){
    if(cur == null || cur.getNext() == null){
      log.error("저장된 데이터가 없습니다.");
      return null;
    }
    before = cur;
    cur = cur.getNext();
    return cur.getData();
  }
  T remove(){
    T data = cur.getData();
    before.setNext(cur.getNext());
    cur = before;
    return data;
  }

  void setSortRule(Comparator<T> comp){
    this.comp = comp;
  }
}
```




