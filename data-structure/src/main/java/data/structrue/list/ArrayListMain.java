package data.structrue.list;

import data.structrue.list.domain.NameCard;
import data.structrue.list.domain.Point;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ArrayListMain {

  public static void main(String[] args) {
    Point[] point = new Point[10];
    ArrayList<Point> pointArrayList = new ArrayList<>(point);
    pointArrayList.insert(new Point(1,2));
    pointArrayList.insert(new Point(3,4));
    pointArrayList.insert(new Point(-1,-5));
    pointArrayList.insert(new Point(7,-2));

    Point first = pointArrayList.first();
    if(first != null){
      log.info("x좌표 {} , y좌료 {}",first.getX(),first.getY());
      Point next;
      while((next = pointArrayList.next()) != null){
        log.info("x좌표 {} , y좌료 {}",next.getX(),next.getY());
        if(next.getX() == 3 ){
          Point remove = pointArrayList.remove();
          log.info(remove.toString());
        }
      }
    }

    log.info("#####################");
    ArrayList<NameCard> nameCardArrayList = new ArrayList<>(new NameCard[10]);
    nameCardArrayList.insert(new NameCard("john","01011111111"));
    nameCardArrayList.insert(new NameCard("david","01022222222"));
    nameCardArrayList.insert(new NameCard("sam","01033333333"));
    nameCardArrayList.insert(new NameCard("jun","01044444444"));

    NameCard nameCardFirst = nameCardArrayList.first();
    if(nameCardFirst != null){
      log.info(nameCardFirst.toString());
      NameCard nextNameCard;
      while((nextNameCard = nameCardArrayList.next()) != null){
        if(nextNameCard.getName().equals("david")){
          nameCardArrayList.remove();
          continue;
        }
        log.info(nextNameCard.toString());
      }
    }
  }

}
