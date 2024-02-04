package data.structrue.queue;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HamburgerSim {

  private static final int CUS_COME_TERM = 15;
  private static final int CHE_BUR = 0;
  private static final int BUL_BUR = 1;
  private static final int DUB_BUR = 2;
  private static final int CHE_TERM = 12;
  private static final int BUL_TERM = 15;
  private static final int DUB_TERM = 24;
  public static void main(String[] args) {

    int makeProc = 0;
    int cheOrder = 0,bulOrder = 0,dubOrder = 0;

    Integer[] arr = new Integer[30];
    ArrayQueue<Integer> queue = new ArrayQueue<>(arr);

    for(int sec = 0 ; sec < 3600 ; sec++){
      if(sec % CUS_COME_TERM == 0){
        double random = Math.floor(Math.random() * 3);
        switch ((int) (random % 3)) {
          case CHE_BUR -> {
            queue.enqueue(CHE_TERM);
            cheOrder++;
          }
          case BUL_BUR -> {
            queue.enqueue(BUL_TERM);
            bulOrder++;
          }
          case DUB_BUR -> {
            queue.enqueue(DUB_TERM);
            dubOrder++;
          }
        }
      }

      if(makeProc <= 0 && !queue.isEmpty()){
        makeProc = queue.dequeue();
      }

      makeProc--;
    }

    log.info("Simulation Report!" );
    log.info("- Cheese burger : {}" ,cheOrder);
    log.info("- Bulgogi burger : {}" ,bulOrder);
    log.info("- Double burger : {}" ,dubOrder);
    log.info("- Waiting room size : {}" ,arr.length);

  }
}
